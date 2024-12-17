package edu.cibertec.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.models.Adopciones;
import edu.cibertec.models.Mascotas;
import edu.cibertec.models.Refugios;
import edu.cibertec.models.SolicitudAdopcion;
import edu.cibertec.services.AdopcionesService;
import edu.cibertec.services.MascotasService;
import edu.cibertec.services.RefugiosService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MascotasController {

    @Autowired
    private MascotasService mascotasService;
    
    @Autowired
    private RefugiosService refugiosService;
    
    @Autowired
    private AdopcionesService adopcionesService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Refugios.class, new RefugioEditor(refugiosService));
    }
    @RequestMapping("/")
    public String verPaginaDeInicio(Model model, String palabraClave) {
        List<Mascotas> listaMascotas = mascotasService.listAll(palabraClave);
        model.addAttribute("listaMascotas", listaMascotas);
        model.addAttribute("palabraClave", palabraClave);
        return "index";
    }
    
    @RequestMapping("/reporteMascotas")
    public String reporteMascotas(Model model) {
        List<Mascotas> listaMascotas = mascotasService.listAll(null); 
        model.addAttribute("listaMascotas", listaMascotas);
        return "reportemascotas";
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
        return "redirect:/refugio/refugio";
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
    public String eliminarMascota(@PathVariable(name="id") Long id, Model model) {
        try {
            mascotasService.delete(id);
            model.addAttribute("success", "Mascota eliminada exitosamente");
        } catch (Exception e) {
            model.addAttribute("error", "Esta mascota está siendo solicitada");
        }
        List<Mascotas> listaMascotas = mascotasService.listAll(null);
        model.addAttribute("listaMascotas", listaMascotas);
        return "RefugioView";
    }
    
    @RequestMapping("/solicitud/{id}")
    public String mostrarFormularioDeSolicitudAdopcion(@PathVariable(name="id") Long id, Model model) {
        Mascotas mascota = mascotasService.get(id);
        model.addAttribute("adopcion", new SolicitudAdopcion());
        model.addAttribute("mascotaNombre", mascota.getNombre());
        return "solicitud_adopcion";
    }
    
}
