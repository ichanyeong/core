package hello.core;

import org.springframework.aot.generate.GeneratedClasses;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args)throws ClassNotFoundException  {
        Class<?> clazz = Class.forName("hello.core.member.MemberServiceImpl");

        Autowired annotation = clazz.getAnnotation(Autowired.class);
        System.out.println("annotation = " + annotation);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            System.out.println("method = " + method);
        }
    }
}
