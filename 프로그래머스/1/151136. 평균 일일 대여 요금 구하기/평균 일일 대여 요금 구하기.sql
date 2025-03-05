-- 코드를 입력하세요
select round(avg(c.DAILY_FEE), 0) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR as c
where c.CAR_TYPE = 'SUV';