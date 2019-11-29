package controller;

import java.util.List;

import dao.Dao;
import modelo.Potes_mel;
import modelo.Proprietario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class ProprietarioController {
	
	private Proprietario proprietario = new Proprietario();

	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setPotes(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public void gravar() {
		if(proprietario.getId() == null)
			new Dao<Proprietario>(Proprietario.class).adiciona(proprietario);
		else
			new Dao<Proprietario>(Proprietario.class).atualiza(proprietario);
			proprietario = new Proprietario();
	}
	public List<Proprietario> getTodosProprietarios(){
		return new Dao<Proprietario>(Proprietario.class).buscaTodos();
	}
	public void remover(Proprietario t) {
		new Dao<Proprietario>(Proprietario.class).remove(t.getId());
	}
	public void carregar(Proprietario t) {
		proprietario = t;
	}
}
