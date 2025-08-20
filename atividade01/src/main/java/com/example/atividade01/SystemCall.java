package com.example.atividade01;

/**
 * Representa uma chamada de sistema (system call), o mecanismo fundamental pelo qual
 * um programa em modo de usuário solicita um serviço do kernel do sistema operacional.
 * Na vida real, isso envolve uma mudança de contexto do modo de usuário para o modo de núcleo.
 */
public class SystemCall {
    public static final String RECEIVE_DATA = "RECEIVE_DATA";

    private String type;
    private String data;

    /**
     * Cria uma nova chamada de sistema.
     * @param type O tipo da chamada (ex: "ler arquivo", "enviar dados de rede").
     * @param data Os dados associados à chamada.
     */
    public SystemCall(String type, String data) {
        this.type = type;
        this.data = data;
    }

    /**
     * Retorna o tipo da chamada de sistema.
     * @return O tipo da chamada.
     */
    public String getType() {
        return type;
    }

    /**
     * Retorna os dados associados à chamada.
     * @return Os dados da chamada.
     */
    public String getData() {
        return data;
    }
}
