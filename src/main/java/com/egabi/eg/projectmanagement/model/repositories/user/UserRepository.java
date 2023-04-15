package com.egabi.eg.projectmanagement.model.repositories.user;


import com.egabi.eg.projectmanagement.model.entities.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{


    Optional<UserEntity> findByUsernameIgnoreCase(String username);

    Optional<UserEntity> findById(Long id);

    long countByUsernameIgnoreCase(String username);

    @Query(value = "select usr "+
            "from UserEntity usr\n " +
            "where (:username is null or upper(usr.username) like  '%'||UPPER(:username)||'%')\n" +
            "and ( :currentStsCode is null or :currentStsCode = usr.currentStsCode)\n "+
            "and (:fullName is null or upper(usr.fullName) like  '%'||UPPER(:fullName)||'%') \n")
    public Page<UserEntity> search(@Param("username")  String username,
                                   @Param("currentStsCode")  String currentStsCode,
                                   @Param("fullName")  String fullName,
                                   Pageable pageable);




}