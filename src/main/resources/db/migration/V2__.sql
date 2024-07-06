ALTER TABLE product
    ADD quantity INT NULL;

ALTER TABLE product
    MODIFY quantity INT NOT NULL;

ALTER TABLE sc_users
DROP
COLUMN avg_rating;

ALTER TABLE sc_users
    ADD avg_rating FLOAT NOT NULL;

ALTER TABLE sc_users
    MODIFY avg_rating FLOAT NOT NULL;

ALTER TABLE sc_users
    MODIFY number_of_session INT NOT NULL;

ALTER TABLE sc_users
    MODIFY user_type INT NULL;