package CadastroEscola.CadastroEscola.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import CadastroEscola.CadastroEscola.Alunos.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	/*Retorna uma lista de nomes. Colocamos parte do nome e uma lista é retornada.
	 * Método dentro do banco de dados.*/
	@Query("select u from Aluno u where upper(trim(u.nome)) like %?1%")
	List<Aluno> buscarNome(String nome);
	
	@Query("SELECT a.chave FROM Aluno a")
	List<String> listaChaves();
	
}