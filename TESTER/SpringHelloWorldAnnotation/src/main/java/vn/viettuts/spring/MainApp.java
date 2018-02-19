package vn.viettuts.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import vn.viettuts.spring.config.HelloWorldConfig;
import vn.viettuts.spring.domain.HelloWorld;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				HelloWorldConfig.class);
		HelloWorld bean = (HelloWorld) context.getBean("helloWorldBean");
		bean.sayHello("Spring");
		context.close();
	}
}
