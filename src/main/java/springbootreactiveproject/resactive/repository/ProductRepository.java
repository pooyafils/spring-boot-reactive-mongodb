package springbootreactiveproject.resactive.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import springbootreactiveproject.resactive.model.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product,String>{
}
