package com.cloudcare.web.server;

import com.cloudcare.common.lang.Configs;
import org.eclipse.jetty.servlet.FilterHolder;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;

/**
 * Created by ASUS on 2017/5/11.
 */
public class StartWorkerServer {
    public static void main(String[] args) throws Exception{
        JettyServer webServer = new JettyServer(Configs.getString("worker.server.host"),
                Configs.getInt("worker.server.port"), Configs.getString("worker.server.webContext"), "/");
        //WorkerServer server= new WorkerServer(Configs.getString("worker.name"), webServer);
        webServer.addEventListener(new SingleSignOutHttpSessionListener());

        HashMap<String,String> map3=new HashMap<String,String>();
        String casServerUrl = Configs.getString("cas.casServerUrl");
        map3.put("casServerUrlPrefix", casServerUrl);
        webServer.addFilter(new SingleSignOutFilter(),"",map3, EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC));

        //拦截访问本应用的转至cas server的login页面
        HashMap<String,String> map1=new HashMap<String,String>();
        map1.put("casServerLoginUrl", casServerUrl +"/login");
        String serverName = Configs.getString("cas.serverName");
        map1.put("serverName", serverName);
        map1.put("useSession","true");
        map1.put("redirectAfterValidation","true");
        webServer.addFilter(new AuthenticationFilter(),"/html/*",map1, EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC));

        HashMap<String,String> map2=new HashMap<String,String>();
        map2.put("casServerUrlPrefix", casServerUrl);
        map2.put("serverName", serverName);
        webServer.addFilter(new Cas20ProxyReceivingTicketValidationFilter(),"/html/*",map2, EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC));

        StandaloneServer server= new StandaloneServer( webServer);
        server.start();
    }
}
