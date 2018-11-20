--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-20 11:31:59

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
-- TOC entry 2540 (class 0 OID 0)
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
-- TOC entry 231 (class 1259 OID 16697)
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
-- TOC entry 2541 (class 0 OID 0)
-- Dependencies: 231
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
-- TOC entry 232 (class 1259 OID 16706)
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
-- TOC entry 2542 (class 0 OID 0)
-- Dependencies: 232
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
    id_equipo integer,
    numero_inventario text,
    numero_serie text,
    estado boolean,
    personal boolean,
    asignado boolean,
    observaciones text
);


ALTER TABLE public.componentes OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16715)
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
-- TOC entry 2543 (class 0 OID 0)
-- Dependencies: 233
-- Name: componentes_id_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.componentes_id_componente_seq OWNED BY public.componentes.id_componente;


--
-- TOC entry 222 (class 1259 OID 16667)
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
-- TOC entry 234 (class 1259 OID 16725)
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
-- TOC entry 2544 (class 0 OID 0)
-- Dependencies: 234
-- Name: cronograma_id_cronograma_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cronograma_id_cronograma_seq OWNED BY public.cronograma.id_cronograma;


--
-- TOC entry 227 (class 1259 OID 16685)
-- Name: detalles_orden_trabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalles_orden_trabajo (
    id_detalle integer NOT NULL,
    id_orden_trabajo integer NOT NULL,
    id_tipo_mantenimiento integer NOT NULL,
    id_solucion integer NOT NULL,
    observaciones text
);


ALTER TABLE public.detalles_orden_trabajo OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16731)
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
-- TOC entry 2545 (class 0 OID 0)
-- Dependencies: 235
-- Name: detalles_orden_trabajo_id_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalles_orden_trabajo_id_detalle_seq OWNED BY public.detalles_orden_trabajo.id_detalle;


--
-- TOC entry 221 (class 1259 OID 16664)
-- Name: dia_no_laboral; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dia_no_laboral (
    id_dia integer NOT NULL,
    fecha date NOT NULL
);


ALTER TABLE public.dia_no_laboral OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 16740)
-- Name: dia_no_laboral_id_dia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dia_no_laboral_id_dia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dia_no_laboral_id_dia_seq OWNER TO postgres;

--
-- TOC entry 2546 (class 0 OID 0)
-- Dependencies: 236
-- Name: dia_no_laboral_id_dia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dia_no_laboral_id_dia_seq OWNED BY public.dia_no_laboral.id_dia;


--
-- TOC entry 199 (class 1259 OID 16598)
-- Name: discos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discos (
    id_disco integer NOT NULL,
    id_marca integer NOT NULL,
    id_capacidad integer NOT NULL,
    id_puerto integer NOT NULL,
    id_tipo_disco integer NOT NULL,
    numero_serie text
);


ALTER TABLE public.discos OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16746)
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
-- TOC entry 2547 (class 0 OID 0)
-- Dependencies: 237
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
    obsevaciones text
);


ALTER TABLE public.equipos OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 16755)
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
-- TOC entry 2548 (class 0 OID 0)
-- Dependencies: 238
-- Name: equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipo_id_equipo_seq OWNED BY public.equipos.id_equipo;


--
-- TOC entry 226 (class 1259 OID 16682)
-- Name: estados_orden; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estados_orden (
    id_estado integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.estados_orden OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 16773)
-- Name: estado_ordenes_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_ordenes_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_ordenes_id_estado_seq OWNER TO postgres;

--
-- TOC entry 2549 (class 0 OID 0)
-- Dependencies: 239
-- Name: estado_ordenes_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_ordenes_id_estado_seq OWNED BY public.estados_orden.id_estado;


--
-- TOC entry 225 (class 1259 OID 16679)
-- Name: estados_solicitud; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estados_solicitud (
    id_estado integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.estados_solicitud OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 16782)
-- Name: estados_solicitud_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estados_solicitud_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estados_solicitud_id_estado_seq OWNER TO postgres;

--
-- TOC entry 2550 (class 0 OID 0)
-- Dependencies: 240
-- Name: estados_solicitud_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estados_solicitud_id_estado_seq OWNED BY public.estados_solicitud.id_estado;


