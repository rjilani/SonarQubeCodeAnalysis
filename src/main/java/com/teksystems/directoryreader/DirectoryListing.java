package com.teksystems.directoryreader;

import java.io.File;
import java.util.List;

import com.teksystems.directoryreader.util.IListDirectory;
import com.teksystems.directoryreader.util.ISortDirectory;
import com.teksystems.directoryreader.util.IWriteDirectory;
import com.teksystems.directoryreader.util.handler.SortDirectoryHandler;
import com.teksystems.directoryreader.util.handler.WriteDirectoryHandler;
import com.teksystems.directoryreader.util.impl.WriteToConsole;

public class DirectoryListing implements IListDirectory {

	private final int lengthOfDirectory;

	private WriteDirectoryHandler writeHandler;
	private SortDirectoryHandler sortHandler;

	public DirectoryListing(WriteDirectoryHandler writeDirectoryHandler, SortDirectoryHandler sortDirectoryHandler,
			int lengthOfDirectory) {
		this.lengthOfDirectory = lengthOfDirectory;
		this.writeHandler = writeDirectoryHandler;
		this.sortHandler = sortDirectoryHandler;
	}

	@Override
	public void listAllFilesRecursively(File dir, int tabs) {
		if (dir != null) {
			if (dir.isDirectory()) {
				for (int i = 0; i < tabs; i++) {
					System.out.print("  ");
				}
				System.out.println("- Project: " + dir.getName() + " - URL: "
						+ dir.getAbsolutePath().substring(lengthOfDirectory));
				String listOfFileNames[] = dir.list();
				// sortedList = sort(s);
				List<String> sortedListOfFiles = sortHandler.sortFiles(listOfFileNames);
				iterateListOfFiles(sortedListOfFiles, tabs, dir);
			} else {
				System.out.println("Please provide a path to root directory");
			}
		} else {
			System.out.println(dir + " is not a directory");
		}

	}

	private void iterateListOfFiles(List<String> sortedListOfFiles, int tabs, File dir) {
		for (String item : sortedListOfFiles) {
			tabs++;
			File file = new File(dir + "/" + item);
			if (file.isDirectory()) {
				listAllFilesRecursively(file, tabs);
				tabs--;
			} else {
				writeHandler.printFile(file, tabs, lengthOfDirectory);
				tabs--;
			}
		}
	}

}
