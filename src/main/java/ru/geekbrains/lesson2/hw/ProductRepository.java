package ru.geekbrains.lesson2.hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return new Product(product.getId(), product.getName(), product.getPrice());
            }
        }
        throw new RuntimeException("There is no any product with this id!");
    }

    public void add(Product product) {
        products.add(product);
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Яблоки", 500));
        products.add(new Product(2, "Груши", 560));
        products.add(new Product(3, "Мандарины", 600));
        products.add(new Product(4, "Бананы", 580));
        products.add(new Product(5, "Киви", 650));
    }

}
