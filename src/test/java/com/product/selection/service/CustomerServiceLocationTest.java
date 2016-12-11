package com.product.selection.service;

import com.product.selection.dto.LocationDto;
import com.product.selection.exception.CustomerLocationException;
import com.product.selection.util.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceLocationTest {

    @InjectMocks
    private CustomerServiceLocationStub customerServiceLocationStub;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.customerServiceLocationStub.init();
    }

    @Test
    public void testGetCustomerLocation() {
        LocationDto locationDtoResponse = customerServiceLocationStub.getLocation("customer2");
        Assert.assertTrue(locationDtoResponse.getLocationID().equals(Location.LIVERPOOL.name()));
    }

    @Test(expected = CustomerLocationException.class)
    public void testGetCustomerLocationWhenUnkownCustomer() {
        customerServiceLocationStub.getLocation("customerId");
    }

    @Test(expected = CustomerLocationException.class)
    public void testGetCustomerLocationWhenNoCustomer() {
        customerServiceLocationStub.getLocation(null);
    }

    @Test(expected = CustomerLocationException.class)
    public void testGetCustomerLocationWhenEmptyCustomer() {
        customerServiceLocationStub.getLocation("");
    }
}
