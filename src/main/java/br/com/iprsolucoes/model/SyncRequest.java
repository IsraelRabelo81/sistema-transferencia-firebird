package br.com.iprsolucoes.model;

import java.time.LocalDate;

public class SyncRequest {
    private boolean produtos;
    private boolean fornecedores;
    private boolean clientes;

    private boolean porPeriodo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public boolean isProdutos() {
        return produtos;
    }

    public void setProdutos(boolean produtos) {
        this.produtos = produtos;
    }


}
