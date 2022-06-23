package com.cibertec.apiHospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.cibertec"})
@EntityScan(basePackages = {"com.cibertec"})
@EnableJpaRepositories(basePackages = {"com.cibertec"})
public class ApiHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHospitalApplication.class, args);
	}

}
