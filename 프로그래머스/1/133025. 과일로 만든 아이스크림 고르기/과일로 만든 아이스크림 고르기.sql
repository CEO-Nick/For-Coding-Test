-- 코드를 입력하세요
-- 총주문량이 3,000보다 높음 && 아이스크림의 주 성분이 과일
-- 정렬 : 총주문량 내림차순
select f.FLAVOR 
from FIRST_HALF as f
inner join ICECREAM_INFO as i on i.FLAVOR = f.FLAVOR
where f.TOTAL_ORDER > 3000 and i.INGREDIENT_TYPE = 'fruit_based'
order by f.TOTAL_ORDER desc;
