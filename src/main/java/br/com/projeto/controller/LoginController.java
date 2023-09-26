package br.com.projeto.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginController {

    private String username;
    private String password;

    @ManagedProperty("#{usuarioController}")
    private UsuarioController usuarioController;

    public String login() {
        // Aqui você pode adicionar a lógica de validação do usuário.
        // Por exemplo, verificar no banco de dados se o usuário e senha são válidos.
        // Se for válido, redirecione para a página de gerenciamento de usuários.
        if (username.equals("admin") && password.equals("admin")) {
            return usuarioController.navegarParaGerenciar();
        }
        
        // Caso contrário, exiba uma mensagem de erro ou faça o que for apropriado no seu caso.
        return null;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioController getUsuarioController() {
		return usuarioController;
	}

	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}
}
