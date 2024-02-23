package com.finder.finderapi.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoryDTO {
    Long id;
    String name;
    String description;
}
