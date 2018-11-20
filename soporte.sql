--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-20 15:55:18

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
-- TOC entry 2531 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 32965)
-- Name: arquitecturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.arquitecturas (
    id_arquitectura integer NOT NULL,
    arquitectura text NOT NULL
);


ALTER TABLE public.arquitecturas OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 32971)
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
-- TOC entry 2532 (class 0 OID 0)
-- Dependencies: 197
-- Name: arquitecturas_id_arquitectura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.arquitecturas_id_arquitectura_seq OWNED BY public.arquitecturas.id_arquitectura;


--
-- TOC entry 198 (class 1259 OID 32973)
-- Name: capacidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.capacidades (
    id_capacidad integer NOT NULL,
    capacidad text NOT NULL
);


ALTER TABLE public.capacidades OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 32979)
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
-- TOC entry 2533 (class 0 OID 0)
-- Dependencies: 199
-- Name: capacidades_id_capacidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.capacidades_id_capacidad_seq OWNED BY public.capacidades.id_capacidad;


--
-- TOC entry 200 (class 1259 OID 32981)
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
-- TOC entry 201 (class 1259 OID 32987)
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
-- TOC entry 2534 (class 0 OID 0)
-- Dependencies: 201
-- Name: componentes_id_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.componentes_id_componente_seq OWNED BY public.componentes.id_componente;


--
-- TOC entry 202 (class 1259 OID 32989)
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
-- TOC entry 203 (class 1259 OID 32995)
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
-- TOC entry 2535 (class 0 OID 0)
-- Dependencies: 203
-- Name: cronograma_id_cronograma_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cronograma_id_cronograma_seq OWNED BY public.cronograma.id_cronograma;


--
-- TOC entry 204 (class 1259 OID 32997)
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
-- TOC entry 205 (class 1259 OID 33003)
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
-- TOC entry 2536 (class 0 OID 0)
-- Dependencies: 205
-- Name: detalles_orden_trabajo_id_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalles_orden_trabajo_id_detalle_seq OWNED BY public.detalles_orden_trabajo.id_detalle;


--
-- TOC entry 206 (class 1259 OID 33010)
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
-- TOC entry 207 (class 1259 OID 33016)
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
-- TOC entry 2537 (class 0 OID 0)
-- Dependencies: 207
-- Name: discos_id_discos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.discos_id_discos_seq OWNED BY public.discos.id_disco;


--
-- TOC entry 208 (class 1259 OID 33018)
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
-- TOC entry 209 (class 1259 OID 33024)
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
-- TOC entry 2538 (class 0 OID 0)
-- Dependencies: 209
-- Name: equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipo_id_equipo_seq OWNED BY public.equipos.id_equipo;


--
-- TOC entry 210 (class 1259 OID 33026)
-- Name: estados_orden; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estados_orden (
    id_estado integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.estados_orden OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 33032)
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
-- TOC entry 2539 (class 0 OID 0)
-- Dependencies: 211
-- Name: estado_ordenes_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_ordenes_id_estado_seq OWNED BY public.estados_orden.id_estado;


--
-- TOC entry 212 (class 1259 OID 33034)
-- Name: estados_solicitud; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estados_solicitud (
    id_estado integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.estados_solicitud OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 33040)
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
-- TOC entry 2540 (class 0 OID 0)
-- Dependencies: 213
-- Name: estados_solicitud_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estados_solicitud_id_estado_seq OWNED BY public.estados_solicitud.id_estado;


--
-- TOC entry 214 (class 1259 OID 33042)
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
-- TOC entry 215 (class 1259 OID 33048)
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
-- TOC entry 2541 (class 0 OID 0)
-- Dependencies: 215
-- Name: fuentes_id_fuente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fuentes_id_fuente_seq OWNED BY public.fuentes.id_fuente;


--
-- TOC entry 216 (class 1259 OID 33050)
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
-- TOC entry 217 (class 1259 OID 33056)
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
-- TOC entry 2542 (class 0 OID 0)
-- Dependencies: 217
-- Name: hardware_componente_id_hardware_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hardware_componente_id_hardware_componente_seq OWNED BY public.hardware_componente.id_hardware_componente;


--
-- TOC entry 218 (class 1259 OID 33058)
-- Name: mantenimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mantenimientos (
    id_mantenimiento integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.mantenimientos OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33064)
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
-- TOC entry 2543 (class 0 OID 0)
-- Dependencies: 219
-- Name: mantenimientos_id_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mantenimientos_id_mantenimiento_seq OWNED BY public.mantenimientos.id_mantenimiento;


