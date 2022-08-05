package com.zenika.javabasics.services;

public class OtherTestService implements TestService {
    @Override
    public boolean isValid(int i) {
        return i % 3 == 2;
    }
}
