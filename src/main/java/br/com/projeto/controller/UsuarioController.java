package br.com.projeto.controller;

import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.model.Usuario;
import jakarta.annotation.ManagedBean;

@ManagedBean
@ViewScoped
public class UsuarioController {

    @ManagedProperty("#{usuarioDAO}")
    private UsuarioDAO usuarioDAO;
    
    private List<Usuario> usuarios;
    private Usuario novoUsuario = new Usuario();

    public String navegarParaAdicionarEditar() {
        return "adicionarEditarUsuario.xhtml";
    }

    public String navegarParaListar() {
        return "listarUsuarios.xhtml";
    }
    
    public String navegarParaGerenciar() {
        return "gerenciarUsuarios.xhtml";
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = usuarioDAO.listarUsuarios();
        }
        return usuarios;
    }

    public void adicionarUsuario() {
        usuarioDAO.adicionarUsuario(novoUsuario);
        novoUsuario = new Usuario();
        usuarios = null; // Força recarregamento da lista após adição.
    }

    public void editarUsuario(Usuario usuario) {
        usuarioDAO.editarUsuario(usuario);
        usuarios = null; // Força recarregamento da lista após edição.
    }

    public void excluirUsuario(Usuario usuario) {
        usuarioDAO.excluirUsuario(usuario);
        usuarios = null; // Força recarregamento da lista após exclusão.
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
