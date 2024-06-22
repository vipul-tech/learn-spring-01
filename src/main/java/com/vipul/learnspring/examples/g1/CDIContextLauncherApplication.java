package com.vipul.learnspring.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// for this import we have added maven repository 'jakarta.inject-api' in pom.xml file
import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BuisnessService {
	private DataService dataService;
	
//	@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}
	
}

@Component
class DataService{
	
}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(CDIContextLauncherApplication.class);){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(BuisnessService.class).getDataService());
		}
	}

}
