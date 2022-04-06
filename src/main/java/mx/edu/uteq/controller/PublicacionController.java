/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import mx.edu.uteq.domain.Publicacion;
import mx.edu.uteq.domain.Usuario;
import mx.edu.uteq.model.RespuestaOperacionModel;
import mx.edu.uteq.service.IPublicacionService;
import mx.edu.uteq.service.IUsuarioService;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ricardo
 */
@org.springframework.stereotype.Controller
@Slf4j
public class PublicacionController {

    @Autowired
    IPublicacionService publicacionService;
    
    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/publicaciones")
    public String page(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Publicacion> publicaciones = publicacionService.getAllByUsuario(authentication.getName());
        model.addAttribute("publicaciones", publicaciones);
        return "publicaciones";
    }

    @PostMapping(path = "/insert")
    @ResponseBody
    public ModelAndView subirImagen(@RequestBody @RequestParam("file") MultipartFile file, @RequestParam("publicacion") String publicacion, HttpServletRequest request, HttpServletResponse response) {

        RespuestaOperacionModel respuesta = new RespuestaOperacionModel();

        respuesta.setRespuesta(true);

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            int random = new Random().nextInt();
            String url = "/static/images/"+random+"_"+file.getOriginalFilename().replaceAll("[^A-Za-z0-9.]+", "").trim();
            if(file.isEmpty()){
                publicacionService.insertar(usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue(), publicacion, null);
            }
            else{
                publicacionService.guardarImagen(".//src//main//resources//static//images", file, random+"_"+file.getOriginalFilename().replaceAll("[^A-Za-z0-9.]+", "").trim());
                publicacionService.insertar(usuarioService.findByEmailUsua(authentication.getName()).idUsua.intValue(), publicacion, url);
            }
            
            //Delay para que alcance a subirse la imágen al servidor y cargue correctamente
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            respuesta.setRespuesta(false);
            respuesta.setDescripcion("Error al subir imagen"+e.toString());
        }

        return new ModelAndView("redirect:/publicaciones");
    }
}
