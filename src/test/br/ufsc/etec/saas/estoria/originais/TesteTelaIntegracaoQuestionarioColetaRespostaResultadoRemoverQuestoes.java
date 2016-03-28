package test.br.ufsc.etec.saas.estoria.originais;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import test.br.ufsc.etec.saas.estoria.ConsultorListarConvitesNaoRespondidosDeColetasAbertas;
import test.br.ufsc.etec.saas.tela.EmTestePagina;
import test.br.ufsc.etec.saas.tela.selenium.SeleniumSaas;
import br.ufsc.etec.saas.auxiliar.Calendario;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.etec.saas.entidades.enumerados.Usuarios;
import br.ufsc.etec.saas.entidades.saas.Convite;
import br.ufsc.etec.saas.entidades.saas.Usuario;
import br.ufsc.etec.saas.fachadas.EmBanco;

public class TesteTelaIntegracaoQuestionarioColetaRespostaResultadoRemoverQuestoes {

	private Instancia teste;
	private Usuario beatriz;
	private SeleniumSaas selenium;

	@Test
	public void estoriaDeTeste() throws Exception {
		criarInstanciaComAdministradoraBeatriz();

		logarComAdministradoraBeatriz();
		cadastrarInstituicaoUfsc();
		cadastrarGerenteDouglas();
		desautenticar();

		logarComGerenteDouglas();
		cadastrarPoloUfscDeJaragua();
		cadastrarCursoCienciasDaComputacao();
		cadastrarOfertaCursoCienciasDaComputacao();
		associarPoloUfscDeJaraguaEmOfertaCursoCienciasDaComputacao();
		cadastrarAvaliadorJhon();
		associarAvaliadorJhonEmPoloOfertaCursoUfscDeJaraguaCienciasDaComputacao();
		desautenticar();

		logarComAdministradoraBeatriz();

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
		logarComAdministradoraBeatriz();

		coletaEdicaoAcessar();
		coletaEdicaoFinalizar();

		resultadosAcessar();
		resultadosVisualizar();
		resultadosVerificar();
	}

	private void criarInstanciaComAdministradoraBeatriz() throws Exception {
		teste = EmBanco.novaInstancia();
		beatriz = new Usuario();
		beatriz.setNome("Beatriz");
		beatriz.setLogin("admin");
		beatriz.setSenha("senha");
		beatriz.setPapel(Usuarios.ADMIN);
		beatriz.setEmail("beatriz@gmail.com");
		selenium = EmTestePagina.selenium();
		EmBanco.get(teste).cadastrarAdmin(beatriz);
		EmTestePagina.get(selenium).trocarInstancia(teste);
	}

	private void logarComAdministradoraBeatriz() {
		selenium.acessar("/saas/");
		selenium.digitar("loge:usuario", beatriz.getLogin());
		selenium.digitar("loge:senha", beatriz.getSenha());
		selenium.clicar("loge:logar");
	}

	private void logarComGerenteDouglas() {
		selenium.acessar("/saas/");
		selenium.digitar("loge:usuario", "douglas");
		selenium.digitar("loge:senha", "senha");
		selenium.clicar("loge:logar");
	}

	private void desautenticar() {
		selenium.acessar("/saas/logout");
	}

	private void cadastrarInstituicaoUfsc() {
		selenium.abrirMenu("menu:instituicao");
		selenium.clicar("menu:cadastro");
		selenium.digitar("form:nome", "Universidade Federal de Santa Catarina");
		selenium.digitar("form:sigla", "UFSC");
		selenium.selecionarElemento("form:classificacao", 2);
		selenium.digitar("form:cidade_input", "Florianópolis");
		selenium.selecionarElementoDeAutoCompletarComplexo("form:cidade", 1);
		selenium.clicar("form:salvar");
		selenium.assertTextEquals("Instituição \"Universidade Federal de Santa Catarina\" foi cadastrada com sucesso!", "messages");
	}

	private void cadastrarGerenteDouglas() {
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
		selenium.assertTextEquals("Usuário gerente \"Douglas Hiura\" foi cadastrado com sucesso!", "messages");
	}

	private void cadastrarPoloUfscDeJaragua() {
		selenium.abrirMenu("menu:polo");
		selenium.clicar("menu:polo_cadastrar");
		selenium.digitar("form:nome", "UFSC de Jaraguá");
		selenium.digitar("form:cidade", "Jaraguá do Sul");
		selenium.selecionarElemento("form:estado", 25);
		selenium.clicar("form:salvar");
		selenium.assertTextEquals("Polo \"UFSC de Jaraguá\" foi cadastrado com sucesso!", "form:messages");
	}

	private void cadastrarCursoCienciasDaComputacao() {
		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_cadastrar");
		selenium.digitar("form:nome", "Ciências da Computação");
		selenium.clicar("form:salvar");
		selenium.assertTextEquals("Curso \"Ciências da Computação\" foi cadastrado com sucesso!", "form:messages");
	}

	private void cadastrarOfertaCursoCienciasDaComputacao() {
		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_listar");
		selenium.clicar("form:lista:0:nome");
		selenium.clicar("form:lista:cadastrarOferta");
		selenium.selecionarElemento("form:inicioAno", 5);
		selenium.selecionarElemento("form:inicioPeriodo", 2);
		selenium.selecionarElemento("form:fimAno", 5);
		selenium.selecionarElemento("form:fimPeriodo", 3);
		selenium.clicar("form:salvar");
		String oferta = Calendario.formatar("\"Y/1\"", Calendario.obterDataAtual());
		selenium.assertTextEquals("Oferta " + oferta + " cadastrada com sucesso!", "form:messages");
	}

	private void associarPoloUfscDeJaraguaEmOfertaCursoCienciasDaComputacao() {
		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_listar");
		selenium.clicar("form:lista:0:nome");
		selenium.clicar("form:lista:0:listar_polo");
		selenium.clicar("form:lista:associarPolo");
		selenium.clicar("form:polos:0:nome");
		selenium.clicar("form:associar");
		selenium.digitar("vagas:campoVagas", "50");
		selenium.clicar("vagas:associarPolo");
		selenium.assertTextEquals("O polo \"UFSC de Jaraguá\" foi associado com sucesso!", "form:messages");
	}

	private void cadastrarAvaliadorJhon() {
		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_listar");
		selenium.clicar("form:lista:0:nome");
		selenium.clicar("form:lista:0:listar_polo");
		selenium.clicar("form:lista:0:aluno");
		selenium.clicar("form:pessoas:cadastrar");
		selenium.digitar("avaliador:nome", "Jhon");
		selenium.digitar("avaliador:email", "jhon@gmail.com");
		selenium.clicar("avaliador:salvar");
		selenium.assertTextEquals("\"Jhon\" cadastrado(a) com sucesso!", "form:messages");
	}

	private void associarAvaliadorJhonEmPoloOfertaCursoUfscDeJaraguaCienciasDaComputacao() {
		selenium.abrirMenu("menu:curso");
		selenium.clicar("menu:curso_listar");
		selenium.clicar("form:lista:0:nome");
		selenium.clicar("form:lista:0:listar_polo");
		selenium.clicar("form:lista:0:aluno");
		selenium.clicar("form:pessoas:0:nome");
		selenium.clicar("form:associar");
		selenium.assertTextEquals("Aluno \"Jhon\" associado com sucesso!", "form:messages");
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
		selenium.descansar(5);
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
		return new ConsultorListarConvitesNaoRespondidosDeColetasAbertas(teste).executar();
	}

	@After
	public void tearDown() throws Exception {
		selenium.acessar("/saas/logout");
	}

}
