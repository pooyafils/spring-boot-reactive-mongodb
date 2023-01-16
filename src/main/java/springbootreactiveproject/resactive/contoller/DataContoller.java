package springbootreactiveproject.resactive.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootreactiveproject.resactive.model.Product;
import springbootreactiveproject.resactive.service.ProductService;

@Controller
@RequestMapping(value = "/")
public class DataContoller {
@Autowired
    ProductService productService;

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
}
