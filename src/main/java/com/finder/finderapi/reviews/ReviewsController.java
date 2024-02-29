package com.finder.finderapi.reviews;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewsController {
    @Autowired
    private final ReviewsService service;

    @PostMapping("/newReview")
    public ResponseEntity<?> newReview(@RequestBody @Valid ReviewsDTO data) {
        service.newReview(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{workerId}/reviews")
    public ResponseEntity<WorkerReviewsStatsDTO> getWorkerReviewsStats(@PathVariable Long workerId) {
        WorkerReviewsStatsDTO stats = service.getWorkerReviewsStats(workerId);
        return ResponseEntity.ok(stats);
    }
}