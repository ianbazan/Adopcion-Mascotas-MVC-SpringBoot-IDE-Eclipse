package edu.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.models.Adopciones;
import edu.cibertec.models.Mascotas;
import edu.cibertec.models.Refugios;
import edu.cibertec.services.AdopcionesService;
import edu.cibertec.services.MascotasService;
import edu.cibertec.services.RefugiosService;

@Controller
public class MascotasController {

    @Autowired
    private MascotasService mascotasService;
    
    @Autowired
    private RefugiosService refugiosService;
    
    @Autowired
    private AdopcionesService adopcionesService;

    @RequestMapping("/")
    public String verPaginaDeInicio(Model model, String palabraClave) {
        List<Mascotas> listaMascotas = mascotasService.listAll(palabraClave);
        model.addAttribute("listaMascotas", listaMascotas);
        model.addAttribute("palabraClave", palabraClave);
        return "index";
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioDeRegistrarMascota(Model model) {
        Mascotas mascotas = new Mascotas();
        List<Refugios> refugios = refugiosService.findAll();
        List<Adopciones> adopciones = adopcionesService.findAll();

        model.addAttribute("mascotas", mascotas);
        model.addAttribute("refugios", refugios);
        model.addAttribute("adopciones", adopciones);
        return "nueva_mascota";
    }

    @RequestMapping(value="/guardar", method=RequestMethod.POST)
    public String guardarMascota(@ModelAttribute("mascotas") Mascotas mascotas) {
        mascotasService.save(mascotas);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarMascota(@PathVariable(name="id") Long id) {
        ModelAndView modelo = new ModelAndView("editar_mascotas");
        Mascotas mascotas = mascotasService.get(id);
        List<Refugios> refugios = refugiosService.findAll();
        List<Adopciones> adopciones = adopcionesService.findAll();
        
        modelo.addObject("mascotas", mascotas);
        modelo.addObject("refugios", refugios);
        modelo.addObject("adopciones", adopciones);
        return modelo;
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable(name="id") Long id) {
        mascotasService.delete(id);
        return "redirect:/";
    }
}
