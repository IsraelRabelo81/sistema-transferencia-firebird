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

    public boolean isFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(boolean fornecedores) {
        this.fornecedores = fornecedores;
    }

    public boolean isClientes() {
        return clientes;
    }

    public void setClientes(boolean clientes) {
        this.clientes = clientes;
    }

    public boolean isPorPeriodo() {
        return porPeriodo;
    }

    public void setPorPeriodo(boolean porPeriodo) {
        this.porPeriodo = porPeriodo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
