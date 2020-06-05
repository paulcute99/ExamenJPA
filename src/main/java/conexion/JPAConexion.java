/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Paul
 */
public class JPAConexion {
    
    private final String NOMBRE_PERSISTENCIA = "LIGA";
    private EntityManager manager;
    private EntityManagerFactory managerFactory;
    private static JPAConexion conex;

    private JPAConexion() {
        managerFactory = Persistence.createEntityManagerFactory(NOMBRE_PERSISTENCIA);

    }

    public EntityManager getEntityManager() {
        return manager = managerFactory.createEntityManager();
    }

    public static JPAConexion getInstance() {
        if (conex == null) {
            conex = new JPAConexion();
        } else if (!(conex.getEntityManager().isOpen())) {
            conex = new JPAConexion();
        }

        return conex;
    }
}
