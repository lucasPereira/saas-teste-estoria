package test.br.ufsc.etec.saas.estoria.reescritos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.br.ufsc.etec.saas.tela.EmTestePagina;
import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@RunWith(Estoria.class)
@FixtureSetup(Teste11InstanciaTeste.class)
public class Teste12Selenium {

	private SeleniumSaas selenium;

	@Fixture
	private Instancia teste;

	@Before
	public void configurar() throws Exception {
		selenium = EmTestePagina.selenium();
		EmTestePagina.get(selenium).trocarInstancia(teste);
	}

	@Test
	public void testar() throws Exception {
		assertNotNull(selenium);
	}

}
