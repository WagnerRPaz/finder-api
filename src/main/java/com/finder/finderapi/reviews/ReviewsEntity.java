package com.finder.finderapi.reviews;

import com.finder.finderapi.users.UsersEntity;
import com.finder.finderapi.worker.WorkerEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "reviews")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity worker;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity user;

    private int rating;

    private String comment;

    public ReviewsEntity (WorkerEntity worker, UsersEntity user, int rating, String comment){
        this.worker = worker;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    public static ReviewsDTO entityToDto(ReviewsEntity entity){
        return new ReviewsDTO(entity.reviewId, entity.worker.getWorker_id(), entity.user.getUser_id(), entity.rating, entity.comment);
    }
}
