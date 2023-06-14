package unipar.exemplo.ui;

import unipar.exemplo.entity.Cliente;
import unipar.exemplo.repository.clientes.RepositoryCliente;
import unipar.exemplo.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCadastroCliente {
    private JTextField textIdCliente;
    private JTextField textNome;
    private JTextField textCnpj;
    private JTextField textTelefone;
    private JTextField textEmail;
    private JTextField textSituacao;
    private JTextField textCidade;
    private JTextField textEstado;
    private JTextField textCredito;
    private JButton CADASTRARButton;
    public JPanel TCliente;
    private JTable TabCliente;
    private JComboBox Situacao;


    public TelaCadastroCliente() {
        carregarDadosCliente();

        CADASTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Cliente novoCliente = new Cliente();

                novoCliente.setIdcliente(Utils.convertInteger(textIdCliente));
                novoCliente.setNome(textNome.getText());
                novoCliente.setCnpj(textCnpj.getText());
                novoCliente.setTelefone(textTelefone.getText());
                novoCliente.setEmail(textEmail.getText());
                novoCliente.setCidade(textCidade.getText());
                novoCliente.setEstado(textEstado.getText());
                novoCliente.setCredito(Utils.convertDouble(textCredito));
                if(Situacao.getSelectedIndex() == 0){
                      novoCliente.setSituacao("Ativo");
                }else if(Situacao.getSelectedIndex() == 1){
                    novoCliente.setSituacao("Inativo");
                }


                RepositoryCliente repo = new RepositoryCliente();
                Integer retorno = repo.inserirCliente(novoCliente);

                Utils.validarRetorno(retorno);



            }
        });

    }


    private void carregarDadosCliente() {
        TabCliente.setModel(new DefaultTableModel(null,
                new Object[]{"ID", "Nome", "CNPJ", "Telefone", "Email", "Situacao", "Cidade", "Estado", "Credito"}));


        RepositoryCliente repo = new RepositoryCliente();
        List<Cliente> listaClienteBanco = repo.buscarCliente();

        DefaultTableModel tabela = (DefaultTableModel) TabCliente.getModel();

        listaClienteBanco.forEach(cliente -> {
            tabela.addRow(new Object[]{cliente.getIdcliente(),
                    cliente.getNome(),
                    cliente.getCnpj(),
                    cliente.getTelefone(),
                    cliente.getEmail(),
                    cliente.getSituacao(),
                    cliente.getCidade(),
                    cliente.getEstado(),
                    cliente.getCredito()});


        });
    }




}
