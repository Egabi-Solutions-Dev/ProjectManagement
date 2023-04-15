package com.egabi.eg.projectmanagement.model.entities.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity @Setter @Getter
@Table(name = "SECURITY_USER")
public class UserEntity {

    @Id
    @Column(name = "USR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrId;


    @NotNull @NotBlank
    @Column(name = "USERNAME")
    private String username;

    @NotNull @NotBlank
    @Column(name = "USER_ROLE")
    private String userRole;

//    @Password
    @NotNull @NotBlank
    @Column(name = "PASSWORD")
    private String password;


    @NotNull @NotBlank
    @Column(name = "FULL_NAME")
    private String fullName;

    @NotNull @NotBlank
    @Column(name = "USER_TYPE")
    private String userType;

    @Column(name = "IS_FIRST_LOGIN")
    private String isFirstLogin;
//    private Long accountTypeId;


//    private Long invalidLoginAttemptCount;
//    private Timestamp lastInvalidLoginAttempt;
//    private Timestamp lastValidLoginAttempt;

    @NotNull @NotBlank
    @Column(name = "CURRENT_STS_CODE")
    private String currentStsCode;


    @Column(name = "BIRTH_DATE")
    private Date birthDate;

//    private Employee employee;

    @NotNull @NotBlank
    @Column(name = "EMAIL")
    private String email;
//    public String defaultPassword;


    @Column(name = "MOBILE_NO")
    private String mobileNo;


    @Column(name = "GENDER")
    private String gender;


}
