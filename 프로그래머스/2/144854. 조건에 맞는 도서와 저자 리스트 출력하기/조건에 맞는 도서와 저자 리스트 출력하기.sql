-- 코드를 입력하세요
-- 출력: BOOK_ID, AUTHOR_NAME, PUBLISHED_DATE
-- 정렬: PUBLISHED_DATE
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM Book as b
left join author as a on b.author_id = a.author_id
where b.category = '경제'
order by b.published_date;