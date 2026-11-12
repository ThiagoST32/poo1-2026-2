package Servico;

import DAO.EgressoDAO;
import Dominio.Egresso;

import java.util.ArrayList;

public class EgressoSRV extends BaseGenericaSRV<Egresso> {
    @Override
    public ArrayList<Egresso> listar() {
        return this.dao.readAll();
    }

    @Override
    public Egresso buscar(int codigo) {
        return this.dao.readOne(codigo);
    }

    @Override
    public Egresso criar(Egresso novo) {
        return this.dao.create(novo);
    }

    @Override
    public Egresso alterar(Egresso alterado) {
        return this.dao.update(alterado);
    }

    @Override
    public Egresso excluirPorID(int codigo) {
        return this.dao.deletePorID(codigo);
    }

    public EgressoSRV() {
        this.dao = new EgressoDAO();
    }
}
