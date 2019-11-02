--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 12.0

-- Started on 2019-11-02 10:58:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3328 (class 0 OID 52909)
-- Dependencies: 196
-- Data for Name: arquitecturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.arquitecturas (id_arquitectura, arquitectura) FROM stdin;
1	64 bits
2	32 bits
\.


--
-- TOC entry 3330 (class 0 OID 52917)
-- Dependencies: 198
-- Data for Name: capacidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.capacidades (id_capacidad, capacidad) FROM stdin;
\.


--
-- TOC entry 3356 (class 0 OID 53021)
-- Dependencies: 224
-- Data for Name: marcas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marcas (id_marca, nombre) FROM stdin;
1	DELL
2	Lenovo
3	PC Clon
\.


--
-- TOC entry 3362 (class 0 OID 53045)
-- Dependencies: 230
-- Data for Name: modelos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.modelos (id_modelo, id_marca, nombre) FROM stdin;
1	1	Optiplex 780
2	1	Optiplex GX620
3	1	Vostro 460
4	1	Vostro 230
5	2	ThinkCentre M82
6	1	Vostro 220
7	3	Clon
\.


--
-- TOC entry 3402 (class 0 OID 53199)
-- Dependencies: 270
-- Data for Name: tipos_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_componente (id_tipo_componente, nombre, descripcion, contenedor_hw, contenedor_sw) FROM stdin;
1	CPU		t	t
\.


--
-- TOC entry 3332 (class 0 OID 52925)
-- Dependencies: 200
-- Data for Name: componentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.componentes (id_componente, id_tipo_componente, id_modelo, numero_inventario, numero_serie, estado, personal, asignado, observaciones) FROM stdin;
1	1	1	12040.3301. 080.0090	3W36JL1	t	f	t	
2	1	1	12040.3301. 080.0089	JW36JL1	t	f	t	
3	1	1	12040.3301. 080.0086	2VP5JL1	t	f	t	
4	1	1	12040.3301. 080.0087	22S5JL1	t	f	t	
5	1	1	12040.3301. 080.0092	42S5JL1	t	f	t	
6	1	1	12040.3301. 080.0091	G0S5JL1	t	f	t	
7	1	2	12040.3318. 080.0027	DSZFQ81	t	f	t	
8	1	2	12040.3318. 080.0028	BWXFQ81	t	f	t	
10	1	3	12040.3318. 080.0042	4VC1PS1	t	f	t	
9	1	2	12040.3318. 080.0031	GWXFQ81	t	f	t	
11	1	4	12040.3301. 080.0150	2V75MN1	t	f	t	
12	1	5	12040.3318. 080.0043	MJVZLLG	t	f	t	
13	1	6	12040.3301. 080.0074	DQ4LYH1	t	f	t	
14	1	7	12040.3318. 080.0037	--	t	f	t	
16	1	2	12040.3318. 080.0032	2ZXFQ81	t	f	t	
18	1	7	12040.3318. 080.0011	--	t	f	t	
17	1	6	12040.3301. 080.0076	431LYH1	t	f	t	
15	1	1	12040.3301. 080.0088	1X36JL1	t	f	t	
20	1	2	12040.3318. 080.0029	GRZFQ81	t	f	t	
23	1	6	12040.3318. 080.0039	D51LYH1	t	f	t	
26	1	7	12040.3318. 080.0038	--	t	f	t	
27	1	6	12040.3301. 080.0081	341LYH1	t	f	t	
28	1	6	12040.3301. 080.0079	18JGYH1	t	f	t	
19	1	2	12040.3318. 080.0034	7YXFQ81	t	f	t	
21	1	2	12040.3318. 080.0030	4RZFQ81	t	f	t	
22	1	6	12040.3301. 080.0080	531LYH1	t	f	t	
24	1	6	12040.3301. 080.0049	C31LYH1	t	f	t	
25	1	2	--	8XXFQ81	t	f	t	
\.


--
-- TOC entry 3414 (class 0 OID 53247)
-- Dependencies: 282
-- Data for Name: ubicaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ubicaciones (id_ubicacion, nombre, descripcion) FROM stdin;
1	Ciencias Economicas	Depto. Economia
\.


