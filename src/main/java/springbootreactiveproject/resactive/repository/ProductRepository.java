package springbootreactiveproject.resactive.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import springbootreactiveproject.resactive.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product,String>{
}
