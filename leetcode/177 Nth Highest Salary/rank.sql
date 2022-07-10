CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
        SELECT 
            DISTINCT salary
        FROM 
            (SELECT 
                salary,
                DENSE_RANK() OVER(ORDER BY salary DESC) AS ranking
             FROM 
                employee) AS rankTable
        WHERE ranking = N
  );
END