--
-- TOC entry 3380 (class 0 OID 53114)
-- Dependencies: 248
-- Data for Name: responsables; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.responsables (id_responsable, nombre, correo, id_ubicacion) FROM stdin;
1	Licdo. Hugo Eduardo García	\N	1
2	Licdo. Francisco Cienfuegos	\N	1
3	Licdo. Eduardo Zepeda Guevara	\N	1
4	Licdo. Jorge Mauricio Rivera	\N	1
5	Licda. Flor de María Rivera	\N	1
6	Licdo. Carlos Mauricio Trigueros	\N	1
7	Licdo. Orlando Peraza	\N	1
8	Licdo. Waldemar Sandoval	\N	1
9	Licdo. David Eliú González	\N	1
10	Licdo. Juan Bautista Salazar	\N	1
11	Licdo. José Luis Mendoza	\N	1
12	Licdo. José Luis Salazar	\N	1
13	Licda. Flor de María Portillo	\N	1
14	Licdo. Francisco López Román	\N	1
15	Licdo. Cristóbal Roberto Elizondo	\N	1
16	Sra. Zulma de Beltrán	\N	1
17	Licdo. Mario Ernesto Martínez	\N	1
\.


--
-- TOC entry 3346 (class 0 OID 52981)
-- Dependencies: 214
-- Data for Name: equipos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipos (id_equipo, id_ubicacion, estado, id_responsable, observaciones) FROM stdin;
1	1	\N	1	
2	1	\N	2	
3	1	\N	3	
4	1	\N	4	
5	1	\N	5	
6	1	\N	6	
7	1	\N	7	
10	1	\N	9	
11	1	\N	10	
9	1	f	8	
12	1	\N	12	
13	1	\N	11	
14	1	\N	13	
15	1	\N	14	
16	1	\N	15	
17	1	\N	16	
18	1	\N	17	
8	1	f	8	
\.


--
-- TOC entry 3333 (class 0 OID 52931)
-- Dependencies: 201
-- Data for Name: componentes_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.componentes_equipo (id_componente_equipo, id_equipo, id_componente, fecha_vinculado, fecha_desvinculado, estado, observaciones) FROM stdin;
1	1	1	2019-10-26	\N	\N	\N
2	2	2	2019-10-26	\N	\N	\N
3	3	3	2019-10-26	\N	\N	\N
4	4	4	2019-10-26	\N	\N	\N
5	5	5	2019-10-26	\N	\N	\N
6	6	6	2019-10-26	\N	\N	\N
7	7	7	2019-10-26	\N	\N	\N
8	8	8	2019-10-26	\N	\N	\N
9	9	10	2019-10-26	\N	\N	\N
10	9	9	2019-10-26	\N	\N	\N
11	9	11	2019-10-26	\N	\N	\N
12	10	12	2019-10-26	\N	\N	\N
13	11	13	2019-10-26	\N	\N	\N
14	9	14	2019-10-26	\N	\N	\N
15	9	16	2019-10-26	\N	\N	\N
16	9	18	2019-10-26	\N	\N	\N
17	12	17	2019-10-26	\N	\N	\N
18	13	15	2019-10-26	\N	\N	\N
19	14	20	2019-10-26	\N	\N	\N
20	15	23	2019-10-26	\N	\N	\N
21	16	26	2019-10-26	\N	\N	\N
22	17	27	2019-10-26	\N	\N	\N
23	18	28	2019-10-26	\N	\N	\N
24	8	19	2019-10-26	\N	\N	\N
25	8	21	2019-10-26	\N	\N	\N
26	8	22	2019-10-26	\N	\N	\N
27	8	24	2019-10-26	\N	\N	\N
28	8	25	2019-10-26	\N	\N	\N
\.


--
-- TOC entry 3354 (class 0 OID 53013)
-- Dependencies: 222
-- Data for Name: mantenimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mantenimientos (id_mantenimiento, nombre, descripcion) FROM stdin;
\.


--
-- TOC entry 3404 (class 0 OID 53207)
-- Dependencies: 272
-- Data for Name: tipos_solicitud; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_solicitud (id_tipo_solicitud, nombre) FROM stdin;
\.


