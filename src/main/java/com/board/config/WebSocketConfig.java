package com.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Value("${allowed.origins}")
    private String[] allowedOrigins;
    
    /* 
     * This method configures the message broker for handling WebSocket messages.
     * It enables a simple in-memory message broker and sets the application destination prefix.
     * /topic -> Clients subscribe to this prefix to receive messages.
     * /app -> Clients send messages to this prefix, which are then routed to @MessageMapping methods in controllers.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // Enable a simple in-memory message broker
        registry.setApplicationDestinationPrefixes("/app"); // Prefix for messages bound for @MessageMapping methods
    }

    /* 
     * This method registers STOMP endpoints for WebSocket connections.
     * It adds the "/ws-board" endpoint and configures it to allow all origins for CORS.
     * SockJS is enabled as a fallback option for browsers that do not support WebSockets.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.
        addEndpoint("/ws-board"). // Conection URL for WebSocket connections
        setAllowedOrigins(allowedOrigins). // Restrict origins to the configured list
        withSockJS(); // Register the /ws endpoint for WebSocket connections with SockJS fallback
    }
}
