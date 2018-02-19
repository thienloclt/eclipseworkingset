package vn.viettuts.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import vn.viettuts.spring.domain.HelloWorld;
import vn.viettuts.spring.domain.HelloWorldImpl;

@Configuration
public class HelloWorldConfig {

	@Bean(name = "helloWorldBean")
	@Description("Dinh nghia bean annotation")
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}
}
