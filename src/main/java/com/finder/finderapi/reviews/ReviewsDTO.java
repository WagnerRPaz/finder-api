package com.finder.finderapi.reviews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewsDTO {

    private Long reviewId;
    private Long worker;
    private Long user;
    private int rating;
    private String comment;
}
