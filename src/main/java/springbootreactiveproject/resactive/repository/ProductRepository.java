package springbootreactiveproject.resactive.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springbootreactiveproject.resactive.model.Product;

import java.util.List;

public interface ProductRepository extends ReactiveMongoRepository<Product,String>{
    Flux<List<Product>>findByDescription(String des);
    Mono<Product> findByPrice(Integer integer);
}
