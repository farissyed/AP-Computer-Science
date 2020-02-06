package my.assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderHelper {

	/*
	 * This method calculate size of given folder by looping through all files and
	 * folders. For folder size it calls getFolderSize method
	 */
	public Object[][] calculateFolderSize(String userSelectedDirPath) {

		List<FolderObj> folderList = new ArrayList<>();
		long userSelectedDirSize = 0;

		// insert top folder as first element
		folderList.add(new FolderObj(userSelectedDirPath, userSelectedDirSize));

		File userSelectedDir = new File(userSelectedDirPath);

		if (userSelectedDir.exists() && userSelectedDir.isDirectory()) {

			File fileArray[] = userSelectedDir.listFiles();

			System.out.println("Files from main directory: " + userSelectedDir);

			for (File f : fileArray) {
				long size = 0;

				if (f.isFile()) {
					userSelectedDirSize += f.length();
				} else {
					size = getFolderSize(f, folderList);
					userSelectedDirSize += size;

					folderList.add(new FolderObj(f.getAbsolutePath(), size));
					System.out.println("Folder: " + f + " - size:" + size + " Bytes");
				}

			}

		}

		// update top folder size at the end
		FolderObj mainFolder = folderList.get(0);
		mainFolder.setSize(userSelectedDirSize);
		System.out.println("Main directory: " + userSelectedDirPath + " - size:" + userSelectedDirSize + " Bytes");

		return getArrayFromList(folderList);
	}

	/*
	 * This Method is called recursively while looping through all folders
	 */
	private long getFolderSize(File folder, List<FolderObj> folderList) {

		long length = 0;

		File[] files = folder.listFiles();

		int count = files.length;

		for (int i = 0; i < count; i++) {
			if (files[i].isFile()) {
				length += files[i].length();
			} 
			else {
				long localFolderSize = getFolderSize(files[i], folderList);
				folderList.add(new FolderObj(files[i].getAbsolutePath(), localFolderSize));
				length += localFolderSize;
				System.out.println("Folder: " + files[i].getAbsolutePath() + " - size:" + localFolderSize + " Bytes");
			}
		}

		return length;
	}
	
	private Object[][] getArrayFromList(List<FolderObj> folderList) {

		Object[][] data = new Object[0][];

		if (folderList != null) {			
			data = new Object[folderList.size()][];

			int i = 0;
			for (FolderObj folder : folderList) {
				data[i++] = folder.toArray();
			}
		}

		return data;

	}

}
