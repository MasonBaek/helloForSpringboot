package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!!!!!!!");
    return "hello";
  }
  
  // http://localhost:8080/hello-mvc?name=spring!!!!!!
  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
  /*public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {*/
    System.out.println("name -> "+name);
    model.addAttribute("name", name);
    return "hello-template";
  }
  
  // http://localhost:8080/hello-string?name=spring
  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name") String name) {
    return "hello"+name;
  }


}

