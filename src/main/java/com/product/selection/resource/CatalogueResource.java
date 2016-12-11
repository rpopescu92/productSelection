package com.product.selection.resource;

import com.product.selection.dto.CatalogueDto;
import com.product.selection.dto.LocationDto;
import com.product.selection.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueResource {

    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping(value = "{locationId}", method = RequestMethod.GET)
    public ResponseEntity getAvailableCatalogue(@PathVariable("locationId") String locationId) {
        CatalogueDto catalogue = catalogueService.getAvailableProducts(locationId);

        return new ResponseEntity(catalogue, HttpStatus.OK);
    }
}
