package test.br.ufsc.etec.saas.estoria.reescritos;

import java.util.List;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

import test.br.ufsc.etec.saas.tela.EmTestePagina;
import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
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

public class TesteTelaIntegracaoQuestionarioColetaRespostaResultadoRemoverQuestoes {

	private Instancia teste;
	private Usuario beatriz;
	private SeleniumSaas selenium;
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

		questionarioCadastroAcessar();
		questionarioCadastroCadastrar();
		questionarioEdicaoAcessar();
		questionarioEdicaoCadastrarDimensao();
		questionarioEdicaoCadastrarTopico();

		questionarioEdicaoCadastrarPrimeiraQuestaoObjetiva();
		questionarioEdicaoCadastrarSegundaQuestaoObjetiva();
		questionarioEdicaoCadastrarPrimeiraQuestaoMultipla();
		questionarioEdicaoCadastrarSegundaQuestaoMultipla();
		questionarioEdicaoCadastrarPrimeiraQuestaoDiscursiva();
		questionarioEdicaoCadastrarSegundaQuestaoDiscursiva();
		questionarioEdicaoCadastrarPrimeiraQuestaoQuadroObjetiva();
		questionarioEdicaoCadastrarSegundaQuestaoQuadroObjetiva();
		questionarioEdicaoCadastrarPrimeiraQuestaoQuadroMultipla();
		questionarioEdicaoCadastrarSegundaQuestaoQuadroMultipla();

		questionarioEdicaoRemoverPrimeiraQuestaoObjetiva();
		questionarioEdicaoRemoverPrimeiraQuestaoMultipla();
		questionarioEdicaoRemoverPrimeiraQuestaoDiscursiva();
		questionarioEdicaoRemoverPrimeiraQuestaoQuadroObjetiva();
		questionarioEdicaoRemoverPrimeiraQuestaoQuadroMultipla();

		coletaCadastroAcessar();
		coletaCadastroCadastrar();

		questionarioPreenchimentoAcessar();
		questionarioPreenchimentoResponder();

		verificarAvaliacoesDoAvaliador();
		desautenticar();
		logarComAdministrador();

		coletaEdicaoAcessar();
		coletaEdicaoFinalizar();

