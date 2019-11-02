--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-11-02 11:07:42

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
-- TOC entry 2680 (class 0 OID 16628)
-- Dependencies: 209
-- Data for Name: arquitecturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.arquitecturas (id_arquitectura, arquitectura) FROM stdin;
1	x64
2	x86
3	x32
\.


--
-- TOC entry 2675 (class 0 OID 16613)
-- Dependencies: 204
-- Data for Name: capacidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.capacidades (id_capacidad, capacidad) FROM stdin;
1	64GB
2	1TB
\.


--
-- TOC entry 2678 (class 0 OID 16622)
-- Dependencies: 207
-- Data for Name: marcas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marcas (id_marca, nombre) FROM stdin;
1	Marca1
2	Marca2
3	Marca3
4	Marca4
6	Lenovo
\.


--
-- TOC entry 2679 (class 0 OID 16625)
-- Dependencies: 208
-- Data for Name: modelos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.modelos (id_modelo, id_marca, nombre) FROM stdin;
1	1	Modelo
2	2	Modelo2
4	1	Modelo34
3	4	Modelo4
5	6	G350
\.


--
-- TOC entry 2685 (class 0 OID 16646)
-- Dependencies: 214
-- Data for Name: tipos_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_componente (id_tipo_componente, nombre, descripcion, contenedor_hw, contenedor_sw) FROM stdin;
2	Mouse		\N	\N
3	Monitor		\N	\N
4	Teclado		\N	\N
5	UPS		\N	\N
1	CPU	CPU completo	f	t
6	WebCam		f	f
\.


--
-- TOC entry 2681 (class 0 OID 16634)
-- Dependencies: 210
-- Data for Name: componentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.componentes (id_componente, id_tipo_componente, id_modelo, numero_inventario, numero_serie, estado, personal, asignado, observaciones) FROM stdin;
4	4	3	1111114		t	f	f	Teclado 1
3	3	4	1111113		t	f	t	monitor si
1	1	1	1111111		t	f	f	cpu 1
2	2	2	1111112		t	f	t	mouse 1
5	5	4	11111122	2344543-3-4-534-5	t	f	f	UPS
6	1	4	8888.8888.8888.8881	sdfgdfg-dfgdf-dgfg	t	f	t	dsfghj
\.


--
-- TOC entry 2689 (class 0 OID 16658)
-- Dependencies: 218
-- Data for Name: ubicaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ubicaciones (id_ubicacion, nombre, descripcion) FROM stdin;
1	Aqui	\N
2	Alla	\N
3	En ningún lado	\N
5	Usos Multiples	\N
6	RRHH	\N
7	Economía	\N
\.


--
-- TOC entry 2690 (class 0 OID 16661)
-- Dependencies: 219
-- Data for Name: responsables; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.responsables (id_responsable, nombre, correo, id_ubicacion) FROM stdin;
3	Ella	sefwrfw	3
2	Nosotros	reterter	2
4	Pepito	2345@34354.234	1
5	Pablito	eeeeeee	1
6	sdf	e	6
\.


--
-- TOC entry 2688 (class 0 OID 16655)
-- Dependencies: 217
-- Data for Name: equipos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipos (id_equipo, id_ubicacion, estado, id_responsable, observaciones) FROM stdin;
14	7	t	4	
1	5	t	3	Equipo 1
7	6	t	2	A
5	6	t	3	ABC
6	5	t	2	Componentes
\.


--
-- TOC entry 2742 (class 0 OID 17465)
-- Dependencies: 271
-- Data for Name: componentes_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.componentes_equipo (id_componente_equipo, id_equipo, id_componente, fecha_vinculado, fecha_desvinculado, estado, observaciones) FROM stdin;
4	6	1	2019-01-16	2019-01-19	f	cpu 1
5	6	3	2019-01-16	\N	t	monitor si
9	1	5	2019-01-19	2019-01-19	f	\N
11	1	5	2019-01-19	2019-01-21	f	\N
10	5	1	2019-01-19	2019-01-21	f	\N
12	1	5	2019-01-21	2019-01-21	f	\N
13	1	5	2019-01-21	2019-01-21	f	\N
14	1	5	2019-01-21	2019-01-21	f	\N
15	1	5	2019-01-21	\N	t	\N
16	14	2	2019-01-25	\N	t	\N
17	14	6	2019-07-06	\N	t	\N
\.


