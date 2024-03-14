package br.com.consultacep.principal;

import br.com.consultacep.consulta.ConsultaCep;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaCep consultar = new ConsultaCep();
        consultar.ConsultaEndereco();
        consultar.SalvarArquivo();
    }
}