--
-- TOC entry 220 (class 1259 OID 33066)
-- Name: marcas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marcas (
    id_marca integer NOT NULL,
    nombre text NOT NULL
);


ALTER TABLE public.marcas OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33072)
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
-- TOC entry 2544 (class 0 OID 0)
-- Dependencies: 221
-- Name: marcas_id_marca_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marcas_id_marca_seq OWNED BY public.marcas.id_marca;


--
-- TOC entry 222 (class 1259 OID 33074)
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
-- TOC entry 223 (class 1259 OID 33080)
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
-- TOC entry 2545 (class 0 OID 0)
-- Dependencies: 223
-- Name: memorias_id_memoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.memorias_id_memoria_seq OWNED BY public.memorias.id_memoria;


--
-- TOC entry 224 (class 1259 OID 33082)
-- Name: modelos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modelos (
    id_modelo integer NOT NULL,
    id_marca integer NOT NULL,
    nombre text NOT NULL
);


ALTER TABLE public.modelos OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 33088)
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
-- TOC entry 2546 (class 0 OID 0)
-- Dependencies: 225
-- Name: modelos_id_modelo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modelos_id_modelo_seq OWNED BY public.modelos.id_modelo;


--
-- TOC entry 226 (class 1259 OID 33090)
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
-- TOC entry 227 (class 1259 OID 33096)
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
-- TOC entry 2547 (class 0 OID 0)
-- Dependencies: 227
-- Name: motherboards_id_motherboard_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.motherboards_id_motherboard_seq OWNED BY public.motherboards.id_motherboard;


--
-- TOC entry 228 (class 1259 OID 33098)
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
-- TOC entry 229 (class 1259 OID 33104)
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
-- TOC entry 2548 (class 0 OID 0)
-- Dependencies: 229
-- Name: ordenes_trabajo_id_orden_trabajo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ordenes_trabajo_id_orden_trabajo_seq OWNED BY public.ordenes_trabajo.id_orden_trabajo;


--
-- TOC entry 230 (class 1259 OID 33106)
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
-- TOC entry 231 (class 1259 OID 33112)
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
-- TOC entry 2549 (class 0 OID 0)
-- Dependencies: 231
-- Name: procesadores_id_procesador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.procesadores_id_procesador_seq OWNED BY public.procesadores.id_procesador;


--
-- TOC entry 232 (class 1259 OID 33114)
-- Name: puertos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.puertos (
    id_puerto integer NOT NULL,
    tipo_puerto text NOT NULL
);


ALTER TABLE public.puertos OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 33120)
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
-- TOC entry 2550 (class 0 OID 0)
-- Dependencies: 233
-- Name: puertos_id_puerto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.puertos_id_puerto_seq OWNED BY public.puertos.id_puerto;


--
-- TOC entry 234 (class 1259 OID 33122)
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
-- TOC entry 235 (class 1259 OID 33128)
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
-- TOC entry 2551 (class 0 OID 0)
-- Dependencies: 235
-- Name: resposables_id_responsable_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resposables_id_responsable_seq OWNED BY public.responsables.id_responsable;


--
-- TOC entry 236 (class 1259 OID 33130)
-- Name: sockets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sockets (
    id_socket integer NOT NULL,
    socket text NOT NULL
);


ALTER TABLE public.sockets OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 33136)
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
-- TOC entry 2552 (class 0 OID 0)
-- Dependencies: 237
-- Name: sockets_id_socket_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sockets_id_socket_seq OWNED BY public.sockets.id_socket;


--
-- TOC entry 238 (class 1259 OID 33138)
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
-- TOC entry 239 (class 1259 OID 33144)
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
-- TOC entry 240 (class 1259 OID 33150)
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
-- TOC entry 2553 (class 0 OID 0)
-- Dependencies: 240
-- Name: software_componente_id_software_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.software_componente_id_software_componente_seq OWNED BY public.software_componente.id_software_componente;


--
-- TOC entry 241 (class 1259 OID 33152)
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
-- TOC entry 2554 (class 0 OID 0)
-- Dependencies: 241
-- Name: software_id_software_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.software_id_software_seq OWNED BY public.software.id_software;


--
-- TOC entry 242 (class 1259 OID 33154)
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
-- TOC entry 243 (class 1259 OID 33160)
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
-- TOC entry 2555 (class 0 OID 0)
-- Dependencies: 243
-- Name: solicitudes_id_solicitud_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.solicitudes_id_solicitud_seq OWNED BY public.solicitudes.id_solicitud;


