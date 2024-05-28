package com.nomii.springbatch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean appliedForRegistration;
    private String vrn;
    private String engineNumber;
    private String chassisNumber;
    private BigDecimal sumInsured;
    private String coiTypeCode;
    private String vehicleColor;
    private String regProvinceCode;
    private String manufactureYear;
    private String keeperName;
    private String keeperCNIC;
    private String accessoryName;
    private BigDecimal accessoryValue;
    private String bodyTypeCode;
    private Short passengerCapacity;
    private String cubicCapacity;
    private String modelCode;
    private Boolean trackerInstalled;
    private String trackerInstalledType;
    private String trackerTypeCode;
    private String serialNumber;
    private BigDecimal trackerCost;
    private String trackerRegisteredOwner;
}
