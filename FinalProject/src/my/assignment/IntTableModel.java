package my.assignment;

public interface IntTableModel {
	String[] columnNames = { "Folder Name", "Folder Size (Bytes)"};

	void setData(Object[][] data);
}
