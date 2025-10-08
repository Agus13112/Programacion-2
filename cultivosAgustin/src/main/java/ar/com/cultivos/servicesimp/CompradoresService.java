package ar.com.cultivos.servicesimp;

import ar.com.cultivos.dao.ICompradoresDao;
import ar.com.cultivos.entities.Compradores;
import ar.com.cultivos.services.ICompradoresService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradoresService implements ICompradoresService {

    @Autowired
    public ICompradoresDao entityDao;

    @Override
    public List<Compradores> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    @Override
    public List<Compradores> findByName(String nombre) {
        return entityDao.findByName("%" + nombre + "%");
    }

    @Override
    public Compradores get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Compradores entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public void delete(Compradores entity) {
        entityDao.delete(entity);
    }
}
