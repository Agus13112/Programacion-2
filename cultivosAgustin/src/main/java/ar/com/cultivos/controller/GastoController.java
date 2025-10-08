package ar.com.cultivos.controller;

import ar.com.cultivos.entities.Gasto;
import ar.com.cultivos.services.IGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GastoController {
    @Autowired
    IGastoService entityService;

    @GetMapping(path = "/gasto")
    public List<Gasto> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/gasto/{id}")
    public Gasto get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @GetMapping(path = "/gasto/search/{expresion}")
    public List<Gasto> getListGasto(@PathVariable Date expresion){
        return entityService.findByFecha(expresion);
    }

    @PostMapping(value = "/gasto", consumes = "application/json", produces = "aplication/json")
    public Gasto save(@RequestBody Gasto entity){
        entityService.save(entity);
        return entity;
    }

    @DeleteMapping(path = "/gasto/{id}")
    public String delete(@PathVariable Integer id){
        Gasto entity = null;
        try{
            entity = entityService.get(id);
            entityService.delete(entity);
            return "Gasto eliminado";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }
}
