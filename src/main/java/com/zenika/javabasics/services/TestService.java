package com.zenika.javabasics.services;

public interface TestService {
    boolean isValid(int i);

    class DefaultTestService implements TestService {

        @Override
        public boolean isValid(int i) {
            return i % 2 == 0;
        }
    }

}