		resultadosAcessar();
		resultadosVisualizar();
		resultadosVerificar();
	}

	private void criarNovaInstanciaComAdministrador() throws Exception {
		EmBanco.get(teste = EmBanco.novaInstancia()).cadastrarAdmin(beatriz);
		selenium = EmTestePagina.selenium();
		EmTestePagina.get(selenium).trocarInstancia(teste);
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

	private void questionarioCadastroAcessar() {
		selenium.clicar("menu:questionarios");
		selenium.clicar("form:cadastrarQuestionario");
	}

	private void questionarioCadastroCadastrar() {
		selenium.digitar("form:titulo", "Integração");
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:papel", 2);
		selenium.clicar("form:salvar");
	}

	private void questionarioEdicaoAcessar() {
		selenium.clicar("menu:questionarios");
		selenium.clicar("form:lista:0:editar");
	}

	private void questionarioEdicaoCadastrarDimensao() {
		selenium.clicar("form:adicionarDimensao");
		selenium.digitar("formAdicionarDimensao:nome", "dimensão integração");
		selenium.clicar("formAdicionarDimensao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarDimensao");
	}

	private void questionarioEdicaoCadastrarTopico() {
		selenium.clicar("form:adicionarTopico");
		selenium.digitar("formAdicionarTopico:nome", "topico integração");
		selenium.clicar("formAdicionarTopico:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarTopico");
	}

	private void questionarioEdicaoCadastrarPrimeiraQuestaoObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado objetiva 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 objetiva 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 objetiva 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarSegundaQuestaoObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado objetiva 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 objetiva 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 objetiva 2");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarPrimeiraQuestaoMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado multipla 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 multipla 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 multipla 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarSegundaQuestaoMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado multipla 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 multipla 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 multipla 2");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarPrimeiraQuestaoDiscursiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoDiscursiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado discursiva 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarSegundaQuestaoDiscursiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoDiscursiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado discursiva 2");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarPrimeiraQuestaoQuadroObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro objetiva 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro objetiva 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro objetiva 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro objetiva 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro objetiva 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarSegundaQuestaoQuadroObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro objetiva 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro objetiva 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro objetiva 2");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro objetiva 2");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro objetiva 2");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarPrimeiraQuestaoQuadroMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro multipla 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro multipla 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro multipla 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro multipla 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro multipla 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void questionarioEdicaoCadastrarSegundaQuestaoQuadroMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro multipla 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro multipla 2");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro multipla 2");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro multipla 2");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro multipla 2");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");

	}

	private void questionarioEdicaoRemoverPrimeiraQuestaoObjetiva() {
		selenium.clicar("form:topicos:0:questoes:0:excluirQuestao");
		selenium.clicar("formExcluirQuestao:excluir");
		selenium.assertElementIsNotVisible("mdExcluirQuestao");
	}

	private void questionarioEdicaoRemoverPrimeiraQuestaoMultipla() {
		selenium.clicar("form:topicos:0:questoes:1:excluirQuestao");
		selenium.clicar("formExcluirQuestao:excluir");
		selenium.assertElementIsNotVisible("mdExcluirQuestao");
	}

	private void questionarioEdicaoRemoverPrimeiraQuestaoDiscursiva() {
		selenium.clicar("form:topicos:0:questoes:2:excluirQuestao");
		selenium.clicar("formExcluirQuestao:excluir");
		selenium.assertElementIsNotVisible("mdExcluirQuestao");
	}

	private void questionarioEdicaoRemoverPrimeiraQuestaoQuadroObjetiva() {
		selenium.clicar("form:topicos:0:questoes:3:excluirQuestao");
		selenium.clicar("formExcluirQuestao:excluir");
		selenium.assertElementIsNotVisible("mdExcluirQuestao");
	}

	private void questionarioEdicaoRemoverPrimeiraQuestaoQuadroMultipla() {
		selenium.clicar("form:topicos:0:questoes:4:excluirQuestao");
		selenium.clicar("formExcluirQuestao:excluir");
		selenium.assertElementIsNotVisible("mdExcluirQuestao");
	}

	private void coletaCadastroAcessar() throws Exception {
		selenium.selecionarItemDeMenu("menu:coleta", "menu:criar");
	}

	private void coletaCadastroCadastrar() throws Exception {
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

	private void questionarioPreenchimentoAcessar() throws Exception {
		List<Convite> convites = obterConvites();
		assertEquals(1, convites.size());
		selenium.acessarComParametro("/saas/quest.jsf", "c", convites.get(0).getChave());
	}

	private void questionarioPreenchimentoResponder() {
		selenium.clicar("resposta:topicos:0:questoes:0:radio:0");
		selenium.clicar("resposta:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.digitar("resposta:topicos:0:questoes:2:textArea", "resposta 1 discursiva 2 integração");
		selenium.clicar("resposta:topicos:0:questoes:3:enunciadosQuadroObjetiva:0:linhaQuadro:0");
		selenium.clicar("resposta:topicos:0:questoes:3:enunciadosQuadroObjetiva:1:linhaQuadro:2");
		selenium.clicar("resposta:topicos:0:questoes:4:enunciadosQuadroMultipla:0:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:4:enunciadosQuadroMultipla:1:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.clicar("resposta:salvar");
	}

	public void verificarAvaliacoesDoAvaliador() {
		selenium.assertTextEquals("Avaliações", "titulo");
		selenium.assertTextEquals("Questionário respondido com sucesso!", "mensagemQuestionario");
		selenium.assertTextEquals("Nenhuma avaliação pendente", "form:pendencias_data");
	}

	private void desautenticar() {
		selenium.acessar("/saas/logout");
	}

	private void coletaEdicaoAcessar() {
		selenium.selecionarItemDeMenu("menu:coleta", "menu:coleta_listar");
		selenium.clicar("form:lista:0:editar");
	}

	private void coletaEdicaoFinalizar() {
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaAnterior());
		selenium.clicar("form:salvar");
		selenium.assertTextEquals(String.format("A coleta %d/1 foi atualizada com sucesso.", Calendario.obterAnoAtual()), "form:messages");
	}

	private void resultadosAcessar() {
		selenium.selecionarItemDeMenu("menu:resultados", "menu:geraisNovo");
	}

	private void resultadosVisualizar() {
		selenium.selecionarElemento("form:coleta", 2);
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:avaliador", 2);
		selenium.clicar("form:check_qualitativa_input");
		selenium.clicar("form:visualizar");
	}

	private void resultadosVerificar() {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão integração", "avaliacao:dimensao:0:nomeDimensao");

		selenium.assertTextEquals("enunciado objetiva 2", "avaliacao:dimensao:0:resultados:0:enunciadoObjetiva");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:percentual");
		selenium.assertTextEquals("alternativa 1 objetiva 2", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:nome");
		selenium.assertTextEquals("alternativa 2 objetiva 2", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:nome");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:0:nome");

		selenium.assertTextEquals("enunciado multipla 2", "avaliacao:dimensao:0:resultados:1:enunciadoMultipla");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:percentual");
		selenium.assertTextEquals("alternativa 1 multipla 2", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:nome");
		selenium.assertTextEquals("alternativa 2 multipla 2", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:nome");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:1:msgMultipla");

		selenium.assertTextEquals("enunciado discursiva 2", "avaliacao:dimensao:0:resultados:2:enunciadoDiscursiva");
		selenium.assertTextEquals("resposta 1 discursiva 2 integração", "avaliacao:dimensao:0:resultados:2:respostas:0:discursiva");

		selenium.assertTextEquals("enunciado quadro objetiva 2", "avaliacao:dimensao:0:resultados:3:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva 2", "avaliacao:dimensao:0:resultados:3:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva 2", "avaliacao:dimensao:0:resultados:3:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:3:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva 2", "avaliacao:dimensao:0:resultados:3:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva 2", "avaliacao:dimensao:0:resultados:3:enunciados:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciados:1:percentual");

		selenium.assertTextEquals("enunciado quadro multipla 2", "avaliacao:dimensao:0:resultados:4:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla 2", "avaliacao:dimensao:0:resultados:4:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla 2", "avaliacao:dimensao:0:resultados:4:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla 2", "avaliacao:dimensao:0:resultados:4:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla 2", "avaliacao:dimensao:0:resultados:4:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:4:msgQuadroMultipla");

		selenium.assertAmountOfElements(5, By.className("resultadoEmbrulhado"));
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
