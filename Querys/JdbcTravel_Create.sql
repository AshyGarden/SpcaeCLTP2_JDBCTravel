-- ���� ����
--���������Ҷ� ���̵� �տ� C## �ٿ��� ����� ���� ���� �� �ʿ��ϴ�.
ALTER SESSION SET "_ORACLE_SCRIPT" = true; 
CREATE USER jdbctravel IDENTIFIED BY travel;

-- ���� �ο�
GRANT CONNECT, RESOURCE, UNLIMITED TABLESPACE TO jdbctravel;

-- �⺻ ���̺����̽��� ���ο� ��ü(���̺�, �ε��� ��)�� ������ �� ����Ǵ� ��������,
-- �� ������ �����ϸ� ������ �߻��մϴ�.
ALTER USER jdbctravel DEFAULT TABLESPACE USERS;

-- TEMPORARY TABLESPACE�� �����̳� �ؽ� ���ΰ� ���� �۾��� ���Ǵ� �ӽ� �����Դϴ�.
ALTER USER jdbctravel TEMPORARY TABLESPACE TEMP;