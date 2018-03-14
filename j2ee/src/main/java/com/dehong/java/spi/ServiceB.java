package com.dehong.java.spi;

/**
 * Created by dehong on 2018-03-14.
 */
public class ServiceB implements IService
{
    @Override
    public String hello(String name)
    {
        return "ServiceB : hello " + name;
    }
}
