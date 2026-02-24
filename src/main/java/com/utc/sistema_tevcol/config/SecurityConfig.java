package com.utc.sistema_tevcol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                // Permitimos que todos vean los estilos y la página de login
                .requestMatchers("/css/**", "/js/**", "/login").permitAll()
                // Cualquier otra ruta (como /productoepp) requiere estar logueado
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/login") // Nuestra página personalizada
                .defaultSuccessUrl("/productoepp", true) // A donde va tras loguearse
                .permitAll()
            )
            .logout((logout) -> logout
            		.logoutSuccessUrl("/login?logout")
            		.permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Creamos un usuario en memoria para cumplir con el requisito rápidamente
        UserDetails user = User.builder()
            .username("admin")
            .password("{noop}tevcol2026") // {noop} se usa para contraseñas en texto plano (solo pruebas)
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}