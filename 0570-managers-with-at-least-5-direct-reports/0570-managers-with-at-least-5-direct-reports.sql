# Write your MySQL query statement below

select name from Employee 
where id in
(select managerId from Employee e
where managerId is not null
group by managerId
having count(managerId)>=5);