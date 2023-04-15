package com.egabi.eg.projectmanagement.controllers.security;


import com.egabi.eg.projectmanagement.constant.ErrorMessage;
import com.egabi.eg.projectmanagement.constant.ErrorsConstants;
import com.egabi.eg.projectmanagement.controllers.security.dto.AuthenticateUserRequest;
import com.egabi.eg.projectmanagement.controllers.security.dto.AuthenticationResponse;
import com.egabi.eg.projectmanagement.controllers.security.dto.ChangePasswordRequest;
import com.egabi.eg.projectmanagement.model.entities.user.UserEntity;
import com.egabi.eg.projectmanagement.model.services.security.SecurityService;
import com.egabi.eg.projectmanagement.model.services.users.imp.UserServiceImpl;
import com.egabi.eg.projectmanagement.response.ApiBaseModel;
import com.egabi.eg.projectmanagement.utils.*;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api(tags="Security")
@RestController()
@RequestMapping(value = "/zatca/api/identity")
public class SecurityController {
    List<String> errors = new ArrayList<String>();

//    @Value("${com.egabi.eg.zatcaservices.security.mail-auth-enabled}")
//    private Boolean IS_MAIL_AUTH_ENABLED;

//    @Value("${com.egabi.eg.zatcaservices.security.invalid-login-attempt-count}")
//    private Integer INVALID_LOGIN_ATTEMPT_COUNT;
//
//    @Value("${com.egabi.eg.zatcaservices.security.invalid-login-attempt-period-mil}")
//    private Long INVALID_LOGIN_ATTEMPT_PERIOD_MIL;



    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Autowired
    UserServiceImpl userService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;



    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private ApiBaseModel authenticateUser(@RequestBody(required = true) AuthenticateUserRequest authenticationRequest) throws Exception {
        ApiBaseModel res = null;
        boolean isValid = SecurityUtil.isValidAuthenticationCred(authenticationRequest);

        UserDetails userdetails = null;
        String token = null;

        try {
            if(!isValid){
                throw new BadCredentialsException(ErrorMessage.INVALID_CREDENTIALS.name());
            }
//            userDetailsService.setExternalAppUser(false);
            userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            boolean passMatched = bCryptPasswordEncoder.matches(authenticationRequest.getPassword(),userdetails.getPassword());

            if(!passMatched){
                throw new BadCredentialsException(ErrorMessage.INVALID_CREDENTIALS.name());
            }

            token = jwtUtil.generateToken((org.springframework.security.core.userdetails.User) userdetails);

//            if (token != null) {

                UserEntity userEntity = userDetailsService.getUserEntity();
                userEntity.setPassword(null);
                res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, new AuthenticationResponse(token,userEntity ), null);

                return res;
//            }else{
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.UNEXPECTED_ERROR}, null, null);
//            }

//        } catch (LockedException e) {
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_USER_LOCKED}, null, null);
//        } catch (DisabledException e) {
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_USER_DISABLED}, null, null);
//        } catch (BadCredentialsException e) {
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_INVALID_CREDENTIALS}, null, null);
//        } catch (Exception e) {
//            Logger.log.error("error",e);
//
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.UNEXPECTED_ERROR}, null, null);
//        }


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


//
//
//
//    private List<Integer> validateSetPassword(Long userId, ChangePasswordRequest param) {
//        System.out.println(param.getOldPassword()+" " + param.getNewPassword());
//        List<Integer> err = new ArrayList<Integer>()  ;
//        if(param != null) {
//            if ( param.getNewPassword() == null || param.getNewPassword().isEmpty()) {
//                err.add(ErrorsConstants.USER_INVALID_NEW_PASS);
//            }
//            if (param.getOldPassword() == null || param.getOldPassword().isEmpty()) {
//                err.add(ErrorsConstants.USER_INVALID_OLD_PASS);
//            }
//            if (userId == null || userId == 0) {
//                err.add(ErrorsConstants.USER_INVALID_USERID);
//            }
//            if (param.getConfirmPassword() == null || !param.getConfirmPassword().equals(param.getNewPassword())) {
//                err.add(ErrorsConstants.USER_PASS_AND_CONFIRM_PASS_IS_NOT_MATCHED);
//            }
//            if (param.getOldPassword() != null && !param.getOldPassword().isEmpty() &&
//                    param.getNewPassword() != null && !param.getNewPassword().isEmpty()&&
//                    param.getNewPassword().equals(param.getOldPassword())) {
//
//                err.add(ErrorsConstants.USER_NEW_PASS_EQUAL_OLD_PASS);
//            }
//            if (param.getNewPassword() != null && param.getNewPassword().isEmpty()&&
//                    param.getNewPassword().equals(AppConstants.USER_DEFAULT_PASSWORD)) {
//
//                err.add(ErrorsConstants.USER_NEW_PASS_EQUAL_DEFAULT_PASS);
//            }
//            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,20}$";
//            if(param.getNewPassword() != null && (!param.getNewPassword().matches(regex))){
//                err.add(ErrorsConstants.USER_INVALID_NEW_PASS_POLICY);
//
//            }
//        }else{
//            err.add(ErrorsConstants.USER_INVALID_INPUTS);
//        }
//       return err;
//    }


