package org.springframework.samples.petclinic.rest.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Spring Boot Actuator responds with the vendor-specific media type
 * application/vnd.spring-boot.actuator.vN+json unless the client
 * explicitly sends "Accept: application/json". Tools that check for
 * plain application/json (rather than the actuator-specific type)
 * would otherwise treat the actuator as unreachable, even though it
 * responds successfully. This filter rewrites the Accept header on
 * /actuator/** requests so those tools get standard JSON.
 */
@Configuration
public class ActuatorAcceptHeaderConfig {

    @Bean
    public FilterRegistrationBean<Filter> actuatorAcceptHeaderFilter() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new ActuatorAcceptHeaderFilter());
        registration.addUrlPatterns("/actuator/*");
        registration.setOrder(Integer.MIN_VALUE);
        return registration;
    }

    private static class ActuatorAcceptHeaderFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            chain.doFilter(new AcceptJsonRequestWrapper(httpRequest), response);
        }
    }

    private static class AcceptJsonRequestWrapper extends HttpServletRequestWrapper {
        AcceptJsonRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getHeader(String name) {
            if ("Accept".equalsIgnoreCase(name)) {
                return "application/json";
            }
            return super.getHeader(name);
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            if ("Accept".equalsIgnoreCase(name)) {
                return Collections.enumeration(Collections.singletonList("application/json"));
            }
            return super.getHeaders(name);
        }
    }
}
