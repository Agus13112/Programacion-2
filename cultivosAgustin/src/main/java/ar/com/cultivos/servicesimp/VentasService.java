package ar.com.cultivos.servicesimp;

import ar.com.cultivos.dao.IVentasDao;
import ar.com.cultivos.entities.Compradores;
import ar.com.cultivos.entities.Ventas;
import ar.com.cultivos.services.IVentasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class VentasService implements IVentasService {
    @Autowired
    private IVentasDao entityDao;

    public List<Ventas> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"fecha"));
    }

    public List<Ventas> findByFecha(LocalDate fecha) {
        return entityDao.findByFecha(fecha);
    }

    // Consulta 4
    public List<Ventas> getAllCompradorfecha(LocalDate dfecha, LocalDate hfecha, Compradores comprador) {
        return entityDao.getAllCompradorfecha(dfecha,hfecha,comprador);
    }

    //Consulta 5
    public double getalltotalventas(LocalDate desdefecha, LocalDate hastafecha, Compradores comprador) {
        return entityDao.getalltotalventas(desdefecha,hastafecha,comprador);
    }

    public Ventas get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Ventas entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Ventas entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
