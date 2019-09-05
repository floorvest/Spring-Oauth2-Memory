package profesorp.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		// Whitelist these Rest API without OAUTH
		http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/", "/public").permitAll();
		
		// Api below must insert headers
		http.requestMatchers().antMatchers("/api/rahasia")
		.and().authorizeRequests()
		.antMatchers("/api/rahasia").access("hasRole('USER')")
		.and().requestMatchers().antMatchers("/admin");
	}  

}