package ar.com.cultivos.dao;

import ar.com.cultivos.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IGastoDao extends JpaRepository<Gasto, Integer> {
    @Query("select c from Gasto c where c.fecha = ?1")
    public List<Gasto> findByFecha(Date fecha);
}
