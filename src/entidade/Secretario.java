package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Secretario {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String cpf;
	private String linguaEstrangeira;
	private String linguaMaterna;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLinguaEstrangeira() {
		return linguaEstrangeira;
	}

	public void setLinguaEstrangeira(String linguaEstrangeira) {
		this.linguaEstrangeira = linguaEstrangeira;
	}

	public String getLinguaMaterna() {
		return linguaMaterna;
	}

	public void setLinguaMaterna(String linguaMaterna) {
		this.linguaMaterna = linguaMaterna;
	}
}
