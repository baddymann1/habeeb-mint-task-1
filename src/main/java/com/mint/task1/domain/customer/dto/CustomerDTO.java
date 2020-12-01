package com.mint.task1.domain.customer.dto;

import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Serializable{

        private Long id;
        private String name;

        private String phoneNo;
}
