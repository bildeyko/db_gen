DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_POSITIONS_POSITION_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_POSITIONS_POSITION_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_POSITIONS_POSITION_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_POSITIONS_POSITION_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_EMAIL_EMAIL_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_EMAIL_EMAIL_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_EMAIL_EMAIL_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_EMAIL_EMAIL_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_PHONES_PHONE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_PHONES_PHONE_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_PHONES_PHONE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_PHONES_PHONE_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_PEOPLE_PERSON_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_PEOPLE_PERSON_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_PEOPLE_PERSON_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_PEOPLE_PERSON_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_PRODUCT_ITEMS_PRODITEM_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_PRODUCT_ITEMS_PRODITEM_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_PRODUCT_ITEMS_PRODITEM_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_PRODUCT_ITEMS_PRODITEM_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_PRODUCT_TYPES_TYPE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_PRODUCT_TYPES_TYPE_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_PRODUCT_TYPES_TYPE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_PRODUCT_TYPES_TYPE_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_CONTRACTS_CONTRACT_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_CONTRACTS_CONTRACT_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_CONTRACTS_CONTRACT_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_CONTRACTS_CONTRACT_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_STATES_STATE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_STATES_STATE_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_STATES_STATE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_STATES_STATE_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_DELIVERY_DELIVERY_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_DELIVERY_DELIVERY_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_DELIVERY_DELIVERY_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_DELIVERY_DELIVERY_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_CUSTOMERS_CUSTOMER_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_CUSTOMERS_CUSTOMER_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_CUSTOMERS_CUSTOMER_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_CUSTOMERS_CUSTOMER_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_BETS_BET_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_BETS_BET_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_BETS_BET_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_BETS_BET_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_POSITION_TYPES_POS_TYPE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_POSITION_TYPES_POS_TYPE_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_POSITION_TYPES_POS_TYPE_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_POSITION_TYPES_POS_TYPE_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_AUCTIONS_AUCTION_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_AUCTIONS_AUCTION_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_AUCTIONS_AUCTION_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_AUCTIONS_AUCTION_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_STAFF_STAFF_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_STAFF_STAFF_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_STAFF_STAFF_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_STAFF_STAFF_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_UNITS_UNIT_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_UNITS_UNIT_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_UNITS_UNIT_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_UNITS_UNIT_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_BATCH_ITEMS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_BATCH_ITEMS_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_BATCH_ITEMS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_BATCH_ITEMS_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_BATCHES_BATCH_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_BATCHES_BATCH_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_BATCHES_BATCH_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_BATCHES_BATCH_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_PRODUCTS_PRODUCT_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_PRODUCTS_PRODUCT_ID"'; 
END IF; 
END; 
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_PRODUCTS_PRODUCT_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_PRODUCTS_PRODUCT_ID"'; 
END IF; 
END; 
/

DROP TABLE "POSITIONS" CASCADE CONSTRAINTS
;

DROP TABLE "EMAIL" CASCADE CONSTRAINTS
;

DROP TABLE "PHONES" CASCADE CONSTRAINTS
;

DROP TABLE "PEOPLE" CASCADE CONSTRAINTS
;

DROP TABLE "PRODUCT_ITEMS" CASCADE CONSTRAINTS
;

DROP TABLE "PRODUCT_TYPES" CASCADE CONSTRAINTS
;

DROP TABLE "CONTRACTS" CASCADE CONSTRAINTS
;

DROP TABLE "STATES" CASCADE CONSTRAINTS
;

DROP TABLE "DELIVERY" CASCADE CONSTRAINTS
;

DROP TABLE "CUSTOMERS" CASCADE CONSTRAINTS
;

DROP TABLE "BETS" CASCADE CONSTRAINTS
;

DROP TABLE "POSITION_TYPES" CASCADE CONSTRAINTS
;

DROP TABLE "AUCTIONS" CASCADE CONSTRAINTS
;

DROP TABLE "STAFF" CASCADE CONSTRAINTS
;

DROP TABLE "UNITS" CASCADE CONSTRAINTS
;

DROP TABLE "BATCH_ITEMS" CASCADE CONSTRAINTS
;

DROP TABLE "BATCHES" CASCADE CONSTRAINTS
;

DROP TABLE "PRODUCTS" CASCADE CONSTRAINTS
;

DROP TABLE "COMPANIES" CASCADE CONSTRAINTS
;

CREATE TABLE "POSITIONS"
(
	"POSITION_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"STAFF_ID" NUMBER(8) NOT NULL,
	"POSITION_TYPE_ID" NUMBER(8) NOT NULL,
	"START_TIME" DATE NOT NULL,
	"END_TIME" DATE NULL
)
;

