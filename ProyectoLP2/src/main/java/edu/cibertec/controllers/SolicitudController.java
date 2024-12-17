package edu.cibertec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import edu.cibertec.models.Mascotas;
import edu.cibertec.models.SolicitudAdopcion;
import edu.cibertec.repositories.MascotasRepositorio;
import edu.cibertec.repositories.SolicitudAdopcionRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class SolicitudController {

    @Autowired
    private SolicitudAdopcionRepository solicitudAdopcionRepository;
    
    @Autowired
    private MascotasRepositorio mascotasRepository;

    @RequestMapping("/solicitud")
    public String mostrarFormularioDeRegistrarSolicitudAdopcion(Model model) {
        SolicitudAdopcion adopcion = new SolicitudAdopcion();
        model.addAttribute("adopcion", adopcion);
        List<SolicitudAdopcion> solicitudes = solicitudAdopcionRepository.findAll();
        model.addAttribute("solicitudes", solicitudes);
        return "solicitud_adopcion";
    }

    @GetMapping("/api/solicitudes")
    @ResponseBody
    public List<SolicitudAdopcion> getAllSolicitudes() {
        return solicitudAdopcionRepository.findAll();
    }

    @GetMapping("/api/solicitudes/{id}")
    @ResponseBody
    public ResponseEntity<SolicitudAdopcion> getSolicitudById(@PathVariable Long id) {
        Optional<SolicitudAdopcion> solicitud = solicitudAdopcionRepository.findById(id);
        return solicitud.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/solicitudes")
    @ResponseBody
    public SolicitudAdopcion createSolicitud(@RequestBody SolicitudAdopcion solicitudAdopcion) {
        return solicitudAdopcionRepository.save(solicitudAdopcion);
    }

    @PutMapping("/api/solicitudes/{id}")
    @ResponseBody
    public ResponseEntity<SolicitudAdopcion> updateSolicitud(@PathVariable Long id, @RequestBody SolicitudAdopcion solicitudActualizada) {
        return solicitudAdopcionRepository.findById(id)
                .map(solicitud -> {
                    solicitud.setNombre(solicitudActualizada.getNombre());
                    solicitud.setEmail(solicitudActualizada.getEmail());
                    solicitud.setTelefono(solicitudActualizada.getTelefono());
                    solicitud.setDireccion(solicitudActualizada.getDireccion());
                    solicitud.setComentarios(solicitudActualizada.getComentarios());
                    solicitudAdopcionRepository.save(solicitud);
                    return ResponseEntity.ok(solicitud);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/api/solicitudes/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteSolicitud(@PathVariable Long id) {
        return solicitudAdopcionRepository.findById(id)
                .map(solicitud -> {
                    solicitudAdopcionRepository.delete(solicitud);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/solicitud/adoptar")
    @ResponseBody
    public ResponseEntity<String> procesarSolicitudAdopcion(@RequestParam("mascota_id") Long mascota_id,
                                            @RequestParam("nombre") String nombre,
                                            @RequestParam("email") String email,
                                            @RequestParam("telefono") int telefono,
                                            @RequestParam("direccion") String direccion,
                                            @RequestParam("comentarios") String comentarios) {
        System.out.println("Mascota ID: " + mascota_id);
        Optional<Mascotas> mascotaOpt = mascotasRepository.findById(mascota_id);
        if (mascotaOpt.isPresent()) {
            Mascotas mascota = mascotaOpt.get();
            SolicitudAdopcion solicitudAdopcion = new SolicitudAdopcion();
            solicitudAdopcion.setNombre(nombre);
            solicitudAdopcion.setEmail(email);
            solicitudAdopcion.setTelefono(telefono);
            solicitudAdopcion.setDireccion(direccion);
            solicitudAdopcion.setComentarios(comentarios);
            solicitudAdopcion.setMascota(mascota);
            solicitudAdopcionRepository.save(solicitudAdopcion);
            return ResponseEntity.ok("Solicitud enviada con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada.");
        }
    }
}
