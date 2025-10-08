package ar.com.cultivos.services;

import ar.com.cultivos.entities.Cultivos;

import java.util.List;

public interface ICultivosService {
    List<Cultivos> getAll();
    Cultivos get(Integer id);
    List<Cultivos> findByDescrip (String descrip);
    void save(Cultivos entity);
    String delete(Cultivos entity);
}
