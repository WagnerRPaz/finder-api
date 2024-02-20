package com.finder.finderapi.worker;

import com.finder.finderapi.category.CategoryEntity;
import com.finder.finderapi.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
