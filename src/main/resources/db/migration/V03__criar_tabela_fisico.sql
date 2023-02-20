/**
 * Author:  Miguel Castro
 */

CREATE TABLE fisico (
    id bigint NOT NULL, 
    altura DOUBLE NOT NULL, 
    peso DOUBLE NOT NULL, 
    tipo_sanguineo VARCHAR(255) NOT NULL, 
    PRIMARY KEY (id)
);
