package ru.gb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
