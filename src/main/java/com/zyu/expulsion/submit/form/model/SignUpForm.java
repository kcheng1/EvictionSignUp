package com.zyu.expulsion.submit.form.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "signup_form")
public class SignUpForm {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_datetime")
    private Date createdDatetime;

    @Column(name = "last_update_datetime")
    private Date lastUpdatedDatetime;

    @Column(name = "landlord_name")
    private String landlordName;

    @Column(name = "landlord_city")
    private String landlordCity;

    @Column(name = "landlord_state")
    private String landlordState;

    @Column(name = "landlord_zip")
    private String landlordZip;

    @Column(name = "landlord_county")
    private String landlordCounty;

    @Column(name = "landlord_telephone")
    private String landlordTelephone;

    @Column(name = "landlord_email")
    private String landLordEmail;

    @Column(name = "tenant_1")
    private String tenant1;

    @Column(name = "tenant_2")
    private String tenant2;

    @Column(name = "tenant_3")
    private String tenant3;

    @Column(name = "tenant_4")
    private String tenant4;

    @Column(name = "tenant_address")
    private String tenantAddress;

    @Column(name = "tenant_city")
    private String tenantCity;

    @Column(name = "tenant_state")
    private String tenantState;

    @Column(name = "tenant_zip")
    private String tenantZip;

    @Column(name = "tenant_county")
    private String tenantCounty;

    @Column(name = "tenant_telephone")
    private String tenantTelephone;

    @Column(name = "tenant_email")
    private String tenantEmail;
}
