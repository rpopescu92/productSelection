package com.product.selection.dto;

import com.product.selection.util.Category;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsByCategoryDto {

    private Category category;
    private List<String> products;
}
