package uth.edu.backend.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import uth.edu.backend.security.CustomSecurityContextSerializer;

@Configuration
@EnableJdbcHttpSession
public class SessionConfig {

    @Bean
    public Serializer<SecurityContext> springSessionDefaultSerializer() {
        return new CustomSecurityContextSerializer();
    }

    @Bean
    public Deserializer<SecurityContext> springSessionDefaultDeserializer() {
        return new CustomSecurityContextSerializer();
    }
}