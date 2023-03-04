package com.br.Maintenance.maintenance.model.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "_authority")
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_description")
    private String roleDescription;

    @Override
    public String getAuthority() {
        return roleCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

}