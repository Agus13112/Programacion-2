package ar.com.cultivos.servicesimp;

import ar.com.cultivos.dao.ICosechasDao;
import ar.com.cultivos.entities.Cosechas;
import ar.com.cultivos.services.ICosechasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CosechasService implements ICosechasService {

    @Autowired
    private ICosechasDao entityDao;  // Inyección del repositorio JPA

    // Obtiene todas las cosechas ordenadas por fecha (ascendente)
    @Override
    public List<Cosechas> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "fecha"));
    }

    // Busca cosechas por fecha exacta
    @Override
    public List<Cosechas> findByFecha(Date fecha) {
        return entityDao.findByFecha(fecha);
    }

    // Obtiene una cosecha por ID (retorna Optional para manejar nulls)
    @Override
    public Cosechas get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    // Guarda una cosecha (transaccional)
    @Transactional
    @Override
    public void save(Cosechas entity) {
        entityDao.save(entity);
    }

    @Transactional
    @Override
    public void delete(Cosechas entity) {
        entityDao.delete(entity);
    }
}