package unipar.exemplo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter             //criando getter de todos os atributos
@Getter             //criando setter de todos os atributos
@AllArgsConstructor //criando construtor com todos os argumentos
@NoArgsConstructor  //criando construtor com nenhum argumento
public class Produto {

    private Integer codigo;
    private String nome;
    private String ean;
    private Double preco;




}
