package com.shaunwah.pafday21workshop.model;

import lombok.Data;

import java.util.Optional;

@Data
public class Order {
    private int id;
    private int employeeId;
    private int customerId;
    private String orderDate;
    private String shippedDate;
    private Optional<Integer> shipperId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private String shipZipPostalCode;
    private String shipCountryRegion;
    private Double shippingFee;
    private Double taxes;
    private String paymentType;
    private String paidDate;
    private String notes;
    private Double taxRate;
    private Optional<Integer> taxStatusId;
    private Optional<Integer> statusId;
}
