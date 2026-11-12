package Testes.DAO;

import DAO.EgressoDAO;
import Dominio.Egresso;

public class TesteEgressoDAO {

    private Egresso est;

    private final EgressoDAO dao;

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
        this.dao.readAll().forEach(Egresso::exibir);
    }

    private void criar() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.est = new Egresso(301, "Lucas Silva", "12345678901", 2020, "Engenharia de Software", "Desenvolvimento");
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

    public TesteEgressoDAO() {
        this.dao = new EgressoDAO();
    }
}
