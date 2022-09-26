/**
  Test data used by the application.
 */

TRUNCATE TABLE public.airplane RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.customer RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.ticket_type RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.ticket_option RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.airport RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.booking RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.flight RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.ticket RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.booked_option RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.daily_discount RESTART IDENTITY CASCADE;

INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (1, 385, 'N206NV');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (2, 162, 'N21375');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (3, 190, 'N13738');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (4, 187, 'N141YN');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (5, 375, 'N28162');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (6, 336, 'N1338I');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (7, 177, 'N183UQ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (8, 130, 'N27782');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (9, 287, 'N275PU');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (10, 286, 'N2267X');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (11, 300, 'N274XP');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (12, 132, 'N17722');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (13, 360, 'N2947I');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (14, 301, 'N11598');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (15, 145, 'N2745E');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (16, 201, 'N222DJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (17, 283, 'N1755P');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (18, 339, 'N16293');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (19, 253, 'N28181');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (20, 341, 'N2532D');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (21, 360, 'N1274O');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (22, 152, 'N123YX');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (23, 374, 'N241XZ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (24, 219, 'N168MD');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (25, 314, 'N28804');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (26, 135, 'N182TF');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (27, 104, 'N272PP');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (28, 160, 'N219WX');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (29, 198, 'N1233N');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (30, 397, 'N2941Z');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (31, 144, 'N105SK');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (32, 286, 'N1828L');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (33, 348, 'N2148L');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (34, 103, 'N212TJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (35, 156, 'N21306');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (36, 139, 'N2483D');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (37, 302, 'N2074E');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (38, 389, 'N2553Y');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (39, 321, 'N26665');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (40, 308, 'N12218');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (41, 132, 'N245TV');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (42, 361, 'N2325S');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (43, 157, 'N10378');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (44, 260, 'N1599H');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (45, 362, 'N163SJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (46, 381, 'N202BA');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (47, 358, 'N22838');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (48, 155, 'N279YJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (49, 386, 'N102NI');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (50, 285, 'N2510Y');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (51, 161, 'N155JM');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (52, 131, 'N2294G');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (53, 301, 'N205FF');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (54, 310, 'N27490');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (55, 301, 'N131LC');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (56, 265, 'N185PQ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (57, 144, 'N19242');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (58, 314, 'N11132');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (59, 343, 'N1044N');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (60, 187, 'N1485S');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (61, 169, 'N17822');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (62, 301, 'N18862');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (63, 250, 'N258OR');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (64, 184, 'N211GJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (65, 266, 'N24060');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (66, 277, 'N14306');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (67, 180, 'N1918E');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (68, 255, 'N1098I');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (69, 338, 'N1586O');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (70, 334, 'N23367');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (71, 251, 'N16276');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (72, 253, 'N22571');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (73, 362, 'N2154L');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (74, 307, 'N25172');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (75, 224, 'N24857');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (76, 369, 'N29166');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (77, 378, 'N29586');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (78, 171, 'N2295O');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (79, 386, 'N24477');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (80, 244, 'N236XI');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (81, 154, 'N29105');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (82, 316, 'N2452H');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (83, 367, 'N1071Y');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (84, 204, 'N291ZC');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (85, 164, 'N13679');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (86, 112, 'N29900');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (87, 119, 'N2069G');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (88, 309, 'N141AU');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (89, 238, 'N22138');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (90, 126, 'N151XH');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (91, 203, 'N2228L');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (92, 179, 'N12833');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (93, 240, 'N1895C');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (94, 364, 'N29840');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (95, 368, 'N232ML');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (96, 123, 'N198HJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (97, 179, 'N10819');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (98, 341, 'N210LJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (99, 315, 'N14134');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (100, 307, 'N263BM');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (101, 268, 'N1804P');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (102, 164, 'N252DL');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (103, 116, 'N25317');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (104, 341, 'N16185');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (105, 232, 'N2459R');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (106, 369, 'N105SJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (107, 124, 'N102TE');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (108, 204, 'N26818');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (109, 167, 'N18971');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (110, 239, 'N200ZQ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (111, 331, 'N184VV');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (112, 328, 'N1777R');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (113, 276, 'N20499');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (114, 378, 'N1857T');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (115, 159, 'N15649');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (116, 224, 'N1492L');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (117, 298, 'N145RY');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (118, 153, 'N2420H');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (119, 226, 'N1043O');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (120, 153, 'N284WG');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (121, 229, 'N1050X');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (122, 140, 'N1043S');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (123, 346, 'N239YE');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (124, 205, 'N25153');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (125, 269, 'N236HO');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (126, 150, 'N2658I');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (127, 286, 'N240XS');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (128, 295, 'N1111B');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (129, 161, 'N248DC');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (130, 310, 'N142BU');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (131, 306, 'N260GN');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (132, 229, 'N20614');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (133, 219, 'N2476Y');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (134, 295, 'N218PY');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (135, 177, 'N1426S');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (136, 208, 'N293YH');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (137, 236, 'N2679Q');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (138, 345, 'N262RM');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (139, 266, 'N11901');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (140, 284, 'N14898');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (141, 158, 'N2420C');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (142, 150, 'N290JQ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (143, 380, 'N25623');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (144, 188, 'N20124');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (145, 148, 'N16556');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (146, 235, 'N29365');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (147, 282, 'N282YF');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (148, 257, 'N28845');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (149, 354, 'N1973F');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (150, 181, 'N101NX');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (151, 275, 'N23008');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (152, 313, 'N1735R');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (153, 266, 'N276SV');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (154, 246, 'N22635');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (155, 142, 'N18196');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (156, 154, 'N16764');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (157, 298, 'N2960T');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (158, 113, 'N2005G');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (159, 256, 'N295UC');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (160, 277, 'N2640M');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (161, 146, 'N21041');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (162, 387, 'N1910A');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (163, 298, 'N14435');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (164, 265, 'N2070W');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (165, 190, 'N17971');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (166, 138, 'N21197');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (167, 394, 'N1592E');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (168, 233, 'N101RF');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (169, 339, 'N2501T');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (170, 196, 'N1331E');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (171, 375, 'N279SF');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (172, 135, 'N1348E');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (173, 382, 'N18983');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (174, 147, 'N133QJ');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (175, 120, 'N1127N');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (176, 286, 'N151XK');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (177, 287, 'N265EL');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (178, 331, 'N10818');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (179, 110, 'N204YC');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (180, 216, 'N1297O');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (181, 287, 'N1609Y');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (182, 368, 'N2177K');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (183, 328, 'N1575H');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (184, 157, 'N24691');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (185, 173, 'N249OH');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (186, 369, 'N11729');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (187, 379, 'N25799');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (188, 126, 'N1371Z');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (189, 340, 'N140TV');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (190, 380, 'N1707C');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (191, 204, 'N20138');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (192, 349, 'N23181');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (193, 169, 'N2265I');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (194, 189, 'N21455');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (195, 233, 'N294JD');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (196, 368, 'N122BP');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (197, 108, 'N18538');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (198, 211, 'N234AK');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (199, 304, 'N252HD');
INSERT INTO public.airplane (id, max_capacity, registration_number) OVERRIDING SYSTEM VALUE
VALUES (200, 376, 'N21702');

ALTER SEQUENCE public.airplane_id_seq RESTART WITH 201;

INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (1, 'Hendrika Griffin', 'qe8l8e87w0@hoswo.de', '1996-06-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (2, 'George Goode', '6o156chzu@jqmaz.nl', '1981-10-13');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (3, 'Joelle Jefferson', 'ilijxoixo1@ceaem.nl', '1987-07-23');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (4, 'Donetta Ivers', 'jzx3z3@vaidb.nl', '2014-05-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (5, 'Lilllie Gilliam', 'crbm3bg6t@gvbcd.com', '2009-12-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (6, 'Jessa Harlow', 'lzklla@xaxgi.net', '1984-10-08');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (7, 'Aggi Womack', 'c3lk@vhxep.com', '2008-08-05');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (8, 'Sheila-kathryn Carl', 'xnnoi@groyr.de', '1989-02-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (9, 'Avivah Levitt', 'ardq124f@ccfgv.de', '2021-04-07');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (10, 'Anetta Ray', 'yioz4@oifdj.com', '2008-08-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (11, 'Jennifer Michaelson', 'mqah@xpyps.com', '2016-08-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (12, 'Maribel Gully', 'e9t40q@jydou.de', '1998-12-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (13, 'Barbie Kersey', 'kxad4ap3wd@ohjaz.net', '1989-08-14');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (14, 'Aime Courtney', 'mr4hv7@qxaqx.nl', '2003-04-15');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (15, 'Elfreda Baker', 'hd2502q@qglqe.de', '2005-03-29');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (16, 'Marabel Davidson', '07l2n8v@yroif.net', '2001-05-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (17, 'Melisande Vernon', 'dm6vft@vsyfz.com', '2002-01-19');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (18, 'Lacey Greene', '19l706mj@vvjvv.com', '2003-03-15');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (19, 'Shirlee Purcell', 'fgqi@rvujo.co.uk', '1974-06-10');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (20, 'Nona Easton', 'xq3l3ssyc@uuqfv.co.uk', '2020-07-14');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (21, 'Camilla Wolfe', 'vj7f@xdwff.de', '1972-04-25');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (22, 'Anne-marie Crewe', '1ggjn@tvfwc.nl', '2019-07-25');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (23, 'Rosie Fletcher', '8u1187pja@mwptt.de', '1976-05-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (24, 'Devin Dickenson', 'rfk1@bmgns.net', '1990-01-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (25, 'Rubie Hedley', 'd134s25yd@gdgvp.co.uk', '1999-08-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (26, 'Hyacinthie Hodges', 'gxipu1eb@juxxf.co.uk', '1987-01-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (27, 'Abra Bennett', 'vbvf160b3g@tvqrx.de', '2013-05-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (28, 'Idell Howe', 'tfdku@yntdl.net', '2004-06-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (29, 'Debi Danell', 'w9pbvl7dw@wmlik.nl', '1994-03-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (30, 'Sabra Vincent', 'mkean75y@zriah.nl', '1988-12-10');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (31, 'Silvana Spence', 'oota@vohqo.com', '1997-07-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (32, 'Estrellita Gladwin', '6fhx5ma0x@crprd.de', '2012-02-05');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (33, 'Shae Larson', 'st7i1y@kgrgi.com', '1972-03-30');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (34, 'Audrye Reynolds', 'wg404f@pdbjr.co.uk', '1988-10-11');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (35, 'Hanny Williamson', 'zq3xm13@mqoxy.de', '2011-09-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (36, 'Quintilla Webster', 'xbnn@mqhmm.co.uk', '2006-02-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (37, 'Coraline Hawking', 'qsuk6@jprgt.com', '2002-11-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (38, 'Oralle Slater', 'a0dx@qnsyj.de', '1981-10-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (39, 'Larine Wolf', 'jw0as@sjwyt.nl', '1978-11-05');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (40, 'Joan Devin', '0sz4eoz6@rbhyi.net', '2015-09-18');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (41, 'Harli Alexander', 'dtb9z@civyx.nl', '1975-09-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (42, 'Maye Quigley', '95atwgyfk5@jpbyt.net', '2009-11-02');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (43, 'Shelbi Teel', 'gm3r1@oaufl.nl', '1972-04-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (44, 'Mahala Bentley', 'v1pg9@uxnew.de', '2000-05-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (45, 'Tamarah Grant', '7hdjhmoohc@eyhsk.com', '1991-11-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (46, 'Ilysa Henry', 'c4kgvp@vdjzx.de', '1997-03-12');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (47, 'Marcile Perkins', '5peg@uodsc.de', '1991-05-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (48, 'Lorne Parsons', 'crk4@vjxqh.net', '1996-07-09');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (49, 'Eileen Durant', 'rvfd54f9us@krxuy.nl', '1980-05-18');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (50, 'Mora Endicott', 'nrgdr8@laxhq.net', '1974-09-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (51, 'Barbaraanne Brewer', 'opbuvr30m1@sohhd.nl', '2012-09-15');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (52, 'Shannah Hicks', 'y22i9w2@zdqjn.com', '1992-06-05');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (53, 'Idette Victor', 'jmlo1kju6y@mpwmq.nl', '2019-12-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (54, 'Bette Albertson', '0tvyf@ptrvj.co.uk', '1976-05-29');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (55, 'Randy Hawkins', 'f9afqlj@eopzh.com', '1981-02-25');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (56, 'Georgie Neville', '6biuikn@prajd.co.uk', '1984-04-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (57, 'Harriot Lee', 'u0v3w@wdmfv.de', '1981-11-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (58, 'Vivi Quigley', 'qulw9wf6d@haksv.de', '1975-07-10');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (59, 'Luise Kelsey', 'oupa2ggps@sgibi.nl', '2006-11-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (60, 'Inessa Parker', '517h8fz@qwurg.de', '1998-09-07');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (61, 'Esmaria Strange', 'zqria@ewckk.co.uk', '2017-05-30');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (62, 'Henrietta Rider', '0cfz1de@cxgfp.net', '1988-03-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (63, 'Mareah Brewster', 'pe1qqm3f@pmmyb.co.uk', '1994-05-11');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (64, 'Willetta Cantrell', 'cgda2p0e2b@jennp.net', '2015-03-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (65, 'Rhianon Alger', 'qpdkc@poluf.de', '1972-06-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (66, 'Gloriana Haywood', '1gy831l0@kysah.com', '2004-04-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (67, 'Nadean Albinson', 'r3yi@gizlk.nl', '1988-12-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (68, 'Bobina Durand', 'oyrkox9ys2@vfuvv.co.uk', '1980-12-19');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (69, 'Wally Comstock', 't0dsslhl0@bcbrh.co.uk', '2017-04-29');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (70, 'Jeanine Bush', 'pv36ug3ws@gvwvu.co.uk', '1978-11-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (71, 'Clarie Hooper', 'iq2i1f0o@lcnts.co.uk', '1982-03-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (72, 'Amie Adkins', 'ptup9j0@eyfwu.com', '2001-07-07');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (73, 'Minna Caulfield', '8a5c2v@rjtkw.net', '2020-06-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (74, 'Nikkie Lewin', 'k2wjfw2f@odvbr.com', '2017-03-10');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (75, 'Tansy Snider', 'jzu911d@kiwzv.de', '2014-09-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (76, 'Christine Henry', 'oim2justt@qbtwb.net', '2008-01-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (77, 'Monah Statham', 'iykr@pkxst.de', '1975-03-13');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (78, 'Margareta Sniders', '8xsnxtg6b@rxuvr.nl', '1978-03-23');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (79, 'Carrie Wells', '0gvy8v6a1@nrnlb.de', '1982-09-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (80, 'Roby Rush', 'i4i0dasb@xdopd.co.uk', '1986-09-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (81, 'Lila Maynard', 'uha9v0b@udyeg.de', '1991-05-13');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (82, 'Kaleena Fletcher', 'lngwuk0@qgrjj.com', '1976-02-18');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (83, 'Zonda Alexander', 'i32g1@gjiuk.nl', '2005-01-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (84, 'Karly Scarlett', 'j50r0mk8@jdjan.de', '1988-12-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (85, 'Fran Horne', 'h7r472c8@mceig.de', '1972-03-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (86, 'Liza Sandford', 'd127@idcbs.net', '2019-03-23');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (87, 'Reiko Jerome', 'axmzv44@qevyl.net', '2020-05-05');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (88, 'Katha Irvine', 'kxzdou@qniqb.co.uk', '1993-11-12');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (89, 'Lillian Rowe', 'jxm211s@idgvi.net', '1975-11-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (90, 'Roseanne Atkinson', '1b61nfbaa@lozzb.nl', '2017-07-29');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (91, 'Sabine Hightower', '5s1jv1@wdmhz.co.uk', '1998-05-31');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (92, 'Cayla Tate', 'as2i@zuaen.com', '2013-07-25');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (93, 'Cecile Robertson', 'rjyip95sb@wucel.nl', '2006-05-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (94, 'Janella Spears', 'uw0214to@eqast.de', '2019-11-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (95, 'Dyana Kersey', '10awz20w1@eitgf.de', '2005-11-15');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (96, 'Karly Walsh', 'apystc3@zbwis.de', '1974-07-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (97, 'Lanni Gladwin', '3jnfl@ysyuk.net', '1982-06-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (98, 'Rhodia Radcliff', 'fr1n@wesoq.nl', '2013-02-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (99, 'Lillian Gladwin', 'zygv2tom2h@iefwk.net', '2000-06-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (100, 'Adda Martel', 'sci0@kzwkz.de', '1984-05-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (101, 'Elisabetta Forrest', 't6ta5f8@wqajz.net', '2003-03-08');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (102, 'Paloma Strudwick', 'hhz0egto@scytg.co.uk', '2016-02-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (103, 'Clo Fay', 'sz8y@dzmyz.de', '1998-11-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (104, 'Rhoda Irwin', 'yyvrcolcf6@ujldn.de', '2018-04-06');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (105, 'Minna Beake', 'zez6815m0@pchfi.de', '1978-06-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (106, 'Margette Dyson', 'jqmam0@mcnzg.nl', '2019-08-08');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (107, 'Van James', 's44f5uabi@wnkve.net', '2013-05-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (108, 'Karyn Wayne', 'exw8ls2sr@kbrvw.de', '2015-05-08');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (109, 'Teresa Beck', '4xuw@fiygs.co.uk', '1984-09-09');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (110, 'Anne Brigham', '52qyvwy6@exlbt.nl', '1973-02-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (111, 'Vinnie Barber', 'xx07cqzv7@fqhzu.de', '1983-08-31');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (112, 'Kizzie Byrd', 'z7jipj@kdsgm.co.uk', '1985-01-09');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (113, 'Tierney Page', 'kkc7@qqmpt.de', '1998-08-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (114, 'Eustacia Dalton', '0a1fuox@iqqrz.de', '1973-11-13');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (115, 'Peria Dean', 'zd44kg6@jlihq.nl', '1976-05-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (116, 'Aveline Aiken', 'uojhrwj0@aozjf.net', '1983-06-30');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (117, 'Marthe Caulfield', '61uyf@epuqv.co.uk', '1998-07-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (118, 'Carina Simmons', 'sys2qj8c@cxgat.net', '2001-05-29');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (119, 'Patrizia Hathaway', '29qb6382ke@hyves.com', '2015-12-02');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (120, 'Gladi Travers', '7neougkwke@vaybc.co.uk', '2009-06-05');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (121, 'Samaria Hull', '668ofok97j@rxxgp.nl', '1988-05-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (122, 'Aveline Jardine', 'l9rpcvo1ig@qnkjk.net', '1976-03-15');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (123, 'Dinny Lincoln', 'wny4vrci0@hohjx.de', '1985-10-05');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (124, 'Gray Warren', '4hjxh5vc9@tesyg.nl', '2007-11-13');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (125, 'Natty Jenkins', '5vpgm7r9r@pjrjn.net', '2010-08-07');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (126, 'Vitia Knight', 'fufji6xfbe@lunaf.net', '2003-06-10');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (127, 'Chrysler Strickland', 'hv18cfu@hzmdt.nl', '2001-08-06');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (128, 'Rosemarie Akerman', 'h40nhs3ex@iacbn.nl', '2014-03-12');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (129, 'Willyt Hopper', 'pf9zwm@rastb.net', '1975-01-31');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (130, 'Carola Merrill', 'mcy8850hzo@nzzfy.de', '1999-09-23');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (131, 'Karlotte Bentley', 'udpcndeen@bicin.com', '2003-03-06');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (132, 'Rennie Hurst', 'sjndtp29re@pvtuk.net', '1970-01-25');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (133, 'Mavra Haden', 'wdenbld@bsoer.com', '2018-08-13');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (134, 'Ruperta Clinton', 't99rr0s@qfdmy.net', '2010-12-09');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (135, 'Marni Cheshire', 'oq9gb3jiz@doghu.co.uk', '2015-03-07');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (136, 'Alexi Tyson', 'jjmrjv@azfgj.com', '1999-06-07');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (137, 'Rosie Simpkin', 'fbh4ipj@twnyk.com', '1994-09-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (138, 'Zola Glover', '8tdu@acdeg.de', '2013-06-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (139, 'Lindsey Hawk', '2mt8dpu56w@fomdg.co.uk', '1973-11-06');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (140, 'Shay Armistead', '8pdryve@ppjrn.net', '2009-12-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (141, 'Lilias Blackburn', 'q1fkoeq@dfrul.net', '2015-08-15');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (142, 'Trude Easton', '7kti3yld@iplrj.de', '1992-07-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (143, 'Krystle Cook', 'rc3i@yxcvq.net', '1989-10-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (144, 'Libbey Baxter', '9rjmq6uk3@nldso.nl', '1999-01-14');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (145, 'Ilyse Woodham', 'mc35qu@uailm.de', '1987-11-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (146, 'Glenn Linton', 'uc50t@qfdyc.nl', '2001-05-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (147, 'Rhetta Thompson', '1r1pbx@wstbp.com', '2021-02-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (148, 'Jena Fay', 'o1qwel@prhmv.co.uk', '2005-04-25');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (149, 'Moyna Ingram', '2dces60s7f@pvqlc.net', '2021-04-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (150, 'Brandice Abram', '242ha9@zdhen.nl', '1995-04-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (151, 'Arline Carman', 'zv8gmv@pebge.net', '1989-06-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (152, 'Eolande Fuller', 'y0sjt@jyzjw.nl', '2020-11-18');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (153, 'Mari Neville', 'ruaz0i@ldxac.net', '2013-05-15');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (154, 'Marj Giles', 'aw09z@qnydz.net', '1991-03-09');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (155, 'Lelia Hailey', '1mahy5@ciwic.nl', '1980-05-19');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (156, 'Babbette Lamar', 'h51460mllc@oqxvr.nl', '1981-06-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (157, 'Noelyn Merritt', '1l2dq@bywoy.nl', '2002-01-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (158, 'Clotilda Terry', 'sslxxg4s@kvcyh.nl', '1982-03-09');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (159, 'Perrine Wayne', '5uwkm4pyj@mnlma.nl', '1999-04-17');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (160, 'Roselle Gilbert', '2qnjy7bt@otsdt.co.uk', '1984-03-19');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (161, 'Sisile Griffin', '3umqp5v@lgjob.net', '2004-09-11');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (162, 'Bonnee Stern', 'hata@rmnxh.net', '1986-09-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (163, 'Estelle Chapman', '6fdj@cpmll.net', '1974-01-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (164, 'Faythe Martel', '833wfgu8tv@wgppo.de', '1979-07-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (165, 'Katti Forest', '084jhkd@jrvgw.net', '2002-04-14');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (166, 'Beverlee Trevis', 'wukqq57ivx@kfqdf.com', '2019-08-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (167, 'Lulu Jardine', 'mwucw3f@vhhni.com', '1977-12-31');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (168, 'Karena Hunt', '59mmyy@vltro.co.uk', '2014-12-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (169, 'Lenee Deering', 'i4n41ehq@yvfhw.com', '2014-10-30');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (170, 'Isabella Grant', 'wz62t9y6uf@cbgdw.de', '1976-10-19');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (171, 'Denice Brown', 'k8eat5a@fbjbs.co.uk', '2019-05-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (172, 'Cori Darby', 'mlv6b42@xaaua.com', '1981-04-03');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (173, 'Malva Adamson', '572fby@wqnhz.net', '2019-09-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (174, 'Karen Griffin', 'fruuqgf@mleri.co.uk', '1986-01-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (175, 'Faun Aiken', 'ae33j6d594@dwnqf.de', '1987-11-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (176, 'Becki Witherspoon', 'pzqnaw@elkvg.de', '1985-07-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (177, 'Gavra Church', 'up7cil54qk@ayfeq.com', '1976-06-08');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (178, 'Cheri Janson', 'wf30nfxcco@yjuht.co.uk', '2009-03-22');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (179, 'Xaviera Ridley', '659czi@fbsqy.nl', '2019-08-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (180, 'Beverie Piper', 'vq7d2p@gmehx.nl', '1976-06-04');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (181, 'Mellisent Arnold', 'n3cfbds9@agsnq.net', '2007-04-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (182, 'Tani Peters', 'x9n2edr@hysxp.co.uk', '1983-01-23');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (183, 'Chrystel Adam', 'uylej@yitde.nl', '1995-10-31');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (184, 'Illa Spalding', 'p79azd7g@ovmfa.nl', '1977-11-21');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (185, 'Phyllys Comstock', 'ahxqnc@lfiqw.co.uk', '1982-02-10');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (186, 'Paule Ford', 'hsuxq71@mucsd.net', '2006-01-18');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (187, 'Charlean Geary', 'tn2fdi@lustr.co.uk', '1988-01-26');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (188, 'Orella Appleton', 'ij07@vyaqa.nl', '1986-06-07');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (189, 'Emilee Spears', 'v1ach951v@kdwtl.com', '2016-05-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (190, 'Arlene Hawking', 'uddbf4w@hifet.net', '1984-10-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (191, 'Hatti Hicks', 'uv6pqg@nnror.net', '1986-11-24');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (192, 'Fania Fry', 'z1bnhsnsp@pzpuz.de', '1971-12-30');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (193, 'Tobye Williams', 'c5z4a3ug5@dpepf.com', '1999-10-20');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (194, 'Maryl Hallman', 'y36t@ongcf.com', '2008-09-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (195, 'Hali Bullock', 'r9clc0@cmqnx.net', '1984-01-27');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (196, 'Lyndsie Braddock', 'n6ji8svs@hoyxn.de', '1973-12-10');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (197, 'Kathye Darrell', 's5fphcltd@rgfme.nl', '1990-05-16');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (198, 'Bellanca Darrell', '0rji@lpbgj.co.uk', '1971-11-01');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (199, 'Etti Herbert', 'xu8n@ymcdc.co.uk', '1974-11-28');
INSERT INTO public.customer (id, name, email, birth_date) OVERRIDING SYSTEM VALUE
VALUES (200, 'Galina Spurling', 'mflfa5rrb4@jrnzs.net', '1998-02-07');

ALTER SEQUENCE public.customer_id_seq RESTART WITH 201;

INSERT INTO public.ticket_type (name, multiplier, id) OVERRIDING SYSTEM VALUE
VALUES ('First Class', 3, 1);
INSERT INTO public.ticket_type (name, multiplier, id) OVERRIDING SYSTEM VALUE
VALUES ('Business Class', 2, 2);
INSERT INTO public.ticket_type (name, multiplier, id) OVERRIDING SYSTEM VALUE
VALUES ('Economy Class', 1, 3);

ALTER SEQUENCE public.ticket_type_id_seq RESTART WITH 4;

INSERT INTO public.ticket_option (name, price, id) OVERRIDING SYSTEM VALUE
VALUES ('Extra leg room', 50, 1);
INSERT INTO public.ticket_option (name, price, id) OVERRIDING SYSTEM VALUE
VALUES ('Dinner', 25, 2);
INSERT INTO public.ticket_option (name, price, id) OVERRIDING SYSTEM VALUE
VALUES ('More luggage', 12, 3);

ALTER SEQUENCE public.ticket_option_id_seq RESTART WITH 4;

INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Johannesburg', 'Lanseria Airport', 1);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Figari', 'Sud Corse Airport', 2);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Villa General Roca', 'San Luis Airport', 3);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Penticton', 'Penticton Airport', 4);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Dayong', 'Dayong', 5);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Ilorin', 'Ilorin Airport', 6);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Tulsa', 'Tulsa International Airport', 7);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kasane', 'Kasane Airport', 8);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Woodruff', 'Lakelan-Noble F. Lee Memerial Field Airport', 9);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Avarua', 'Rarotonga International Airport', 10);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Un', 'Surat Airport', 11);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Nelson House', 'Cross Lake Airport', 12);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Jackson', 'Julian Carroll Airport', 13);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Salvador', 'Marechal Cunha Machado International Airport', 14);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Nuuk', 'Godthaab Airport', 15);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Nagygoricza', 'Zagreb Airport', 16);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Pocatello', 'Pocatello Municipal Airport', 17);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Nicoya', 'Playa Samara Airport', 18);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Gladstone', 'Gladstone Airport', 19);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Raba', 'Mohammad Salahuddin Airport', 20);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Victoria', 'Seychelles International Airport', 21);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Darwin', 'Elcho Island Airport', 22);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Wyoming', 'Wyoming Rail Station', 23);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Breña Alta', 'Santa Cruz de la Palma Airport', 24);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Jammu Cantt', 'Jammu Airport', 25);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Buckland', 'Buckland Airport', 26);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Heho', 'Heho Airport', 27);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Iqaluit', 'Hall Beach Airport', 28);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Missoula', 'Missoula International Airport', 29);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Trat', 'Mueang Trat', 30);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Birdsville', 'Birdsville Airport', 31);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Phra Phrom', 'Nakhon Si Thammarat Airport', 32);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Frankfurt', 'Frankfurt International Airport', 33);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Lakeba', 'Lakemba Island', 34);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kita Kyushu', 'New Kitakyushu Airport', 35);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kirkwall', 'Kirkwall Airport', 36);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kaltag', 'Kaltag', 37);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Bursa', 'Bursa Airport', 38);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('St-Pierre', 'Boos Airport', 39);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Lyoksele', 'Lycksele Airport', 40);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Aspen', 'Aspen Pitkin County Airport-Sardy Field', 41);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('St. Johns', 'St Johns International Airport', 42);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Spring Point', 'Spring Point Airport', 43);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Boscobel', 'Boscobel Airport', 44);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Marathon', 'Webequie Airport', 45);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Lanzhou', 'Lanzhou Airport', 46);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Geraldton', 'Geraldton Airport', 47);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Toronto', 'Toronto Downtown Airport', 48);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Chisasibi', 'Aupaluk Airport', 49);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Allahabad', 'Bamrauli Airport', 50);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Lar', 'Lar', 51);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Gemena', 'Gemena Airport', 52);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Alexandria', 'Alexandria', 53);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Iqaluit', 'Pangnirtung Airport', 54);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Oro-Medonte', 'Ontario', 55);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Haines', 'Haines Airport', 56);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Leksand', 'Leksand Rail Station', 57);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Allentown', 'Lehigh Valley International Airport', 58);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Nosara', 'Nosara Beach Airport', 59);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Stockton', 'Stockton Metropolitan Airport', 60);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Oak Harbor', 'Oak Harbor Airpark', 61);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Mananara', 'Mananara', 62);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Ouargla', 'Ain Beida', 63);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Buenavista', 'Butuan Airport', 64);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Athens', 'Eleftherios Venizelos International Airport', 65);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Hovdebygda', 'Hovden Airport', 66);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Tainan City', 'Tainan Airport', 67);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Caxias do Sul', 'Campo dos Bugres Airport', 68);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Fossano', 'Levaldigi Airport', 69);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kagau', 'Kagau', 70);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Tours', 'Centre', 71);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Friday Harbor', 'Roche Harbor Airport', 72);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kendari', 'Wolter Monginsidi Airport', 73);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Gorontalo', 'Jalaluddin Airport', 74);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Phalaborwa', 'Hoedspruit Afs Airport', 75);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Juillan', 'Ossun Airport', 76);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Cicia', 'Cicia Airport', 77);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Krabi', 'Thailand', 78);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Masset', 'Sandspit Airport', 79);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Larantuka', 'Larantuka', 80);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Setif', 'Setif', 81);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Ejido', 'Alberto Carnevalli Airport', 82);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Flores Island', 'Flores Airport', 83);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Jayapura', 'Sentani Airport', 84);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Isle Of Colonsay', 'Isle Of Colonsay', 85);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Mandalay', 'Mandalay Airport', 86);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Trelew', 'Trelew Almirante Zar Airport', 87);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Havre-St-Pierre', 'Harrington Harbour Airport', 88);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Madeira', 'Funchal Airport', 89);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Gambang', 'Kuantan Airport', 90);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Blessington', 'Launceston Airport', 91);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Basel Mulhouse Freiburg', 'Bale Mulhouse Airport', 92);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Aurangabad', 'Aurangabad Airport', 93);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Miyako Jima', 'Miyako Airport', 94);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Bodrum', 'Milas Airport', 95);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Gatokae', 'Solomon Islands', 96);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Catarman', 'Catarman Airport', 97);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('George', 'P W Botha Airport', 98);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Chefornak', 'Chefornak Airport', 99);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Namibe', 'Namibe', 100);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Golmud', 'Golmud Airport', 101);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Swansea', 'Swansea Airport', 102);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Toamasina', 'Toamasina Airport', 103);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Coteau', 'Coteau Rail Station', 104);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Wick', 'Wick Airport', 105);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Alotau', 'Gurney Airport', 106);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Cauayan', 'Cauayan Airport', 107);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Arequipa', 'Rodriguez Ballon Airport', 108);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Mildura', 'Mildura Airport', 109);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Madrid', 'Barajas Airport', 110);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kangerlussuaq', 'Kangerlussuaq', 111);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Broken Hill', 'Broken Hill Airport', 112);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Arctic Village', 'Arctic Village Airport', 113);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Muskegon', 'Muskegon County Airport', 114);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Devils Lake', 'Devils Lake Municipal Airport', 115);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Brooks Lodge', 'Brooks Lodge', 116);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Levelock', 'Levelock', 117);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Zhezqazghan', 'Dzhezkazgan South Airport', 118);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Bangor', 'Bangor International Airport', 119);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Jaipur', 'Sanganer Airport', 120);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Hengchun', 'Hengchun Airport', 121);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Ducos', 'Le Lamentin Airport', 122);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Durack', 'Kununurra Airport', 123);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Mana Island', 'Mana Island Airstrip', 124);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Brownvale', 'High Level Airport', 125);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Anguilla', 'Wallblake Airport', 126);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Mexicali', 'Gen Rodolfo Sanchez T International Airport', 127);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Santa Cruz', 'Viru Viru International Airport', 128);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Wilmington', 'Wilmington Rail', 129);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Fortaleza', 'Pinto Martins International Airport', 130);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Brussels', 'Brussels Midi Railway Station', 131);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Mcallen', 'Miller International Airport', 132);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Pajala', 'Sweden', 133);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Bangui', 'Bangui M Poko Airport', 134);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Hyeres', 'Le Palyvestre Airport', 135);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('NDjamena', 'Ndjamena Airport', 136);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Alexandroupolis', 'Alexandroupolis Airport', 137);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Saint Paul Island', 'Saint Paul Island', 138);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Melbourne', 'Melbourne International Airport', 139);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Rugby', 'Rugby Rail Station', 140);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Alessandro', 'March Air Force Base', 141);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Hayden', 'Yampa Valley Airport', 142);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Carpiquet', 'Carpiquet Airport', 143);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kulusuk', 'Kulusuk Airport', 144);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Charlotte Amalie', 'Cyril E King International Airport', 145);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Tyumen', 'Tyumen Northwest Airport', 146);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Chuathbaluk', 'Chuathbaluk', 147);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Sacheon-Si', 'Sacheon Airport', 148);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Brochet', 'Brochet', 149);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Sand Point', 'Sand Point Airport', 150);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Iraklio', 'Iraklion Airport', 151);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Bejaia', 'Soummam Airport', 152);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Des Moines', 'Des Moines International Airport', 153);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Nelson House', 'Ilford Airport', 154);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Salmon', 'Lemhi County Airport', 155);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Dhilianata', 'Kefallinia Airport', 156);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Thessaloniki', 'Thessaloniki Airport', 157);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Lamerd', 'Lamerd', 158);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Thirsk', 'England', 159);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Hay River', 'Lac la Martre Aerodrome', 160);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kallinge', 'Ronneby Airport', 161);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Brighton', 'Brighton Airport', 162);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Fort Dodge', 'Fort Dodge Regional Airport', 163);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kansk', 'Yelovaya Airport', 164);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Dushanbe', 'Tajikistan', 165);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Vadodara', 'Vadodara Airport', 166);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Toliara', 'Toliara Airport', 167);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Vegreville', 'Lloydminster Airport', 168);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Atyrau', 'Guryev Airport', 169);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kelsey', 'Kelsey Airport', 170);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Funafuti', 'Funafuti International Airport', 171);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Araxá', 'Romeu Zuma Airport', 172);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Circle', 'Circle', 173);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Casselman', 'Casselman Rail Station', 174);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Fletcher', 'Asheville Regional Airport', 175);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Cobourg', 'Cobourg Rail Station', 176);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Balalae', 'Balalae', 177);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Norrkoping', 'Kungsangen Airport', 178);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Marignane', 'Marignane Airport', 179);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Skonseng', 'Rossvoll Airport', 180);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Baton Rouge', 'Baton Rouge Metropolitan Airport', 181);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Grand Rapids', 'Gerald R. Ford International Airport', 182);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Algiers', 'Houari Boumediene Airport', 183);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Kalaban', 'Bamako Senou Airport', 184);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Qarshi', 'Karshi South Airport', 185);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Stephenville', 'Stephenville International Airport', 186);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Aomori-shi', 'Aomori Airport', 187);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Laredo', 'Laredo International Airport', 188);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('San Fernando', 'San Fernando Airport', 189);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Lewistown', 'Lewistown Municipal Airport', 190);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Azmir', 'Gaziemir Airport', 191);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Tipitapa', 'Augusto Cesar Sandino International Airport', 192);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Maseru', 'Maseru Moshoeshoe Airport', 193);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Hua Hin', 'Hua Hin Airport', 194);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Virac', 'Virac Airport', 195);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Thiruvananthapuram', 'Thiruvananthapuram Airport', 196);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Guarulhos', 'Governador Andre Franco Montoro International Ai', 197);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Balimo', 'Balimo', 198);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Bergeforsen', 'Sundsvall Harnosand Airport', 199);
INSERT INTO public.airport (location, name, id) OVERRIDING SYSTEM VALUE
VALUES ('Ouarzazate', 'Ouarzazate Airport', 200);

