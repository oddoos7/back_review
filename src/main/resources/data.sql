-- 기존 테이블 제거
DROP TABLE IF EXISTS review;

-- 리뷰 테이블 생성
CREATE TABLE review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    store_id BIGINT NOT NULL,
    username VARCHAR(255) NOT NULL,
    comment VARCHAR(1000),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 리뷰 샘플 데이터 삽입
INSERT INTO review (store_id, username, comment)
VALUES
    (1, 'userA', '정말 맛있고 친절했어요!'),
    (1, 'userB', '맛은 좋았는데 조금 늦게 나왔어요.'),
    (2, 'userC', '평범했어요.'),
    (3, 'userD', '재방문 의사 100%!'),
    (2, 'userE', '서비스가 아쉬웠어요.');

-- 확인용
SELECT * FROM review;
