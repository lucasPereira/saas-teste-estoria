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
@FixtureSetup(Teste25Avaliacoes.class)
public class Teste26ColetaIntegracaoFechada {

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

		selenium.selecionarItemDeMenu("menu:coleta", "menu:coleta_listar");
		selenium.clicar("form:lista:0:editar");
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaAnterior());
		selenium.clicar("form:salvar");
	}

	@Test
	public void testar() throws Exception {
		selenium.assertTextEquals(String.format("A coleta %d/1 foi atualizada com sucesso.", Calendario.obterAnoAtual()), "form:messages");
	}

}