ALTER SEQUENCE public.airport_id_seq RESTART WITH 201;

INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (1, 143);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (2, 175);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (3, 69);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (4, 56);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (5, 149);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (6, 134);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (7, 150);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (8, 4);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (9, 101);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (10, 47);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (11, 99);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (12, 132);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (13, 161);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (14, 67);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (15, 79);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (16, 31);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (17, 122);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (18, 143);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (19, 32);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (20, 148);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (21, 101);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (22, 151);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (23, 147);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (24, 98);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (25, 170);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (26, 79);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (27, 7);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (28, 76);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (29, 57);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (30, 58);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (31, 132);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (32, 33);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (33, 68);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (34, 176);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (35, 53);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (36, 28);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (37, 103);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (38, 14);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (39, 17);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (40, 75);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (41, 146);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (42, 75);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (43, 108);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (44, 155);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (45, 130);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (46, 26);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (47, 21);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (48, 79);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (49, 140);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (50, 69);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (51, 104);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (52, 31);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (53, 27);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (54, 63);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (55, 60);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (56, 152);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (57, 170);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (58, 103);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (59, 146);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (60, 179);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (61, 13);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (62, 65);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (63, 58);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (64, 58);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (65, 98);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (66, 189);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (67, 101);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (68, 115);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (69, 65);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (70, 102);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (71, 10);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (72, 87);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (73, 124);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (74, 46);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (75, 164);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (76, 108);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (77, 30);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (78, 131);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (79, 116);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (80, 113);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (81, 38);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (82, 100);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (83, 4);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (84, 87);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (85, 121);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (86, 124);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (87, 12);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (88, 116);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (89, 147);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (90, 8);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (91, 94);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (92, 59);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (93, 132);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (94, 123);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (95, 23);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (96, 169);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (97, 200);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (98, 82);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (99, 173);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (100, 98);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (101, 172);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (102, 141);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (103, 176);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (104, 101);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (105, 135);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (106, 8);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (107, 105);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (108, 82);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (109, 126);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (110, 136);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (111, 42);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (112, 189);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (113, 64);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (114, 188);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (115, 196);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (116, 155);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (117, 80);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (118, 105);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (119, 53);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (120, 145);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (121, 165);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (122, 146);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (123, 62);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (124, 138);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (125, 189);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (126, 124);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (127, 102);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (128, 25);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (129, 24);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (130, 130);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (131, 164);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (132, 110);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (133, 100);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (134, 182);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (135, 3);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (136, 162);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (137, 126);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (138, 143);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (139, 192);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (140, 161);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (141, 93);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (142, 31);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (143, 122);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (144, 68);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (145, 26);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (146, 112);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (147, 40);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (148, 173);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (149, 51);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (150, 194);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (151, 78);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (152, 44);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (153, 152);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (154, 176);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (155, 153);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (156, 129);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (157, 90);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (158, 15);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (159, 8);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (160, 42);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (161, 41);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (162, 85);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (163, 98);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (164, 37);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (165, 2);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (166, 109);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (167, 141);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (168, 146);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (169, 37);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (170, 188);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (171, 88);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (172, 42);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (173, 29);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (174, 3);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (175, 197);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (176, 100);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (177, 200);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (178, 190);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (179, 87);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (180, 38);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (181, 89);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (182, 60);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (183, 186);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (184, 143);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (185, 53);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (186, 182);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (187, 196);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (188, 20);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (189, 44);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (190, 107);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (191, 18);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (192, 27);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (193, 110);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (194, 160);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (195, 78);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (196, 54);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (197, 168);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (198, 22);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (199, 39);
INSERT INTO public.booking (id, customer) OVERRIDING SYSTEM VALUE
VALUES (200, 112);