//    private boolean validateResetPassword(ResetUserPasswordRequest param) {
//        if (param == null || param.getUserId() == null) {
//            this.errors.add("must enter userId");
//        }
//
//        if (errors != null && errors.size() > 0) {
//            return false;//throw new MyException(418,errors,"/users/ResetUserPassword");
//        } else {
//            return true;
//        }
//    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ApiBaseModel logout(@CookieValue(name = "jwtTokenCookie", defaultValue = "") String jwtTokenCookie) throws Exception {
        System.out.println("identity/logout >>>>> Called");


//        HttpHeaders responseHeaders = new HttpHeaders();
//        JwtTokenCookieHandeler cookie = new JwtTokenCookieHandeler();
//        responseHeaders.set(HttpHeaders.SET_COOKIE, cookie.deleteCookie("jwtTokenCookie").toString());

//        responseHeaders.set("Baeldung-Example-Header","Value-ResponseEntityBuilderWithHttpHeaders");
        ApiBaseModel res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, null, null);
//        responseHeaders.set("Access-Control-Allow-Origin","*");
//        responseHeaders.set("Access-Control-Allow-Methods","GET, POST, PATCH, PUT, DELETE, OPTIONS");
//        responseHeaders.set("Access-Control-Allow-Headers","Origin, Content-Type, X-Auth-Token");


        return res;
    }

//
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/set-password", method = RequestMethod.POST)
//    public ApiBaseModel setPassword( @RequestBody(required = true) ChangePasswordRequest changePasswordRequest) throws Exception {
//
//        Long userId = SessionUtils.getCurrentUser().getUserId();
//
//        ApiBaseModel res = null;
////        ResponseEntity<ApiBaseModel> ss = null;
//        List<Integer> err= PasswordUtil.validateSetPassword(userId, changePasswordRequest);
//
//        if (err != null && err.size() > 0) {
//            int [] errCodes = new int[err.size()];
//            for (int i=0;i<err.size();i++) {
//                errCodes[i]=err.get(i).intValue();
//            }
//            res = new ApiBaseModel<AuthenticationResponse>(Boolean.FALSE, errCodes, null, null);
//
//            return res;
//        }
//
//        String userName = null;
//
//        try {
//            userName = userService.setPassword(userId,
//                    changePasswordRequest.getNewPassword(),
//                    changePasswordRequest.getOldPassword());
//        } catch (CustomBusinessException e) {
//            if ("OLD_PASSWORD_NO_MATCH".equals(e.getMessage())) {
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_PASS_SET_OLD_NEW_NO_MATCH}, null, null);
//                return res;
//            }
//            if ("SET_PASSWORD_ERROR".equals(e.getMessage()) || "USER_NOT_FOUND".equals(e.getMessage())) {
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_PASS_SET_ERROR}, null, null);
//
//                return res;
//            }
//        }
//
////        try {
////            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, changePasswordRequest.getNewPassword()));
////        } catch (DisabledException e) {
////            throw new CDCUnauthorizedException(ErrorMessage.USER_DISABLED.name());
////        } catch (BadCredentialsException e) {
////            throw new CDCUnauthorizedException(ErrorMessage.INVALID_CREDENTIALS.name());
////        }
//
//        res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, null, null);
//
//        return res;
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
//    public ApiBaseModel changePassword( @RequestBody(required = true) ChangePasswordRequest changePasswordRequest) throws Exception {
//
//        return setPassword( changePasswordRequest);
//    }

