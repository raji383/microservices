package Microservices.User.Product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Microservices.User.Product.dto.ProductRequst;
import Microservices.User.Product.dto.productRes;
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

    public List<productRes> getallproducts() {
        List<Product> all = productRepository.findAll();
        List<productRes> l = all.stream().map(p -> maptoProduct(p)).toList();
        return l;

    }

    private productRes maptoProduct(Product p) {
        return productRes.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice())
                .build();
    }
}
