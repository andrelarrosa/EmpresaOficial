package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engenheiro {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private int cpf;
	private String engenharia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEngenharia() {
		return engenharia;
	}

	public void setEngenharia(String engenharia) {
		this.engenharia = engenharia;
	}

}
