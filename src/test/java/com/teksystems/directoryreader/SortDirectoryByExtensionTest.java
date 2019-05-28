package com.teksystems.directoryreader;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.teksystems.directoryreader.util.handler.SortDirectoryHandler;
import com.teksystems.directoryreader.util.impl.SortDirectoryByextension;

public class SortDirectoryByExtensionTest {

	@Test
	public void testSortByExt() throws IOException {
		String listOfFileNames[] = new String[] { "test.jpeg", "test1.com", "test.xlsx" };
		List<String> sortedList = new SortDirectoryHandler(new SortDirectoryByextension()).sortFiles(listOfFileNames);
		assertTrue(sortedList.get(0).equals("test1.com"));
	}

}
