package com.egabi.eg.projectmanagement.security;


import com.egabi.eg.projectmanagement.response.ApiBaseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		Exception exception = (Exception) request.getAttribute("exception");

		String message;

		if (exception != null) {
			
			if (exception.getCause() != null) {
				message = exception.getCause().toString() + " " + exception.getMessage();
			} else {
				message = exception.getMessage();
			}

			byte[] body =  new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS).writeValueAsBytes(new ApiBaseModel(false,new int[]{401}));

			response.getOutputStream().write(body);
			

		} else {

			if (authException.getCause() != null) {
				message = authException.getCause().toString() + " " + authException.getMessage();
			} else {
				message = authException.getMessage();
			}


//			byte[] body = null;//new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", new ErrorResponse(message,401)));
			byte[] body =  new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS).writeValueAsBytes(new ApiBaseModel(false,new int[]{401}));

			response.getOutputStream().write(body);
		}
	}



}
