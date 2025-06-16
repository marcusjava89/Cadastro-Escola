package CadastroEscola.CadastroEscola.requests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CadastroEscola.CadastroEscola.Application;
import CadastroEscola.CadastroEscola.Alunos.Aluno;
import CadastroEscola.CadastroEscola.Repository.AlunoRepository;
import junit.framework.TestCase;

@SpringBootTest(classes = Application.class)
public class TesteCadastroEscola extends TestCase{
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Test
	public void testCadastrarAluno() throws JsonProcessingException, Exception{
		
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(wac);
		MockMvc mockMvc = builder.build();	
		
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno Cadastro Teste");
		alunoRepository.save(aluno);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc.perform(MockMvcRequestBuilders.post("cadastrar")
									      .content(objectMapper.writeValueAsString(aluno))
									      .accept(MediaType.APPLICATION_JSON)
									      .contentType(MediaType.APPLICATION_JSON));
		Aluno alunoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse()
				.getContentAsString(), Aluno.class);
		
		System.out.println("Retorno da API " + 
		retornoApi.andReturn().getResponse().getContentAsString());
		
		assertEquals(aluno.getNome(), alunoRetorno.getNome());
		
	}

}












