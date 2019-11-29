package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import dao.Dao;
import modelo.Tipo_Mel;
@ManagedBean
@ViewScoped
public class TipomelController {

	private Tipo_Mel tipomel = new Tipo_Mel();

	
	public Tipo_Mel getTipo_Mel() {
		return tipomel;
	}

	public void setApiario(Tipo_Mel tipomel) {
		this.tipomel = tipomel;
	}
	public void gravar() {
		if(tipomel.getId() == null)
			new Dao<Tipo_Mel>(Tipo_Mel.class).adiciona(tipomel);
		else
			new Dao<Tipo_Mel>(Tipo_Mel.class).atualiza(tipomel);
		tipomel = new Tipo_Mel();
	}
	public List<Tipo_Mel> getTodosTiposMel(){
		return new Dao<Tipo_Mel>(Tipo_Mel.class).buscaTodos();
	}
	public void remover(Tipo_Mel t) {
		new Dao<Tipo_Mel>(Tipo_Mel.class).remove(t.getId());
	}
	public void carregar(Tipo_Mel t) {
		tipomel = t;
	}
}
