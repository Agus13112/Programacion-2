package ar.com.cultivos.controller;

import ar.com.cultivos.entities.Cosechas;
import ar.com.cultivos.services.ICosechasService;
import ar.com.cultivos.services.ICultivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CosechasController {
    @Autowired
    ICosechasService entityService;

    @GetMapping(path = "/cosechas")
    public List<Cosechas> getAll() {return entityService.getAll();}

    @GetMapping(path = "/cosechas/{id}")
    public Cosechas get(@PathVariable Integer id) {return entityService.get(id);}

    @GetMapping(path = "/cosechas/search/{expresion}")
    public List<Cosechas> getListCosechas(@PathVariable Date expresion) {return entityService.findByFecha(expresion);}

    @PostMapping(value = "/cosechas", consumes = "application/json", produces = "application/json")
    public Cosechas save(@RequestBody Cosechas entity) {
        entityService.save(entity);
        return entity;
    }

    @DeleteMapping (path = "/cosechas/{id}")
    public String delete(@PathVariable Integer id) {
        Cosechas entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return "Cosecha eliminada correctamente";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }
}
