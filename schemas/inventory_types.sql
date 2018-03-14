-- Table: public.inventory_types

-- DROP TABLE public.inventory_types;

CREATE TABLE public.inventory_types
(
    id integer NOT NULL DEFAULT nextval('inventory_types_id_seq'::regclass),
    description "char"[] NOT NULL,
    CONSTRAINT inventory_types_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.inventory_types
    OWNER to postgres;
COMMENT ON TABLE public.inventory_types
    IS 'List of inventory types available for the end user';