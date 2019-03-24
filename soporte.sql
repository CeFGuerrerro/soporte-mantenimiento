--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-03-24 17:49:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12278)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2598 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 209 (class 1259 OID 16628)
-- Name: arquitecturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.arquitecturas (
    id_arquitectura integer NOT NULL,
    arquitectura text NOT NULL
);


ALTER TABLE public.arquitecturas OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16697)
-- Name: arquitecturas_id_arquitectura_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.arquitecturas_id_arquitectura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.arquitecturas_id_arquitectura_seq OWNER TO postgres;

--
-- TOC entry 2599 (class 0 OID 0)
-- Dependencies: 228
-- Name: arquitecturas_id_arquitectura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.arquitecturas_id_arquitectura_seq OWNED BY public.arquitecturas.id_arquitectura;


--
-- TOC entry 204 (class 1259 OID 16613)
-- Name: capacidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.capacidades (
    id_capacidad integer NOT NULL,
    capacidad text NOT NULL
);


ALTER TABLE public.capacidades OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16706)
-- Name: capacidades_id_capacidad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.capacidades_id_capacidad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.capacidades_id_capacidad_seq OWNER TO postgres;

--
-- TOC entry 2600 (class 0 OID 0)
-- Dependencies: 229
-- Name: capacidades_id_capacidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.capacidades_id_capacidad_seq OWNED BY public.capacidades.id_capacidad;


--
-- TOC entry 211 (class 1259 OID 16634)
-- Name: componentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.componentes (
    id_componente integer NOT NULL,
    id_tipo_componente integer NOT NULL,
    id_modelo integer NOT NULL,
    numero_inventario text,
    numero_serie text,
    estado boolean,
    personal boolean,
    asignado boolean,
    observaciones text
);


ALTER TABLE public.componentes OWNER TO postgres;

--
-- TOC entry 273 (class 1259 OID 17465)
-- Name: componentes_equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.componentes_equipo (
    id_componente_equipo integer NOT NULL,
    id_equipo integer NOT NULL,
    id_componente integer NOT NULL,
    fecha_vinculado date,
    fecha_desvinculado date,
    estado boolean,
    observaciones text
);


ALTER TABLE public.componentes_equipo OWNER TO postgres;

--
-- TOC entry 272 (class 1259 OID 17463)
-- Name: componentes_equipo_id_componente_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.componentes_equipo_id_componente_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.componentes_equipo_id_componente_equipo_seq OWNER TO postgres;

--
-- TOC entry 2601 (class 0 OID 0)
-- Dependencies: 272
-- Name: componentes_equipo_id_componente_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.componentes_equipo_id_componente_equipo_seq OWNED BY public.componentes_equipo.id_componente_equipo;


--
-- TOC entry 230 (class 1259 OID 16715)
-- Name: componentes_id_componente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.componentes_id_componente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.componentes_id_componente_seq OWNER TO postgres;

--
-- TOC entry 2602 (class 0 OID 0)
-- Dependencies: 230
-- Name: componentes_id_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.componentes_id_componente_seq OWNED BY public.componentes.id_componente;


--
-- TOC entry 221 (class 1259 OID 16667)
-- Name: cronograma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cronograma (
    id_cronograma integer NOT NULL,
    id_equipo integer,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    nombre_evento text NOT NULL,
    descripcion text
);


ALTER TABLE public.cronograma OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16725)
-- Name: cronograma_id_cronograma_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cronograma_id_cronograma_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cronograma_id_cronograma_seq OWNER TO postgres;

--
-- TOC entry 2603 (class 0 OID 0)
-- Dependencies: 231
-- Name: cronograma_id_cronograma_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cronograma_id_cronograma_seq OWNED BY public.cronograma.id_cronograma;


--
-- TOC entry 224 (class 1259 OID 16685)
-- Name: detalles_orden_trabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalles_orden_trabajo (
    id_detalle integer NOT NULL,
    id_orden_trabajo integer NOT NULL,
    id_solucion integer NOT NULL,
    observaciones text
);


ALTER TABLE public.detalles_orden_trabajo OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16731)
-- Name: detalles_orden_trabajo_id_detalle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalles_orden_trabajo_id_detalle_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalles_orden_trabajo_id_detalle_seq OWNER TO postgres;

--
-- TOC entry 2604 (class 0 OID 0)
-- Dependencies: 232
-- Name: detalles_orden_trabajo_id_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalles_orden_trabajo_id_detalle_seq OWNED BY public.detalles_orden_trabajo.id_detalle;


--
-- TOC entry 261 (class 1259 OID 17413)
-- Name: dimension_disco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dimension_disco (
    id_dimension integer NOT NULL,
    dimension text NOT NULL
);


ALTER TABLE public.dimension_disco OWNER TO postgres;

--
-- TOC entry 260 (class 1259 OID 17411)
-- Name: dimension_disco_id_dimension_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dimension_disco_id_dimension_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dimension_disco_id_dimension_seq OWNER TO postgres;

--
-- TOC entry 2605 (class 0 OID 0)
-- Dependencies: 260
-- Name: dimension_disco_id_dimension_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dimension_disco_id_dimension_seq OWNED BY public.dimension_disco.id_dimension;


--
-- TOC entry 199 (class 1259 OID 16598)
-- Name: discos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discos (
    id_disco integer NOT NULL,
    id_marca integer NOT NULL,
    id_capacidad integer,
    id_puerto integer,
    id_tipo_disco integer,
    numero_serie text,
    id_dimension integer,
    estado boolean,
    asignado boolean
);


ALTER TABLE public.discos OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16746)
-- Name: discos_id_discos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discos_id_discos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discos_id_discos_seq OWNER TO postgres;

--
-- TOC entry 2606 (class 0 OID 0)
-- Dependencies: 233
-- Name: discos_id_discos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.discos_id_discos_seq OWNED BY public.discos.id_disco;


--
-- TOC entry 218 (class 1259 OID 16655)
-- Name: equipos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipos (
    id_equipo integer NOT NULL,
    id_ubicacion integer NOT NULL,
    estado boolean,
    id_responsable integer,
    observaciones text
);


ALTER TABLE public.equipos OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 16755)
-- Name: equipo_id_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipo_id_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipo_id_equipo_seq OWNER TO postgres;

--
-- TOC entry 2607 (class 0 OID 0)
-- Dependencies: 234
-- Name: equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipo_id_equipo_seq OWNED BY public.equipos.id_equipo;


--
-- TOC entry 202 (class 1259 OID 16607)
-- Name: fuentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fuentes (
    id_fuente integer NOT NULL,
    id_modelo integer NOT NULL,
    potencia text,
    numero_pines text,
    numero_serie text,
    estado boolean,
    asignado boolean
);


ALTER TABLE public.fuentes OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16791)
-- Name: fuentes_id_fuente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fuentes_id_fuente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fuentes_id_fuente_seq OWNER TO postgres;

