package telaSecundaria;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DAOSecretario;
import entidade.*;

import relatorio.RelatorioSecretario;
import telaSecundaria.TelaDeConsulta;
import javax.swing.JFrame;

public class TelaSecretario extends JInternalFrame {
	
	DAOSecretario a = new DAOSecretario();
	Secretario secretario = new Secretario();
	
	private JTextField txtInsiraSeuNome;
	private JTextField txtInsiraSeuCpf;
	private JTextField txtInsiraUmaLingua;
	private JTextField txtInsiraLnguaMaterna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSecretario frame = new TelaSecretario();
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
	public TelaSecretario() {
			setTitle("Olá Secretário");
			setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 42, 70, 15);
		getContentPane().add(lblNome);
		
		txtInsiraSeuNome = new JTextField();
		txtInsiraSeuNome.setBounds(95, 40, 286, 19);
		getContentPane().add(txtInsiraSeuNome);
		txtInsiraSeuNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 69, 70, 15);
		getContentPane().add(lblCpf);
		
		txtInsiraSeuCpf = new JTextField();
		txtInsiraSeuCpf.setBounds(267, 67, 114, 19);
		getContentPane().add(txtInsiraSeuCpf);
		txtInsiraSeuCpf.setColumns(10);
		
		JLabel lblLnguaEstrangeira = new JLabel("Língua Estrangeira:");
		lblLnguaEstrangeira.setBounds(27, 96, 159, 15);
		getContentPane().add(lblLnguaEstrangeira);
		
		txtInsiraUmaLingua = new JTextField();
		txtInsiraUmaLingua.setText("\r\n");
		txtInsiraUmaLingua.setBounds(267, 94, 114, 19);
		getContentPane().add(txtInsiraUmaLingua);
		txtInsiraUmaLingua.setColumns(10);
		
		JLabel lblLnguaMaterna = new JLabel("Língua Materna:");
		lblLnguaMaterna.setBounds(27, 123, 148, 15);
		getContentPane().add(lblLnguaMaterna);
		
		txtInsiraLnguaMaterna = new JTextField();
		txtInsiraLnguaMaterna.setBounds(267, 125, 114, 19);
		getContentPane().add(txtInsiraLnguaMaterna);
		txtInsiraLnguaMaterna.setColumns(10);
		
		JButton btnOk = new JButton("OK!");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secretario.setNome(txtInsiraSeuNome.getText());
				secretario.setCpf(txtInsiraSeuCpf.getText());
				secretario.setLinguaEstrangeira(txtInsiraUmaLingua.getText());
				secretario.setLinguaMaterna(txtInsiraLnguaMaterna.getText());
				a.salvar(secretario);
				dispose();			
			}
		});
		btnOk.setBounds(69, 234, 117, 25);
		getContentPane().add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancelar.setBounds(215, 235, 117, 23);
		getContentPane().add(btnCancelar);

	}

		protected void setLinguaMaterna(String text) {
			// TODO Auto-generated method stub
			
		}

		protected void setNome(String text) {
			// TODO Auto-generated method stub
			
		}

		protected void setLinguaEstrangeira(String text) {
			// TODO Auto-generated method stub
			
		}
}
