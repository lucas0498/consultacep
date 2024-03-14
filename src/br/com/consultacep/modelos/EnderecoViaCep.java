package br.com.consultacep.modelos;

public record EnderecoViaCep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
}
