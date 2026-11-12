package Testes.SRV;

import Dominio.Estagiario;
import Servico.EstagiarioSRV;

public class TesteEstagiarioSRV {
    private Estagiario est;

    private final EstagiarioSRV srv;

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
        this.srv.listar().forEach(Estagiario::exibir);
    }

    private void criar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.est = new Estagiario(201, "Ana Paula", "12345678901", "ana.paula@techacademy.com", "(11) 99999-0001", 900.0, "Rua das Flores, 100", "Desenvolvimento", 30);
        srv.criar(this.est);
        this.est.exibir();
    }

    private void alterar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** ALTERANDO REGISTRO *****");
        this.est.setNome("Bolsonaro");
        this.est = this.srv.alterar(this.est);
        this.est.exibir();
    }

    private void excluir() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** EXCLUINDO REGISTRO *****");
        this.est = srv.excluirPorID(est.getCodigo());
        this.est.exibir();
    }

    public TesteEstagiarioSRV() {
        this.srv = new EstagiarioSRV();
    }
}
