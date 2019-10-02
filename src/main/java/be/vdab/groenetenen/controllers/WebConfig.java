package be.vdab.groenetenen.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
class WebConfig implements WebMvcConfigurer {

	// taal vast zetten
	/*
	 * @Bean FixedLocaleResolver localeResolver() { return new
	 * FixedLocaleResolver(new Locale("fr", "BE")); }
	 */

//	 taal laten kiezen door de gebruiker
	
	  @Bean SessionLocaleResolver localeResolver() { return new
	  SessionLocaleResolver(); }
	  
	  @Override public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(new LocaleChangeInterceptor()); }

	// taal van de brouwer zolang de gebruiker geen taal kiest, taal bij houden in
	// een cookie


	// taal via locale brouwer
	
	/*@Bean 
	CookieLocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieMaxAge(604_800);
		return resolver;
	}*/

}
