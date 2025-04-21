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
import logica.claseUsuariosOdon;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class claseUsuariosOdonJpaController implements Serializable {

    public claseUsuariosOdonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public claseUsuariosOdonJpaController() {
        emf = Persistence.createEntityManagerFactory("persistenciaUsuarios");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseUsuariosOdon claseUsuariosOdon) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseUsuariosOdon);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseUsuariosOdon claseUsuariosOdon) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseUsuariosOdon = em.merge(claseUsuariosOdon);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseUsuariosOdon.getId();
                if (findclaseUsuariosOdon(id) == null) {
                    throw new NonexistentEntityException("The claseUsuariosOdon with id " + id + " no longer exists.");
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
            claseUsuariosOdon claseUsuariosOdon;
            try {
                claseUsuariosOdon = em.getReference(claseUsuariosOdon.class, id);
                claseUsuariosOdon.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseUsuariosOdon with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseUsuariosOdon);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseUsuariosOdon> findclaseUsuariosOdonEntities() {
        return findclaseUsuariosOdonEntities(true, -1, -1);
    }

    public List<claseUsuariosOdon> findclaseUsuariosOdonEntities(int maxResults, int firstResult) {
        return findclaseUsuariosOdonEntities(false, maxResults, firstResult);
    }

    private List<claseUsuariosOdon> findclaseUsuariosOdonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseUsuariosOdon.class));
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

    public claseUsuariosOdon findclaseUsuariosOdon(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseUsuariosOdon.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseUsuariosOdonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseUsuariosOdon> rt = cq.from(claseUsuariosOdon.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