--
-- TOC entry 244 (class 1259 OID 33162)
-- Name: soluciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.soluciones (
    id_solucion integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.soluciones OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 33168)
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
-- TOC entry 2556 (class 0 OID 0)
-- Dependencies: 245
-- Name: soluciones_id_solucion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.soluciones_id_solucion_seq OWNED BY public.soluciones.id_solucion;


--
-- TOC entry 246 (class 1259 OID 33170)
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
-- TOC entry 247 (class 1259 OID 33176)
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
-- TOC entry 2557 (class 0 OID 0)
-- Dependencies: 247
-- Name: tarjetas_video_id_tarjeta_video_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarjetas_video_id_tarjeta_video_seq OWNED BY public.tarjetas_video.id_tarjeta_video;


--
-- TOC entry 248 (class 1259 OID 33178)
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
-- TOC entry 249 (class 1259 OID 33184)
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
-- TOC entry 2558 (class 0 OID 0)
-- Dependencies: 249
-- Name: tecnicos_id_tecnico_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tecnicos_id_tecnico_seq OWNED BY public.tecnicos.id_tecnico;


--
-- TOC entry 250 (class 1259 OID 33186)
-- Name: tipos_componente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_componente (
    id_tipo_componente integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.tipos_componente OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 33192)
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
-- TOC entry 2559 (class 0 OID 0)
-- Dependencies: 251
-- Name: tipo_componente_id_tipo_componente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_componente_id_tipo_componente_seq OWNED BY public.tipos_componente.id_tipo_componente;


--
-- TOC entry 252 (class 1259 OID 33194)
-- Name: tipos_disco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_disco (
    id_tipo_disco integer NOT NULL,
    tipo_disco text NOT NULL
);


ALTER TABLE public.tipos_disco OWNER TO postgres;

--
-- TOC entry 253 (class 1259 OID 33200)
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
-- TOC entry 2560 (class 0 OID 0)
-- Dependencies: 253
-- Name: tipos_disco_id_tipo_disco_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_disco_id_tipo_disco_seq OWNED BY public.tipos_disco.id_tipo_disco;


--
-- TOC entry 254 (class 1259 OID 33202)
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
-- TOC entry 255 (class 1259 OID 33208)
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
-- TOC entry 2561 (class 0 OID 0)
-- Dependencies: 255
-- Name: tipos_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_mantenimiento_id_tipo_mantenimiento_seq OWNED BY public.tipos_mantenimiento.id_tipo_mantenimiento;


--
-- TOC entry 256 (class 1259 OID 33210)
-- Name: tipos_memoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_memoria (
    id_tipo_memoria integer NOT NULL,
    tipo_memoria text NOT NULL
);


ALTER TABLE public.tipos_memoria OWNER TO postgres;

--
-- TOC entry 257 (class 1259 OID 33216)
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
-- TOC entry 2562 (class 0 OID 0)
-- Dependencies: 257
-- Name: tipos_memoria_id_tipo_memoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_memoria_id_tipo_memoria_seq OWNED BY public.tipos_memoria.id_tipo_memoria;


--
-- TOC entry 258 (class 1259 OID 33218)
-- Name: tipos_software; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipos_software (
    id_tipo_software integer NOT NULL,
    tipo_software text NOT NULL
);


ALTER TABLE public.tipos_software OWNER TO postgres;

--
-- TOC entry 259 (class 1259 OID 33224)
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
-- TOC entry 2563 (class 0 OID 0)
-- Dependencies: 259
-- Name: tipos_software_id_tipo_software_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipos_software_id_tipo_software_seq OWNED BY public.tipos_software.id_tipo_software;


--
-- TOC entry 260 (class 1259 OID 33226)
-- Name: ubicaciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ubicaciones (
    id_ubicacion integer NOT NULL,
    nombre text NOT NULL,
    descripcion text
);


ALTER TABLE public.ubicaciones OWNER TO postgres;

--
-- TOC entry 261 (class 1259 OID 33232)
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
-- TOC entry 2564 (class 0 OID 0)
-- Dependencies: 261
-- Name: ubicaciones_id_ubicacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ubicaciones_id_ubicacion_seq OWNED BY public.ubicaciones.id_ubicacion;


--
-- TOC entry 262 (class 1259 OID 33234)
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
-- TOC entry 263 (class 1259 OID 33240)
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
-- TOC entry 2565 (class 0 OID 0)
-- Dependencies: 263
-- Name: ups_id_ups_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ups_id_ups_seq OWNED BY public.ups.id_ups;


--
-- TOC entry 2256 (class 2604 OID 33242)
-- Name: arquitecturas id_arquitectura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.arquitecturas ALTER COLUMN id_arquitectura SET DEFAULT nextval('public.arquitecturas_id_arquitectura_seq'::regclass);


