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

public class TesteTelaIntegracaoQuestionarioColetaRespostaResultadoDesativarQuestoes {

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

		primeiraColetaQuestionarioCadastroAcessar();
		primeiraColetaQuestionarioCadastroCadastrar();
		primeiraColetaQuestionarioEdicaoAcessar();
		primeiraColetaQuestionarioEdicaoCadastrarDimensao();
		primeiraColetaQuestionarioEdicaoCadastrarTopico();
		primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoObjetiva();
		primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoMultipla();
		primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoDiscursiva();
		primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoQuadroMultipla();
		primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoQuadroObjetiva();
		primeiraColetaQuestionarioEdicaoVerificar();
		primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoObjetiva();
		primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoMultipla();
		primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoDiscursiva();
		primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroMultipla();
		primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroObjetiva();

		coletaCadastroAcessar();
		primeiraColetaCadastroCadastrar();
		acessarOQuestionario();

		primeiraColetaQuestionarioResponderVerificar();
		primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoObjetiva();
		primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoMultipla();
		primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoDiscursiva();
		primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoQuadroMultipla();
		primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoQuadroObjetiva();
		primeiraColetaQuestionarioPreenchimentoPreencher();
		primeiraColetaAvaliadorAvaliacoesVerificar();

		desautenticar();
		logarComAdministradoraBeatriz();
		coletaEdicaoAcessar();
		primeiraColetaEdicaoFinalizar();

		acessarResultados();
		coletaResultadosVisualizarComPeriodoMaisRecente();
		primeiraColetaResultadosVerificarPrimeirasVersoes();

		segundaColetaQuestionarioEdicaoAcessar();
		segundaColetaQuestionarioEdicaoEditar();
		segundaColetaQuestionarioEdicaoEditarDimensao();
		segundaColetaQuestionarioEdicaoEditarTopico();
		segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoObjetiva();
		segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoMultipla();
		segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoDiscursiva();
		segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoQuadroMultipla();
		segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoQuadroObjetiva();
		segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoObjetiva();
		segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoMultipla();
		segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoDiscursiva();
		segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoQuadroMultipla();
		segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoQuadroObjetiva();
		segundaColetaQuestionarioEdicaoVerificar();
		segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoObjetiva();
		segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoMultipla();
		segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoDiscursiva();
		segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroMultipla();
		segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroObjetiva();
		segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoObjetiva();
		segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoMultipla();
		segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoDiscursiva();
		segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoQuadroMultipla();
		segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoQuadroObjetiva();

		coletaCadastroAcessar();
		segundaColetaCadastroCadastrar();
		acessarOQuestionario();
		segundaColetaQuestionarioResponderVerificar();
		segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoObjetiva();
		segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoMultipla();
		segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoDiscursiva();
		segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoQuadroMultipla();
		segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoQuadroObjetiva();
		segundaColetaQuestionarioPreenchimentoPreencher();
		segundaColetaAvaliadorAvaliacoesVerificar();

		desautenticar();
		logarComAdministradoraBeatriz();
		coletaEdicaoAcessar();
		segundaColetaEdicaoFinalizar();

		acessarResultados();
		coletaResultadosVisualizarComPeriodoMaisAntigo();
		primeiraColetaResultadosVerificarSegundasVersoes();
		coletaResultadosVisualizarComPeriodoMaisRecente();
		segundaColetaResultadosVerificar();
		coletaResultadosVisualizarComPeriodoMaisRecenteEExtratificada();
		segundaColetaResultadosVerificarExtratificada();
		coletaResultadosVisualizarComPeriodoAnteriorEExtratificada();
		primeiraColetaResultadosVerificarExtratificada();
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

