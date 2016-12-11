package com.product.selection.service;

import com.product.selection.dto.CatalogueDto;
import com.product.selection.dto.ProductsByCategoryDto;
import com.product.selection.util.Category;
import com.product.selection.util.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CatalogueService {

    private List<String> products = Arrays.asList("Sky News", "Sky Sports News");

    public CatalogueDto getAvailableProducts(String locationId) {
        Location location = Location.valueOf(locationId);
        return CatalogueDto.builder().productsByCategory(getProductsByCategoryAndLocation(location)).build();

    }

    private List<ProductsByCategoryDto> getProductsByCategoryAndLocation(Location location) {
        List<ProductsByCategoryDto> productsByCategory = new ArrayList<>();
        if(location.equals(Location.OTHER)) {
            productsByCategory.add(ProductsByCategoryDto.builder().category(Category.NEWS).products(products).build());
        } else {
            productsByCategory.add(ProductsByCategoryDto.builder().category(Category.NEWS).products(products).build());
            productsByCategory.add(ProductsByCategoryDto.builder().category(Category.SPORTS).products(getProductsByLocation(location)).build());
        }
        return productsByCategory;
    }

    private List<String> getProductsByLocation(Location location) {
        List<String> productsByLocation = new ArrayList<>();
        switch (location) {
            case LONDON:
                productsByLocation.add("Arsenal TV");
                productsByLocation.add("Chelsea TV");
                break;
            case LIVERPOOL:
                productsByLocation.add("LIVERPOOL TV");
        }
        return productsByLocation;
    }
}
