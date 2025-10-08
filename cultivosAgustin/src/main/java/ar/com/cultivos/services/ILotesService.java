package ar.com.cultivos.services;

import ar.com.cultivos.entities.Lotes;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ILotesService {
    List<Lotes> getAll();
    List<Lotes> findByDescrip(String descrip);
    Lotes get(Integer id);
    void save(Lotes entity);
    String delete(Lotes entity);
}
