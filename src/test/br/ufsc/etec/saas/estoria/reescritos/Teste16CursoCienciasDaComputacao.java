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
@FixtureSetup(Teste15GerenteDouglas.class)
public class Teste16CursoCienciasDaComputacao {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.acessar("/saas/logout");
		selenium.acessar("/saas/");
		selenium.digitar("loge:usuario", "douglas");
		selenium.digitar("loge:senha", "senha");
		selenium.clicar("loge:logar");

		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_cadastrar");
		selenium.digitar("form:nome", "Ciências da Computação");
		selenium.clicar("form:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("Curso \"Ciências da Computação\" foi cadastrado com sucesso!", "form:messages");
	}

}