--
-- TOC entry 3392 (class 0 OID 53159)
-- Dependencies: 260
-- Data for Name: solicitudes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.solicitudes (id_solicitud, id_responsable, fecha_solicitud, problema, codigo_seguimiento, id_tipo_solicitud, id_ubicacion, estado) FROM stdin;
\.


--
-- TOC entry 3400 (class 0 OID 53191)
-- Dependencies: 268
-- Data for Name: tecnicos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tecnicos (id_tecnico, nombre, descripcion, correo, estado) FROM stdin;
1	Ana Gabriela Quezada Torres	\N	\N	t
\.


--
-- TOC entry 3368 (class 0 OID 53069)
-- Dependencies: 236
-- Data for Name: ordenes_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ordenes_trabajo (id_orden_trabajo, id_solicitud, id_mantenimiento, id_tecnico, fecha_inicio, fecha_finalizacion, hora_inicio, hora_finalizacion, observaciones, estado, id_equipo, prioridad) FROM stdin;
\.


--
-- TOC entry 3336 (class 0 OID 52941)
-- Dependencies: 204
-- Data for Name: cronograma; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cronograma (id_cronograma, fecha_inicio, fecha_fin, nombre_evento, descripcion, id_orden_trabajo) FROM stdin;
\.


--
-- TOC entry 3394 (class 0 OID 53167)
-- Dependencies: 262
-- Data for Name: soluciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.soluciones (id_solucion, nombre, descripcion) FROM stdin;
\.


--
-- TOC entry 3408 (class 0 OID 53223)
-- Dependencies: 276
-- Data for Name: tipos_mantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_mantenimiento (id_tipo_mantenimiento, id_mantenimiento, nombre, descripcion) FROM stdin;
\.


--
-- TOC entry 3338 (class 0 OID 52949)
-- Dependencies: 206
-- Data for Name: detalles_orden_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalles_orden_trabajo (id_detalle, id_orden_trabajo, id_solucion, observaciones, id_tipo_mantenimiento) FROM stdin;
\.


--
-- TOC entry 3340 (class 0 OID 52957)
-- Dependencies: 208
-- Data for Name: dimension_disco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dimension_disco (id_dimension, dimension) FROM stdin;
\.


--
-- TOC entry 3378 (class 0 OID 53106)
-- Dependencies: 246
-- Data for Name: puertos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.puertos (id_puerto, tipo_puerto) FROM stdin;
\.


--
-- TOC entry 3406 (class 0 OID 53215)
-- Dependencies: 274
-- Data for Name: tipos_disco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_disco (id_tipo_disco, tipo_disco) FROM stdin;
\.