--
-- TOC entry 202 (class 1259 OID 16607)
-- Name: fuentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fuentes (
    id_fuente integer NOT NULL,
    id_modelo integer NOT NULL,
    potencia text,
    numero_pines text,
    numero_serie text
);


ALTER TABLE public.fuentes OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 16791)
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
-- TOC entry 2551 (class 0 OID 0)
-- Dependencies: 241
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
-- TOC entry 242 (class 1259 OID 16800)
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
-- TOC entry 2552 (class 0 OID 0)
-- Dependencies: 242
-- Name: hardware_componente_id_hardware_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hardware_componente_id_hardware_componente_seq OWNED BY public.hardware_componente.id_hardware_componente;


--
-- TOC entry 229 (class 1259 OID 16691)
-- Name: mantenimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mantenimientos (
    id_mantenimiento integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.mantenimientos OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 16810)
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
-- TOC entry 2553 (class 0 OID 0)
-- Dependencies: 243
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
-- TOC entry 244 (class 1259 OID 16819)
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
-- TOC entry 2554 (class 0 OID 0)
-- Dependencies: 244
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
    numero_serie text
);


ALTER TABLE public.memorias OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 16828)
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
-- TOC entry 2555 (class 0 OID 0)
-- Dependencies: 245
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
-- TOC entry 246 (class 1259 OID 16837)
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
-- TOC entry 2556 (class 0 OID 0)
-- Dependencies: 246
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
    numero_serie text
);


ALTER TABLE public.motherboards OWNER TO postgres;

--
-- TOC entry 247 (class 1259 OID 16846)
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
-- TOC entry 2557 (class 0 OID 0)
-- Dependencies: 247
-- Name: motherboards_id_motherboard_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.motherboards_id_motherboard_seq OWNED BY public.motherboards.id_motherboard;


--
-- TOC entry 224 (class 1259 OID 16676)
-- Name: ordenes_trabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordenes_trabajo (
    id_orden_trabajo integer NOT NULL,
    id_solicitud integer NOT NULL,
    id_mantenimiento integer NOT NULL,
    id_tecnico integer NOT NULL,
    prioridad text,
    fecha_inicio date,
    fecha_finalizacion date,
    hora_inicio text,
    hora_finalizacion text,
    id_estado integer,
    observaciones text
);


ALTER TABLE public.ordenes_trabajo OWNER TO postgres;

--
-- TOC entry 248 (class 1259 OID 16855)
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
-- TOC entry 2558 (class 0 OID 0)
-- Dependencies: 248
-- Name: ordenes_trabajo_id_orden_trabajo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ordenes_trabajo_id_orden_trabajo_seq OWNED BY public.ordenes_trabajo.id_orden_trabajo;


--
-- TOC entry 200 (class 1259 OID 16601)
-- Name: procesadores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.procesadores (
    id_procesador integer NOT NULL,
    id_modelo integer NOT NULL,
    id_arquitectura integer NOT NULL,
    id_socket integer,
    numero_serie text
);


ALTER TABLE public.procesadores OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 16864)
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
-- TOC entry 2559 (class 0 OID 0)
-- Dependencies: 249
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
-- TOC entry 250 (class 1259 OID 16873)
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
-- TOC entry 2560 (class 0 OID 0)
-- Dependencies: 250
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
-- TOC entry 251 (class 1259 OID 16882)
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
-- TOC entry 2561 (class 0 OID 0)
-- Dependencies: 251
-- Name: resposables_id_responsable_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resposables_id_responsable_seq OWNED BY public.responsables.id_responsable;


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
-- TOC entry 252 (class 1259 OID 16891)
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
-- TOC entry 2562 (class 0 OID 0)
-- Dependencies: 252
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
-- TOC entry 254 (class 1259 OID 16910)
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
-- TOC entry 2563 (class 0 OID 0)
-- Dependencies: 254
-- Name: software_componente_id_software_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.software_componente_id_software_componente_seq OWNED BY public.software_componente.id_software_componente;


--
-- TOC entry 253 (class 1259 OID 16901)
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
-- TOC entry 2564 (class 0 OID 0)
-- Dependencies: 253
-- Name: software_id_software_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.software_id_software_seq OWNED BY public.software.id_software;


