package ar.com.cultivos.servicesimp;

import ar.com.cultivos.dao.IGastoDao;
import ar.com.cultivos.entities.Gasto;
import ar.com.cultivos.services.IGastoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;

@Service
public class GastoService implements IGastoService {
    @Autowired
    private IGastoDao entityDao;


    @Override
    public List<Gasto> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "fecha" ));
    }

    @Override
    public List<Gasto> findByFecha(Date fecha) {
        return entityDao.findByFecha(fecha);
    }

    @Override
    public Gasto get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    public void save(Gasto entity) {
        entityDao.save(entity);
    }

    @Override
    public String delete(Gasto entity) {
        try {
            entityDao.delete(entity);
            return null;
        }   catch (Exception e){
            return e.getMessage().toString();
        }
    }
}
