package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findApplicationBean() {
        String[]beanDefinitionNames=ac.getBeanDefinitionNames();
        for (String beanDefinitionName:beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            System.out.println("beanDefinition = " + beanDefinition);
        if (beanDefinition.getRole()==BeanDefinition.ROLE_INFRASTRUCTURE){
            Object bean=ac.getBean(beanDefinitionName);
//            System.out.println("bean = " + bean);
        }
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void  findAllBea(){
            String[]beanDefinitionNames=ac.getBeanDefinitionNames();
            for (String beanDefinitionName:beanDefinitionNames){
//                System.out.println("beanDefinitionName = " + beanDefinitionName);
                Object bean=ac.getBean(beanDefinitionName);
                System.out.println("bean = " + bean);
            }

    }
}
