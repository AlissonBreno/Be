package controller;

import java.util.List;

import dao.Dao;
import modelo.Apiario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ApiarioController {
	
	private Apiario apiario = new Apiario();

	
	public Apiario getApiario() {
		return apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	public void gravar() {
		if(apiario.getId() == null)
			new Dao<Apiario>(Apiario.class).adiciona(apiario);
		else
			new Dao<Apiario>(Apiario.class).atualiza(apiario);
		apiario = new Apiario();
	}
	public List<Apiario>getTodosApiario(){
		return new Dao<Apiario>(Apiario.class).buscaTodos();
	}
	public void remover(Apiario t) {
		new Dao<Apiario>(Apiario.class).remove(t.getId());
	}
	public void carregar(Apiario t) {
		apiario = t;
	}
}
