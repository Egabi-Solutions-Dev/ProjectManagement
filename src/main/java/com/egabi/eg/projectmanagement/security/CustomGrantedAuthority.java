package com.egabi.eg.projectmanagement.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class CustomGrantedAuthority implements GrantedAuthority {




    private static final long serialVersionUID = -3007732696559630183L;
    private final String roleCode;
    private Long roleId;
//    private Long branchId;

    public CustomGrantedAuthority(String roleCode, Long roleId, Long branchId) {
        this.roleCode = roleCode;
        this.roleId = roleId;
//        this.branchId = branchId;
    }

    public CustomGrantedAuthority(String roleCode) {
        Assert.hasText(roleCode, "A granted authority textual representation is required");
        this.roleCode = roleCode;
    }
    @Override
    public String getAuthority() {
        return this.roleCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return obj instanceof CustomGrantedAuthority ? this.roleCode.equals(((CustomGrantedAuthority)obj).roleCode) : false;
        }
    }

    public int hashCode() {
        return this.roleCode.hashCode();
    }

    public String toString() {
        return this.roleCode;
    }




    public String toString2() {
        return "{" +
                "role:" + (roleCode != null ? roleCode :"")+
                ", roleId:" + roleId+
//                ", branchId:" + branchId+
                '}';
    }
}
