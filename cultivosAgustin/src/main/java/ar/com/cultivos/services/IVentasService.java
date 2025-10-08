package ar.com.cultivos.services;

import ar.com.cultivos.entities.Compradores;
import ar.com.cultivos.entities.Ventas;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IVentasService {
    List<Ventas> getAll();
    List<Ventas> findByFecha(LocalDate fecha);

    //Consulta
    List<Ventas> getAllCompradorfecha (LocalDate dfecha, LocalDate hfecha, Compradores comprador);

    //Consulta
    double getalltotalventas (LocalDate desdefecha, LocalDate hastafecha, Compradores comprador);
    Ventas get(Integer id);
    void save(Ventas entity);
    String delete(Ventas entity);
}
