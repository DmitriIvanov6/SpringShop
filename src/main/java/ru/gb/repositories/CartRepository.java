package ru.gb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
