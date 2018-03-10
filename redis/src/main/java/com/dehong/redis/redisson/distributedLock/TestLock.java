package com.dehong.redis.redisson.distributedLock;

import java.io.IOException;

/**
 * Created by dehong on 2018-03-11.
 */
public class TestLock
{
    public static void main(String[] args) throws IOException
    {
        String key = "test";
        for (int i = 1; i <= 10; i++)
        {
            new Thread(() -> {
                try
                {
                    RedissonLockUtil.lock(key);
                    System.out.println(Thread.currentThread().getName() + ":获取锁！");
                    Thread.sleep(2000);
                    RedissonLockUtil.unlock(key);
                    System.out.println(Thread.currentThread().getName() + ":释放锁！");
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }, "Thread_"+String.valueOf(i)).start();
        }


        System.in.read();
    }

}
