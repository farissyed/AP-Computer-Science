package my.assignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ManageFoldersMain extends JFrame implements ActionListener {

	private static final String CHOOSER_TITLE = "Select Folder to Manage Size";
	private static final String LBL_TITLE = "Manage Folder Size";
	private static final String BTN_LABEL = "Select Folder";

	private JPanel contentPane;
	private JTable table;
	private FolderTableModel model;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageFoldersMain frame = new ManageFoldersMain();
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
	public ManageFoldersMain() {

		this.setTitle(LBL_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlTitle.setBounds(10, 23, 591, 38);
		contentPane.add(pnlTitle);

		JLabel lblTitle = new JLabel(LBL_TITLE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlTitle.add(lblTitle);

		JPanel pnlSelectFolder = new JPanel();
		pnlSelectFolder.setBorder(null);
		pnlSelectFolder.setBounds(10, 83, 591, 33);
		contentPane.add(pnlSelectFolder);

		JButton btnSelectFolder = new JButton(BTN_LABEL);
		btnSelectFolder.addActionListener(this);
		pnlSelectFolder.add(btnSelectFolder);

		JPanel pnlTable = new JPanel();
		pnlTable.setBorder(null);
		pnlTable.setBounds(10, 132, 591, 364);
		contentPane.add(pnlTable);

		model = new FolderTableModel();
		table = new FolderTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(570, 320));
		JScrollPane scrollPane = new JScrollPane(table);
		pnlTable.add(scrollPane);

		JPanel pnlMsg = new JPanel();
		pnlMsg.setBorder(null);
		FlowLayout flowLayout = (FlowLayout) pnlMsg.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlMsg.setBounds(10, 496, 591, 86);
		contentPane.add(pnlMsg);

		textArea = new JTextArea();
		textArea.setColumns(72);
		textArea.setLineWrap(true);
		textArea.setRows(4);
		JScrollPane scrollPaneMsg = new JScrollPane(textArea);
		pnlMsg.add(scrollPaneMsg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setDialogTitle(CHOOSER_TITLE);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);

		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

			textArea.append("Selected Directory is: " + fileChooser.getCurrentDirectory() + "\n");
			textArea.append("Selected Folder is: " + fileChooser.getSelectedFile() + "\n");

			System.out.println("Selected Directory is: " + fileChooser.getCurrentDirectory());
			System.out.println("Selected Folder is: " + fileChooser.getSelectedFile());

			FolderHelper folderHelper = new FolderHelper();
			Object[][] data = folderHelper.calculateFolderSize(fileChooser.getSelectedFile().getAbsolutePath());
			System.out.println("Number of folders " + data.length);

			model.setData(data);
			model.fireTableDataChanged();

			model.debugData();

		} else {
			System.out.println("No Selection made.");
			textArea.append("No Selection made \n");
		}

	}
}
