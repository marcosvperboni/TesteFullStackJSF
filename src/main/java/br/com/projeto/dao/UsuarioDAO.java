package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UsuarioDAO {

    @PersistenceContext(unitName = "PU_NAME")
    private EntityManager em;

    public List<Usuario> listarUsuarios() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public void adicionarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    public void editarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
}
