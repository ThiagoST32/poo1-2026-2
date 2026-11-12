package Testes.SRV;

import Dominio.Visitante;
import Servico.VisitanteSRV;

public class TesteVisitanteSRV {

    private Visitante visit;

    private final VisitanteSRV srv;

    public void executar(){
        this.listar();
        this.criar();
        this.listar();
        this.alterar();
        this.listar();
        this.excluir();
        this.listar();
    }

    private void listar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** LISTANDO TUDO *****");
        this.srv.listar().forEach(Visitante::exibir);
    }

    private void criar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.visit = new Visitante(301, "Thiago da Silva", "98765432101",
                "thiago.silva@email.com", "(11) 98342-0621", "Rua das Flores, 180", "Reunião", "Desenvolvimento");
        srv.criar(this.visit);
        this.visit.exibir();
    }

    private void alterar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** ALTERANDO REGISTRO *****");
        this.visit.setNome("Bolsonaro");
        this.visit = this.srv.alterar(this.visit);
        this.visit.exibir();
    }

    private void excluir(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** EXCLUINDO REGISTRO *****");
        this.visit = srv.excluirPorID(visit.getCodigo());
        this.visit.exibir();
    }

    public TesteVisitanteSRV(){
        this.srv = new VisitanteSRV();
    }
}
