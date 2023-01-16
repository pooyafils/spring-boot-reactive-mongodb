package springbootreactiveproject.resactive.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class DataContoller {


    @GetMapping
    public String index(){
        return "index";
    }
    @GetMapping("/insert")
    public String insertData(){
        return "insert";
    }
}
