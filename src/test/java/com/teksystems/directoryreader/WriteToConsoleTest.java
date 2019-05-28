package com.teksystems.directoryreader;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.teksystems.directoryreader.util.handler.WriteDirectoryHandler;
import com.teksystems.directoryreader.util.impl.WriteToConsole;

public class WriteToConsoleTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void testPrintDirToConsole() throws IOException {
		File testDirectory = new File("./testdirectory/Main Project/");
		int length = testDirectory.getAbsolutePath().length() - testDirectory.getName().length();
		String listOfFileNames[] = testDirectory.list();
		List<String> orginalList = new CopyOnWriteArrayList<>(Arrays.asList(listOfFileNames));
		for (String item : orginalList) {
			File file = new File(testDirectory + "/" + item);
			new WriteDirectoryHandler(new WriteToConsole()).printFile(file, 1, length);
		}

		assertTrue(outContent.toString().contains("Main Project\\Project 1"));
	}

}
