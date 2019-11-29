package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import dao.Dao;
import modelo.Tipo_Propriedade;
@ManagedBean
@ViewScoped
public class Tipo_PropriedadeController {

	private Tipo_Propriedade tipopropriedade = new Tipo_Propriedade();

	
	public Tipo_Propriedade getTipo_Propriedade() {
		return tipopropriedade;
	}

	public void setPropriedade(Tipo_Propriedade tipopropriedade) {
		this.tipopropriedade = tipopropriedade;
	}
	public void gravar() {
		if(tipopropriedade.getId() == null)
			new Dao<Tipo_Propriedade>(Tipo_Propriedade.class).adiciona(tipopropriedade);
		else
			new Dao<Tipo_Propriedade>(Tipo_Propriedade.class).atualiza(tipopropriedade);
		tipopropriedade = new Tipo_Propriedade();
	}
	public List<Tipo_Propriedade> getTodosTiposPropriedade(){
		return new Dao<Tipo_Propriedade>(Tipo_Propriedade.class).buscaTodos();
	}
	public void remover(Tipo_Propriedade t) {
		new Dao<Tipo_Propriedade>(Tipo_Propriedade.class).remove(t.getId());
	}
	public void carregar(Tipo_Propriedade t) {
		tipopropriedade = t;
	}
}
