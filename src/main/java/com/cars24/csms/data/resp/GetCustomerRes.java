package com.cars24.csms.data.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerRes {


    private String name;


    private String phone ;


    private String email ;


    private String address ;
}
