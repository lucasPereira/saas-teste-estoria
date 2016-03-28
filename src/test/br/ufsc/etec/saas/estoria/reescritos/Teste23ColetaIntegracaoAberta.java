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
@FixtureSetup(Teste22QuestionarioIntegracao.class)
public class Teste23ColetaIntegracaoAberta {

	@Fixture
	private Instancia teste;

	@Fixture
	private SeleniumSaas selenium;

	@Before
	public void configurar() throws Exception {
		selenium.selecionarItemDeMenu("menu:coleta", "menu:criar");
		selenium.selecionarElemento("form:ano", 2);
		selenium.selecionarElemento("form:periodo", 2);
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaSeguinte());
		selenium.selecionarElemento("form:foco", 2);
		selenium.clicar("form:avancar");
		selenium.clicar("form:avancar");
		selenium.assertTextEquals("Sera(ão) criado(s) 1 convite(s).", "form:messages");
		selenium.clicar("form:terminar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals("Envio de convites iniciado com sucesso.", "form:messages");
	}

}
