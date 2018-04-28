package shiro;

import com.google.common.eventbus.EventBus;
import org.omg.CORBA.Object;

/**
 * @author lee
 * @Date:2018/4/17
 */

public class GuavaEventbus {

    private static EventBus eventBus = new EventBus();


    public static EventBus getInstance() {
        return eventBus;
    }

    public static EventBus getInstance(String name) {
        return new EventBus(name);
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }

}
