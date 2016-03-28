package test.br.ufsc.etec.saas.estoria.reescritos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ufsc.etec.saas.auxiliar.Calendario;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.etec.saas.entidades.instituicao.AlunoPolo;
import br.ufsc.etec.saas.entidades.instituicao.Avaliador;
import br.ufsc.etec.saas.entidades.instituicao.Curso;
import br.ufsc.etec.saas.entidades.instituicao.OfertaCurso;
import br.ufsc.etec.saas.entidades.instituicao.Polo;
import br.ufsc.etec.saas.entidades.instituicao.PoloOfertaCurso;
import br.ufsc.etec.saas.entidades.saas.Coleta;
import br.ufsc.etec.saas.entidades.saas.Convite;
import br.ufsc.etec.saas.entidades.saas.Instituicao;
import br.ufsc.etec.saas.entidades.saas.Usuario;
import br.ufsc.etec.saas.fachadas.EmBanco;
import br.ufsc.etec.saas.fachadas.EmInstituicao;
import br.ufsc.etec.saas.fachadas.EmSaas;
import test.br.ufsc.etec.saas.tela.EmTestePagina;
import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;

public class TesteTelaIntegracaoQuestionarioColetaRespostaResultadoOrdemDasQuestoes {

	private Instancia teste;
	private SeleniumSaas selenium;
	private Usuario beatriz;
	private Instituicao ufsc;
	private Usuario douglas;
	private Avaliador jhon;
	private Polo ufscJaragua;
	private Curso computacao;
	private OfertaCurso computacao2012_1;
	private PoloOfertaCurso ufscJaraguaComputacao2012_1;
	private AlunoPolo jhonUfscJaraguaComputacao2012_1;

	@Test
	public void estoriaDeTeste() throws Exception {
		criarNovaInstanciaComAdministrador();
		cadastrarInstituicaoCompleta();
		logarComAdministrador();

		acessarCadastroDeQuestionario();
		cadastrarQuestionario();
		acessarEdicaoDeQuestionario();
		cadastrarDimensao();
		cadastrarTopico();
		cadastrarQuestaoObjetivaQuadroDesativada();
		cadastrarQuestaoQuadroMultipla();
		cadastrarQuestaoQuadroObjetivaNova();
		desativarQuestaoObjetivaQuadroDesativada();
		moverQuestaoQuestaoQuadroObjetivaNovaParaPrimeiraPosicao();
		verificarQuestionarioCadastrado();

		acessarCadastroDeColeta();
		cadastrarColeta();
		verificarSeRoboJaTerminouExecucao();
		acessarQuestionarioParaResponder();

		verificarQuestionarioParaResponder();
		verificarQuestaoQuadroObjetivaNova();
		verificarQuestaoQuadroMultipla();
		responderQuestionario();
		verificarAvaliacoes();

		desautenticar();
		logarComAdministrador();
		acessarEdicaoDeColeta();
		finalizarColeta();

		acessarResultados();
		acessarResultadosDaColeta();
		verificarResultados();
	}

	private void verificarSeRoboJaTerminouExecucao() throws Exception {
		selenium.descansar(5);
		// selenium.clicar("menu:configuracoes");
		// selenium.assertTextEquals("Coleta Curso 2015/1 (1)",
		// "atividadesAnionimas:0:descricao");
		// selenium.assertTextStartsWith(Calendario.formatar("dd/MM/y HH:mm",
		// Calendario.obterDataAtual()),
		// "atividadesAnionimas:0:inicio");
		// selenium.assertTextStartsWith(Calendario.formatar("dd/MM/y HH:mm",
		// Calendario.obterDataAtual()),
		// "atividadesAnionimas:0:fim");
	}

	private void criarNovaInstanciaComAdministrador() throws Exception {
		EmBanco.get(teste = EmBanco.novaInstancia()).cadastrarAdmin(beatriz);
		selenium = EmTestePagina.selenium();
		EmTestePagina.get(selenium).trocarInstancia(teste);
		EmTestePagina.get(selenium).limparAtividadesAnonimas();
	}

	private void cadastrarInstituicaoCompleta() throws Exception {
		EmSaas.get(beatriz).cadastrarInstituicao(ufsc);
		EmSaas.get(beatriz).cadastrarOGerente(douglas);
		EmInstituicao.get(douglas).cadastrarAvaliador(jhon);
		EmInstituicao.get(douglas).cadastrarPolo(ufscJaragua);
		EmInstituicao.get(douglas).cadastrarCurso(computacao);
		EmInstituicao.get(douglas).cadastrarOfertaCurso(computacao2012_1);
		EmInstituicao.get(douglas).cadastrarPoloOfertaCurso(ufscJaraguaComputacao2012_1);
		EmInstituicao.get(douglas).cadastrarAlunoPolo(jhonUfscJaraguaComputacao2012_1);
	}

