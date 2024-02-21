package com.finder.finderapi.worker;

import com.finder.finderapi.category.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity,Long> {
    Page<WorkerEntity> findByCategory(CategoryEntity category, Pageable pageable);
}
