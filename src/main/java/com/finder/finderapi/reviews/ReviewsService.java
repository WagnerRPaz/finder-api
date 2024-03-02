package com.finder.finderapi.reviews;


import com.finder.finderapi.exptions.ReviewAlreadyExistsException;
import com.finder.finderapi.exptions.UserNotFoundException;
import com.finder.finderapi.exptions.WorkerNotFoundException;
import com.finder.finderapi.users.UsersEntity;
import com.finder.finderapi.users.UsersRepository;
import com.finder.finderapi.worker.WorkerEntity;
import com.finder.finderapi.worker.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository repository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private UsersRepository usersRepository;

    public void newReview(ReviewsDTO data) {
        WorkerEntity worker = workerRepository.findById(data.getWorker())
                .orElseThrow(() -> new WorkerNotFoundException("Profissional não encontrado para o ID: ", data.getWorker()));

        UsersEntity user = usersRepository.findById(data.getUser())
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado para o ID: ", data.getUser()));

        if (repository.existsByUserAndWorker(user, worker)) {
            throw new ReviewAlreadyExistsException("Este usuário já avaliou este profissional.");
        }


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
        double averageRating = calculateAverageRating(reviews);
        List<ReviewsDTO> reviewsDTOs = reviews.stream()
                .map(ReviewsEntity::entityToDto)
                .collect(Collectors.toList());

        return new WorkerReviewsStatsDTO(totalReviews, averageRating, reviewsDTOs);
    }
    private double calculateAverageRating(List<ReviewsEntity> reviews) {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double sum = reviews.stream()
                .mapToDouble(ReviewsEntity::getRating)
                .sum();
        return sum / reviews.size();
    }
}