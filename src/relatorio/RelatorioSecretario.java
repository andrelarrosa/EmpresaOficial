package relatorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioSecretario extends JDialog {

	public RelatorioSecretario() {
		super(new JFrame(), "Relatório Secretario", true);
		setSize(1024, 768);
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgreesql://localhost:5432/aulaPU", "postgres", "1234");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Secretario");
			JRResultSetDataSource ds = new JRResultSetDataSource(rs);
			String lugar = System.getProperty("user.dir");
			JasperReport jr = JasperCompileManager.compileReport(lugar + "/relSecretario_1.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, ds);
			JasperViewer jw = new JasperViewer(jp);
			getContentPane().add(jw.getContentPane());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
