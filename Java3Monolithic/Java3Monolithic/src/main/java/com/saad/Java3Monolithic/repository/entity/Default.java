package com.saad.Java3Monolithic.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Default {
    boolean isactive;
    Long createdate;
    Long updatedate;
}
