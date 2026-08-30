# Write your MySQL query statement below

(select u.name as results from MovieRating m
join Users u
on m.user_id=u.user_id
group by m.user_id 
order by count(*) desc,u.name asc
limit 1)

union all

(select m.title as results from MovieRating mr
join Movies m
on mr.movie_id=m.movie_id
WHERE mr.created_at >= '2020-02-01'
  AND mr.created_at < '2020-03-01'
group by mr.movie_id
order by avg(mr.rating) desc, m.title asc
limit 1);