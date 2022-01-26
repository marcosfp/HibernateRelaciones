DROP DATABASE hibernate_relaciones;

CREATE DATABASE hibernate_relaciones;

USE hibernate_relaciones;

CREATE TABLE alumno (
  alumno_id bigint NOT NULL AUTO_INCREMENT,
  nombreyapellidos varchar(255) DEFAULT NULL,
  PRIMARY KEY (alumno_id)
) ;

CREATE TABLE  modulo  (
   modulo_id  bigint NOT NULL AUTO_INCREMENT,
   nombre  varchar(255) DEFAULT NULL,
  PRIMARY KEY ( modulo_id )
) ;



CREATE TABLE matricula (
  calificacion int DEFAULT NULL,
  fecha_creacion datetime(6) DEFAULT NULL,
  modulo_modulo_id bigint NOT NULL,
  alumno_alumno_id bigint NOT NULL,
  PRIMARY KEY (alumno_alumno_id,modulo_modulo_id),
  KEY FKs3bi95de7lehogpfu0mm7moy  (modulo_modulo_id),
  CONSTRAINT FKdidutdxnqgwfrilogi4cwu5qx FOREIGN KEY (alumno_alumno_id) REFERENCES alumno (alumno_id),
  CONSTRAINT FKs3bi95de7lehogpfu0mm7moy0 FOREIGN KEY (modulo_modulo_id) REFERENCES modulo (modulo_id)
) ;
