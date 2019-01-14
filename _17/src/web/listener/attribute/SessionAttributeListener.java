package web.listener.attribute;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("SessionAttributeListener attributeAdded");
        System.out.println("SessionAttribute Added name=" + se.getName() + ",value=" + se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("SessionAttributeListener attributeRemoved");
        System.out.println("SessionAttribute Removed name=" + se.getName() + ",value=" + se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("SessionAttributeListener attributeReplaced");
        System.out.println("SessionAttribute Replaced name=" + se.getName() + ",value=" + se.getValue());
    }
}
