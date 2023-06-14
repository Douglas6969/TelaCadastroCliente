package unipar.exemplo.dbsimples;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoDbSimples {

    public static void main(String[] args) {

        conectarBancoDeDados();

    }

    public static void conectarBancoDeDados(){

        String url = "jdbc:postgresql://localhost:5432/Unipar";
        String username = "postgres";
        String password = "adm123";

        try{

           //iniciamos a criação da conexão com o banco
           Connection conn = DriverManager.getConnection(url,username,password);

           //cria a interface para a conexão com o banco
            //nela vamos executar o selct, insert, update, delete
            Statement statement = conn.createStatement();

            //executar uma query sql
            ResultSet result = statement.executeQuery("SELECT * FROM produtos where codigo = 1");

            while (result.next()){

                Integer codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ean = result.getString("ean");
                Double preco = result.getDouble("preco");

                System.out.println("-----------------");
                System.out.println("Cadastro produto");
                System.out.println("Código :" + codigo);
                System.out.println("Nome :" + nome);
                System.out.println("EAN :" + ean);
                System.out.println("Preço :" + preco);
                System.out.println("-----------------");

            }

            conn.close();

        }catch (Exception e){
            //vai exibir o log do exception
            e.printStackTrace();
            //System.out.println("DEU ERRO");

        }
    }


}