	private void logarComAdministrador() {
		selenium.acessar("/saas/");
		selenium.digitar("loge:usuario", beatriz.getLogin());
		selenium.digitar("loge:senha", beatriz.getSenha());
		selenium.clicar("loge:logar");
	}

	private void acessarCadastroDeQuestionario() {
		selenium.clicar("menu:questionarios");
		selenium.clicar("form:cadastrarQuestionario");
	}

	private void cadastrarQuestionario() {
		selenium.digitar("form:titulo", "Integração");
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:papel", 2);
		selenium.clicar("form:salvar");
	}

	private void acessarEdicaoDeQuestionario() {
		selenium.clicar("menu:questionarios");
		selenium.clicar("form:lista:0:editar");
	}

	private void cadastrarDimensao() {
		selenium.clicar("form:adicionarDimensao");
		selenium.digitar("formAdicionarDimensao:nome", "dimensão integração");
		selenium.clicar("formAdicionarDimensao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarDimensao");
	}

	private void cadastrarTopico() {
		selenium.clicar("form:adicionarTopico");
		selenium.digitar("formAdicionarTopico:nome", "topico integração");
		selenium.clicar("formAdicionarTopico:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarTopico");
	}

	private void cadastrarQuestaoObjetivaQuadroDesativada() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado questão desativada");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 questão desativada");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 questão desativada");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 questão desativada");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 questão desativada");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void cadastrarQuestaoQuadroObjetivaNova() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro objetiva nova");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro objetiva nova");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro objetiva nova");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro objetiva nova");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro objetiva nova");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void cadastrarQuestaoQuadroMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void moverQuestaoQuestaoQuadroObjetivaNovaParaPrimeiraPosicao() {
		selenium.clicar("form:topicos:0:questoes:2:cima");
		selenium.clicar("form:topicos:0:questoes:1:cima");
	}

	private void verificarQuestionarioCadastrado() throws Exception {
		selenium.assertTextEquals("Editar o questionário Curso para Estudante", "titulo");
		selenium.assertTextEquals("Integração", "form:nomeDoQuestionario");
		selenium.assertTextEquals("dimensão integração", "form:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico integração", "form:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .dimensoes > .dimensao"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .questoes > .topico"));
		selenium.assertAmountOfElements(3, By.cssSelector(".questionario > .questoes > .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:0:quadroObjetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(6, By.xpath("//span[@id='form:topicos:0:questoes:0:quadroObjetiva']/table/tbody/tr/td"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:1:quadroObjetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(6, By.xpath("//span[@id='form:topicos:0:questoes:1:quadroObjetiva']/table/tbody/tr/td"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='form:topicos:0:questoes:2:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(9, By.xpath("//span[@id='form:topicos:0:questoes:2:quadroMultipla']/table/tbody/tr/td"));
	}

	private void acessarCadastroDeColeta() throws Exception {
		selenium.selecionarItemDeMenu("menu:coleta", "menu:criar");
	}

	private void desativarQuestaoObjetivaQuadroDesativada() {
		selenium.clicar("form:topicos:0:questoes:0:editarQuestao");
		selenium.clicar("formEditar:ativa_input");
		selenium.clicar("formEditar:salvar");
		selenium.assertElementIsNotVisible("mdEditarQuestao");
	}

	private void verificarQuestaoQuadroObjetivaNova() {
		selenium.assertTextEquals("enunciado quadro objetiva nova", "resposta:topicos:0:questoes:0:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro objetiva nova", "resposta:topicos:0:questoes:0:alternativasQuadroObjetiva:0:alternativaQuadroObjetiva");
		selenium.assertTextEquals("alternativa 2 quadro objetiva nova", "resposta:topicos:0:questoes:0:alternativasQuadroObjetiva:1:alternativaQuadroObjetiva");
		selenium.assertTextEquals("enunciado 1 quadro objetiva nova", "resposta:topicos:0:questoes:0:enunciadosQuadroObjetiva:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro objetiva nova", "resposta:topicos:0:questoes:0:enunciadosQuadroObjetiva:1:enunciado");
	}

	private void verificarQuestaoQuadroMultipla() {
		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:2:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:2:alternativasQuadroMultipla:0:alternativaQuadroMultipla");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:2:alternativasQuadroMultipla:1:alternativaQuadroMultipla");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:2:enunciadosQuadroMultipla:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:2:enunciadosQuadroMultipla:1:enunciado");
	}

	private void verificarQuestionarioParaResponder() throws Exception {
		selenium.assertTextEquals("Integração", "titulo");
		selenium.assertTextEquals("dimensão integração", "resposta:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico integração", "resposta:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .questoes .topico"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .dimensoes .dimensao"));
		selenium.assertAmountOfElements(2, By.cssSelector(".questionario .questoes .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:0:quadroObjetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='resposta:topicos:0:questoes:2:quadroMultipla']/table/tbody/tr"));
	}

	private void cadastrarColeta() throws Exception {
		selenium.selecionarElemento("form:ano", 2);
		selenium.selecionarElemento("form:periodo", 2);
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaSeguinte());
		selenium.selecionarElemento("form:foco", 2);
		selenium.clicar("form:avancar");
		selenium.clicar("form:avancar");
		selenium.assertTextEquals("Sera(ão) criado(s) 1 convite(s).", "form:messages");
		selenium.clicar("form:terminar");
		selenium.assertTextEquals("Envio de convites iniciado com sucesso.", "form:messages");
	}

	private void responderQuestionario() {
		selenium.clicar("resposta:topicos:0:questoes:0:enunciadosQuadroObjetiva:0:linhaQuadro:0");
		selenium.clicar("resposta:topicos:0:questoes:0:enunciadosQuadroObjetiva:1:linhaQuadro:2");
		selenium.clicar("resposta:topicos:0:questoes:2:enunciadosQuadroMultipla:0:multiplaAlternativas:1:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:2:enunciadosQuadroMultipla:1:multiplaAlternativas:1:multiplaAlternativa_input");
		selenium.clicar("resposta:salvar");
	}

	public void verificarAvaliacoes() {
		selenium.assertTextEquals("Avaliações", "titulo");
		selenium.assertTextEquals("Questionário respondido com sucesso!", "mensagemQuestionario");
		selenium.assertTextEquals("Nenhuma avaliação pendente", "form:pendencias_data");
	}

	private void desautenticar() {
		selenium.acessar("/saas/logout");
	}

	private void acessarEdicaoDeColeta() {
		selenium.selecionarItemDeMenu("menu:coleta", "menu:coleta_listar");
		selenium.clicar("form:lista:0:editar");
	}

	private void finalizarColeta() {
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaAnterior());
		selenium.clicar("form:salvar");
		selenium.assertTextEquals(String.format("A coleta %d/1 foi atualizada com sucesso.", Calendario.obterAnoAtual()), "form:messages");
	}

	private void verificarResultados() {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão integração", "avaliacao:dimensao:0:nomeDimensao");

		selenium.assertTextEquals("enunciado quadro objetiva nova", "avaliacao:dimensao:0:resultados:0:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva nova", "avaliacao:dimensao:0:resultados:0:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva nova", "avaliacao:dimensao:0:resultados:0:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:0:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva nova", "avaliacao:dimensao:0:resultados:0:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva nova", "avaliacao:dimensao:0:resultados:0:enunciados:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:0:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:0:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:0:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:0:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:0:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:0:enunciados:1:percentual");

		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:2:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:2:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:2:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:2:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:2:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:2:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:2:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:2:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:2:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:2:msgQuadroMultipla");

		selenium.assertAmountOfElements(2, By.className("resultadoEmbrulhado"));
	}

	private void acessarResultados() {
		selenium.selecionarItemDeMenu("menu:resultados", "menu:geraisNovo");
	}

	private void acessarResultadosDaColeta() {
		selenium.selecionarElemento("form:coleta", 2);
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:avaliador", 2);
		selenium.clicar("form:visualizar");
	}

	private void acessarQuestionarioParaResponder() throws Exception {
		List<Convite> convites = obterConvites();
		assertEquals(1, convites.size());
		selenium.acessarComParametro("/saas/quest.jsf", "c", convites.get(0).getChave());
	}

	private List<Convite> obterConvites() throws Exception {
		Coleta coleta = EmSaas.get(beatriz).listarColetas().get(0);
		List<Convite> convites = EmInstituicao.get(douglas).sobreAcompanhamento().listarTodosConvitesDaColeta(coleta);
		return convites;
	}

	@After
	public void tearDown() throws Exception {
		selenium.acessar("/saas/logout");
	}
}
