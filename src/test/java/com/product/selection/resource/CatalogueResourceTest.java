package com.product.selection.resource;

import com.product.selection.dto.CatalogueDto;
import com.product.selection.service.CatalogueService;
import com.product.selection.util.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CatalogueResourceTest {

    @InjectMocks
    private CatalogueResource catalogueResource;

    @Mock
    private CatalogueService catalogueService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAvailableCatalogue() {
        ResponseEntity<CatalogueDto> responseEntity = catalogueResource.getAvailableCatalogue(Location.LONDON.name());

        Assert.assertTrue(responseEntity.getStatusCode().equals(HttpStatus.OK));
    }
}
