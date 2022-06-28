insert into acktion_role(acktion_role_id, name, created_at, updated_at) VALUES
(hextoraw(replace(uuid(), '-', '')), 'ROLE_TEMPORARY_USER', NOW(), NOW()),
(hextoraw(replace(uuid(), '-', '')), 'ROLE_MEMBER', NOW(), NOW()),
(hextoraw(replace(uuid(), '-', '')), 'ROLE_ADMIN', NOW(), NOW());

insert into acktion_privilege(acktion_privilege_id, name, created_at, updated_at) values
(hextoraw(replace(uuid(), '-', '')), 'WATCH_AUCTION', now(), now()),
(hextoraw(replace(uuid(), '-', '')), 'REQUEST_AUCTION', now(), now()),
(hextoraw(replace(uuid(), '-', '')), 'PARTICIPATE_AUCTION', now(), now()),
(hextoraw(replace(uuid(), '-', '')), 'MANAGE_AUCTION', now(), now()),
(hextoraw(replace(uuid(), '-', '')), 'MANAGE_USER', now(), now()),
(hextoraw(replace(uuid(), '-', '')), 'MANAGE_PRODUCT', now(), now());

DELIMITER ;;
CREATE FUNCTION grant_privilege() RETURNS BOOL
BEGIN
	DECLARE temp_user BINARY(16);
    DECLARE acktion_member BINARY(16);
    DECLARE acktion_admin BINARY(16);
    DECLARE wa BINARY(16);
    DECLARE ra BINARY(16);
    DECLARE pa BINARY(16);
    DECLARE ma BINARY(16);
    DECLARE mu BINARY(16);
    DECLARE mp BINARY(16);
	SET temp_user = (select acktion_role_id from acktion_role where name = "ROLE_TEMPORARY_USER");
    SET acktion_member = (select acktion_role_id from acktion_role where name = "ROLE_MEMBER");
    SET acktion_admin = (select acktion_role_id from acktion_role where name = "ROLE_ADMIN");
    SET wa = (select acktion_privilege_id from acktion_privilege where name = "WATCH_AUCTION");
    SET ra = (select acktion_privilege_id from acktion_privilege where name = "REQUEST_AUCTION");
    SET pa = (select acktion_privilege_id from acktion_privilege where name = "PARTICIPATE_AUCTION");
    SET ma = (select acktion_privilege_id from acktion_privilege where name = "MANAGE_AUCTION");
    SET mu = (select acktion_privilege_id from acktion_privilege where name = "MANAGE_USER");
    SET mp = (select acktion_privilege_id from acktion_privilege where name = "MANAGE_PRODUCT");

    insert into acktion_role_privilege(acktion_role_privilege_id, created_at, updated_at, acktion_role_id, acktion_privilege_id) values
	  (hextoraw(replace(uuid(), '-', '')), now(), now(), temp_user, wa),
	  (hextoraw(replace(uuid(), '-', '')), now(), now(), acktion_member, wa),
	  (hextoraw(replace(uuid(), '-', '')), now(), now(), acktion_member, ra),
    (hextoraw(replace(uuid(), '-', '')), now(), now(), acktion_member, pa),
    (hextoraw(replace(uuid(), '-', '')), now(), now(), acktion_admin, wa),
    (hextoraw(replace(uuid(), '-', '')), now(), now(), acktion_admin, ma),
    (hextoraw(replace(uuid(), '-', '')), now(), now(), acktion_admin, mu),
    (hextoraw(replace(uuid(), '-', '')), now(), now(), acktion_admin, mp);

    RETURN TRUE;
END ;;
DELIMITER ;

select grant_privilege();
