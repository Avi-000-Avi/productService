CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at VARCHAR(255) NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_it
(
    id             BIGINT NOT NULL,
    specialisation VARCHAR(255) NULL,
    CONSTRAINT pk_jt_it PRIMARY KEY (id)
);

CREATE TABLE jt_mentor
(
    id        BIGINT NOT NULL,
    comp_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id                BIGINT NOT NULL,
    number_of_session INT    NOT NULL,
    avg_rating        FLOAT  NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_users
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_users PRIMARY KEY (id)
);

CREATE TABLE mps_it
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialisation VARCHAR(255) NULL,
    CONSTRAINT pk_mps_it PRIMARY KEY (id)
);

CREATE TABLE mps_mentor
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    password  VARCHAR(255) NULL,
    comp_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_mps_mentor PRIMARY KEY (id)
);

CREATE TABLE mps_ta
(
    id                BIGINT NOT NULL,
    name              VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    password          VARCHAR(255) NULL,
    number_of_session INT    NOT NULL,
    avg_rating        FLOAT  NOT NULL,
    CONSTRAINT pk_mps_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE sc_users
(
    id                BIGINT NOT NULL,
    user_type         INT NULL,
    name              VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    password          VARCHAR(255) NULL,
    specialisation    VARCHAR(255) NULL,
    number_of_session INT    NOT NULL,
    avg_rating        FLOAT  NOT NULL,
    comp_name         VARCHAR(255) NULL,
    CONSTRAINT pk_sc_users PRIMARY KEY (id)
);

CREATE TABLE tpc
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tpc PRIMARY KEY (id)
);

CREATE TABLE tpc_it
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialisation VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_it PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    password  VARCHAR(255) NULL,
    comp_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id                BIGINT NOT NULL,
    name              VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    password          VARCHAR(255) NULL,
    number_of_session INT    NOT NULL,
    avg_rating        FLOAT  NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE vip_products
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_at   VARCHAR(255) NULL,
    category1_id BIGINT NULL,
    CONSTRAINT pk_vipproducts PRIMARY KEY (id)
);

ALTER TABLE jt_it
    ADD CONSTRAINT FK_JT_IT_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE vip_products
    ADD CONSTRAINT FK_VIPPRODUCTS_ON_CATEGORY1 FOREIGN KEY (category1_id) REFERENCES category (id);