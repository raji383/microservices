package Microservices.User.Product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Microservices.User.Product.dto.ProductRequst;
import Microservices.User.Product.dto.productRes;
import Microservices.User.Product.service.productService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class productController {
    private final productService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequst product) {
        productService.creatProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<productRes> getallproducts() {
        return productService.getallproducts();
    }
}
