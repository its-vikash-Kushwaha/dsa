

SELECT 
employee_id
from Employees e
where manager_id is not null and  manager_id not in (
    select employee_id from Employees
) and e.salary<30000
order by employee_id;