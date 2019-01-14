package web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLoaderListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionLoaderListener sessionCreated");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
