package com.dehong.java.spi;

import java.util.ServiceLoader;

public class ServiceFactory
{

    //读取配置获取所有实现
    private static ServiceLoader<IService> services = ServiceLoader.load(IService.class);

    //根据名字选取对应实现
    public static IService getService(Class clazz)
    {

        for (IService service : services)
        {
            if(clazz.getName().equals(service.getClass().getName())){
                return service;
            }
        }

        return null;
    }

}