ALTER SEQUENCE public.booking_id_seq RESTART WITH 201;

INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:14:44', '2021-05-26 23:40:34', 115, 1, 167, 147, 97);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:51:21', '2021-05-26 19:11:49', 178, 2, 89, 96, 191);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:29:17', '2021-05-26 19:00:32', 187, 3, 130, 178, 158);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:47:48', '2021-05-26 18:55:14', 99, 4, 32, 12, 104);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:35:38', '2021-05-26 15:59:10', 176, 5, 43, 174, 88);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:40:41', '2021-05-26 23:39:31', 146, 6, 162, 54, 68);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:41:03', '2021-05-26 21:25:54', 133, 7, 98, 117, 64);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:22:13', '2021-05-27 00:56:13', 108, 8, 182, 54, 92);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:59:55', '2021-05-27 02:04:27', 122, 9, 174, 166, 175);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:44:30', '2021-05-27 00:27:25', 133, 10, 5, 105, 157);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:52:24', '2021-05-26 21:25:44', 111, 11, 2, 44, 30);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:53:22', '2021-05-27 01:55:51', 160, 12, 42, 138, 178);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:50:02', '2021-05-26 20:20:42', 99, 13, 102, 133, 148);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:43:10', '2021-05-26 22:32:35', 84, 14, 144, 87, 17);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:06:44', '2021-05-26 23:32:47', 140, 15, 25, 93, 109);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:43:38', '2021-05-26 21:55:21', 85, 16, 98, 58, 35);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:28:24', '2021-05-26 18:08:11', 84, 17, 24, 122, 75);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:04:08', '2021-05-26 17:22:57', 98, 18, 168, 130, 96);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:21:10', '2021-05-27 02:07:26', 100, 19, 117, 1, 44);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:14:22', '2021-05-26 20:44:58', 142, 20, 179, 28, 43);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:21:28', '2021-05-26 18:38:50', 161, 21, 40, 179, 130);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:06:05', '2021-05-26 21:06:08', 177, 22, 146, 148, 36);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:48:58', '2021-05-26 17:05:26', 116, 23, 129, 2, 65);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:17:58', '2021-05-26 21:09:25', 186, 24, 24, 166, 162);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:58:31', '2021-05-27 01:03:25', 153, 25, 79, 18, 133);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:38:52', '2021-05-26 21:23:52', 138, 26, 162, 153, 157);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:25:37', '2021-05-26 21:07:36', 98, 27, 37, 70, 26);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:40:08', '2021-05-26 20:48:39', 147, 28, 65, 48, 9);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:12:48', '2021-05-27 02:32:15', 57, 29, 176, 2, 145);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:20:37', '2021-05-26 18:16:57', 75, 30, 33, 102, 29);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:07:27', '2021-05-26 22:34:42', 138, 31, 77, 151, 66);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:58:47', '2021-05-26 19:15:38', 109, 32, 168, 163, 161);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:15:09', '2021-05-26 23:21:46', 172, 33, 86, 82, 59);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:02:13', '2021-05-26 20:47:15', 53, 34, 74, 171, 146);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:29:58', '2021-05-27 02:22:57', 141, 35, 27, 78, 56);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:26:26', '2021-05-26 16:51:39', 174, 36, 200, 156, 63);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:56:05', '2021-05-27 01:18:21', 68, 37, 58, 188, 81);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:19:16', '2021-05-26 20:39:48', 57, 38, 94, 72, 13);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:04:24', '2021-05-26 16:24:12', 81, 39, 99, 90, 191);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:32:32', '2021-05-26 20:09:44', 176, 40, 114, 49, 130);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:23:42', '2021-05-26 20:30:38', 79, 41, 27, 41, 159);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:10:09', '2021-05-26 18:46:45', 195, 42, 157, 115, 99);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:27:18', '2021-05-27 00:47:46', 99, 43, 89, 177, 185);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:25:49', '2021-05-27 01:14:56', 150, 44, 142, 52, 10);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:12:39', '2021-05-26 17:33:27', 55, 45, 186, 152, 69);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:06:11', '2021-05-26 19:53:26', 117, 46, 111, 180, 96);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:11:16', '2021-05-26 18:47:25', 93, 47, 160, 117, 87);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:04:22', '2021-05-27 01:43:10', 63, 48, 175, 150, 140);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:51:37', '2021-05-26 21:58:57', 180, 49, 63, 9, 178);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:41:13', '2021-05-27 01:50:35', 182, 50, 73, 13, 117);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:13:12', '2021-05-26 22:20:39', 76, 51, 32, 90, 42);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:41:53', '2021-05-26 20:47:05', 101, 52, 200, 105, 48);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:53:32', '2021-05-26 17:18:34', 175, 53, 156, 6, 103);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:49:03', '2021-05-26 19:16:29', 82, 54, 154, 172, 165);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:25:38', '2021-05-26 18:12:47', 152, 55, 118, 196, 67);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:46:14', '2021-05-26 22:24:26', 162, 56, 91, 80, 143);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:17:35', '2021-05-26 23:48:27', 67, 57, 64, 79, 113);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:23:59', '2021-05-26 20:18:46', 94, 58, 123, 197, 80);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:51:02', '2021-05-26 21:07:17', 57, 59, 86, 199, 85);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:46:36', '2021-05-27 01:17:51', 69, 60, 21, 168, 76);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:52:58', '2021-05-26 19:19:03', 70, 61, 35, 153, 14);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:41:12', '2021-05-26 23:07:33', 194, 62, 99, 113, 198);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:56:28', '2021-05-26 22:21:37', 129, 63, 175, 35, 43);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:50:22', '2021-05-27 02:09:30', 173, 64, 192, 86, 138);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:48:38', '2021-05-27 01:47:39', 117, 65, 119, 187, 128);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:36:32', '2021-05-26 19:02:44', 184, 66, 90, 63, 145);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:25:04', '2021-05-27 02:09:46', 178, 67, 197, 122, 161);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:14:49', '2021-05-27 01:12:44', 189, 68, 30, 176, 168);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:31:13', '2021-05-26 18:03:57', 187, 69, 162, 111, 195);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:34:52', '2021-05-26 23:23:28', 51, 70, 111, 158, 134);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:45:41', '2021-05-27 00:27:59', 115, 71, 180, 120, 80);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:19:16', '2021-05-26 23:38:16', 117, 72, 15, 163, 122);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:35:32', '2021-05-27 01:29:55', 160, 73, 127, 59, 127);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:45:47', '2021-05-26 20:33:21', 64, 74, 136, 19, 126);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:24:26', '2021-05-27 01:57:50', 62, 75, 168, 37, 108);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:57:20', '2021-05-26 21:36:51', 162, 76, 128, 159, 22);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:03:07', '2021-05-27 00:12:11', 78, 77, 103, 80, 142);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:32:24', '2021-05-26 22:28:00', 104, 78, 185, 85, 76);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:16:48', '2021-05-27 00:50:30', 51, 79, 164, 89, 197);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:12:00', '2021-05-27 02:43:11', 140, 80, 52, 41, 161);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:14:22', '2021-05-26 20:21:45', 133, 81, 168, 31, 45);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:02:49', '2021-05-27 02:05:34', 193, 82, 171, 71, 67);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:33:55', '2021-05-26 16:54:38', 88, 83, 90, 78, 145);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:54:14', '2021-05-26 22:54:05', 74, 84, 162, 114, 102);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:36:51', '2021-05-26 21:57:34', 164, 85, 35, 57, 102);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:38:19', '2021-05-26 18:00:53', 77, 86, 109, 14, 98);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:44:35', '2021-05-26 19:12:14', 188, 87, 180, 110, 80);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:41:27', '2021-05-26 22:57:17', 51, 88, 185, 161, 200);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:38:33', '2021-05-26 16:42:18', 151, 89, 108, 99, 5);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:17:46', '2021-05-27 00:40:57', 185, 90, 104, 70, 114);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:16:50', '2021-05-26 18:25:37', 59, 91, 194, 138, 176);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:49:17', '2021-05-26 22:48:33', 87, 92, 93, 69, 116);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:43:38', '2021-05-26 20:45:15', 68, 93, 80, 133, 58);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:04:28', '2021-05-27 02:18:10', 92, 94, 146, 154, 167);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:44:34', '2021-05-26 17:33:32', 108, 95, 151, 50, 55);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:49:36', '2021-05-26 22:58:31', 155, 96, 192, 118, 190);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:06:32', '2021-05-26 22:23:20', 103, 97, 117, 122, 115);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:20:17', '2021-05-27 00:46:47', 117, 98, 101, 158, 129);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:58:48', '2021-05-26 18:26:18', 112, 99, 170, 195, 88);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:50:12', '2021-05-27 00:13:16', 197, 100, 145, 136, 152);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:37:31', '2021-05-26 21:53:41', 52, 101, 170, 127, 70);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:51:34', '2021-05-27 00:11:04', 125, 102, 64, 28, 102);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:51:10', '2021-05-26 20:46:44', 130, 103, 100, 133, 36);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:45:30', '2021-05-26 23:54:56', 167, 104, 165, 5, 70);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:21:02', '2021-05-27 00:24:46', 126, 105, 28, 152, 122);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:35:58', '2021-05-26 22:31:53', 115, 106, 51, 50, 21);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:51:59', '2021-05-26 19:10:08', 117, 107, 22, 99, 191);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:53:09', '2021-05-26 21:02:15', 146, 108, 19, 166, 50);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:39:44', '2021-05-26 20:20:25', 58, 109, 191, 170, 155);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:40:16', '2021-05-26 23:15:29', 163, 110, 163, 120, 5);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:53:45', '2021-05-26 18:09:59', 94, 111, 71, 198, 69);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:00:24', '2021-05-26 19:30:35', 93, 112, 200, 80, 92);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:03:28', '2021-05-26 16:12:31', 116, 113, 64, 156, 76);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:04:21', '2021-05-26 23:24:01', 169, 114, 186, 171, 22);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:09:47', '2021-05-26 21:32:25', 148, 115, 57, 105, 183);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:52:07', '2021-05-27 01:22:21', 184, 116, 54, 97, 33);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:55:11', '2021-05-26 19:43:44', 59, 117, 191, 78, 51);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:57:42', '2021-05-27 02:35:55', 113, 118, 39, 3, 69);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:38:23', '2021-05-26 19:48:59', 152, 119, 99, 176, 27);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:37:52', '2021-05-26 21:42:41', 61, 120, 53, 125, 156);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:37:48', '2021-05-26 21:45:07', 152, 121, 160, 33, 149);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:58:31', '2021-05-27 02:28:40', 175, 122, 94, 27, 113);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:18:05', '2021-05-26 21:09:36', 92, 123, 147, 66, 21);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:56:08', '2021-05-27 00:51:01', 56, 124, 3, 155, 118);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:22:02', '2021-05-26 22:57:21', 183, 125, 86, 101, 174);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:55:31', '2021-05-26 20:28:58', 144, 126, 41, 200, 71);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:41:16', '2021-05-27 02:36:51', 104, 127, 120, 57, 61);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:49:02', '2021-05-27 01:10:18', 122, 128, 133, 76, 190);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:37:31', '2021-05-26 21:09:20', 87, 129, 57, 117, 115);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:55:54', '2021-05-26 20:57:40', 161, 130, 19, 182, 168);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:22:16', '2021-05-26 18:32:02', 138, 131, 57, 94, 177);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:34:48', '2021-05-27 02:30:16', 143, 132, 15, 54, 189);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:02:02', '2021-05-26 22:56:56', 149, 133, 12, 102, 2);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:29:27', '2021-05-26 20:45:03', 137, 134, 138, 96, 64);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:04:29', '2021-05-26 21:24:14', 150, 135, 115, 162, 151);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:59:40', '2021-05-27 01:34:03', 91, 136, 99, 56, 149);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:50:38', '2021-05-27 02:40:05', 88, 137, 118, 169, 113);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:18:12', '2021-05-26 17:05:28', 130, 138, 76, 2, 190);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:15:26', '2021-05-26 20:31:12', 155, 139, 141, 62, 5);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:36:13', '2021-05-26 22:59:02', 101, 140, 37, 45, 106);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:04:56', '2021-05-26 23:32:55', 186, 141, 108, 28, 161);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:42:22', '2021-05-26 17:44:00', 157, 142, 129, 159, 101);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:28:09', '2021-05-27 01:32:10', 141, 143, 119, 189, 182);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:05:41', '2021-05-27 00:37:35', 74, 144, 67, 128, 155);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:35:36', '2021-05-26 21:27:38', 153, 145, 130, 16, 44);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:56:44', '2021-05-26 16:49:10', 193, 146, 179, 53, 30);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:56:53', '2021-05-27 02:33:30', 172, 147, 61, 179, 13);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:58:58', '2021-05-27 00:39:26', 174, 148, 99, 48, 27);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:44:22', '2021-05-26 23:47:04', 102, 149, 94, 128, 42);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:15:10', '2021-05-27 00:57:33', 184, 150, 99, 125, 192);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:55:32', '2021-05-26 21:13:39', 170, 151, 49, 111, 137);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:33:51', '2021-05-26 19:07:30', 188, 152, 38, 75, 77);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:53:08', '2021-05-26 18:11:13', 136, 153, 17, 152, 97);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:00:16', '2021-05-26 17:58:32', 118, 154, 115, 119, 105);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:21:12', '2021-05-26 20:52:25', 144, 155, 195, 164, 47);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:19:00', '2021-05-26 18:34:52', 55, 156, 76, 17, 157);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:57:55', '2021-05-26 18:58:53', 102, 157, 15, 115, 193);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:37:59', '2021-05-26 16:38:42', 184, 158, 130, 139, 156);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:21:54', '2021-05-27 01:41:01', 95, 159, 64, 165, 158);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:13:02', '2021-05-26 17:27:56', 192, 160, 64, 35, 119);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:35:20', '2021-05-26 21:52:28', 82, 161, 142, 39, 188);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:53:13', '2021-05-26 20:14:43', 141, 162, 88, 199, 29);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:21:54', '2021-05-26 23:40:49', 148, 163, 197, 115, 183);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:09:17', '2021-05-26 21:16:33', 178, 164, 96, 101, 130);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:07:42', '2021-05-26 20:33:53', 200, 165, 117, 81, 46);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:03:17', '2021-05-27 00:40:51', 171, 166, 91, 181, 47);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:10:33', '2021-05-26 23:09:26', 164, 167, 62, 120, 195);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:20:04', '2021-05-26 16:43:20', 51, 168, 87, 105, 173);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:34:04', '2021-05-26 20:42:31', 126, 169, 72, 144, 90);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:28:25', '2021-05-26 19:09:12', 115, 170, 26, 77, 141);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:12:19', '2021-05-26 23:21:47', 55, 171, 126, 88, 93);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:37:56', '2021-05-26 21:13:08', 118, 172, 71, 62, 36);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:33:06', '2021-05-26 20:22:22', 109, 173, 18, 114, 122);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:29:40', '2021-05-26 21:19:16', 150, 174, 70, 148, 88);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:39:46', '2021-05-27 02:25:23', 79, 175, 58, 170, 137);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 14:52:38', '2021-05-26 19:29:20', 165, 176, 119, 108, 158);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:07:55', '2021-05-26 20:18:00', 55, 177, 168, 38, 30);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:18:52', '2021-05-26 17:17:47', 130, 178, 45, 4, 7);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:39:17', '2021-05-27 01:50:22', 124, 179, 197, 179, 9);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:07:57', '2021-05-26 16:09:14', 175, 180, 56, 83, 76);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:04:09', '2021-05-26 22:12:20', 54, 181, 82, 107, 167);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:16:24', '2021-05-26 19:35:56', 115, 182, 31, 179, 43);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:24:02', '2021-05-27 02:28:32', 181, 183, 186, 16, 174);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:42:32', '2021-05-26 19:10:29', 81, 184, 48, 144, 110);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:15:27', '2021-05-26 20:43:17', 99, 185, 156, 106, 172);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:52:28', '2021-05-26 22:41:24', 55, 186, 6, 162, 157);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:42:37', '2021-05-26 22:04:58', 123, 187, 147, 24, 27);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:35:27', '2021-05-26 23:24:50', 188, 188, 140, 109, 52);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:11:57', '2021-05-27 02:45:38', 197, 189, 88, 3, 77);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 15:18:02', '2021-05-26 22:56:54', 111, 190, 180, 59, 44);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:11:14', '2021-05-26 18:37:35', 191, 191, 15, 4, 17);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:06:59', '2021-05-26 17:27:01', 141, 192, 67, 112, 59);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 18:21:37', '2021-05-26 18:26:07', 179, 193, 60, 49, 19);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:16:34', '2021-05-26 21:21:01', 157, 194, 166, 4, 75);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:05:56', '2021-05-26 19:26:37', 103, 195, 56, 128, 15);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:09:15', '2021-05-26 22:14:44', 141, 196, 122, 63, 91);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 17:25:15', '2021-05-26 22:13:15', 97, 197, 193, 92, 146);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:22:08', '2021-05-26 20:55:08', 83, 198, 163, 179, 116);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 16:15:59', '2021-05-27 01:47:05', 99, 199, 33, 86, 4);
INSERT INTO public.flight (departure_datetime, arrival_datetime, price, id, plane, arrival_airport,
                           departure_airport) OVERRIDING SYSTEM VALUE
