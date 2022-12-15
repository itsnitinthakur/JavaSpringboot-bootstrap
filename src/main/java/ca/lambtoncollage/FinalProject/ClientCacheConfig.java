package ca.lambtoncollage.FinalProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientCacheConfig {

	@Bean
	public ClientCache getCientCache() {
		return new ClientCache();
	}
}