--
-- TOC entry 2257 (class 2604 OID 33243)
-- Name: capacidades id_capacidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capacidades ALTER COLUMN id_capacidad SET DEFAULT nextval('public.capacidades_id_capacidad_seq'::regclass);


--
-- TOC entry 2258 (class 2604 OID 33244)
-- Name: componentes id_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes ALTER COLUMN id_componente SET DEFAULT nextval('public.componentes_id_componente_seq'::regclass);


--
-- TOC entry 2259 (class 2604 OID 33245)
-- Name: cronograma id_cronograma; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma ALTER COLUMN id_cronograma SET DEFAULT nextval('public.cronograma_id_cronograma_seq'::regclass);


--
-- TOC entry 2260 (class 2604 OID 33246)
-- Name: detalles_orden_trabajo id_detalle; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo ALTER COLUMN id_detalle SET DEFAULT nextval('public.detalles_orden_trabajo_id_detalle_seq'::regclass);


--
-- TOC entry 2261 (class 2604 OID 33248)
-- Name: discos id_disco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos ALTER COLUMN id_disco SET DEFAULT nextval('public.discos_id_discos_seq'::regclass);


--
-- TOC entry 2262 (class 2604 OID 33249)
-- Name: equipos id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos ALTER COLUMN id_equipo SET DEFAULT nextval('public.equipo_id_equipo_seq'::regclass);


--
-- TOC entry 2263 (class 2604 OID 33250)
-- Name: estados_orden id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_orden ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_ordenes_id_estado_seq'::regclass);


--
-- TOC entry 2264 (class 2604 OID 33251)
-- Name: estados_solicitud id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_solicitud ALTER COLUMN id_estado SET DEFAULT nextval('public.estados_solicitud_id_estado_seq'::regclass);


--
-- TOC entry 2265 (class 2604 OID 33252)
-- Name: fuentes id_fuente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes ALTER COLUMN id_fuente SET DEFAULT nextval('public.fuentes_id_fuente_seq'::regclass);


--
-- TOC entry 2266 (class 2604 OID 33253)
-- Name: hardware_componente id_hardware_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente ALTER COLUMN id_hardware_componente SET DEFAULT nextval('public.hardware_componente_id_hardware_componente_seq'::regclass);


--
-- TOC entry 2267 (class 2604 OID 33254)
-- Name: mantenimientos id_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos ALTER COLUMN id_mantenimiento SET DEFAULT nextval('public.mantenimientos_id_mantenimiento_seq'::regclass);


--
-- TOC entry 2268 (class 2604 OID 33255)
-- Name: marcas id_marca; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcas ALTER COLUMN id_marca SET DEFAULT nextval('public.marcas_id_marca_seq'::regclass);


--
-- TOC entry 2269 (class 2604 OID 33256)
-- Name: memorias id_memoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias ALTER COLUMN id_memoria SET DEFAULT nextval('public.memorias_id_memoria_seq'::regclass);


--
-- TOC entry 2270 (class 2604 OID 33257)
-- Name: modelos id_modelo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos ALTER COLUMN id_modelo SET DEFAULT nextval('public.modelos_id_modelo_seq'::regclass);


--
-- TOC entry 2271 (class 2604 OID 33258)
-- Name: motherboards id_motherboard; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards ALTER COLUMN id_motherboard SET DEFAULT nextval('public.motherboards_id_motherboard_seq'::regclass);


--
-- TOC entry 2272 (class 2604 OID 33259)
-- Name: ordenes_trabajo id_orden_trabajo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo ALTER COLUMN id_orden_trabajo SET DEFAULT nextval('public.ordenes_trabajo_id_orden_trabajo_seq'::regclass);


--
-- TOC entry 2273 (class 2604 OID 33260)
-- Name: procesadores id_procesador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores ALTER COLUMN id_procesador SET DEFAULT nextval('public.procesadores_id_procesador_seq'::regclass);


--
-- TOC entry 2274 (class 2604 OID 33261)
-- Name: puertos id_puerto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puertos ALTER COLUMN id_puerto SET DEFAULT nextval('public.puertos_id_puerto_seq'::regclass);


--
-- TOC entry 2275 (class 2604 OID 33262)
-- Name: responsables id_responsable; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables ALTER COLUMN id_responsable SET DEFAULT nextval('public.resposables_id_responsable_seq'::regclass);


--
-- TOC entry 2276 (class 2604 OID 33263)
-- Name: sockets id_socket; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sockets ALTER COLUMN id_socket SET DEFAULT nextval('public.sockets_id_socket_seq'::regclass);


