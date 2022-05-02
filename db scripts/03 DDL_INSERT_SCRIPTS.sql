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
SERVICE_OWNER_BUSINESS_ID, SERVICE_MANAGER_ID) VALUES 
(1, 'Prjct1', 'XYZ01BC', 60, 'Scrum', 
'Some gibberish about how the project works.', 2, 3, 4);