package com.egabi.eg.projectmanagement.model.services.users.imp;

import com.egabi.eg.projectmanagement.model.entities.user.UserEntity;
import com.egabi.eg.projectmanagement.model.repositories.user.UserRepository;
import com.egabi.eg.projectmanagement.response.ApiBaseModel;
import com.egabi.eg.projectmanagement.utils.JavaxValidator;
//import com.egabi.eg.zatcaservices.constant.AppConstants;
//import com.egabi.eg.zatcaservices.constant.ErrorsConstants;
//import com.egabi.eg.zatcaservices.constant.SystemUserRole;
//import com.egabi.eg.zatcaservices.constant.UserAccountStatus;
//import com.egabi.eg.zatcaservices.controller.base.response.ApiBaseModel;
//import com.egabi.eg.zatcaservices.controller.security.dto.AuthenticationResponse;
//import com.egabi.eg.zatcaservices.controller.security.dto.ChangePasswordRequest;
//import com.egabi.eg.zatcaservices.controller.user.mapper.UserMapper;
//import com.egabi.eg.zatcaservices.controller.user.pojo.User;
//import com.egabi.eg.zatcaservices.exception.CustomBusinessException;
//import com.egabi.eg.zatcaservices.model.entities.user.UserEntity;
//import com.egabi.eg.zatcaservices.model.repositories.user.UserRepository;
//import com.egabi.eg.zatcaservices.security.UserDetailsImpl;
//import com.egabi.eg.zatcaservices.utils.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaxValidator<UserEntity> userValidator;


//    private UserMapper userMapper = new UserMapper();

//
//    public Long createUser(User user) throws SQLIntegrityConstraintViolationException,Exception{
//
//        UserEntity us = userMapper.unMap(user);
//
//
//        String encodedPassword = SecurityUtil.encode(AppConstants.USER_DEFAULT_PASSWORD);
//
//        us.setPassword(encodedPassword);//
//
//        us.setIsFirstLogin("T");
////        us.getEmployee().setEmployeesBranchesRoles(userRoles);
//
//        userValidator.validate(us);
//
//        Long userId = userRepository.save(us).getUsrId();
////        Long userId = userDao.save(us).getId();
//        //userDao.flush();
//
//        return userId;
//    }

    public UserEntity findByUsername(String username){
        UserEntity user=null;
        Optional<UserEntity> userOpt = userRepository.findByUsernameIgnoreCase(username);
        if(userOpt.isPresent()){
            user = userOpt.get();
        }
        return user;
    }

    public UserEntity findUserByUserId(Long userId){
        UserEntity user = userRepository.getById(userId);
        return user;

    }

//
//    public ApiBaseModel changeAccountStatus(Long userId){
//        ApiBaseModel res;
//        if(userId==null){
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_INPUTS},null,null);
//            return res;
//        }
//        try{
//            UserEntity user  = userRepository.getById(userId);
//
////            if (user!=null && !validateUserEntity.isEligibleUser(user.getEntityId())) {
////                res = new ApiBaseModel<Integer>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_NOT_ALLOWED_TO_ACCESS_THIS_ENTITY}, null, null);
////                return res;
////            }
//            //        String username = param.getUser().getUsername();
//            //        UserEntity user = userDetailsService.findUserByUsernameAndPassword(param.getUser().getUsername(),param.getUser().getPassword());
//            if(user!=null){
//                if(user.getCurrentStsCode() == null || user.getCurrentStsCode().equals(UserAccountStatus.ACTIVE.getValue())){
//                    user.setCurrentStsCode(UserAccountStatus.DISABLED.getValue());
//                }else{
//                    user.setCurrentStsCode(UserAccountStatus.ACTIVE.getValue());
//
////                    this.resetOtpRateLimit(user.getUsername());
//
//                }
//                this.updateUser(user);
//                //Long userId = userDetailsService.createUser(param.getUser());
//            }
//
//
//            res = new ApiBaseModel<>(Boolean.TRUE,null,null,null);
//
//        }catch(EntityNotFoundException e){
//            Logger.log.error("error",e);
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_CANT_SAVE_USER_DATA},null,null);
//        }
//        return res;
//    }


    public Long countByUsername(String username){
        Long user = userRepository.countByUsernameIgnoreCase(username);

        return user;
    }

    public UserEntity updateUser(UserEntity user){



//        for(UserRolesEntity role :user.getUserRoles()){
//            role.setUser(user);
////            RoleEntity roleEntity = roleRepository.getById(role.getRole().getId());
////            roleEntity.setUsersRoles(user.getUserRoles());
////            role.setRole(roleEntity);
//        }
//        us.setEmployee(emp);
        userValidator.validate(user);
        UserEntity u = userRepository.save(user);
        return u;
    }
