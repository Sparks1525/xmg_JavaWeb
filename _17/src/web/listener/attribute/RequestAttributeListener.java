package web.listener.attribute;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("RequestAttributeListener attributeAdded");
        System.out.println("RequestAttribute Added name=" + srae.getName() + ",value=" + srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("RequestAttributeListener attributeRemoved");
        System.out.println("RequestAttribute Removed name=" + srae.getName() + ",value=" + srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("RequestAttributeListener attributeReplaced");
        System.out.println("RequestAttribute Replaced name=" + srae.getName() + ",value=" + srae.getValue());
    }
}
