package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Dao;
import modelo.Proprietario;
import modelo.Tipo_Usuario;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioController {
private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void gravar() {
		if(usuario.getId() == null)
			new Dao<Usuario>(Usuario.class).adiciona(usuario);
		else
			new Dao<Usuario>(Usuario.class).atualiza(usuario);
			usuario = new Usuario();
	}
	public List<Usuario> getTodosUsuarios(){
		return new Dao<Usuario>(Usuario.class).buscaTodos();
	}
	public List<Tipo_Usuario> getTodosTiposUsu(){
		return new Dao<Tipo_Usuario>(Tipo_Usuario.class).buscaTodos();
	}
	public void remover(Usuario t) {
		new Dao<Usuario>(Usuario.class).remove(t.getId());
	}
	public void carregar(Usuario t) {
		usuario = t;
	}	
}
