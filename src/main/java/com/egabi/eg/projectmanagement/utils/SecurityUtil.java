package com.egabi.eg.projectmanagement.utils;

import com.egabi.eg.projectmanagement.constant.AppConstants;
import com.egabi.eg.projectmanagement.constant.ErrorsConstants;
import com.egabi.eg.projectmanagement.controllers.security.dto.AuthenticateUserRequest;
import com.egabi.eg.projectmanagement.controllers.security.dto.ChangePasswordRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class SecurityUtil {

    public static String extractCredentialsFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Basic ")) {
            return bearerToken.substring(6, bearerToken.length());
        }
        return null;
    }

    public static AuthenticateUserRequest getDecodedBasicAuthCredentials(String cread){
        if(cread==null){
            return new AuthenticateUserRequest(null,null);
        }
        String decodedAuthorization =new String(Base64.getDecoder().decode(cread.getBytes(StandardCharsets.UTF_8)));

        int passStart = decodedAuthorization.indexOf(":");
        String username = decodedAuthorization.substring(0, passStart);
        String password = decodedAuthorization.substring(passStart+1, decodedAuthorization.length());

        AuthenticateUserRequest basicReq = new AuthenticateUserRequest(username,password);
        return basicReq;
    }

    public static boolean isValidAuthenticationCred(AuthenticateUserRequest param) {
        boolean isValid = true;
        if (param == null || param.getUsername() == null || param.getUsername().isEmpty()) {
            isValid=false;
        }
        if (param == null || param.getPassword() == null || param.getPassword().isEmpty()) {
            isValid=false;
        }
        return isValid;
    }


    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static boolean matches(String rawPassword, String encodedPassword ){
        return bCryptPasswordEncoder.matches(rawPassword,encodedPassword);
    }

    public static boolean encodeAndMatch(String rawPassword, String decodedPassword ){
        String encodedPassword = bCryptPasswordEncoder.encode(decodedPassword);
        return bCryptPasswordEncoder.matches(rawPassword,encodedPassword);
    }

    public static String encode(String decodedPassword){
        return bCryptPasswordEncoder.encode(decodedPassword);
    }

    public static List<Integer> validateSetPassword(Long userId, ChangePasswordRequest param) {
        System.out.println(param.getOldPassword()+" " + param.getNewPassword());
        List<Integer> err = new ArrayList<Integer>()  ;
        if(param != null) {
            if ( param.getNewPassword() == null || param.getNewPassword().isEmpty()) {
                err.add(ErrorsConstants.USER_INVALID_NEW_PASS);
            }
            if (param.getOldPassword() == null || param.getOldPassword().isEmpty()) {
                err.add(ErrorsConstants.USER_INVALID_OLD_PASS);
            }
            if (userId == null || userId == 0) {
                err.add(ErrorsConstants.USER_INVALID_USERID);
            }
            if (param.getConfirmPassword() == null || !param.getConfirmPassword().equals(param.getNewPassword())) {
                err.add(ErrorsConstants.USER_PASS_AND_CONFIRM_PASS_IS_NOT_MATCHED);
            }
            if (param.getOldPassword() != null && !param.getOldPassword().isEmpty() &&
                    param.getNewPassword() != null && !param.getNewPassword().isEmpty()&&
                    param.getNewPassword().equals(param.getOldPassword())) {

                err.add(ErrorsConstants.USER_NEW_PASS_EQUAL_OLD_PASS);
            }
            if (param.getNewPassword() != null && !param.getNewPassword().isEmpty()&&
                    param.getNewPassword().equals(AppConstants.USER_DEFAULT_PASSWORD)) {

                err.add(ErrorsConstants.USER_NEW_PASS_EQUAL_DEFAULT_PASS);
            }
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,20}$";
            if(param.getNewPassword() != null && (!param.getNewPassword().matches(regex))){
                err.add(ErrorsConstants.USER_INVALID_NEW_PASS_POLICY);

            }
        }else{
            err.add(ErrorsConstants.USER_INVALID_INPUTS);
        }
        return err;
    }

}
