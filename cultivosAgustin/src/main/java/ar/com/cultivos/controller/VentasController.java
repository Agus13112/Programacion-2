package ar.com.cultivos.controller;

import ar.com.cultivos.entities.Compradores;
import ar.com.cultivos.entities.Ventas;
import ar.com.cultivos.services.ICompradoresService;
import ar.com.cultivos.services.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VentasController {

    @Autowired
    IVentasService entityService;
    //Inyecccion
    @Autowired
    ICompradoresService compradoresService;

    @GetMapping(path = "/ventas")
    public List<Ventas> getAll() {return entityService.getAll();}

    @GetMapping(path = "/ventas/{id}")
    public Ventas get(@PathVariable Integer id) {return entityService.get(id);}

    @GetMapping(path = "/ventas/search/{fecha}")
    public List<Ventas> getListGastos(@PathVariable LocalDate fecha) {return entityService.findByFecha(fecha);}

    @PostMapping(value = "/ventas", consumes = "application/json", produces = "application/json")
    public Ventas save(@RequestBody Ventas entity) {
        entityService.save(entity);
        return entity;
    }

    @DeleteMapping (path = "/ventas/{id}")
    public String delete(@PathVariable Integer id) {
        Ventas entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return "Venta eliminada correctamente";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }
    @GetMapping(path = "/ventas/getallcompradorfecha/{dfecha}/{hfecha}/{comprador}")
    public List<Ventas> getAllCompradorFecha(
            @PathVariable("dfecha") LocalDate dfecha,
            @PathVariable("hfecha") LocalDate hfecha,
            @PathVariable("comprador") Integer compradorId) {
        // Obtener el comprador a partir de su ID usando el servicio de compradores
        Compradores comprador = compradoresService.get(compradorId);

        // Llamar al servicio de ventas para obtener las ventas filtradas
        return entityService.getAllCompradorfecha(dfecha, hfecha, comprador);
    }

        @GetMapping(path = "/ventas/totalventas/{dfecha}/{hfecha}/{comprador}")
        public double getTotalVentas (
                @PathVariable("dfecha") LocalDate dfecha,
                @PathVariable("hfecha") LocalDate hfecha,
                @PathVariable("comprador") Integer compradorId){
            // Obtener el comprador a partir de su ID usando el servicio de compradores
            Compradores comprador = compradoresService.get(compradorId);

            // Llamar al método del servicio de ventas para obtener el total
            return entityService.getalltotalventas(dfecha, hfecha, comprador);
        }
}
