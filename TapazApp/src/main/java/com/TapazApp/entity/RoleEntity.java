package com.TapazApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String roleName;
    String roleStatus;

    public RoleEntity(String id, String roleName, String roleStatus) {
        this.id = id;
        this.roleName = roleName;
        this.roleStatus = roleStatus;
    }

    public RoleEntity() {
    }
}
