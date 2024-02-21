package com.finder.finderapi.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public Page<CategoryDTO> getAllCategories(Pageable pageable) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),sort);

        return repository.findAll(pageableWithSort).map(CategoryEntity::entityToDto);
    }
}