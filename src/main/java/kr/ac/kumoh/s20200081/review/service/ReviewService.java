package kr.ac.kumoh.s20200081.review.service;

import kr.ac.kumoh.s20200081.review.dto.ReviewRequest;
import kr.ac.kumoh.s20200081.review.dto.ReviewResponse;
import kr.ac.kumoh.s20200081.review.model.Review;
import kr.ac.kumoh.s20200081.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewResponse createReview(ReviewRequest request) {
        Review review = Review.builder()
                .storeId(request.getStoreId())
                .userId(request.getUserId())
                .content(request.getContent())
                .createdAt(now())
                .updatedAt(now())
                .build();

        Review saved = reviewRepository.save(review);
        return toResponse(saved);
    }

    public void deleteReview(Long id, Long userId) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        if (!review.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized deletion");
        }
        reviewRepository.deleteById(id);
    }

    public ReviewResponse updateReview(Long id, ReviewRequest request) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setContent(request.getContent());
        review.setUpdatedAt(now());
        Review saved = reviewRepository.save(review);

        return toResponse(saved);
    }

    public List<ReviewResponse> getReviewsByStore(Long storeId) {
        return reviewRepository.findByStoreId(storeId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ReviewResponse toResponse(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .storeId(review.getStoreId())
                .userId(review.getUserId())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}