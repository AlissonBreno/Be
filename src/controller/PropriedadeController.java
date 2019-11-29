package controller;

import java.util.List;

import dao.Dao;
import modelo.Apiario;
import modelo.Propriedade;
import modelo.Proprietario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class PropriedadeController {
	
	private Propriedade propriedade = new Propriedade();

	
	public Propriedade getPropriedade() {
		return propriedade;
	}

	public void setPotes(Propriedade propriedade) {
		this.propriedade = propriedade;
	}
	public void gravar() {
		if(propriedade.getId() == null)
			new Dao<Propriedade>(Propriedade.class).adiciona(propriedade);
		else
			new Dao<Propriedade>(Propriedade.class).atualiza(propriedade);
			propriedade = new Propriedade();
	}
	public List<Propriedade> getTodosPropriedades(){
		return new Dao<Propriedade>(Propriedade.class).buscaTodos();
	}
	public List<Propriedade> getTodosTiposPropriedades(){
		return new Dao<Propriedade>(Propriedade.class).buscaTodos();
	}
	public List<Proprietario> getTodosProprietarios(){
		return new Dao<Proprietario>(Proprietario.class).buscaTodos();
	}
	public void remover(Propriedade t) {
		new Dao<Propriedade>(Propriedade.class).remove(t.getId());
	}
	public void carregar(Propriedade t) {
		propriedade = t;
	}
}
