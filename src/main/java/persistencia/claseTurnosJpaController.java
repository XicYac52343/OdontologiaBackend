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
import logica.clasePacientes;
import logica.claseTurnos;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class claseTurnosJpaController implements Serializable {

    public claseTurnosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public claseTurnosJpaController() {
        emf = Persistence.createEntityManagerFactory("persistenciaUsuarios");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseTurnos claseTurnos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseOdontologo unOdontologo = claseTurnos.getUnOdontologo();
            if (unOdontologo != null) {
                unOdontologo = em.getReference(unOdontologo.getClass(), unOdontologo.getId());
                claseTurnos.setUnOdontologo(unOdontologo);
            }
            clasePacientes unPaciente = claseTurnos.getUnPaciente();
            if (unPaciente != null) {
                unPaciente = em.getReference(unPaciente.getClass(), unPaciente.getId());
                claseTurnos.setUnPaciente(unPaciente);
            }
            em.persist(claseTurnos);
            if (unOdontologo != null) {
                unOdontologo.getListaTurnos().add(claseTurnos);
                unOdontologo = em.merge(unOdontologo);
            }
            if (unPaciente != null) {
                unPaciente.getListaTurnos().add(claseTurnos);
                unPaciente = em.merge(unPaciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseTurnos claseTurnos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseTurnos persistentclaseTurnos = em.find(claseTurnos.class, claseTurnos.getId());
            claseOdontologo unOdontologoOld = persistentclaseTurnos.getUnOdontologo();
            claseOdontologo unOdontologoNew = claseTurnos.getUnOdontologo();
            clasePacientes unPacienteOld = persistentclaseTurnos.getUnPaciente();
            clasePacientes unPacienteNew = claseTurnos.getUnPaciente();
            if (unOdontologoNew != null) {
                unOdontologoNew = em.getReference(unOdontologoNew.getClass(), unOdontologoNew.getId());
                claseTurnos.setUnOdontologo(unOdontologoNew);
            }
            if (unPacienteNew != null) {
                unPacienteNew = em.getReference(unPacienteNew.getClass(), unPacienteNew.getId());
                claseTurnos.setUnPaciente(unPacienteNew);
            }
            claseTurnos = em.merge(claseTurnos);
            if (unOdontologoOld != null && !unOdontologoOld.equals(unOdontologoNew)) {
                unOdontologoOld.getListaTurnos().remove(claseTurnos);
                unOdontologoOld = em.merge(unOdontologoOld);
            }
            if (unOdontologoNew != null && !unOdontologoNew.equals(unOdontologoOld)) {
                unOdontologoNew.getListaTurnos().add(claseTurnos);
                unOdontologoNew = em.merge(unOdontologoNew);
            }
            if (unPacienteOld != null && !unPacienteOld.equals(unPacienteNew)) {
                unPacienteOld.getListaTurnos().remove(claseTurnos);
                unPacienteOld = em.merge(unPacienteOld);
            }
            if (unPacienteNew != null && !unPacienteNew.equals(unPacienteOld)) {
                unPacienteNew.getListaTurnos().add(claseTurnos);
                unPacienteNew = em.merge(unPacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseTurnos.getId();
                if (findclaseTurnos(id) == null) {
                    throw new NonexistentEntityException("The claseTurnos with id " + id + " no longer exists.");
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
            claseTurnos claseTurnos;
            try {
                claseTurnos = em.getReference(claseTurnos.class, id);
                claseTurnos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseTurnos with id " + id + " no longer exists.", enfe);
            }
            claseOdontologo unOdontologo = claseTurnos.getUnOdontologo();
            if (unOdontologo != null) {
                unOdontologo.getListaTurnos().remove(claseTurnos);
                unOdontologo = em.merge(unOdontologo);
            }
            clasePacientes unPaciente = claseTurnos.getUnPaciente();
            if (unPaciente != null) {
                unPaciente.getListaTurnos().remove(claseTurnos);
                unPaciente = em.merge(unPaciente);
            }
            em.remove(claseTurnos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseTurnos> findclaseTurnosEntities() {
        return findclaseTurnosEntities(true, -1, -1);
    }

    public List<claseTurnos> findclaseTurnosEntities(int maxResults, int firstResult) {
        return findclaseTurnosEntities(false, maxResults, firstResult);
    }

    private List<claseTurnos> findclaseTurnosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseTurnos.class));
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

    public claseTurnos findclaseTurnos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseTurnos.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseTurnosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseTurnos> rt = cq.from(claseTurnos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
