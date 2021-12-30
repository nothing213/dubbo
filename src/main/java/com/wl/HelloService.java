package com.wl;

import com.wl.bean.Person;

public interface HelloService {
    public String sayHelloGeneric(Person person, String message);
}

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHelloGeneric(Person person, String message) throws Exception {
        String result = "hello[" + person + "],message=" + message;
        return result;

        /////
    }
}