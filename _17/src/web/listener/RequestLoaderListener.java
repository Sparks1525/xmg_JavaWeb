package web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLoaderListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("RequestLoaderListener requestInitialized");

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
