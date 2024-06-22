package com.vipul.learnspring.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBuisnessClass{
	
//	as soon as we put 'Autowired' annotation on the field, it is called as field injection
	
//	@Autowired
	Dependency1 dependency1;
	
//	@Autowired
	Dependency2 dependency2;
	
//	as soon as we put 'Autowired' annotation on the constructor, it is called as constructor injection
//  for constructor injection, using 'Autowired' annotation is not mandatory
//  constructor injection is recommended by Spring
	
	@Autowired
	public YourBuisnessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBuisnessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}



//	as soon as we put 'Autowired' annotation on the setter function, it is called as setter injection
	
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(DependencyInjectionLauncherApplication.class);){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
				System.out.println(context.getBean(YourBuisnessClass.class));
		}
	}

}
