package com.teksystems.directoryreader.util.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import com.teksystems.directoryreader.constants.DirectoryConstants;
import com.teksystems.directoryreader.util.ISortDirectory;

public class SortDirectoryByextension implements ISortDirectory {


	@Override
	public List<String> sortFiles(String[] listOfFileNames) {
		List<String> orginalList = new CopyOnWriteArrayList<>(Arrays.asList(listOfFileNames));
		Set<String> setOfuniqueExtension = new TreeSet<>();



		for (String item : listOfFileNames) {
			if (item.contains(".")) {
				String[] split = item.split(DirectoryConstants.DELIMETER);
				String temp = "." + split[split.length - 1];
				setOfuniqueExtension.add(temp);
			}
		}



		List<String> finalListOfAllFiles = new LinkedList<>();
		setOfuniqueExtension.stream().forEach((s1) -> {
			for (int i = 0; i < orginalList.size(); i++) {
				if (orginalList.get(i).contains(s1)) {
					finalListOfAllFiles.add(orginalList.get(i));
					orginalList.remove(orginalList.get(i));
					i--;
				}
			}
		});

		orginalList.stream().filter(s1 -> !finalListOfAllFiles.contains(s1)).forEach(s1 -> finalListOfAllFiles.add(s1));

		return finalListOfAllFiles;
	}

}
