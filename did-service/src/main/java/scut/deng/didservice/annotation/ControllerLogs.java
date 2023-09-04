package scut.deng.didservice.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)  // 表示该注解可以用于标记方法
@Retention(RetentionPolicy.RUNTIME)  // 表示该注解在运行时保留
@Documented  // 表示该注解应该包含在JavaDoc中
public @interface ControllerLogs {
    String description() default "";  // 自定义注解的属性，用于描述方法的功能
    boolean printResponse() default true;  // 自定义注解的属性，用于指定是否打印响应信息，默认为true
}
