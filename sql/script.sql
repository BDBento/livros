CREATE TABLE livro
(
    id bigserial NOT NULL,
    nome character varying(50),
    autor character varying(30),
    categoria character varying(30),
    CONSTRAINT livro_pkey PRIMARY KEY (id)
);
