package com.teksystems.directoryreader.util.handler;

import java.io.File;
import java.io.IOException;

import com.teksystems.directoryreader.util.IWriteDirectory;

public class WriteDirectoryHandler {

	private IWriteDirectory dir;

	public WriteDirectoryHandler(IWriteDirectory dir) {
		this.dir = dir;
	}

	public void printFile(File file, int tabs, int lengthOfDirectory) {
		this.dir.printFile(file, tabs, lengthOfDirectory);
	}

}
