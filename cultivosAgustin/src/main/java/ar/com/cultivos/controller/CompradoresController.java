package ar.com.cultivos.controller;

import ar.com.cultivos.entities.Compradores;
import ar.com.cultivos.services.ICompradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompradoresController {
    @Autowired
    ICompradoresService entityService;

    @GetMapping(path = "/compradores")
    public List<Compradores> getAll() {return entityService.getAll();}

    @GetMapping(path = "/compradores/{id}")
    public Compradores get(@PathVariable Integer id)
    {return entityService.get(id);}

    @GetMapping(path = "/compradores/search/{expresion}")
    public List<Compradores> getListCompradores(@PathVariable String expresion)
    {return entityService.findByName(expresion);}

    @PostMapping(value = "/compradores", consumes = "application/json", produces = "application/json")
    public Compradores save(@RequestBody Compradores entity) {
        entityService.save(entity);
        return entity;
    }

    @DeleteMapping(path = "/compradores/{id}")
    public String delete(@PathVariable Integer id) {
        try {
            Compradores entity = entityService.get(id);
            if (entity != null) {
                entityService.delete(entity);
                return "Comprador eliminado correctamente";
            }
            return "Comprador no encontrado";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
