package com.egabi.eg.projectmanagement.model.entities.lkp;

import javax.persistence.*;

@MappedSuperclass
public class BaseLkpEntity<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LKP_ID", nullable = false)
    private ID id;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }


    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
