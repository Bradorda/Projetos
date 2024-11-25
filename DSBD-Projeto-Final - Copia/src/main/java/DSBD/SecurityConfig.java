package DSBD;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecurityConfig {
	
	@Bean
    public BCrypt bcrypt() {
		return new BCrypt();
	}

}
