package blogApp.blogX.utility;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyConfig {


	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
