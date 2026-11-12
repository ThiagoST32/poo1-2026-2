package Servico;

import DAO.VisitanteDAO;
import Dominio.Visitante;

import java.util.ArrayList;

public class VisitanteSRV extends BaseGenericaSRV<Visitante> {
    @Override
    public ArrayList<Visitante> listar() {
        return this.dao.readAll();
    }

    @Override
    public Visitante buscar(int codigo) {
        return this.dao.readOne(codigo);
    }

    @Override
    public Visitante criar(Visitante novo) {
        return this.dao.create(novo);
    }

    @Override
    public Visitante alterar(Visitante alterado) {
        return this.dao.update(alterado);
    }

    @Override
    public Visitante excluirPorID(int codigo) {
        return this.dao.deletePorID(codigo);
    }

    public VisitanteSRV() {

        this.dao = new VisitanteDAO(); }
}
