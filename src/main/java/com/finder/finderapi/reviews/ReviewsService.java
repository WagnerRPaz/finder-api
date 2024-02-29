package com.finder.finderapi.reviews;


import com.finder.finderapi.exptions.WorkerNotFoundException;
import com.finder.finderapi.users.UsersEntity;
import com.finder.finderapi.users.UsersRepository;
import com.finder.finderapi.worker.WorkerEntity;
import com.finder.finderapi.worker.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository repository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private UsersRepository usersRepository;

    public void newReview(ReviewsDTO data) {
        if (data.getRating() < 1 || data.getRating() > 5) {
            throw new IllegalArgumentException("O rating deve estar entre 1 e 5.");
        }
        Optional<WorkerEntity> workerOptional = workerRepository.findById(data.getWorker());
        if (workerOptional.isEmpty()) {
            throw new WorkerNotFoundException("Trabalhador não encontrado para o ID: ", data.getWorker());
        }
        Optional<UsersEntity> userOptional = usersRepository.findById(data.getUser());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado para o ID: " + data.getUser());
        }
        WorkerEntity worker = workerOptional.get();
        UsersEntity user = userOptional.get();
        ReviewsEntity newReview = new ReviewsEntity(
                worker,
                user,
                data.getRating(),
                data.getComment()
        );
        repository.save(newReview);
    }

    public WorkerReviewsStatsDTO getWorkerReviewsStats(Long workerId) {
        WorkerEntity worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new WorkerNotFoundException("Trabalhador não encontrado para o ID: ", workerId));

        List<ReviewsEntity> reviews = repository.findByWorker(worker);

        int totalReviews = reviews.size();
        double averageRating = reviews.stream()
                .mapToInt(ReviewsEntity::getRating)
                .average()
                .orElse(0.0);

        List<ReviewsDTO> reviewDTOs = reviews.stream()
                .map(ReviewsEntity::entityToDto)
                .collect(Collectors.toList());

        return new WorkerReviewsStatsDTO(totalReviews, averageRating, reviewDTOs);
    }
}



