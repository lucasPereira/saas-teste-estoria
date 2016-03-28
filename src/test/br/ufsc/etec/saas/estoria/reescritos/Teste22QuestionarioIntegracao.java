package test.br.ufsc.etec.saas.estoria.reescritos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@RunWith(Estoria.class)
@FixtureSetup(Teste21AvaliadorJhonEmOfertaCursoCienciasDaComputacao.class)
public class Teste22QuestionarioIntegracao {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.acessar("/saas/logout");
		selenium.digitar("loge:usuario", "admin");
		selenium.digitar("loge:senha", "senha");
		selenium.clicar("loge:logar");

		selenium.clicar("menu:questionarios");
		selenium.clicar("form:cadastrarQuestionario");
		selenium.digitar("form:titulo", "Integração");
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:papel", 2);
		selenium.clicar("form:salvar");

		selenium.clicar("menu:questionarios");
		selenium.clicar("form:lista:0:editar");

		selenium.clicar("form:adicionarDimensao");
		selenium.digitar("formAdicionarDimensao:nome", "dimensão integração");
		selenium.clicar("formAdicionarDimensao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarDimensao");

		selenium.clicar("form:adicionarTopico");
		selenium.digitar("formAdicionarTopico:nome", "topico integração");
		selenium.clicar("formAdicionarTopico:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarTopico");

		selenium.clicar("form:topicos:0:adicionarQuestaoObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");

		selenium.clicar("form:topicos:0:adicionarQuestaoMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");

		selenium.clicar("form:topicos:0:adicionarQuestaoDiscursiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado discursiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");

		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");

		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	@Test
	public void testar1() throws Exception {
		selenium.assertTextEquals("Editar o questionário Curso para Estudante", "titulo");
		selenium.assertTextEquals("Integração", "form:nomeDoQuestionario");
		selenium.assertTextEquals("dimensão integração", "form:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico integração", "form:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .dimensoes > .dimensao"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .questoes > .topico"));
		selenium.assertAmountOfElements(5, By.cssSelector(".questionario > .questoes > .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:0:objetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:1:multipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='form:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(9, By.xpath("//span[@id='form:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr/td"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(6, By.xpath("//span[@id='form:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr/td"));
	}

	@Test
	public void testar2() throws Exception {
		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 1", "form:topicos:0:questoes:0:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 1 versão 1", "form:topicos:0:questoes:0:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 1 versão 1", "form:topicos:0:questoes:0:radio:1");
	}

	@Test
	public void testar3() throws Exception {
		selenium.assertTextEquals("Desativada", "form:topicos:0:questoes:0:desativada");
		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 2", "form:topicos:0:questoes:0:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 1 versão 2", "form:topicos:0:questoes:0:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 1 versão 2", "form:topicos:0:questoes:0:radio:1");
	}

	@Test
	public void testar4() throws Exception {
		selenium.assertElementNotExists("form:topicos:0:questoes:5:desativada");
		selenium.assertTextEquals("enunciado objetiva coleta 2 versão 1", "form:topicos:0:questoes:5:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 2 versão 1", "form:topicos:0:questoes:5:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 2 versão 1", "form:topicos:0:questoes:5:radio:1");
	}

	@Test
	public void testar5() throws Exception {
		selenium.assertTextEquals("enunciado multipla coleta 1 versão 1", "form:topicos:0:questoes:1:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 1", "form:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 1", "form:topicos:0:questoes:1:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

	@Test
	public void testar6() throws Exception {
		selenium.assertTextEquals("Desativada", "form:topicos:0:questoes:1:desativada");
		selenium.assertTextEquals("enunciado multipla coleta 1 versão 2", "form:topicos:0:questoes:1:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 2", "form:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 2", "form:topicos:0:questoes:1:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

}