--
-- TOC entry 3342 (class 0 OID 52965)
-- Dependencies: 210
-- Data for Name: discos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.discos (id_disco, id_marca, id_capacidad, id_puerto, id_tipo_disco, numero_serie, id_dimension, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 3343 (class 0 OID 52971)
-- Dependencies: 211
-- Data for Name: discos_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.discos_componente (id_discos_componente, id_discos, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 3350 (class 0 OID 52997)
-- Dependencies: 218
-- Data for Name: fuentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fuentes (id_fuente, id_modelo, potencia, numero_pines, numero_serie, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 3348 (class 0 OID 52989)
-- Dependencies: 216
-- Data for Name: fuente_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fuente_componente (id_fuente_componente, id_fuente, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 3352 (class 0 OID 53005)
-- Dependencies: 220
-- Data for Name: loggin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.loggin (id_loggin, id_tecnico, nombre_loggin, passwoird) FROM stdin;
1	1	gaby	123
\.


--
-- TOC entry 3410 (class 0 OID 53231)
-- Dependencies: 278
-- Data for Name: tipos_memoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_memoria (id_tipo_memoria, tipo_memoria) FROM stdin;
\.


--
-- TOC entry 3420 (class 0 OID 53271)
-- Dependencies: 288
-- Data for Name: velocidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.velocidad (id_velocidad, velocidad) FROM stdin;
\.


--
-- TOC entry 3358 (class 0 OID 53029)
-- Dependencies: 226
-- Data for Name: memorias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.memorias (id_memoria, id_marca, id_tipo, id_capacidad, numero_serie, id_velocidad, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 3359 (class 0 OID 53035)
-- Dependencies: 227
-- Data for Name: memorias_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.memorias_componente (id_memorias_componente, id_memoria, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 3386 (class 0 OID 53135)
-- Dependencies: 254
-- Data for Name: sockets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sockets (id_socket, socket) FROM stdin;
\.


--
-- TOC entry 3366 (class 0 OID 53061)
-- Dependencies: 234
-- Data for Name: motherboards; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.motherboards (id_motherboard, id_marca, id_socket, numero_serie, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 3364 (class 0 OID 53053)
-- Dependencies: 232
-- Data for Name: motherboard_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.motherboard_componente (id_motherboard_componente, id_motherboard, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 3370 (class 0 OID 53077)
-- Dependencies: 238
-- Data for Name: permisos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permisos (id_permiso, id_loggin, arquitectura, componentes, cronograma, equipos, mantenimiento, marcas, modelos, hardware, software, software_componente, hardware_componente, responsables, solicitudes, soluciones, tecnicos, ubicaciones, orden_trabajo, permisos) FROM stdin;
1	1	t	t	t	t	t	t	t	t	t	t	t	t	t	t	t	t	t	t
\.


--
-- TOC entry 3372 (class 0 OID 53082)
-- Dependencies: 240
-- Data for Name: potencia_ups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.potencia_ups (id_potencia, voltaje, amperaje) FROM stdin;
\.


--
-- TOC entry 3376 (class 0 OID 53098)
-- Dependencies: 244
-- Data for Name: procesadores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.procesadores (id_procesador, id_modelo, id_arquitectura, id_socket, numero_serie, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 3374 (class 0 OID 53090)
-- Dependencies: 242
-- Data for Name: procesador_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.procesador_componente (id_procesador_componente, id_procesador, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 3384 (class 0 OID 53127)
-- Dependencies: 252
-- Data for Name: salida_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.salida_video (id_salida_video, tipo_salida) FROM stdin;
\.


--
-- TOC entry 3396 (class 0 OID 53175)
-- Dependencies: 264
-- Data for Name: tarjetas_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarjetas_video (id_tarjeta_video, id_marca, id_puerto, numero_serial, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 3382 (class 0 OID 53122)
-- Dependencies: 250
-- Data for Name: salida_tarjeta_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.salida_tarjeta_video (id_salida_tarjeta_video, id_salida_video, id_tarjeta_video) FROM stdin;
\.


--
-- TOC entry 3412 (class 0 OID 53239)
-- Dependencies: 280
-- Data for Name: tipos_software; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_software (id_tipo_software, tipo_software) FROM stdin;
1	Sistema Operativo
\.


--
-- TOC entry 3388 (class 0 OID 53143)
-- Dependencies: 256
-- Data for Name: software; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.software (id_software, id_tipo_software, id_arquitectura, nombre, version, service_pack, descripcion) FROM stdin;
1	1	2	Windows 7.0 	Professional	SP1	
2	1	1	Windows 7.0	Professional	SP1	
3	1	1	Windows 7.0	Ultimate	SP1	
4	1	2	Windows 7.0	Home Premium	SP1	
5	1	1	Windows 10	Pro		
6	1	2	Windows XP	Professional V2002	SP3	
7	1	2	Debian	Stretch 9.5		
\.


--
-- TOC entry 3389 (class 0 OID 53149)
-- Dependencies: 257
-- Data for Name: software_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.software_componente (id_software_componente, id_software, id_componente, licencia, serial, observaciones, fecha_instalacion) FROM stdin;
\.


--
-- TOC entry 3397 (class 0 OID 53181)
-- Dependencies: 265
-- Data for Name: tarjetas_video_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarjetas_video_componente (id_tarjeta_video_componente, id_tarjeta_video, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 3416 (class 0 OID 53255)
-- Dependencies: 284
-- Data for Name: ups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ups (id_ups, id_componente, bateria, estado_bateria, regulador, ultimo_cambio, observaciones, id_potencia) FROM stdin;
\.


--
-- TOC entry 3418 (class 0 OID 53263)
-- Dependencies: 286
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id_usuario, nombre_usuario, password, id_ubicacion) FROM stdin;
\.


--
-- TOC entry 3427 (class 0 OID 0)
-- Dependencies: 197
-- Name: arquitecturas_id_arquitectura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.arquitecturas_id_arquitectura_seq', 2, true);


--
-- TOC entry 3428 (class 0 OID 0)
-- Dependencies: 199
-- Name: capacidades_id_capacidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.capacidades_id_capacidad_seq', 1, false);


--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 202
-- Name: componentes_equipo_id_componente_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.componentes_equipo_id_componente_equipo_seq', 28, true);


--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 203
-- Name: componentes_id_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.componentes_id_componente_seq', 28, true);


--
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 205
-- Name: cronograma_id_cronograma_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cronograma_id_cronograma_seq', 1, false);


--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 207
-- Name: detalles_orden_trabajo_id_detalle_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalles_orden_trabajo_id_detalle_seq', 1, false);


--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 209
-- Name: dimension_disco_id_dimension_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dimension_disco_id_dimension_seq', 1, false);


--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 212
-- Name: discos_componente_id_discos_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discos_componente_id_discos_componente_seq', 1, false);


--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 213
-- Name: discos_id_discos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discos_id_discos_seq', 1, false);


--
-- TOC entry 3436 (class 0 OID 0)
-- Dependencies: 215
-- Name: equipo_id_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipo_id_equipo_seq', 18, true);


--
-- TOC entry 3437 (class 0 OID 0)
-- Dependencies: 217
-- Name: fuente_componente_id_fuente_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fuente_componente_id_fuente_componente_seq', 1, false);


--
-- TOC entry 3438 (class 0 OID 0)
-- Dependencies: 219
-- Name: fuentes_id_fuente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fuentes_id_fuente_seq', 1, false);


--
-- TOC entry 3439 (class 0 OID 0)
-- Dependencies: 221
-- Name: loggin_id_loggin_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.loggin_id_loggin_seq', 1, true);


--
-- TOC entry 3440 (class 0 OID 0)
-- Dependencies: 223
-- Name: mantenimientos_id_mantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mantenimientos_id_mantenimiento_seq', 1, false);


--
-- TOC entry 3441 (class 0 OID 0)
-- Dependencies: 225
-- Name: marcas_id_marca_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marcas_id_marca_seq', 3, true);


--
-- TOC entry 3442 (class 0 OID 0)
-- Dependencies: 228
-- Name: memorias_componente_id_memorias_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.memorias_componente_id_memorias_componente_seq', 1, false);


--
-- TOC entry 3443 (class 0 OID 0)
-- Dependencies: 229
-- Name: memorias_id_memoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.memorias_id_memoria_seq', 1, false);


--
-- TOC entry 3444 (class 0 OID 0)
-- Dependencies: 231
-- Name: modelos_id_modelo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modelos_id_modelo_seq', 7, true);


--
-- TOC entry 3445 (class 0 OID 0)
-- Dependencies: 233
-- Name: motherboard_componente_id_motherboard_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.motherboard_componente_id_motherboard_componente_seq', 1, false);


--
-- TOC entry 3446 (class 0 OID 0)
-- Dependencies: 235
-- Name: motherboards_id_motherboard_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.motherboards_id_motherboard_seq', 1, false);


--
-- TOC entry 3447 (class 0 OID 0)
-- Dependencies: 237
-- Name: ordenes_trabajo_id_orden_trabajo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ordenes_trabajo_id_orden_trabajo_seq', 1, false);


--
-- TOC entry 3448 (class 0 OID 0)
-- Dependencies: 239
-- Name: permisos_id_permiso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permisos_id_permiso_seq', 1, true);


--
-- TOC entry 3449 (class 0 OID 0)
-- Dependencies: 241
-- Name: potencia_ups_id_potencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.potencia_ups_id_potencia_seq', 1, false);


--
-- TOC entry 3450 (class 0 OID 0)
-- Dependencies: 243
-- Name: procesador_componente_id_procesador_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procesador_componente_id_procesador_componente_seq', 1, false);


--
-- TOC entry 3451 (class 0 OID 0)
-- Dependencies: 245
-- Name: procesadores_id_procesador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procesadores_id_procesador_seq', 1, false);


--
-- TOC entry 3452 (class 0 OID 0)
-- Dependencies: 247
-- Name: puertos_id_puerto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.puertos_id_puerto_seq', 1, false);


--
-- TOC entry 3453 (class 0 OID 0)
-- Dependencies: 249
-- Name: resposables_id_responsable_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resposables_id_responsable_seq', 17, true);


--
-- TOC entry 3454 (class 0 OID 0)
-- Dependencies: 251
-- Name: salida_tarjeta_video_id_salida_tarjeta_video_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.salida_tarjeta_video_id_salida_tarjeta_video_seq', 1, false);


--
-- TOC entry 3455 (class 0 OID 0)
-- Dependencies: 253
-- Name: salida_video_id_salida_video_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.salida_video_id_salida_video_seq', 1, false);


--
-- TOC entry 3456 (class 0 OID 0)
-- Dependencies: 255
-- Name: sockets_id_socket_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sockets_id_socket_seq', 1, false);


--
-- TOC entry 3457 (class 0 OID 0)
-- Dependencies: 258
-- Name: software_componente_id_software_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.software_componente_id_software_componente_seq', 1, false);


--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 259
-- Name: software_id_software_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.software_id_software_seq', 7, true);


--
-- TOC entry 3459 (class 0 OID 0)
-- Dependencies: 261
-- Name: solicitudes_id_solicitud_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.solicitudes_id_solicitud_seq', 1, false);


--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 263
-- Name: soluciones_id_solucion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.soluciones_id_solucion_seq', 1, false);


--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 266
-- Name: tarjetas_video_componente_id_tarjetas_video_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarjetas_video_componente_id_tarjetas_video_componente_seq', 1, false);


--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 267
-- Name: tarjetas_video_id_tarjeta_video_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarjetas_video_id_tarjeta_video_seq', 1, false);


--
-- TOC entry 3463 (class 0 OID 0)
-- Dependencies: 269
-- Name: tecnicos_id_tecnico_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tecnicos_id_tecnico_seq', 1, true);


--
-- TOC entry 3464 (class 0 OID 0)
-- Dependencies: 271
-- Name: tipo_componente_id_tipo_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_componente_id_tipo_componente_seq', 1, true);


--
-- TOC entry 3465 (class 0 OID 0)
-- Dependencies: 273
-- Name: tipo_solicitud_id_tipo_solicitud_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_solicitud_id_tipo_solicitud_seq', 1, false);


--
-- TOC entry 3466 (class 0 OID 0)
-- Dependencies: 275
-- Name: tipos_disco_id_tipo_disco_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_disco_id_tipo_disco_seq', 1, false);


--
-- TOC entry 3467 (class 0 OID 0)
-- Dependencies: 277
-- Name: tipos_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_mantenimiento_id_tipo_mantenimiento_seq', 1, false);


--
-- TOC entry 3468 (class 0 OID 0)
-- Dependencies: 279
-- Name: tipos_memoria_id_tipo_memoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_memoria_id_tipo_memoria_seq', 1, false);


--
-- TOC entry 3469 (class 0 OID 0)
-- Dependencies: 281
-- Name: tipos_software_id_tipo_software_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_software_id_tipo_software_seq', 1, true);


--
-- TOC entry 3470 (class 0 OID 0)
-- Dependencies: 283
-- Name: ubicaciones_id_ubicacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ubicaciones_id_ubicacion_seq', 1, true);


--
-- TOC entry 3471 (class 0 OID 0)
-- Dependencies: 285
-- Name: ups_id_ups_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ups_id_ups_seq', 1, false);


--
-- TOC entry 3472 (class 0 OID 0)
-- Dependencies: 287
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 1, false);


--
-- TOC entry 3473 (class 0 OID 0)
-- Dependencies: 289
-- Name: velocidad_id_velocidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.velocidad_id_velocidad_seq', 1, false);


-- Completed on 2019-11-02 10:58:35

--
-- PostgreSQL database dump complete
--

