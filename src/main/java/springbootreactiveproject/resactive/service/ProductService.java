package springbootreactiveproject.resactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springbootreactiveproject.resactive.model.Product;
import springbootreactiveproject.resactive.repository.ProductRepository;

import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void insertProduct(Product product){
product.setId(UUID.randomUUID().toString());
/*Product product1=new Product();
product1.setId(UUID.randomUUID().toString());
product1.setPrice(12);
product1.setDescription("s")*/;
        productRepository.save(product).subscribe();

    }
   public Flux<Product> findAll(){
        return productRepository.findAll();
    }
}
