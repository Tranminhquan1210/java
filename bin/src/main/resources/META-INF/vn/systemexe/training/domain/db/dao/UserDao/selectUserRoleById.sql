SELECT
  u.id as user_id,
  r.id as role_id,
  r.name as role_name
FROM user u INNER JOIN user_role ur ON u.id = ur.user_id
  INNER JOIN role r ON ur.role_id = r.id
WHERE
  u.id = /* userId */1