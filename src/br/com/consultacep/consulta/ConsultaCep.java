package br.com.consultacep.consulta;

import br.com.consultacep.excecoes.ErroConsultaCepException;
import br.com.consultacep.modelos.Endereco;
import br.com.consultacep.modelos.EnderecoViaCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaCep {
    List<Endereco> listaDeEnderecos = new ArrayList<>();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void ConsultaEndereco() throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String cep = "";
        while(!cep.equalsIgnoreCase("sair")){
            System.out.println("Digite seu cep: ");
            cep = leitura.nextLine();
            if(cep.equalsIgnoreCase("sair")){
                break;
            }
            try{

                String url = "https://viacep.com.br/ws/"+cep+"/json/";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url.replaceAll("-", "")))
                        .build();
                HttpResponse<String>response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 400){
                    throw new ErroConsultaCepException("CEP Invalido!");
                }
                String json = response.body();
                EnderecoViaCep enderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
                Endereco meuEndereco = new Endereco(enderecoViaCep);
                listaDeEnderecos.add(meuEndereco);
                System.out.println(meuEndereco);

            } catch (ErroConsultaCepException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void SalvarArquivo() throws IOException {
        System.out.println(listaDeEnderecos);
        FileWriter escreva = new FileWriter("enderecos.json");
        escreva.write(gson.toJson(listaDeEnderecos));
        escreva.close();
        System.out.println("Arquivo salvo com sucesso!");

    }
}
