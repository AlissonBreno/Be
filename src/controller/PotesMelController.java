package controller;

import java.util.List;

import dao.Dao;
import modelo.Potes_mel;
import modelo.Proprietario;
import modelo.Tipo_Mel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class PotesMelController {
	private Potes_mel potesmel = new Potes_mel();
	private Integer FornecedorId, Tipos_MelID;
	public Potes_mel getPotesmel() {
		return potesmel;
	}

	public Integer getFornecedorId() {
		return FornecedorId;
	}

	public void setFornecedorId(Integer fornecedorId) {
		FornecedorId = fornecedorId;
	}

	public Integer getTipos_MelID() {
		return Tipos_MelID;
	}

	public void setTipos_MelID(Integer tipos_MelID) {
		Tipos_MelID = tipos_MelID;
	}

	public Potes_mel getPotes() {
		return potesmel;
	}

	public void setPotes(Potes_mel potesmel) {
		this.potesmel = potesmel;
	}
	public void gravar() {
		Proprietario p = new Dao<Proprietario>(Proprietario.class).buscaPorId(FornecedorId);
		potesmel.setFornecedor(p);
		
		Tipo_Mel tm = new Dao<Tipo_Mel>(Tipo_Mel.class).buscaPorId(Tipos_MelID);
		potesmel.setTipo(tm);
		
		if(potesmel.getId() == null)
			new Dao<Potes_mel>(Potes_mel.class).adiciona(potesmel);
		else
			new Dao<Potes_mel>(Potes_mel.class).atualiza(potesmel);
			potesmel = new Potes_mel();
	
		potesmel = new Potes_mel();
		Tipos_MelID = null;
		FornecedorId = null;
	}
	public List<Potes_mel> getTodosPotesMel(){
		return new Dao<Potes_mel>(Potes_mel.class).buscaTodos();
	}
	public List<Proprietario> getTodosFornecedores(){
		return new Dao<Proprietario>(Proprietario.class).buscaTodos();
	}
	public List<Tipo_Mel> getTodosTiposMel(){
		return new Dao<Tipo_Mel>(Tipo_Mel.class).buscaTodos();
	}
	public void remover(Potes_mel t) {
		new Dao<Potes_mel>(Potes_mel.class).remove(t.getId());
	}
	public void carregar(Potes_mel t) {
		potesmel = t;
	}
}
