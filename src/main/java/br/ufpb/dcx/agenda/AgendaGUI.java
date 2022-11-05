package br.ufpb.dcx.agenda;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class  AgendaGUI extends JFrame {
    JLabel linha1;
    JLabel linha2;
    ImageIcon boloImg = new ImageIcon( "src"+File.separator+"main"+File.separator+"resources1"+ File.separator+"imgs"+File.separator+"bolo.jpg");
    ImageIcon addImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources2"+ File.separator+"imgs"+File.separator+"addImg.jpg");
    ImageIcon removeImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources3"+ File.separator+"imgs"+File.separator+"removeImg.jpg");

    JButton botaoAdicionar;
    JButton botaoPesquisar;
    JButton botaoRemover;
    Agenda agenda = new AgendaPOO();
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDeContatos gravador = new GravadorDeContatos();


    public AgendaGUI(){

        File f = new File ("src"+File.separator+"main"+File.separator+"resources4"+ File.separator+"imgs"+File.separator+"addImg.jpg");
        System.out.println(f.exists());
        System.out.println(f.getAbsolutePath());

        setTitle("Agenda de Aniversários");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        Collection<Contato> contatos = null;
        try {
            contatos = gravador.recuperaContatos();
            for (Contato c: contatos){
                this.agenda.cadastraContato(c.getNome(), c.getDiaAniversario(), c.getMesAniversario());
            }
            JOptionPane.showMessageDialog(null, "Contatos recuperados com sucesso");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Contatos não recuperados. Erro: "+e.getMessage());
            e.printStackTrace();
        }

        linha1 = new JLabel("Minha Agenda de Aniversários", SwingConstants.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        
        linha2 = new JLabel(boloImg, SwingConstants.CENTER);
        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.addActionListener(new AgendaAddController(agenda, this));
        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));
        
        getContentPane().setLayout(new GridLayout(2,2));
        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(linha2);
        getContentPane().add(botaoRemover);

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarAniversariante = new JMenuItem("Cadastrar Aniversariante");
        menuCadastrar.add(menuCadastrarAniversariante);
        menuCadastrarAniversariante.addActionListener(new AgendaAddController(agenda, this));

        barraDeMenu.add(menuCadastrar);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverAniversariante = new JMenuItem("Remover Aniversariante");
        menuRemover.add(menuRemoverAniversariante);
        menuRemoverAniversariante.addActionListener(new AgendaRemoveController(agenda, this));

        barraDeMenu.add(menuRemover);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarAniversariante = new JMenuItem("Pesquisar Aniversariante");
        menuPesquisar.add(menuPesquisarAniversariante);
        menuPesquisarAniversariante.addActionListener(new AgendaSearchController(agenda, this));

        barraDeMenu.add(menuPesquisar);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarDados = new JMenuItem("Salvar dados");
        menuSalvar.add(menuSalvarDados);
        menuSalvarDados.addActionListener(new AgendaSaveController(agenda, this, gravador));
        barraDeMenu.add(menuSalvar);

        setJMenuBar(barraDeMenu);
        File arquivo = new File(".");
        System.out.println("===>"+arquivo.getAbsolutePath());

    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}