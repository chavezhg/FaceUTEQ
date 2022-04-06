/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.controller;

import java.util.List;
import mx.edu.uteq.domain.Amigo;
import mx.edu.uteq.service.IAmigoService;
import mx.edu.uteq.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ricardo
 */
@Controller
public class AmigoController {
    
    @Autowired
    IAmigoService amigoService;
    
    @Autowired
    IUsuarioService usuarioService;
    
    @GetMapping("/amigos")
    public String page(Model model) {
        return "amigos";
    }
    
    @GetMapping("/buscaramigos")
    public String buscaramigos(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int val = usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue();
        List<Amigo> usersNotFriends = amigoService.getAllNotFriends(val);
        model.addAttribute("usersNotFriends", usersNotFriends);
        return "buscaramigos";
    }
    
}
