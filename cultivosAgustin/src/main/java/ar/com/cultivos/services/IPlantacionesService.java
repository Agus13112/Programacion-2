package ar.com.cultivos.services;

import ar.com.cultivos.entities.Cultivos;
import ar.com.cultivos.entities.Plantaciones;

import java.time.LocalDate;
import java.util.List;

public interface IPlantacionesService {
    List<Plantaciones> getAll();

    List<Plantaciones> findByName(String nombre);
    List<Plantaciones> getAllPlantaciones(String periodo);
    List<Plantaciones> getAllPlantacionesFecha (LocalDate dfecha, LocalDate hfecha);
    List<Plantaciones> getAllPeriodoCultivo(String periodo, Cultivos cultivo);

    Plantaciones get(Integer id);
    void save(Plantaciones entity);
    String delete(Plantaciones entity);
}
