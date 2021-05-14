package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controlador.ControladorPanelAnalisis;
import javax.swing.JComboBox;

public class PanelAnalisis extends JPanel {


	private static final long serialVersionUID = -2457862673139031544L;
	private ControladorPanelAnalisis controladorPanelAnalisis;
	private JButton btnProdLocal;
	private JButton btnProdGeneral;
	private JComboBox comboBox;
	private JLabel lblTextoPanel;
	private JButton btnDesconectar;
	private JTextField textFieldLocal;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultListModel<String> listaCombinaciones = new DefaultListModel<String>();
	private JList listaProductos;


	public PanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis, String tipoLocal, String nombreUsuario, String nombreLocal) {
		setBackground(new Color(51, 153, 255));


		this.controladorPanelAnalisis = controladorPanelAnalisis;

		setLayout(null);

		btnProdLocal = new JButton("Productos relacionados del local");
		btnProdLocal.setFont(new Font("Arial", Font.BOLD, 15));
		btnProdLocal.setBounds(395, 173, 300, 25);
		add(btnProdLocal);

		btnDesconectar = new JButton("Salir");
		btnDesconectar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDesconectar.setBounds(358, 545, 117, 25);
		add(btnDesconectar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 247, 556, 186);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {	"Primer Producto", "Segundo Producto", "Fecha", "Probabilidad"	}));
		scrollPane.setViewportView(table);

		textFieldLocal = new JTextField();
		textFieldLocal.setText(controladorPanelAnalisis.conseguirLocal());
		textFieldLocal.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldLocal.setColumns(10);
		textFieldLocal.setBounds(265, 173, 114, 25);
		add(textFieldLocal);

		JLabel lblLocal = new JLabel("NIF del Local:\r\n");
		lblLocal.setFont(new Font("Arial", Font.BOLD, 16));
		lblLocal.setBounds(139, 173, 114, 25);
		add(lblLocal);

		btnProdGeneral = new JButton("Productos relacionados generales");
		btnProdGeneral.setFont(new Font("Arial", Font.BOLD, 15));
		btnProdGeneral.setBounds(395, 210, 300, 25);
		add(btnProdGeneral);

		comboBox = new JComboBox();
		comboBox.setBounds(139, 210, 240, 25);
		add(comboBox);
		comboBox.addItem("Naive Bayes");

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_analisis.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);
		
				lblTextoPanel = new JLabel("PANEL DE AN\u00C1LISIS");
				lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
				lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
				lblTextoPanel.setBounds(139, 35, 556, 50);
				add(lblTextoPanel);

		initializeEvents();

	}

	private void initializeEvents() {
		this.btnProdLocal.addActionListener(listenerBotonProdLocal(this.controladorPanelAnalisis));
		this.btnDesconectar.addActionListener(listenerBotonDesconectar(this.controladorPanelAnalisis));
		this.btnProdGeneral.addActionListener(listenerBotonProdGeneral(this.controladorPanelAnalisis));
	}

	private ActionListener listenerBotonProdLocal(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Productos relacionados del local");
				DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
				int rowCount = modeloTabla.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
					modeloTabla.removeRow(i);
				}
				String lista[][] = controladorPanelAnalisis.accionadoBottonMostrarProdLocal(textFieldLocal.getText());
				for(int i = 0;i<lista.length;i++) {
					String temp[] = { lista[i][0], lista[i][1], lista[i][2], lista[i][3] };
					modeloTabla.addRow(temp);
				}
			}
		};
	}

	private ActionListener listenerBotonProdGeneral(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Productos relacionados generales");
				DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
				int rowCount = modeloTabla.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
					modeloTabla.removeRow(i);
				}
				String lista[][] = controladorPanelAnalisis.accionadoBottonMostrarProdGeneral();
				for(int i = 0;i<lista.length;i++) {
					String temp[] = { lista[i][0], lista[i][1], lista[i][2], lista[i][3] };
					modeloTabla.addRow(temp);
				}
			}
		};
	}

	private ActionListener listenerBotonDesconectar(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectar");
				controladorPanelAnalisis.accionadoBottonDesconectarPanelAnalisis();
			}
		};
	}
}
