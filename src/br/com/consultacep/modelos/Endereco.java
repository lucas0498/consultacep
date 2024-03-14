package br.com.consultacep.modelos;

public class Endereco {
private String cep;
private String logradouro;
private String complemento;
private String bairro;
private String localidade;
private String uf;

    public Endereco(EnderecoViaCep enderecoViaCep) {
        this.cep = enderecoViaCep.cep();
        this.logradouro = enderecoViaCep.logradouro();
        this.complemento = enderecoViaCep.complemento();
        this.bairro = enderecoViaCep.bairro();
        this.localidade = enderecoViaCep.localidade();
        this.uf = enderecoViaCep.uf();
    }

    @Override
    public String toString() {
        return  "\n(CEP: " + cep + '\n' +
                "Logradouro: " + logradouro + '\n' +
                "Complemento: " + complemento + '\n' +
                "Bairro: " + bairro + '\n' +
                "Estado: " + localidade +"-"+uf +")";
    }
}
