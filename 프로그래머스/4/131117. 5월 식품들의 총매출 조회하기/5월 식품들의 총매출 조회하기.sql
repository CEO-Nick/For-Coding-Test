-- 코드를 입력하세요
-- 조건: 생산일자 2022 05
-- 출력: product_id, product_name, 총매출
-- 정렬: 총매출 desc, product_id asc

SELECT p.PRODUCT_ID, p.PRODUCT_NAME, sum(p.price * o.amount) as TOTAL_SALES
from food_product as p
join food_order as o on p.product_id = o.product_id
where year(o.PRODUCE_DATE) = 2022 and month(o.PRODUCE_DATE) = 5
group by p.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID ASC
;