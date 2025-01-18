-- Question: https://leetcode.com/problems/biggest-single-number/description/
SELECT
    CASE
        WHEN COUNT(*) = 0 THEN NULL
        ELSE MAX(num)
    END AS num
FROM MyNumbers
WHERE num IN (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
);