--
-- TOC entry 223 (class 1259 OID 16673)
-- Name: solicitudes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solicitudes (
    id_solicitud integer NOT NULL,
    id_equipo integer NOT NULL,
    nombre_solicitante text NOT NULL,
    fecha_solicitud date NOT NULL,
    problema text NOT NULL,
    id_estado integer
);


ALTER TABLE public.solicitudes OWNER TO postgres;

--
-- TOC entry 255 (class 1259 OID 16919)
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
-- TOC entry 2565 (class 0 OID 0)
-- Dependencies: 255
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
    descripcion text
);


ALTER TABLE public.soluciones OWNER TO postgres;

--
-- TOC entry 256 (class 1259 OID 16928)
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
-- TOC entry 2566 (class 0 OID 0)
-- Dependencies: 256
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
    numero_serial text
);


ALTER TABLE public.tarjetas_video OWNER TO postgres;

--
-- TOC entry 257 (class 1259 OID 16937)
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
-- TOC entry 2567 (class 0 OID 0)
-- Dependencies: 257
-- Name: tarjetas_video_id_tarjeta_video_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarjetas_video_id_tarjeta_video_seq OWNED BY public.tarjetas_video.id_tarjeta_video;


--
-- TOC entry 230 (class 1259 OID 16694)
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
-- TOC entry 258 (class 1259 OID 16946)
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
-- TOC entry 2568 (class 0 OID 0)
-- Dependencies: 258
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
-- TOC entry 259 (class 1259 OID 16955)
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
-- TOC entry 2569 (class 0 OID 0)
-- Dependencies: 259
-- Name: tipo_componente_id_tipo_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_componente_id_tipo_componente_seq OWNED BY public.tipos_componente.id_tipo_componente;


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
-- TOC entry 260 (class 1259 OID 16964)
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
-- TOC entry 2570 (class 0 OID 0)
-- Dependencies: 260
-- Name: tipos_disco_id_tipo_disco_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_disco_id_tipo_disco_seq OWNED BY public.tipos_disco.id_tipo_disco;


--
-- TOC entry 228 (class 1259 OID 16688)
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
-- TOC entry 261 (class 1259 OID 16973)
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
-- TOC entry 2571 (class 0 OID 0)
-- Dependencies: 261
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
-- TOC entry 262 (class 1259 OID 16982)
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
-- TOC entry 2572 (class 0 OID 0)
-- Dependencies: 262
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
-- TOC entry 263 (class 1259 OID 16992)
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
-- TOC entry 2573 (class 0 OID 0)
-- Dependencies: 263
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
-- TOC entry 264 (class 1259 OID 17001)
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
-- TOC entry 2574 (class 0 OID 0)
-- Dependencies: 264
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
    observaciones text
);


ALTER TABLE public.ups OWNER TO postgres;

--
-- TOC entry 265 (class 1259 OID 17010)
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
-- TOC entry 2575 (class 0 OID 0)
-- Dependencies: 265
-- Name: ups_id_ups_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ups_id_ups_seq OWNED BY public.ups.id_ups;


--
-- TOC entry 2275 (class 2604 OID 16699)
-- Name: arquitecturas id_arquitectura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.arquitecturas ALTER COLUMN id_arquitectura SET DEFAULT nextval('public.arquitecturas_id_arquitectura_seq'::regclass);


--
-- TOC entry 2270 (class 2604 OID 16708)
-- Name: capacidades id_capacidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capacidades ALTER COLUMN id_capacidad SET DEFAULT nextval('public.capacidades_id_capacidad_seq'::regclass);


--
-- TOC entry 2277 (class 2604 OID 16717)
-- Name: componentes id_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes ALTER COLUMN id_componente SET DEFAULT nextval('public.componentes_id_componente_seq'::regclass);


--
-- TOC entry 2288 (class 2604 OID 16727)
-- Name: cronograma id_cronograma; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma ALTER COLUMN id_cronograma SET DEFAULT nextval('public.cronograma_id_cronograma_seq'::regclass);


--
-- TOC entry 2293 (class 2604 OID 16733)
-- Name: detalles_orden_trabajo id_detalle; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo ALTER COLUMN id_detalle SET DEFAULT nextval('public.detalles_orden_trabajo_id_detalle_seq'::regclass);


--
-- TOC entry 2287 (class 2604 OID 16742)
-- Name: dia_no_laboral id_dia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dia_no_laboral ALTER COLUMN id_dia SET DEFAULT nextval('public.dia_no_laboral_id_dia_seq'::regclass);


