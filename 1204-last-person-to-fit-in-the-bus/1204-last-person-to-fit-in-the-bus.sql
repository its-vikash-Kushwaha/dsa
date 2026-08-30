
select person_name from (
    select person_name,
           sum(weight) over(order by (turn)) as total_weights from Queue
) q

where q.total_weights <=1000
order by total_weights desc
limit 1;