//
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/entityLogin", method = RequestMethod.POST)
//    public ApiBaseModel authenticateUserWithOtp(@ApiParam(value = "Json with username & password") @RequestBody(required = true) AuthenticateUserRequest authenticationRequest) throws Exception {
//        ApiBaseModel res = null;
//        boolean isSuccess = validateAuthenticateUser(authenticationRequest);
//        Long userId = null;
//
//        UserDetails userdetails = null;
//        String token = null;
//        Boolean needsOtp=false;
//        try {
//            userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//
//            if(((UserDetailsImpl) userdetails).getUserData().getAccountTypeId().intValue()== AccountType.ENTITY.getValue()){
//
//                if(IS_MAIL_AUTH_ENABLED == true) {
//                    needsOtp = true;
//                    Otp otp = otpGenerator.findLatestOtp(authenticationRequest.getUsername(), "USER", "OTP_LOGIN");
//                    if (otp != null) {
//                        int msgCode = otpGenerator.validateOtpAndShowMsg(otp,otp.getOtpString());
//
//                        if(msgCode==ErrorsConstants.OTP_TRIALS_EXCEEDED) {
//                            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.OTP_TRIALS_EXCEEDED}, null, null);
//                            return res;
//                        }
//
//                        if(msgCode==ErrorsConstants.OTP_USED_BEFORE) {
//                            otpGenerator.generateNewOtpAction(userdetails.getUsername(),
//                                    ((UserDetailsImpl) userdetails).getUserData().getEmail(),
//                                    ((UserDetailsImpl) userdetails).getUserData().getMobileNo(),
//                                    ((UserDetailsImpl) userdetails).getUserId());
//
//                            res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, new AuthenticationResponse(null, IS_MAIL_AUTH_ENABLED), null);
//
//                        }else{
//
//                            //                        if(msgCode!=ErrorsConstants.OTP_INCORRECT_VALUE) {
//                            otpGenerator.regenerateOtpAction(otp.getId(), userdetails.getUsername(),
//                                    ((UserDetailsImpl) userdetails).getUserData().getEmail(),
//                                    ((UserDetailsImpl) userdetails).getUserData().getMobileNo());
//                            res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, new AuthenticationResponse(null, IS_MAIL_AUTH_ENABLED), null);
//                            //                        }else{
//                            //                            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.OTP_INCORRECT_VALUE}, null, null);
//                            //                        }
//                            //                    }else{
//                            //                        res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.OTP_SENT_BEFORE}, null, null);
//                            //                    }
//                        }
//
//                    } else {
//                        //                    if(needsOtp) {
//                        otpGenerator.generateNewOtpAction(userdetails.getUsername(),
//                                ((UserDetailsImpl) userdetails).getUserData().getEmail(),
//                                ((UserDetailsImpl) userdetails).getUserData().getMobileNo(),
//                                ((UserDetailsImpl) userdetails).getUserId());
//
//                        res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, new AuthenticationResponse(null, IS_MAIL_AUTH_ENABLED), null);
//
//                        //                    }else{
//                        //                        token = jwtUtil.generateToken((org.springframework.security.core.userdetails.UserEntity) userdetails);
//                        //                    }
//                    }
//                }else{
//                    token = jwtUtil.generateToken((org.springframework.security.core.userdetails.UserEntity) userdetails);
//                    res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, new AuthenticationResponse(token, IS_MAIL_AUTH_ENABLED), null);
//                }
//
////                loginRateLimitation(true,authenticationRequest.getUsername());
//
//            }else{
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_CDC_USER_NOT_ALLOWED_TO_USE_THIS_SERVICE}, null, null);
//            }
//
//
//        } catch (LockedException e) {
//            //throw new CDCUnauthorizedException(ErrorMessage.USER_DISABLED.name());
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_USER_LOCKED}, null, null);
//
//        } catch (DisabledException e) {
//            //throw new CDCUnauthorizedException(ErrorMessage.USER_DISABLED.name());
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_USER_DISABLED}, null, null);
//        } catch (BadCredentialsException e) {
//
////            loginRateLimitation(false,authenticationRequest.getUsername());
//
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_INVALID_CREDENTIALS}, null, null);
//        } catch (Exception e) {
//            Logger.log.error("error",e);
//
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.UNEXPECTED_ERROR}, null, null);
//        }
//
//        return res;
//    }
//
//
//
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/validateOtpAndLogin", method = RequestMethod.POST)
//    public ApiBaseModel validateOtpAndLogin(@ApiParam(value = "Json with username & OTP") @RequestBody(required = true) AuthenticateUserWithOtpRequest authenticationRequest) throws Exception {
//        ApiBaseModel res = null;
//
//        UserDetails userdetails = null;
//        String token = null;
//        try {
//            userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//            if(((UserDetailsImpl) userdetails).getUserData().getAccountTypeId().intValue()== AccountType.ENTITY.getValue()){
//
//                Otp otp = otpGenerator.findLatestOtp(authenticationRequest.getUsername(),"USER","OTP_LOGIN");
//                if(otp!=null){
//                    int msgCode = otpGenerator.validateOtpAndShowMsg(otp,authenticationRequest.getOtpString());
//                    if(msgCode==0){
//                        otp.setOtpStatus("VERIFIED");
//                        otpGenerator.updateOtp(otp);
//                        token = jwtUtil.generateToken((org.springframework.security.core.userdetails.UserEntity) userdetails);
//                        res = new ApiBaseModel<AuthenticationResponse>(Boolean.TRUE, null, new AuthenticationResponse(token), null);
//                    }else{
//                        if(msgCode==ErrorsConstants.OTP_TRIALS_EXCEEDED) {
//                            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.OTP_TRIALS_EXCEEDED}, null, null);
//                            return res;
//                        }
//
//                        if(msgCode==ErrorsConstants.OTP_INCORRECT_VALUE || msgCode==ErrorsConstants.OTP_MUST_ENTER_VALUE) {
//                            otpGenerator.otpRateLimitation(false,otp.getId());
//                            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.OTP_INCORRECT_VALUE}, null, null);
//                            return res;
//                        }
//
//                        if(msgCode==ErrorsConstants.OTP_USED_BEFORE || msgCode==ErrorsConstants.OTP_EXPIRED) {
//                            otpGenerator.regenerateOtpAction(otp.getId(), userdetails.getUsername(),
//                                    ((UserDetailsImpl) userdetails).getUserData().getEmail(),
//                                    ((UserDetailsImpl) userdetails).getUserData().getMobileNo());
//
//                            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{msgCode}, null, null);
//                            return res;
//                        }
//                    }
//                }else{
//                    res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.UNEXPECTED_ERROR}, null, null);
//                }
//            }else{
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_CDC_USER_NOT_ALLOWED_TO_USE_THIS_SERVICE}, null, null);
//            }
//
//        } catch (javax.persistence.NonUniqueResultException nonUniqueResultException) {
//            Logger.log.error("error",nonUniqueResultException);
//            res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_INVALID_CREDENTIALS}, null, null);
//        } catch (Exception e) {
////            Logger.log.error("error",e);
//
//            Logger.log.error("error",e);
//            if(e instanceof CustomBusinessException){
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_USER_DISABLED}, null, null);
//            }
//            else
//                res = new ApiBaseModel<>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_INVALID_CREDENTIALS}, null, null);
//        }
//
//        return res;
//    }




