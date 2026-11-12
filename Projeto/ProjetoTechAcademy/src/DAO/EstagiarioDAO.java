package DAO;

import Dominio.Estagiario;
import FakeDB.EstagiarioFakeDB;

public class EstagiarioDAO extends BaseGenericaDAO<Estagiario> {

    @Override
    public Estagiario create(Estagiario novo) {
        int newCode = this.repositorio.getLast().getCodigo() + 1;
        novo.setCodigo(newCode);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Estagiario readOne(int codigo) {
        return this.repositorio.stream()
                .filter(estagiario -> estagiario.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Estagiario update(Estagiario alterado) {
        if (readOne(alterado.getCodigo()) != null) {
            int index = this.repositorio.indexOf(alterado);
            this.repositorio.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Estagiario deletePorID(int codigo) {
        Estagiario paraApagar = readOne(codigo);
        if (paraApagar != null) {
            this.repositorio.remove(paraApagar);
            return paraApagar;
        }
        return null;
    }

    @Override
    public Estagiario delete(Estagiario apagado) {
        Estagiario paraApagar = readOne(apagado.getCodigo());
        if (paraApagar != null) {
            this.repositorio.remove(paraApagar);
            return paraApagar;
        }
        return null;
    }

    public EstagiarioDAO() {
        this.fonteDados = new EstagiarioFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
