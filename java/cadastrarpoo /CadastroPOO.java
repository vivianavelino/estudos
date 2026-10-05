package cadastropoo;

import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println();
            System.out.println("==============================");
            System.out.println("     CADASTRO DE CLIENTES");
            System.out.println("==============================");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {

                case 1:

                    System.out.println();
                    System.out.println("1 - Pessoa Fisica");
                    System.out.println("2 - Pessoa Juridica");
                    System.out.print("Escolha o tipo: ");

                    int tipoInclusao =
                            Integer.parseInt(teclado.nextLine());

                    if (tipoInclusao == 1) {

                        System.out.print("ID: ");
                        int id = Integer.parseInt(teclado.nextLine());

                        System.out.print("Nome: ");
                        String nome = teclado.nextLine();

                        System.out.print("CPF: ");
                        String cpf = teclado.nextLine();

                        System.out.print("Idade: ");
                        int idade = Integer.parseInt(teclado.nextLine());

                        PessoaFisica pessoa =
                                new PessoaFisica(id, nome, cpf, idade);

                        repoFisica.inserir(pessoa);

                        System.out.println("Pessoa fisica cadastrada.");

                    } else if (tipoInclusao == 2) {

                        System.out.print("ID: ");
                        int id = Integer.parseInt(teclado.nextLine());

                        System.out.print("Nome: ");
                        String nome = teclado.nextLine();

                        System.out.print("CNPJ: ");
                        String cnpj = teclado.nextLine();

                        PessoaJuridica pessoa =
                                new PessoaJuridica(id, nome, cnpj);

                        repoJuridica.inserir(pessoa);

                        System.out.println("Pessoa juridica cadastrada.");

                    } else {

                        System.out.println("Tipo invalido.");
                    }

                    break;

                case 2:

                    System.out.println();
                    System.out.println("1 - Pessoa Fisica");
                    System.out.println("2 - Pessoa Juridica");
                    System.out.print("Escolha o tipo: ");

                    int tipoAlteracao =
                            Integer.parseInt(teclado.nextLine());

                    System.out.print("Digite o ID: ");
                    int idAlteracao =
                            Integer.parseInt(teclado.nextLine());

                    if (tipoAlteracao == 1) {

                        PessoaFisica pessoa =
                                repoFisica.obter(idAlteracao);

                        if (pessoa != null) {

                            System.out.println();
                            System.out.println("Dados atuais:");
                            pessoa.exibir();

                            System.out.println();
                            System.out.println("Digite os novos dados:");

                            System.out.print("Nome: ");
                            String nome = teclado.nextLine();

                            System.out.print("CPF: ");
                            String cpf = teclado.nextLine();

                            System.out.print("Idade: ");
                            int idade =
                                    Integer.parseInt(teclado.nextLine());

                            PessoaFisica novaPessoa =
                                    new PessoaFisica(
                                            idAlteracao,
                                            nome,
                                            cpf,
                                            idade
                                    );

                            repoFisica.alterar(novaPessoa);

                            System.out.println("Cadastro alterado.");

                        } else {

                            System.out.println("Pessoa nao encontrada.");
                        }

                    } else if (tipoAlteracao == 2) {

                        PessoaJuridica pessoa =
                                repoJuridica.obter(idAlteracao);

                        if (pessoa != null) {

                            System.out.println();
                            System.out.println("Dados atuais:");
                            pessoa.exibir();

                            System.out.println();
                            System.out.println("Digite os novos dados:");

                            System.out.print("Nome: ");
                            String nome = teclado.nextLine();

                            System.out.print("CNPJ: ");
                            String cnpj = teclado.nextLine();

                            PessoaJuridica novaPessoa =
                                    new PessoaJuridica(
                                            idAlteracao,
                                            nome,
                                            cnpj
                                    );

                            repoJuridica.alterar(novaPessoa);

                            System.out.println("Cadastro alterado.");

                        } else {

                            System.out.println("Pessoa nao encontrada.");
                        }

                    } else {

                        System.out.println("Tipo invalido.");
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("1 - Pessoa Fisica");
                    System.out.println("2 - Pessoa Juridica");
                    System.out.print("Escolha o tipo: ");

                    int tipoExclusao =
                            Integer.parseInt(teclado.nextLine());

                    System.out.print("Digite o ID: ");
                    int idExclusao =
                            Integer.parseInt(teclado.nextLine());

                    if (tipoExclusao == 1) {

                        PessoaFisica pessoa =
                                repoFisica.obter(idExclusao);

                        if (pessoa != null) {

                            repoFisica.excluir(idExclusao);

                            System.out.println("Pessoa fisica excluida.");

                        } else {

                            System.out.println("Pessoa nao encontrada.");
                        }

                    } else if (tipoExclusao == 2) {

                        PessoaJuridica pessoa =
                                repoJuridica.obter(idExclusao);

                        if (pessoa != null) {

                            repoJuridica.excluir(idExclusao);

                            System.out.println("Pessoa juridica excluida.");

                        } else {

                            System.out.println("Pessoa nao encontrada.");
                        }

                    } else {

                        System.out.println("Tipo invalido.");
                    }

                    break;

                case 4:

                    System.out.println();
                    System.out.println("1 - Pessoa Fisica");
                    System.out.println("2 - Pessoa Juridica");
                    System.out.print("Escolha o tipo: ");

                    int tipoObter =
                            Integer.parseInt(teclado.nextLine());

                    System.out.print("Digite o ID: ");
                    int idObter =
                            Integer.parseInt(teclado.nextLine());

                    if (tipoObter == 1) {

                        PessoaFisica pessoa =
                                repoFisica.obter(idObter);

                        if (pessoa != null) {

                            System.out.println();
                            pessoa.exibir();

                        } else {

                            System.out.println("Pessoa nao encontrada.");
                        }

                    } else if (tipoObter == 2) {

                        PessoaJuridica pessoa =
                                repoJuridica.obter(idObter);

                        if (pessoa != null) {

                            System.out.println();
                            pessoa.exibir();

                        } else {

                            System.out.println("Pessoa nao encontrada.");
                        }

                    } else {

                        System.out.println("Tipo invalido.");
                    }

                    break;

                case 5:

                    System.out.println();
                    System.out.println("1 - Pessoa Fisica");
                    System.out.println("2 - Pessoa Juridica");
                    System.out.print("Escolha o tipo: ");

                    int tipoTodos =
                            Integer.parseInt(teclado.nextLine());

                    if (tipoTodos == 1) {

                        System.out.println();
                        System.out.println("PESSOAS FISICAS");

                        for (PessoaFisica pessoa :
                                repoFisica.obterTodos()) {

                            pessoa.exibir();
                            System.out.println();
                        }

                    } else if (tipoTodos == 2) {

                        System.out.println();
                        System.out.println("PESSOAS JURIDICAS");

                        for (PessoaJuridica pessoa :
                                repoJuridica.obterTodos()) {

                            pessoa.exibir();
                            System.out.println();
                        }

                    } else {

                        System.out.println("Tipo invalido.");
                    }

                    break;

                case 6:

                    System.out.print(
                            "Digite o prefixo dos arquivos: "
                    );

                    String prefixoSalvar = teclado.nextLine();

                    try {

                        repoFisica.persistir(
                                prefixoSalvar + ".fisica.bin"
                        );

                        repoJuridica.persistir(
                                prefixoSalvar + ".juridica.bin"
                        );

                        System.out.println(
                                "Dados salvos com sucesso."
                        );

                    } catch (Exception e) {

                        System.out.println(
                                "Erro ao salvar os dados."
                        );

                        System.out.println(
                                "Detalhes: " + e.getMessage()
                        );
                    }

                    break;

                case 7:

                    System.out.print(
                            "Digite o prefixo dos arquivos: "
                    );

                    String prefixoRecuperar = teclado.nextLine();

                    try {

                        repoFisica.recuperar(
                                prefixoRecuperar + ".fisica.bin"
                        );

                        repoJuridica.recuperar(
                                prefixoRecuperar + ".juridica.bin"
                        );

                        System.out.println(
                                "Dados recuperados com sucesso."
                        );

                    } catch (Exception e) {

                        System.out.println(
                                "Erro ao recuperar os dados."
                        );

                        System.out.println(
                                "Detalhes: " + e.getMessage()
                        );
                    }

                    break;

                case 0:

                    System.out.println();
                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }
        }

        teclado.close();
    }
}