--
-- TOC entry 2696 (class 0 OID 16691)
-- Dependencies: 225
-- Data for Name: mantenimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mantenimientos (id_mantenimiento, nombre, descripcion) FROM stdin;
1	Correctivo	
2	Preventivo	
\.


--
-- TOC entry 2744 (class 0 OID 17543)
-- Dependencies: 273
-- Data for Name: tipos_solicitud; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_solicitud (id_tipo_solicitud, nombre) FROM stdin;
1	Problema con mi equipo (EUS)
2	Problema con un equipo en la Unidad/Area
3	Problema con mi equipo personal 
\.


--
-- TOC entry 2692 (class 0 OID 16673)
-- Dependencies: 221
-- Data for Name: solicitudes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.solicitudes (id_solicitud, id_responsable, fecha_solicitud, problema, codigo_seguimiento, id_tipo_solicitud, id_ubicacion, estado) FROM stdin;
59	5	2019-10-28	xfghjkjhgf	74400059	1	1	f
57	4	2019-10-07	dd	22300057	1	1	f
66	5	2019-10-29	Tasukete!	82400066	1	1	t
45	5	2019-04-27	sacfgfnhjhtgfscdcrnj	13100045	3	1	f
44	5	2019-04-27	sacfgfnhjhtgfscdcrnj	40600044	3	1	f
41	5	2019-04-27	sacfgfnhjhtgfscdcrnj	84800041	3	1	f
38	5	2019-04-27	sacfgfnhjhtgfscdcrnj	55400038	3	1	f
33	4	2019-03-25	efghjgfhfdghr	45200033	2	1	t
63	4	2019-10-29	dfthythtr	99000063	3	1	t
61	5	2019-10-28	xfghjkjhgf	62400061	1	1	f
46	5	2019-04-27	sacfgfnhjhtgfscdcrnj	58900046	3	1	f
42	5	2019-04-27	sacfgfnhjhtgfscdcrnj	74500042	3	1	f
40	5	2019-04-27	sacfgfnhjhtgfscdcrnj	32500040	3	1	f
39	5	2019-04-27	sacfgfnhjhtgfscdcrnj	13400039	3	1	f
49	4	2019-06-29	edfdfdfd	44800049	1	1	t
47	5	2019-04-27	sacfgfnhjhtgfscdcrnj	98000047	3	1	t
48	4	2019-06-29	AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA	30300048	2	1	f
51	4	2019-10-07	xcbxhgbdfbsdgbxc	76700051	3	1	\N
52	5	2019-10-07	sfgfhjkhhhgreg h gfhfghf 	33300052	2	1	\N
53	4	2019-10-07	ccccccccc	69900053	1	1	\N
55	4	2019-10-07	dfghjhhgfddfegrthyj	14400055	1	1	\N
56	2	2019-10-07	sdfghhjgsddf	56400056	2	2	\N
58	5	2019-10-28	xfghjkjhgf	48100058	1	1	\N
60	5	2019-10-28	xfghjkjhgf	41000060	1	1	\N
34	5	2019-04-27	sacfgfnhjhtgfscdcrnj	83500034	3	1	f
35	5	2019-04-27	sacfgfnhjhtgfscdcrnj	88600035	3	1	f
43	5	2019-04-27	sacfgfnhjhtgfscdcrnj	34000043	3	1	f
36	5	2019-04-27	sacfgfnhjhtgfscdcrnj	53100036	3	1	f
32	4	2019-03-25	fgfhjgsfghjgrfh	72800032	2	1	f
75	3	2019-10-29	srge5y5	85000075	2	3	t
37	5	2019-04-27	sacfgfnhjhtgfscdcrnj	72900037	3	1	f
54	4	2019-10-07	ccccccccc	80100054	1	1	t
74	4	2019-10-29	sfdgtye5	59700074	2	1	t
64	4	2019-10-29	dsfgdrhg	56700064	1	1	f
70	5	2019-10-29	5ytrgt5y	43800070	1	1	t
69	4	2019-10-29	dfsfsdfmkjkkknj	19200069	1	1	t
68	5	2019-10-29	dfsfsdf	94500068	1	1	t
67	4	2019-10-29	jskfhkjghskdfj	63000067	1	1	t
65	4	2019-10-29	dsfgdrhg	26200065	1	1	t
73	5	2019-10-29	fwgrthyrheg	18100073	1	1	f
72	4	2019-10-29	minubyvtcrxercv	21000072	1	1	f
71	4	2019-10-29	minubyvtcrxercv	52900071	1	1	f
76	4	2019-10-31	Por que me da error y el glassfish no me dice nada	57000076	1	1	t
\.


