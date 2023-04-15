package com.egabi.eg.projectmanagement.model.repositories.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.NoRepositoryBean;

//@Repository
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}