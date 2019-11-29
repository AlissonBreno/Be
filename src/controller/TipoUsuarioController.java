package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Dao;
import modelo.Tipo_Usuario;

@ManagedBean
@ViewScoped
public class TipoUsuarioController {
private Tipo_Usuario tipousuario = new Tipo_Usuario();
	
	public Tipo_Usuario getTipoUsuario() {
		return tipousuario;
	}

	public void setTipoUsuario(Tipo_Usuario tipousuario) {
		this.tipousuario = tipousuario;
	}
	public void gravar() {
		if(tipousuario.getId() == null)
			new Dao<Tipo_Usuario>(Tipo_Usuario.class).adiciona(tipousuario);
		else
			new Dao<Tipo_Usuario>(Tipo_Usuario.class).atualiza(tipousuario);
			tipousuario = new Tipo_Usuario();
	}
	public List<Tipo_Usuario> getTodosTipoUsuario(){
		return new Dao<Tipo_Usuario>(Tipo_Usuario.class).buscaTodos();
	}

	public void remover(Tipo_Usuario t) {
		new Dao<Tipo_Usuario>(Tipo_Usuario.class).remove(t.getId());
	}
	public void carregar(Tipo_Usuario t) {
		tipousuario = t;
	}
}
