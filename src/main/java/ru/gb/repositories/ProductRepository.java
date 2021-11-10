package ru.gb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
