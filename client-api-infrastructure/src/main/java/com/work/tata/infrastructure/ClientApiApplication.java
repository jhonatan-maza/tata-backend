package com.work.tata.infrastructure;

import com.work.tata.infrastructure.client.persistence.RoleJpaRepository;
import com.work.tata.infrastructure.client.persistence.model.RoleEntity;
import com.work.tata.infrastructure.client.rest.utils.HelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class, HttpClientConfiguration.class})
public class ClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}

	@Autowired
	private RoleJpaRepository roleRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<RoleEntity> roles = roleRepository.findAll();
			if(roles.isEmpty()) {
				roleRepository.saveAll(HelperUtil.roleSupplier.get());
			}
		};
	}

}
