package shiro;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author lee
 * @Date:2018/4/17
 */

public class GuavaEventRegister {

    public static void main(String[] args) {

        EventBus bussCenter = GuavaEventbus.getInstance();

        DataRegister r1 = new DataRegister();
        DatasRegister r2 = new DatasRegister();

        System.out.println("===register===");
        bussCenter.register(r1);
        bussCenter.register(r2);

        bussCenter.post("abc");
        bussCenter.post(1000);

        System.out.println("===unregister===");
        bussCenter.unregister(r2);
        bussCenter.post("abc");
        bussCenter.post(1000);

    }
}


class DataRegister {

    @Subscribe
    public void subscribe2(String str) {
        System.out.println("d1 ==> reg1 " + str + " ========");
    }

    public void subscribe3(String str) {
        System.out.println("d1 ==> reg1 " + str + " dddddd");
    }

    @Subscribe
    public void subscribe(String str) {
        System.out.println("d1 ==> reg1 " + str);
    }
}

class DatasRegister {

    @Subscribe
    public void subscribe(Integer i) {
        System.out.println("d2 ==> reg2 " + i);
    }
}