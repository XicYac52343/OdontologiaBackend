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
import logica.clasePacientes;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class clasePacientesJpaController implements Serializable {

    public clasePacientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public clasePacientesJpaController() {
        emf = Persistence.createEntityManagerFactory("persistenciaUsuarios");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(clasePacientes clasePacientes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clasePacientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(clasePacientes clasePacientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clasePacientes = em.merge(clasePacientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = clasePacientes.getId();
                if (findclasePacientes(id) == null) {
                    throw new NonexistentEntityException("The clasePacientes with id " + id + " no longer exists.");
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
            clasePacientes clasePacientes;
            try {
                clasePacientes = em.getReference(clasePacientes.class, id);
                clasePacientes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clasePacientes with id " + id + " no longer exists.", enfe);
            }
            em.remove(clasePacientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<clasePacientes> findclasePacientesEntities() {
        return findclasePacientesEntities(true, -1, -1);
    }

    public List<clasePacientes> findclasePacientesEntities(int maxResults, int firstResult) {
        return findclasePacientesEntities(false, maxResults, firstResult);
    }

    private List<clasePacientes> findclasePacientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clasePacientes.class));
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

    public clasePacientes findclasePacientes(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(clasePacientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getclasePacientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<clasePacientes> rt = cq.from(clasePacientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
