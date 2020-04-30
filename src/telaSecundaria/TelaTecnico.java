package telaSecundaria;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entidade.Tecnico;
import dao.DAOTecnico;

public class TelaTecnico extends JInternalFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	DAOTecnico daoTec = new DAOTecnico();
	Tecnico tecnico = new Tecnico();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTecnico frame = new TelaTecnico();
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
	public TelaTecnico() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblOlTcnico = new JLabel("Olá Técnico");
		lblOlTcnico.setFont(lblOlTcnico.getFont().deriveFont(lblOlTcnico.getFont().getStyle() | Font.BOLD));
		lblOlTcnico.setBounds(169, 11, 97, 14);
		getContentPane().add(lblOlTcnico);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(lblNome.getFont().deriveFont(lblNome.getFont().getStyle() | Font.BOLD));
		lblNome.setBounds(31, 56, 46, 14);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(325, 53, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(lblCpf.getFont().deriveFont(lblCpf.getFont().getStyle() | Font.BOLD));
		lblCpf.setBounds(31, 102, 46, 14);
		getContentPane().add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(325, 99, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFormao = new JLabel("Formação");
		lblFormao.setFont(lblFormao.getFont().deriveFont(lblFormao.getFont().getStyle() | Font.BOLD));
		lblFormao.setBounds(31, 150, 67, 14);
		getContentPane().add(lblFormao);
		
		textField_2 = new JTextField();
		textField_2.setBounds(325, 147, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnOk = new JButton("OK!");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tecnico.setNome(textField.getText());
				tecnico.setCpf(textField_1.getY());
				tecnico.setFormacao(textField_2.getText());
				dispose();
			}
		});
		btnOk.setBounds(116, 235, 89, 23);
		getContentPane().add(btnOk);
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancelar.setBounds(215, 235, 89, 23);
		getContentPane().add(btnCancelar);

	
	}
}
