package springbootreactiveproject.resactive.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootreactiveproject.resactive.model.Product;
import springbootreactiveproject.resactive.repository.ProductRepository;
import springbootreactiveproject.resactive.service.ProductService;

@Controller
@RequestMapping(value = "/")
public class DataContoller {
@Autowired
    ProductService productService;
@Autowired
    ProductRepository productRepository;
    @GetMapping
    public String index(){
        return "index";
    }
    @GetMapping("/mainPage")
    public String insertData(){
        return "insert";
    }
    @PostMapping("insertproduct")
    public String insertProduct(@ModelAttribute("obj")Product product){
        productService.insertProduct(product);
        return "redirect:/";
    }
    @GetMapping("/showAll")
    public String showAll(Model model){
        model.addAttribute("all",productService.findAll());
        System.out.println(productService.findAll());
     return   "showAll";
    }
    @GetMapping("/findPrice")
    public String findDescription(Model model) {
        model.addAttribute("info",productRepository.findByPrice(new Integer(100)));
        return "findPrice";
    }
    @GetMapping("/findDescription")
    public String findBy(Model model){
        model.addAttribute("fi",productRepository.findByDescription("a51"));
        return "findDescription";
    }
    @GetMapping("/delete/{id}")
    public String delteById(@PathVariable String id){
        productRepository.deleteById(id).subscribe();
        return "index";
    }
}
