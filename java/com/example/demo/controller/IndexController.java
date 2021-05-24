//不要
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
@Controller
public class IndexController {
	@GetMapping("/index")
    public String Test() {
    	return "pages/Index.html";
    }
}
