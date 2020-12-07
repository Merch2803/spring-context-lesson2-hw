package ru.geekbrains.lesson2.hw;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Cart {
    private ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        productRepository.add(product);
    }

    public void removeById(int id) {
        List<Product> arrayList = productRepository.getProducts();
        int index = -1;
        for (Product ar : arrayList) {
            index++;
            if (ar.getId() == id) {
                break;
            }
        }
        arrayList.remove(index);
    }
}
