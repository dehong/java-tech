package com.dehong.java.spi;

/**
 * Created by dehong on 2018-03-14.
 */
public class ServiceA implements IService
{

    public static final String SERVICENAME = "serviceA";

    @Override
    public String hello(String name)
    {
        return "ServiceA : hello " + name;
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