//
//    public String setPassword(Long userId,String newPassword,String oldPassword) throws CustomBusinessException {
//        UserEntity u = null;
//
//        try {
//            u = userRepository.findById(userId).get();
//        }catch (Exception e){
//            throw new CustomBusinessException("USER_NOT_FOUND");
//        }
//        if(u == null ){
//            throw new CustomBusinessException("USER_NOT_FOUND");
//        }
//        if( !(SecurityUtil.matches( oldPassword+"",u.getPassword()))){
//            throw new CustomBusinessException("OLD_PASSWORD_NO_MATCH");
//        }
//        try {
//            String encodedPassword = SecurityUtil.encode(newPassword);
//            u.setPassword(encodedPassword);
//            u.setIsFirstLogin("F");
//            userValidator.validate(u);
//            userRepository.save(u);
//            return u.getUsername();
//        }catch (Exception e){
//            throw new CustomBusinessException("SET_PASSWORD_ERROR");
//        }
//    }
//
//
//
//
//    @SneakyThrows
//    public ApiBaseModel search( String username, String status, String fullName, Integer currentPage,Integer pageSize){
//
//
//        UserDetailsImpl ud= SessionUtils.getCurrentUser();
//
//        if(ud.getUserRole()!=null && ud.getUserRole().equals(SystemUserRole.ADMIN.getValue()) ){
//
//        }
//
//        CustomPagination customPagination = new CustomPagination(currentPage, pageSize);
//        Page<UserEntity> page = userRepository.search(username, status,fullName,  customPagination.getPageable());
//
//
//        List<User> users = userMapper.mapPage(page);
//
//
//        ApiBaseModel res = new ApiBaseModel<List<User>>(Boolean.TRUE,null,users,customPagination.getPageInfoApiModel(page));
//
//        return res;
//    }
//
//
//
//    public ApiBaseModel registerNewUser(User user){
//        ApiBaseModel res;
//        if(user==null){
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_INPUTS},null,null);
//            return res;
//        }
//
//        try {
//
//            res = this.checkUsernameAvailability(user.getUsername());
//            Boolean availableUserName = res.getStatus();
//            if(availableUserName == false){
//                return res;
//            }else {
//                user.setUserId(null);
//
////                if (user!=null && !validateUserEntity.isEligibleUser(user.getEntityId())) {
////                    res = new ApiBaseModel<Integer>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_NOT_ALLOWED_TO_ACCESS_THIS_ENTITY}, null, null);
////                    return res;
////                }
//
//                Long userId = this.createUser(user);
////                //send email
////                if(user.getAccountTypeId()!=null && user.getEmail()!=null){
////                    try {
////                        this.sendMail(user.getEmail(), Constants.USER_DEFAULT_PASSWORD);
////                    }catch(Exception e){
////                        Logger.log.error("error",e);
////                    }
////                }
//
//                res = new ApiBaseModel<Long>(Boolean.TRUE, null, null, null);
//            }
//        }catch(javax.validation.ConstraintViolationException ex){
//            throw ex;
//        }catch (SQLIntegrityConstraintViolationException e){
//            Logger.log.error("error",e);
////            if (e.getMessage().contains("constraint [nationalid_uk]"))
////                res = new ApiBaseModel<>(Boolean.FALSE,new int[]{ErrorsConstants.USER_NATIONAL_ID_EXSITS}, null,null);
////            else
//            res = new ApiBaseModel<>(Boolean.FALSE,new int[]{ErrorsConstants.USER_CANT_SAVE_USER_DATA}, null,null);
//        }
//        catch (Exception e){
//            Logger.log.error("error",e);
//
//            res = new ApiBaseModel<>(Boolean.FALSE,new int[]{ErrorsConstants.USER_CANT_SAVE_USER_DATA}, null,null);
//        }
//
//        return res;
//    }