--
-- TOC entry 2277 (class 2604 OID 33264)
-- Name: software id_software; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software ALTER COLUMN id_software SET DEFAULT nextval('public.software_id_software_seq'::regclass);


--
-- TOC entry 2278 (class 2604 OID 33265)
-- Name: software_componente id_software_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente ALTER COLUMN id_software_componente SET DEFAULT nextval('public.software_componente_id_software_componente_seq'::regclass);


--
-- TOC entry 2279 (class 2604 OID 33266)
-- Name: solicitudes id_solicitud; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes ALTER COLUMN id_solicitud SET DEFAULT nextval('public.solicitudes_id_solicitud_seq'::regclass);


--
-- TOC entry 2280 (class 2604 OID 33267)
-- Name: soluciones id_solucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soluciones ALTER COLUMN id_solucion SET DEFAULT nextval('public.soluciones_id_solucion_seq'::regclass);


--
-- TOC entry 2281 (class 2604 OID 33268)
-- Name: tarjetas_video id_tarjeta_video; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video ALTER COLUMN id_tarjeta_video SET DEFAULT nextval('public.tarjetas_video_id_tarjeta_video_seq'::regclass);


--
-- TOC entry 2282 (class 2604 OID 33269)
-- Name: tecnicos id_tecnico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tecnicos ALTER COLUMN id_tecnico SET DEFAULT nextval('public.tecnicos_id_tecnico_seq'::regclass);


--
-- TOC entry 2283 (class 2604 OID 33270)
-- Name: tipos_componente id_tipo_componente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_componente ALTER COLUMN id_tipo_componente SET DEFAULT nextval('public.tipo_componente_id_tipo_componente_seq'::regclass);


--
-- TOC entry 2284 (class 2604 OID 33271)
-- Name: tipos_disco id_tipo_disco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_disco ALTER COLUMN id_tipo_disco SET DEFAULT nextval('public.tipos_disco_id_tipo_disco_seq'::regclass);


--
-- TOC entry 2285 (class 2604 OID 33272)
-- Name: tipos_mantenimiento id_tipo_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento ALTER COLUMN id_tipo_mantenimiento SET DEFAULT nextval('public.tipos_mantenimiento_id_tipo_mantenimiento_seq'::regclass);


--
-- TOC entry 2286 (class 2604 OID 33273)
-- Name: tipos_memoria id_tipo_memoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_memoria ALTER COLUMN id_tipo_memoria SET DEFAULT nextval('public.tipos_memoria_id_tipo_memoria_seq'::regclass);


--
-- TOC entry 2287 (class 2604 OID 33274)
-- Name: tipos_software id_tipo_software; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_software ALTER COLUMN id_tipo_software SET DEFAULT nextval('public.tipos_software_id_tipo_software_seq'::regclass);


--
-- TOC entry 2288 (class 2604 OID 33275)
-- Name: ubicaciones id_ubicacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicaciones ALTER COLUMN id_ubicacion SET DEFAULT nextval('public.ubicaciones_id_ubicacion_seq'::regclass);


--
-- TOC entry 2289 (class 2604 OID 33276)
-- Name: ups id_ups; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups ALTER COLUMN id_ups SET DEFAULT nextval('public.ups_id_ups_seq'::regclass);


--
-- TOC entry 2291 (class 2606 OID 33278)
-- Name: arquitecturas id_arquitectura; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.arquitecturas
    ADD CONSTRAINT id_arquitectura PRIMARY KEY (id_arquitectura);


--
-- TOC entry 2293 (class 2606 OID 33280)
-- Name: capacidades id_capacidad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.capacidades
    ADD CONSTRAINT id_capacidad PRIMARY KEY (id_capacidad);


--
-- TOC entry 2295 (class 2606 OID 33282)
-- Name: componentes id_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_componente PRIMARY KEY (id_componente);


--
-- TOC entry 2297 (class 2606 OID 33284)
-- Name: cronograma id_cronograma; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma
    ADD CONSTRAINT id_cronograma PRIMARY KEY (id_cronograma);


--
-- TOC entry 2299 (class 2606 OID 33286)
-- Name: detalles_orden_trabajo id_detalle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_detalle PRIMARY KEY (id_detalle);


--
-- TOC entry 2301 (class 2606 OID 33290)
-- Name: discos id_disco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_disco PRIMARY KEY (id_disco);


--
-- TOC entry 2303 (class 2606 OID 33292)
-- Name: equipos id_equipo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_equipo PRIMARY KEY (id_equipo);


