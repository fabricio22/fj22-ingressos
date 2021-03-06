package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

/**
 * Created by nando on 03/03/17.
 */
@Repository
public class SalaDao {

    @PersistenceContext
    private EntityManager manager;
    
    public void save(Sessao sessao) {
    	manager.persist(sessao);
    }

    public Sala findOne(Integer id) {

        return manager.find(Sala.class, id);
    }

    public void save(Sala sala) {
        manager.merge(sala);
    }

    public List<Sala> findAll() {
        return manager.createQuery("select s from Sala s", Sala.class).getResultList();
    }

    public void delete(Integer id) {
        manager.remove(findOne(id));
    }
    
    public List<Sessao> buscaSessoesDaSala(Sala sala){
    	return manager.createQuery("select s from sessao s where s.sala = :sala", Sessao.class).setParameter("sala", sala).getResultList();
    }
}