//
//    public ApiBaseModel<Integer> checkUsernameAvailability(String username){
//
//        ApiBaseModel<Integer> res;
//        if(username==null || username.isEmpty()){
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_USERNAME},null,null);
//            return res;
//        }
//
//        Long cnt =  this.countByUsername(username);
//
//        if(cnt>0){
//            res = new ApiBaseModel<>(Boolean.FALSE,new int[]{ErrorsConstants.USER_ALREADY_EXIST}, null,null);
//        }else {
//            res = new ApiBaseModel<>(Boolean.TRUE,new int[]{}, null,null);
//        }
//        return res;
//
//    }

//
//    public ApiBaseModel updateUser(User user){
//        ApiBaseModel res = null;//new ApiBaseModel<>(Boolean.FALSE,new int[]{ErrorMessage.ALREADY_EXIST_USER.ordinal()}, null,null);
//
////        User user = mapUserServiceDtoToUser(param);
//
//        if(user == null || user.getUserId()==null || user.getUserId()==0L){
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_INPUTS},null,null);
//            return res;
//        }
//
//
////        if (user!=null && !validateUserEntity.isEligibleUser(user.getEntityId())) {
////            res = new ApiBaseModel<Integer>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_NOT_ALLOWED_TO_ACCESS_THIS_ENTITY}, null, null);
////            return res;
////        }
//
//        try {
//
//            UserEntity existEnt = this.findUserByUserId(user.getUserId());
//            user.setPassword(existEnt.getPassword());
//            user.setUsername(existEnt.getUsername());
//            user.setIsFirstLogin(existEnt.getIsFirstLogin());
//
//            UserEntity userEntity = userMapper.unMap(user);
//
//            this.updateUser(userEntity);
//            res = new ApiBaseModel<>(Boolean.TRUE,null, null,null);
//
//        }catch(javax.validation.ConstraintViolationException ex){
//            throw ex;
//        }catch (Exception e){
//            if(e!=null&& e.getMessage().contains("users_uniqueKey1")){
//                res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_ALREADY_EXIST},null,null);
//                return res;
//            }else{
//                Logger.log.error("error",e);
//                res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_CANT_SAVE_USER_DATA},null,null);
//            }
//
//        }
//        return res;
//    }
//
//
//    public ApiBaseModel changePassword( ChangePasswordRequest param){
//
//        ApiBaseModel res = null;
//        if(param==null ){
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_INPUTS},null,null);
//        }
//
//        UserEntity user = this.findUserByUserId(param.getUserId());//SessionUtils.getCurrentUser().getUserId());
//
////            if (user!=null && !validateUserEntity.isEligibleUser(user.getEntityId())) {
////                res = new ApiBaseModel<Integer>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_NOT_ALLOWED_TO_ACCESS_THIS_ENTITY}, null, null);
////                return res;
////            }
//
//        if (user != null) {
//
//            if(user.getPassword()!=null && param.getOldPassword()!=null &&
//                    SecurityUtil.matches(param.getOldPassword(),user.getPassword())&&
////                        user.getPassword().equals(param.getOldPassword())&&
//                    param.getNewPassword()!=null && !param.getNewPassword().isEmpty() ){
//
//                List<Integer> err = SecurityUtil.validateSetPassword(user.getUsrId(), param);
//
//                if (err != null && err.size() > 0) {
//                    int [] errCodes = new int[err.size()];
//                    for (int i=0;i<err.size();i++) {
//                        errCodes[i]=err.get(i).intValue();
//                    }
//                    res = new ApiBaseModel<AuthenticationResponse>(Boolean.FALSE, errCodes, null, null);
//
//                    return res;
//                }
//
//                user.setPassword(SecurityUtil.encode(param.getNewPassword()));
//                this.updateUser(user);
//                res = new ApiBaseModel<>(Boolean.TRUE, null, null, null);
//
//            }else{
//                res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_INPUTS},null,null);
//            }
//        }
//
//        return res;
//    }
//
//
//    public ApiBaseModel resetPassword(ChangePasswordRequest param){
//        ApiBaseModel res = null;
//
//        if(param==null || param.getUserId()==null){
//            res = new ApiBaseModel<>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_INPUTS}, null,null);
//            return res;
//        }
//        try {
//            Optional<UserEntity> userOpt = userRepository.findById(param.getUserId());
//            if(!userOpt.isPresent()){
//                res = new ApiBaseModel<>(Boolean.FALSE,new int[]{ErrorsConstants.USER_NOT_FOUND}, null,null);
//                return res;
//            }
//            UserEntity user = userOpt.get() ;
//
////            if (user!=null && !validateUserEntity.isEligibleUser(user.getEntityId())) {
////                res = new ApiBaseModel<Integer>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_NOT_ALLOWED_TO_ACCESS_THIS_ENTITY}, null, null);
////                return res;
////            }
//
//
//            if (user != null) {
//
////                if( param.getNewPassword()!=null && !param.getNewPassword().isEmpty() &&
////                        param.getConfirmPassword()!=null &&
////                        param.getNewPassword().equals(param.getConfirmPassword())) {
////                    param.setOldPassword("x");
////                    List<Integer> err = SecurityUtil.validateSetPassword(user.getUsrId(), param);
////
////                    if (err != null && err.size() > 0) {
////                        int[] errCodes = new int[err.size()];
////                        for (int i = 0; i < err.size(); i++) {
////                            errCodes[i] = err.get(i).intValue();
////                        }
////                        res = new ApiBaseModel<AuthenticationResponse>(Boolean.FALSE, errCodes, null, null);
////
////                        return res;
////                    }
//
//                    user.setPassword(SecurityUtil.encode(AppConstants.USER_DEFAULT_PASSWORD));
//                    user.setIsFirstLogin("T");
//                    this.updateUser(user);
//
////                this.resetOtpRateLimit(user.getUsername());
//
//                    //send email
////                if(user.getAccountTypeId()!=null && user.getEmail()!=null){
////                    try {
////                        this.sendMail(user.getEmail(), Constants.USER_DEFAULT_PASSWORD);
////                    }catch(Exception e){
////                        Logger.log.error("error",e);
////                    }
////                }
//                    res = new ApiBaseModel<>(Boolean.TRUE, null, null, null);
//
////                }
//            }else{
//                res = new ApiBaseModel<>(Boolean.TRUE, new int[]{ErrorsConstants.USER_NOT_FOUND}, null, null);
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_CANT_SAVE_USER_DATA},null,null);
//        }
//        return res;
//    }


