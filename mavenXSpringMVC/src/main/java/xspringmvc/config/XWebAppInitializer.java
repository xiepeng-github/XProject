package xspringmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/*
对应web.xml的配置
 */
public class XWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    /*
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {XRootConfig.class};
    }

    /*
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <!--配置dispatcher.xml作为mvc的配置文件-->
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {XWebConfig.class};
    }

    /*
        <servlet-mapping>
            <servlet-name>dispatcher</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>
     */
    protected String[] getServletMappings() {
        return new String[] {"/"};//将DispatcherServlet映射到"/"
    }
}
