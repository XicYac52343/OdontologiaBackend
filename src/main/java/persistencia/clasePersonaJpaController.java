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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.clasePersona;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class clasePersonaJpaController implements Serializable {

    public clasePersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(clasePersona clasePersona) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clasePersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(clasePersona clasePersona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clasePersona = em.merge(clasePersona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = clasePersona.getId();
                if (findclasePersona(id) == null) {
                    throw new NonexistentEntityException("The clasePersona with id " + id + " no longer exists.");
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
            clasePersona clasePersona;
            try {
                clasePersona = em.getReference(clasePersona.class, id);
                clasePersona.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clasePersona with id " + id + " no longer exists.", enfe);
            }
            em.remove(clasePersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<clasePersona> findclasePersonaEntities() {
        return findclasePersonaEntities(true, -1, -1);
    }

    public List<clasePersona> findclasePersonaEntities(int maxResults, int firstResult) {
        return findclasePersonaEntities(false, maxResults, firstResult);
    }

    private List<clasePersona> findclasePersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clasePersona.class));
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

    public clasePersona findclasePersona(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(clasePersona.class, id);
        } finally {
            em.close();
        }
    }

    public int getclasePersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<clasePersona> rt = cq.from(clasePersona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
