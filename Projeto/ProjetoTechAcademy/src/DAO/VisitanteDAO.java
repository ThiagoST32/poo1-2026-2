package DAO;

import Dominio.Visitante;
import FakeDB.VisitanteFakeDB;

public class VisitanteDAO extends BaseGenericaDAO<Visitante> {

    @Override
    public Visitante create(Visitante novo) {
        int newCode = this.repositorio.getLast().getCodigo() + 1;
        novo.setCodigo(newCode);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Visitante readOne(int codigo) {
        return this.repositorio.stream()
                .filter(visitante -> visitante.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Visitante update(Visitante alterado) {
        if (readOne(alterado.getCodigo()) != null) {
            int index = this.repositorio.indexOf(alterado);
            this.repositorio.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Visitante deletePorID(int codigo) {
        Visitante paraApagar = readOne(codigo);
        if (paraApagar != null) {
            this.repositorio.remove(paraApagar);
            return paraApagar;
        }
        return null;
    }

    @Override
    public Visitante delete(Visitante apagado) {
        Visitante paraApagar = readOne(apagado.getCodigo());
        if (paraApagar != null) {
            this.repositorio.remove(paraApagar);
            return paraApagar;
        }
        return null;
    }

    public VisitanteDAO() {
        this.fonteDados = new VisitanteFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
