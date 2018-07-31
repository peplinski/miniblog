package pl.com.miniblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.miniblog.service.AppUserService;
@RestController
public class HomeControler {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/login_Page")
    public Long getHomePage(@RequestParam(name = "email")String email,
                              @RequestParam(name = "password")String password,
                              @RequestParam(name = "name")String name) {

        Long id=appUserService.registerUser(email,password,name);


        // model to obiekt do którego możemy zamieścić dowolne wartości
        // poprzez dodanie ich jako atrybutu
       // model.addAttribute("wartosc", "Tekst do wydrukowania");
//        model.addAttribute("page_title", "Home Page");

        // przykładowe dodanie listy
//        model.addAttribute("lista", appUserService.getUserList());

        // zwracamy zawsze nazwę naszego widoku (nazwę pliku html bez końcówki '.html')
        return id;
    }
}
