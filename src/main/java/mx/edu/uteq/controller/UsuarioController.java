/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.uteq.dao.ICarrera;
import mx.edu.uteq.dao.IEstudiante;
import mx.edu.uteq.domain.Carrera;
import mx.edu.uteq.domain.Privacidad;
import mx.edu.uteq.domain.Usuario;
import mx.edu.uteq.service.IPrivacidadService;
import mx.edu.uteq.service.IProfesorService;
import mx.edu.uteq.service.IPublicacionService;
import mx.edu.uteq.service.IUsuarioService;
import mx.edu.uteq.service.SendEmail;
import static mx.edu.uteq.util.EncriptarPassword.encriptarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ricardo
 */
@Controller
public class UsuarioController {

    @Autowired
    IProfesorService profesorService;

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IPrivacidadService privacidadService;

    @Autowired
    ICarrera carreraService;

    @Autowired
    IEstudiante estudianteService;

    @Autowired
    SendEmail correo;

    @GetMapping({"/", "/login"})
    public String page(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<Carrera> carreras = carreraService.findAll();
        model.addAttribute("carreras", carreras);
        return "register";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioService.findById(usuarioService.findByEmailUsua(authentication.getName()));

        List<Carrera> carreras = carreraService.findAll();

        Privacidad privacidad = privacidadService.findByIdUsua(usuario.idUsua.intValue());
        model.addAttribute("privacidad", privacidad);
        model.addAttribute("carreras", carreras);
        return "perfil";
    }

    @PostMapping(path = "/registerusuario")
    @ResponseBody
    public ModelAndView registerusuario(
            @RequestParam("carrUsua") String carrUsua,
            @RequestParam("n1Usua") String n1Usua,
            @RequestParam("n2Usua") String n2Usua,
            @RequestParam("apUsua") String apUsua,
            @RequestParam("amUsua") String amUsua,
            @RequestParam("ecivilUsua") String ecivilUsua,
            @RequestParam("fnacUsua") String fnacUsua,
            @RequestParam("lnacUsua") String lnacUsua,
            @RequestParam("emailUsua") String emailUsua,
            @RequestParam("passwordUsua") String passwordUsua,
            @RequestParam(value = "isProfesor", required = false) String isProfesor) {

        if (emailUsua.split("@")[1].equals("uteq.edu.mx")) {
            if (isProfesor != null) {
                profesorService.insert(carrUsua, n1Usua, n2Usua, apUsua, amUsua, ecivilUsua, fnacUsua, lnacUsua);
                usuarioService.insert(profesorService.getLastId(), null, "1", emailUsua, encriptarPassword(passwordUsua), "0");
                privacidadService.insert(usuarioService.getLastId(), "PRIVADO", "PRIVADO");
                correo.sendEmail(emailUsua, "Verificación de cuenta en FaceUTEQ", "Para verificar tu cuenta debes ingresar al siguiente enlace: http://localhost:8080/activar?idUsua=" + usuarioService.getLastId());
            } else {
                estudianteService.insert(carrUsua, n1Usua, n2Usua, apUsua, amUsua, ecivilUsua, fnacUsua, lnacUsua);
                usuarioService.insert(null, estudianteService.getLastId(), "1", emailUsua, encriptarPassword(passwordUsua), "0");
                privacidadService.insert(usuarioService.getLastId(), "PRIVADO", "PRIVADO");
                correo.sendEmail(emailUsua, "Verificación de cuenta en FaceUTEQ", "Para verificar tu cuenta debes ingresar al siguiente enlace: http://localhost:8080/activar?idUsua=" + usuarioService.getLastId());
            }
        }

        return new ModelAndView("redirect:/login");
    }

    @PostMapping(path = "/updatepreferences")
    @ResponseBody
    public ModelAndView registerusuario(@RequestParam("publi_priv") String publiPriv) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioService.findById(usuarioService.findByEmailUsua(authentication.getName()));
        privacidadService.update(publiPriv, usuario.idUsua.intValue());

        return new ModelAndView("redirect:/perfil");
    }

    @PostMapping(path = "/updateprofile")
    @ResponseBody
    public ModelAndView updateprofile(
            @RequestParam("carrUsua") int carrUsua,
            @RequestParam("lnacUsua") String lnacUsua,
            @RequestParam("ecivilUsua") String ecivilUsua) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioService.findById(usuarioService.findByEmailUsua(authentication.getName()));
        if (usuario.getEstudiante().getIdEstu() != null) {
            estudianteService.actualizar(carrUsua, lnacUsua, ecivilUsua, usuario.estudiante.getIdEstu().intValue());
        } else {
            profesorService.actualizar(carrUsua, lnacUsua, ecivilUsua, usuario.profesor.getIdProf().intValue());
        }

        return new ModelAndView("redirect:/perfil");
    }

    @RequestMapping("/activar")
    public ModelAndView activar(@RequestParam(name = "idUsua") String idUsua) {
        usuarioService.activarCuenta(idUsua);

        return new ModelAndView("redirect:/login");
    }

}
