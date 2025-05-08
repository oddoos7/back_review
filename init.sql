-- Review 엔티티 참고용 주석 (실제 DB에 영향 없음)
--
-- @Entity
-- @Table(name = "review")
-- @Getter
-- @Setter
-- @NoArgsConstructor
-- @AllArgsConstructor
-- @Builder
-- public class Review {
--     @Id
--     @GeneratedValue(strategy = GenerationType.IDENTITY)
--     private Long id;
--
--     @ManyToOne
--     @JoinColumn(name = "store_id", nullable = false)
--     private Store store;
--
--     private String username;
--     private String comment;
--     private LocalDateTime createdAt;
-- }

-- 테이블 생성
CREATE TABLE review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    store_id BIGINT NOT NULL,
    username VARCHAR(255) NOT NULL,
    comment VARCHAR(1000),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 초기 리뷰 데이터 삽입
INSERT INTO review (store_id, username, comment)
VALUES
    (1, 'userA', '정말 맛있고 친절했어요!'),
    (1, 'userB', '맛은 좋았는데 조금 늦게 나왔어요.'),
    (2, 'userC', '평범했어요.'),
    (3, 'userD', '재방문 의사 100%!'),
    (2, 'userE', '서비스가 아쉬웠어요.');
