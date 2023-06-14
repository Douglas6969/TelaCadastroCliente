package unipar.exemplo.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    private Integer idcliente;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String Situacao;
    private String cidade;
    private String estado;
    private Double credito;


}