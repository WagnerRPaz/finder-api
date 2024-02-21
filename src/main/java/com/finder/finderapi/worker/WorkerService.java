package com.finder.finderapi.worker;

import com.finder.finderapi.category.CategoryEntity;
import com.finder.finderapi.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository repository;
    @Autowired
    CategoryRepository categoryRepository;
    public void workerRegister(WorkerDTO data) {
        CategoryEntity category = categoryRepository.findByName(data.categoryName);
        WorkerEntity newWorker = new WorkerEntity(
                data.full_name,
                data.birth_data,
                data.phone,
                data.email,
                category,
                data.experience
        );
        repository.save(newWorker);
    }

    public Page<WorkerDTO> getWorkerByCategory(String categoryName, Pageable pageable) {


        CategoryEntity category = categoryRepository.findByName(categoryName);
        Sort sort = Sort.by("experience").ascending();
        Pageable pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),sort);

        return repository.findByCategory(category, pageableWithSort).map(WorkerEntity::entityToDto);
    }
}
