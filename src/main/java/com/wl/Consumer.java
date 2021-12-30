package com.wl
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void testGeneric() {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(new ApplicationConfig("java-front-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        reference.setInterface("com.java.front.dubbo.demo.provider.HelloService");
        reference.setGeneric(true);
        GenericService genericService = reference.get();
        Map<String, Object> person = new HashMap<String, Object>();
        person.put("name", "张三」");
        String message = "你好";
        Object result = genericService.$invoke("sayHelloGeneric", new String[] { "com.java.front.dubbo.demo.provider.model.Person", "java.lang.String" }, new Object[] { person, message });
        System.out.println(result);
    }
}