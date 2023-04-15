package com.egabi.eg.projectmanagement.utils;

import com.egabi.eg.projectmanagement.constant.ErrorMessage;
import com.egabi.eg.projectmanagement.exception.CDCUnauthorizedException;
import com.egabi.eg.projectmanagement.security.CustomGrantedAuthority;
import com.egabi.eg.projectmanagement.security.UserDetailsImpl;
//import com.egabi.eg.zatcaservices.constant.ErrorMessage;
//import com.egabi.eg.zatcaservices.exception.CDCUnauthorizedException;
//import com.egabi.eg.zatcaservices.security.CustomGrantedAuthority;
//import com.egabi.eg.zatcaservices.security.UserDetailsImpl;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class JwtUtil {

	private String secret;
	private int jwtExpirationInMs;

	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Value("${jwt.expirationDateInMs}")
	public void setJwtExpirationInMs(int jwtExpirationInMs) {
		this.jwtExpirationInMs = jwtExpirationInMs;
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("sid",((UserDetailsImpl)userDetails).getUserId());
		claims.put("fullName",((UserDetailsImpl)userDetails).getName());
		claims.put("userRole",((UserDetailsImpl)userDetails).getUserRole());
		claims.put("userType",((UserDetailsImpl)userDetails).getUserType());
		claims.put("email",((UserDetailsImpl)userDetails).getEmail());
		claims.put("mobileNo",((UserDetailsImpl)userDetails).getMobileNo());
		claims.put("gender",((UserDetailsImpl)userDetails).getGender());
		claims.put("isFirstLogin",((UserDetailsImpl)userDetails).getIsFirstLogin());

		Collection<? extends GrantedAuthority> grantedAuthorities = userDetails.getAuthorities();

		List<String> authorities=new ArrayList<>() ;

		grantedAuthorities.forEach((auth)->{authorities.add(auth.getAuthority());});

		claims.put("authorities",authorities);

		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}

	public void validateToken(String authToken) throws CDCUnauthorizedException {
		if(!StringUtils.hasText(authToken)){
			throw new CDCUnauthorizedException(ErrorMessage.INVALID_TOKEN.name());
		}

		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
		}catch (MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
			throw new CDCUnauthorizedException(ErrorMessage.EXPIRED_TOKEN.name());
		} catch (ExpiredJwtException ex) {
			throw new CDCUnauthorizedException(ErrorMessage.INVALID_CREDENTIALS.name());
		}catch (SignatureException ex){
			throw new CDCUnauthorizedException(ErrorMessage.INVALID_TOKEN_SIGNATURE.name());
		}catch (Exception e){
			throw new CDCUnauthorizedException(e.getMessage());
		}

	}

	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claims.getSubject();

	}

	public <T> T getClaimFromToken(String token,String claimName, Class<T> requiredType){
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return (T) claims.get(claimName,requiredType);
	}

	public List<CustomGrantedAuthority> getAuthoritiesFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

		List<CustomGrantedAuthority> customGrantedAuthorities = new ArrayList<CustomGrantedAuthority>();

		List<String> authorities =new ArrayList<String>();
		authorities = claims.get("authorities",authorities.getClass());
		for (String auth :authorities) {
			customGrantedAuthorities.add(new CustomGrantedAuthority(auth));
		}

		return customGrantedAuthorities;

	}

//	public static <T> List<T> getObjectList(String jsonString,Class<T> cls){
//		List<T> list = new ArrayList<T>();
//		try {
//			Gson gson = new Gson();
//			JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
//			for (JsonElement jsonElement : arry) {
//				list.add(gson.fromJson(jsonElement, cls));
//			}
//		} catch (Exception e) {
//			Logger.log.error("error",e);
//		}
//		return list;
//	}

}
