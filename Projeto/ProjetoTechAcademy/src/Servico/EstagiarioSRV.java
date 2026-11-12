package Servico;

import DAO.EstagiarioDAO;
import Dominio.Estagiario;

import java.util.ArrayList;

public class EstagiarioSRV extends BaseGenericaSRV<Estagiario> {
    @Override
    public ArrayList<Estagiario> listar() { return this.dao.readAll(); }

    @Override
    public Estagiario buscar(int codigo) { return this.dao.readOne(codigo); }

    @Override
    public Estagiario criar(Estagiario novo) { return this.dao.create(novo); }

    @Override
    public Estagiario alterar(Estagiario alterado) { return this.dao.update(alterado); }

    @Override
    public Estagiario excluirPorID(int codigo) { return this.dao.deletePorID(codigo); }

    public EstagiarioSRV() { this.dao = new EstagiarioDAO(); }
}
