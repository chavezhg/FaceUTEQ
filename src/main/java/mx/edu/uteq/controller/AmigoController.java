/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.controller;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.uteq.domain.Amigo;
import mx.edu.uteq.domain.Usuario;
import mx.edu.uteq.model.RespuestaOperacionModel;
import mx.edu.uteq.service.IAmigoService;
import mx.edu.uteq.service.IProfesorService;
import mx.edu.uteq.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
    
    @Autowired
    IProfesorService profesorService;
    
    @GetMapping("/amigos")
    public String page(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int val = usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue();
        List<Usuario> usersFriends = usuarioService.getAllFriends(val);
        model.addAttribute("usersFriends", usersFriends);
        return "amigos";
    }
    
    @GetMapping("/buscaramigos")
    public String buscaramigos(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Usuario> usersNotFriends = usuarioService.getAllNotFriends(usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue());
        model.addAttribute("usersNotFriends", usersNotFriends);
        return "buscaramigos";
    }
    
    @PostMapping(path = "/insertamigo")
    @ResponseBody
    public ModelAndView insertAmigo(@RequestParam("id") String idrecUsua, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        amigoService.insert(usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue(), Integer.parseInt(idrecUsua));

        return new ModelAndView("redirect:/buscaramigos");
    }
    
    @PostMapping(path = "/deleteamigo")
    @ResponseBody
    public ModelAndView deleteAmigo(@RequestParam("id") String idrecUsua, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        amigoService.insert(usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue(), Integer.parseInt(idrecUsua));

        return new ModelAndView("redirect:/buscaramigos");
    }
    
    @GetMapping("/solicitudes")
    public String solicitudes(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Usuario> usersRequests = usuarioService.getAllRequests(usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue());
        model.addAttribute("usersRequests", usersRequests);
        return "solicitudes";
    }
    
    @PostMapping(path = "/aceptarsolicitud")
    @ResponseBody
    public ModelAndView aceptarsolicitud(@RequestParam("idaceptar") String idEmi, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        amigoService.aceptarSolicitud(Integer.parseInt(idEmi), usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue());

        return new ModelAndView("redirect:/amigos");
    }
    
    @PostMapping(path = "/rechazarsolicitud")
    @ResponseBody
    public ModelAndView rechazarsolicitud(@RequestParam("idrechazar") String idEmi, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        amigoService.rechazarSolicitud(Integer.parseInt(idEmi), usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue());

        return new ModelAndView("redirect:/amigos");
    }
    
    
}
