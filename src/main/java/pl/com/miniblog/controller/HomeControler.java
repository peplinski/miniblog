package pl.com.miniblog.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HomeControler {
    @GetMapping("/index")
    public String getHomePage() {
        // model to obiekt do którego możemy zamieścić dowolne wartości
        // poprzez dodanie ich jako atrybutu
//        model.addAttribute("wartosc", "Tekst do wydrukowania");
//        model.addAttribute("page_title", "Home Page");

        // przykładowe dodanie listy
//        model.addAttribute("lista", appUserService.getUserList());

        // zwracamy zawsze nazwę naszego widoku (nazwę pliku html bez końcówki '.html')
        return "index";
    }
}
