package br.com.iprsolucoes.service;

import br.com.iprsolucoes.model.SyncRequest;

public class SyncService {

    public void executar(SyncRequest request) {
        if (request.isProdutos()) {
            syncProdutos(request);
        }

        if (request.isFornecedores()) {
            syncFornecedores(request);
        }

        if (request.isClientes()) {
            syncClientes(request);
        }
    }
}
