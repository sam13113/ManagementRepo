USE `portfolio_manager`;

INSERT INTO USER_ROLE(ID, NAME, DESCRIPTION, PRIORITY, ACTIVE) 
VALUES (1, 'ADMIN', 'ADMIN', 1, True);
INSERT INTO USER_ROLE(ID, NAME, DESCRIPTION, PRIORITY, ACTIVE) 
VALUES (2, 'MANAGER', 'MANAGER', 2, True);
INSERT INTO USER_ROLE(ID, NAME, DESCRIPTION, PRIORITY, ACTIVE) 
VALUES (3, 'USER', 'USER', 3, True);

INSERT INTO USER(ID, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) 
VALUES (1, 'Admin', 'Admin', 'admin', 'password@123');
INSERT INTO USER(ID, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) 
VALUES (2, 'Service', 'owner', 'ownerIT', 'password@123');
INSERT INTO USER(ID, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) 
VALUES (3, 'Service', 'owner', 'OwnerBusiness', 'password@123');
INSERT INTO USER(ID, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) 
VALUES (4, 'Service', 'Manager', 'Manager', 'password@123');

INSERT INTO USER_ROLE_MAP( USER_ID, USER_ROLE_ID) 
VALUES ( 1, 1);
INSERT INTO USER_ROLE_MAP( USER_ID, USER_ROLE_ID) 
VALUES ( 2, 1);
INSERT INTO USER_ROLE_MAP( USER_ID, USER_ROLE_ID) 
VALUES ( 3, 1);
INSERT INTO USER_ROLE_MAP( USER_ID, USER_ROLE_ID) 
VALUES ( 4, 2);

INSERT INTO USER_CONTACT(ID, EMAIL, PHONE_NUMBER, USER_ID) 
VALUES (1, 'user1@test.com', '00123456789', 1);
INSERT INTO USER_CONTACT(ID, EMAIL, PHONE_NUMBER, USER_ID) 
VALUES (2, 'ownerIT@test.com', '00123456789', 2);
INSERT INTO USER_CONTACT(ID, EMAIL, PHONE_NUMBER, USER_ID) 
VALUES (3, 'OwnerBsinerss@test.com', '00123456789', 3);
INSERT INTO USER_CONTACT(ID, EMAIL, PHONE_NUMBER, USER_ID) 
VALUES (4, 'manager@test.com', '00123456789', 4);

INSERT INTO PROJECT(ID, PRJ_NAME, DEPARTMENT, BUSINESS_WEIGHTAGE, 
DEVELOPMENT_METHODOLOGY, PRJ_DESCRIPTION, SERVICE_OWNER_IT_ID, 
SERVICE_OWNER_BUSINESS_ID, SERVICE_MANAGER_ID, PORTFOLIO_ID) VALUES 
(1, 'Prjct1', 'XYZ01BC', 60, 'Scrum', 
'Some gibberish about how the project works.', 2, 3, 4, 1);

INSERT INTO KPI(ID, KPI_NAME, KPI_DESCRIPTION, THRESHOLD_MAX, THRESHOLD_MIN, 
BUSINESS_WEIGHTAGE, PROJECT_ID) 
VALUES (1, 'OnTimeDeliveryIndex', 'Delivering within the release plan', 
90, 70, 80, 1);

INSERT INTO KPI_DATA(ID, VALUE, COMMENTS, REPORTING_PERIOD, KPI_ID) 
VALUES (1, 70, 'Network outage', CURDATE(), 1);
INSERT INTO KPI_DATA(ID, VALUE, COMMENTS, REPORTING_PERIOD, KPI_ID) 
VALUES (2, 6, 'Low defect count Network outage', '2019-07-01 17:18:55', 1);

INSERT INTO COUNTRY(ID, COUNTRY_CODE, COUNTRY_NAME) VALUES (1, 'IN', 'India');
INSERT INTO COUNTRY(ID, COUNTRY_CODE, COUNTRY_NAME) VALUES (2, 'LK', 'Sri Lanka');

INSERT INTO OPERATING_ENTITY(ID, ENTITY_NAME, COUNTRY_ID) 
VALUES (1, 'Company Branch IN', 1);
INSERT INTO OPERATING_ENTITY(ID, ENTITY_NAME, COUNTRY_ID) 
VALUES (2, 'Company Branch SL', 2);

INSERT INTO SERVICE_OFFERING
(ID, SERVICE_NAME, SERVICE_DESCRIPTION, BUSINESS_WEIGHTAGE, OPERATING_ENTITY_ID) 
VALUES (1, 'Service Offering 1', 'Test Service Offering', 50, 1);

INSERT INTO PORTFOLIO(ID, PORTFOLIO_NAME, PORTFOLIO_DESCRIPTION, SOLUTION, 
PORTFOLIO_MODEL, BUSINESS_WEIGHTAGE, SERVICE_OFFERING_ID) VALUES (1, 'Project ', 
'A prjt for In', 'APFI', 'Staff Augumentation', 80, 1);