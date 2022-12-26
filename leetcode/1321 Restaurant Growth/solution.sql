SELECT a.visited_on AS visited_on,
       SUM(B.day_sum) AS amount,
       ROUND(AVG(B.day_sum), 2) AS average_amount
FROM
    (SELECT visited_on, SUM(amount) AS day_sum FROM Customer GROUP BY visited_on ) AS A,
    (SELECT visited_on, SUM(amount) AS day_sum FROM Customer GROUP BY visited_on ) AS B
WHERE DATEDIFF(A.visited_on, B.visited_on) BETWEEN 0 AND 6
GROUP BY A.visited_on
HAVING COUNT(B.visited_on) = 7
ORDER BY visited_on ASC