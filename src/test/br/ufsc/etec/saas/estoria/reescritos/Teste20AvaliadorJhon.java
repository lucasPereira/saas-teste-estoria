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
@FixtureSetup(Teste19PoloUfscDeJaraguaEmOfertaCursoCienciasDaComputacao.class)
public class Teste20AvaliadorJhon {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_listar");
		selenium.clicar("form:lista:0:nome");
		selenium.clicar("form:lista:0:listar_polo");
		selenium.clicar("form:lista:0:aluno");
		selenium.clicar("form:pessoas:cadastrar");
		selenium.digitar("avaliador:nome", "Jhon");
		selenium.digitar("avaliador:email", "jhon@gmail.com");
		selenium.clicar("avaliador:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("\"Jhon\" cadastrado(a) com sucesso!", "form:messages");
	}

}