VALUES ('2021-05-26 19:11:16', '2021-05-26 22:11:40', 55, 200, 75, 193, 191);

ALTER SEQUENCE public.flight_id_seq RESTART WITH 201;

INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (1, '72L', 187, 2, 194, 25, 70);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (2, '82X', 67, 3, 26, 46, 65);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (3, '76R', 186, 3, 61, 39, 7);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (4, '69Y', 148, 2, 19, 134, 54);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (5, '60Q', 118, 1, 181, 44, 173);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (6, '42P', 81, 3, 168, 101, 97);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (7, '32J', 159, 1, 84, 81, 157);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (8, '60Z', 124, 3, 123, 76, 199);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (9, '84C', 156, 1, 68, 141, 16);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (10, '39M', 122, 3, 94, 174, 110);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (11, '79V', 189, 1, 130, 81, 40);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (12, '54V', 152, 1, 119, 66, 79);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (13, '03W', 78, 1, 180, 136, 143);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (14, '100Z', 193, 2, 112, 73, 165);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (15, '71A', 171, 2, 6, 119, 69);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (16, '03J', 129, 1, 18, 162, 51);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (17, '36M', 155, 1, 104, 64, 90);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (18, '07I', 78, 1, 64, 66, 108);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (19, '29W', 100, 1, 70, 8, 145);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (20, '64T', 196, 3, 83, 78, 126);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (21, '63V', 166, 1, 141, 2, 156);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (22, '65B', 94, 2, 1, 165, 92);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (23, '80F', 163, 1, 195, 179, 116);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (24, '57J', 50, 3, 65, 31, 24);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (25, '43G', 196, 2, 188, 67, 97);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (26, '48D', 166, 1, 160, 36, 190);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (27, '82Q', 65, 3, 16, 21, 175);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (28, '74L', 71, 3, 195, 172, 55);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (29, '29E', 194, 3, 136, 138, 78);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (30, '81S', 93, 1, 9, 75, 147);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (31, '15G', 196, 3, 3, 156, 115);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (32, '41A', 88, 1, 176, 113, 101);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (33, '76H', 131, 3, 14, 109, 107);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (34, '23S', 168, 1, 153, 27, 104);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (35, '47M', 182, 2, 143, 140, 33);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (36, '33T', 52, 1, 110, 86, 99);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (37, '86O', 131, 3, 190, 56, 168);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (38, '10Z', 98, 3, 171, 120, 68);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (39, '67R', 107, 1, 104, 175, 15);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (40, '79X', 143, 2, 34, 187, 172);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (41, '09H', 71, 2, 191, 81, 159);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (42, '86V', 130, 1, 80, 38, 72);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (43, '40F', 81, 1, 139, 30, 125);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (44, '74Y', 82, 1, 19, 127, 153);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (45, '97I', 112, 1, 51, 162, 157);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (46, '52P', 154, 2, 167, 45, 125);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (47, '81P', 81, 2, 72, 107, 175);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (48, '95J', 113, 1, 43, 51, 79);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (49, '22X', 69, 1, 12, 72, 190);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (50, '67N', 181, 3, 186, 122, 92);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (51, '42D', 125, 3, 56, 34, 162);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (52, '68M', 140, 1, 27, 150, 43);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (53, '54B', 181, 1, 116, 102, 196);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (54, '16T', 150, 3, 8, 125, 110);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (55, '60R', 181, 1, 67, 81, 36);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (56, '100T', 69, 3, 28, 37, 11);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (57, '78E', 64, 1, 187, 110, 114);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (58, '73U', 176, 1, 84, 33, 16);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (59, '80V', 164, 2, 185, 102, 104);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (60, '57X', 137, 2, 173, 158, 144);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (61, '76W', 154, 3, 42, 129, 74);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (62, '22Z', 76, 2, 121, 66, 194);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (63, '23M', 125, 1, 123, 78, 66);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (64, '05G', 131, 3, 96, 75, 91);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (65, '69P', 55, 1, 62, 148, 93);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (66, '04N', 112, 3, 172, 12, 177);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (67, '80R', 183, 1, 67, 163, 17);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (68, '15O', 79, 1, 181, 17, 140);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (69, '40Y', 76, 3, 90, 4, 183);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (70, '72Q', 128, 3, 184, 126, 120);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (71, '25A', 129, 3, 150, 45, 43);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (72, '29Y', 127, 1, 31, 75, 69);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (73, '02W', 145, 1, 92, 121, 147);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (74, '48Z', 196, 3, 24, 182, 82);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (75, '91N', 159, 1, 172, 26, 107);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (76, '37Y', 160, 3, 12, 76, 49);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (77, '66C', 171, 1, 181, 34, 107);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (78, '52V', 136, 3, 90, 193, 55);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (79, '29A', 56, 3, 171, 54, 75);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (80, '20V', 191, 1, 29, 143, 115);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (81, '11H', 199, 3, 160, 13, 28);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (82, '18U', 53, 2, 97, 136, 85);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (83, '04K', 112, 1, 98, 121, 85);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (84, '55O', 179, 1, 55, 113, 152);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (85, '80M', 187, 2, 36, 188, 179);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (86, '45M', 152, 2, 23, 179, 172);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (87, '95U', 53, 3, 154, 1, 32);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (88, '42R', 142, 3, 150, 188, 125);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (89, '48T', 65, 1, 150, 110, 85);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (90, '46R', 148, 1, 30, 20, 140);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (91, '20T', 132, 3, 87, 121, 30);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (92, '43S', 175, 3, 123, 44, 99);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (93, '90K', 169, 3, 63, 143, 15);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (94, '03Q', 164, 3, 198, 165, 170);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (95, '87J', 148, 3, 133, 60, 41);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (96, '17G', 133, 3, 23, 19, 93);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (97, '87Y', 151, 3, 48, 70, 120);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (98, '63Z', 98, 3, 199, 174, 30);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (99, '45I', 168, 3, 157, 168, 191);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (100, '28R', 84, 1, 146, 135, 6);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (101, '93T', 185, 2, 32, 133, 164);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (102, '48V', 96, 1, 112, 119, 146);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (103, '17D', 160, 2, 160, 24, 40);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (104, '90H', 63, 1, 28, 70, 131);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (105, '58V', 76, 2, 44, 14, 89);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (106, '11W', 182, 3, 149, 54, 56);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (107, '49E', 65, 1, 191, 30, 198);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (108, '14U', 101, 1, 45, 126, 22);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (109, '20I', 186, 1, 45, 120, 153);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (110, '81F', 85, 1, 58, 187, 144);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (111, '42S', 61, 1, 184, 117, 178);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (112, '51Z', 66, 2, 122, 106, 165);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (113, '34E', 151, 3, 91, 58, 59);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (114, '38W', 59, 2, 7, 123, 122);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (115, '91Z', 149, 3, 12, 108, 169);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (116, '86K', 71, 3, 115, 13, 123);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (117, '58R', 90, 2, 71, 65, 80);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (118, '52W', 197, 3, 82, 161, 170);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (119, '10I', 60, 1, 183, 189, 80);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (120, '54L', 59, 2, 186, 129, 184);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (121, '51F', 115, 3, 94, 149, 191);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (122, '100G', 79, 1, 51, 147, 76);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (123, '93L', 183, 3, 171, 77, 33);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (124, '70T', 96, 2, 153, 146, 131);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (125, '21C', 52, 1, 160, 55, 171);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (126, '81T', 137, 3, 190, 199, 101);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (127, '97S', 110, 3, 160, 73, 21);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (128, '39L', 139, 3, 52, 24, 125);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (129, '78B', 62, 3, 15, 89, 65);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (130, '21N', 79, 1, 183, 63, 26);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (131, '58M', 133, 1, 97, 127, 68);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (132, '06W', 177, 1, 196, 51, 161);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (133, '27Y', 132, 1, 39, 176, 148);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (134, '75B', 100, 3, 143, 39, 80);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (135, '47P', 100, 2, 164, 191, 172);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (136, '07V', 126, 1, 11, 60, 27);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (137, '07L', 128, 3, 92, 125, 187);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (138, '74I', 119, 3, 175, 178, 109);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (139, '62J', 171, 2, 179, 148, 189);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (140, '18G', 162, 1, 16, 79, 52);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (141, '98S', 169, 1, 4, 130, 135);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (142, '89W', 86, 1, 51, 131, 127);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (143, '88J', 68, 2, 197, 129, 83);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (144, '74R', 51, 3, 89, 144, 32);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (145, '02C', 186, 3, 83, 13, 184);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (146, '46M', 52, 1, 5, 14, 120);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (147, '73P', 108, 3, 161, 106, 31);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (148, '81P', 170, 2, 171, 38, 200);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (149, '68G', 53, 1, 93, 87, 131);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (150, '11B', 177, 2, 48, 162, 115);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (151, '57X', 109, 1, 85, 9, 75);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (152, '92T', 200, 1, 149, 150, 14);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (153, '01Y', 109, 2, 17, 166, 2);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (154, '11X', 166, 2, 11, 77, 50);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (155, '38W', 143, 3, 190, 88, 170);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (156, '41S', 73, 1, 55, 146, 170);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (157, '09S', 196, 2, 47, 100, 108);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (158, '71O', 68, 3, 134, 52, 99);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (159, '77V', 108, 3, 54, 20, 200);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (160, '04K', 139, 2, 60, 75, 134);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (161, '61J', 73, 2, 83, 25, 197);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (162, '87G', 90, 1, 135, 29, 142);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (163, '93I', 98, 2, 72, 194, 200);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (164, '61Y', 69, 1, 90, 191, 34);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (165, '01G', 184, 1, 54, 78, 51);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (166, '20D', 170, 3, 170, 35, 18);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (167, '57H', 165, 3, 107, 114, 159);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (168, '49Q', 111, 2, 133, 157, 128);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (169, '04K', 159, 3, 68, 93, 18);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (170, '88Y', 156, 2, 88, 80, 121);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (171, '81T', 56, 3, 66, 161, 65);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (172, '99G', 84, 3, 78, 2, 67);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (173, '72V', 105, 2, 115, 171, 174);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (174, '21V', 82, 3, 103, 7, 106);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (175, '45U', 177, 3, 102, 17, 146);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (176, '26K', 165, 3, 59, 78, 107);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (177, '36A', 80, 1, 199, 11, 69);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (178, '27G', 66, 3, 55, 119, 47);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (179, '35I', 78, 3, 12, 9, 18);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (180, '15X', 67, 2, 193, 5, 142);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (181, '98T', 67, 3, 159, 106, 147);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (182, '58K', 74, 1, 92, 89, 33);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (183, '46A', 163, 1, 72, 18, 192);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (184, '21A', 51, 3, 27, 46, 65);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (185, '11W', 57, 3, 179, 76, 164);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (186, '67B', 73, 3, 115, 19, 148);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (187, '55M', 196, 2, 117, 170, 99);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (188, '84N', 149, 3, 59, 3, 131);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (189, '58U', 55, 2, 157, 138, 9);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (190, '92I', 121, 2, 157, 85, 177);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (191, '45W', 121, 1, 179, 60, 6);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (192, '18D', 199, 2, 179, 138, 79);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (193, '62W', 57, 1, 36, 116, 67);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (194, '11U', 104, 1, 181, 182, 133);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (195, '44I', 144, 2, 34, 85, 149);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (196, '27V', 144, 1, 3, 192, 138);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (197, '36W', 187, 3, 95, 175, 119);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (198, '04Y', 121, 1, 85, 163, 43);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (199, '22M', 193, 1, 144, 101, 119);
INSERT INTO public.ticket (id, seat_number, price, ticket_type, booking, customer, flight) OVERRIDING SYSTEM VALUE
VALUES (200, '14J', 98, 3, 98, 47, 12);

