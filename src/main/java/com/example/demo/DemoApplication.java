package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		DemoService demoService =context.getBean(DemoService.class);
		
		Driver driver = new Driver();
		driver.setName("Daniele");

		Vehicle v1 = new Vehicle();
		v1.setVehicleIdentityNumber("123");
		v1.setDriver(driver);
		
		var listaVeicoli = new ArrayList<Vehicle>();
		listaVeicoli.add(v1);
		
		driver.setVehicleList(listaVeicoli);
		
		Driver savedDriver = demoService.save(driver);
		
		System.out.println(savedDriver);
		
		savedDriver.getVehicleList().stream().forEach(System.out::println);
		
		demoService.find(savedDriver.getVehicleList().get(0).getId()).ifPresent(v -> {
			v.setVehicleIdentityNumber("456");
			demoService.save(v);
		});
		
		
	
	}

}
