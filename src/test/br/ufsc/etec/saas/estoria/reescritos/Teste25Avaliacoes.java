package test.br.ufsc.etec.saas.estoria.reescritos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@RunWith(Estoria.class)
@FixtureSetup(Teste24RespostaIntegracao.class)
public class Teste25Avaliacoes {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.clicar("resposta:topicos:0:questoes:0:radio:0");
		selenium.clicar("resposta:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.digitar("resposta:topicos:0:questoes:2:textArea", "resposta 1 discursiva 1 integração");
		selenium.clicar("resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:0:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:1:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:0:linhaQuadro:0");
		selenium.clicar("resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:1:linhaQuadro:2");
		selenium.clicar("resposta:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("Avaliações", "titulo");
		selenium.assertTextEquals("Questionário respondido com sucesso!", "mensagemQuestionario");
		selenium.assertTextEquals("Nenhuma avaliação pendente", "form:pendencias_data");
	}

}
