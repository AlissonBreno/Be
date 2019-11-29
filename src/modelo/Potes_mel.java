package modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
public class Potes_mel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String informacoes_nutricionais;
	private int estoque;
	private double valor;
	
	@OneToOne
	private Tipo_Mel tipo;
	
	@OneToOne
	private Proprietario fornecedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInformacoes_nutricionais() {
		return informacoes_nutricionais;
	}

	public void setInformacoes_nutricionais(String informacoes_nutricionais) {
		this.informacoes_nutricionais = informacoes_nutricionais;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Proprietario getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Proprietario fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Tipo_Mel getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Mel tipo) {
		this.tipo = tipo;
	}
	
	
	
}
