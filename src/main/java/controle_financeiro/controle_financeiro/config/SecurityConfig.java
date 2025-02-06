package controle_financeiro.controle_financeiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.
            csrf(csrf -> csrf.disable()) // CSRF DESATIVADO APENAS PARA APIs GET
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/**").authenticated().anyRequest().permitAll())
                
                .httpBasic(httpBasic -> {});
         
        return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService(){
            UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

                return new InMemoryUserDetailsManager(admin);
        }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
}

