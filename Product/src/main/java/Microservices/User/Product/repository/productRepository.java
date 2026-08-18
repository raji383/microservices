package Microservices.User.Product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import Microservices.User.Product.model.Product;
/*
save(product);
findAll();
findById(id);
deleteById(id);
delete(product);
existsById(id);
count();
*/
public interface productRepository extends MongoRepository<Product, String> {
    
}
