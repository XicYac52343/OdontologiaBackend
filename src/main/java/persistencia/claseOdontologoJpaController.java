/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.claseOdontologo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class claseOdontologoJpaController implements Serializable {

    public claseOdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public claseOdontologoJpaController() {
        emf = Persistence.createEntityManagerFactory("persistenciaUsuarios");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseOdontologo claseOdontologo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseOdontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseOdontologo claseOdontologo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseOdontologo = em.merge(claseOdontologo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseOdontologo.getId();
                if (findclaseOdontologo(id) == null) {
                    throw new NonexistentEntityException("The claseOdontologo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseOdontologo claseOdontologo;
            try {
                claseOdontologo = em.getReference(claseOdontologo.class, id);
                claseOdontologo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseOdontologo with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseOdontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseOdontologo> findclaseOdontologoEntities() {
        return findclaseOdontologoEntities(true, -1, -1);
    }

    public List<claseOdontologo> findclaseOdontologoEntities(int maxResults, int firstResult) {
        return findclaseOdontologoEntities(false, maxResults, firstResult);
    }

    private List<claseOdontologo> findclaseOdontologoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseOdontologo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public claseOdontologo findclaseOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseOdontologo.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseOdontologoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseOdontologo> rt = cq.from(claseOdontologo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