--
-- TOC entry 2265 (class 2604 OID 16748)
-- Name: discos id_disco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos ALTER COLUMN id_disco SET DEFAULT nextval('public.discos_id_discos_seq'::regclass);


--
-- TOC entry 2284 (class 2604 OID 16757)
-- Name: equipos id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos ALTER COLUMN id_equipo SET DEFAULT nextval('public.equipo_id_equipo_seq'::regclass);


--
-- TOC entry 2292 (class 2604 OID 16775)
-- Name: estados_orden id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_orden ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_ordenes_id_estado_seq'::regclass);


--
-- TOC entry 2291 (class 2604 OID 16784)
-- Name: estados_solicitud id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_solicitud ALTER COLUMN id_estado SET DEFAULT nextval('public.estados_solicitud_id_estado_seq'::regclass);


--
-- TOC entry 2268 (class 2604 OID 16793)
-- Name: fuentes id_fuente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes ALTER COLUMN id_fuente SET DEFAULT nextval('public.fuentes_id_fuente_seq'::regclass);


--
-- TOC entry 2276 (class 2604 OID 16802)
-- Name: hardware_componente id_hardware_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente ALTER COLUMN id_hardware_componente SET DEFAULT nextval('public.hardware_componente_id_hardware_componente_seq'::regclass);


--
-- TOC entry 2295 (class 2604 OID 16812)
-- Name: mantenimientos id_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos ALTER COLUMN id_mantenimiento SET DEFAULT nextval('public.mantenimientos_id_mantenimiento_seq'::regclass);


--
-- TOC entry 2273 (class 2604 OID 16821)
-- Name: marcas id_marca; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcas ALTER COLUMN id_marca SET DEFAULT nextval('public.marcas_id_marca_seq'::regclass);


--
-- TOC entry 2264 (class 2604 OID 16830)
-- Name: memorias id_memoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias ALTER COLUMN id_memoria SET DEFAULT nextval('public.memorias_id_memoria_seq'::regclass);


--
-- TOC entry 2274 (class 2604 OID 16839)
-- Name: modelos id_modelo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos ALTER COLUMN id_modelo SET DEFAULT nextval('public.modelos_id_modelo_seq'::regclass);


--
-- TOC entry 2267 (class 2604 OID 16848)
-- Name: motherboards id_motherboard; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards ALTER COLUMN id_motherboard SET DEFAULT nextval('public.motherboards_id_motherboard_seq'::regclass);


--
-- TOC entry 2290 (class 2604 OID 16857)
-- Name: ordenes_trabajo id_orden_trabajo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo ALTER COLUMN id_orden_trabajo SET DEFAULT nextval('public.ordenes_trabajo_id_orden_trabajo_seq'::regclass);


--
-- TOC entry 2266 (class 2604 OID 16866)
-- Name: procesadores id_procesador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores ALTER COLUMN id_procesador SET DEFAULT nextval('public.procesadores_id_procesador_seq'::regclass);


--
-- TOC entry 2271 (class 2604 OID 16875)
-- Name: puertos id_puerto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puertos ALTER COLUMN id_puerto SET DEFAULT nextval('public.puertos_id_puerto_seq'::regclass);


--
-- TOC entry 2286 (class 2604 OID 16884)
-- Name: responsables id_responsable; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables ALTER COLUMN id_responsable SET DEFAULT nextval('public.resposables_id_responsable_seq'::regclass);


--
-- TOC entry 2272 (class 2604 OID 16893)
-- Name: sockets id_socket; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sockets ALTER COLUMN id_socket SET DEFAULT nextval('public.sockets_id_socket_seq'::regclass);


--
-- TOC entry 2279 (class 2604 OID 16903)
-- Name: software id_software; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software ALTER COLUMN id_software SET DEFAULT nextval('public.software_id_software_seq'::regclass);


--
-- TOC entry 2278 (class 2604 OID 16912)
-- Name: software_componente id_software_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente ALTER COLUMN id_software_componente SET DEFAULT nextval('public.software_componente_id_software_componente_seq'::regclass);


