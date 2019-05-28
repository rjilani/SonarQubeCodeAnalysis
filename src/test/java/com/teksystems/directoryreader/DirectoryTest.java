package com.teksystems.directoryreader;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class DirectoryTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testUsingTempFolder() throws IOException {
		File createdFolder = folder.newFolder("testdirectory","Main Project");
		assertTrue(createdFolder.exists());
	}
}
