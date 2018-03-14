package com.dehong.java.spi;

/**
 * Created by dehong on 2018-03-14.
 */
public class ServiceB implements IService
{
    public static final String SERVICENAME = "serviceB";

    @Override
    public String hello(String name)
    {
        return "ServiceB : hello " + name;
    }

    @Override
    public IService getService(String name)
    {
        if (SERVICENAME.equals(name))
        {
            return this;
        }
        return null;
    }

    public String name()
    {
        return SERVICENAME;
    }
}
