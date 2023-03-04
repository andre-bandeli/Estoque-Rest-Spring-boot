package com.br.Maintenance.maintenance.configuration.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtFilter extends OncePerRequestFilter {

    private UserDetailsService userDetailsService;
    private JwtToken jwt;

    public JwtFilter(UserDetailsService userDetailsService, JwtToken jwt) {
        this.userDetailsService=userDetailsService;
        this.jwt=jwt;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authToken=jwt.getToken(request);
        if(null!=authToken) {
            String userName=jwt.getUsernameFromToken(authToken);
            if(null!=userName) {
                UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
                if(jwt.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

}
