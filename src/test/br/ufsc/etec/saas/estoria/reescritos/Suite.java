package test.br.ufsc.etec.saas.estoria.reescritos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.Estoria;

@SuiteClasses({
		Teste11InstanciaTeste.class,
		Teste12Selenium.class,
		Teste13AdministradoraBeatriz.class,
		Teste14InstituicaoUfsc.class,
		Teste15GerenteDouglas.class,
		Teste16CursoCienciasDaComputacao.class,
		Teste17OfertaCursoCienciasDaComputacao.class,
		Teste18PoloUfscDeJaragua.class,
		Teste19PoloUfscDeJaraguaEmOfertaCursoCienciasDaComputacao.class,
		Teste20AvaliadorJhon.class,
		Teste21AvaliadorJhonEmOfertaCursoCienciasDaComputacao.class,
		Teste22QuestionarioIntegracao.class,
		Teste23ColetaIntegracaoAberta.class,
		Teste24RespostaIntegracao.class,
		Teste25Avaliacoes.class,
		Teste26ColetaIntegracaoFechada.class,
		Teste27ResultadoIntegracao.class
})
@RunWith(Estoria.class)
public class Suite {

}
