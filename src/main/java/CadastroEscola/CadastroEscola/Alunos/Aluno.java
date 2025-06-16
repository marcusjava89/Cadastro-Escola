package CadastroEscola.CadastroEscola.Alunos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aluno")
@SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno", 
allocationSize = 1, initialValue = 1)
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
	private Long id;
	
	@NotBlank(message = "O campo do nome não pode ser vazio.")
	private String nome;
	
	@NotBlank(message = "Campo do idade não pode ser vazio.")
	private int idade;
	
	@NotNull(message = "O campo do cof não pode ser vazio.")
	private String cpf;
	
	@NotBlank(message = "Campo da chave não pode ser vazia")
	private String chave;
	
	public String getChave() {
		return chave;
	}
	public void setChave(String senha) {
		this.chave = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}