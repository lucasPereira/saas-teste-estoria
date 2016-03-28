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
@FixtureSetup(Teste17OfertaCursoCienciasDaComputacao.class)
public class Teste18PoloUfscDeJaragua {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.abrirMenu("menu:polo");
		selenium.clicar("menu:polo_cadastrar");
		selenium.digitar("form:nome", "UFSC de Jaraguá");
		selenium.digitar("form:cidade", "Jaraguá do Sul");
		selenium.selecionarElemento("form:estado", 25);
		selenium.clicar("form:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("Polo \"UFSC de Jaraguá\" foi cadastrado com sucesso!", "form:messages");
	}
}
