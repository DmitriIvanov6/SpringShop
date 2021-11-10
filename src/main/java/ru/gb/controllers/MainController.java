package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.entities.Category;
import ru.gb.entities.Product;
import ru.gb.repositories.CategoryRepository;
import ru.gb.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MainController {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public MainController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String toIndex() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String mainPage(Model model) {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        model.addAttribute("products", products);
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        model.addAttribute("categories", categories);
        return "/index";
    }

}
