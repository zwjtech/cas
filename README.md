
# CAS部署手册
CAS （ Central Authentication Service ） 是 Yale 大学发起的一个企业级的、开源的项目，旨在为 Web 应用系统提供一种可靠的单点登录解决方法（属于 Web SSO ）。

## 部署CAS Server
Jetty+CAS+keytool配置CAS Server
1. 生成证书（[参考链接](http://blog.csdn.net/dotuian/article/details/9311109)）
 + 切换到\jdk1.8.0_77\bin下，用JDK自带的keytool生成证书： ` keytool    -genkeypair   -alias    "cjTomcat"   -keyalg    "RSA"    -keystore     "F:\keystore\tomcat.keystore"`
 + 导出证书：`keytool -export -file F:\keystore\guyan.crt -alias cjTomcat -keystore F:\keystore\tomcat.keystore`
 + 将证书导入到客户端的JDK中：`keytool -import -keystore "F:\JavaDev\jdk1.8.0_77\jre\lib\security\cacerts" -file F:\keystore\guyan.crt -alias cjTomcat`

>*友情提示：为防止记错，期间出现的所有密码可设为同一密码*
> [参数的详细说明](http://www.kafeitu.me/sso/2010/11/05/sso-cas-full-course.html )

2. 安装Jetty（[参考链接](http://blog.csdn.net/dotuian/article/details/9311109)）
 + 官网上下载Jetty后，解压即可。进入安装目录，运行`java -jar start.jar`，即可启动Jetty Server。
打开浏览器，访问localhost:8080，出现欢迎页面，安装成功。
 + 配置Jetty的SSL：`java -jar start.jar --add-to-start=ssl,http,https,deploy`。
然后，拷贝前面生成的keystore（就是tomcat.keystore）到{jetty_home}的etc/目录下；
demo中使用的是Jetty9，所以配置方式参考（http://blog.csdn.net/tomato__/article/details/37656091 ）。在jetty的start.ini文件中配置KeyStorePath和密码。

3. 部署cas server到jetty
 + 按照官网的做法，demo采用WAR overplay安装（[官网地址](https://github.com/apereo/cas-overlay-template/tree/4.2)）
默认选择的master分支，为了稳定版本，选择4.2分支，可以直接下载压缩包。
 + 解压后，导入到Intellij中，
>PS：xml配置文件中出现标红，显示错误信息是URI not registered.（[解决参考](https://www.jetbrains.com/help/idea/2017.1/schemas-and-dtds.html)）
解决方法：点击File>Setting>Schemas and DTDs，把标红的URI都添加到ignore list中。

 + 修改配置文件src\main\webapp\WEB-INF\spring-configuration\propertyFileConfigurer.xml：
```java
 <util:properties id="casProperties" location="file:F:\WebServer\cas\cas.properties" />
```
将文件路径指向自己保存的位置。
 + 运行mvn clean,然后mvc install，成功打包项目
 + 把打包后的war包，放到Jetty_Home/webapp下
 + 重启服务器，再次访问cas server：https://localhost:8443 。可以看到身份认证页面，初始用户名和密码是casuser,Mellon。

4.  调用应用提供的restful API，实现cas server端身份认证
 + 查看server的几个配置文件deployerConfigContext.xml，cas.properties，cas-servlet.xml，会找到：
```xml
<bean id="primaryAuthenticationHandler" class="com.cloudcare.cas.authentication.DemoAcceptUsersAuthenticationHandler"/>
```
可通过手动方式注册我们的身份认证bean。可参考源代码中使用handler，继承其父类后，编写自己的bean。

## 部署CAS Client（[参考](http://blog.csdn.net/my580236/article/details/39253863)）
1）给应用添加过滤器：由于demo应用没有web.xml文件，使用Jetty Server添加过滤器的方式。
>*各类监听器、过滤器说明（http://blog.csdn.net/yuwenruli/article/details/6612010）*

```java
webServer.addEventListener(new SingleSignOutHttpSessionListener());
```
```java
HashMap<String,String> map3=new HashMap<String,String>();
        String casServerUrl = Configs.getString("cas.casServerUrl");
        map3.put("casServerUrlPrefix", casServerUrl);
        webServer.addFilter(new SingleSignOutFilter(),"",map3, EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC));HashMap<String,String> map3=new HashMap<String,String>();
```
```java
HashMap<String,String> map1=new HashMap<String,String>();
map1.put("casServerLoginUrl", casServerUrl +"/login");      //cas server login路径
String serverName = Configs.getString("cas.serverName");
map1.put("serverName", serverName);                   //应用所在的server name
map1.put("useSession","true");                       //whether to store the Assertion in session or not
map1.put("redirectAfterValidation","true");          //redirect to the same url after ticket valication
webServer.addFilter(new AuthenticationFilter(),"/html/*",map1, EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC));

```
```java
HashMap<String,String> map2=new HashMap<String,String>();
map2.put("casServerUrlPrefix", casServerUrl);      //the start of the cas server url
map2.put("serverName", serverName);    //the start of the url that this application is runnin on
webServer.addFilter(new Cas20ProxyReceivingTicketValidationFilter(),"/html/*",map2, EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC));
```
2）在web应用中添加对cas client的依赖，以便调用cas client的过滤认证：
```xml
<dependency>
            <groupId>org.jasig.cas.client</groupId>
            <artifactId>cas-client-core</artifactId>
            <version>3.4.1</version>
 </dependency>
```