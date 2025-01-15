-- Question: https://leetcode.com/problems/duplicate-emails/description/

SELECT email AS 'Email'
FROM Person
GROUP BY email
HAVING COUNT(*) >= 2;