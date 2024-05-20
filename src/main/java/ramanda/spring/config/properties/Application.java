package ramanda.spring.config.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import ramanda.spring.config.properties.converter.StringToDateConverter;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class Application {
	@Bean
	public ApplicationConversionService conversionService(StringToDateConverter stringToDateConverter){
		ApplicationConversionService applicationConversionService = new ApplicationConversionService();
		applicationConversionService.addConverter(stringToDateConverter);
		return applicationConversionService;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
