package co.edu.ucentral.app.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ServicioInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioInventarioApplication.class, args);
	}

}
