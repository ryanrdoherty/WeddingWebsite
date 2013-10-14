CREATE TABLE GUESTBOOK
  (
    GB_ID int8 NOT NULL,
    GB_DATE TIMESTAMP,
    MESSAGE text,
    SUBJECT VARCHAR(255),
    USER_ID int8,
    PRIMARY KEY (GB_ID)
  );

CREATE TABLE PAGE_VIEWS
  (
    VIEW_ID int8 NOT NULL,
    VIEW_DATE TIMESTAMP,
    PAGE VARCHAR(255),
    USER_ID int8,
    PRIMARY KEY (VIEW_ID)
  );

-- Note this table is not used but is required for a JPA native query
CREATE TABLE PageStat
  (
    page int4 NOT NULL, numViews int4, PRIMARY KEY (page)
  );

CREATE TABLE WEDDING_USER
  (
    USER_ID int8 NOT NULL,
    ADDRESS      VARCHAR(255),
    RSVP         VARCHAR(255),
    CITY         VARCHAR(255),
    DISPLAY_NAME VARCHAR(255),
    EMAIL        VARCHAR(255),
    GIFT_DESC    VARCHAR(255),
    MAX_ADULTS int4,
    MAX_KIDS int4,
    NAME VARCHAR(255),
    NUM_ADULTS int4,
    NUM_KIDS int4,
    PASSCODE     VARCHAR(255),
    COMMENT      VARCHAR(255),
    STATE        VARCHAR(255),
    THANKYOU     BOOLEAN,
    WRITE_ACCESS BOOLEAN,
    ZIP          VARCHAR(255),
    PRIMARY KEY (USER_ID)
  );

CREATE TABLE CONTENT
  (
    KEY VARCHAR(256),
    VALUE TEXT
  );

ALTER TABLE GUESTBOOK ADD CONSTRAINT FK_2x594ktjwmabk5oyemccv5hqq FOREIGN KEY
(
  USER_ID
)
REFERENCES WEDDING_USER;

ALTER TABLE PAGE_VIEWS ADD CONSTRAINT FK_a3s92hmbstdj76xkstdahj04u FOREIGN KEY
(
  USER_ID
)
REFERENCES WEDDING_USER;

CREATE sequence hibernate_sequence;

INSERT INTO WEDDING_USER
  ( user_id, rsvp, name, num_adults, num_kids, passcode, write_access )
  VALUES
  ( -1, 'YES', 'Admin', 1, 0, 'adminpasscode', true );
