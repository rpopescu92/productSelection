package com.product.selection.resource;

import com.product.selection.dto.LocationDto;
import com.product.selection.service.CustomerServiceLocationStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer-location")
public class CustomerLocationResource {

    @Autowired
    private CustomerServiceLocationStub customerServiceLocation;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public ResponseEntity getCustomerLocation(@PathVariable("customerId") String customerId) {
        LocationDto location = customerServiceLocation.getLocation(customerId);
        return new ResponseEntity(location, HttpStatus.OK);
    }
}
