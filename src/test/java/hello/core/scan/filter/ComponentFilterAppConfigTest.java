package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {
    @Test
    void filterConfig(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean(BeanA.class);
        System.out.println("beanA = " + beanA);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean(BeanB.class));
    }
    @Configuration
    @ComponentScan(basePackages = "hello.core.scan.filter",includeFilters = @ComponentScan.Filter(classes = MyIncludeComponent.class)
            ,excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE ,classes = MyExcludeComponent.class))
    static class ComponentFilterAppConfig{

    }
}

