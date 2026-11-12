package Testes.SRV;

import Dominio.Egresso;
import Servico.EgressoSRV;

public class TesteEgressoSRV {

    private Egresso egre;

    private final EgressoSRV srv;

    public void executar() {
        this.listar();
        this.criar();
        this.listar();
        this.alterar();
        this.listar();
        this.excluir();
        this.listar();
    }

    private void listar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** LISTANDO TUDO *****");
        this.srv.listar().forEach(Egresso::exibir);
    }

    private void criar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.egre = new Egresso(301, "Lucas Silva", "12345678901", 2020, "Engenharia de Software", "Desenvolvimento");
        srv.criar(this.egre);
        this.egre.exibir();
    }

    private void alterar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** ALTERANDO REGISTRO *****");
        this.egre.setNome("Bolsonaro");
        this.egre = this.srv.alterar(this.egre);
        this.egre.exibir();
    }

    private void excluir() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** EXCLUINDO REGISTRO *****");
        this.egre = srv.excluirPorID(egre.getCodigo());
        this.egre.exibir();
    }

    public TesteEgressoSRV() {
        this.srv = new EgressoSRV();
    }
}
