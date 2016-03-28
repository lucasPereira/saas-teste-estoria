package test.br.ufsc.etec.saas.estoria;

import br.ufsc.etec.saas.auxiliar.Consulta;
import br.ufsc.etec.saas.banco.de.dados.ConsultorLista;
import br.ufsc.etec.saas.entidades.Instancia;
import br.ufsc.etec.saas.entidades.saas.Convite;

public class ConsultorListarConvitesNaoRespondidosDeColetasAbertas extends ConsultorLista<Convite, RuntimeException> {

	private Instancia instancia;

	public ConsultorListarConvitesNaoRespondidosDeColetasAbertas(Instancia instancia) {
		this.instancia = instancia;
	}

	@Override
	protected Class<Convite> fornecerTipoDeRetorno() {
		return Convite.class;
	}

	@Override
	protected Consulta fornecerConsulta() {
		Consulta consulta = new Consulta();
		consulta.selecionar("convite").de("Convite convite");
		consulta.onde("convite.dataResposta IS NULL").e("coleta.encerramento > NOW()").e("convite.instancia = :instancia");
		consulta.comParametro("instancia", instancia);
		return consulta;
	}
}
