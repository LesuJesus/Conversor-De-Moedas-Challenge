package modulos;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class ConverteMoeda {
    Scanner leitura = new Scanner(System.in);
    ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas();
    public void menuPrincipal() throws IOException, InterruptedException {
        var escolha = 0;

        while(escolha != 7){

            System.out.println("\n" + """
                    
                    ***************************************
                    
                     Bem vindo ao conversor de moedas!
                 
                     1) BRL -> USD
                     2) USD -> BRL
                     3) BRL -> Euro
                     4) Euro -> BRL
                     5) BRL -> Peso Argentino
                     6) Peso Argentino -> BRL
                     7) Sair
                   
                    ****************************************               
                    """ + "\n");

            System.out.println("Digite o número da opção que deseja acessar");
            escolha = leitura.nextInt();

            switch (escolha){
                case 1:
                    converterAsMoedas("BRL", "USD", "Real");
                    break;
                case 2:
                    converterAsMoedas("USD", "BRL", "Dólar");
                    break;
                case 3:
                    converterAsMoedas("BRL", "EUR", "Real");
                    break;
                case 4:
                    converterAsMoedas("EUR", "BRL", "Euro");
                    break;
                case 5:
                    converterAsMoedas("BRL", "ARS", "Real");
                    break;
                case 6:
                    converterAsMoedas("ARS", "BRL", "Peso Argentino");
                    break;
                case 7:
                    System.out.println("finalizando a operação");
                    break;
                default:
                    System.out.println("Opção inválida tente novamente!");
                    break;
            }
        }
    }

    public ConversorDeMoedas converterAsMoedas(String primeiraMoeda, String segundaMoeda, String nomeDaMoeda) throws IOException, InterruptedException {
        System.out.println(primeiraMoeda + " será convertido para: " + segundaMoeda);
        System.out.println("Digite o valor: ");
        double valor = leitura.nextDouble();

        var moedas = conversorDeMoedas.consultarMoeda(primeiraMoeda, segundaMoeda, nomeDaMoeda);
        var taxaDeConversao = moedas.conversion_rate();
        var resultado = valor * taxaDeConversao;


        System.out.printf("O valor de " + valor + " " + primeiraMoeda + " convertido para " + segundaMoeda + " com a taxa de conversão de: " + taxaDeConversao + " por " + nomeDaMoeda +" é igual a: " + resultado + " " + segundaMoeda);
        return conversorDeMoedas;
    }
}
