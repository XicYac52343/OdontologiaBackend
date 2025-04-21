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
import logica.claseSecretaria;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class claseSecretariaJpaController implements Serializable {

    public claseSecretariaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public claseSecretariaJpaController() {
        emf = Persistence.createEntityManagerFactory("persistenciaUsuarios");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseSecretaria claseSecretaria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseSecretaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseSecretaria claseSecretaria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseSecretaria = em.merge(claseSecretaria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseSecretaria.getId();
                if (findclaseSecretaria(id) == null) {
                    throw new NonexistentEntityException("The claseSecretaria with id " + id + " no longer exists.");
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
            claseSecretaria claseSecretaria;
            try {
                claseSecretaria = em.getReference(claseSecretaria.class, id);
                claseSecretaria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseSecretaria with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseSecretaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseSecretaria> findclaseSecretariaEntities() {
        return findclaseSecretariaEntities(true, -1, -1);
    }

    public List<claseSecretaria> findclaseSecretariaEntities(int maxResults, int firstResult) {
        return findclaseSecretariaEntities(false, maxResults, firstResult);
    }

    private List<claseSecretaria> findclaseSecretariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseSecretaria.class));
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

    public claseSecretaria findclaseSecretaria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseSecretaria.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseSecretariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseSecretaria> rt = cq.from(claseSecretaria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
