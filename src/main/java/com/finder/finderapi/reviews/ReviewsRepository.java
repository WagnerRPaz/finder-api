package com.finder.finderapi.reviews;

import com.finder.finderapi.users.UsersEntity;
import com.finder.finderapi.worker.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Long> {
    List<ReviewsEntity> findByWorker(WorkerEntity worker);

    boolean existsByUserAndWorker(UsersEntity user, WorkerEntity worker);
}
