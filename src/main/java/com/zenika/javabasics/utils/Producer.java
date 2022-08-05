package com.zenika.javabasics.utils;

import com.zenika.javabasics.services.OtherTestService;
import com.zenika.javabasics.services.TestService;

public class Producer {

    public static TestService testService() {
        return new TestService.DefaultTestService();
    }

    public static TestService testService2() {
        return new OtherTestService();
    }

}