--
-- TOC entry 2289 (class 2604 OID 16921)
-- Name: solicitudes id_solicitud; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes ALTER COLUMN id_solicitud SET DEFAULT nextval('public.solicitudes_id_solicitud_seq'::regclass);


--
-- TOC entry 2280 (class 2604 OID 16930)
-- Name: soluciones id_solucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soluciones ALTER COLUMN id_solucion SET DEFAULT nextval('public.soluciones_id_solucion_seq'::regclass);


--
-- TOC entry 2269 (class 2604 OID 16939)
-- Name: tarjetas_video id_tarjeta_video; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video ALTER COLUMN id_tarjeta_video SET DEFAULT nextval('public.tarjetas_video_id_tarjeta_video_seq'::regclass);


--
-- TOC entry 2296 (class 2604 OID 16948)
-- Name: tecnicos id_tecnico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tecnicos ALTER COLUMN id_tecnico SET DEFAULT nextval('public.tecnicos_id_tecnico_seq'::regclass);


--
-- TOC entry 2281 (class 2604 OID 16957)
-- Name: tipos_componente id_tipo_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_componente ALTER COLUMN id_tipo_componente SET DEFAULT nextval('public.tipo_componente_id_tipo_componente_seq'::regclass);


--
-- TOC entry 2263 (class 2604 OID 16966)
-- Name: tipos_disco id_tipo_disco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_disco ALTER COLUMN id_tipo_disco SET DEFAULT nextval('public.tipos_disco_id_tipo_disco_seq'::regclass);


--
-- TOC entry 2294 (class 2604 OID 16975)
-- Name: tipos_mantenimiento id_tipo_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento ALTER COLUMN id_tipo_mantenimiento SET DEFAULT nextval('public.tipos_mantenimiento_id_tipo_mantenimiento_seq'::regclass);


--
-- TOC entry 2262 (class 2604 OID 16984)
-- Name: tipos_memoria id_tipo_memoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_memoria ALTER COLUMN id_tipo_memoria SET DEFAULT nextval('public.tipos_memoria_id_tipo_memoria_seq'::regclass);


--
-- TOC entry 2282 (class 2604 OID 16994)
-- Name: tipos_software id_tipo_software; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_software ALTER COLUMN id_tipo_software SET DEFAULT nextval('public.tipos_software_id_tipo_software_seq'::regclass);


--
-- TOC entry 2285 (class 2604 OID 17003)
-- Name: ubicaciones id_ubicacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicaciones ALTER COLUMN id_ubicacion SET DEFAULT nextval('public.ubicaciones_id_ubicacion_seq'::regclass);


--
-- TOC entry 2283 (class 2604 OID 17012)
-- Name: ups id_ups; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups ALTER COLUMN id_ups SET DEFAULT nextval('public.ups_id_ups_seq'::regclass);


--
-- TOC entry 2324 (class 2606 OID 17030)
-- Name: arquitecturas id_arquitectura; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.arquitecturas
    ADD CONSTRAINT id_arquitectura PRIMARY KEY (id_arquitectura);


--
-- TOC entry 2314 (class 2606 OID 17028)
-- Name: capacidades id_capacidad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capacidades
    ADD CONSTRAINT id_capacidad PRIMARY KEY (id_capacidad);


--
-- TOC entry 2328 (class 2606 OID 17022)
-- Name: componentes id_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_componente PRIMARY KEY (id_componente);


--
-- TOC entry 2350 (class 2606 OID 17089)
-- Name: cronograma id_cronograma; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma
    ADD CONSTRAINT id_cronograma PRIMARY KEY (id_cronograma);


--
-- TOC entry 2360 (class 2606 OID 17329)
-- Name: detalles_orden_trabajo id_detalle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_detalle PRIMARY KEY (id_detalle);


--
-- TOC entry 2348 (class 2606 OID 17042)
-- Name: dia_no_laboral id_dia; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dia_no_laboral
    ADD CONSTRAINT id_dia PRIMARY KEY (id_dia);


--
-- TOC entry 2304 (class 2606 OID 17127)
-- Name: discos id_disco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_disco PRIMARY KEY (id_disco);


--
-- TOC entry 2342 (class 2606 OID 17070)
-- Name: equipos id_equipo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_equipo PRIMARY KEY (id_equipo);


