package ar.com.cultivos.servicesimp;

import ar.com.cultivos.dao.IPlantacionesDao;
import ar.com.cultivos.entities.Cultivos;
import ar.com.cultivos.entities.Plantaciones;
import ar.com.cultivos.services.IPlantacionesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlantacionesService implements IPlantacionesService {

    @Autowired
    private IPlantacionesDao entityDao;

    @Override
    public List<Plantaciones> getAll() {return entityDao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));}

    @Override
    public List<Plantaciones> findByName(String nombre) { return entityDao.findByName("%" + nombre + "%");}

    //Consulta 1
    @Override
    public List<Plantaciones> getAllPlantaciones(String periodo) {
        return entityDao.getAllPlantaciones(periodo) ;
    }

    //consulta 2
    @Override
    public List<Plantaciones> getAllPlantacionesFecha(LocalDate dfecha, LocalDate hfecha) {
        return entityDao.getAllPlantacionesFecha(dfecha,hfecha);
    }

    // consulta 3
    @Override
    public List<Plantaciones> getAllPeriodoCultivo(String periodo, Cultivos cultivo) {
        return entityDao.getAllPeriodoCultivo(periodo,cultivo);
    }

    @Override
    public Plantaciones get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Plantaciones entity) {
        entityDao.save(entity);

    }

    @Override
    @Transactional
    public String delete(Plantaciones entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
