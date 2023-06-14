package unipar.exemplo.run;

import unipar.exemplo.entity.Produto;
import unipar.exemplo.repository.clientes.RepositoryCliente;
import unipar.exemplo.repository.produto.RepositoryProduto;

public class Main {

    public static void main(String[] args) {

        RepositoryProduto repo = new RepositoryProduto();

        Produto energetico = new Produto();
        energetico.setCodigo(4);
        energetico.setNome("coca");
        energetico.setEan("2312312");
        energetico.setPreco(5.79);

        repo.inserirProduto(energetico);

        repo.buscarProduto();

        RepositoryCliente cliente = new RepositoryCliente();
        cliente.buscarCliente();

    }

}
