package com.finder.finderapi.category;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping("/findAll")
    public ResponseEntity<Page<CategoryDTO>> getAllCategories(Pageable pageable){
        return ResponseEntity.ok(service.getAllCategories(pageable));
    }

    @GetMapping("/findCategoryById/{id}")
    public ResponseEntity<CategoryDTO>getCategoryById(@PathVariable Long id){
        var category = service.getCategoryById(id);
        return ResponseEntity.ok((CategoryDTO) category);
    }

}