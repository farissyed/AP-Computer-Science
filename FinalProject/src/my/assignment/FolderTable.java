package my.assignment;

import javax.swing.JTable;

public class FolderTable extends JTable {

	public FolderTable(FolderTableModel model) {
		super(model);

		this.setAutoCreateRowSorter(true);
		this.getColumnModel().getColumn(0).setMinWidth(300);

	}
}
