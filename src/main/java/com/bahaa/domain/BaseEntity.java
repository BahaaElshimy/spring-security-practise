package com.bahaa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by bahaa on 20/06/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    private Long id;

    private LocalDate createdDate;

    private LocalDate modifiedDate;
}
