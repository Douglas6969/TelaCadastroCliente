package unipar.exemplo.repository.produto;

import unipar.exemplo.connection.ConnectionGeneric;
import unipar.exemplo.entity.Produto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProduto {

    public Integer inserirProduto(Produto produto){

        try {
            ConnectionGeneric connection = new ConnectionGeneric();
            connection.getConnection();

            String query = "INSERT INTO produtos (codigo, nome, ean, preco) VALUES ("
                                        + produto.getCodigo() + ",'"
                                        + produto.getNome()
                                        +"','" + produto.getEan()+ "',"
                                        + produto.getPreco() +")";
            System.out.println(query);

            Integer retorno = connection.statement.executeUpdate(query);

            /*if (retorno == 1){
                System.out.println("CADASTRADO COM SUCESSO");
            }else{
                System.out.println("PROBLEMA AO CADASTRAR");
            }*/

            connection.closeConnection();

            return retorno;

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }


    }
    public void alterarProduto(){}
    public void deletarProduto(){}
    public List<Produto> buscarProduto(){

        ConnectionGeneric connection = new ConnectionGeneric();
        try{
            List<Produto> listaRetorno = new ArrayList<>();

            connection.getConnection();

            String query = "SELECT * FROM produtos";

            ResultSet result = connection.statement.executeQuery(query);

            while (result.next()){
                //Retona dados do banco
                Integer codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ean = result.getString("ean");
                Double preco = result.getDouble("preco");


              //joga os dados em objeto do banco
              Produto produtoBanco = new Produto();
              produtoBanco.setCodigo(codigo);
              produtoBanco.setNome(nome);
              produtoBanco.setEan(ean);
              produtoBanco.setPreco(preco);

              listaRetorno.add(produtoBanco);



               /* System.out.println("-----------------");
                System.out.println("Cadastro produto");
                System.out.println("Código : " + codigo);
                System.out.println("Nome : " + nome);
                System.out.println("EAN : " + ean);
                System.out.println("Preço : " + preco);
                System.out.println("-----------------");*/
            }

            connection.closeConnection();
            return listaRetorno;

        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

}
