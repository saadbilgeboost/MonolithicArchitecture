package com.saad.Java3Monolithic.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "tblcustomer")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Customer extends Default {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String address;
    String telephone;
    int birthdate;
    String email;
    String username;
    String password;
    String state;
    String district;
    String locality;
    String street;
    String postalCode;
    String tcno;
    String birthPlace;
    String maritalStatus;
    String profession;
    String nationality;
    boolean turnOffNotification;
    boolean dontShowUpInSearches;
    boolean accountApproved;
}