	private void primeiraColetaResultadosVerificarExtratificada() {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão editada integração", "avaliacao:estratos:0:dimensao:0:nomeDimensao");

		selenium.assertTextEquals("Universidade Federal de Santa Catarina - 1 avaliador(es)", "avaliacao:estratos:0:estratificacao");

		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:0:enunciadoObjetiva");
		selenium.assertTextEquals("100,0%", "avaliacao:estratos:0:dimensao:0:resultados:0:alternativasObjetiva:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:estratos:0:dimensao:0:resultados:0:alternativasObjetiva:1:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:estratos:0:dimensao:0:resultados:0:percentual");
		selenium.assertTextEquals("alternativa 1 objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:0:alternativasObjetiva:0:nome");
		selenium.assertTextEquals("alternativa 2 objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:0:alternativasObjetiva:1:nome");
		selenium.assertTextEquals("Sem resposta", "avaliacao:estratos:0:dimensao:0:resultados:0:nome");

		selenium.assertTextEquals("enunciado multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:1:enunciadoMultipla");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:1:alternativasMultipla:0:nome");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:1:alternativasMultipla:1:nome");
		selenium.assertTextEquals("100,0%", "avaliacao:estratos:0:dimensao:0:resultados:1:alternativasMultipla:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:estratos:0:dimensao:0:resultados:1:alternativasMultipla:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:estratos:0:dimensao:0:resultados:1:msgMultipla");

		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:2:enunciadoDiscursiva");
		selenium.assertTextEquals("resposta 1 discursiva 1 integração", "avaliacao:estratos:0:dimensao:0:resultados:2:respostas:0:discursiva");

		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:3:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:3:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:3:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:3:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:3:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:3:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:3:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:3:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:3:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:estratos:0:dimensao:0:resultados:3:msgQuadroMultipla");

		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:4:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:4:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:estratos:0:dimensao:0:resultados:4:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 2", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:4:enunciados:1:percentual");

		selenium.assertAmountOfElements(5, By.className("resultadoEmbrulhado"));
	}

	private void segundaColetaResultadosVerificarExtratificada() {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão editada integração", "avaliacao:estratos:0:dimensao:0:nomeDimensao");

		selenium.assertTextEquals("Universidade Federal de Santa Catarina - 1 avaliador(es)", "avaliacao:estratos:0:estratificacao");

		selenium.assertTextEquals("enunciado objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:5:enunciadoObjetiva");
		selenium.assertTextEquals("0,0%", "avaliacao:estratos:0:dimensao:0:resultados:5:alternativasObjetiva:0:percentual");
		selenium.assertTextEquals("100,0%", "avaliacao:estratos:0:dimensao:0:resultados:5:alternativasObjetiva:1:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:estratos:0:dimensao:0:resultados:5:percentual");
		selenium.assertTextEquals("alternativa 1 objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:5:alternativasObjetiva:0:nome");
		selenium.assertTextEquals("alternativa 2 objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:5:alternativasObjetiva:1:nome");
		selenium.assertTextEquals("Sem resposta", "avaliacao:estratos:0:dimensao:0:resultados:5:nome");

		selenium.assertTextEquals("enunciado multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:6:enunciadoMultipla");
		selenium.assertTextEquals("alternativa 1 multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:6:alternativasMultipla:0:nome");
		selenium.assertTextEquals("alternativa 2 multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:6:alternativasMultipla:1:nome");
		selenium.assertTextEquals("0,0%", "avaliacao:estratos:0:dimensao:0:resultados:6:alternativasMultipla:0:percentual");
		selenium.assertTextEquals("100,0%", "avaliacao:estratos:0:dimensao:0:resultados:6:alternativasMultipla:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:estratos:0:dimensao:0:resultados:6:msgMultipla");

		selenium.assertTextEquals("enunciado discursiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:7:enunciadoDiscursiva");
		selenium.assertTextEquals("resposta 1 discursiva 2 integração", "avaliacao:estratos:0:dimensao:0:resultados:7:respostas:0:discursiva");

		selenium.assertTextEquals("enunciado quadro multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:8:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:8:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:8:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:8:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:8:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:8:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:8:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:8:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:8:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:estratos:0:dimensao:0:resultados:8:msgQuadroMultipla");

		selenium.assertTextEquals("enunciado quadro objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:9:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:9:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:estratos:0:dimensao:0:resultados:9:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 2 versão 1", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:1:nome");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:estratos:0:dimensao:0:resultados:9:enunciados:1:percentual");

		selenium.assertAmountOfElements(5, By.className("resultadoEmbrulhado"));
	}

	private void coletaResultadosVisualizarComPeriodoMaisRecenteEExtratificada() {
		selenium.selecionarElemento("form:coleta", 2);
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:avaliador", 2);
		selenium.selecionarElemento("form:estratificacao", 3);
		selenium.clicar("form:visualizar");
	}

	private void coletaResultadosVisualizarComPeriodoAnteriorEExtratificada() {
		selenium.selecionarElemento("form:coleta", 3);
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:avaliador", 2);
		selenium.selecionarElemento("form:estratificacao", 3);
		selenium.clicar("form:check_qualitativa_input");
		selenium.clicar("form:visualizar");
	}

	private void primeiraColetaQuestionarioCadastroAcessar() {
		selenium.clicar("menu:questionarios");
		selenium.clicar("form:cadastrarQuestionario");
	}

	private void primeiraColetaQuestionarioCadastroCadastrar() {
		selenium.digitar("form:titulo", "Integração");
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:papel", 2);
		selenium.clicar("form:salvar");
	}

	private void primeiraColetaQuestionarioEdicaoAcessar() {
		selenium.clicar("menu:questionarios");
		selenium.clicar("form:lista:0:editar");
	}

	private void segundaColetaQuestionarioEdicaoAcessar() {
		selenium.clicar("menu:questionarios");
		selenium.clicar("form:lista:0:editar");
	}

	private void segundaColetaQuestionarioEdicaoEditar() {
		selenium.clicar("form:editarQuestionario");
		selenium.digitar("formEditarQuestionario:editarTitulo", "Integração Editado");
		selenium.clicar("formEditarQuestionario:salvar");
		selenium.assertElementIsNotVisible("mdEditarQuestionario");
	}

	private void primeiraColetaQuestionarioEdicaoCadastrarDimensao() {
		selenium.clicar("form:adicionarDimensao");
		selenium.digitar("formAdicionarDimensao:nome", "dimensão integração");
		selenium.clicar("formAdicionarDimensao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarDimensao");
	}

	private void segundaColetaQuestionarioEdicaoEditarDimensao() {
		selenium.clicar("form:dimensoes:0:editarDimensao");
		selenium.digitar("formEditarDimensao:editarNome", "dimensão editada integração");
		selenium.clicar("formEditarDimensao:salvar");
		selenium.assertElementIsNotVisible("mdEditarDimensao");
	}

	private void primeiraColetaQuestionarioEdicaoCadastrarTopico() {
		selenium.clicar("form:adicionarTopico");
		selenium.digitar("formAdicionarTopico:nome", "topico integração");
		selenium.clicar("formAdicionarTopico:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarTopico");
	}

	private void segundaColetaQuestionarioEdicaoEditarTopico() {
		selenium.clicar("form:topicos:0:editarTopico");
		selenium.digitar("formEditarTopico:editarNome", "topico editado integração");
		selenium.clicar("formEditarTopico:salvar");
		selenium.assertElementIsNotVisible("mdEditarTopico");
	}

	private void primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoObjetiva() {
		selenium.clicar("form:topicos:0:questoes:0:editarQuestao");
		selenium.digitar("formEditar:editarEnunciado", "enunciado objetiva coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 objetiva coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 objetiva coleta 1 versão 2");
		selenium.clicar("formEditar:ativa_input");
		selenium.clicar("formEditar:salvar");
		selenium.assertElementIsNotVisible("mdEditarQuestao");
	}

	private void primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 multipla coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoMultipla() {
		selenium.clicar("form:topicos:0:questoes:1:editarQuestao");
		selenium.digitar("formEditar:editarEnunciado", "enunciado multipla coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 multipla coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 multipla coleta 1 versão 2");
		selenium.clicar("formEditar:ativa_input");
		selenium.clicar("formEditar:salvar");
		selenium.assertElementIsNotVisible("mdEditarQuestao");
	}

	private void primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoDiscursiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoDiscursiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado discursiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoDiscursiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoDiscursiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado discursiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoDiscursiva() {
		selenium.clicar("form:topicos:0:questoes:2:editarQuestao");
		selenium.digitar("formEditar:editarEnunciado", "enunciado discursiva coleta 1 versão 2");
		selenium.clicar("formEditar:ativa_input");
		selenium.clicar("formEditar:salvar");
		selenium.assertElementIsNotVisible("mdEditarQuestao");
	}

	private void primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoQuadroMultipla() {
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

	private void segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoQuadroMultipla() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroMultipla");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro multipla coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoQuadroMultipla() {
		selenium.clicar("form:topicos:0:questoes:3:editarQuestao");
		selenium.digitar("formEditar:editarEnunciado", "enunciado quadro multipla coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro multipla coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro multipla coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro multipla coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro multipla coleta 1 versão 2");
		selenium.clicar("formEditar:ativa_input");
		selenium.clicar("formEditar:salvar");
		selenium.assertElementIsNotVisible("mdEditarQuestao");
	}

	private void primeiraColetaQuestionarioEdicaoCadastrarPrimeiraQuestaoQuadroObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro objetiva coleta 1 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoCadastrarSegundaQuestaoQuadroObjetiva() {
		selenium.clicar("form:topicos:0:adicionarQuestaoQuadroObjetiva");
		selenium.digitar("formAdicionarQuestao:nome", "enunciado quadro objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addAlternativa");
		selenium.digitar("formAdicionarQuestao:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:addEnunciado");
		selenium.digitar("formAdicionarQuestao:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro objetiva coleta 2 versão 1");
		selenium.clicar("formAdicionarQuestao:salvar");
		selenium.assertElementIsNotVisible("mdAdicionarQuestao");
	}

	private void segundaColetaQuestionarioEdicaoEditarPrimeiraQuestaoQuadroObjetiva() {
		selenium.clicar("form:topicos:0:questoes:4:editarQuestao");
		selenium.digitar("formEditar:editarEnunciado", "enunciado quadro objetiva coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:0:nomeAlternativa", "alternativa 1 quadro objetiva coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaAlternativas:1:nomeAlternativa", "alternativa 2 quadro objetiva coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaQuestoes:0:nomeQuestao", "enunciado 1 quadro objetiva coleta 1 versão 2");
		selenium.digitar("formEditar:tabelaQuestoes:1:nomeQuestao", "enunciado 2 quadro objetiva coleta 1 versão 2");
		selenium.clicar("formEditar:ativa_input");
		selenium.clicar("formEditar:salvar");
		selenium.assertElementIsNotVisible("mdEditarQuestao");
	}

	private void primeiraColetaQuestionarioEdicaoVerificar() throws Exception {
		selenium.assertTextEquals("Editar o questionário Curso para Estudante", "titulo");
		selenium.assertTextEquals("Integração", "form:nomeDoQuestionario");
		selenium.assertTextEquals("dimensão integração", "form:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico integração", "form:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .dimensoes > .dimensao"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .questoes > .topico"));
		selenium.assertAmountOfElements(5, By.cssSelector(".questionario > .questoes > .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:0:objetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:1:multipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='form:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(9, By.xpath("//span[@id='form:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr/td"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(6, By.xpath("//span[@id='form:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr/td"));
	}

	private void segundaColetaQuestionarioEdicaoVerificar() throws Exception {
		selenium.assertTextEquals("Editar o questionário Curso para Estudante", "titulo");
		selenium.assertTextEquals("Integração Editado", "form:nomeDoQuestionario");
		selenium.assertTextEquals("dimensão editada integração", "form:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico editado integração", "form:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .dimensoes > .dimensao"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario > .questoes > .topico"));
		selenium.assertAmountOfElements(10, By.cssSelector(".questionario > .questoes > .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:0:objetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:1:multipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='form:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(9, By.xpath("//span[@id='form:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr/td"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(6, By.xpath("//span[@id='form:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr/td"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:5:objetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:6:multipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='form:topicos:0:questoes:8:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(9, By.xpath("//span[@id='form:topicos:0:questoes:8:quadroMultipla']/table/tbody/tr/td"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='form:topicos:0:questoes:9:quadroObjetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(6, By.xpath("//span[@id='form:topicos:0:questoes:9:quadroObjetiva']/table/tbody/tr/td"));
	}

	private void primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoObjetiva() throws Exception {
		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 1", "form:topicos:0:questoes:0:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 1 versão 1", "form:topicos:0:questoes:0:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 1 versão 1", "form:topicos:0:questoes:0:radio:1");
	}

	private void segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoObjetiva() throws Exception {
		selenium.assertTextEquals("Desativada", "form:topicos:0:questoes:0:desativada");
		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 2", "form:topicos:0:questoes:0:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 1 versão 2", "form:topicos:0:questoes:0:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 1 versão 2", "form:topicos:0:questoes:0:radio:1");
	}

	private void segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoObjetiva() throws Exception {
		selenium.assertElementNotExists("form:topicos:0:questoes:5:desativada");
		selenium.assertTextEquals("enunciado objetiva coleta 2 versão 1", "form:topicos:0:questoes:5:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 2 versão 1", "form:topicos:0:questoes:5:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 2 versão 1", "form:topicos:0:questoes:5:radio:1");
	}

	private void primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoMultipla() {
		selenium.assertTextEquals("enunciado multipla coleta 1 versão 1", "form:topicos:0:questoes:1:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 1", "form:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 1", "form:topicos:0:questoes:1:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

	private void segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoMultipla() {
		selenium.assertTextEquals("Desativada", "form:topicos:0:questoes:1:desativada");
		selenium.assertTextEquals("enunciado multipla coleta 1 versão 2", "form:topicos:0:questoes:1:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 2", "form:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 2", "form:topicos:0:questoes:1:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

	private void segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoMultipla() {
		selenium.assertElementNotExists("form:topicos:0:questoes:6:desativada");
		selenium.assertTextEquals("enunciado multipla coleta 2 versão 1", "form:topicos:0:questoes:6:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 2 versão 1", "form:topicos:0:questoes:6:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 2 versão 1", "form:topicos:0:questoes:6:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

	private void primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoDiscursiva() {
		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 1", "form:topicos:0:questoes:2:enunciadoDaQuestao");
	}

	private void segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoDiscursiva() {
		selenium.assertTextEquals("Desativada", "form:topicos:0:questoes:2:desativada");
		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 2", "form:topicos:0:questoes:2:enunciadoDaQuestao");
	}

	private void segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoDiscursiva() {
		selenium.assertElementNotExists("form:topicos:0:questoes:7:desativada");
		selenium.assertTextEquals("enunciado discursiva coleta 2 versão 1", "form:topicos:0:questoes:7:enunciadoDaQuestao");
	}

	private void primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroMultipla() {
		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 1", "form:topicos:0:questoes:3:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 1", "form:topicos:0:questoes:3:alternativasQuadroMultipla:0:alternativaQuadroMultipla");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 1", "form:topicos:0:questoes:3:alternativasQuadroMultipla:1:alternativaQuadroMultipla");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 1", "form:topicos:0:questoes:3:enunciadosQuadroMultipla:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 1", "form:topicos:0:questoes:3:enunciadosQuadroMultipla:1:enunciado");
	}

	private void segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroMultipla() {
		selenium.assertTextEquals("Desativada", "form:topicos:0:questoes:3:desativada");
		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 2", "form:topicos:0:questoes:3:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 2", "form:topicos:0:questoes:3:alternativasQuadroMultipla:0:alternativaQuadroMultipla");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 2", "form:topicos:0:questoes:3:alternativasQuadroMultipla:1:alternativaQuadroMultipla");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 2", "form:topicos:0:questoes:3:enunciadosQuadroMultipla:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 2", "form:topicos:0:questoes:3:enunciadosQuadroMultipla:1:enunciado");
	}

	private void segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoQuadroMultipla() {
		selenium.assertElementNotExists("form:topicos:0:questoes:8:desativada");
		selenium.assertTextEquals("enunciado quadro multipla coleta 2 versão 1", "form:topicos:0:questoes:8:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 2 versão 1", "form:topicos:0:questoes:8:alternativasQuadroMultipla:0:alternativaQuadroMultipla");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 2 versão 1", "form:topicos:0:questoes:8:alternativasQuadroMultipla:1:alternativaQuadroMultipla");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 2 versão 1", "form:topicos:0:questoes:8:enunciadosQuadroMultipla:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 2 versão 1", "form:topicos:0:questoes:8:enunciadosQuadroMultipla:1:enunciado");
	}

	private void primeiraColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroObjetiva() {
		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 1", "form:topicos:0:questoes:4:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 1", "form:topicos:0:questoes:4:alternativasQuadroObjetiva:0:alternativaQuadroObjetiva");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 1", "form:topicos:0:questoes:4:alternativasQuadroObjetiva:1:alternativaQuadroObjetiva");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 1", "form:topicos:0:questoes:4:enunciadosQuadroObjetiva:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 1", "form:topicos:0:questoes:4:enunciadosQuadroObjetiva:1:enunciado");
	}

	private void segundaColetaQuestionarioEdicaoVerificarPrimeiraQuestaoQuadroObjetiva() {
		selenium.assertTextEquals("Desativada", "form:topicos:0:questoes:4:desativada");
		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 2", "form:topicos:0:questoes:4:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 2", "form:topicos:0:questoes:4:alternativasQuadroObjetiva:0:alternativaQuadroObjetiva");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 2", "form:topicos:0:questoes:4:alternativasQuadroObjetiva:1:alternativaQuadroObjetiva");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 2", "form:topicos:0:questoes:4:enunciadosQuadroObjetiva:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 2", "form:topicos:0:questoes:4:enunciadosQuadroObjetiva:1:enunciado");
	}

	private void segundaColetaQuestionarioEdicaoVerificarSegundaQuestaoQuadroObjetiva() {
		selenium.assertElementNotExists("form:topicos:0:questoes:9:desativada");
		selenium.assertTextEquals("enunciado quadro objetiva coleta 2 versão 1", "form:topicos:0:questoes:9:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 2 versão 1", "form:topicos:0:questoes:9:alternativasQuadroObjetiva:0:alternativaQuadroObjetiva");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 2 versão 1", "form:topicos:0:questoes:9:alternativasQuadroObjetiva:1:alternativaQuadroObjetiva");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 2 versão 1", "form:topicos:0:questoes:9:enunciadosQuadroObjetiva:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 2 versão 1", "form:topicos:0:questoes:9:enunciadosQuadroObjetiva:1:enunciado");
	}

	private void coletaCadastroAcessar() throws Exception {
		selenium.selecionarItemDeMenu("menu:coleta", "menu:criar");
	}

	private void primeiraColetaCadastroCadastrar() throws Exception {
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

	private void segundaColetaCadastroCadastrar() throws Exception {
		selenium.selecionarElemento("form:ano", 2);
		selenium.selecionarElemento("form:periodo", 3);
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaSeguinte());
		selenium.descansar(5);
		selenium.selecionarElemento("form:foco", 2);
		selenium.clicar("form:avancar");
		selenium.clicar("form:avancar");
		selenium.assertTextEquals("Sera(ão) criado(s) 1 convite(s).", "form:messages");
		selenium.clicar("form:terminar");
		selenium.assertTextEquals("Envio de convites iniciado com sucesso.", "form:messages");
	}

	private void acessarOQuestionario() throws Exception {
		selenium.descansar(5);
		List<Convite> convites = obterConvites();
		assertEquals(1, convites.size());
		selenium.acessarComParametro("/saas/quest.jsf", "c", convites.get(0).getChave());
	}

	private void primeiraColetaQuestionarioResponderVerificar() throws Exception {
		selenium.assertTextEquals("Integração", "titulo");
		selenium.assertTextEquals("dimensão integração", "resposta:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico integração", "resposta:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .questoes .topico"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .dimensoes .dimensao"));
		selenium.assertAmountOfElements(5, By.cssSelector(".questionario .questoes .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:0:objetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:1:multipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='resposta:topicos:0:questoes:3:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:4:quadroObjetiva']/table/tbody/tr"));
	}

	private void segundaColetaQuestionarioResponderVerificar() throws Exception {
		selenium.assertTextEquals("Integração Editado", "titulo");
		selenium.assertTextEquals("dimensão editada integração", "resposta:dimensoes:0:dimensao");
		selenium.assertTextEquals("topico editado integração", "resposta:topicos:0:nomeDoTopico");
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .questoes .topico"));
		selenium.assertAmountOfElements(1, By.cssSelector(".questionario .dimensoes .dimensao"));
		selenium.assertAmountOfElements(5, By.cssSelector(".questionario .questoes .enunciado"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:5:objetiva']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:6:multipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(3, By.xpath("//span[@id='resposta:topicos:0:questoes:8:quadroMultipla']/table/tbody/tr"));
		selenium.assertAmountOfElements(2, By.xpath("//span[@id='resposta:topicos:0:questoes:9:quadroObjetiva']/table/tbody/tr"));
	}

	private void primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoObjetiva() {
		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:0:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:0:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:0:radio:1");
	}

	private void segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoObjetiva() {
		selenium.assertTextEquals("enunciado objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:5:enunciadoDaQuestao");
		selenium.assertTextEqualsForLabel("alternativa 1 objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:5:radio:0");
		selenium.assertTextEqualsForLabel("alternativa 2 objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:5:radio:1");
	}

	private void primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoMultipla() {
		selenium.assertTextEquals("enunciado multipla coleta 1 versão 1", "resposta:topicos:0:questoes:1:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 1", "resposta:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 1", "resposta:topicos:0:questoes:1:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

	private void segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoMultipla() {
		selenium.assertTextEquals("enunciado multipla coleta 2 versão 1", "resposta:topicos:0:questoes:6:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 multipla coleta 2 versão 1", "resposta:topicos:0:questoes:6:multiplaAlternativas:0:multiplaAlternativaLabel");
		selenium.assertTextEquals("alternativa 2 multipla coleta 2 versão 1", "resposta:topicos:0:questoes:6:multiplaAlternativas:1:multiplaAlternativaLabel");
	}

	private void primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoDiscursiva() {
		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 1", "resposta:topicos:0:questoes:2:enunciadoDaQuestao");
	}

	private void segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoDiscursiva() {
		selenium.assertTextEquals("enunciado discursiva coleta 2 versão 1", "resposta:topicos:0:questoes:7:enunciadoDaQuestao");
	}

	private void primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoQuadroMultipla() {
		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:alternativasQuadroMultipla:0:alternativaQuadroMultipla");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:alternativasQuadroMultipla:1:alternativaQuadroMultipla");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 1", "resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:1:enunciado");
	}

	private void segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoQuadroMultipla() {
		selenium.assertTextEquals("enunciado quadro multipla coleta 2 versão 1", "resposta:topicos:0:questoes:8:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 2 versão 1", "resposta:topicos:0:questoes:8:alternativasQuadroMultipla:0:alternativaQuadroMultipla");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 2 versão 1", "resposta:topicos:0:questoes:8:alternativasQuadroMultipla:1:alternativaQuadroMultipla");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 2 versão 1", "resposta:topicos:0:questoes:8:enunciadosQuadroMultipla:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 2 versão 1", "resposta:topicos:0:questoes:8:enunciadosQuadroMultipla:1:enunciado");
	}

	private void primeiraColetaQuestionarioPreenchimentoVerificarPrimeiraQuestaoQuadroObjetiva() {
		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:alternativasQuadroObjetiva:0:alternativaQuadroObjetiva");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:alternativasQuadroObjetiva:1:alternativaQuadroObjetiva");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 1", "resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:1:enunciado");
	}

	private void segundaColetaQuestionarioPreenchimentoVerificarSegundaQuestaoQuadroObjetiva() {
		selenium.assertTextEquals("enunciado quadro objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:9:enunciadoDaQuestao");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:9:alternativasQuadroObjetiva:0:alternativaQuadroObjetiva");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:9:alternativasQuadroObjetiva:1:alternativaQuadroObjetiva");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:9:enunciadosQuadroObjetiva:0:enunciado");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 2 versão 1", "resposta:topicos:0:questoes:9:enunciadosQuadroObjetiva:1:enunciado");
	}

	private void primeiraColetaQuestionarioPreenchimentoPreencher() {
		selenium.clicar("resposta:topicos:0:questoes:0:radio:0");
		selenium.clicar("resposta:topicos:0:questoes:1:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.digitar("resposta:topicos:0:questoes:2:textArea", "resposta 1 discursiva 1 integração");
		selenium.clicar("resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:0:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:3:enunciadosQuadroMultipla:1:multiplaAlternativas:0:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:0:linhaQuadro:0");
		selenium.clicar("resposta:topicos:0:questoes:4:enunciadosQuadroObjetiva:1:linhaQuadro:2");
		selenium.clicar("resposta:salvar");
	}

	private void segundaColetaQuestionarioPreenchimentoPreencher() {
		selenium.clicar("resposta:topicos:0:questoes:5:radio:1");
		selenium.clicar("resposta:topicos:0:questoes:6:multiplaAlternativas:1:multiplaAlternativa_input");
		selenium.digitar("resposta:topicos:0:questoes:7:textArea", "resposta 1 discursiva 2 integração");
		selenium.clicar("resposta:topicos:0:questoes:8:enunciadosQuadroMultipla:0:multiplaAlternativas:1:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:8:enunciadosQuadroMultipla:1:multiplaAlternativas:1:multiplaAlternativa_input");
		selenium.clicar("resposta:topicos:0:questoes:9:enunciadosQuadroObjetiva:0:linhaQuadro:1");
		selenium.clicar("resposta:topicos:0:questoes:9:enunciadosQuadroObjetiva:1:linhaQuadro:3");
		selenium.clicar("resposta:salvar");
	}

	public void primeiraColetaAvaliadorAvaliacoesVerificar() {
		selenium.assertTextEquals("Avaliações", "titulo");
		selenium.assertTextEquals("Questionário respondido com sucesso!", "mensagemQuestionario");
		selenium.assertTextEquals("Nenhuma avaliação pendente", "form:pendencias_data");
	}

	private void segundaColetaAvaliadorAvaliacoesVerificar() {
		selenium.assertTextEquals("Avaliações", "titulo");
		selenium.assertTextEquals("Questionário respondido com sucesso!", "mensagemQuestionario");
		selenium.assertTextEquals("Nenhuma avaliação pendente", "form:pendencias_data");
	}

	private void coletaEdicaoAcessar() {
		selenium.selecionarItemDeMenu("menu:coleta", "menu:coleta_listar");
		selenium.clicar("form:lista:0:editar");
	}

	private void primeiraColetaEdicaoFinalizar() {
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaAnterior());
		selenium.clicar("form:salvar");
		selenium.assertTextEquals(String.format("A coleta %d/1 foi atualizada com sucesso.", Calendario.obterAnoAtual()), "form:messages");
	}

	private void segundaColetaEdicaoFinalizar() {
		selenium.digitarDataEHora("form:encerramento_input", Calendario.obterDataDoDiaAnterior());
		selenium.clicar("form:salvar");
		selenium.assertTextEquals(String.format("A coleta %d/2 foi atualizada com sucesso.", Calendario.obterAnoAtual()), "form:messages");
	}

	private void acessarResultados() {
		selenium.selecionarItemDeMenu("menu:resultados", "menu:geraisNovo");
	}

	private void coletaResultadosVisualizarComPeriodoMaisRecente() {
		selenium.selecionarElemento("form:coleta", 2);
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:avaliador", 2);
		selenium.clicar("form:check_qualitativa_input");
		selenium.clicar("form:visualizar");
	}

	private void coletaResultadosVisualizarComPeriodoMaisAntigo() {
		selenium.selecionarElemento("form:coleta", 3);
		selenium.selecionarElemento("form:foco", 2);
		selenium.selecionarElemento("form:avaliador", 2);
		selenium.clicar("form:check_qualitativa_input");
		selenium.clicar("form:visualizar");
	}

	private void primeiraColetaResultadosVerificarPrimeirasVersoes() {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão integração", "avaliacao:dimensao:0:nomeDimensao");

		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:0:enunciadoObjetiva");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:percentual");
		selenium.assertTextEquals("alternativa 1 objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:nome");
		selenium.assertTextEquals("alternativa 2 objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:nome");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:0:nome");

		selenium.assertTextEquals("enunciado multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:1:enunciadoMultipla");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:percentual");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:nome");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:nome");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:1:msgMultipla");

		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:2:enunciadoDiscursiva");
		selenium.assertTextEquals("resposta 1 discursiva 1 integração", "avaliacao:dimensao:0:resultados:2:respostas:0:discursiva");

		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 1", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:3:msgQuadroMultipla");

		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:4:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 1", "avaliacao:dimensao:0:resultados:4:enunciados:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:percentual");

		selenium.assertAmountOfElements(5, By.className("resultadoEmbrulhado"));
	}

	private void primeiraColetaResultadosVerificarSegundasVersoes() {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão editada integração", "avaliacao:dimensao:0:nomeDimensao");

		selenium.assertTextEquals("enunciado objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:0:enunciadoObjetiva");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:0:percentual");
		selenium.assertTextEquals("alternativa 1 objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:0:nome");
		selenium.assertTextEquals("alternativa 2 objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:0:alternativasObjetiva:1:nome");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:0:nome");

		selenium.assertTextEquals("enunciado multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:1:enunciadoMultipla");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:percentual");
		selenium.assertTextEquals("alternativa 1 multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:0:nome");
		selenium.assertTextEquals("alternativa 2 multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:1:alternativasMultipla:1:nome");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:1:msgMultipla");

		selenium.assertTextEquals("enunciado discursiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:2:enunciadoDiscursiva");
		selenium.assertTextEquals("resposta 1 discursiva 1 integração", "avaliacao:dimensao:0:resultados:2:respostas:0:discursiva");

		selenium.assertTextEquals("enunciado quadro multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:3:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:3:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:3:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 1 versão 2", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:3:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:3:msgQuadroMultipla");

		selenium.assertTextEquals("enunciado quadro objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:4:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:4:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:4:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:4:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:4:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 1 versão 2", "avaliacao:dimensao:0:resultados:4:enunciados:1:nome");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:4:enunciados:1:percentual");

		selenium.assertAmountOfElements(5, By.className("resultadoEmbrulhado"));
	}

	private void segundaColetaResultadosVerificar() {
		selenium.assertTextEquals("Total de avaliadores: 1", "avaliacao:totalAvaliadores");
		selenium.assertTextEquals("dimensão editada integração", "avaliacao:dimensao:0:nomeDimensao");

		selenium.assertTextEquals("enunciado objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:5:enunciadoObjetiva");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:5:alternativasObjetiva:0:percentual");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:5:alternativasObjetiva:1:percentual");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:5:percentual");
		selenium.assertTextEquals("alternativa 1 objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:5:alternativasObjetiva:0:nome");
		selenium.assertTextEquals("alternativa 2 objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:5:alternativasObjetiva:1:nome");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:5:nome");

		selenium.assertTextEquals("enunciado multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:6:enunciadoMultipla");
		selenium.assertTextEquals("0,0%", "avaliacao:dimensao:0:resultados:6:alternativasMultipla:0:percentual");
		selenium.assertTextEquals("100,0%", "avaliacao:dimensao:0:resultados:6:alternativasMultipla:1:percentual");
		selenium.assertTextEquals("alternativa 1 multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:6:alternativasMultipla:0:nome");
		selenium.assertTextEquals("alternativa 2 multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:6:alternativasMultipla:1:nome");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:6:msgMultipla");

		selenium.assertTextEquals("enunciado discursiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:7:enunciadoDiscursiva");
		selenium.assertTextEquals("resposta 1 discursiva 2 integração", "avaliacao:dimensao:0:resultados:7:respostas:0:discursiva");

		selenium.assertTextEquals("enunciado quadro multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:8:enunciadoQuadroMultipla");
		selenium.assertTextEquals("alternativa 1 quadro multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:8:alternativasQuadroMultipla:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:8:alternativasQuadroMultipla:1:alternativa");
		selenium.assertTextEquals("enunciado 1 quadro multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:8:enunciadosQuadro:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro multipla coleta 2 versão 1", "avaliacao:dimensao:0:resultados:8:enunciadosQuadro:1:nome");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:8:enunciadosQuadro:0:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:8:enunciadosQuadro:1:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:8:enunciadosQuadro:0:valores:1:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:8:enunciadosQuadro:1:valores:1:percentual");
		selenium.assertTextEquals("Como a questão é de escolha múltipla, a soma dos percentuais pode ultrapassar 100%.", "avaliacao:dimensao:0:resultados:8:msgQuadroMultipla");

		selenium.assertTextEquals("enunciado quadro objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:9:enunciadoQuadroObjetiva");
		selenium.assertTextEquals("alternativa 1 quadro objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:9:alternativasQuadroObjetiva:0:alternativa");
		selenium.assertTextEquals("alternativa 2 quadro objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:9:alternativasQuadroObjetiva:1:alternativa");
		selenium.assertTextEquals("Sem resposta", "avaliacao:dimensao:0:resultados:9:nomeQuadro");
		selenium.assertTextEquals("enunciado 1 quadro objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:9:enunciados:0:nome");
		selenium.assertTextEquals("enunciado 2 quadro objetiva coleta 2 versão 1", "avaliacao:dimensao:0:resultados:9:enunciados:1:nome");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:9:enunciados:0:valores:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:9:enunciados:1:valores:0:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:9:enunciados:0:valores:1:percentual");
		selenium.assertTextEquals("100,0", "avaliacao:dimensao:0:resultados:9:enunciados:1:valores:1:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:9:enunciados:0:percentual");
		selenium.assertTextEquals("0,0", "avaliacao:dimensao:0:resultados:9:enunciados:1:percentual");

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
