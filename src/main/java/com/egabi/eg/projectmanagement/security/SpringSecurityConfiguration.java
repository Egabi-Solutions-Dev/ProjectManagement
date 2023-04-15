package com.egabi.eg.projectmanagement.security;
//

import com.egabi.eg.projectmanagement.model.services.security.SecurityService;
import com.egabi.eg.projectmanagement.utils.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Value("${com.egabi.eg.zatcaservices.security.cors}")
	private String[] CORS_ALLOWED_ORIGINS;

	public static final String[] AUTH_WHITELIST = {"/zatca/api/identity/login","/zatca/api/test","/zatca/api/user/checkUsernameAvailability"};

	public static final String[] SWAGGER_WHITELIST = { "/swagger-ui.html", "/swagger-ui/**", "/webjars/**", "/api/**",
			"/v2/api-docs/**", "/swagger-resources/**","/login" };

	public static final String[] ALL_CLAIMS_LIST = {"1","2","3","4","5","6","7","8","9"};


	@Autowired
	private SecurityService securityService;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;


	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.headers().frameOptions().and().contentSecurityPolicy(this.getContentSecurityPolicy()).and()
				.and().cors().configurationSource(corsConfigurationSource())
				.and().csrf().disable()
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.antMatchers(SWAGGER_WHITELIST).permitAll()

				//////
//				.antMatchers("/zatca/api/reports/**").hasAnyAuthority("10")
//
				.antMatchers("/zatca/api/identity/set-password").hasAnyAuthority(ALL_CLAIMS_LIST)
				.antMatchers("/zatca/api/identity/change-password").hasAnyAuthority(ALL_CLAIMS_LIST)
				.antMatchers("/zatca/api/user/getCurrUser").hasAnyAuthority(ALL_CLAIMS_LIST)

//
//				.antMatchers("/zatca/api/patch/submitDailyInvoice").hasAnyAuthority(ALL_CLAIMS_LIST)
//				.antMatchers("/zatca/api/patch/submitDailyInvoiceAsyn").hasAnyAuthority(ALL_CLAIMS_LIST)
//				.antMatchers("/zatca/api/patch/submitSelectedInvoices").hasAnyAuthority(ALL_CLAIMS_LIST)
//				.antMatchers("/zatca/api/patch/submitSelectedInvoicesAsyn").hasAnyAuthority(ALL_CLAIMS_LIST)
//				.antMatchers("/zatca/api/patch/submitSingleInvoice").hasAnyAuthority(ALL_CLAIMS_LIST)

				.antMatchers("/zatca/api/chart/**").hasAnyAuthority("1")//view-dashboard
				.antMatchers("/zatca/api/invoice/**").hasAnyAuthority("2")//view-invoices
				.antMatchers("/zatca/api/patch/**").hasAnyAuthority("3")//manage-invoices
				.antMatchers("/zatca/api/user/**").hasAnyAuthority("8")//manage-users
				.antMatchers("/zatca/api/config/**").hasAnyAuthority("9")//manage-zatca-config

				.antMatchers("/**").hasAnyAuthority(ALL_CLAIMS_LIST)
				.and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
				and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().logout().logoutUrl("/logout").
				and().addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


	}


	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(CORS_ALLOWED_ORIGINS));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type","skip-auth"
//				,"Access-Control-Allow-Origin"
				));
		configuration.setAllowCredentials(true);
		configuration.setExposedHeaders(Arrays.asList("Authorization","File-Name","skip-auth"
//				,"Access-Control-Allow-Origin http://10.10.250.2"
		));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	private String getContentSecurityPolicy(){
		StringBuilder contentSecurityPolicy = new StringBuilder("frame-ancestors 'self'");
		try {
			for (String address : CORS_ALLOWED_ORIGINS) {
				contentSecurityPolicy.append(" " + address);
			}
		}catch (Exception e){
			Logger.log.error("ContentSecurityPolicy",e);
		}
		return contentSecurityPolicy.toString();
	}

	protected static List<String> getExcludedUrlPatterns(){
		List<String> excludeUrlPatterns = new ArrayList<>();

		for(String s :SpringSecurityConfiguration.AUTH_WHITELIST){
			excludeUrlPatterns.add(s);
		}

		for(String s :SpringSecurityConfiguration.SWAGGER_WHITELIST){
			excludeUrlPatterns.add(s);
		}


		return excludeUrlPatterns;
	}

}
