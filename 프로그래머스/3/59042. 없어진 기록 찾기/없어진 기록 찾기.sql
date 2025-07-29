-- 코드를 입력하세요
-- 입양 갔는데 보호소에 들어온 기록이 없는
SELECT O.ANIMAL_ID, O.NAME
from ANIMAL_OUTS as O
left join ANIMAL_INS as I on O.ANIMAL_ID = I.ANIMAL_ID
where I.ANIMAL_ID is NULL;