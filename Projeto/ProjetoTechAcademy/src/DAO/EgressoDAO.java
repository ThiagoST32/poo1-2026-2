package DAO;

import Dominio.Egresso;
import FakeDB.EgressoFakeDB;

public class EgressoDAO extends BaseGenericaDAO<Egresso> {
    @Override
    public Egresso create(Egresso novo) {
        int newCode = this.repositorio.getLast().getCodigo() + 1;
        novo.setCodigo(newCode);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Egresso readOne(int codigo) {
        return this.repositorio.stream()
                .filter(egresso -> egresso.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Egresso update(Egresso alterado) {
        if (readOne(alterado.getCodigo()) != null) {
            int index = this.repositorio.indexOf(alterado);
            this.repositorio.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Egresso deletePorID(int codigo) {
        Egresso paraApagar = readOne(codigo);
        if (paraApagar != null) {
            this.repositorio.remove(paraApagar);
            return paraApagar;
        }
        return null;
    }

    @Override
    public Egresso delete(Egresso apagado) {
        Egresso paraApagar = readOne(apagado.getCodigo());
        if (paraApagar != null) {
            this.repositorio.remove(paraApagar);
            return paraApagar;
        }
        return null;
    }

    public EgressoDAO() {
        this.fonteDados = new EgressoFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
