package telaPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import relatorio.RelatorioSecretario;
import telaSecundaria.TelaDeConsulta;
import telaSecundaria.TelaEngenheiro;
import telaSecundaria.TelaSecretario;
import telaSecundaria.TelaTecnico;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Escolha_1 extends JFrame {

	private JPanel painel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escolha_1 frame = new Escolha_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Escolha_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenuItem mntmSecretrio = new JMenuItem("Secretário");
		mntmSecretrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretario secretario = new TelaSecretario();
				secretario.setVisible(true);
				painel.add(secretario);
			}
		});
		mnCadastro.add(mntmSecretrio);
		
		JMenuItem mntmTecnico = new JMenuItem("Técnico");
		mntmTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTecnico tecnico = new TelaTecnico();
				tecnico.setVisible(true);
				painel.add(tecnico);
			}
		});
		mnCadastro.add(mntmTecnico);

		JMenu mnRelatrio = new JMenu("Relatório");
		menuBar.add(mnRelatrio);

		JMenuItem mntmRelatrioDeSecretrios = new JMenuItem("Relatório de Secretários");
		mntmRelatrioDeSecretrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioSecretario relSecretario1 = new RelatorioSecretario();
				relSecretario1.setVisible(true);
			}
		});
		mnRelatrio.add(mntmRelatrioDeSecretrios);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmTelaDeConsulta = new JMenuItem("Tela De Consulta");
		mntmTelaDeConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeConsulta telaC = new TelaDeConsulta();
				telaC.setModal(true);
				telaC.setVisible(true);
			}
		});
		mnConsulta.add(mntmTelaDeConsulta);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
	}
}
