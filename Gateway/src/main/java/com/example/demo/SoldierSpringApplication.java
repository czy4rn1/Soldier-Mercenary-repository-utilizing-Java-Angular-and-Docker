package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class SoldierSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoldierSpringApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${military.soldiers.url}") String soldiersUrl,
			@Value("${military.companies.url}") String companiesUrl,
			@Value("${military.gateway.host}") String host
	){
		return builder
				.routes()
				.route("military-company", route -> route
						.host(host)
						.and()
						.path(
								"/military-company/companies",
								"/military-company/one-company/{id}",
								"/military-company/create/{id}",
								"/military-company/delete/{id}",
								"/military-company/update/{id}"
						)
						.uri(companiesUrl)
				)
				.route("soldier", route -> route
						.host(host)
						.and()
						.path(
								"/soldier/soldiers",
								"/soldier/soldiersCompany/{id}",
								"/soldier/one-soldier/{id}",
								"/soldier/create/{id}",
								"/soldier/delete/{id}",
								"/soldier/update/{id}"
						)
						.uri(soldiersUrl))
				.build();
	}

	@Bean
	public CorsWebFilter corsWebFilter() {
		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}

}
