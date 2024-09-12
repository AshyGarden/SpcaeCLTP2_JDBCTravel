--������Ű��
CREATE TABLE TRAVELS(
    TRAVEL_NO NUMBER PRIMARY KEY,
    TRAVEL_NAME VARCHAR2(100),
    TRAVEL_PRICE NUMBER,
    TRAVEL_DEPARTURE DATE,
    TRAVEL_ARRIVAL DATE
);

DROP TABLE TRAVELS;
-------------------------------------------------------------
--������
CREATE TABLE PLACES(
    PLACE_NO NUMBER PRIMARY KEY,
    PLACE_NAME VARCHAR2(100),
    PLACE_ARRIVAL DATE,   
    PLACE_DEPARTURE DATE,
    TRAVEL_NO NUMBER, 
    FOREIGN KEY(TRAVEL_NO) REFERENCES TRAVELS(TRAVEL_NO) ON DELETE SET NULL
);

DROP TABLE PLACES;
-------------------------------------------------------------
--���ڽü�
CREATE TABLE LODGINGS(
    LODGING_NO NUMBER PRIMARY KEY,
    LODGING_NAME VARCHAR2(100),
    LODGING_ARRIVAL DATE,
    LODGING_DEPARTURE DATE,
    PLACE_NO NUMBER,  
    FOREIGN KEY(PLACE_NO) REFERENCES PLACES(PLACE_NO) ON DELETE CASCADE
);

DROP TABLE LODGINGS;
-------------------------------------------------------------
--����
CREATE TABLE FOODS(
    FOOD_NO NUMBER PRIMARY KEY,
    FOOD_NAME VARCHAR2(100),
    PLACE_NO NUMBER,  
    FOREIGN KEY(PLACE_NO) REFERENCES PLACES(PLACE_NO) ON DELETE CASCADE
);

DROP TABLE FOODS;

-------------------------------------------------------------
--��
CREATE TABLE CUSTOMERS(
    CUSTOMER_NO NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    CUSTOMER_NAME VARCHAR2(100),
    CUSTOMER_PHONENO VARCHAR2(15),
    CUSTOMER_EMAIL VARCHAR2(100) NOT NULL
);

DROP TABLE CUSTOMERS;
-------------------------------------------------------------
--����
CREATE TABLE RESERVATIONS(
    RSV_NO NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    CUSTOMER_NO NUMBER,  
    FOREIGN KEY(CUSTOMER_NO) REFERENCES CUSTOMERS(CUSTOMER_NO) ON DELETE CASCADE, 
    TRAVEL_NO NUMBER,  
    FOREIGN KEY(TRAVEL_NO) REFERENCES TRAVELS(TRAVEL_NO)
    );

DROP TABLE RESERVATIONS;



