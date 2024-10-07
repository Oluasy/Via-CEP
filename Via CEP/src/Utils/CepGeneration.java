package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CepGeneration {
    Scanner scanner = new Scanner(System.in);
    private List<String> listaDeCep;
    String cep = "";

    public String cepGeneration() {
        System.out.println("Digite o CEP que deseja fazer a busca ou 0 para cancelar a busca: ");
        cep = scanner.nextLine();
        listaDeCep.add(cep);

        if (cep.equalsIgnoreCase("0")) {
            System.out.println("Busca cancelada");
            cep = "";
        } else if (cep.length() != 8) {
            System.out.println("CEP informado não pode ser encotrado, coloque um CEP válido!");
            cep = "";
        }
        return cep;
    }

    public CepGeneration() {
        this.listaDeCep = new ArrayList<>();
    }

    public List<String> getListaDeCep() {
        return listaDeCep;
    }

}