//
//    public ApiBaseModel getUser(Long id){
//
//        ApiBaseModel res=null;
//        if(id==null){
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_INVALID_INPUTS},null,null);
//            return res;
//        }
//        try {
//
////            UserEntity u = userService.findUserUserByUserId(id);
//
////            if (u!=null && !validateUserEntity.isEligibleUser(u.getEntityId())) {
////                res = new ApiBaseModel<Integer>(Boolean.FALSE, new int[]{ErrorsConstants.AUTH_NOT_ALLOWED_TO_ACCESS_THIS_ENTITY}, null, null);
////                return res;
////            }
//
//            User user = userMapper.map(this.findUserByUserId(id));
////            UserServiceDto dto = mapUserToUserServiceDto(user);
//            res = new ApiBaseModel<User>(Boolean.TRUE,null, user,null);
//        }catch (Exception e){
//            res = new ApiBaseModel<Integer>(Boolean.FALSE,new int[]{ErrorsConstants.USER_NOT_FOUND},null,null);
//        }
//        return res;
//    }
//
//
//    public ApiBaseModel getCurrUser(){
//
//        Long userId=0L;
//        try{
//            userId =(Long) SessionUtils.getCurrentUser().getUserId();
//        }catch (Exception ex){
//            Logger.log.error("error",ex);
//        }
//
//
//        UserEntity u = this.findUserByUserId(userId);
//        User user = userMapper.map(this.findUserByUserId(userId));
//
////        ApiBaseModel res = new ApiBaseModel<User>(Boolean.TRUE,new int[] {HttpStatus.OK.value()},user,null);
//        ApiBaseModel res = new ApiBaseModel<User>(Boolean.TRUE,null,user,null);
//
//        return res;
//    }

}
