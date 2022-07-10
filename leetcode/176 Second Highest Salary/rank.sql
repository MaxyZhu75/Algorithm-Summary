SELECT
    IFNULL(
        (SELECT DISTINCT salary
        FROM
            (SELECT
                salary,
                DENSE_RANK() OVER(ORDER BY salary DESC) AS ranking
            FROM
                employee) AS rankTable
            WHERE ranking = 2), NULL) AS SecondHighestSalary