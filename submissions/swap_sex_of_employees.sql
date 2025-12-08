-- Question: https://leetcode.com/problems/swap-sex-of-employees/description/

UPDATE SALARY
SET sex =
    CASE
        WHEN sex = 'm' THEN 'f'
        ELSE 'm'
END;