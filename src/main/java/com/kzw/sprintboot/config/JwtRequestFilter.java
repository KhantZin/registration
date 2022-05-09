package com.kzw.sprintboot.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kzw.sprintboot.service.impl.UserServiceImpl;
import com.kzw.sprintboot.util.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserServiceImpl impl;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		final String requestToken = request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;
		
		String url = request.getRequestURI();
		
//		if(url != "/" and )
		
		if(requestToken != null && requestToken.startsWith("Bearer ")) {
			jwtToken = requestToken.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			}
			catch (IllegalIdentifierException e) {
				e.printStackTrace();
				response.sendRedirect("/login");
				System.out.println("Unable to get JWT Token");
			}
			catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("JWT Token has expired");
			}
		}
		else {
			logger.warn("JWT Token does not begin with Bearer String");
		}
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = impl.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
	}
	
}
