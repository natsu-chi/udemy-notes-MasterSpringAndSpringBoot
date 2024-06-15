package com.chi.learnspringframework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

  public static void main(String[] args) {
    // 1. Launch a Spring Context
    // .class 取得類別實例
    try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
      // 2. Configure the things that we want Spring to manage - @Configuration
      // HelloWorldConfiguration - @Configuration
      // name - @Bean

      // 3. Retrieving Beans managed by Spring
      System.out.println(context.getBean("name"));
      System.out.println(context.getBean("age"));
      System.out.println(context.getBean("person"));

      // custom name
      // System.out.println(context.getBean("address"));
      System.out.println(context.getBean(Address.class));
      System.out.println(context.getBean("myCustomAddress"));

      // @Bean by @Bean
      System.out.println(context.getBean("person2ByMethodCall"));
      System.out.println(context.getBean("person3ByParameters"));

      // CANNOT get Bean By class when annotate two same @Bean class
      // System.out.println(context.getBean(Education.class));
    }
  }

}
