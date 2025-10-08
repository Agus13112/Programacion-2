package ar.com.cultivos.services;

import ar.com.cultivos.entities.Compradores;

import java.util.List;

public interface ICompradoresService {

    List<Compradores> getAll();
    List<Compradores> findByName(String nombre);
    Compradores get(Integer id);
    void save(Compradores entity);
    void delete(Compradores entity);
}
