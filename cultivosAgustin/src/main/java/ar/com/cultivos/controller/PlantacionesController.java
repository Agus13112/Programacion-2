package ar.com.cultivos.controller;

import ar.com.cultivos.entities.Plantaciones;
import ar.com.cultivos.services.ICultivosService;
import ar.com.cultivos.services.IPlantacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlantacionesController {
    @Autowired
    IPlantacionesService entityService;

    //Inyeccion
    @Autowired
    ICultivosService cultivosService;

    @GetMapping(path = "/plantaciones")
    public List<Plantaciones> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/plantaciones/{id}")
    public Plantaciones get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @GetMapping(path = "/plantaciones/search/{expresion}")
    public List<Plantaciones> getListPlantaciones(@PathVariable String expresion) {
        return entityService.findByName(expresion);
    }

    @PostMapping(value = "/plantaciones", consumes = "application/json", produces = "application/json")
    public Plantaciones save( @RequestBody Plantaciones entity) {
        entityService.save(entity);
        return entity;
    }

    @DeleteMapping("/plantaciones/{id}")
    public String delete(@PathVariable Integer id) {
        try {
            Plantaciones entity = entityService.get(id);
            if(entity != null) {
                entityService.delete(entity);
                return "Plantación eliminada";
            }
            return "No encontrada";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
