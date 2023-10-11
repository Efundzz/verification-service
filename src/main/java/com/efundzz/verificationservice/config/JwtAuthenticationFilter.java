package com.efundzz.verificationservice.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain chain)
            throws ServletException, IOException {
        // Extract token from Authorization header
        // Validate token
        // If valid, set authentication in the security context
        // Chain the request to next filter

        final String authorizationHeader = httpRequest.getHeader(AUTHORIZATION_HEADER);
        String username = null;
        String jwt = null;

        String requestURI = httpRequest.getRequestURI();
        if (isPermitAllEndpoint(requestURI)) {
            chain.doFilter(httpRequest, httpResponse);
            return;
        }

        // Bearer should be replaced with the prefix you use in your token
//        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {
//            String idToken = authorizationHeader.substring(BEARER_PREFIX.length());
//            username = jwtTokenUtil.extractUsername(jwt);
//        }

        // Ensure the user is not already authenticated, and if the token is valid, proceed to authenticate the request
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = new User(username, "", jwtTokenUtil.extractAuthorities(jwt));
//
//            if (jwtTokenUtil.validateToken(jwt, userDetails)) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken
//                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
        chain.doFilter(httpRequest, httpResponse);
    }

    private boolean isPermitAllEndpoint(String requestURI) {
        // Use this method to check if the request URI matches any of your permit-all endpoints.
        return pathMatcher.match("/reference/**", requestURI) ||
                pathMatcher.match("/lead/save", requestURI); // Add your new pattern here
    }
}