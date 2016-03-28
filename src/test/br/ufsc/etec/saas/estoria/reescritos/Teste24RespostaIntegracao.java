package test.br.ufsc.etec.saas.estoria.reescritos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import test.br.ufsc.etec.saas.estoria.ConsultorListarConvitesNaoRespondidosDeColetasAbertas;
import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@RunWith(Estoria.class)
@FixtureSetup(Teste23ColetaIntegracaoAberta.class)
public class Teste24RespostaIntegracao {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.acessar("/saas/logout");
		selenium.acessarComParametro("/saas/quest.jsf", "c", new ConsultorListarConvitesNaoRespondidosDeColetasAbertas(teste).executar().get(0).getChave());
	}

	@Test
	public void testar1() throws Exception {
		selenium.assertTextEquals("Integração", "titulo");
		selenium.assertTextEquals("dimensão integração", "resposta:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico integração", "resposta:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .questoes .topico"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .dimensoes .dimensao"));
		selenium.assertAmountOfElements(5, By.cssSelector(".questionario .questoes .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:0:objetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:1:multipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='resposta:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr"));
	}

	@Test
	public void testar2() throws Exception {
		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:0:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:0:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:0:radio:1");
	}

	@Test
	public void testar3() throws Exception {
		selenium.assertTextEquals("enunciado multipla coleta 1 versão 1", "resposta:topicos:0:questoes:1:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 1", "resposta:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 1", "resposta:topicos:0:questoes:1:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

	@Test
	public void testar4() throws Exception {
		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 1", "resposta:topicos:0:questoes:2:enunciadoDaQuestao");
	}

	@Test
	public void testar5() throws Exception {
		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:alternativasQuadroMultipla:0:alternativaQuadroMultipla");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:alternativasQuadroMultipla:1:alternativaQuadroMultipla");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:1:enunciado");
	}

	@Test
	public void testar6() throws Exception {
		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:alternativasQuadroObjetiva:0:alternativaQuadroObjetiva");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:alternativasQuadroObjetiva:1:alternativaQuadroObjetiva");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:1:enunciado");
	}

}
