package uth.edu.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import uth.edu.backend.entity.custom.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private CustomUserDetailsService customUserDetailsService;

        @Bean
        BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @SuppressWarnings("removal")
        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable()) // Add CSRF configuration

                                // Consolidate session management
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                                                .maximumSessions(1)
                                                .expiredUrl("/login?expired=true")
                                                .and()
                                                .sessionFixation().migrateSession())

                                .securityContext(context -> context
                                                .requireExplicitSave(false))

                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/*").permitAll()
                                                .requestMatchers("/static/**", "/fe/**", "/assets/**", "/uploads/**",
                                                                "/css/**", "/js/**", "/images/**")
                                                .permitAll()
                                                .requestMatchers("/fe/**", "/css/**", "/js/**", "/images/**")
                                                .permitAll()
                                                .requestMatchers("/login").permitAll()
                                                .requestMatchers("/logout").permitAll()
                                        .requestMatchers("/seller/**").permitAll()
                                        .requestMatchers("/admin/**").permitAll() // Remove authority checks
                                                .requestMatchers("/cart/**").permitAll() // Remove authority checks
                                                .requestMatchers("/product/**").permitAll() // Remove authority checks
                                                .requestMatchers("/product-detail/**").permitAll() // Remove authority
                                                .requestMatchers("/identity/product-extended/**").permitAll()
                                                .requestMatchers("/identity/product/**").permitAll()
                                                .requestMatchers("/cart").permitAll()
                                                .requestMatchers("/cart/**").permitAll()
                                                .requestMatchers("/checkout/**").permitAll()
                                                .requestMatchers("/checkout").permitAll()

                                                .requestMatchers("/product-extended/**").permitAll()
                                                .requestMatchers("/user/**").permitAll() // Remove authority checks
                                                .requestMatchers("/admin/**").hasAuthority("ADMIN") // Uncomment
                                                // authority
                                                // checks
                                                // .requestMatchers("/seller/**").hasAuthority("SELLER")
                                                .anyRequest().authenticated())

                                .formLogin(login -> login
                                                .loginPage("/login")
                                                .loginProcessingUrl("/login")
                                                .usernameParameter("username")
                                                .passwordParameter("password")
                                                .defaultSuccessUrl("/", true))

                                // Single logout configuration
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login")
                                                .invalidateHttpSession(true)
                                                .deleteCookies("JSESSIONID"));

                return http.build();
        }

//        @Bean
//        public WebSecurityCustomizer webSecurityCustomizer() {
//                return (web) -> web.ignoring().requestMatchers("/static/**", "/fe/**",
//                                "assets/**", "uploads/**",
//                                "/css/**", "/js/**", "/images/**", "product-detail/**");
//        }
}