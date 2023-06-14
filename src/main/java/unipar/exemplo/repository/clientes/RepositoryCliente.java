package unipar.exemplo.repository.clientes;

import unipar.exemplo.connection.ConnectionGeneric;
import unipar.exemplo.entity.Cliente;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class repositoryClientes {

    public Integer inserirCliente(Cliente cliente){

        try {
            //conexao
            ConnectionGeneric connection = new ConnectionGeneric();
            connection.getConnection();

            //insertBD
            String query = "INSERT INTO clientes (idCliente, nome, cnpj, telefone, email, situacao, cidade, estado, credito)" +
                    "VALUES ("+cliente.getIdCliente()+", '"+cliente.getNome()+"', '"+cliente.getCnpj()
                    + "','" +cliente.getTelefone() +"', '"+cliente.getEmail()+"', '"+cliente.getSituacao()+"', '"+cliente.getCidade()+"', '"+cliente.getEstado()+"'" +
                    ", '"+cliente.getCredito()+"' )";
            Integer retorno = connection.statement.executeUpdate(query);
            connection.closeConnection();
            return retorno;

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
    public void alterarCliente(){}
    public void deletarClinte(){}
    public List<Cliente> buscarCliente(){

        ConnectionGeneric connection = new ConnectionGeneric();
        try{
            connection.getConnection();
            String query = "SELECT * FROM clientes";

            ResultSet result = connection.statement.executeQuery(query);

            List<Cliente> listaRetorno = new ArrayList<>();

            while (result.next()){

                Integer idCliente = result.getInt("idCliente");
                String nome = result.getString("nome");
                String cnpj = result.getString("cnpj");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                String situacao = result.getString("situacao");
                String cidade = result.getString("cidade");
                String estado = result.getString("estado");
                Double credito = result.getDouble("credito");

                Cliente clienteBanco = new Cliente();
                clienteBanco.setIdCliente(idCliente);
                clienteBanco.setSituacao(situacao);
                clienteBanco.setNome(nome);
                clienteBanco.setCnpj(cnpj);
                clienteBanco.setTelefone(telefone);
                clienteBanco.setEstado(estado);
                clienteBanco.setCidade(cidade);
                clienteBanco.setCredito(credito);
                clienteBanco.setEmail(email);

                listaRetorno.add(clienteBanco);




               /*System.out.println("--------------------------");
                System.out.println("Cadastro cliente");
                System.out.println("IdCliente : " + idCliente);
                System.out.println("Nome : " + nome);
                System.out.println("CNPJ : " + cnpj);
                System.out.println("Telefone : " + telefone);
                System.out.println("email : " + email);
                System.out.println("Situação : " + situacao);
                System.out.println("Cidade : " + cidade);
                System.out.println("Estado : " + estado);
                System.out.println("Crédito : " + credito);
                System.out.println("--------------------------");*/
            }

            connection.closeConnection();
            return listaRetorno;

        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}