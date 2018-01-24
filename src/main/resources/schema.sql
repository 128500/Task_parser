CREATE TABLE tires
(
  tire_id          SERIAL NOT NULL
    CONSTRAINT tires_pkey
    PRIMARY KEY,
  type             VARCHAR(30),
  manufacturer     VARCHAR(30),
  model            VARCHAR(60),
  width            INTEGER,
  height           INTEGER,
  diameter         INTEGER,
  season           VARCHAR(20),
  load_index       INTEGER,
  speed_index      VARCHAR(1),
  strengthen        BOOLEAN,
  studded          BOOLEAN,
  additional_param VARCHAR(10),
  country          VARCHAR(50),
  year             INTEGER,
  balance          INTEGER,
  price            NUMERIC(7, 2)
);