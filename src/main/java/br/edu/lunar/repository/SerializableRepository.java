package br.edu.lunar.repository;

import br.edu.lunar.model.Missao;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableRepository {

    private final File arquivo = new File("missoes_serializadas.bin");

    public void salvar(List<Missao> missoes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(missoes);
        } catch (Exception e) {
            System.out.println("Erro ao salvar serialização: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Missao> carregar() {
        if (!arquivo.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Missao>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
