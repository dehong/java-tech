package com.dehong.java.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by dehong on 2018-03-14.
 */
public class MainApp
{
    private static void demo1()
    {
        ServiceLoader<IService> serviceLoader = ServiceLoader.load(IService.class);
        for (IService service : serviceLoader)
        {
            String res = service.hello("zhangsan");
            System.out.println(res);
        }
    }

    private static void demo2()
    {
        IService service = ServiceLoaderUtils.getService(IService.class);
        String res = service.hello("world");
        System.out.println(res);
    }


    public static void main(String[] args)
    {
        demo1();
        demo2(); //设置jvm options: -Dcom.dehong.java.spi.IService=com.dehong.java.spi.ServiceB


        /*输出：
            ServiceA : hello zhangsan
            ServiceB : hello zhangsan
            ServiceB : hello world
        */
    }
}
