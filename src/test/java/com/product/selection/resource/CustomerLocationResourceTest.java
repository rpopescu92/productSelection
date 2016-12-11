package com.product.selection.resource;

import com.product.selection.dto.LocationDto;
import com.product.selection.service.CustomerServiceLocationStub;
import com.product.selection.util.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerLocationResourceTest {

    @InjectMocks
    private CustomerLocationResource customerLocationResource;

    @Mock
    private CustomerServiceLocationStub customerServiceLocation;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomerLocation() {
        Mockito.when(customerServiceLocation.getLocation("customer1"))
                .thenReturn(LocationDto.builder().locationID(Location.LONDON.name()).build());

        ResponseEntity<LocationDto> responseEntity = customerLocationResource.getCustomerLocation("customer1");
        Assert.assertTrue(responseEntity.getStatusCode().equals(HttpStatus.OK));
        Assert.assertTrue(responseEntity.getBody().getLocationID().equals(Location.LONDON.name()));
    }
}
