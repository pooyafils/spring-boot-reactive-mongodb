package springbootreactiveproject.resactive.contoller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootreactiveproject.resactive.repository.ProductRepository;

@RestController
@RequestMapping("/rest")
public class DataRestController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping
    public ResponseEntity getAllProduct(){

        return new ResponseEntity(productRepository.findAll(),HttpStatus.OK);
    }
}
