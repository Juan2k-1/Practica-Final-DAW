CREATE TABLE VUELO (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    fecha date NOT NULL,
    hora_salida time NOT NULL,
    hora_llegada time NOT NULL,
    estado text NOT NULL,
    puertaDeEmbarque smallint NOT NULL,
    ciudad_origen text NOT NULL,
    ciudad_destino text NOT NULL
);

CREATE TABLE USUARIO (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre text NOT NULL,
    apellidos text NOT NULL,
    email text NOT NULL UNIQUE,
    nickName text NOT NULL UNIQUE
);