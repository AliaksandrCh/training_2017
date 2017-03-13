package com.epam.training.library2017.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.library2017.services.IBookService;

public class ServicesTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");
        System.out.println(context);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("Бобы в банке:");
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }

        IBookService service = context.getBean(IBookService.class);
        System.out.println(service);

        service.get(1);
    }
}
