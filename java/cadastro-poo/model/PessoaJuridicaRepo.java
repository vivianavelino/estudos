package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {
        pessoasJuridicas.add(pessoa);
    }

    public void alterar(PessoaJuridica pessoa) {

        for (int i = 0; i < pessoasJuridicas.size(); i++) {

            if (pessoasJuridicas.get(i).getId() == pessoa.getId()) {
                pessoasJuridicas.set(i, pessoa);
                break;
            }
        }
    }

    public void excluir(int id) {

        for (int i = 0; i < pessoasJuridicas.size(); i++) {

            if (pessoasJuridicas.get(i).getId() == id) {
                pessoasJuridicas.remove(i);
                break;
            }
        }
    }

    public PessoaJuridica obter(int id) {

        for (PessoaJuridica pessoa : pessoasJuridicas) {

            if (pessoa.getId() == id) {
                return pessoa;
            }
        }

        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws Exception {

        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        ObjectOutputStream objeto = new ObjectOutputStream(arquivo);

        objeto.writeObject(pessoasJuridicas);

        objeto.close();
        arquivo.close();
    }

    public void recuperar(String nomeArquivo) throws Exception {

        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        ObjectInputStream objeto = new ObjectInputStream(arquivo);

        pessoasJuridicas = (ArrayList<PessoaJuridica>) objeto.readObject();

        objeto.close();
        arquivo.close();
    }
}
