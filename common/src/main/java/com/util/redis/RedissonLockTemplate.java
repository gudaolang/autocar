package com.util.redis;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

public class RedissonLockTemplate {

    private DistributedLocker distributedLocker;

    /**
     * 加锁 此方法不开放，加锁必须有过期时间
     * @param lockKey 锁名称
     * @return 锁对象
     */
    /*public RLock lock(String lockKey){
        return distributedLocker.lock(lockKey);
    }*/

    /**
     * 带超时的锁
     * @param lockKey 锁名称
     * @param timeout 超时时间 单位：秒
     */
    public RLock lock(String lockKey, int timeout) {
        return distributedLocker.lock(lockKey, timeout);
    }

    /**
     * 带超时的锁
     * @param lockKey 锁名称
     * @param unit 时间单位
     * @param timeout 超时时间
     */
    public RLock lock(String lockKey, TimeUnit unit , int timeout) {
        return distributedLocker.lock(lockKey, unit, timeout);
    }

    /**
     * 尝试获取锁
     * @param lockKey 锁名称
     * @param timeout 上锁后自动释放锁时间 单位：秒
     * @return
     */
    public boolean tryLock(String lockKey, int timeout) {
        return distributedLocker.tryLock(lockKey, TimeUnit.SECONDS, 0, timeout);
    }

    /**
     * 尝试获取锁
     * @param lockKey 锁名称
     * @param waitTime 最多等待时间 单位：秒
     * @param timeout 上锁后自动释放锁时间 单位：秒
     * @return
     */
    public boolean tryLock(String lockKey, int waitTime, int timeout) {
        return distributedLocker.tryLock(lockKey, TimeUnit.SECONDS, waitTime, timeout);
    }

    /**
     * 尝试获取锁
     * @param lockKey 锁名称
     * @param unit 时间单位
     * @param waitTime 最多等待时间
     * @param timeout 上锁后自动释放锁时间
     * @return
     */
    public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int timeout) {
        return distributedLocker.tryLock(lockKey, unit, waitTime, timeout);
    }

    /**
     * 释放锁
     * @param lockKey 锁名称
     */
    public void unlock(String lockKey){
        distributedLocker.unlock(lockKey);
    }

    /**
     * 释放锁
     * @param rLock 锁对象
     */
    public void unlock(RLock rLock){
        distributedLocker.unlock(rLock);
    }

    public void setDistributedLocker(DistributedLocker distributedLocker) {
        this.distributedLocker = distributedLocker;
    }

}
