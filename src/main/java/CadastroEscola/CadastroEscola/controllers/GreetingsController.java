package CadastroEscola.CadastroEscola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import CadastroEscola.CadastroEscola.Alunos.Aluno;
import CadastroEscola.CadastroEscola.Repository.AlunoRepository;

@RestController
public class GreetingsController {

	@Autowired
	private AlunoRepository alunoRepository;

	/*Cadastro do aluno.*/
	@PostMapping(value = "cadastrar")
	@ResponseBody
	public ResponseEntity<?> cadastrar(@RequestBody Aluno aluno) {

		List<String> listaChave = alunoRepository.listaChaves();

		int cont = 0;

		if (aluno.getNome() == null || aluno.getNome().trim().equals("")) {
			return new ResponseEntity<String>("O campo do nome não pode ficar vazio.", HttpStatus.OK);
		}

		if (aluno.getChave() == null || aluno.getChave().trim().equals("")) {
			return new ResponseEntity<String>("A chave não pode ficar vazia!", HttpStatus.OK);
		}

		for (String chave : listaChave) {
			if (chave.trim().toUpperCase().equals(aluno.getChave().trim().toUpperCase())) {
				cont++;
			}
		}

		if (cont != 0) {
			return new ResponseEntity<String>("Chave já existente e não pode ser usada!", 
					HttpStatus.BAD_REQUEST);
		}

		Aluno user = alunoRepository.save(aluno);
		return new ResponseEntity<Aluno>(user, HttpStatus.OK);

	}

	/*Entrega a lista de todos os alunos cadastrados*/
	@GetMapping(value = "listagem")
	@ResponseBody
	public ResponseEntity<List<Aluno>> listagem() {
		List<Aluno> listaAlunos = alunoRepository.findAll();
		return new ResponseEntity<List<Aluno>>(listaAlunos, HttpStatus.OK);
	}

	/*Atualiaza no banco de dados alguma modificação de cada objeto aluno.*/
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Aluno aluno) {
		/*Garantimos que cada aluno tenha sua chave diferente dos outros.*/
		List<String> listaChave = alunoRepository.listaChaves();
		int cont = 0;

		if (aluno.getId() == null) {
			return new ResponseEntity<String>("O id do aluno não foi informado!", HttpStatus.BAD_REQUEST);
		}

		if (aluno.getChave() == null || aluno.getChave().trim() == "") {
			return new ResponseEntity<String>("A chave não pode ficar vazia na atualização!", 
					HttpStatus.BAD_REQUEST);
		}
		listaChave.remove(aluno.getChave());
		for (String chave : listaChave) {
			if (chave.trim().toUpperCase().equals(aluno.getChave().trim().toUpperCase())) {
				cont++;
			}
		}

		if (cont != 0) {
			return new ResponseEntity<String>("Chave repetida não pode ser usada na atualização!", 
					HttpStatus.BAD_REQUEST);
		}
		alunoRepository.saveAndFlush(aluno);
		return new ResponseEntity<String>("Usuário atualizado com sucesso!", HttpStatus.BAD_REQUEST);

	}
	/*Deleta aluno do banco de dados*/
	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long iduser) {
		alunoRepository.deleteById(iduser);
		return new ResponseEntity<String>("O estudante foi apagado com sucesso!", HttpStatus.OK);
	}
	/*Com apenas parte do nome aparece uma lista de alunos que têm essa parte em seu nome.*/
	@GetMapping("buscarpornome")
	@ResponseBody
	public ResponseEntity<List<Aluno>> buscarpornome(@RequestParam String nomeAluno) {
		List<Aluno> lista = alunoRepository.buscarNome(nomeAluno.toUpperCase().trim());
		return new ResponseEntity<List<Aluno>>(lista, HttpStatus.OK);
	}

	/*Lista as chaves, que são senhas, de cada aluno.*/
	@GetMapping("listachaves")
	@ResponseBody
	public ResponseEntity<List<String>> listachaves() {
		List<String> listaChaveAlunos = alunoRepository.listaChaves();
		return new ResponseEntity<List<String>>(listaChaveAlunos, HttpStatus.OK);
	}

	/*Busca aluno pelo id do banco de dados*/
	@GetMapping("buscarporid")
	@ResponseBody
	public ResponseEntity<Aluno> buscarporid(@RequestParam Long iduser){
		Aluno alunoUser = alunoRepository.findById(iduser).get();
		return new ResponseEntity<Aluno>(alunoUser, HttpStatus.OK);
	}
}






