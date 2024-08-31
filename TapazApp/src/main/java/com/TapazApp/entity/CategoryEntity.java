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
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String categoryName;
    Boolean categoryStatus;

    public CategoryEntity(String id, String categoryName, Boolean categoryStatus) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
    }

    public CategoryEntity() {
    }
}
