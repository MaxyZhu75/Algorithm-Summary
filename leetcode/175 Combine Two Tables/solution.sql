SELECT
    firstName,
    lastName,
    city,
    state
FROM Person AS A LEFT JOIN Address AS B
ON A.PersonId = B.PersonId