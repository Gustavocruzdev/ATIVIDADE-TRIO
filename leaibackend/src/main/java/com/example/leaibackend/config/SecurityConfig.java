package com.example.leaibackend.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
    //Inserindo o CORS ao BackEnd para receber Requisições do FrontEnd

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();

        //Liberando as portas padrão do React (porta:3000) e Vite (porta:5173)

        configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:5173"));

        //Liberando os acessos aos métodos HTTP

        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));

        //Liberando acesso geral aos Headers do sistema

        configuration.setAllowedHeaders(List.of("*"));

        //Liberando acesso as credenciais

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
