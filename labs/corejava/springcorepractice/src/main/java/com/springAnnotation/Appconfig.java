package com.springAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@ComponentScan(basePackages = {"com.springAnnotation"})
public class Appconfig {
@Bean
  public Customer customer() {
      return new Customer(person());
      }
@Bean
  public Person person() {
      return new Person("sdf",56,"dfg") }
  }    
  

