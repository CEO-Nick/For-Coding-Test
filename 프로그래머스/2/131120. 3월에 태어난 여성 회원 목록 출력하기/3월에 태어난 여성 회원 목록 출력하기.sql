-- 코드를 입력하세요
-- 조건: 생일이 3월 & 여성 &  전화번호 NULL이면 제외
-- 정렬: 회원ID 오름차순
select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE
where MONTH(DATE_OF_BIRTH) = 3 and GENDER = 'W' and TLNO is not null
order by MEMBER_ID;