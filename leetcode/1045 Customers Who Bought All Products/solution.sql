SELECT DISTINCT
    A.customer_id
FROM
    Customer AS A INNER JOIN Product AS B
    ON A.product_key = B.product_key
GROUP BY A.customer_id
HAVING COUNT(DISTINCT A.product_key) = (SELECT COUNT(*) FROM Product)