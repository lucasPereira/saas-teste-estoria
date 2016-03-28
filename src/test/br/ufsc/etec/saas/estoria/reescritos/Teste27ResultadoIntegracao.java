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
@FixtureSetup(Teste26ColetaIntegracaoFechada.class)
public class Teste27ResultadoIntegracao {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.selecionarItemDeMenu("menu:resultados", "menu:geraisNovo");
		selenium.selecionarElemento("form:coleta", 2);
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:avaliador", 2);
		selenium.clicar("form:check_qualitativa_input");
		selenium.clicar("form:visualizar");
	}

	@Test
	public void testar1() throws Exception {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão integração", "avaliacao:dimensao:0:nomeDimensao");
		selenium.assertAmountOfElements(5, By.className("resultadoEmbrulhado"));
	}

	@Test
	public void testar2() throws Exception {
		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:0:enunciadoObjetiva");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:percentual");
		selenium.assertTextEquals("alternativa 1 objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:nome");
		selenium.assertTextEquals("alternativa 2 objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:nome");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:0:nome");
	}

	@Test
	public void testar3() throws Exception {

		selenium.assertTextEquals("enunciado multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:1:enunciadoMultipla");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:percentual");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:nome");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:nome");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:1:msgMultipla");
	}

	@Test
	public void testar4() throws Exception {
		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:2:enunciadoDiscursiva");
		selenium.assertTextEquals("resposta 1 discursiva 1 integração", "avaliacao:dimensao:0:resultados:2:respostas:0:discursiva");
	}

	@Test
	public void testar5() throws Exception {
		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:3:msgQuadroMultipla");
	}

	@Test
	public void testar6() throws Exception {
		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:4:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:enunciados:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:percentual");
	}

}
