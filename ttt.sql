SELECT * FROM party_group 
SELECT * FROM party_relationship
SELECT * FROM party_relationship_type 
SELECT * FROM party_role WHERE party_id=2

SELECT * FROM party_relationship WHERE party_relationship_id=1
UPDATE party_relationship SET party_relationship_type_id=3, role_type_id_to=2 WHERE party_relationship_id=1

SELECT * FROM party WHERE party_id>=8 AND party_id<=27
-- --新增乡党委
INSERT INTO party(party_type_id,status_id,description,created_by_user)
SELECT 'party_group',0,CONCAT(description,'党委'),party_id
FROM party WHERE party_id>=8 AND party_id<=27

SELECT * FROM `party_group`
INSERT INTO party_group (party_id,group_name)
SELECT party_id,description
FROM party WHERE party_id>=570 AND party_id<=588

SELECT * FROM party_role 
INSERT INTO party_role (party_id,role_type_id)
SELECT party_id,2
FROM party WHERE party_id>=570 AND party_id<=588

SELECT * FROM `party_relationship`
INSERT INTO party_relationship(party_relationship_type_id,party_id_from,party_id_to,role_type_id_from,role_type_id_to,from_date)
SELECT 3,created_by_user,party_id,1,2,'2015-09-03'
FROM party WHERE party_id>=570 AND party_id<=588

INSERT INTO party_relationship(party_relationship_type_id,party_id_from,party_id_to,role_type_id_from,role_type_id_to,from_date)
SELECT 4,2,party_id,2,2,'2015-09-03'
FROM party WHERE party_id>=570 AND party_id<=588
-- --新增村党支部
SELECT * FROM party WHERE description LIKE '%党支部%'
INSERT INTO party(party_type_id,status_id,description,created_by_user)
SELECT 'party_group',0,CONCAT(description,'党支部'),party_id
FROM party WHERE party_id>=39 AND party_id<=569


SELECT * FROM `party_group`
INSERT INTO party_group (party_id,group_name)
SELECT party_id,description
FROM party WHERE party_id>=601 AND party_id<=1130
 

SELECT * FROM party_role 
INSERT INTO party_role (party_id,role_type_id)
SELECT party_id,2
FROM party WHERE party_id>=601 AND party_id<=1130

-- 归属的行政村
SELECT * FROM `party_relationship`
INSERT INTO party_relationship(party_relationship_type_id,party_id_from,party_id_to,role_type_id_from,role_type_id_to,from_date)
SELECT 3,created_by_user,party_id,1,2,'2015-09-03'
FROM party WHERE party_id>=601 AND party_id<=1130
-- 上下级关系
INSERT INTO party_relationship(party_relationship_type_id,party_id_from,party_id_to,role_type_id_from,role_type_id_to,from_date)

SELECT 4,c.party_id,a.party_id,2,2,'2015-09-03'
FROM party a
INNER JOIN party_relationship b
ON a.created_by_user=b.party_id_to AND b.party_relationship_type_id=1
INNER JOIN party c
ON b.party_id_from=c.created_by_user AND c.party_type_id='party_group'
WHERE a.party_id>=601 AND a.party_id<=1130


SELECT * 
FROM party a
INNER JOIN party_relationship b
ON a.party_id=b.party_id_from AND party_relationship_type_id=4
INNER JOIN party c
ON b.party_id_to=c.party_id
WHERE a.party_id=584

SELECT * FROM person 

