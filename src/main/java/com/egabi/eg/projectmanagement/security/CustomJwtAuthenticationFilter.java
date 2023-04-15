package com.egabi.eg.projectmanagement.security;

import com.egabi.eg.projectmanagement.utils.JwtUtil;
//import com.egabi.eg.zatcaservices.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {



	private String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIdXNzaWVuIiwidXNlclJvbGUiOiJVU0VSIiwidXNlclR5cGUiOiJBZG1pbiIsImZ1bGxOYW1lIjoiSHVzc2llbiBIYW1keSIsImF1dGhvcml0aWVzIjpbIjEiLCIyIiwiMyIsIjQiLCI1IiwiNiIsIjciXSwiZW1haWwiOiJodXNzaWVuQGdtYWlsLmNvbSIsIm1vYmlsZU5vIjoiMTIxMjMxMyIsInVzZXJOYW1lIjoiSHVzc2llbiIsImdlbmRlciI6Ik0iLCJpc0ZpcnN0TG9naW4iOiIwIiwiZXhwIjoxOTUzMTE4MjYyLCJpYXQiOjE2NTI2MTgyNjIsInNpZCI6MX0.8jlM2HOYOu8C0PZ9oG9MMhzYgs3dwTByBJf8_UYZtFl8TN86I0ZqOsnr-tIf81UTcNZU8WVPFift3IEAD15t8Q";
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		 try {

			 String path = request.getRequestURI();
			 String contentType = request.getContentType();
			 logger.info("Request URL path : "+path);
			 logger.info("Request content type: "+ contentType);
			 SecurityContext xx = SecurityContextHolder.getContext();

			 // JWT Token is in the form "Bearer token". Remove Bearer word and
			 // get  only the Token
//			 String jwtToken = extractJwtFromRequest(request);

			 // Just For developmenmt needs to be deleted
			 String jwtToken=token;


			 jwtTokenUtil.validateToken(jwtToken);

			 String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			 Long userId = jwtTokenUtil.getClaimFromToken(jwtToken,"sid",Long.class);
			 String email = jwtTokenUtil.getClaimFromToken(jwtToken,"email",String.class);
			 String fullName = jwtTokenUtil.getClaimFromToken(jwtToken,"fullName",String.class);
			 String mobileNo = jwtTokenUtil.getClaimFromToken(jwtToken,"mobileNo",String.class);
			 String userRole = jwtTokenUtil.getClaimFromToken(jwtToken,"userRole",String.class);
			 String userType = jwtTokenUtil.getClaimFromToken(jwtToken,"userType",String.class);
			 String gender = jwtTokenUtil.getClaimFromToken(jwtToken,"gender",String.class);
			 String isFirstLogin = jwtTokenUtil.getClaimFromToken(jwtToken,"isFirstLogin",String.class);


			 List<CustomGrantedAuthority> authorities = jwtTokenUtil.getAuthoritiesFromToken(jwtToken);

			 UserDetailsImpl userDetails = new UserDetailsImpl(userId,username, "",authorities);
			 userDetails.setEmail(email);
			 userDetails.setName(fullName);
			 userDetails.setMobileNo(mobileNo);
			 userDetails.setUserRole(userRole);
			 userDetails.setUserType(userType);
			 userDetails.setGender(gender);
			 userDetails.setIsFirstLogin(isFirstLogin);

			 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					 userDetails, null, userDetails.getAuthorities());
			 // After setting the Authentication in the context, we specify
			 // that the current user is authenticated. So it passes the
			 // Spring Security Configurations successfully.
			 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);


		 }catch(Exception ex) {
			 request.setAttribute("exception", ex);
			 ex.printStackTrace();
		 }
		chain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		List<String> excludeUrlPatterns = new ArrayList<>();

		for(String s :SpringSecurityConfiguration.AUTH_WHITELIST){
			excludeUrlPatterns.add(s);
		}

		for(String s :SpringSecurityConfiguration.SWAGGER_WHITELIST){
			excludeUrlPatterns.add(s);
		}


		return excludeUrlPatterns.stream().anyMatch(p -> new AntPathMatcher().match(p, request.getServletPath()));
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

}