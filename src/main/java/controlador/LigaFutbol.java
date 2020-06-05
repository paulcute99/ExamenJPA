/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.Entrenador;
import modelo.Equipo;

/**
 *
 * @author Paul
 */
public class LigaFutbol {

    /**
     * Crea un equipo con los datos pasados por consola
     *
     * @param datosEquipo
     */
    public void crearEquipo(Entrenador datosEquipo) {
        EntityManagerFactory managerFactory = null;
        EntityManager manager = null;
        try {
            managerFactory = Persistence.createEntityManagerFactory("LIGA");
            manager = managerFactory.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(datosEquipo);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            manager.close();
        }

    }

    /**
     * Elimina el equipo donde el nombre es Real Betis
     *
     * @param nombreEquipo
     */
    public void eliminarEquipo(short nombreEquipo) {
        EntityManagerFactory managerFactory = null;
        EntityManager manager = null;
        try {
            managerFactory = Persistence.createEntityManagerFactory("LIGA");
            manager = managerFactory.createEntityManager();
            manager.getTransaction().begin();

            Equipo equipoBorrar = manager.find(Equipo.class, nombreEquipo);

            manager.remove(equipoBorrar);

            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            manager.close();
        }

    }

    /**
     * Obtiene todos los datos de los equipos que tengan mas de 50000 socios
     *
     * @param socios
     * @return devuelve una lista con todos los equipos
     */
    public List<Equipo> filtroPorSocios(int socios) {
        List<Equipo> equipos = new ArrayList();
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("LIGA");
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();

        TypedQuery<Equipo> query = manager.createQuery(
                " Select e from Equipo e WHERE  e.num_socios >= :socios", Equipo.class);
        query.setParameter("socios", socios);
        equipos = query.getResultList();
        return equipos;
    }

    /**
     * Obtiene el entrenador que depende del entrenador Zinedine Zidane
     *
     * @param entrenador
     * @return devuelve una lista con los entrenadores que depende de Zinedine
     * Zidane”
     */
    public List<Entrenador> filtroPorEntrenador(String entrenador) {
        List<Entrenador> entrenadores = new ArrayList();
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("LIGA");
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Entrenador> query = manager.createQuery(
                " Select e from Entrenador e WHERE  e.depende_de = (select e.cod_entrenador from Entrenador e WHERE e.nombre = :entrenador)", Entrenador.class);
        query.setParameter("entrenador", entrenador);
        entrenadores = query.getResultList();

        return entrenadores;

    }

}