--
-- TOC entry 2697 (class 0 OID 16694)
-- Dependencies: 226
-- Data for Name: tecnicos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tecnicos (id_tecnico, nombre, descripcion, correo, estado) FROM stdin;
1	Eduardo Acevedo Flores	:v	eduu_ace7@hotmail.com	t
3	Fuentes	saadsfdghg	nose@niidea.oc	t
4	Veralice		jdhfsjdf@dfdfdk.com	t
5	erwewerwe 1	ewrwer	wqewe	t
7	fxgdfgd	dd	dd	\N
8	dfsfd	edfd	df1	\N
9	dfdfd	df	frgd	\N
10	xffdf	dfgg	dsf	\N
11	xffdfcccc	dfggcc	dsfcc	\N
12	xffdfcccc	dfggcc	dsfcc	\N
13	xffdfcccc	dfggcc	dsfcc	\N
14	fghgds	dfgh	fg	\N
\.


--
-- TOC entry 2693 (class 0 OID 16676)
-- Dependencies: 222
-- Data for Name: ordenes_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ordenes_trabajo (id_orden_trabajo, id_solicitud, id_mantenimiento, id_tecnico, fecha_inicio, fecha_finalizacion, hora_inicio, hora_finalizacion, observaciones, estado, id_equipo, prioridad) FROM stdin;
7	49	1	3	2019-07-06	\N	13:38	\N	\N	\N	14	\N
8	49	1	4	2019-07-13	\N	10:15	\N	\N	\N	14	\N
9	49	1	1	2019-07-13	\N	10:16	\N	\N	\N	14	\N
10	49	1	3	2019-07-13	\N	10:28	\N	\N	\N	14	\N
11	49	1	3	2019-07-13	\N	10:33	\N	\N	\N	14	\N
12	49	1	1	2019-07-13	\N	10:34	\N	\N	\N	14	Alta
15	61	1	1	2019-10-28	\N	18:21	\N	\N	1	14	Media
16	61	1	4	2019-10-28	\N	18:26	\N	\N	1	14	Media
17	61	1	3	2019-10-28	\N	18:28	\N	\N	1	14	Media
18	61	1	5	2019-10-28	\N	18:29	\N	\N	1	14	Baja
19	61	1	1	2019-10-28	\N	18:35	\N	\N	1	14	Baja
20	57	1	1	2019-10-28	\N	18:36	\N	\N	1	14	Baja
21	54	1	3	2019-10-28	\N	18:43	\N	\N	1	14	Baja
22	57	1	3	2019-10-29	\N	11:2	\N	\N	1	14	Baja
23	57	1	3	2019-10-29	\N	15:35	\N	\N	1	14	Baja
24	75	1	3	2019-10-29	\N	16:14	\N	\N	1	14	Baja
25	76	1	3	2019-10-31	\N	11:31	\N	\N	1	14	Media
\.


--
-- TOC entry 2691 (class 0 OID 16667)
-- Dependencies: 220
-- Data for Name: cronograma; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cronograma (id_cronograma, fecha_inicio, fecha_fin, nombre_evento, descripcion, id_orden_trabajo) FROM stdin;
80	2018-12-15	2018-12-16	sdfghj	\N	\N
81	2018-12-20	2018-12-20	dfghfsdfgd	SSSSS	\N
82	2019-02-07	2019-02-10	Mantto Preventivo		\N
83	2019-01-28	2019-02-02	Presentaciones		\N
84	2019-02-05	2019-02-05	Expo		\N
85	2019-09-19	2019-09-19	dfgh		\N
\.


