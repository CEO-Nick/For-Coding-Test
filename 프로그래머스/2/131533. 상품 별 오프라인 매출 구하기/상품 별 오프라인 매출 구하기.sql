-- 코드를 입력하세요
-- 상품 코드 별 매출액 출력
-- 정렬: 매출액 기준 DESC -> 상품코드 ASC
SELECT p.PRODUCT_CODE, (sum(sales_amount) * p.price) as SALES
from offline_sale as os 
left join product as p on os.product_id = p.product_id
group by os.product_id
order by SALES DESC, p.product_code;