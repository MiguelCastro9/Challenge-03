/**
 * Author:  Miguel Castro
 */

ALTER TABLE endereco 
ADD CONSTRAINT FKp5rksyhf75f5ms33ve89k709d FOREIGN KEY (paciente_id) REFERENCES paciente;
