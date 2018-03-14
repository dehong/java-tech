package com.dehong.java.spi;

/**
 * Created by dehong on 2018-03-14.
 */
public class ServiceA implements IService
{

    @Override
    public String hello(String name)
    {
        return "ServiceA : hello " + name;
    }
}
