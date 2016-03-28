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
@FixtureSetup(Teste14InstituicaoUfsc.class)
public class Teste15GerenteDouglas {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.abrirMenu("menu:usuario");
		selenium.clicar("menu:gerente");
		selenium.digitar("form:nome", "Douglas Hiura");
		selenium.digitar("form:cpf", "062.193.859-93");
		selenium.digitar("form:email", "douglashiura@gmail.com");
		selenium.digitar("form:login", "douglas");
		selenium.digitar("form:senha", "senha");
		selenium.digitar("form:telefone", "(49)9903-2569");
		selenium.digitar("form:instituicao_input", "UFSC");
		selenium.selecionarElementoDeAutoCompletar("form:instituicao", 1);
		selenium.clicar("form:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("Usuário gerente \"Douglas Hiura\" foi cadastrado com sucesso!", "messages");
	}

}
