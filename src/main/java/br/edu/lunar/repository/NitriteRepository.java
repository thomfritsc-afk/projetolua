package br.edu.lunar.repository;

import br.edu.lunar.model.Missao;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.ArrayList;
import java.util.List;

public class NitriteRepository {

    private final ObjectRepository<Missao> repo;

    public NitriteRepository() {
        Nitrite db = Nitrite.builder()
                .filePath("missoes.db")
                .openOrCreate();

        repo = db.getRepository(Missao.class);
    }

    public void salvar(Missao m) {
        repo.update(m, true);
    }

    public List<Missao> listar() {
        return new ArrayList<>(repo.find().toList());
    }
}
