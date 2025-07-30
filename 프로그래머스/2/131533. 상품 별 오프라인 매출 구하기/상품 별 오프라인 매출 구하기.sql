-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(p.price * o.sales_amount) as SALES
from product as p
join offline_sale as o on p.product_id = o.product_id
group by p.product_id
order by SALES desc, p.product_code asc;