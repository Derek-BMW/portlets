CREATE TABLE bank
(
  id bigint NOT NULL,
  title character varying(255) NOT NULL,
  url character varying(255),
  logo_url character varying(255),
  created_date date,
  created_by character varying(255),
  modified_date date,
  modified_by character varying(255),
  CONSTRAINT bank_pk PRIMARY KEY (id )
);

CREATE TABLE deposit
(
  id bigint NOT NULL,
  title character varying(255) NOT NULL,
  created_date date,
  created_by character varying(255),
  modified_date date,
  modified_by character varying(255),
  percent double precision,
  period integer,
  CONSTRAINT deposit_pk PRIMARY KEY (id )
)