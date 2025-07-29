-- 코드를 입력하세요
-- 들어올 땐 중성화 X, 나갈 땐 중성화 O
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
from ANIMAL_INS as I
inner join ANIMAL_OUTS as O on I.ANIMAL_ID = O.ANIMAL_ID
where I.SEX_UPON_INTAKE like 'Intact%' and (O.SEX_UPON_OUTCOME like 'Neutered%' or O.SEX_UPON_OUTCOME like 'Spayed%')
order by I.ANIMAL_ID;