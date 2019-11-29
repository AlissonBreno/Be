package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Dao;
import modelo.Fornecedores;

@ManagedBean
@ViewScoped
public class FornecedorController {
	private Fornecedores fornecedor = new Fornecedores();
	
	public Fornecedores getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}
	public void gravar() {
		if(fornecedor.getId() == null)
			new Dao<Fornecedores>(Fornecedores.class).adiciona(fornecedor);
		else
			new Dao<Fornecedores>(Fornecedores.class).atualiza(fornecedor);
			fornecedor = new Fornecedores();
	}
	public List<Fornecedores> getTodosFornecedores(){
		return new Dao<Fornecedores>(Fornecedores.class).buscaTodos();
	}

	public void remover(Fornecedores t) {
		new Dao<Fornecedores>(Fornecedores.class).remove(t.getId());
	}
	public void carregar(Fornecedores t) {
		fornecedor = t;
	}
}
