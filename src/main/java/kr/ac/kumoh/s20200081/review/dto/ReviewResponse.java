package kr.ac.kumoh.s20200081.review.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponse {
    private Long id;
    private Long storeId;
    private Long userId;
    private String content;
    private String createdAt;
    private String updatedAt;
}