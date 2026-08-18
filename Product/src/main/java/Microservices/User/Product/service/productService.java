package Microservices.User.Product.service;

import org.springframework.stereotype.Service;

import Microservices.User.Product.dto.ProductRequst;
import Microservices.User.Product.model.Product;
import Microservices.User.Product.repository.productRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class productService {

    private final productRepository productRepository;

    public void creatProduct(ProductRequst productR) {
        Product product = Product.builder()
                .name(productR.getName())
                .description(productR.getDescription())
                .price(productR.getPrice()).build();

        productRepository.save(product);
        log.info("Product " + product.getId() + "is saved");

    }
}
