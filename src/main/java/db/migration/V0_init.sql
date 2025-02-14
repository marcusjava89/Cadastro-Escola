--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.25
-- Dumped by pg_dump version 9.5.25

-- Started on 2025-02-14 11:59:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2105 (class 1262 OID 41073)
-- Name: cadastro-escola; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "cadastro-escola" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE "cadastro-escola" OWNER TO postgres;

\connect -reuse-previous=on "dbname='cadastro-escola'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2108 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 181 (class 1259 OID 41074)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    id bigint NOT NULL,
    nome character varying(255),
    cpf character varying(255),
    idade integer NOT NULL,
    chave character varying(255)
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 41079)
-- Name: seq_aluno; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_aluno
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_aluno OWNER TO postgres;

--
-- TOC entry 2098 (class 0 OID 41074)
-- Dependencies: 181
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (7, 'Okafor Susan', '24586574102', 25, 'resident');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (10, 'Elizabeth Keen', '78965412345', 40, 'orfa');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (6, 'Indiana Jones', '28647852014', 75, 'lança');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (3, 'Aaram Prog', '10108975789', 46, 'shok');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (8, 'Samar Navabi', '74685921487', 34, 'black list');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (11, 'Cinthia Panabaker', '52489735210', 60, 'força tarefa');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (12, 'Siya Malik', '41879652010', 30, 'mi6');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (13, 'Harold Cooper', '74896532154', 61, 'Raymond');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (14, 'Agnes Keen', '54897632015', 10, 'Mãe Keen');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (15, 'Bruce Wayne', '46521879654', 37, 'batman');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (16, 'Diana Amazona', '86485213698', 5000, 'maravilha');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (18, 'Tchalla', '65821789854', 40, 'pantera negra');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (19, 'Liu Kang', '85236974120', 45, 'Fogo');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (20, 'Lois Lane', '01265897410', 32, 'superman');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (21, 'Monique Martins', '10523698547', 37, 'nome');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (22, 'Peter Park', '13205698741', 25, 'aranha');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (23, 'Peter Parker', '3216548792', 63, 'homem aranha');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (24, 'Tio Ben', '2356654878965', 65, 'homem');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (27, 'Barry Allen', '43258974112', 0, 'flash');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (28, 'Celina Kyle', '46857985120', 25, 'gato');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (29, 'Natasha Romanoff', '15326987420', 35, 'viúva');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (30, 'Tony Stark', '46528974123', 35, 'ferro');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (31, 'Bruce Banner', '45698712357', 40, 'hulk');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (32, 'Thor Trovão', '32569874103', 5000, 'mjlnor');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (33, 'Lucas Azevedo 2', '16284748744', 29, '1231231232');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (34, 'Lucas Azevedo 3', '16284748744', 29, '1231231233');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (17, 'Pelé', '13564986465', 65, 'gol');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (36, 'Tyler Perry', '52369874520', 49, 'beauty');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (5, 'Donald Ressler FBI', '35264879821', 32, 'fbi');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (2, 'Marcus Martins', '12547896325', 35, 'mvms');
INSERT INTO public.aluno (id, nome, cpf, idade, chave) VALUES (9, 'Samar Navabi', '14105689713', 35, 'black hawk');


--
-- TOC entry 2109 (class 0 OID 0)
-- Dependencies: 182
-- Name: seq_aluno; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_aluno', 36, true);


--
-- TOC entry 1983 (class 2606 OID 41078)
-- Name: aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);


--
-- TOC entry 2107 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2025-02-14 11:59:23

--
-- PostgreSQL database dump complete
--

