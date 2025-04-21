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
import logica.claseHorario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class claseHorarioJpaController implements Serializable {

    public claseHorarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public claseHorarioJpaController() {
        emf = Persistence.createEntityManagerFactory("persistenciaUsuarios");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseHorario claseHorario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseHorario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseHorario claseHorario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseHorario = em.merge(claseHorario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseHorario.getId();
                if (findclaseHorario(id) == null) {
                    throw new NonexistentEntityException("The claseHorario with id " + id + " no longer exists.");
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
            claseHorario claseHorario;
            try {
                claseHorario = em.getReference(claseHorario.class, id);
                claseHorario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseHorario with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseHorario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseHorario> findclaseHorarioEntities() {
        return findclaseHorarioEntities(true, -1, -1);
    }

    public List<claseHorario> findclaseHorarioEntities(int maxResults, int firstResult) {
        return findclaseHorarioEntities(false, maxResults, firstResult);
    }

    private List<claseHorario> findclaseHorarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseHorario.class));
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

    public claseHorario findclaseHorario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseHorario.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseHorarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseHorario> rt = cq.from(claseHorario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
