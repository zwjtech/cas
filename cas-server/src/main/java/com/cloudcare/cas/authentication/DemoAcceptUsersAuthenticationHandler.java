package com.cloudcare.cas.authentication;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.springframework.stereotype.Component;

import javax.security.auth.login.FailedLoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;

@Component("demoAcceptUsersAuthenticationHandler")
public class DemoAcceptUsersAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler{
    private static final String BaseUrl="http://cas.client.com";
    private static final String Port=":8118";
    private static final String PathName="/resources/request/UserDemo@checkUser";

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential) throws GeneralSecurityException, PreventedException {
        final String username=getPrincipalNameTransformer().transform(credential.getUsername());
        final String password=credential.getPassword();

        if (username==null || username.isEmpty())
            throw new FailedLoginException("No user can be accepted because none is defined");

        try {
            URL restServiceURL=new URL(BaseUrl+Port+PathName);

            HttpURLConnection con=(HttpURLConnection) restServiceURL.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");

            String input="{\"content\":{\"username\":"+username+",\"password\":"+password+"}}";

            OutputStream output=con.getOutputStream();
            output.write(input.getBytes());
            output.flush();

            System.out.println(con.getResponseCode());
            if(con.getResponseCode()!=200){
                throw new FailedLoginException();
            }

            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String line;
            String result = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println(result);

            if(!result.contains("\"content\":true")){
                throw new FailedLoginException("Invalid username and password!");
            }

            con.disconnect();

            return createHandlerResult(credential, this.principalFactory.createPrincipal(username), null);
        } catch (MalformedURLException e) {
            e.printStackTrace();

            throw new FailedLoginException();
        } catch (IOException e) {
            e.printStackTrace();

            throw new FailedLoginException();
        }
    }
}