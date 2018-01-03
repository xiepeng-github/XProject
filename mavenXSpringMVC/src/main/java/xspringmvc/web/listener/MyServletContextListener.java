package xspringmvc.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
  @WebListener等价于在web.xml中配置listener
  <!-- 注册针对ServletContext对象进行监听的监听器 -->
  <listener>
      <description>ServletContextListener监听器</description>
      <!--实现了ServletContextListener接口的监听器类 -->
      <listener-class>xspringmvc.web.listener.MyServletContextListener</listener-class>
  </listener>
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("XProject ServletContext对象创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("XProject ServletContext对象销毁");
    }
}
