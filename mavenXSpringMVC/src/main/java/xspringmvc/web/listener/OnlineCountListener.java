package xspringmvc.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineCountListener implements HttpSessionListener {

    public int count=0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
        System.out.println("sessionCreated 当前登录人数：" + count);
        httpSessionEvent.getSession().getServletContext().setAttribute("Count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
        System.out.println("sessionDestroyed 当前登录人数：" + count);
        httpSessionEvent.getSession().getServletContext().setAttribute("Count", count);
    }
}
