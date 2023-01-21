package springbootreactiveproject.resactive.contoller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import springbootreactiveproject.resactive.model.Product;
import springbootreactiveproject.resactive.repository.ProductRepository;
@Transactional
@RestController
@RequestMapping("/rest")
public class DataRestController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping
    public ResponseEntity getAllProduct(){

        return new ResponseEntity(productRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping("/findPrice")
    public ResponseEntity findByPrice(@RequestParam int Price){

        return new ResponseEntity(productRepository.findByPrice(new Integer(Price)),HttpStatus.OK);
    }
    @GetMapping("/findDescription")
    public ResponseEntity findByDiscrption(@RequestParam String dis){
        return new ResponseEntity<>(productRepository.findByDescription(dis),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity saved(@RequestBody Product product){
productRepository.save(product).subscribe();
return new ResponseEntity("saved",HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Product productUpdate){
        //TODO - additional id match
        Mono<Product> updatedCont = productRepository.findById(productUpdate.getId())
                        .flatMap(oldContact -> {
                            oldContact
                                    .setPrice(120);
                            return productRepository.save(oldContact);
                        });
      updatedCont.subscribe();
       return ResponseEntity.ok("ok");
    }

}
