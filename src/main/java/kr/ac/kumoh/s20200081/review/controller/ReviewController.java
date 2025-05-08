package kr.ac.kumoh.s20200081.review.controller;

import kr.ac.kumoh.s20200081.review.dto.ReviewRequest;
import kr.ac.kumoh.s20200081.review.dto.ReviewResponse;
import kr.ac.kumoh.s20200081.review.service.ReviewService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ReviewResponse createReview(@RequestBody ReviewRequest request) {
        return reviewService.createReview(request);
    }

    @PutMapping("/{id}")
    public ReviewResponse updateReview(@PathVariable Long id, @RequestBody ReviewRequest request) {
        return reviewService.updateReview(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id, @RequestParam Long userId) {
        reviewService.deleteReview(id, userId);
    }

    @GetMapping("/store/{storeId}")
    public List<ReviewResponse> getReviewsByStore(@PathVariable Long storeId) {
        return reviewService.getReviewsByStore(storeId);
    }
}
