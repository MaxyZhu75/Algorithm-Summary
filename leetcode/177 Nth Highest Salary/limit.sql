CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT # 只能查全局不能查分组后的排名，若要求分组排名需要用窗口函数！！！
BEGIN
    SET N := N-1;
  RETURN (
        SELECT 
            salary
        FROM 
            employee
        GROUP BY 
            salary
        ORDER BY 
            salary DESC
        LIMIT N, 1
  );
END