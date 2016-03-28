package test.br.ufsc.etec.saas.estoria.reescritos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.etec.saas.fachadas.EmBanco;
import br.ufsc.ine.leb.projetos.estoria.Estoria;

@RunWith(Estoria.class)
public class Teste11InstanciaTeste {

	private Instancia teste;

	@Before
	public void configurar() throws Exception {
		teste = EmBanco.novaInstancia();
	}

	@Test
	public void testar() throws Exception {
		assertNotEquals(0, teste.getId().intValue());
	}

}
