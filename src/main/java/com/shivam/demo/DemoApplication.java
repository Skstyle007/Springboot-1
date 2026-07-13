package com.shivam.demo;

import com.shivam.demo.DependancyInjaction.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


//		Student student = context.getBean(Student.class);
//		student.setName("Rahul");
//		student.setAge(30);
//
//		System.out.println(student.getName());
//		System.out.println(student.getAge());
//
//


//		Student student = new Student("Shivam",20,100);
//		System.out.println(student.getAge());
//

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}


}
