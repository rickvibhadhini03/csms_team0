package com.cars24.csms.controller;

import com.cars24.csms.data.req.CreateCustomerReq;
import com.cars24.csms.data.req.GetCustomerReq;
import com.cars24.csms.data.req.UpdateCustomerReq;
import com.cars24.csms.data.resp.CreateCustomerRes;
import com.cars24.csms.data.resp.GetCustomerRes;
import com.cars24.csms.data.resp.UpdateCustomerRes;
import com.cars24.csms.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping("/customer")//resource name
@Validated
@Slf4j
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService cs;
    @PostMapping("/post")
    public ResponseEntity<CreateCustomerRes> createCustomer(@Valid @RequestBody CreateCustomerReq createCustomerReq){
        log.info("[createCustomer] createCustomerReq  {}",createCustomerReq);
        CreateCustomerRes createCustomerRes = cs.createCustomer(createCustomerReq);
        return ResponseEntity.ok(createCustomerRes);
    }

    @GetMapping("/get")
    public ResponseEntity<GetCustomerRes> getCustomerByPhone(@RequestParam("phone") String phone) {
        log.info("[getCustomerByPhone] phone: {}", phone);

        // Build the request object
        GetCustomerReq getCustomerReq = new GetCustomerReq();
        getCustomerReq.setPhone(phone);

        // Call the service to fetch customer details
        GetCustomerRes getCustomerRes = cs.getCustomerReq(getCustomerReq);
        return ResponseEntity.ok(getCustomerRes);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestBody GetCustomerReq getCustomerReq) {
        log.info("[deleteCustomer] Phone: {}", getCustomerReq.getPhone());

        boolean isDeleted = cs.deleteCustomer_phone(getCustomerReq.getPhone());

        if (isDeleted) {
            return ResponseEntity.ok("Customer deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Customer not found with phone: " + getCustomerReq.getPhone());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateCustomerRes> updateCustomer(@Valid @RequestBody UpdateCustomerReq updateCustomerReq) {
        UpdateCustomerRes response = cs.updateCustomer(updateCustomerReq);
        return ResponseEntity.ok(response);
    }
}


