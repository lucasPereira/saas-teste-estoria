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
@FixtureSetup(Teste13AdministradoraBeatriz.class)
public class Teste14InstituicaoUfsc {

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

		selenium.abrirMenu("menu:instituicao");
		selenium.clicar("menu:cadastro");
		selenium.digitar("form:nome", "Universidade Federal de Santa Catarina");
		selenium.digitar("form:sigla", "UFSC");
		selenium.selecionarElemento("form:classificacao", 2);
		selenium.digitar("form:cidade_input", "Florianópolis");
		selenium.selecionarElementoDeAutoCompletarComplexo("form:cidade", 1);
		selenium.clicar("form:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("Instituição \"Universidade Federal de Santa Catarina\" foi cadastrada com sucesso!", "messages");
	}

}