--
-- TOC entry 2608 (class 0 OID 0)
-- Dependencies: 235
-- Name: fuentes_id_fuente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fuentes_id_fuente_seq OWNED BY public.fuentes.id_fuente;


--
-- TOC entry 210 (class 1259 OID 16631)
-- Name: hardware_componente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hardware_componente (
    id_hardware_componente integer NOT NULL,
    id_componente integer NOT NULL,
    id_memoria integer NOT NULL,
    id_disco integer NOT NULL,
    id_procesador integer NOT NULL,
    id_motherboard integer NOT NULL,
    id_fuente integer,
    id_tarjeta_video integer,
    observaciones text
);


ALTER TABLE public.hardware_componente OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 16800)
-- Name: hardware_componente_id_hardware_componente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hardware_componente_id_hardware_componente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hardware_componente_id_hardware_componente_seq OWNER TO postgres;

--
-- TOC entry 2609 (class 0 OID 0)
-- Dependencies: 236
-- Name: hardware_componente_id_hardware_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hardware_componente_id_hardware_componente_seq OWNED BY public.hardware_componente.id_hardware_componente;


--
-- TOC entry 226 (class 1259 OID 16691)
-- Name: mantenimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mantenimientos (
    id_mantenimiento integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.mantenimientos OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16810)
-- Name: mantenimientos_id_mantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mantenimientos_id_mantenimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mantenimientos_id_mantenimiento_seq OWNER TO postgres;

--
-- TOC entry 2610 (class 0 OID 0)
-- Dependencies: 237
-- Name: mantenimientos_id_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mantenimientos_id_mantenimiento_seq OWNED BY public.mantenimientos.id_mantenimiento;


--
-- TOC entry 207 (class 1259 OID 16622)
-- Name: marcas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marcas (
    id_marca integer NOT NULL,
    nombre text NOT NULL
);


ALTER TABLE public.marcas OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 16819)
-- Name: marcas_id_marca_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marcas_id_marca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marcas_id_marca_seq OWNER TO postgres;

--
-- TOC entry 2611 (class 0 OID 0)
-- Dependencies: 238
-- Name: marcas_id_marca_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marcas_id_marca_seq OWNED BY public.marcas.id_marca;


--
-- TOC entry 198 (class 1259 OID 16595)
-- Name: memorias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.memorias (
    id_memoria integer NOT NULL,
    id_marca integer NOT NULL,
    id_tipo integer NOT NULL,
    id_capacidad integer,
    numero_serie text,
    id_velocidad integer,
    estado boolean,
    asignado boolean
);


ALTER TABLE public.memorias OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 16828)
-- Name: memorias_id_memoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.memorias_id_memoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.memorias_id_memoria_seq OWNER TO postgres;

--
-- TOC entry 2612 (class 0 OID 0)
-- Dependencies: 239
-- Name: memorias_id_memoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.memorias_id_memoria_seq OWNED BY public.memorias.id_memoria;


--
-- TOC entry 208 (class 1259 OID 16625)
-- Name: modelos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modelos (
    id_modelo integer NOT NULL,
    id_marca integer NOT NULL,
    nombre text NOT NULL
);


ALTER TABLE public.modelos OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 16837)
-- Name: modelos_id_modelo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modelos_id_modelo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modelos_id_modelo_seq OWNER TO postgres;

--
-- TOC entry 2613 (class 0 OID 0)
-- Dependencies: 240
-- Name: modelos_id_modelo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modelos_id_modelo_seq OWNED BY public.modelos.id_modelo;


--
-- TOC entry 201 (class 1259 OID 16604)
-- Name: motherboards; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.motherboards (
    id_motherboard integer NOT NULL,
    id_marca integer NOT NULL,
    id_socket integer,
    numero_serie text,
    estado boolean,
    asignado boolean
);


ALTER TABLE public.motherboards OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 16846)
-- Name: motherboards_id_motherboard_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.motherboards_id_motherboard_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.motherboards_id_motherboard_seq OWNER TO postgres;

--
-- TOC entry 2614 (class 0 OID 0)
-- Dependencies: 241
-- Name: motherboards_id_motherboard_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.motherboards_id_motherboard_seq OWNED BY public.motherboards.id_motherboard;


--
-- TOC entry 223 (class 1259 OID 16676)
-- Name: ordenes_trabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordenes_trabajo (
    id_orden_trabajo integer NOT NULL,
    id_solicitud integer,
    id_mantenimiento integer NOT NULL,
    id_tecnico integer NOT NULL,
    fecha_inicio date,
    fecha_finalizacion date,
    hora_inicio text,
    hora_finalizacion text,
    observaciones text,
    prioridad integer,
    estado integer,
    id_equipo integer NOT NULL
);


ALTER TABLE public.ordenes_trabajo OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 16855)
-- Name: ordenes_trabajo_id_orden_trabajo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ordenes_trabajo_id_orden_trabajo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ordenes_trabajo_id_orden_trabajo_seq OWNER TO postgres;

--
-- TOC entry 2615 (class 0 OID 0)
-- Dependencies: 242
-- Name: ordenes_trabajo_id_orden_trabajo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ordenes_trabajo_id_orden_trabajo_seq OWNED BY public.ordenes_trabajo.id_orden_trabajo;


--
-- TOC entry 269 (class 1259 OID 17447)
-- Name: potencia_ups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.potencia_ups (
    id_potencia integer NOT NULL,
    voltaje text,
    amperaje text
);


ALTER TABLE public.potencia_ups OWNER TO postgres;

--
-- TOC entry 268 (class 1259 OID 17445)
-- Name: potencia_ups_id_potencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.potencia_ups_id_potencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.potencia_ups_id_potencia_seq OWNER TO postgres;

--
-- TOC entry 2616 (class 0 OID 0)
-- Dependencies: 268
-- Name: potencia_ups_id_potencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.potencia_ups_id_potencia_seq OWNED BY public.potencia_ups.id_potencia;


--
-- TOC entry 200 (class 1259 OID 16601)
-- Name: procesadores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.procesadores (
    id_procesador integer NOT NULL,
    id_modelo integer NOT NULL,
    id_arquitectura integer NOT NULL,
    id_socket integer,
    numero_serie text,
    estado boolean,
    asignado boolean
);


ALTER TABLE public.procesadores OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 16864)
-- Name: procesadores_id_procesador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.procesadores_id_procesador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.procesadores_id_procesador_seq OWNER TO postgres;

--
-- TOC entry 2617 (class 0 OID 0)
-- Dependencies: 243
-- Name: procesadores_id_procesador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.procesadores_id_procesador_seq OWNED BY public.procesadores.id_procesador;


--
-- TOC entry 205 (class 1259 OID 16616)
-- Name: puertos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.puertos (
    id_puerto integer NOT NULL,
    tipo_puerto text NOT NULL
);


