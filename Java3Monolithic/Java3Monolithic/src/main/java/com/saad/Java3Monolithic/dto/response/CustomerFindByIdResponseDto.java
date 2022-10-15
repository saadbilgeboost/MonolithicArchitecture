package com.saad.Java3Monolithic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerFindByIdResponseDto {
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
