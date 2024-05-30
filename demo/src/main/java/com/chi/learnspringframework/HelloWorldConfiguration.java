package com.chi.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/* 
 * Spring 官方對 @Configuration 的解釋
 * @Configuration is a class-level annotation indicating that an object is a source of bean definitions.
 * @Configuration classes declare beans through @Bean-annotated methods. 
 * Calls to @Bean methods on @Configuration classes can also be used to define inter-bean dependencies.
 */

record Person(String name, int age) { };
record PersonWithAddress(String name, int age, Address address) { };
record Address(String street, String city) { };
record Education(String major, String school) { };

@Configuration
public class HelloWorldConfiguration {

  @Bean
  public String name() {
    return "chi";
  }

  @Bean
  public int age() {
    return 27;
  }

  @Bean
  public Person person() {
    return new Person("Husan", 24);
  }

  @Bean(name="myCustomAddress")
  public Address address() {
    return new Address("Backer St.", "London");
  }

  @Bean
  public PersonWithAddress person2ByMethodCall() {
    return new PersonWithAddress(name(), age(), address());
  }

  /*
   * name, age, address 已經變成 @Bean 透過 Spring 管理，
   * 建立新的 @Bean，將存在的 @Bean 注入進去，讓 Spring 建立自動連接，
   * 進而建立新的 @Bean
   */
  @Bean
  public PersonWithAddress person3ByParameters(String name, int age, Address address) {
    return new PersonWithAddress(name, age, address);
  }

  @Bean
  public Education education() {
    return new Education("Marketing", "Northwestern University");
  }

  @Bean
  public Education education2() {
    return new Education("Science", "TU Berlin");
  }

}