--
-- TOC entry 2305 (class 2606 OID 33294)
-- Name: estados_orden id_estado_orden; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_orden
    ADD CONSTRAINT id_estado_orden PRIMARY KEY (id_estado);


--
-- TOC entry 2307 (class 2606 OID 33296)
-- Name: estados_solicitud id_estado_solicitud; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados_solicitud
    ADD CONSTRAINT id_estado_solicitud PRIMARY KEY (id_estado);


--
-- TOC entry 2309 (class 2606 OID 33298)
-- Name: fuentes id_fuente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes
    ADD CONSTRAINT id_fuente PRIMARY KEY (id_fuente);


--
-- TOC entry 2311 (class 2606 OID 33300)
-- Name: hardware_componente id_hardware_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_hardware_componente PRIMARY KEY (id_hardware_componente);


--
-- TOC entry 2313 (class 2606 OID 33302)
-- Name: mantenimientos id_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos
    ADD CONSTRAINT id_mantenimiento PRIMARY KEY (id_mantenimiento);


--
-- TOC entry 2315 (class 2606 OID 33304)
-- Name: marcas id_marca; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT id_marca PRIMARY KEY (id_marca);


--
-- TOC entry 2317 (class 2606 OID 33306)
-- Name: memorias id_memoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_memoria PRIMARY KEY (id_memoria);


--
-- TOC entry 2319 (class 2606 OID 33308)
-- Name: modelos id_modelo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT id_modelo PRIMARY KEY (id_modelo);


--
-- TOC entry 2321 (class 2606 OID 33310)
-- Name: motherboards id_motherboard; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_motherboard PRIMARY KEY (id_motherboard);


--
-- TOC entry 2323 (class 2606 OID 33312)
-- Name: ordenes_trabajo id_orden_trabajo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_orden_trabajo PRIMARY KEY (id_orden_trabajo);


--
-- TOC entry 2325 (class 2606 OID 33314)
-- Name: procesadores id_procesador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_procesador PRIMARY KEY (id_procesador);


--
-- TOC entry 2327 (class 2606 OID 33316)
-- Name: puertos id_puerto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puertos
    ADD CONSTRAINT id_puerto PRIMARY KEY (id_puerto);


--
-- TOC entry 2329 (class 2606 OID 33318)
-- Name: responsables id_responsable; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables
    ADD CONSTRAINT id_responsable PRIMARY KEY (id_responsable);


--
-- TOC entry 2331 (class 2606 OID 33320)
-- Name: sockets id_socket; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sockets
    ADD CONSTRAINT id_socket PRIMARY KEY (id_socket);


--
-- TOC entry 2333 (class 2606 OID 33322)
-- Name: software id_software; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_software PRIMARY KEY (id_software);


--
-- TOC entry 2335 (class 2606 OID 33324)
-- Name: software_componente id_software_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_software_componente PRIMARY KEY (id_software_componente);


--
-- TOC entry 2337 (class 2606 OID 33326)
-- Name: solicitudes id_solicitud; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_solicitud PRIMARY KEY (id_solicitud);


--
-- TOC entry 2339 (class 2606 OID 33328)
-- Name: soluciones id_solucion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soluciones
    ADD CONSTRAINT id_solucion PRIMARY KEY (id_solucion);


--
-- TOC entry 2341 (class 2606 OID 33330)
-- Name: tarjetas_video id_tarjeta_video; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_tarjeta_video PRIMARY KEY (id_tarjeta_video);


--
-- TOC entry 2343 (class 2606 OID 33332)
-- Name: tecnicos id_tecnico; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tecnicos
    ADD CONSTRAINT id_tecnico PRIMARY KEY (id_tecnico);


--
-- TOC entry 2345 (class 2606 OID 33334)
-- Name: tipos_componente id_tipo_componente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_componente
    ADD CONSTRAINT id_tipo_componente PRIMARY KEY (id_tipo_componente);


--
-- TOC entry 2347 (class 2606 OID 33336)
-- Name: tipos_disco id_tipo_disco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_disco
    ADD CONSTRAINT id_tipo_disco PRIMARY KEY (id_tipo_disco);


--
-- TOC entry 2349 (class 2606 OID 33338)
-- Name: tipos_mantenimiento id_tipo_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento
    ADD CONSTRAINT id_tipo_mantenimiento PRIMARY KEY (id_tipo_mantenimiento);


--
-- TOC entry 2351 (class 2606 OID 33340)
-- Name: tipos_memoria id_tipo_memoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_memoria
    ADD CONSTRAINT id_tipo_memoria PRIMARY KEY (id_tipo_memoria);