ALTER SEQUENCE public.ticket_id_seq RESTART WITH 201;

INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (1, 1, 1);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (2, 1, 2);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (3, 3, 3);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (4, 1, 4);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (5, 1, 5);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (6, 1, 6);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (7, 2, 7);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (8, 1, 8);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (9, 3, 9);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (10, 1, 10);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (11, 2, 11);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (12, 3, 12);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (13, 2, 13);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (14, 1, 14);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (15, 3, 15);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (16, 3, 16);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (17, 3, 17);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (18, 2, 18);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (19, 2, 19);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (20, 2, 20);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (21, 2, 21);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (22, 2, 22);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (23, 1, 23);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (24, 1, 24);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (25, 3, 25);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (26, 2, 26);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (27, 1, 27);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (28, 2, 28);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (29, 3, 29);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (30, 3, 30);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (31, 2, 31);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (32, 3, 32);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (33, 3, 33);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (34, 1, 34);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (35, 1, 35);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (36, 1, 36);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (37, 1, 37);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (38, 1, 38);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (39, 3, 39);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (40, 3, 40);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (41, 1, 41);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (42, 1, 42);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (43, 2, 43);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (44, 2, 44);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (45, 2, 45);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (46, 2, 46);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (47, 2, 47);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (48, 2, 48);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (49, 2, 49);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (50, 3, 50);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (51, 3, 51);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (52, 1, 52);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (53, 3, 53);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (54, 3, 54);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (55, 1, 55);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (56, 3, 56);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (57, 3, 57);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (58, 1, 58);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (59, 3, 59);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (60, 2, 60);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (61, 2, 61);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (62, 1, 62);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (63, 3, 63);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (64, 2, 64);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (65, 3, 65);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (66, 2, 66);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (67, 2, 67);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (68, 2, 68);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (69, 3, 69);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (70, 3, 70);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (71, 2, 71);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (72, 2, 72);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (73, 3, 73);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (74, 1, 74);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (75, 1, 75);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (76, 3, 76);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (77, 3, 77);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (78, 3, 78);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (79, 2, 79);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (80, 1, 80);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (81, 3, 81);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (82, 2, 82);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (83, 1, 83);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (84, 3, 84);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (85, 1, 85);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (86, 2, 86);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (87, 3, 87);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (88, 1, 88);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (89, 2, 89);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (90, 3, 90);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (91, 3, 91);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (92, 3, 92);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (93, 1, 93);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (94, 1, 94);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (95, 1, 95);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (96, 3, 96);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (97, 1, 97);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (98, 1, 98);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (99, 1, 99);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (100, 3, 100);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (101, 2, 101);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (102, 1, 102);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (103, 1, 103);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (104, 3, 104);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (105, 2, 105);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (106, 1, 106);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (107, 1, 107);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (108, 2, 108);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (109, 3, 109);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (110, 1, 110);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (111, 1, 111);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (112, 3, 112);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (113, 1, 113);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (114, 2, 114);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (115, 2, 115);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (116, 2, 116);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (117, 3, 117);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (118, 1, 118);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (119, 3, 119);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (120, 2, 120);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (121, 2, 121);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (122, 3, 122);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (123, 1, 123);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (124, 2, 124);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (125, 3, 125);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (126, 1, 126);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (127, 2, 127);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (128, 1, 128);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (129, 2, 129);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (130, 1, 130);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (131, 2, 131);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (132, 3, 132);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (133, 3, 133);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (134, 1, 134);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (135, 1, 135);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (136, 3, 136);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (137, 2, 137);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (138, 3, 138);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (139, 2, 139);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (140, 2, 140);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (141, 1, 141);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (142, 2, 142);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (143, 2, 143);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (144, 3, 144);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (145, 3, 145);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (146, 1, 146);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (147, 2, 147);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (148, 1, 148);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (149, 3, 149);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (150, 1, 150);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (151, 1, 151);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (152, 3, 152);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (153, 3, 153);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (154, 1, 154);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (155, 1, 155);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (156, 2, 156);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (157, 1, 157);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (158, 3, 158);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (159, 2, 159);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (160, 1, 160);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (161, 1, 161);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (162, 2, 162);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (163, 2, 163);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (164, 1, 164);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (165, 1, 165);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (166, 2, 166);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (167, 1, 167);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (168, 1, 168);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (169, 1, 169);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (170, 2, 170);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (171, 3, 171);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (172, 2, 172);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (173, 2, 173);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (174, 3, 174);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (175, 2, 175);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (176, 2, 176);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (177, 3, 177);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (178, 2, 178);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (179, 1, 179);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (180, 1, 180);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (181, 3, 181);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (182, 3, 182);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (183, 2, 183);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (184, 3, 184);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (185, 2, 185);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (186, 2, 186);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (187, 2, 187);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (188, 3, 188);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (189, 1, 189);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (190, 1, 190);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (191, 2, 191);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (192, 2, 192);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (193, 3, 193);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (194, 1, 194);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (195, 2, 195);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (196, 3, 196);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (197, 2, 197);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (198, 1, 198);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (199, 1, 199);
INSERT INTO public.booked_option (id, ticket_option, ticket) OVERRIDING SYSTEM VALUE
VALUES (200, 1, 200);

ALTER SEQUENCE public.booked_option_id_seq RESTART WITH 201;

INSERT INTO public.daily_discount (id, day, multiplier) OVERRIDING SYSTEM VALUE
VALUES (1, 'Monday', 1);
INSERT INTO public.daily_discount (id, day, multiplier) OVERRIDING SYSTEM VALUE
VALUES (2, 'Tuesday', 0.8);
INSERT INTO public.daily_discount (id, day, multiplier) OVERRIDING SYSTEM VALUE
VALUES (3, 'Wednesday', 0.7);
INSERT INTO public.daily_discount (id, day, multiplier) OVERRIDING SYSTEM VALUE
VALUES (4, 'Thursday', 0.8);
INSERT INTO public.daily_discount (id, day, multiplier) OVERRIDING SYSTEM VALUE
VALUES (5, 'Friday', 1);
INSERT INTO public.daily_discount (id, day, multiplier) OVERRIDING SYSTEM VALUE
VALUES (6, 'Saturday', 1);
INSERT INTO public.daily_discount (id, day, multiplier) OVERRIDING SYSTEM VALUE
VALUES (7, 'Sunday', 1);

ALTER SEQUENCE public.daily_discount_id_seq RESTART WITH 8;