--
-- TOC entry 2684 (class 0 OID 16643)
-- Dependencies: 213
-- Data for Name: soluciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.soluciones (id_solucion, nombre, descripcion) FROM stdin;
2	No sé	
3	Ni idea	
4	Holo	
5	Tirarla a la basura	
6	Tirarla a la basura x2	
7	Tirarla a la basura x3	
8	Tirarla a la basura x4	
9	Tirarla a la basura x5	
10	sdfsdf	
11	aaaaaaaaaaaahh	
12	asdasd	
13	RCP	:v
15	sdfsdf	
16	sdfsdfsdfs	
\.


--
-- TOC entry 2695 (class 0 OID 16688)
-- Dependencies: 224
-- Data for Name: tipos_mantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_mantenimiento (id_tipo_mantenimiento, id_mantenimiento, nombre, descripcion) FROM stdin;
2	2	Software	
3	1	Hardware	
4	2	No sé	
5	1	Software	Asd
6	2	Hardware	
\.


--
-- TOC entry 2694 (class 0 OID 16685)
-- Dependencies: 223
-- Data for Name: detalles_orden_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalles_orden_trabajo (id_detalle, id_orden_trabajo, id_solucion, observaciones, id_tipo_mantenimiento) FROM stdin;
\.


--
-- TOC entry 2730 (class 0 OID 17413)
-- Dependencies: 259
-- Data for Name: dimension_disco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dimension_disco (id_dimension, dimension) FROM stdin;
\.


--
-- TOC entry 2676 (class 0 OID 16616)
-- Dependencies: 205
-- Data for Name: puertos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.puertos (id_puerto, tipo_puerto) FROM stdin;
1	SATA
2	M2
\.


--
-- TOC entry 2668 (class 0 OID 16592)
-- Dependencies: 197
-- Data for Name: tipos_disco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_disco (id_tipo_disco, tipo_disco) FROM stdin;
3	M2
2	SSD
1	HDD
\.


