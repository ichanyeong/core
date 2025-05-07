package hello.core.scan.filter;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.lang.annotation.*;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