CREATE TABLE "EMAIL"
(
	"EMAIL_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"PERSON_ID" NUMBER(8) NOT NULL,
	"EMAIL" VARCHAR2(255) NOT NULL
)
;

CREATE TABLE "PHONES"
(
	"PHONE_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"PERSON_ID" NUMBER(8) NOT NULL,
	"PHONE" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "PEOPLE"
(
	"PERSON_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL,
	"SURNAME" VARCHAR2(255) NOT NULL,
	"DOB" DATE NULL
)
;

CREATE TABLE "PRODUCT_ITEMS"
(
	"PRODITEM_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"TIN" NUMBER(10) NOT NULL,
	"PRODUCT_ID" NUMBER(8) NOT NULL,
	"SHELF_LIFE" DATE NULL,
	"QUANTITY" NUMBER(8,2) NULL,
	"PRICE" NUMBER(8,2) NULL
)
;

CREATE TABLE "PRODUCT_TYPES"
(
	"TYPE_ID" NUMBER(5) PRIMARY KEY NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL,
	"UNITS" NUMBER(5) NOT NULL
)
;

CREATE TABLE "CONTRACTS"
(
	"CONTRACT_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"CUSTOMER_ID" NUMBER(8) NOT NULL,
	"BROKER_ID" NUMBER(8) NOT NULL,
	"START_TIME" DATE NOT NULL,
	"END_TIME" DATE NOT NULL,
	"LIMIT_PER_AUCTION" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "STATES"
(
	"STATE_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL
)
;

CREATE TABLE "DELIVERY"
(
	"DELIVERY_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"DELIVERYMAN_ID" NUMBER(8) NOT NULL,
	"AUCTION_ID" NUMBER(8) NOT NULL,
	"STATE_ID" NUMBER(8) NOT NULL,
	"DATE" DATE NOT NULL,
	"ACTUAL_DATE" DATE NULL
)
;

CREATE TABLE "CUSTOMERS"
(
	"CUSTOMER_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"PERSON_ID" NUMBER(8) NOT NULL,
	"POSTCODE" NUMBER(8) NOT NULL,
	"ADDRESS" VARCHAR2(255) NULL
)
;

CREATE TABLE "BETS"
(
	"BET_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"AUCTION_ID" NUMBER(8) NOT NULL,
	"CONTRACT_ID" NUMBER(8) NOT NULL,
	"BET" NUMBER(8,2) NOT NULL,
	"TIME" DATE NOT NULL
)
;

CREATE TABLE "POSITION_TYPES"
(
	"POSITION_TYPE_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"PERCENT" NUMBER(3,2) NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL
)
;

CREATE TABLE "AUCTIONS"
(
	"AUCTION_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"BATCH_ID" NUMBER(8) NOT NULL,
	"START_TIME" DATE NOT NULL,
	"END_TIME" DATE NOT NULL
)
;

CREATE TABLE "STAFF"
(
	"STAFF_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"PERSON_ID" NUMBER(8) NOT NULL,
	"SNILS" NUMBER(11) NOT NULL
)
;

CREATE TABLE "UNITS"
(
	"UNIT_ID" NUMBER(5) PRIMARY KEY NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL,
	"SHORT_NAME" VARCHAR2(50) NULL
)
;

CREATE TABLE "BATCH_ITEMS"
(
	"ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"PRODITEM_ID" NUMBER(8) NOT NULL,
	"BATCH_ID" NUMBER(8) NOT NULL,
	"QUANTITY" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "BATCHES"
(
	"BATCH_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"STAFF_ID" NUMBER(8) NOT NULL,
	"TYPE_ID" NUMBER(5) NOT NULL,
	"BUILD_DATE" DATE NOT NULL
)
;

CREATE TABLE "PRODUCTS"
(
	"PRODUCT_ID" NUMBER(8) PRIMARY KEY NOT NULL,
	"BARCODE" NUMBER(13) NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL,
	"TYPE" NUMBER(5) NOT NULL
)
;

CREATE TABLE "COMPANIES"
(
	"TIN" NUMBER(10) PRIMARY KEY NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL,
	"POSTCODE" NUMBER(8) NOT NULL,
	"ADDRESS" VARCHAR2(255) NOT NULL
)
;

CREATE SEQUENCE "SEQ_POSITIONS_POSITION_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_POSITIONS_POSITION_ID" 
	BEFORE INSERT 
	ON "POSITIONS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_POSITIONS_POSITION_ID".NEXTVAL 
		INTO :NEW."POSITION_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_EMAIL_EMAIL_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_EMAIL_EMAIL_ID" 
	BEFORE INSERT 
	ON "EMAIL" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_EMAIL_EMAIL_ID".NEXTVAL 
		INTO :NEW."EMAIL_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_PHONES_PHONE_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_PHONES_PHONE_ID" 
	BEFORE INSERT 
	ON "PHONES" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_PHONES_PHONE_ID".NEXTVAL 
		INTO :NEW."PHONE_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_PEOPLE_PERSON_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_PEOPLE_PERSON_ID" 
	BEFORE INSERT 
	ON "PEOPLE" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_PEOPLE_PERSON_ID".NEXTVAL 
		INTO :NEW."PERSON_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_PRODUCT_ITEMS_PRODITEM_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_PRODUCT_ITEMS_PRODITEM_ID" 
	BEFORE INSERT 
	ON "PRODUCT_ITEMS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_PRODUCT_ITEMS_PRODITEM_ID".NEXTVAL 
		INTO :NEW."PRODITEM_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_PRODUCT_TYPES_TYPE_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_PRODUCT_TYPES_TYPE_ID" 
	BEFORE INSERT 
	ON "PRODUCT_TYPES" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_PRODUCT_TYPES_TYPE_ID".NEXTVAL 
		INTO :NEW."TYPE_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_CONTRACTS_CONTRACT_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_CONTRACTS_CONTRACT_ID" 
	BEFORE INSERT 
	ON "CONTRACTS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_CONTRACTS_CONTRACT_ID".NEXTVAL 
		INTO :NEW."CONTRACT_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_STATES_STATE_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_STATES_STATE_ID" 
	BEFORE INSERT 
	ON "STATES" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_STATES_STATE_ID".NEXTVAL 
		INTO :NEW."STATE_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_DELIVERY_DELIVERY_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_DELIVERY_DELIVERY_ID" 
	BEFORE INSERT 
	ON "DELIVERY" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_DELIVERY_DELIVERY_ID".NEXTVAL 
		INTO :NEW."DELIVERY_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_CUSTOMERS_CUSTOMER_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_CUSTOMERS_CUSTOMER_ID" 
	BEFORE INSERT 
	ON "CUSTOMERS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_CUSTOMERS_CUSTOMER_ID".NEXTVAL 
		INTO :NEW."CUSTOMER_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_BETS_BET_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_BETS_BET_ID" 
	BEFORE INSERT 
	ON "BETS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_BETS_BET_ID".NEXTVAL 
		INTO :NEW."BET_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_POSITION_TYPES_POS_TYPE_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_POSITION_TYPES_POS_TYPE_ID" 
	BEFORE INSERT 
	ON "POSITION_TYPES" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_POSITION_TYPES_POS_TYPE_ID".NEXTVAL 
		INTO :NEW."POSITION_TYPE_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_AUCTIONS_AUCTION_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_AUCTIONS_AUCTION_ID" 
	BEFORE INSERT 
	ON "AUCTIONS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_AUCTIONS_AUCTION_ID".NEXTVAL 
		INTO :NEW."AUCTION_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_STAFF_STAFF_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_STAFF_STAFF_ID" 
	BEFORE INSERT 
	ON "STAFF" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_STAFF_STAFF_ID".NEXTVAL 
		INTO :NEW."STAFF_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_UNITS_UNIT_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_UNITS_UNIT_ID" 
	BEFORE INSERT 
	ON "UNITS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_UNITS_UNIT_ID".NEXTVAL 
		INTO :NEW."UNIT_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_BATCH_ITEMS_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_BATCH_ITEMS_ID" 
	BEFORE INSERT 
	ON "BATCH_ITEMS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_BATCH_ITEMS_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_BATCHES_BATCH_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_BATCHES_BATCH_ID" 
	BEFORE INSERT 
	ON "BATCHES" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_BATCHES_BATCH_ID".NEXTVAL 
		INTO :NEW."BATCH_ID" 
		FROM DUAL; 
	END;
/


CREATE SEQUENCE "SEQ_PRODUCTS_PRODUCT_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_PRODUCTS_PRODUCT_ID" 
	BEFORE INSERT 
	ON "PRODUCTS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_PRODUCTS_PRODUCT_ID".NEXTVAL 
		INTO :NEW."PRODUCT_ID" 
		FROM DUAL; 
	END;
/

ALTER TABLE "POSITIONS" 
 ADD CONSTRAINT "FK_POSITIONS_POSITION_TYPES"
	FOREIGN KEY ("POSITION_TYPE_ID") REFERENCES "POSITION_TYPES" ("POSITION_TYPE_ID")
;

ALTER TABLE "POSITIONS" 
 ADD CONSTRAINT "FK_POSITIONS_STAFF"
	FOREIGN KEY ("STAFF_ID") REFERENCES "STAFF" ("STAFF_ID")
;

ALTER TABLE "EMAIL" 
 ADD CONSTRAINT "FK_EMAIL_PEOPLE"
	FOREIGN KEY ("PERSON_ID") REFERENCES "PEOPLE" ("PERSON_ID")
;

ALTER TABLE "PHONES" 
 ADD CONSTRAINT "FK_PHONES_PEOPLE"
	FOREIGN KEY ("PERSON_ID") REFERENCES "PEOPLE" ("PERSON_ID")
;

ALTER TABLE "PRODUCT_ITEMS" 
 ADD CONSTRAINT "FK_PRODUCT_ITEMS_COMPANIES"
	FOREIGN KEY ("TIN") REFERENCES "COMPANIES" ("TIN")
;

ALTER TABLE "PRODUCT_ITEMS" 
 ADD CONSTRAINT "FK_PRODUCT_ITEMS_PRODUCTS"
	FOREIGN KEY ("PRODUCT_ID") REFERENCES "PRODUCTS" ("PRODUCT_ID")
;

ALTER TABLE "PRODUCT_TYPES" 
 ADD CONSTRAINT "FK_PRODUCT_TYPES_UNITS"
	FOREIGN KEY ("UNITS") REFERENCES "UNITS" ("UNIT_ID")
;

ALTER TABLE "CONTRACTS" 
 ADD CONSTRAINT "FK_CONTRACTS_STAFF"
	FOREIGN KEY ("BROKER_ID") REFERENCES "STAFF" ("STAFF_ID")
;

ALTER TABLE "CONTRACTS" 
 ADD CONSTRAINT "FK_CONTRACTS_CUSTOMERS"
	FOREIGN KEY ("CUSTOMER_ID") REFERENCES "CUSTOMERS" ("CUSTOMER_ID")
;

ALTER TABLE "DELIVERY" 
 ADD CONSTRAINT "FK_DELIVERY_STAFF"
	FOREIGN KEY ("DELIVERYMAN_ID") REFERENCES "STAFF" ("STAFF_ID")
;

ALTER TABLE "DELIVERY" 
 ADD CONSTRAINT "FK_DELIVERY_AUCTIONS"
	FOREIGN KEY ("AUCTION_ID") REFERENCES "AUCTIONS" ("AUCTION_ID")
;

ALTER TABLE "DELIVERY" 
 ADD CONSTRAINT "FK_DELIVERY_STATES"
	FOREIGN KEY ("STATE_ID") REFERENCES "STATES" ("STATE_ID")
;

ALTER TABLE "CUSTOMERS" 
 ADD CONSTRAINT "FK_CUSTOMERS_PEOPLE"
	FOREIGN KEY ("PERSON_ID") REFERENCES "PEOPLE" ("PERSON_ID")
;

ALTER TABLE "BETS" 
 ADD CONSTRAINT "FK_BETS_AUCTIONS"
	FOREIGN KEY ("AUCTION_ID") REFERENCES "AUCTIONS" ("AUCTION_ID")
;

ALTER TABLE "BETS" 
 ADD CONSTRAINT "FK_BETS_CONTRACTS"
	FOREIGN KEY ("CONTRACT_ID") REFERENCES "CONTRACTS" ("CONTRACT_ID")
;

ALTER TABLE "AUCTIONS" 
 ADD CONSTRAINT "FK_AUCTIONS_BATCHES"
	FOREIGN KEY ("BATCH_ID") REFERENCES "BATCHES" ("BATCH_ID")
;

ALTER TABLE "STAFF" 
 ADD CONSTRAINT "FK_STAFF_PEOPLE"
	FOREIGN KEY ("PERSON_ID") REFERENCES "PEOPLE" ("PERSON_ID")
;

ALTER TABLE "BATCH_ITEMS" 
 ADD CONSTRAINT "FK_BATCH_ITEMS_BATCHES"
	FOREIGN KEY ("BATCH_ID") REFERENCES "BATCHES" ("BATCH_ID")
;

ALTER TABLE "BATCH_ITEMS" 
 ADD CONSTRAINT "FK_BATCH_ITEMS_PRODUCT_ITEMS"
	FOREIGN KEY ("PRODITEM_ID") REFERENCES "PRODUCT_ITEMS" ("PRODITEM_ID")
;

ALTER TABLE "BATCHES" 
 ADD CONSTRAINT "FK_BATCHES_PRODUCT_TYPES"
	FOREIGN KEY ("TYPE_ID") REFERENCES "PRODUCT_TYPES" ("TYPE_ID")
;

ALTER TABLE "BATCHES" 
 ADD CONSTRAINT "FK_BATCHES_STAFF"
	FOREIGN KEY ("STAFF_ID") REFERENCES "STAFF" ("STAFF_ID")
;

ALTER TABLE "PRODUCTS" 
 ADD CONSTRAINT "FK_PRODUCTS_PRODUCT_TYPES"
	FOREIGN KEY ("TYPE") REFERENCES "PRODUCT_TYPES" ("TYPE_ID")
;
