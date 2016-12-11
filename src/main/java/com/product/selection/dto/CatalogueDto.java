package com.product.selection.dto;

import lombok.*;

import java.util.List;

/**
 * Created by roxana on 11.12.2016.
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CatalogueDto {

    private List<ProductsByCategoryDto> productsByCategory;

}
