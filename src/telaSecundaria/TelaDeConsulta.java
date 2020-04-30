package telaSecundaria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.transaction.Transactional.TxType;

import org.hibernate.sql.Update;

import com.mysql.jdbc.UpdatableResultSet;

import dao.DAOSecretario;
import entidade.Secretario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaDeConsulta extends JDialog {

	private JTextField textField;
	private JTable tabela;
	private DefaultTableModel modelo;
	private DAOSecretario dao = new DAOSecretario();
	private List<Secretario> lista;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaDeConsulta dialog = new TelaDeConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaDeConsulta() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 600, 400);
			
		textField = new JTextField();
		textField.setBounds(12, 12, 343, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnOk = new JButton("ok");
		btnOk.setBounds(381, 9, 51, 25);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.setNumRows(0);
				lista = dao.buscar(textField.getText());
				for (Secretario sec : lista) {
					Object[] linha = new Object[] { sec.getNome(), sec.getCpf(), sec.getId() };
					modelo.addRow(linha);
				}

			}
		});
		getContentPane().add(btnOk);

		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int linha = tabela.getSelectedRow();
					Secretario s = lista.get(linha);
					
					textField_1.setText(s.getNome());
					textField_2.setText(s.getCpf());
					textField_3.setText(s.getLinguaMaterna());
					textField_4.setText(s.getLinguaEstrangeira());
					
					dao.alterar(linha);
				}
			}
		});
		tabela.setBounds(12, 43, 420, 217);
		tabela.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Id" }));

		modelo = (DefaultTableModel) tabela.getModel();
		getContentPane().add(tabela);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(327, 276, 117, 25);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tabela.getSelectedRow();
				long id = lista.get(linha).getId();

				dao.excluir(id);
				JOptionPane.showMessageDialog(null, "Excluído com sucesso");
				updateTable();
				modelo.setNumRows(0);
				lista = dao.buscar(textField.getText());
				for (Secretario sec : lista) {
					Object[] linhaa = new Object[] { sec.getNome(), sec.getCpf(), sec.getId() };
					modelo.addRow(linhaa);
				}

			}

		});
		getContentPane().add(btnExcluir);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(441, 216, 117, 25);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Secretario secretario = lista.get(tabela.getSelectedRow());

				secretario.setNome(textField_1.getText());
				secretario.setCpf(textField_2.getText());
				secretario.setLinguaMaterna(textField_3.getText());
				secretario.setLinguaEstrangeira(textField_4.getText());

				dao.alterar(secretario);
				updateTable();
			}
		});
		getContentPane().add(btnAlterar);

		textField_1 = new JTextField();
		textField_1.setBounds(444, 59, 114, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(444, 105, 114, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(444, 148, 114, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(444, 190, 114, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(450, 43, 70, 15);
		getContentPane().add(lblNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(450, 90, 70, 15);
		getContentPane().add(lblCpf);

		JLabel lblLnguaMaterna = new JLabel("Língua Materna");
		lblLnguaMaterna.setBounds(444, 136, 123, 15);
		getContentPane().add(lblLnguaMaterna);

		JLabel lblLnguaEstrangeira = new JLabel("Língua Estrangeira");
		lblLnguaEstrangeira.setBounds(444, 173, 135, 15);
		getContentPane().add(lblLnguaEstrangeira);
	}

	public void updateTable() {
		modelo.setNumRows(0);
		for (Secretario sec : lista) {
			Object[] linha = new Object[] { sec.getNome(), sec.getCpf(), sec.getId() };
			modelo.addRow(linha);
		}

	}
}
