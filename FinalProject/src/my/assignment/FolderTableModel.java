package my.assignment;

import javax.swing.table.AbstractTableModel;

public class FolderTableModel extends AbstractTableModel implements IntTableModel {

	private Object[][] data = new Object[0][];

	public FolderTableModel() {
		super();
	}

	@Override
	public void setData(Object[][] data) {
		this.data = data;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		if(columnIndex == 1)
		   return Long.class;
		else
		   return String.class;	
	}

	public void debugData() {
		System.out.println("Debug Table data...");
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.println("data[" + i + "][" + j + "]: " + data[i][j]);
			}

		}
	}

}
