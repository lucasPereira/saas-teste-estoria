package test.br.ufsc.etec.saas.estoria.reescritos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
import br.ufsc.etec.saas.auxiliar.Calendario;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@RunWith(Estoria.class)
@FixtureSetup(Teste16CursoCienciasDaComputacao.class)
public class Teste17OfertaCursoCienciasDaComputacao {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_listar");
		selenium.clicar("form:lista:0:nome");
		selenium.clicar("form:lista:cadastrarOferta");
		selenium.selecionarElemento("form:inicioAno", 5);
		selenium.selecionarElemento("form:inicioPeriodo", 2);
		selenium.selecionarElemento("form:fimAno", 5);
		selenium.selecionarElemento("form:fimPeriodo", 3);
		selenium.clicar("form:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("Oferta " + Calendario.formatar("\"Y/1\"", Calendario.obterDataAtual()) + " cadastrada com sucesso!", "form:messages");
	}
}
