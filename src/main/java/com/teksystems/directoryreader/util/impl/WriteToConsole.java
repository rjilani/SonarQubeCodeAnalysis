package com.teksystems.directoryreader.util.impl;

import java.io.File;

import com.teksystems.directoryreader.constants.DirectoryConstants;
import com.teksystems.directoryreader.util.IWriteDirectory;

public class WriteToConsole implements IWriteDirectory {

	@Override
	public void printFile(File file, int tabs, int lengthOfDirectory) {
	 		String fileName = file.getName();
			String[] split = fileName.split(DirectoryConstants.DELIMETER);
			for (int i = 0; i < tabs; i++) {
				System.out.print("  ");
			}
			System.out.println("- Document: " + file.getName() + " - Extension: ." + split[split.length - 1] + " - URL: "
					+ file.getAbsolutePath().substring(lengthOfDirectory));
	 
	}
	 

}
