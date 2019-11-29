package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Dao;
import modelo.TiposProduto;


@ManagedBean
@ViewScoped
public class TipoProdutoController {
	private TiposProduto tiposprodutos = new TiposProduto();
	
	public TiposProduto getTiposProduto() {
		return tiposprodutos;
	}

	public void setTiposProduto(TiposProduto tiposprodutos) {
		this.tiposprodutos = tiposprodutos;
	}
	public void gravar() {
		if(tiposprodutos.getId() == null)
			new Dao<TiposProduto>(TiposProduto.class).adiciona(tiposprodutos);
		else
			new Dao<TiposProduto>(TiposProduto.class).atualiza(tiposprodutos);
		tiposprodutos = new TiposProduto();
	}
	public List<TiposProduto> getTodosTiposProdutos(){
		return new Dao<TiposProduto>(TiposProduto.class).buscaTodos();
	}

	public void remover(TiposProduto t) {
		new Dao<TiposProduto>(TiposProduto.class).remove(t.getId());
	}
	public void carregar(TiposProduto t) {
		tiposprodutos = t;
	}
}
