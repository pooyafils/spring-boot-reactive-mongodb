package springbootreactiveproject.resactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootreactiveproject.resactive.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
}
