package com.shaunwah.pafday21workshop.model;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer employeeId;
    private Integer customerId;
    private String orderDate;
    private String shippedDate;
    private Integer shipperId;
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
    private Integer taxStatusId;
    private Integer statusId;
}
