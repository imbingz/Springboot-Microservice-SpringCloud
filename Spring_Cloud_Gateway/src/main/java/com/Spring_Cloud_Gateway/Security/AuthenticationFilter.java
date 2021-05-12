package com.Spring_Cloud_Gateway.Security;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.Spring_Cloud_Gateway.Entity.UserModel;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	private final WebClient.Builder webClientBuilder;
	
	public static class Config {

	}

	public AuthenticationFilter(WebClient.Builder webClientBuilder) {
		super(Config.class);
		this.webClientBuilder = webClientBuilder;
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				throw new RuntimeException("Missing authorization information");
			}

			String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

			String[] parts = authHeader.split(" ");

			if (parts.length != 2 || !"Bearer".equals(parts[0])) {
				throw new RuntimeException("Incorrect authorization structure");
			}

			return webClientBuilder.build().post().uri("http://USER-SERVICE/user/authenticate")
					.retrieve().bodyToMono(UserModel.class).map(UserModel -> {
						exchange.getRequest().mutate().header("X-auth-user-id", String.valueOf(UserModel.getId()));
						return exchange;
					}).flatMap(chain::filter);
		};
	}
}
