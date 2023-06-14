package unipar.exemplo.run;

import unipar.exemplo.ui.TelaCadastroCliente;
import unipar.exemplo.ui.TelaCadastroProduto;

import javax.swing.*;

public class MainUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createUI();
                createUICliente();

            }
        });
    }


    private static void createUI(){
        TelaCadastroProduto formProduto = new TelaCadastroProduto();

        JFrame frame = new JFrame();
        frame.setContentPane(formProduto.PanelMain);
        frame.setTitle("CADASTRO PRODUTO");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500,500);


    }


    private static void createUICliente(){
        TelaCadastroCliente formCliente = new TelaCadastroCliente();
        JFrame frame = new JFrame();
        frame.setContentPane(formCliente.TCliente);
        frame.setTitle("cadastro RepositoryCliente");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(900,900);

    }


}