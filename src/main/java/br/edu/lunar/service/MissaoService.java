package br.edu.lunar.service;

import br.edu.lunar.model.Astronauta;
import br.edu.lunar.model.Missao;
import br.edu.lunar.repository.SerializableRepository;
import br.edu.lunar.repository.NitriteRepository;

import java.util.ArrayList;
import java.util.List;

public class MissaoService {

    private List<Missao> missoes = new ArrayList<>();

    private final SerializableRepository serialRepo = new SerializableRepository();
    private final NitriteRepository nitRepo = new NitriteRepository();

    public MissaoService() {
        missoes = serialRepo.carregar();
    }

    public void registrarMissao(Missao m) {
        for (Missao x : missoes)
            if (x.getCodigo().equalsIgnoreCase(m.getCodigo()))
                throw new IllegalArgumentException("Código já existe.");

        missoes.add(m);
        serialRepo.salvar(missoes);
        nitRepo.salvar(m);
    }

    public void adicionarAstronauta(String codigo, Astronauta a) {
        Missao m = buscar(codigo);
        if (m == null) throw new IllegalArgumentException("Missão não encontrada.");

        m.adicionarAstronauta(a);
        serialRepo.salvar(missoes);
        nitRepo.salvar(m);
    }

    public List<Missao> listar() { return missoes; }

    public Missao buscar(String codigo) {
        return missoes.stream()
                .filter(m -> m.getCodigo().equalsIgnoreCase(codigo))
                .findFirst().orElse(null);
    }

    public void registrarResultado(String codigo, String res) {
        Missao m = buscar(codigo);
        if (m == null) throw new IllegalArgumentException("Missão não existe.");

        m.setResultadoCientifico(res);
        serialRepo.salvar(missoes);
        nitRepo.salvar(m);
    }
}
