package ar.com.cultivos.services;

import ar.com.cultivos.entities.Gasto;

import java.util.Date;
import java.util.List;

public interface IGastoService {
    List<Gasto> getAll();
    List<Gasto> findByFecha(Date fecha);
    Gasto get(Integer id);
    void save(Gasto entity);
    String delete(Gasto entity);
}