ALTER TABLE public.puertos OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 16873)
-- Name: puertos_id_puerto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.puertos_id_puerto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.puertos_id_puerto_seq OWNER TO postgres;

--
-- TOC entry 2618 (class 0 OID 0)
-- Dependencies: 244
-- Name: puertos_id_puerto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.puertos_id_puerto_seq OWNED BY public.puertos.id_puerto;


--
-- TOC entry 220 (class 1259 OID 16661)
-- Name: responsables; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsables (
    id_responsable integer NOT NULL,
    nombre text NOT NULL,
    correo text,
    id_ubicacion integer
);


ALTER TABLE public.responsables OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 16882)
-- Name: resposables_id_responsable_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resposables_id_responsable_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resposables_id_responsable_seq OWNER TO postgres;

--
-- TOC entry 2619 (class 0 OID 0)
-- Dependencies: 245
-- Name: resposables_id_responsable_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resposables_id_responsable_seq OWNED BY public.responsables.id_responsable;


--
-- TOC entry 267 (class 1259 OID 17441)
-- Name: salida_tarjeta_video; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.salida_tarjeta_video (
    id_salida_tarjeta_video integer NOT NULL,
    id_salida_video integer NOT NULL,
    id_tarjeta_video integer NOT NULL
);


ALTER TABLE public.salida_tarjeta_video OWNER TO postgres;

--
-- TOC entry 266 (class 1259 OID 17439)
-- Name: salida_tarjeta_video_id_salida_tarjeta_video_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.salida_tarjeta_video_id_salida_tarjeta_video_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.salida_tarjeta_video_id_salida_tarjeta_video_seq OWNER TO postgres;

--
-- TOC entry 2620 (class 0 OID 0)
-- Dependencies: 266
-- Name: salida_tarjeta_video_id_salida_tarjeta_video_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.salida_tarjeta_video_id_salida_tarjeta_video_seq OWNED BY public.salida_tarjeta_video.id_salida_tarjeta_video;


--
-- TOC entry 265 (class 1259 OID 17431)
-- Name: salida_video; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.salida_video (
    id_salida_video integer NOT NULL,
    tipo_salida text NOT NULL
);


ALTER TABLE public.salida_video OWNER TO postgres;

--
-- TOC entry 264 (class 1259 OID 17429)
-- Name: salida_video_id_salida_video_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.salida_video_id_salida_video_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.salida_video_id_salida_video_seq OWNER TO postgres;

--
-- TOC entry 2621 (class 0 OID 0)
-- Dependencies: 264
-- Name: salida_video_id_salida_video_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.salida_video_id_salida_video_seq OWNED BY public.salida_video.id_salida_video;


--
-- TOC entry 206 (class 1259 OID 16619)
-- Name: sockets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sockets (
    id_socket integer NOT NULL,
    socket text NOT NULL
);


ALTER TABLE public.sockets OWNER TO postgres;

--
-- TOC entry 246 (class 1259 OID 16891)
-- Name: sockets_id_socket_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sockets_id_socket_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sockets_id_socket_seq OWNER TO postgres;

--
-- TOC entry 2622 (class 0 OID 0)
-- Dependencies: 246
-- Name: sockets_id_socket_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sockets_id_socket_seq OWNED BY public.sockets.id_socket;


--
-- TOC entry 213 (class 1259 OID 16640)
-- Name: software; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.software (
    id_software integer NOT NULL,
    id_tipo_software integer NOT NULL,
    id_arquitectura integer NOT NULL,
    nombre text NOT NULL,
    version text,
    service_pack text,
    descripcion text
);


ALTER TABLE public.software OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16637)
-- Name: software_componente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.software_componente (
    id_software_componente integer NOT NULL,
    id_software integer NOT NULL,
    id_componente integer NOT NULL,
    licencia boolean,
    serial text,
    observaciones text
);


ALTER TABLE public.software_componente OWNER TO postgres;

--
-- TOC entry 248 (class 1259 OID 16910)
-- Name: software_componente_id_software_componente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.software_componente_id_software_componente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.software_componente_id_software_componente_seq OWNER TO postgres;

--
-- TOC entry 2623 (class 0 OID 0)
-- Dependencies: 248
-- Name: software_componente_id_software_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.software_componente_id_software_componente_seq OWNED BY public.software_componente.id_software_componente;


--
-- TOC entry 247 (class 1259 OID 16901)
-- Name: software_id_software_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.software_id_software_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.software_id_software_seq OWNER TO postgres;

--
-- TOC entry 2624 (class 0 OID 0)
-- Dependencies: 247
-- Name: software_id_software_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.software_id_software_seq OWNED BY public.software.id_software;


--
-- TOC entry 222 (class 1259 OID 16673)
-- Name: solicitudes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solicitudes (
    id_solicitud integer NOT NULL,
    id_responsable integer NOT NULL,
    fecha_solicitud date NOT NULL,
    problema text NOT NULL,
    estado integer,
    codigo_seguimiento integer,
    id_tipo_solicitud integer,
    id_ubicacion integer NOT NULL
);


ALTER TABLE public.solicitudes OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 16919)
-- Name: solicitudes_id_solicitud_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.solicitudes_id_solicitud_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.solicitudes_id_solicitud_seq OWNER TO postgres;

--
-- TOC entry 2625 (class 0 OID 0)
-- Dependencies: 249
-- Name: solicitudes_id_solicitud_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.solicitudes_id_solicitud_seq OWNED BY public.solicitudes.id_solicitud;


--
-- TOC entry 214 (class 1259 OID 16643)
-- Name: soluciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.soluciones (
    id_solucion integer NOT NULL,
    nombre text NOT NULL,
    descripcion text,
    id_tipo_mantenimiento integer
);


ALTER TABLE public.soluciones OWNER TO postgres;

--
-- TOC entry 250 (class 1259 OID 16928)
-- Name: soluciones_id_solucion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.soluciones_id_solucion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.soluciones_id_solucion_seq OWNER TO postgres;

--
-- TOC entry 2626 (class 0 OID 0)
-- Dependencies: 250
-- Name: soluciones_id_solucion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.soluciones_id_solucion_seq OWNED BY public.soluciones.id_solucion;


--
-- TOC entry 203 (class 1259 OID 16610)
-- Name: tarjetas_video; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarjetas_video (
    id_tarjeta_video integer NOT NULL,
    id_marca integer NOT NULL,
    id_puerto integer NOT NULL,
    numero_serial text,
    estado boolean,
    asignado boolean
);


ALTER TABLE public.tarjetas_video OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 16937)
-- Name: tarjetas_video_id_tarjeta_video_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tarjetas_video_id_tarjeta_video_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarjetas_video_id_tarjeta_video_seq OWNER TO postgres;

--
-- TOC entry 2627 (class 0 OID 0)
-- Dependencies: 251
-- Name: tarjetas_video_id_tarjeta_video_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarjetas_video_id_tarjeta_video_seq OWNED BY public.tarjetas_video.id_tarjeta_video;


