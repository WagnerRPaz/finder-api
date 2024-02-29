package com.finder.finderapi.reviews;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerReviewsStatsDTO {

    private int totalReviews;
    private double averageRating;
    private List<ReviewsDTO> reviews;
}
