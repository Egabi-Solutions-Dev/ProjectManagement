package com.egabi.eg.projectmanagement.model.services.security;

import com.egabi.eg.projectmanagement.constant.ErrorMessage;
import com.egabi.eg.projectmanagement.constant.ErrorsConstants;
import com.egabi.eg.projectmanagement.constant.SystemUserRole;
import com.egabi.eg.projectmanagement.constant.UserAccountStatus;
import com.egabi.eg.projectmanagement.controllers.security.dto.AuthenticateUserRequest;
import com.egabi.eg.projectmanagement.controllers.security.dto.AuthenticationResponse;
import com.egabi.eg.projectmanagement.model.entities.user.UserEntity;
import com.egabi.eg.projectmanagement.model.repositories.user.UserRepository;

import com.egabi.eg.projectmanagement.response.ApiBaseModel;
import com.egabi.eg.projectmanagement.security.CustomGrantedAuthority;
import com.egabi.eg.projectmanagement.security.UserDetailsImpl;
import com.egabi.eg.projectmanagement.utils.Logger;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityService implements UserDetailsService {


	@Autowired
	UserRepository userRepository;

	UserEntity userEntity=null;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@SneakyThrows
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> userOpt = userRepository.findByUsernameIgnoreCase(username);

		if(userOpt.isPresent()) {
			userEntity = userOpt.get();
		}else{
			throw new BadCredentialsException(ErrorMessage.ENTITY_IS_NOT_FOUND.name());
		}

		String status =null;
//		try {
		status = userEntity.getCurrentStsCode();
//		}catch (Exception e){
//			Logger.log.error("",e);
//			throw new BadCredentialsException(ErrorMessage.ENTITY_IS_NOT_FOUND.name());
//		}

		if(status != null && !status.equals(UserAccountStatus.ACTIVE.getValue())){
			if(status.equals(UserAccountStatus.DISABLED.getValue())) {
				throw new DisabledException(ErrorMessage.USER_DISABLED.name());
			}else if(status.equals(UserAccountStatus.LOCKED.getValue())){
				throw new LockedException(ErrorMessage.ACCOUNT_LOCKED.name());
			}
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		if(userEntity.getUserRole().equals(SystemUserRole.ADMIN.getValue())){
			grantedAuthorities.add(new CustomGrantedAuthority("1"));//view Dashboard
			grantedAuthorities.add(new CustomGrantedAuthority("2"));//view-invoices
			grantedAuthorities.add(new CustomGrantedAuthority("3"));//manage-invoices

			grantedAuthorities.add(new CustomGrantedAuthority("8"));//manage-users
			grantedAuthorities.add(new CustomGrantedAuthority("9"));//view-Batches-statistics

		}else{
			grantedAuthorities.add(new CustomGrantedAuthority("1"));//view Dashboard
			grantedAuthorities.add(new CustomGrantedAuthority("2"));//view-invoices
			grantedAuthorities.add(new CustomGrantedAuthority("3"));//manage-invoices

		}
//		String[] r = AppConstants.ROLE_CLAIMS;
//		for(String rr : r){
//			grantedAuthorities.add(new CustomGrantedAuthority(rr));
//		}


		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(userEntity.getUsrId(),userEntity.getUsername(),userEntity.getPassword(),grantedAuthorities);
		userDetailsImpl.setName(userEntity.getFullName());
		userDetailsImpl.setEmail(userEntity.getEmail());
		userDetailsImpl.setMobileNo(userEntity.getMobileNo());
		userDetailsImpl.setGender(userEntity.getGender());
		userDetailsImpl.setUserRole(userEntity.getUserRole());
		userDetailsImpl.setUserType(userEntity.getUserType());
		userDetailsImpl.setIsFirstLogin(userEntity.getIsFirstLogin());


		return userDetailsImpl;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}


	public ApiBaseModel basicAuthenticateUser(AuthenticateUserRequest authenticationRequest) throws Exception {
		ApiBaseModel res = null;
		boolean isValid = isValidAuthenticationCred(authenticationRequest);

		UserDetails userdetails = null;
		String token = null;

		try {
			if(!isValid){
				throw new BadCredentialsException(ErrorMessage.INVALID_CREDENTIALS.name());
			}

			userdetails = this.loadUserByUsername(authenticationRequest.getUsername());
			boolean passMatched = bCryptPasswordEncoder.matches(authenticationRequest.getPassword(),userdetails.getPassword());

			if(!passMatched){
				throw new BadCredentialsException(ErrorMessage.INVALID_CREDENTIALS.name());
			}

//            token = jwtUtil.generateToken((org.springframework.security.core.userdetails.User) userdetails);

//            if (token != null) {

			UserEntity userEntity = this.getUserEntity();
			userEntity.setPassword(null);
			res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, new AuthenticationResponse(token,userEntity ), null);

			return res;
//            }else{
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.UNEXPECTED_ERROR}, null, null);
//            }

		} catch (LockedException e) {

			Set err = new HashSet<Integer>();
			err.add(ErrorsConstants.AUTH_USER_LOCKED);
			res = new ApiBaseModel<>(Boolean.FALSE, err, null, null);
		} catch (DisabledException e) {
			Set err = new HashSet<Integer>();
			err.add(ErrorsConstants.AUTH_USER_DISABLED);
			res = new ApiBaseModel<>(Boolean.FALSE,err, null, null);
		} catch (BadCredentialsException e) {
			Set err = new HashSet<Integer>();
			err.add(ErrorsConstants.AUTH_INVALID_CREDENTIALS);
			res = new ApiBaseModel<>(Boolean.FALSE, err, null, null);
		} catch (Exception e) {
			Logger.log.error("error",e);
			Set err = new HashSet<Integer>();
			err.add(ErrorsConstants.UNEXPECTED_ERROR);
			res = new ApiBaseModel<>(Boolean.FALSE, err, null, null);
		}

		return res;
	}

	private boolean isValidAuthenticationCred(AuthenticateUserRequest param) {
		boolean isValid = true;
		if (param == null || param.getUsername() == null || param.getUsername().isEmpty()) {
			isValid=false;
		}
		if (param == null || param.getPassword() == null || param.getPassword().isEmpty()) {
			isValid=false;
		}
		return isValid;
	}

}
