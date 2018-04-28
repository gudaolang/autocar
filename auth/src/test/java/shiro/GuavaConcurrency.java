package shiro;

import com.google.common.util.concurrent.Monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lee
 * @Date:2018/4/17
 */

public class GuavaConcurrency {

    private String value;

    //1,synchronized:唤醒所有的锁

    public synchronized String getValue() throws InterruptedException {
        while (value == null) {
            wait();
        }
        String result = value;
        value = null;
        notifyAll();
        return result;
    }

    public synchronized void setValue(String value) throws InterruptedException {

        while (value != null) {
            wait();
        }
        this.value = value;
        notifyAll();
    }


    //2,ReentrantLock:唤醒特定的锁
    ReentrantLock lock = new ReentrantLock();
    Condition absentCondition = lock.newCondition(); // readLock
    Condition existCondition = lock.newCondition();  // writeLock

    public String getLockValue() {

        lock.lock();
        try {
            while (value == null){
                existCondition.await();
            }
            String result = value;
            value = null;
            existCondition.signal();
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void setLockValue(String value) {

        lock.lock();

        try {
            while (value != null){
                absentCondition.await();
            }

            this.value = value;

            absentCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    //Guava:monitor 类
    Monitor monitor = new Monitor();

    Monitor.Guard absentGuard = new Monitor.Guard(monitor){

        @Override
        public boolean isSatisfied() {

            return value == null;
        }
    };
    Monitor.Guard existGuard = new Monitor.Guard(monitor){

        @Override
        public boolean isSatisfied() {

            return value != null;
        }
    };


    public String getGuardValue() throws InterruptedException {

        monitor.enterWhen(existGuard);

        try {
            String result = value;

            value = null;

            return result;

        } finally {

            monitor.leave();
        }


    }

    public void setGuardValue(String value) throws InterruptedException {

        monitor.enterWhen(absentGuard);

        try {
            this.value = value;

        } finally {

            monitor.leave();
        }

    }



}
