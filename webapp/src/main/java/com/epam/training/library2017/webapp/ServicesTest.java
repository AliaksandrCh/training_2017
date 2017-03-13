package com.epam.training.library2017.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServicesTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");
        System.out.println(context);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("Бобы в банке:");
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }

    }
}
