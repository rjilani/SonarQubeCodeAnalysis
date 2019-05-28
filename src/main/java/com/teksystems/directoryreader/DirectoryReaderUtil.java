package com.teksystems.directoryreader;

import java.io.File;

import com.teksystems.directoryreader.util.handler.SortDirectoryHandler;
import com.teksystems.directoryreader.util.handler.WriteDirectoryHandler;
import com.teksystems.directoryreader.util.impl.SortDirectoryByextension;
import com.teksystems.directoryreader.util.impl.WriteToConsole;

public class DirectoryReaderUtil {

	/**
	 * Main driver and entry point
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		File rootDirectory = new File("./testdirectory/Main Project");
		WriteDirectoryHandler writeDirectoryHandler = new WriteDirectoryHandler(new WriteToConsole());
		SortDirectoryHandler sortDirectoryHandler = new SortDirectoryHandler(new SortDirectoryByextension());
		int directoryFileLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
	 	DirectoryListing directoryReaderUitl = new DirectoryListing(writeDirectoryHandler, sortDirectoryHandler, directoryFileLength);
		directoryReaderUitl.listAllFilesRecursively(rootDirectory, 0);
	}

}
