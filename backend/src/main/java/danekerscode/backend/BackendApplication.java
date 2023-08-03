package danekerscode.backend;

import danekerscode.backend.model.Message;
import danekerscode.backend.service.redis.MessageRedisService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(MessageRedisService redisService){
		return args -> {
			redisService.save(new Message());
			System.out.println(redisService.messages());
		};
	}


}