--
-- TOC entry 2353 (class 2606 OID 33342)
-- Name: tipos_software id_tipo_software; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_software
    ADD CONSTRAINT id_tipo_software PRIMARY KEY (id_tipo_software);


--
-- TOC entry 2355 (class 2606 OID 33344)
-- Name: ubicaciones id_ubicacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicaciones
    ADD CONSTRAINT id_ubicacion PRIMARY KEY (id_ubicacion);


--
-- TOC entry 2357 (class 2606 OID 33346)
-- Name: ups id_ups; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups
    ADD CONSTRAINT id_ups PRIMARY KEY (id_ups);


--
-- TOC entry 2393 (class 2606 OID 33347)
-- Name: software id_arquitectura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_arquitectura FOREIGN KEY (id_arquitectura) REFERENCES public.arquitecturas(id_arquitectura);


--
-- TOC entry 2389 (class 2606 OID 33352)
-- Name: procesadores id_arquitectura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_arquitectura FOREIGN KEY (id_arquitectura) REFERENCES public.arquitecturas(id_arquitectura);


--
-- TOC entry 2379 (class 2606 OID 33357)
-- Name: memorias id_capacidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_capacidad FOREIGN KEY (id_capacidad) REFERENCES public.capacidades(id_capacidad);


--
-- TOC entry 2365 (class 2606 OID 33362)
-- Name: discos id_capacidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_capacidad FOREIGN KEY (id_capacidad) REFERENCES public.capacidades(id_capacidad);


--
-- TOC entry 2395 (class 2606 OID 33367)
-- Name: software_componente id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2402 (class 2606 OID 33372)
-- Name: ups id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ups
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2372 (class 2606 OID 33377)
-- Name: hardware_componente id_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_componente FOREIGN KEY (id_componente) REFERENCES public.componentes(id_componente);


--
-- TOC entry 2373 (class 2606 OID 33382)
-- Name: hardware_componente id_disco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_disco FOREIGN KEY (id_disco) REFERENCES public.discos(id_disco);


--
-- TOC entry 2361 (class 2606 OID 33387)
-- Name: cronograma id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cronograma
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2358 (class 2606 OID 33392)
-- Name: componentes id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2397 (class 2606 OID 33397)
-- Name: solicitudes id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipos(id_equipo);


--
-- TOC entry 2385 (class 2606 OID 33402)
-- Name: ordenes_trabajo id_estado_orden; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_estado_orden FOREIGN KEY (id_estado) REFERENCES public.estados_orden(id_estado);


--
-- TOC entry 2398 (class 2606 OID 33407)
-- Name: solicitudes id_estado_solicitud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT id_estado_solicitud FOREIGN KEY (id_estado) REFERENCES public.estados_solicitud(id_estado);


--
-- TOC entry 2374 (class 2606 OID 33412)
-- Name: hardware_componente id_fuente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_fuente FOREIGN KEY (id_fuente) REFERENCES public.fuentes(id_fuente);


--
-- TOC entry 2401 (class 2606 OID 33417)
-- Name: tipos_mantenimiento id_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipos_mantenimiento
    ADD CONSTRAINT id_mantenimiento FOREIGN KEY (id_mantenimiento) REFERENCES public.mantenimientos(id_mantenimiento);


--
-- TOC entry 2386 (class 2606 OID 33422)
-- Name: ordenes_trabajo id_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_mantenimiento FOREIGN KEY (id_mantenimiento) REFERENCES public.mantenimientos(id_mantenimiento);


--
-- TOC entry 2382 (class 2606 OID 33427)
-- Name: modelos id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2380 (class 2606 OID 33432)
-- Name: memorias id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2366 (class 2606 OID 33437)
-- Name: discos id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2383 (class 2606 OID 33442)
-- Name: motherboards id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2399 (class 2606 OID 33447)
-- Name: tarjetas_video id_marca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_marca FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);


--
-- TOC entry 2375 (class 2606 OID 33452)
-- Name: hardware_componente id_memoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_memoria FOREIGN KEY (id_memoria) REFERENCES public.memorias(id_memoria);


--
-- TOC entry 2390 (class 2606 OID 33457)
-- Name: procesadores id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2371 (class 2606 OID 33462)
-- Name: fuentes id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fuentes
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2359 (class 2606 OID 33467)
-- Name: componentes id_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_modelo FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_modelo);


--
-- TOC entry 2376 (class 2606 OID 33472)
-- Name: hardware_componente id_motherboard; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_motherboard FOREIGN KEY (id_motherboard) REFERENCES public.motherboards(id_motherboard);


