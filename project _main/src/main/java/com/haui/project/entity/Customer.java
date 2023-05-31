package com.haui.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMERTB")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;
    @Column(name = "CUSTOMER_NAME", nullable = false, length = 45)
    private String customer_name;
    @Column(name = "CUSTOMER_DATE_OF_BIRTH", length = 45)
    private String customerDateOfBirth;
    @Column(name = "CUSTOMER_IDENTITY_CARD", length = 45)
    private String customerIdentityCard;
    @Column(name = "CUSTOMER_CHECK_IN", length = 45)
    private String customerCheckIn;
    @Column(name = "CUSTOMER_CHECK_OUT", length = 45)
    private String customercheckout;
    @Column(name = "CUSTOMER_NUMBER_OF_DAY")
    private int customerNumberOfDay;
    public int daysBetween(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate date1 = LocalDate.parse(customerCheckIn, dtf);
        LocalDate date2 = LocalDate.parse(customercheckout, dtf);
        customerNumberOfDay = (int) ChronoUnit.DAYS.between(date1, date2);
        return customerNumberOfDay;
    }

    public Customer(Long customerId, String customerName){
        this.customerId = customerId;
        this.customer_name = customerName;
    }
}
