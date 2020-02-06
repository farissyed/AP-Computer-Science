package my.assignment;

public class FolderObj {

	private String name;
	private long size;

	public FolderObj(String name, long size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

		
	public Object[] toArray() {
		Object[] data = new Object[2];

		data[0] = this.getName();
		data[1] = this.getSize();

		return data;
	}

}