--
-- TOC entry 2362 (class 2606 OID 33477)
-- Name: detalles_orden_trabajo id_orden_trabajo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_orden_trabajo FOREIGN KEY (id_orden_trabajo) REFERENCES public.ordenes_trabajo(id_orden_trabajo);


--
-- TOC entry 2377 (class 2606 OID 33482)
-- Name: hardware_componente id_procesador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_procesador FOREIGN KEY (id_procesador) REFERENCES public.procesadores(id_procesador);


--
-- TOC entry 2367 (class 2606 OID 33487)
-- Name: discos id_puerto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_puerto FOREIGN KEY (id_puerto) REFERENCES public.puertos(id_puerto);


--
-- TOC entry 2400 (class 2606 OID 33492)
-- Name: tarjetas_video id_puerto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjetas_video
    ADD CONSTRAINT id_puerto FOREIGN KEY (id_puerto) REFERENCES public.puertos(id_puerto);


--
-- TOC entry 2369 (class 2606 OID 33497)
-- Name: equipos id_responsables; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_responsables FOREIGN KEY (id_responsable) REFERENCES public.responsables(id_responsable);


--
-- TOC entry 2391 (class 2606 OID 33502)
-- Name: procesadores id_socket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procesadores
    ADD CONSTRAINT id_socket FOREIGN KEY (id_socket) REFERENCES public.sockets(id_socket);


--
-- TOC entry 2384 (class 2606 OID 33507)
-- Name: motherboards id_socket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motherboards
    ADD CONSTRAINT id_socket FOREIGN KEY (id_socket) REFERENCES public.sockets(id_socket);


--
-- TOC entry 2396 (class 2606 OID 33512)
-- Name: software_componente id_software; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software_componente
    ADD CONSTRAINT id_software FOREIGN KEY (id_software) REFERENCES public.software(id_software);


--
-- TOC entry 2387 (class 2606 OID 33517)
-- Name: ordenes_trabajo id_solicitud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_solicitud FOREIGN KEY (id_solicitud) REFERENCES public.solicitudes(id_solicitud);


--
-- TOC entry 2363 (class 2606 OID 33522)
-- Name: detalles_orden_trabajo id_solucion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_solucion FOREIGN KEY (id_solucion) REFERENCES public.soluciones(id_solucion);


--
-- TOC entry 2378 (class 2606 OID 33527)
-- Name: hardware_componente id_tarjeta_video; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hardware_componente
    ADD CONSTRAINT id_tarjeta_video FOREIGN KEY (id_tarjeta_video) REFERENCES public.tarjetas_video(id_tarjeta_video);


--
-- TOC entry 2388 (class 2606 OID 33532)
-- Name: ordenes_trabajo id_tecnico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes_trabajo
    ADD CONSTRAINT id_tecnico FOREIGN KEY (id_tecnico) REFERENCES public.tecnicos(id_tecnico);


--
-- TOC entry 2360 (class 2606 OID 33537)
-- Name: componentes id_tipo_componente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT id_tipo_componente FOREIGN KEY (id_tipo_componente) REFERENCES public.tipos_componente(id_tipo_componente);


--
-- TOC entry 2368 (class 2606 OID 33542)
-- Name: discos id_tipo_disco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discos
    ADD CONSTRAINT id_tipo_disco FOREIGN KEY (id_tipo_disco) REFERENCES public.tipos_disco(id_tipo_disco);


--
-- TOC entry 2364 (class 2606 OID 33547)
-- Name: detalles_orden_trabajo id_tipo_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles_orden_trabajo
    ADD CONSTRAINT id_tipo_mantenimiento FOREIGN KEY (id_tipo_mantenimiento) REFERENCES public.tipos_mantenimiento(id_tipo_mantenimiento);


--
-- TOC entry 2381 (class 2606 OID 33552)
-- Name: memorias id_tipo_memoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memorias
    ADD CONSTRAINT id_tipo_memoria FOREIGN KEY (id_tipo) REFERENCES public.tipos_memoria(id_tipo_memoria);


--
-- TOC entry 2394 (class 2606 OID 33557)
-- Name: software id_tipo_software; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT id_tipo_software FOREIGN KEY (id_tipo_software) REFERENCES public.tipos_software(id_tipo_software);


--
-- TOC entry 2370 (class 2606 OID 33562)
-- Name: equipos id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


--
-- TOC entry 2392 (class 2606 OID 33567)
-- Name: responsables id_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsables
    ADD CONSTRAINT id_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES public.ubicaciones(id_ubicacion);


-- Completed on 2018-11-20 15:55:20

--
-- PostgreSQL database dump complete
--

