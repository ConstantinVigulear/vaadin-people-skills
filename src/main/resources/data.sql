

INSERT
All
    INTO "SKILL_LEVEL" (ID, VERSION, NAME, LEVEL_VALUE) VALUES (1, 1, 'None', 1)
    INTO "SKILL_LEVEL" (ID, VERSION, NAME, LEVEL_VALUE) VALUES (2, 1, 'Low', 2)
    INTO "SKILL_LEVEL" (ID, VERSION, NAME, LEVEL_VALUE) VALUES (3, 1, 'Medium', 3)
    INTO "SKILL_LEVEL" (ID, VERSION, NAME, LEVEL_VALUE) VALUES (4, 1, 'High', 4)
    INTO "SKILL_LEVEL" (ID, VERSION, NAME, LEVEL_VALUE) VALUES (5, 1, 'Advanced', 5)
    INTO "SKILL_LEVEL" (ID, VERSION, NAME, LEVEL_VALUE) VALUES (6, 1, 'Godlike', 6)
SELECT 1
FROM dual;

INSERT
ALL
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(7, 1, 'None', 100)
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(8, 1, 'Security', 150)
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(9, 1, 'Data Analysis', 160)
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(10, 1, 'DevOps', 170)
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(11, 1, 'Cloud Computing', 180)
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(12, 1, 'Machine Learning', 140)
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(13, 1, 'Programming', 200)
    INTO "SKILL_DOMAIN" (ID, VERSION, NAME, BASE_PRICE) VALUES(14, 1, 'System Networks', 140)
SELECT 1
FROM dual;

