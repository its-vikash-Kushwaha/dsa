# Write your MySQL query statement below


select 
'Low Salary' as category,
count(*) as accounts_count
from Accounts
where income<20000

UNION ALL

select 
'Average Salary',
count(*) 
from Accounts
where income between 20000 and 50000

UNION ALL

select 
'High Salary',
count(*)
from Accounts
where income>50000;