/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.edu.uteq.domain.Publicacion;
import mx.edu.uteq.domain.Usuario;
import mx.edu.uteq.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ricardo
 */
@Controller
@Slf4j
public class PrincipalController {

    @Autowired
    IPublicacionService publicacionService;

    @GetMapping("/principal")
    public String page(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Publicacion> publicaciones = publicacionService.getAllDisponiblesByUsuario(authentication.getName());
        model.addAttribute("publicaciones", publicaciones);
        return "principal";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        return "";
    }

    @GetMapping("/getByUsua/{usuario}")
    public String getByUsua(Model model) {
        return "";
    }

}
