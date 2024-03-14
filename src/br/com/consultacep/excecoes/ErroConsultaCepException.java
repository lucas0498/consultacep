package br.com.consultacep.excecoes;

public class ErroConsultaCepException extends RuntimeException {
    private String mensagem;
    public ErroConsultaCepException(String mensagem) {
        this.mensagem = mensagem;

    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
