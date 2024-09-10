-- 계정 생성
--계정생성할때 아이디 앞에 C## 붙여서 만들고 싶지 않을 때 필요하다.
ALTER SESSION SET "_ORACLE_SCRIPT" = true; 
CREATE USER jdbctravel IDENTIFIED BY travel;

-- 권한 부여
GRANT CONNECT, RESOURCE, UNLIMITED TABLESPACE TO jdbctravel;

-- 기본 테이블스페이스는 새로운 객체(테이블, 인덱스 등)가 생성될 때 저장되는 공간으로,
-- 이 공간이 부족하면 오류가 발생합니다.
ALTER USER jdbctravel DEFAULT TABLESPACE USERS;

-- TEMPORARY TABLESPACE는 정렬이나 해시 조인과 같은 작업에 사용되는 임시 공간입니다.
ALTER USER jdbctravel TEMPORARY TABLESPACE TEMP;