package web.listener.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        System.out.println("ContextAttributeListener attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        System.out.println("ContextAttributeListener attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        System.out.println("ContextAttributeListener attributeReplaced");
    }
}