//    public void loginRateLimitation(boolean isValidLogin,String username){
//        try {
//            if(isValidLogin){
//                UserEntity u = userService.findByUsername(username);
//                u.setInvalidLoginAttemptCount(0L);
//                Timestamp now = new Timestamp(System.currentTimeMillis());
//                u.setLastValidLoginAttempt(now);
//                u.setLastInvalidLoginAttempt(null);
//                userService.updateUser(u);
//            }else {
//                UserEntity u = userService.findByUsername(username);
//                Timestamp now = new Timestamp(System.currentTimeMillis());
//                Timestamp halfHourBef = new Timestamp(System.currentTimeMillis() - this.INVALID_LOGIN_ATTEMPT_PERIOD_MIL);
//                u.setLastValidLoginAttempt(null);
//
//                if (u.getLastInvalidLoginAttempt() == null || halfHourBef.before(u.getLastInvalidLoginAttempt())) {
//                    u.setInvalidLoginAttemptCount(u.getInvalidLoginAttemptCount() == null ? 1L : u.getInvalidLoginAttemptCount() + 1);
//                } else {
//                    u.setInvalidLoginAttemptCount(1L);
//                }
//
//                if (u.getInvalidLoginAttemptCount().intValue() >= this.INVALID_LOGIN_ATTEMPT_COUNT) {
//                    u.setCurrentStsCode(UserAccountStatus.LOCKED.getValue());
//                }
//                u.setLastInvalidLoginAttempt(now);
//                userService.updateUser(u);
//            }
//        } catch (Exception e) {
//            Logger.log.error("Login", e);
//        }
//    }







//}








}
