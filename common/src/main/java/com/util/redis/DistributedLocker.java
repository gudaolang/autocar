package com.util.redis;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

public interface DistributedLocker {

    /**
     * 加锁
     * @param lockKey 锁名称
     * @return 锁对象
     */
    RLock lock(String lockKey);

    /**
     * 带超时的锁
     * @param lockKey 锁名称
     * @param timeout 超时时间 单位：秒
     * @return 锁对象
     */
    RLock lock(String lockKey, int timeout);

    /**
     * 带超时的锁
     * @param lockKey 锁名称
     * @param unit 时间单位
     * @param timeout 超时时间
     * @return 锁对象
     */
    RLock lock(String lockKey, TimeUnit unit, int timeout);

    /**
     * 尝试获取锁
     * @param lockKey 锁名称
     * @param unit 时间单位
     * @param waitTime 最多等待时间
     * @param timeout 上锁后自动释放锁时间
     * @return 布尔型
     */
    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int timeout);

    /**
     * 释放锁
     * @param lockKey 锁名称
     */
    void unlock(String lockKey);

    /**
     * 释放锁
     * @param lock 锁对象
     */
    void unlock(RLock lock);

}
