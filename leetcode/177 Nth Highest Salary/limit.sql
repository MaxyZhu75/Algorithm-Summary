CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT # ֻ�ܲ�ȫ�ֲ��ܲ��������������Ҫ�����������Ҫ�ô��ں���������
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