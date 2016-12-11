package com.product.selection.service;


import com.product.selection.dto.LocationDto;
import com.product.selection.exception.CustomerLocationException;
import com.product.selection.util.Location;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceLocationStub {

    private Map<String, Location> customerLocations;

    @PostConstruct
    public void init(){
        customerLocations = new HashMap<String,Location>();
        customerLocations.put("customer1", Location.LONDON);
        customerLocations.put("customer2", Location.LIVERPOOL);
    }

    public LocationDto getLocation(String customerId) {
        Location location = customerLocations.get(customerId);
        if(location == null){
            throw new CustomerLocationException("There was a problem in rerieving customer's location");
        }

        return LocationDto.builder().locationID(location.name()).build();
    }
}
