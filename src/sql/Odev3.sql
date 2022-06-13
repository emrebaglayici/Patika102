SELECT country FROM country WHERE country LIKE 'A%' AND country LIKE '%a';
SELECT country FROM country WHERE country LIKE '______' AND country LIKE '%n';
SELECT title FROM film WHERE title ILIKE 'T%T%T%T%';
SELECT * FROM film WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;