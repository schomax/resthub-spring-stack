INSERT INTO IDENTITY (ID) VALUES (1);
INSERT INTO IDENTITY (ID) VALUES (2);
INSERT INTO IDENTITY (ID) VALUES (3);

INSERT INTO USER (ID, FIRSTNAME, LASTNAME, EMAIL, LOGIN, PASSWORD) VALUES (1, 'alex', 'synclar', 'user1@atosorigin.com', 'admin', '4dm|n');
INSERT INTO USER (ID, FIRSTNAME, LASTNAME, EMAIL, LOGIN, PASSWORD) VALUES (2, 'test', 'ing', 'test@atosorigin.com', 'test', 't3st');

INSERT INTO USERSGROUP (ID, NAME) VALUES (3, 'ADMINS');

INSERT INTO USER_GROUP ( GROUPS_ID , USERS_ID ) VALUES ( 3, 1 );

INSERT INTO IDENTITY_PERMISSIONS (IDENTITY_ID, PERMISSIONS) VALUES ( 3 , 'ADMIN');