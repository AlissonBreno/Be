package modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
public class Propriedade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToOne
	private Tipo_Propriedade tipo;
	@OneToOne
	private Proprietario id_proprietario;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo_Propriedade getTipo() {
		return tipo;
	}
	public void setTipo(Tipo_Propriedade tipo) {
		this.tipo = tipo;
	}
	public Proprietario getId_proprietario() {
		return id_proprietario;
	}
	public void setId_proprietario(Proprietario id_proprietario) {
		this.id_proprietario = id_proprietario;
	}

	
	
	
}