--
-- TOC entry 2670 (class 0 OID 16598)
-- Dependencies: 199
-- Data for Name: discos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.discos (id_disco, id_marca, id_capacidad, id_puerto, id_tipo_disco, numero_serie, id_dimension, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 2754 (class 0 OID 33966)
-- Dependencies: 283
-- Data for Name: discos_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.discos_componente (id_discos_componente, id_discos, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 2673 (class 0 OID 16607)
-- Dependencies: 202
-- Data for Name: fuentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fuentes (id_fuente, id_modelo, potencia, numero_pines, numero_serie, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 2752 (class 0 OID 33957)
-- Dependencies: 281
-- Data for Name: fuente_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fuente_componente (id_fuente_componente, id_fuente, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 2746 (class 0 OID 17564)
-- Dependencies: 275
-- Data for Name: loggin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.loggin (id_loggin, id_tecnico, nombre_loggin, passwoird) FROM stdin;
1	1	asdf	asdf
\.


--
-- TOC entry 2667 (class 0 OID 16589)
-- Dependencies: 196
-- Data for Name: tipos_memoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_memoria (id_tipo_memoria, tipo_memoria) FROM stdin;
1	DDR2
3	DDR3
4	DDR7
2	DDR1.5
\.


--
-- TOC entry 2732 (class 0 OID 17422)
-- Dependencies: 261
-- Data for Name: velocidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.velocidad (id_velocidad, velocidad) FROM stdin;
\.


--
-- TOC entry 2669 (class 0 OID 16595)
-- Dependencies: 198
-- Data for Name: memorias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.memorias (id_memoria, id_marca, id_tipo, id_capacidad, numero_serie, id_velocidad, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 2750 (class 0 OID 33948)
-- Dependencies: 279
-- Data for Name: memorias_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.memorias_componente (id_memorias_componente, id_memoria, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 2677 (class 0 OID 16619)
-- Dependencies: 206
-- Data for Name: sockets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sockets (id_socket, socket) FROM stdin;
1	Socket1
2	Socket2
3	Socket3
\.


--
-- TOC entry 2672 (class 0 OID 16604)
-- Dependencies: 201
-- Data for Name: motherboards; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.motherboards (id_motherboard, id_marca, id_socket, numero_serie, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 2756 (class 0 OID 33975)
-- Dependencies: 285
-- Data for Name: motherboard_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.motherboard_componente (id_motherboard_componente, id_motherboard, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 2748 (class 0 OID 25756)
-- Dependencies: 277
-- Data for Name: permisos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permisos (id_permiso, id_loggin, arquitectura, componentes, cronograma, equipos, mantenimiento, marcas, modelos, hardware, software, software_componente, hardware_componente, responsables, solicitudes, soluciones, tecnicos, ubicaciones, orden_trabajo, permisos) FROM stdin;
1	1	t	t	t	t	t	t	t	t	t	t	t	t	t	t	t	t	t	\N
\.


--
-- TOC entry 2738 (class 0 OID 17447)
-- Dependencies: 267
-- Data for Name: potencia_ups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.potencia_ups (id_potencia, voltaje, amperaje) FROM stdin;
\.


--
-- TOC entry 2671 (class 0 OID 16601)
-- Dependencies: 200
-- Data for Name: procesadores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.procesadores (id_procesador, id_modelo, id_arquitectura, id_socket, numero_serie, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 2760 (class 0 OID 33993)
-- Dependencies: 289
-- Data for Name: procesador_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.procesador_componente (id_procesador_componente, id_procesador, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 2734 (class 0 OID 17431)
-- Dependencies: 263
-- Data for Name: salida_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.salida_video (id_salida_video, tipo_salida) FROM stdin;
\.


--
-- TOC entry 2674 (class 0 OID 16610)
-- Dependencies: 203
-- Data for Name: tarjetas_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarjetas_video (id_tarjeta_video, id_marca, id_puerto, numero_serial, estado, asignado, fecha_de_baja, observaciones) FROM stdin;
\.


--
-- TOC entry 2736 (class 0 OID 17441)
-- Dependencies: 265
-- Data for Name: salida_tarjeta_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.salida_tarjeta_video (id_salida_tarjeta_video, id_salida_video, id_tarjeta_video) FROM stdin;
\.


--
-- TOC entry 2686 (class 0 OID 16649)
-- Dependencies: 215
-- Data for Name: tipos_software; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipos_software (id_tipo_software, tipo_software) FROM stdin;
1	SO
2	wefsdhdgf
3	sdsrtwr
\.


--
-- TOC entry 2683 (class 0 OID 16640)
-- Dependencies: 212
-- Data for Name: software; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.software (id_software, id_tipo_software, id_arquitectura, nombre, version, service_pack, descripcion) FROM stdin;
1	1	1	Windows 	10		Es un windows
2	1	1	Debian	9.9		
3	2	1	Microsoft Office	2019		
4	2	3	Microsoft Office	2010	3	
5	3	1	AVG antivirus	2019		
6	3	3	Avast antivirus	10	3	
\.


--
-- TOC entry 2682 (class 0 OID 16637)
-- Dependencies: 211
-- Data for Name: software_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.software_componente (id_software_componente, id_software, id_componente, licencia, serial, observaciones, fecha_instalacion) FROM stdin;
2	1	4	t	444444	fffffff	\N
9	2	3	\N	\N	\N	\N
10	6	1	\N	\N	\N	\N
\.


--
-- TOC entry 2758 (class 0 OID 33984)
-- Dependencies: 287
-- Data for Name: tarjetas_video_componente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarjetas_video_componente (id_tarjeta_video_componente, id_tarjeta_video, id_componente, fecha_asignado, fecha_cambio, estado, observaciones) FROM stdin;
\.


--
-- TOC entry 2687 (class 0 OID 16652)
-- Dependencies: 216
-- Data for Name: ups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ups (id_ups, id_componente, bateria, estado_bateria, regulador, ultimo_cambio, observaciones, id_potencia) FROM stdin;
\.


--
-- TOC entry 2740 (class 0 OID 17456)
-- Dependencies: 269
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id_usuario, nombre_usuario, password, id_ubicacion) FROM stdin;
1	Departamento Ingenieria	1234	1
2	RRHH	1234	6
3	dfg	1234	7
4	alla	1234	2
5	en ni	1234	3
6	sdfgfeg	1234	5
\.


--
-- TOC entry 2766 (class 0 OID 0)
-- Dependencies: 227
-- Name: arquitecturas_id_arquitectura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.arquitecturas_id_arquitectura_seq', 3, true);


--
-- TOC entry 2767 (class 0 OID 0)
-- Dependencies: 228
-- Name: capacidades_id_capacidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.capacidades_id_capacidad_seq', 2, true);


--
-- TOC entry 2768 (class 0 OID 0)
-- Dependencies: 270
-- Name: componentes_equipo_id_componente_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.componentes_equipo_id_componente_equipo_seq', 17, true);


--
-- TOC entry 2769 (class 0 OID 0)
-- Dependencies: 229
-- Name: componentes_id_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.componentes_id_componente_seq', 6, true);


--
-- TOC entry 2770 (class 0 OID 0)
-- Dependencies: 230
-- Name: cronograma_id_cronograma_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cronograma_id_cronograma_seq', 85, true);


--
-- TOC entry 2771 (class 0 OID 0)
-- Dependencies: 231
-- Name: detalles_orden_trabajo_id_detalle_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalles_orden_trabajo_id_detalle_seq', 1, false);


--
-- TOC entry 2772 (class 0 OID 0)
-- Dependencies: 258
-- Name: dimension_disco_id_dimension_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dimension_disco_id_dimension_seq', 1, false);


--
-- TOC entry 2773 (class 0 OID 0)
-- Dependencies: 282
-- Name: discos_componente_id_discos_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discos_componente_id_discos_componente_seq', 1, false);


--
-- TOC entry 2774 (class 0 OID 0)
-- Dependencies: 232
-- Name: discos_id_discos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discos_id_discos_seq', 1, false);


--
-- TOC entry 2775 (class 0 OID 0)
-- Dependencies: 233
-- Name: equipo_id_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipo_id_equipo_seq', 14, true);


--
-- TOC entry 2776 (class 0 OID 0)
-- Dependencies: 280
-- Name: fuente_componente_id_fuente_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fuente_componente_id_fuente_componente_seq', 1, false);


--
-- TOC entry 2777 (class 0 OID 0)
-- Dependencies: 234
-- Name: fuentes_id_fuente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fuentes_id_fuente_seq', 1, false);


--
-- TOC entry 2778 (class 0 OID 0)
-- Dependencies: 274
-- Name: loggin_id_loggin_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.loggin_id_loggin_seq', 1, false);


--
-- TOC entry 2779 (class 0 OID 0)
-- Dependencies: 235
-- Name: mantenimientos_id_mantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mantenimientos_id_mantenimiento_seq', 2, true);


--
-- TOC entry 2780 (class 0 OID 0)
-- Dependencies: 236
-- Name: marcas_id_marca_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marcas_id_marca_seq', 6, true);


--
-- TOC entry 2781 (class 0 OID 0)
-- Dependencies: 278
-- Name: memorias_componente_id_memorias_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.memorias_componente_id_memorias_componente_seq', 1, false);


--
-- TOC entry 2782 (class 0 OID 0)
-- Dependencies: 237
-- Name: memorias_id_memoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.memorias_id_memoria_seq', 1, false);


--
-- TOC entry 2783 (class 0 OID 0)
-- Dependencies: 238
-- Name: modelos_id_modelo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modelos_id_modelo_seq', 5, true);


--
-- TOC entry 2784 (class 0 OID 0)
-- Dependencies: 284
-- Name: motherboard_componente_id_motherboard_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.motherboard_componente_id_motherboard_componente_seq', 1, false);


--
-- TOC entry 2785 (class 0 OID 0)
-- Dependencies: 239
-- Name: motherboards_id_motherboard_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.motherboards_id_motherboard_seq', 1, false);


--
-- TOC entry 2786 (class 0 OID 0)
-- Dependencies: 240
-- Name: ordenes_trabajo_id_orden_trabajo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ordenes_trabajo_id_orden_trabajo_seq', 25, true);


--
-- TOC entry 2787 (class 0 OID 0)
-- Dependencies: 276
-- Name: permisos_id_permiso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permisos_id_permiso_seq', 1, false);


--
-- TOC entry 2788 (class 0 OID 0)
-- Dependencies: 266
-- Name: potencia_ups_id_potencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.potencia_ups_id_potencia_seq', 1, false);


--
-- TOC entry 2789 (class 0 OID 0)
-- Dependencies: 288
-- Name: procesador_componente_id_procesador_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procesador_componente_id_procesador_componente_seq', 1, false);


--
-- TOC entry 2790 (class 0 OID 0)
-- Dependencies: 241
-- Name: procesadores_id_procesador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procesadores_id_procesador_seq', 1, false);


--
-- TOC entry 2791 (class 0 OID 0)
-- Dependencies: 242
-- Name: puertos_id_puerto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.puertos_id_puerto_seq', 2, true);


--
-- TOC entry 2792 (class 0 OID 0)
-- Dependencies: 243
-- Name: resposables_id_responsable_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resposables_id_responsable_seq', 6, true);


--
-- TOC entry 2793 (class 0 OID 0)
-- Dependencies: 264
-- Name: salida_tarjeta_video_id_salida_tarjeta_video_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.salida_tarjeta_video_id_salida_tarjeta_video_seq', 1, false);


--
-- TOC entry 2794 (class 0 OID 0)
-- Dependencies: 262
-- Name: salida_video_id_salida_video_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.salida_video_id_salida_video_seq', 1, false);


--
-- TOC entry 2795 (class 0 OID 0)
-- Dependencies: 244
-- Name: sockets_id_socket_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sockets_id_socket_seq', 3, true);


--
-- TOC entry 2796 (class 0 OID 0)
-- Dependencies: 246
-- Name: software_componente_id_software_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.software_componente_id_software_componente_seq', 11, true);


--
-- TOC entry 2797 (class 0 OID 0)
-- Dependencies: 245
-- Name: software_id_software_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.software_id_software_seq', 6, true);


--
-- TOC entry 2798 (class 0 OID 0)
-- Dependencies: 247
-- Name: solicitudes_id_solicitud_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.solicitudes_id_solicitud_seq', 76, true);


--
-- TOC entry 2799 (class 0 OID 0)
-- Dependencies: 248
-- Name: soluciones_id_solucion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.soluciones_id_solucion_seq', 16, true);


--
-- TOC entry 2800 (class 0 OID 0)
-- Dependencies: 286
-- Name: tarjetas_video_componente_id_tarjetas_video_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarjetas_video_componente_id_tarjetas_video_componente_seq', 1, false);


--
-- TOC entry 2801 (class 0 OID 0)
-- Dependencies: 249
-- Name: tarjetas_video_id_tarjeta_video_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarjetas_video_id_tarjeta_video_seq', 1, false);


--
-- TOC entry 2802 (class 0 OID 0)
-- Dependencies: 250
-- Name: tecnicos_id_tecnico_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tecnicos_id_tecnico_seq', 14, true);


--
-- TOC entry 2803 (class 0 OID 0)
-- Dependencies: 251
-- Name: tipo_componente_id_tipo_componente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_componente_id_tipo_componente_seq', 6, true);


--
-- TOC entry 2804 (class 0 OID 0)
-- Dependencies: 272
-- Name: tipo_solicitud_id_tipo_solicitud_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_solicitud_id_tipo_solicitud_seq', 1, false);


--
-- TOC entry 2805 (class 0 OID 0)
-- Dependencies: 252
-- Name: tipos_disco_id_tipo_disco_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_disco_id_tipo_disco_seq', 3, true);


--
-- TOC entry 2806 (class 0 OID 0)
-- Dependencies: 253
-- Name: tipos_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_mantenimiento_id_tipo_mantenimiento_seq', 6, true);


--
-- TOC entry 2807 (class 0 OID 0)
-- Dependencies: 254
-- Name: tipos_memoria_id_tipo_memoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_memoria_id_tipo_memoria_seq', 4, true);


--
-- TOC entry 2808 (class 0 OID 0)
-- Dependencies: 255
-- Name: tipos_software_id_tipo_software_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipos_software_id_tipo_software_seq', 3, true);


--
-- TOC entry 2809 (class 0 OID 0)
-- Dependencies: 256
-- Name: ubicaciones_id_ubicacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ubicaciones_id_ubicacion_seq', 7, true);


--
-- TOC entry 2810 (class 0 OID 0)
-- Dependencies: 257
-- Name: ups_id_ups_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ups_id_ups_seq', 1, false);


--
-- TOC entry 2811 (class 0 OID 0)
-- Dependencies: 268
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 1, false);


--
-- TOC entry 2812 (class 0 OID 0)
-- Dependencies: 260
-- Name: velocidad_id_velocidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.velocidad_id_velocidad_seq', 1, false);


-- Completed on 2019-11-02 11:07:43

--
-- PostgreSQL database dump complete
--

