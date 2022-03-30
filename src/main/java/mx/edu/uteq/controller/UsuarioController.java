/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author Ricardo
 */
@Controller
public class UsuarioController {
    
    @GetMapping({"/","/login"})
    public String page(Model model) {
        return "login";
    }
    
}