--
-- TOC entry 2358 (class 2606 OID 17046)
-- Name: estados_orden id_estado_orden; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_orden
    ADD CONSTRAINT id_estado_orden PRIMARY KEY (id_estado);


--
-- TOC entry 2356 (class 2606 OID 17048)
-- Name: estados_solicitud id_estado_solicitud; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_solicitud
    ADD CONSTRAINT id_estado_solicitud PRIMARY KEY (id_estado);


--
-- TOC entry 2310 (class 2606 OID 17268)
-- Name: fuentes id_fuente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes
    ADD CONSTRAINT id_fuente PRIMARY KEY (id_fuente);


--
-- TOC entry 2326 (class 2606 OID 17236)
-- Name: hardware_componente id_hardware_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_hardware_componente PRIMARY KEY (id_hardware_componente);


--
-- TOC entry 2364 (class 2606 OID 17050)
-- Name: mantenimientos id_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos
    ADD CONSTRAINT id_mantenimiento PRIMARY KEY (id_mantenimiento);


--
-- TOC entry 2320 (class 2606 OID 17036)
-- Name: marcas id_marca; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT id_marca PRIMARY KEY (id_marca);


--
-- TOC entry 2302 (class 2606 OID 17110)
-- Name: memorias id_memoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_memoria PRIMARY KEY (id_memoria);


--
-- TOC entry 2322 (class 2606 OID 17056)
-- Name: modelos id_modelo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT id_modelo PRIMARY KEY (id_modelo);


--
-- TOC entry 2308 (class 2606 OID 17166)
-- Name: motherboards id_motherboard; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_motherboard PRIMARY KEY (id_motherboard);


--
-- TOC entry 2354 (class 2606 OID 17302)
-- Name: ordenes_trabajo id_orden_trabajo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_orden_trabajo PRIMARY KEY (id_orden_trabajo);


--
-- TOC entry 2306 (class 2606 OID 17149)
-- Name: procesadores id_procesador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_procesador PRIMARY KEY (id_procesador);


--
-- TOC entry 2316 (class 2606 OID 17032)
-- Name: puertos id_puerto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puertos
    ADD CONSTRAINT id_puerto PRIMARY KEY (id_puerto);


--
-- TOC entry 2346 (class 2606 OID 17040)
-- Name: responsables id_responsable; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables
    ADD CONSTRAINT id_responsable PRIMARY KEY (id_responsable);


--
-- TOC entry 2318 (class 2606 OID 17034)
-- Name: sockets id_socket; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sockets
    ADD CONSTRAINT id_socket PRIMARY KEY (id_socket);


--
-- TOC entry 2332 (class 2606 OID 17096)
-- Name: software id_software; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_software PRIMARY KEY (id_software);


--
-- TOC entry 2330 (class 2606 OID 17190)
-- Name: software_componente id_software_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_software_componente PRIMARY KEY (id_software_componente);


--
-- TOC entry 2352 (class 2606 OID 17295)
-- Name: solicitudes id_solicitud; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_solicitud PRIMARY KEY (id_solicitud);


--
-- TOC entry 2334 (class 2606 OID 17052)
-- Name: soluciones id_solucion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soluciones
    ADD CONSTRAINT id_solucion PRIMARY KEY (id_solucion);


--
-- TOC entry 2312 (class 2606 OID 17178)
-- Name: tarjetas_video id_tarjeta_video; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_tarjeta_video PRIMARY KEY (id_tarjeta_video);


--
-- TOC entry 2366 (class 2606 OID 17044)
-- Name: tecnicos id_tecnico; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tecnicos
    ADD CONSTRAINT id_tecnico PRIMARY KEY (id_tecnico);


--
-- TOC entry 2336 (class 2606 OID 17108)
-- Name: tipos_componente id_tipo_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_componente
    ADD CONSTRAINT id_tipo_componente PRIMARY KEY (id_tipo_componente);


--
-- TOC entry 2300 (class 2606 OID 17024)
-- Name: tipos_disco id_tipo_disco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_disco
    ADD CONSTRAINT id_tipo_disco PRIMARY KEY (id_tipo_disco);


--
-- TOC entry 2362 (class 2606 OID 17063)
-- Name: tipos_mantenimiento id_tipo_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento
    ADD CONSTRAINT id_tipo_mantenimiento PRIMARY KEY (id_tipo_mantenimiento);


