SELECT city.city, country.country
FROM city
         LEFT JOIN country on country.country_id = city.country_id;

SELECT payment.payment_id, customer.first_name, customer.last_name
FROM payment
         RIGHT JOIN customer ON customer.customer_id = payment.customer_id;

SELECT rental.rental_id, customer.first_name, customer.last_name
FROM rental
         FULL JOIN customer ON rental.customer_id = customer.customer_id;