--
-- TOC entry 227 (class 1259 OID 16694)
-- Name: tecnicos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tecnicos (
    id_tecnico integer NOT NULL,
    nombre text NOT NULL,
    descripcion text,
    correo text,
    estado boolean
);


ALTER TABLE public.tecnicos OWNER TO postgres;

--
-- TOC entry 252 (class 1259 OID 16946)
-- Name: tecnicos_id_tecnico_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tecnicos_id_tecnico_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tecnicos_id_tecnico_seq OWNER TO postgres;

--
-- TOC entry 2628 (class 0 OID 0)
-- Dependencies: 252
-- Name: tecnicos_id_tecnico_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tecnicos_id_tecnico_seq OWNED BY public.tecnicos.id_tecnico;


--
-- TOC entry 215 (class 1259 OID 16646)
-- Name: tipos_componente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_componente (
    id_tipo_componente integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.tipos_componente OWNER TO postgres;

--
-- TOC entry 253 (class 1259 OID 16955)
-- Name: tipo_componente_id_tipo_componente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_componente_id_tipo_componente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_componente_id_tipo_componente_seq OWNER TO postgres;

--
-- TOC entry 2629 (class 0 OID 0)
-- Dependencies: 253
-- Name: tipo_componente_id_tipo_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_componente_id_tipo_componente_seq OWNED BY public.tipos_componente.id_tipo_componente;


--
-- TOC entry 275 (class 1259 OID 17543)
-- Name: tipos_solicitud; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_solicitud (
    id_tipo_solicitud integer NOT NULL,
    nombre text
);


ALTER TABLE public.tipos_solicitud OWNER TO postgres;

--
-- TOC entry 274 (class 1259 OID 17541)
-- Name: tipo_solicitud_id_tipo_solicitud_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_solicitud_id_tipo_solicitud_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_solicitud_id_tipo_solicitud_seq OWNER TO postgres;

--
-- TOC entry 2630 (class 0 OID 0)
-- Dependencies: 274
-- Name: tipo_solicitud_id_tipo_solicitud_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_solicitud_id_tipo_solicitud_seq OWNED BY public.tipos_solicitud.id_tipo_solicitud;


--
-- TOC entry 197 (class 1259 OID 16592)
-- Name: tipos_disco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_disco (
    id_tipo_disco integer NOT NULL,
    tipo_disco text NOT NULL
);


ALTER TABLE public.tipos_disco OWNER TO postgres;

--
-- TOC entry 254 (class 1259 OID 16964)
-- Name: tipos_disco_id_tipo_disco_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipos_disco_id_tipo_disco_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipos_disco_id_tipo_disco_seq OWNER TO postgres;

--
-- TOC entry 2631 (class 0 OID 0)
-- Dependencies: 254
-- Name: tipos_disco_id_tipo_disco_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_disco_id_tipo_disco_seq OWNED BY public.tipos_disco.id_tipo_disco;


--
-- TOC entry 225 (class 1259 OID 16688)
-- Name: tipos_mantenimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_mantenimiento (
    id_tipo_mantenimiento integer NOT NULL,
    id_mantenimiento integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.tipos_mantenimiento OWNER TO postgres;

--
-- TOC entry 255 (class 1259 OID 16973)
-- Name: tipos_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipos_mantenimiento_id_tipo_mantenimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipos_mantenimiento_id_tipo_mantenimiento_seq OWNER TO postgres;

--
-- TOC entry 2632 (class 0 OID 0)
-- Dependencies: 255
-- Name: tipos_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_mantenimiento_id_tipo_mantenimiento_seq OWNED BY public.tipos_mantenimiento.id_tipo_mantenimiento;


--
-- TOC entry 196 (class 1259 OID 16589)
-- Name: tipos_memoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_memoria (
    id_tipo_memoria integer NOT NULL,
    tipo_memoria text NOT NULL
);


ALTER TABLE public.tipos_memoria OWNER TO postgres;

--
-- TOC entry 256 (class 1259 OID 16982)
-- Name: tipos_memoria_id_tipo_memoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipos_memoria_id_tipo_memoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipos_memoria_id_tipo_memoria_seq OWNER TO postgres;

--
-- TOC entry 2633 (class 0 OID 0)
-- Dependencies: 256
-- Name: tipos_memoria_id_tipo_memoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_memoria_id_tipo_memoria_seq OWNED BY public.tipos_memoria.id_tipo_memoria;


--
-- TOC entry 216 (class 1259 OID 16649)
-- Name: tipos_software; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_software (
    id_tipo_software integer NOT NULL,
    tipo_software text NOT NULL
);


ALTER TABLE public.tipos_software OWNER TO postgres;

--
-- TOC entry 257 (class 1259 OID 16992)
-- Name: tipos_software_id_tipo_software_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipos_software_id_tipo_software_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipos_software_id_tipo_software_seq OWNER TO postgres;

--
-- TOC entry 2634 (class 0 OID 0)
-- Dependencies: 257
-- Name: tipos_software_id_tipo_software_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_software_id_tipo_software_seq OWNED BY public.tipos_software.id_tipo_software;


--
-- TOC entry 219 (class 1259 OID 16658)
-- Name: ubicaciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ubicaciones (
    id_ubicacion integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.ubicaciones OWNER TO postgres;

--
-- TOC entry 258 (class 1259 OID 17001)
-- Name: ubicaciones_id_ubicacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ubicaciones_id_ubicacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ubicaciones_id_ubicacion_seq OWNER TO postgres;

--
-- TOC entry 2635 (class 0 OID 0)
-- Dependencies: 258
-- Name: ubicaciones_id_ubicacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ubicaciones_id_ubicacion_seq OWNED BY public.ubicaciones.id_ubicacion;


--
-- TOC entry 217 (class 1259 OID 16652)
-- Name: ups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ups (
    id_ups integer NOT NULL,
    id_componente integer NOT NULL,
    bateria boolean,
    estado_bateria boolean,
    regulador boolean,
    ultimo_cambio date,
    observaciones text,
    id_potencia integer
);


ALTER TABLE public.ups OWNER TO postgres;

--
-- TOC entry 259 (class 1259 OID 17010)
-- Name: ups_id_ups_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ups_id_ups_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ups_id_ups_seq OWNER TO postgres;

--
-- TOC entry 2636 (class 0 OID 0)
-- Dependencies: 259
-- Name: ups_id_ups_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ups_id_ups_seq OWNED BY public.ups.id_ups;


--
-- TOC entry 271 (class 1259 OID 17456)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id_usuario integer NOT NULL,
    nombre_usuario text NOT NULL,
    password text NOT NULL,
    id_ubicacion integer NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 270 (class 1259 OID 17454)
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2637 (class 0 OID 0)
-- Dependencies: 270
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuarios_id_usuario_seq OWNED BY public.usuarios.id_usuario;


--
-- TOC entry 263 (class 1259 OID 17422)
-- Name: velocidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.velocidad (
    id_velocidad integer NOT NULL,
    velocidad text NOT NULL
);


ALTER TABLE public.velocidad OWNER TO postgres;

--
-- TOC entry 262 (class 1259 OID 17420)
-- Name: velocidad_id_velocidad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.velocidad_id_velocidad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.velocidad_id_velocidad_seq OWNER TO postgres;

--
-- TOC entry 2638 (class 0 OID 0)
-- Dependencies: 262
-- Name: velocidad_id_velocidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.velocidad_id_velocidad_seq OWNED BY public.velocidad.id_velocidad;


--
-- TOC entry 2310 (class 2604 OID 17374)
-- Name: arquitecturas id_arquitectura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.arquitecturas ALTER COLUMN id_arquitectura SET DEFAULT nextval('public.arquitecturas_id_arquitectura_seq'::regclass);


--
-- TOC entry 2305 (class 2604 OID 17375)
-- Name: capacidades id_capacidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capacidades ALTER COLUMN id_capacidad SET DEFAULT nextval('public.capacidades_id_capacidad_seq'::regclass);


--
-- TOC entry 2312 (class 2604 OID 17376)
-- Name: componentes id_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes ALTER COLUMN id_componente SET DEFAULT nextval('public.componentes_id_componente_seq'::regclass);


--
-- TOC entry 2335 (class 2604 OID 17468)
-- Name: componentes_equipo id_componente_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes_equipo ALTER COLUMN id_componente_equipo SET DEFAULT nextval('public.componentes_equipo_id_componente_equipo_seq'::regclass);


--
-- TOC entry 2322 (class 2604 OID 17377)
-- Name: cronograma id_cronograma; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma ALTER COLUMN id_cronograma SET DEFAULT nextval('public.cronograma_id_cronograma_seq'::regclass);


--
-- TOC entry 2325 (class 2604 OID 17378)
-- Name: detalles_orden_trabajo id_detalle; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo ALTER COLUMN id_detalle SET DEFAULT nextval('public.detalles_orden_trabajo_id_detalle_seq'::regclass);


--
-- TOC entry 2329 (class 2604 OID 17416)
-- Name: dimension_disco id_dimension; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dimension_disco ALTER COLUMN id_dimension SET DEFAULT nextval('public.dimension_disco_id_dimension_seq'::regclass);


--
-- TOC entry 2300 (class 2604 OID 17380)
-- Name: discos id_disco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos ALTER COLUMN id_disco SET DEFAULT nextval('public.discos_id_discos_seq'::regclass);


--
-- TOC entry 2319 (class 2604 OID 17381)
-- Name: equipos id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos ALTER COLUMN id_equipo SET DEFAULT nextval('public.equipo_id_equipo_seq'::regclass);


--
-- TOC entry 2303 (class 2604 OID 17384)
-- Name: fuentes id_fuente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes ALTER COLUMN id_fuente SET DEFAULT nextval('public.fuentes_id_fuente_seq'::regclass);


--
-- TOC entry 2311 (class 2604 OID 17385)
-- Name: hardware_componente id_hardware_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente ALTER COLUMN id_hardware_componente SET DEFAULT nextval('public.hardware_componente_id_hardware_componente_seq'::regclass);


--
-- TOC entry 2327 (class 2604 OID 17386)
-- Name: mantenimientos id_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos ALTER COLUMN id_mantenimiento SET DEFAULT nextval('public.mantenimientos_id_mantenimiento_seq'::regclass);


--
-- TOC entry 2308 (class 2604 OID 17387)
-- Name: marcas id_marca; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcas ALTER COLUMN id_marca SET DEFAULT nextval('public.marcas_id_marca_seq'::regclass);


--
-- TOC entry 2299 (class 2604 OID 17388)
-- Name: memorias id_memoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias ALTER COLUMN id_memoria SET DEFAULT nextval('public.memorias_id_memoria_seq'::regclass);


--
-- TOC entry 2309 (class 2604 OID 17389)
-- Name: modelos id_modelo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos ALTER COLUMN id_modelo SET DEFAULT nextval('public.modelos_id_modelo_seq'::regclass);


--
-- TOC entry 2302 (class 2604 OID 17390)
-- Name: motherboards id_motherboard; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards ALTER COLUMN id_motherboard SET DEFAULT nextval('public.motherboards_id_motherboard_seq'::regclass);


--
-- TOC entry 2324 (class 2604 OID 17391)
-- Name: ordenes_trabajo id_orden_trabajo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo ALTER COLUMN id_orden_trabajo SET DEFAULT nextval('public.ordenes_trabajo_id_orden_trabajo_seq'::regclass);


--
-- TOC entry 2333 (class 2604 OID 17450)
-- Name: potencia_ups id_potencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.potencia_ups ALTER COLUMN id_potencia SET DEFAULT nextval('public.potencia_ups_id_potencia_seq'::regclass);


--
-- TOC entry 2301 (class 2604 OID 17392)
-- Name: procesadores id_procesador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores ALTER COLUMN id_procesador SET DEFAULT nextval('public.procesadores_id_procesador_seq'::regclass);


--
-- TOC entry 2306 (class 2604 OID 17393)
-- Name: puertos id_puerto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puertos ALTER COLUMN id_puerto SET DEFAULT nextval('public.puertos_id_puerto_seq'::regclass);


--
-- TOC entry 2321 (class 2604 OID 17394)
-- Name: responsables id_responsable; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables ALTER COLUMN id_responsable SET DEFAULT nextval('public.resposables_id_responsable_seq'::regclass);


--
-- TOC entry 2332 (class 2604 OID 17444)
-- Name: salida_tarjeta_video id_salida_tarjeta_video; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salida_tarjeta_video ALTER COLUMN id_salida_tarjeta_video SET DEFAULT nextval('public.salida_tarjeta_video_id_salida_tarjeta_video_seq'::regclass);


--
-- TOC entry 2331 (class 2604 OID 17434)
-- Name: salida_video id_salida_video; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salida_video ALTER COLUMN id_salida_video SET DEFAULT nextval('public.salida_video_id_salida_video_seq'::regclass);


--
-- TOC entry 2307 (class 2604 OID 17395)
-- Name: sockets id_socket; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sockets ALTER COLUMN id_socket SET DEFAULT nextval('public.sockets_id_socket_seq'::regclass);


--
-- TOC entry 2314 (class 2604 OID 17396)
-- Name: software id_software; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software ALTER COLUMN id_software SET DEFAULT nextval('public.software_id_software_seq'::regclass);


--
-- TOC entry 2313 (class 2604 OID 17397)
-- Name: software_componente id_software_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente ALTER COLUMN id_software_componente SET DEFAULT nextval('public.software_componente_id_software_componente_seq'::regclass);


--
-- TOC entry 2323 (class 2604 OID 17398)
-- Name: solicitudes id_solicitud; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes ALTER COLUMN id_solicitud SET DEFAULT nextval('public.solicitudes_id_solicitud_seq'::regclass);


--
-- TOC entry 2315 (class 2604 OID 17399)
-- Name: soluciones id_solucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soluciones ALTER COLUMN id_solucion SET DEFAULT nextval('public.soluciones_id_solucion_seq'::regclass);


--
-- TOC entry 2304 (class 2604 OID 17400)
-- Name: tarjetas_video id_tarjeta_video; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video ALTER COLUMN id_tarjeta_video SET DEFAULT nextval('public.tarjetas_video_id_tarjeta_video_seq'::regclass);


--
-- TOC entry 2328 (class 2604 OID 17401)
-- Name: tecnicos id_tecnico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tecnicos ALTER COLUMN id_tecnico SET DEFAULT nextval('public.tecnicos_id_tecnico_seq'::regclass);


--
-- TOC entry 2316 (class 2604 OID 17402)
-- Name: tipos_componente id_tipo_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_componente ALTER COLUMN id_tipo_componente SET DEFAULT nextval('public.tipo_componente_id_tipo_componente_seq'::regclass);


--
-- TOC entry 2298 (class 2604 OID 17403)
-- Name: tipos_disco id_tipo_disco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_disco ALTER COLUMN id_tipo_disco SET DEFAULT nextval('public.tipos_disco_id_tipo_disco_seq'::regclass);


--
-- TOC entry 2326 (class 2604 OID 17404)
-- Name: tipos_mantenimiento id_tipo_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento ALTER COLUMN id_tipo_mantenimiento SET DEFAULT nextval('public.tipos_mantenimiento_id_tipo_mantenimiento_seq'::regclass);


--
-- TOC entry 2297 (class 2604 OID 17405)
-- Name: tipos_memoria id_tipo_memoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_memoria ALTER COLUMN id_tipo_memoria SET DEFAULT nextval('public.tipos_memoria_id_tipo_memoria_seq'::regclass);


--
-- TOC entry 2317 (class 2604 OID 17406)
-- Name: tipos_software id_tipo_software; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_software ALTER COLUMN id_tipo_software SET DEFAULT nextval('public.tipos_software_id_tipo_software_seq'::regclass);


--
-- TOC entry 2336 (class 2604 OID 17546)
-- Name: tipos_solicitud id_tipo_solicitud; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_solicitud ALTER COLUMN id_tipo_solicitud SET DEFAULT nextval('public.tipo_solicitud_id_tipo_solicitud_seq'::regclass);


--
-- TOC entry 2320 (class 2604 OID 17407)
-- Name: ubicaciones id_ubicacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicaciones ALTER COLUMN id_ubicacion SET DEFAULT nextval('public.ubicaciones_id_ubicacion_seq'::regclass);


--
-- TOC entry 2318 (class 2604 OID 17408)
-- Name: ups id_ups; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups ALTER COLUMN id_ups SET DEFAULT nextval('public.ups_id_ups_seq'::regclass);


--
-- TOC entry 2334 (class 2604 OID 17459)
-- Name: usuarios id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuarios_id_usuario_seq'::regclass);


--
-- TOC entry 2330 (class 2604 OID 17425)
-- Name: velocidad id_velocidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.velocidad ALTER COLUMN id_velocidad SET DEFAULT nextval('public.velocidad_id_velocidad_seq'::regclass);


--
-- TOC entry 2364 (class 2606 OID 17030)
-- Name: arquitecturas id_arquitectura; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.arquitecturas
    ADD CONSTRAINT id_arquitectura PRIMARY KEY (id_arquitectura);


--
-- TOC entry 2354 (class 2606 OID 17028)
-- Name: capacidades id_capacidad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capacidades
    ADD CONSTRAINT id_capacidad PRIMARY KEY (id_capacidad);


--
-- TOC entry 2368 (class 2606 OID 17022)
-- Name: componentes id_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_componente PRIMARY KEY (id_componente);


--
-- TOC entry 2414 (class 2606 OID 17515)
-- Name: componentes_equipo id_componente_equipo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes_equipo
    ADD CONSTRAINT id_componente_equipo PRIMARY KEY (id_componente_equipo);


--
-- TOC entry 2388 (class 2606 OID 17089)
-- Name: cronograma id_cronograma; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma
    ADD CONSTRAINT id_cronograma PRIMARY KEY (id_cronograma);


--
-- TOC entry 2394 (class 2606 OID 17329)
-- Name: detalles_orden_trabajo id_detalle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_detalle PRIMARY KEY (id_detalle);


--
-- TOC entry 2402 (class 2606 OID 17473)
-- Name: dimension_disco id_dimension; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dimension_disco
    ADD CONSTRAINT id_dimension PRIMARY KEY (id_dimension);


--
-- TOC entry 2344 (class 2606 OID 17127)
-- Name: discos id_disco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_disco PRIMARY KEY (id_disco);


--
-- TOC entry 2382 (class 2606 OID 17070)
-- Name: equipos id_equipo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_equipo PRIMARY KEY (id_equipo);


--
-- TOC entry 2350 (class 2606 OID 17268)
-- Name: fuentes id_fuente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes
    ADD CONSTRAINT id_fuente PRIMARY KEY (id_fuente);


--
-- TOC entry 2366 (class 2606 OID 17236)
-- Name: hardware_componente id_hardware_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_hardware_componente PRIMARY KEY (id_hardware_componente);


--
-- TOC entry 2398 (class 2606 OID 17050)
-- Name: mantenimientos id_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos
    ADD CONSTRAINT id_mantenimiento PRIMARY KEY (id_mantenimiento);


--
-- TOC entry 2360 (class 2606 OID 17036)
-- Name: marcas id_marca; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT id_marca PRIMARY KEY (id_marca);


--
-- TOC entry 2342 (class 2606 OID 17110)
-- Name: memorias id_memoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_memoria PRIMARY KEY (id_memoria);


--
-- TOC entry 2362 (class 2606 OID 17056)
-- Name: modelos id_modelo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT id_modelo PRIMARY KEY (id_modelo);


--
-- TOC entry 2348 (class 2606 OID 17166)
-- Name: motherboards id_motherboard; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_motherboard PRIMARY KEY (id_motherboard);


--
-- TOC entry 2392 (class 2606 OID 17302)
-- Name: ordenes_trabajo id_orden_trabajo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_orden_trabajo PRIMARY KEY (id_orden_trabajo);


--
-- TOC entry 2410 (class 2606 OID 17501)
-- Name: potencia_ups id_potencia; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.potencia_ups
    ADD CONSTRAINT id_potencia PRIMARY KEY (id_potencia);


--
-- TOC entry 2346 (class 2606 OID 17149)
-- Name: procesadores id_procesador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_procesador PRIMARY KEY (id_procesador);


--
-- TOC entry 2356 (class 2606 OID 17032)
-- Name: puertos id_puerto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puertos
    ADD CONSTRAINT id_puerto PRIMARY KEY (id_puerto);


--
-- TOC entry 2386 (class 2606 OID 17040)
-- Name: responsables id_responsable; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables
    ADD CONSTRAINT id_responsable PRIMARY KEY (id_responsable);


--
-- TOC entry 2408 (class 2606 OID 17489)
-- Name: salida_tarjeta_video id_salida_tarjeta_video; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salida_tarjeta_video
    ADD CONSTRAINT id_salida_tarjeta_video PRIMARY KEY (id_salida_tarjeta_video);


--
-- TOC entry 2406 (class 2606 OID 17487)
-- Name: salida_video id_salida_video; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salida_video
    ADD CONSTRAINT id_salida_video PRIMARY KEY (id_salida_video);


--
-- TOC entry 2358 (class 2606 OID 17034)
-- Name: sockets id_socket; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sockets
    ADD CONSTRAINT id_socket PRIMARY KEY (id_socket);


--
-- TOC entry 2372 (class 2606 OID 17096)
-- Name: software id_software; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_software PRIMARY KEY (id_software);


--
-- TOC entry 2370 (class 2606 OID 17190)
-- Name: software_componente id_software_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_software_componente PRIMARY KEY (id_software_componente);


--
-- TOC entry 2390 (class 2606 OID 17295)
-- Name: solicitudes id_solicitud; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_solicitud PRIMARY KEY (id_solicitud);


--
-- TOC entry 2374 (class 2606 OID 17052)
-- Name: soluciones id_solucion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soluciones
    ADD CONSTRAINT id_solucion PRIMARY KEY (id_solucion);


--
-- TOC entry 2352 (class 2606 OID 17178)
-- Name: tarjetas_video id_tarjeta_video; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_tarjeta_video PRIMARY KEY (id_tarjeta_video);


--
-- TOC entry 2400 (class 2606 OID 17044)
-- Name: tecnicos id_tecnico; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tecnicos
    ADD CONSTRAINT id_tecnico PRIMARY KEY (id_tecnico);


--
-- TOC entry 2376 (class 2606 OID 17108)
-- Name: tipos_componente id_tipo_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_componente
    ADD CONSTRAINT id_tipo_componente PRIMARY KEY (id_tipo_componente);


--
-- TOC entry 2340 (class 2606 OID 17024)
-- Name: tipos_disco id_tipo_disco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_disco
    ADD CONSTRAINT id_tipo_disco PRIMARY KEY (id_tipo_disco);


--
-- TOC entry 2396 (class 2606 OID 17063)
-- Name: tipos_mantenimiento id_tipo_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento
    ADD CONSTRAINT id_tipo_mantenimiento PRIMARY KEY (id_tipo_mantenimiento);


--
-- TOC entry 2338 (class 2606 OID 17026)
-- Name: tipos_memoria id_tipo_memoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_memoria
    ADD CONSTRAINT id_tipo_memoria PRIMARY KEY (id_tipo_memoria);


--
-- TOC entry 2378 (class 2606 OID 17054)
-- Name: tipos_software id_tipo_software; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_software
    ADD CONSTRAINT id_tipo_software PRIMARY KEY (id_tipo_software);


--
-- TOC entry 2416 (class 2606 OID 17551)
-- Name: tipos_solicitud id_tipo_solicitud; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_solicitud
    ADD CONSTRAINT id_tipo_solicitud PRIMARY KEY (id_tipo_solicitud);


--
-- TOC entry 2384 (class 2606 OID 17038)
-- Name: ubicaciones id_ubicacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicaciones
    ADD CONSTRAINT id_ubicacion PRIMARY KEY (id_ubicacion);


--
-- TOC entry 2380 (class 2606 OID 17202)
-- Name: ups id_ups; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups
    ADD CONSTRAINT id_ups PRIMARY KEY (id_ups);


--
-- TOC entry 2412 (class 2606 OID 17508)
-- Name: usuarios id_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT id_usuario PRIMARY KEY (id_usuario);


--
-- TOC entry 2404 (class 2606 OID 17480)
-- Name: velocidad id_velocidad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.velocidad
    ADD CONSTRAINT id_velocidad PRIMARY KEY (id_velocidad);


--
-- TOC entry 2447 (class 2606 OID 17102)
-- Name: software id_arquitectura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_arquitectura FOREIGN KEY (id_arquitectura) REFERENCES public.arquitecturas(id_arquitectura);


--
-- TOC entry 2427 (class 2606 OID 17155)
-- Name: procesadores id_arquitectura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_arquitectura FOREIGN KEY (id_arquitectura) REFERENCES public.arquitecturas(id_arquitectura);


--
-- TOC entry 2419 (class 2606 OID 17121)
-- Name: memorias id_capacidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_capacidad FOREIGN KEY (id_capacidad) REFERENCES public.capacidades(id_capacidad);


--
-- TOC entry 2422 (class 2606 OID 17133)
-- Name: discos id_capacidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_capacidad FOREIGN KEY (id_capacidad) REFERENCES public.capacidades(id_capacidad);


--
-- TOC entry 2445 (class 2606 OID 17196)
-- Name: software_componente id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2449 (class 2606 OID 17203)
-- Name: ups id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2435 (class 2606 OID 17237)
-- Name: hardware_componente id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2469 (class 2606 OID 17521)
-- Name: componentes_equipo id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes_equipo
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2425 (class 2606 OID 17474)
-- Name: discos id_dimension; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_dimension FOREIGN KEY (id_dimension) REFERENCES public.dimension_disco(id_dimension);


--
-- TOC entry 2437 (class 2606 OID 17247)
-- Name: hardware_componente id_disco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_disco FOREIGN KEY (id_disco) REFERENCES public.discos(id_disco);


--
-- TOC entry 2454 (class 2606 OID 17090)
-- Name: cronograma id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2468 (class 2606 OID 17516)
-- Name: componentes_equipo id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes_equipo
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2461 (class 2606 OID 17536)
-- Name: ordenes_trabajo id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2441 (class 2606 OID 17274)
-- Name: hardware_componente id_fuente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_fuente FOREIGN KEY (id_fuente) REFERENCES public.fuentes(id_fuente);


--
-- TOC entry 2464 (class 2606 OID 17064)
-- Name: tipos_mantenimiento id_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento
    ADD CONSTRAINT id_mantenimiento FOREIGN KEY (id_mantenimiento) REFERENCES public.mantenimientos(id_mantenimiento);


--
-- TOC entry 2459 (class 2606 OID 17308)
-- Name: ordenes_trabajo id_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_mantenimiento FOREIGN KEY (id_mantenimiento) REFERENCES public.mantenimientos(id_mantenimiento);


--
-- TOC entry 2434 (class 2606 OID 17057)
-- Name: modelos id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2417 (class 2606 OID 17111)
-- Name: memorias id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2421 (class 2606 OID 17128)
-- Name: discos id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2429 (class 2606 OID 17167)
-- Name: motherboards id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2432 (class 2606 OID 17179)
-- Name: tarjetas_video id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2436 (class 2606 OID 17242)
-- Name: hardware_componente id_memoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_memoria FOREIGN KEY (id_memoria) REFERENCES public.memorias(id_memoria);


--
-- TOC entry 2426 (class 2606 OID 17150)
-- Name: procesadores id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2431 (class 2606 OID 17269)
-- Name: fuentes id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2443 (class 2606 OID 17284)
-- Name: componentes id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2439 (class 2606 OID 17257)
-- Name: hardware_componente id_motherboard; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_motherboard FOREIGN KEY (id_motherboard) REFERENCES public.motherboards(id_motherboard);


--
-- TOC entry 2462 (class 2606 OID 17330)
-- Name: detalles_orden_trabajo id_orden_trabajo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_orden_trabajo FOREIGN KEY (id_orden_trabajo) REFERENCES public.ordenes_trabajo(id_orden_trabajo);


--
-- TOC entry 2450 (class 2606 OID 17502)
-- Name: ups id_potencia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups
    ADD CONSTRAINT id_potencia FOREIGN KEY (id_potencia) REFERENCES public.potencia_ups(id_potencia);


--
-- TOC entry 2438 (class 2606 OID 17252)
-- Name: hardware_componente id_procesador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_procesador FOREIGN KEY (id_procesador) REFERENCES public.procesadores(id_procesador);


--
-- TOC entry 2423 (class 2606 OID 17138)
-- Name: discos id_puerto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_puerto FOREIGN KEY (id_puerto) REFERENCES public.puertos(id_puerto);


--
-- TOC entry 2433 (class 2606 OID 17184)
-- Name: tarjetas_video id_puerto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_puerto FOREIGN KEY (id_puerto) REFERENCES public.puertos(id_puerto);


--
-- TOC entry 2455 (class 2606 OID 17531)
-- Name: solicitudes id_responsable; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_responsable FOREIGN KEY (id_responsable) REFERENCES public.responsables(id_responsable);


--
-- TOC entry 2452 (class 2606 OID 17348)
-- Name: equipos id_responsables; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_responsables FOREIGN KEY (id_responsable) REFERENCES public.responsables(id_responsable);


--
-- TOC entry 2465 (class 2606 OID 17490)
-- Name: salida_tarjeta_video id_salida_video; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salida_tarjeta_video
    ADD CONSTRAINT id_salida_video FOREIGN KEY (id_salida_video) REFERENCES public.salida_video(id_salida_video);


--
-- TOC entry 2428 (class 2606 OID 17160)
-- Name: procesadores id_socket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_socket FOREIGN KEY (id_socket) REFERENCES public.sockets(id_socket);


--
-- TOC entry 2430 (class 2606 OID 17172)
-- Name: motherboards id_socket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_socket FOREIGN KEY (id_socket) REFERENCES public.sockets(id_socket);


--
-- TOC entry 2444 (class 2606 OID 17191)
-- Name: software_componente id_software; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_software FOREIGN KEY (id_software) REFERENCES public.software(id_software);


--
-- TOC entry 2458 (class 2606 OID 17303)
-- Name: ordenes_trabajo id_solicitud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_solicitud FOREIGN KEY (id_solicitud) REFERENCES public.solicitudes(id_solicitud);


--
-- TOC entry 2463 (class 2606 OID 17340)
-- Name: detalles_orden_trabajo id_solucion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_solucion FOREIGN KEY (id_solucion) REFERENCES public.soluciones(id_solucion);


--
-- TOC entry 2440 (class 2606 OID 17262)
-- Name: hardware_componente id_tarjeta_video; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_tarjeta_video FOREIGN KEY (id_tarjeta_video) REFERENCES public.tarjetas_video(id_tarjeta_video);


--
-- TOC entry 2466 (class 2606 OID 17495)
-- Name: salida_tarjeta_video id_tarjeta_video; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salida_tarjeta_video
    ADD CONSTRAINT id_tarjeta_video FOREIGN KEY (id_tarjeta_video) REFERENCES public.tarjetas_video(id_tarjeta_video);


--
-- TOC entry 2460 (class 2606 OID 17313)
-- Name: ordenes_trabajo id_tecnico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_tecnico FOREIGN KEY (id_tecnico) REFERENCES public.tecnicos(id_tecnico);


--
-- TOC entry 2442 (class 2606 OID 17279)
-- Name: componentes id_tipo_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_tipo_componente FOREIGN KEY (id_tipo_componente) REFERENCES public.tipos_componente(id_tipo_componente);


--
-- TOC entry 2424 (class 2606 OID 17143)
-- Name: discos id_tipo_disco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_tipo_disco FOREIGN KEY (id_tipo_disco) REFERENCES public.tipos_disco(id_tipo_disco);


--
-- TOC entry 2448 (class 2606 OID 17526)
-- Name: soluciones id_tipo_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soluciones
    ADD CONSTRAINT id_tipo_mantenimiento FOREIGN KEY (id_tipo_mantenimiento) REFERENCES public.tipos_mantenimiento(id_tipo_mantenimiento);


--
-- TOC entry 2418 (class 2606 OID 17116)
-- Name: memorias id_tipo_memoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_tipo_memoria FOREIGN KEY (id_tipo) REFERENCES public.tipos_memoria(id_tipo_memoria);


--
-- TOC entry 2446 (class 2606 OID 17097)
-- Name: software id_tipo_software; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_tipo_software FOREIGN KEY (id_tipo_software) REFERENCES public.tipos_software(id_tipo_software);


--
-- TOC entry 2456 (class 2606 OID 17552)
-- Name: solicitudes id_tipo_solicitud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_tipo_solicitud FOREIGN KEY (id_tipo_solicitud) REFERENCES public.tipos_solicitud(id_tipo_solicitud);


--
-- TOC entry 2451 (class 2606 OID 17071)
-- Name: equipos id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


--
-- TOC entry 2453 (class 2606 OID 17353)
-- Name: responsables id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


--
-- TOC entry 2467 (class 2606 OID 17509)
-- Name: usuarios id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


--
-- TOC entry 2457 (class 2606 OID 17557)
-- Name: solicitudes id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


--
-- TOC entry 2420 (class 2606 OID 17481)
-- Name: memorias id_velocidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_velocidad FOREIGN KEY (id_velocidad) REFERENCES public.velocidad(id_velocidad);


-- Completed on 2019-03-24 17:49:55

--
-- PostgreSQL database dump complete
--

