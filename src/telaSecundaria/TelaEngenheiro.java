package telaSecundaria;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dao.DAOEngenheiro;
import entidade.Engenheiro;

import relatorio.*;
public class TelaEngenheiro extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	Engenheiro engenheiro = new Engenheiro();
	DAOEngenheiro daoEng = new DAOEngenheiro();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEngenheiro frame = new TelaEngenheiro();
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
	public TelaEngenheiro() {
		getContentPane().setFont(getContentPane().getFont().deriveFont(getContentPane().getFont().getStyle() | Font.BOLD));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblOlEngenheiro = new JLabel("Olá Engenheiro");
		lblOlEngenheiro.setFont(lblOlEngenheiro.getFont().deriveFont(lblOlEngenheiro.getFont().getStyle() | Font.BOLD));
		lblOlEngenheiro.setBounds(175, 11, 121, 14);
		getContentPane().add(lblOlEngenheiro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(lblNome.getFont().deriveFont(lblNome.getFont().getStyle() | Font.BOLD));
		lblNome.setBounds(45, 58, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(lblCpf.getFont().deriveFont(lblCpf.getFont().getStyle() | Font.BOLD));
		lblCpf.setBounds(45, 105, 46, 14);
		getContentPane().add(lblCpf);
		
		JLabel lblEngenharia = new JLabel("Engenharia");
		lblEngenharia.setFont(lblEngenharia.getFont().deriveFont(lblEngenharia.getFont().getStyle() | Font.BOLD));
		lblEngenharia.setBounds(45, 153, 77, 14);
		getContentPane().add(lblEngenharia);
		
		textField = new JTextField();
		textField.setBounds(286, 55, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(286, 102, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(286, 150, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnOk = new JButton("OK!");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				engenheiro.setNome(textField.getText());
				engenheiro.setCpf(textField_1.getY());
				engenheiro.setEngenharia(textField_2.getText());
				daoEng.salvar(engenheiro);
				dispose();
			}
		});
		btnOk.setBounds(115, 235, 89, 23);
		getContentPane().add(btnOk);
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancelar.setBounds(214, 235, 121, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnRelatrio = new JButton("relatório");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnRelatrio.setBounds(279, 182, 117, 25);
		getContentPane().add(btnRelatrio);

	
	}
}
