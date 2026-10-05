package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {
        pessoasFisicas.add(pessoa);
    }

    public void alterar(PessoaFisica pessoa) {

        for (int i = 0; i < pessoasFisicas.size(); i++) {

            if (pessoasFisicas.get(i).getId() == pessoa.getId()) {
                pessoasFisicas.set(i, pessoa);
                break;
            }
        }
    }

    public void excluir(int id) {

        for (int i = 0; i < pessoasFisicas.size(); i++) {

            if (pessoasFisicas.get(i).getId() == id) {
                pessoasFisicas.remove(i);
                break;
            }
        }
    }

    public PessoaFisica obter(int id) {

        for (PessoaFisica pessoa : pessoasFisicas) {

            if (pessoa.getId() == id) {
                return pessoa;
            }
        }

        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws Exception {

        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        ObjectOutputStream objeto = new ObjectOutputStream(arquivo);

        objeto.writeObject(pessoasFisicas);

        objeto.close();
        arquivo.close();
    }

    public void recuperar(String nomeArquivo) throws Exception {

        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        ObjectInputStream objeto = new ObjectInputStream(arquivo);

        pessoasFisicas = (ArrayList<PessoaFisica>) objeto.readObject();

        objeto.close();
        arquivo.close();
    }
}
