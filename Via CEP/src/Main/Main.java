package Main;

import Models.Address;
import Utils.ApiConnection;
import Utils.CepGeneration;
import Utils.FileGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CepGeneration generation = new CepGeneration();
        ApiConnection connection = new ApiConnection();
        String option = "";

        System.out.println("Bem vindo ao app da Via CEP");
        while (!option.equalsIgnoreCase("0")) {
            System.out.println("""
                    \nDigite a opção que desejar:
                                    
                    1- Pesquisar CEP;
                    2- Lista de CEPs pesquisados;
                                    
                    0- Finalizar""");
            System.out.println("Digite sua opção:");
            option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    try {
                        String wantedCep;
                        wantedCep = generation.cepGeneration();
                        Address newAddress = connection.cepSearch(wantedCep);
                        FileGenerator geradorJson = new FileGenerator();
                        geradorJson.geraJson(newAddress);
                        generation.getListaDeCep().add(String.valueOf(newAddress));
                        System.out.println(newAddress);
                    } catch (RuntimeException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("O arquivo Json com as informações do CEP foi criado com sucesso");
                }
                case "2" -> {
                    if (generation.getListaDeCep().isEmpty()) {
                        System.out.println("Nenhum CEP pesquisado até o momento, pesquise um CEP antes de selecionar essa opção.");
                    }
                    for (String lista : generation.getListaDeCep()) {
                        System.out.println(lista);
                    }
                }
                case "0" -> {
                    System.out.println("Obrigado por usar o Via CEP!");
                }
                default -> {
                    System.out.println("Opção inválida!");
                }
            }
        }
    }
}
