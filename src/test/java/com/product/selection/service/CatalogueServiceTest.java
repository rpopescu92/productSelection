package com.product.selection.service;

import com.product.selection.dto.CatalogueDto;
import com.product.selection.dto.ProductsByCategoryDto;
import com.product.selection.util.Category;
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

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CatalogueServiceTest {

    @InjectMocks
    private CatalogueService catalogueService;

    @Mock
    private CustomerServiceLocationStub customerServiceLocationStub;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductsWhenLocationIsLondon() {
        CatalogueDto catalogue = catalogueService.getAvailableProducts(Location.LONDON.name());

        Assert.assertTrue(catalogue.getProductsByCategory().size() == 2);
        Assert.assertTrue(catalogue.getProductsByCategory().get(0).getProducts().size() == 2);
        Assert.assertTrue(catalogue.getProductsByCategory().get(1).getProducts().size() == 2);
        Assert.assertTrue(catalogue.getProductsByCategory().get(0).getCategory().equals(Category.NEWS));
        Assert.assertTrue(catalogue.getProductsByCategory().get(1).getCategory().equals(Category.SPORTS));
    }

    @Test
    public void testGetProductsWhenLocationIsLiverpool() {
        CatalogueDto catalogue = catalogueService.getAvailableProducts(Location.LIVERPOOL.name());

        Assert.assertTrue(catalogue.getProductsByCategory().size() == 2);
        Assert.assertTrue(catalogue.getProductsByCategory().get(1).getProducts().size() == 1);
        Assert.assertTrue(catalogue.getProductsByCategory().get(0).getCategory().equals(Category.NEWS));
        Assert.assertTrue(catalogue.getProductsByCategory().get(1).getCategory().equals(Category.SPORTS));
    }

    @Test
    public void testGetProductsWhenOtherLocation() {
        CatalogueDto catalogue = catalogueService.getAvailableProducts(Location.OTHER.name());

        Assert.assertTrue(catalogue.getProductsByCategory().size() == 1);
        Assert.assertTrue(catalogue.getProductsByCategory().get(0).getProducts().size() == 2);
    }
}
