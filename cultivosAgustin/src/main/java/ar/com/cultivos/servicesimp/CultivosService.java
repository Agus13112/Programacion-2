package ar.com.cultivos.servicesimp;

import ar.com.cultivos.dao.ICultivosDao;
import ar.com.cultivos.entities.Cultivos;
import ar.com.cultivos.services.ICultivosService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CultivosService implements ICultivosService {

    @Autowired
    private ICultivosDao entityDao;

    public List<Cultivos> getAll(){
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"descrip"));
    }

    public List<Cultivos> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    public Cultivos get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Cultivos entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Cultivos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
