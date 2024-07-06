ALTER TABLE productservice.product
    ADD is_deleted BIT(1) NULL;

ALTER TABLE productservice.product
    MODIFY is_deleted BIT (1) NOT NULL;