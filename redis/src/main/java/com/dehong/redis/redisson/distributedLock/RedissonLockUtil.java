package com.dehong.redis.redisson.distributedLock;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.core.RLock;

/**
 * @author created by dehong
 * @date 2018年3月4日 下午4:30:11
 * Redisson分布式锁 工具类
 */
public class RedissonLockUtil
{

    private static Redisson redisson = RedissonManager.getRedisson();

    private static final String LOCK_FLAG = "redissonlock_";

    /**
     * 根据key进行上锁操作，redissonLock 阻塞的，采用的机制发布/订阅
     *
     * @param key
     */
    public static void lock(String key)
    {
        String lockKey = LOCK_FLAG + key;
        RLock lock = redisson.getLock(lockKey);
        //lock提供带timeout参数，timeout结束强制解锁，防止死锁 ：1分钟
        lock.lock(1, TimeUnit.MINUTES);
    }

    /**
     * 根据key对进行解锁操作
     *
     * @param key
     */
    public static void unlock(String key)
    {
        String lockKey = LOCK_FLAG + key;
        RLock lock = redisson.getLock(lockKey);
        //如果锁被当前线程持有，则释放
        //不加isHeldByCurrentThread()条件的话，如果在执行的task的时间超过timeout，此时如果unlock时，其实redisson 已经主动unlock ，就会出现IllegalMonitorStateException 异常
        if (lock.isHeldByCurrentThread())
        {
            lock.unlock();
        }
    }


}