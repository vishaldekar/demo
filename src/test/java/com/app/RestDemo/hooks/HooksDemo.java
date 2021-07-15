package com.app.RestDemo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class HooksDemo {

    //@Before
    public void before(){
        System.out.println("Before each scenario ");
    }

    //@After
    public void after(){
        System.out.println("after each scenario ");
    }

    //@BeforeStep
    public void beforeStep(){
        System.out.println("before each step ");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("after each step ");
    }

}
