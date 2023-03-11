/**
 * Author:  Miguel Castro
 */

CREATE TABLE fisico (
    id BIGINT NOT NULL AUTO_INCREMENT, 
    altura DOUBLE NOT NULL, 
    peso DOUBLE NOT NULL, 
    tipo_sanguineo VARCHAR(255) NOT NULL, 
    PRIMARY KEY (id)
);
