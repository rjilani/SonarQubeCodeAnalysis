package com.teksystems.directoryreader.util.handler;

import java.util.List;

import com.teksystems.directoryreader.util.ISortDirectory;

public class SortDirectoryHandler {

	private ISortDirectory sortType;
	
	public SortDirectoryHandler(ISortDirectory sortType) {
		this.sortType = sortType;
	}

	public List<String> sortFiles(String[] listOfFileNames) {
		return this.sortType.sortFiles(listOfFileNames);
	}
}
