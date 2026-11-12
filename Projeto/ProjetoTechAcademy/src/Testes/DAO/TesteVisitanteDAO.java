package Testes.DAO;

import DAO.VisitanteDAO;
import Dominio.Visitante;

public class TesteVisitanteDAO {
    private Visitante visit;

    private final VisitanteDAO dao;

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
        this.dao.readAll().forEach(Visitante::exibir);
    }

    private void criar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.visit = new Visitante(301, "Thiago da Silva", "98765432101",
                "thiago.silva@email.com", "(11) 98342-0621", "Rua das Flores, 180", "Reunião", "Desenvolvimento");
        dao.create(this.visit);
        this.visit.exibir();
    }

    private void alterar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** ALTERANDO REGISTRO *****");
        this.visit.setNome("Bolsonaro");
        this.visit = this.dao.update(this.visit);
        this.visit.exibir();
    }

    private void excluir(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** EXCLUINDO REGISTRO *****");
        this.visit = dao.delete(visit);
        this.visit.exibir();
    }

    public TesteVisitanteDAO(){
        this.dao = new VisitanteDAO();
    }
}