--
-- TOC entry 2298 (class 2606 OID 17026)
-- Name: tipos_memoria id_tipo_memoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_memoria
    ADD CONSTRAINT id_tipo_memoria PRIMARY KEY (id_tipo_memoria);


--
-- TOC entry 2338 (class 2606 OID 17054)
-- Name: tipos_software id_tipo_software; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_software
    ADD CONSTRAINT id_tipo_software PRIMARY KEY (id_tipo_software);


--
-- TOC entry 2344 (class 2606 OID 17038)
-- Name: ubicaciones id_ubicacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicaciones
    ADD CONSTRAINT id_ubicacion PRIMARY KEY (id_ubicacion);


--
-- TOC entry 2340 (class 2606 OID 17202)
-- Name: ups id_ups; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups
    ADD CONSTRAINT id_ups PRIMARY KEY (id_ups);


--
-- TOC entry 2396 (class 2606 OID 17102)
-- Name: software id_arquitectura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_arquitectura FOREIGN KEY (id_arquitectura) REFERENCES public.arquitecturas(id_arquitectura);


--
-- TOC entry 2375 (class 2606 OID 17155)
-- Name: procesadores id_arquitectura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_arquitectura FOREIGN KEY (id_arquitectura) REFERENCES public.arquitecturas(id_arquitectura);


--
-- TOC entry 2369 (class 2606 OID 17121)
-- Name: memorias id_capacidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_capacidad FOREIGN KEY (id_capacidad) REFERENCES public.capacidades(id_capacidad);


--
-- TOC entry 2371 (class 2606 OID 17133)
-- Name: discos id_capacidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_capacidad FOREIGN KEY (id_capacidad) REFERENCES public.capacidades(id_capacidad);


--
-- TOC entry 2394 (class 2606 OID 17196)
-- Name: software_componente id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2397 (class 2606 OID 17203)
-- Name: ups id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2383 (class 2606 OID 17237)
-- Name: hardware_componente id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2385 (class 2606 OID 17247)
-- Name: hardware_componente id_disco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_disco FOREIGN KEY (id_disco) REFERENCES public.discos(id_disco);


--
-- TOC entry 2401 (class 2606 OID 17090)
-- Name: cronograma id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2392 (class 2606 OID 17289)
-- Name: componentes id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2402 (class 2606 OID 17296)
-- Name: solicitudes id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2407 (class 2606 OID 17318)
-- Name: ordenes_trabajo id_estado_orden; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_estado_orden FOREIGN KEY (id_estado) REFERENCES public.estados_orden(id_estado);


--
-- TOC entry 2403 (class 2606 OID 17323)
-- Name: solicitudes id_estado_solicitud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_estado_solicitud FOREIGN KEY (id_estado) REFERENCES public.estados_solicitud(id_estado);


--
-- TOC entry 2389 (class 2606 OID 17274)
-- Name: hardware_componente id_fuente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_fuente FOREIGN KEY (id_fuente) REFERENCES public.fuentes(id_fuente);


--
-- TOC entry 2411 (class 2606 OID 17064)
-- Name: tipos_mantenimiento id_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento
    ADD CONSTRAINT id_mantenimiento FOREIGN KEY (id_mantenimiento) REFERENCES public.mantenimientos(id_mantenimiento);


--
-- TOC entry 2405 (class 2606 OID 17308)
-- Name: ordenes_trabajo id_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_mantenimiento FOREIGN KEY (id_mantenimiento) REFERENCES public.mantenimientos(id_mantenimiento);


--
-- TOC entry 2382 (class 2606 OID 17057)
-- Name: modelos id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2367 (class 2606 OID 17111)
-- Name: memorias id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2370 (class 2606 OID 17128)
-- Name: discos id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2377 (class 2606 OID 17167)
-- Name: motherboards id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2380 (class 2606 OID 17179)
-- Name: tarjetas_video id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2384 (class 2606 OID 17242)
-- Name: hardware_componente id_memoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_memoria FOREIGN KEY (id_memoria) REFERENCES public.memorias(id_memoria);


--
-- TOC entry 2374 (class 2606 OID 17150)
-- Name: procesadores id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2379 (class 2606 OID 17269)
-- Name: fuentes id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2391 (class 2606 OID 17284)
-- Name: componentes id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2387 (class 2606 OID 17257)
-- Name: hardware_componente id_motherboard; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_motherboard FOREIGN KEY (id_motherboard) REFERENCES public.motherboards(id_motherboard);


