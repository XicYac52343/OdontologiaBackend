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
import logica.claseResponsable;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class claseResponsableJpaController implements Serializable {

    public claseResponsableJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public claseResponsableJpaController() {
        emf = Persistence.createEntityManagerFactory("persistenciaUsuarios");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseResponsable claseResponsable) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseResponsable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseResponsable claseResponsable) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseResponsable = em.merge(claseResponsable);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseResponsable.getId();
                if (findclaseResponsable(id) == null) {
                    throw new NonexistentEntityException("The claseResponsable with id " + id + " no longer exists.");
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
            claseResponsable claseResponsable;
            try {
                claseResponsable = em.getReference(claseResponsable.class, id);
                claseResponsable.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseResponsable with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseResponsable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseResponsable> findclaseResponsableEntities() {
        return findclaseResponsableEntities(true, -1, -1);
    }

    public List<claseResponsable> findclaseResponsableEntities(int maxResults, int firstResult) {
        return findclaseResponsableEntities(false, maxResults, firstResult);
    }

    private List<claseResponsable> findclaseResponsableEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseResponsable.class));
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

    public claseResponsable findclaseResponsable(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseResponsable.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseResponsableCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseResponsable> rt = cq.from(claseResponsable.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
