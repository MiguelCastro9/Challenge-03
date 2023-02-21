/**
 * Author:  Miguel Castro
 */

CREATE TABLE contato (
    id BIGINT NOT NULL AUTO_INCREMENT, 
    email VARCHAR(255) NOT NULL, 
    numero VARCHAR(255) NOT NULL, 
    tipo_contato VARCHAR(255) NOT NULL, 
    paciente_id BIGINT, 
    PRIMARY KEY (id)
);