package ar.com.cultivos.services;

import ar.com.cultivos.entities.Cosechas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ICosechasService{
    List<Cosechas> getAll();
    List<Cosechas> findByFecha(Date fecha);
    Cosechas get(Integer id);
    void save(Cosechas entity);
    void delete(Cosechas entity);
}
