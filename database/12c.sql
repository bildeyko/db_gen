CREATE TABLE "COMPANIES"
(
	"TIN" NUMBER(10) generated always as identity (start with 1 increment by 1) primary key,
	"NAME" VARCHAR2(255) NOT NULL,
	"POSTCODE" NUMBER(8) NOT NULL,
	"ADDRESS" VARCHAR2(255) NOT NULL
)
;
CREATE TABLE "UNITS"
(
	"UNIT_ID" NUMBER(5) generated always as identity (start with 1 increment by 1) primary key,
	"NAME" VARCHAR2(255) NOT NULL,
	"SHORT_NAME" VARCHAR2(50) NULL
)
;
CREATE TABLE "PRODUCT_TYPES"
(
	"TYPE_ID" NUMBER(5) generated always as identity (start with 1 increment by 1) primary key,
	"NAME" VARCHAR2(255) NOT NULL,
	"UNITS" NUMBER(5) NOT NULL REFERENCES "UNITS" ("UNIT_ID")
)
;
CREATE TABLE "PRODUCTS"
(
	"PRODUCT_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"BARCODE" NUMBER(13) NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL,
	"TYPE" NUMBER(5) NOT NULL REFERENCES "PRODUCT_TYPES" ("TYPE_ID")
)
;
CREATE TABLE "PRODUCT_ITEMS"
(
	"PRODITEM_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"TIN" NUMBER(10) NOT NULL REFERENCES "COMPANIES" ("TIN"),
	"PRODUCT_ID" NUMBER(8) NOT NULL REFERENCES "PRODUCTS" ("PRODUCT_ID"),
	"SHELF_LIFE" DATE NULL,
	"QUANTITY" NUMBER(8,2) NULL,
	"PRICE" NUMBER(8,2) NULL
)
;
CREATE TABLE "PEOPLE"
(
	"PERSON_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"NAME" VARCHAR2(255) NOT NULL,
	"SURNAME" VARCHAR2(255) NOT NULL,
	"DOB" DATE NULL
)
;
CREATE TABLE "EMAIL"
(
	"EMAIL_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"PERSON_ID" NUMBER(8) NOT NULL REFERENCES "PEOPLE" ("PERSON_ID"),
	"EMAIL" VARCHAR2(255) NOT NULL
)
;
CREATE TABLE "PHONES"
(
	"PHONE_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"PERSON_ID" NUMBER(8) NOT NULL REFERENCES "PEOPLE" ("PERSON_ID"),
	"PHONE" VARCHAR2(50) NOT NULL
)
;
CREATE TABLE "CUSTOMERS"
(
	"CUSTOMER_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"PERSON_ID" NUMBER(8) NOT NULL REFERENCES "PEOPLE" ("PERSON_ID"),
	"POSTCODE" NUMBER(8) NOT NULL,
	"ADDRESS" VARCHAR2(255) NULL
)
;
CREATE TABLE "POSITION_TYPES"
(
	"POSITION_TYPE_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"PERCENT" NUMBER(3,2) NOT NULL,
	"NAME" VARCHAR2(255) NOT NULL
)
;
CREATE TABLE "STAFF"
(
	"STAFF_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"PERSON_ID" NUMBER(8) NOT NULL REFERENCES "PEOPLE" ("PERSON_ID"),
	"SNILS" NUMBER(11) NOT NULL
)
;
CREATE TABLE "POSITIONS"
(
	"POSITION_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"STAFF_ID" NUMBER(8) NOT NULL REFERENCES "STAFF" ("STAFF_ID"),
	"POSITION_TYPE_ID" NUMBER(8) NOT NULL REFERENCES "POSITION_TYPES" ("POSITION_TYPE_ID"),
	"START_TIME" DATE NOT NULL,
	"END_TIME" DATE NULL
)
;
CREATE TABLE "CONTRACTS"
(
	"CONTRACT_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"CUSTOMER_ID" NUMBER(8) NOT NULL REFERENCES "CUSTOMERS" ("CUSTOMER_ID"),
	"BROKER_ID" NUMBER(8) NOT NULL REFERENCES "STAFF" ("STAFF_ID"),
	"START_TIME" DATE NOT NULL,
	"END_TIME" DATE NOT NULL,
	"LIMIT_PER_AUCTION" NUMBER(8,2) NOT NULL
)
;
CREATE TABLE "BATCHES"
(
	"BATCH_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"STAFF_ID" NUMBER(8) NOT NULL REFERENCES "STAFF" ("STAFF_ID"),
	"TYPE_ID" NUMBER(5) NOT NULL REFERENCES "PRODUCT_TYPES" ("TYPE_ID"),
	"BUILD_DATE" DATE NOT NULL
)
;
CREATE TABLE "AUCTIONS"
(
	"AUCTION_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"BATCH_ID" NUMBER(8) NOT NULL REFERENCES "BATCHES" ("BATCH_ID"),
	"START_TIME" DATE NOT NULL,
	"END_TIME" DATE NOT NULL
)
;
CREATE TABLE "BETS"
(
	"BET_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"AUCTION_ID" NUMBER(8) NOT NULL REFERENCES "AUCTIONS" ("AUCTION_ID"),
	"CONTRACT_ID" NUMBER(8) NOT NULL REFERENCES "CONTRACTS" ("CONTRACT_ID"),
	"BET" NUMBER(8,2) NOT NULL,
	"TIME" DATE NOT NULL
)
;
CREATE TABLE "STATES"
(
	"STATE_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"NAME" VARCHAR2(255) NOT NULL
)
;
CREATE TABLE "DELIVERY"
(
	"DELIVERY_ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"DELIVERYMAN_ID" NUMBER(8) NOT NULL REFERENCES "STAFF" ("STAFF_ID"),
	"AUCTION_ID" NUMBER(8) NOT NULL REFERENCES "AUCTIONS" ("AUCTION_ID"),
	"STATE_ID" NUMBER(8) NOT NULL REFERENCES "STATES" ("STATE_ID"),
	"DATE" DATE NOT NULL,
	"ACTUAL_DATE" DATE NULL
)
;
CREATE TABLE "BATCH_ITEMS"
(
	"ID" NUMBER(8) generated always as identity (start with 1 increment by 1) primary key,
	"PRODITEM_ID" NUMBER(8) NOT NULL REFERENCES "PRODUCT_ITEMS" ("PRODITEM_ID"),
	"BATCH_ID" NUMBER(8) NOT NULL REFERENCES "BATCHES" ("BATCH_ID"),
	"QUANTITY" NUMBER(8,2) NOT NULL
)
;