--
-- TOC entry 2408 (class 2606 OID 17330)
-- Name: detalles_orden_trabajo id_orden_trabajo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_orden_trabajo FOREIGN KEY (id_orden_trabajo) REFERENCES public.ordenes_trabajo(id_orden_trabajo);


--
-- TOC entry 2386 (class 2606 OID 17252)
-- Name: hardware_componente id_procesador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_procesador FOREIGN KEY (id_procesador) REFERENCES public.procesadores(id_procesador);


--
-- TOC entry 2372 (class 2606 OID 17138)
-- Name: discos id_puerto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_puerto FOREIGN KEY (id_puerto) REFERENCES public.puertos(id_puerto);


--
-- TOC entry 2381 (class 2606 OID 17184)
-- Name: tarjetas_video id_puerto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_puerto FOREIGN KEY (id_puerto) REFERENCES public.puertos(id_puerto);


--
-- TOC entry 2399 (class 2606 OID 17348)
-- Name: equipos id_responsables; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_responsables FOREIGN KEY (id_responsable) REFERENCES public.responsables(id_responsable);


--
-- TOC entry 2376 (class 2606 OID 17160)
-- Name: procesadores id_socket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_socket FOREIGN KEY (id_socket) REFERENCES public.sockets(id_socket);


--
-- TOC entry 2378 (class 2606 OID 17172)
-- Name: motherboards id_socket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_socket FOREIGN KEY (id_socket) REFERENCES public.sockets(id_socket);


--
-- TOC entry 2393 (class 2606 OID 17191)
-- Name: software_componente id_software; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_software FOREIGN KEY (id_software) REFERENCES public.software(id_software);


--
-- TOC entry 2404 (class 2606 OID 17303)
-- Name: ordenes_trabajo id_solicitud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_solicitud FOREIGN KEY (id_solicitud) REFERENCES public.solicitudes(id_solicitud);


--
-- TOC entry 2410 (class 2606 OID 17340)
-- Name: detalles_orden_trabajo id_solucion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_solucion FOREIGN KEY (id_solucion) REFERENCES public.soluciones(id_solucion);


--
-- TOC entry 2388 (class 2606 OID 17262)
-- Name: hardware_componente id_tarjeta_video; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_tarjeta_video FOREIGN KEY (id_tarjeta_video) REFERENCES public.tarjetas_video(id_tarjeta_video);


--
-- TOC entry 2406 (class 2606 OID 17313)
-- Name: ordenes_trabajo id_tecnico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_tecnico FOREIGN KEY (id_tecnico) REFERENCES public.tecnicos(id_tecnico);


--
-- TOC entry 2390 (class 2606 OID 17279)
-- Name: componentes id_tipo_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_tipo_componente FOREIGN KEY (id_tipo_componente) REFERENCES public.tipos_componente(id_tipo_componente);


--
-- TOC entry 2373 (class 2606 OID 17143)
-- Name: discos id_tipo_disco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_tipo_disco FOREIGN KEY (id_tipo_disco) REFERENCES public.tipos_disco(id_tipo_disco);


--
-- TOC entry 2409 (class 2606 OID 17335)
-- Name: detalles_orden_trabajo id_tipo_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_tipo_mantenimiento FOREIGN KEY (id_tipo_mantenimiento) REFERENCES public.tipos_mantenimiento(id_tipo_mantenimiento);


--
-- TOC entry 2368 (class 2606 OID 17116)
-- Name: memorias id_tipo_memoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_tipo_memoria FOREIGN KEY (id_tipo) REFERENCES public.tipos_memoria(id_tipo_memoria);


--
-- TOC entry 2395 (class 2606 OID 17097)
-- Name: software id_tipo_software; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_tipo_software FOREIGN KEY (id_tipo_software) REFERENCES public.tipos_software(id_tipo_software);


--
-- TOC entry 2398 (class 2606 OID 17071)
-- Name: equipos id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


--
-- TOC entry 2400 (class 2606 OID 17353)
-- Name: responsables id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


-- Completed on 2018-11-20 11:32:01

--
-- PostgreSQL database dump complete
--

