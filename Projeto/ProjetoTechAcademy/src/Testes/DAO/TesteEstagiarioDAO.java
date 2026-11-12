package Testes.DAO;

import DAO.EstagiarioDAO;
import Dominio.Estagiario;

public class TesteEstagiarioDAO {

    private Estagiario est;

    private final EstagiarioDAO dao;

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
        this.dao.readAll().forEach(Estagiario::exibir);
    }

    private void criar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.est = new Estagiario(201, "Ana Paula", "12345678901",
                "ana.paula@techacademy.com", "(11) 99999-0001", 900.0, "Rua das Flores, 100", "Desenvolvimento", 30);
        dao.create(this.est);
        this.est.exibir();
    }

    private void alterar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** ALTERANDO REGISTRO *****");
        this.est.setNome("Bolsonaro");
        this.est = this.dao.update(this.est);
        this.est.exibir();
    }

    private void excluir() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** EXCLUINDO REGISTRO *****");
        this.est = dao.delete(est);
        this.est.exibir();
    }

    public TesteEstagiarioDAO() {
        this.dao = new EstagiarioDAO();
    }
}
