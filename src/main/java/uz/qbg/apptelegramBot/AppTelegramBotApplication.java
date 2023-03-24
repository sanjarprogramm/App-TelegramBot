package uz.qbg.apptelegramBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class AppTelegramBotApplication {


	@Bean
	public RestTemplate restTemplate (){

		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(AppTelegramBotApplication.class, args);
	}

}
