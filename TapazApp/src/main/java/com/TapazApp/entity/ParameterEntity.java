package com.TapazApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String brandOfTransport;
    String colour;
    String engineOfTransport;
    String fuelTypeOfTransport;
    String acceleratingBoxTypeOfTransport;
    String bodyTypeOfTransport;
    LocalDate creationDate;
    String marchOfTransport;
    String typeOfBuilding;
    String areaOfBuilding;
    String numberOfRoom;
    String locationOfBuilding;
    Boolean isNew;
    String city;
    Boolean parameterStatus;

    String fkStickerid;

    public ParameterEntity(String id, String brandOfTransport, String colour, String engineOfTransport, String fuelTypeOfTransport, String acceleratingBoxTypeOfTransport, String bodyTypeOfTransport, LocalDate creationDate, String marchOfTransport, String typeOfBuilding, String areaOfBuilding, String numberOfRoom, String locationOfBuilding, Boolean isNew, String city, Boolean parameterStatus, String fkStickerid) {
        this.id = id;
        this.brandOfTransport = brandOfTransport;
        this.colour = colour;
        this.engineOfTransport = engineOfTransport;
        this.fuelTypeOfTransport = fuelTypeOfTransport;
        this.acceleratingBoxTypeOfTransport = acceleratingBoxTypeOfTransport;
        this.bodyTypeOfTransport = bodyTypeOfTransport;
        this.creationDate = creationDate;
        this.marchOfTransport = marchOfTransport;
        this.typeOfBuilding = typeOfBuilding;
        this.areaOfBuilding = areaOfBuilding;
        this.numberOfRoom = numberOfRoom;
        this.locationOfBuilding = locationOfBuilding;
        this.isNew = isNew;
        this.city = city;
        this.parameterStatus = parameterStatus;
        this.fkStickerid = fkStickerid;
    }

    public ParameterEntity() {
    }
}