INSERT
ALL
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (15, 1, 'eula.lane@jigrormo.ye', 'Eula', 'Lane')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (16, 1, 'barry.rodriquez@zun.mm', 'Barry', 'Rodriquez')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (17, 1, 'eugenia.selvi@capfad.vn', 'Eugenia', 'Selvi')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (18, 1, 'alejandro.miles@dec.bn', 'Alejandro', 'Miles')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (19, 1, 'cora.tesi@bivo.yt', 'Cora', 'Tesi')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (20, 1, 'marguerite.ishii@judbilo.gn', 'Marguerite', 'Ishii')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (21, 1, 'mildred.jacobs@joraf.wf', 'Mildred', 'Jacobs')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (22, 1, 'gene.goodman@kem.tl', 'Gene', 'Goodman')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (23, 1, 'lettie.bennett@odeter.bb', 'Lettie', 'Bennett')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (24, 1, 'mabel.leach@lisohuje.vi', 'Mabel', 'Leach')
    INTO "PERSON" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME) VALUES (25, 1, 'jordan.miccinesi@duod.gy', 'Jordan', 'Miccinesi')
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (22, 1, 'marie.parkes@nowufpus.ph', 'Marie', 'Parkes', 7, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (23, 1, 'rose.gray@kagu.hr', 'Rose', 'Gray', 9, 4)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (24, 1, 'garrett.stokes@fef.bg', 'Garrett', 'Stokes', 9, 3)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (25, 1, 'barbara.matthieu@derwogi.jm', 'Barbara', 'Matthieu', 7, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (26, 1, 'jean.rhodes@wehovuce.gu', 'Jean', 'Rhodes', 7, 3)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (27, 1, 'jack.romoli@zamum.bw', 'Jack', 'Romoli', 6, 4)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (28, 1, 'pearl.holden@dunebuh.cr', 'Pearl', 'Holden', 8, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (29, 1, 'belle.montero@repiwid.si', 'Belle', 'Montero', 9, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (30, 1, 'olive.molina@razuppa.ga', 'Olive', 'Molina', 6, 2)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (31, 1, 'minerva.todd@kulmenim.ad', 'Minerva', 'Todd', 9, 3)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (32, 1, 'bobby.pearson@ib.kg', 'Bobby', 'Pearson', 9, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (33, 1, 'larry.ciappi@ba.lk', 'Larry', 'Ciappi', 10, 2)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (34, 1, 'ronnie.salucci@tohhij.lv', 'Ronnie', 'Salucci', 9, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (35, 1, 'walter.grossi@tuvo.sa', 'Walter', 'Grossi', 9, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (36, 1, 'frances.koopmans@foga.tw', 'Frances', 'Koopmans', 7, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (37, 1, 'frances.fujimoto@uswuzzub.jp', 'Frances', 'Fujimoto', 6, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (38, 1, 'olivia.vidal@hivwerip.vc', 'Olivia', 'Vidal', 9, 2)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (39, 1, 'edna.henry@gugusu.rw', 'Edna', 'Henry', 8, 4)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (40, 1, 'lydia.brun@zedekak.md', 'Lydia', 'Brun', 7, 3)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (41, 1, 'jay.blake@ral.mk', 'Jay', 'Blake', 10, 4)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (42, 1, 'isabel.serafini@turuhu.bh', 'Isabel', 'Serafini', 10, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (43, 1, 'rebecca.carter@omjo.et', 'Rebecca', 'Carter', 8, 4)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (44, 1, 'maurice.fabbrini@rig.bh', 'Maurice', 'Fabbrini', 9, 3)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (45, 1, 'ollie.turnbull@sicewap.org', 'Ollie', 'Turnbull', 6, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (46, 1, 'jerry.hopkins@fo.mh', 'Jerry', 'Hopkins', 9, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (47, 1, 'nora.lyons@gegijap.na', 'Nora', 'Lyons', 10, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (48, 1, 'anne.weis@kuvesa.pe', 'Anne', 'Weis', 7, 4)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (49, 1, 'louise.gauthier@lapahu.mt', 'Louise', 'Gauthier', 6, 2)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (50, 1, 'lloyd.fani@zev.ru', 'Lloyd', 'Fani', 8, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (51, 1, 'maud.dunn@nabeaga.ni', 'Maud', 'Dunn', 6, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (52, 1, 'henry.gigli@kaot.ps', 'Henry', 'Gigli', 6, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (53, 1, 'virgie.werner@tawuctuj.cf', 'Virgie', 'Werner', 10, 4)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (54, 1, 'gregory.cozzi@eh.ru', 'Gregory', 'Cozzi', 8, 2)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (55, 1, 'lucinda.gil@fajjusuz.kr', 'Lucinda', 'Gil', 7, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (56, 1, 'gertrude.verbeek@pave.cc', 'Gertrude', 'Verbeek', 6, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (57, 1, 'mattie.graham@ispaviw.gt', 'Mattie', 'Graham', 7, 2)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (58, 1, 'bryan.shaw@ha.ee', 'Bryan', 'Shaw', 9, 1)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (59, 1, 'essie.adams@iliat.cw', 'Essie', 'Adams', 8, 5)
--     INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES (60, 1, 'gary.osborne@do.ga', 'Gary', 'Osborne', 7, 5)
SELECT 1
FROM dual;

INSERT
    ALL
    INTO "SKILL" (ID, VERSION, NAME, SKILL_DOMAIN_ID, SKILL_LEVEL_ID) VALUES (101, 1, 'Java Core', 13, 4)
    INTO "SKILL" (ID, VERSION, NAME, SKILL_DOMAIN_ID, SKILL_LEVEL_ID) VALUES (102, 1, 'Penetration Testing', 7, 5)
    INTO "SKILL" (ID, VERSION, NAME, SKILL_DOMAIN_ID, SKILL_LEVEL_ID) VALUES (103, 1, 'Docker', 9, 2)
    INTO "SKILL" (ID, VERSION, NAME, SKILL_DOMAIN_ID, SKILL_LEVEL_ID) VALUES (104, 1, 'Terraform', 10, 1)
    INTO "SKILL" (ID, VERSION, NAME, SKILL_DOMAIN_ID, SKILL_LEVEL_ID) VALUES (105, 1, 'Deep Learning', 14, 1)
SELECT 1
FROM dual;

INSERT
ALL
    INTO "PEOPLE_SKILLS" (PERSON_ID, SKILL_ID) VALUES (15, 101)
SELECT 1
FROM dual;