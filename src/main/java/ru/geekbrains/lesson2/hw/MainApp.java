package ru.geekbrains.lesson2.hw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println(productRepository.getProducts());

        Cart cart = context.getBean("cart", Cart.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Add something: ");
        cart.add(new Product(scanner.nextInt(), scanner.next(), scanner.nextInt()));
        System.out.println(productRepository.getProducts());

        System.out.println("Remove by ID");
        cart.removeById(scanner.nextInt());
        System.out.println(productRepository.getProducts());

        System.out.println("Get Product by ID");
        productRepository.getProductById(scanner.nextInt());
        System.out.println(productRepository.getProducts());
    }

}
