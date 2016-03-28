package test.br.ufsc.etec.saas.estoria.reescritos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.etec.saas.entidades.enumerados.Usuarios;
import br.ufsc.etec.saas.entidades.saas.Usuario;
import br.ufsc.etec.saas.fachadas.EmBanco;
import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@RunWith(Estoria.class)
@FixtureSetup(Teste12Selenium.class)
public class Teste13AdministradoraBeatriz {

	private Usuario beatriz;

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		beatriz = new Usuario();
		beatriz.setNome("Beatriz");
		beatriz.setLogin("admin");
		beatriz.setSenha("senha");
		beatriz.setPapel(Usuarios.ADMIN);
		beatriz.setEmail("beatriz@gmail.com");
		EmBanco.get(teste).cadastrarAdmin(beatriz);
	}

	@Test
	public void testar() throws Exception {
		assertNotNull(beatriz.getId());
	}

}
