package com.pranjal.chatstation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.pranjal.chatstation.handler.CustomWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
	
	private static String CHAT_ENDPOINT = "/chat";

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(getWebSocketHandler(), CHAT_ENDPOINT)
			.setAllowedOrigins("*");
	}
	
	@Bean
	public WebSocketHandler getWebSocketHandler() {
		return new CustomWebSocketHandler();
	}

}
