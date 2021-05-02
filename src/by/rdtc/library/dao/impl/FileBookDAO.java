package by.rdtc.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.BookDAO;
import by.rdtc.library.dao.exception.DAOException;

public class FileBookDAO implements BookDAO {

	@Override
	public void addBook(Book book) throws DAOException {

		String filePath = "resources/Books.txt";
		//Path path = Paths.get(fileName);

		String newBook = "\n" + book.getIdBook() + ";" + book.getBookName() + ";" + book.getAuthor() + ";"
				+ book.getNumberOfPages() + ";" + book.getYear();

		FileWriter writer = null;
		BufferedWriter bufferedWriter = null;
		try {
			writer = new FileWriter(filePath, true);
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(newBook);
		} catch (IOException e) {
			System.out.println(e);
			throw new DAOException("Error: book was not added");
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new DAOException(e);
				}
			}
		}

	}

	@Override
	public boolean deleteBook(long idBook) throws DAOException {

		File fileInput = new File("resources/Books.txt");
		File fileTemp = new File(System.getProperty("java.io.tmpdir") + "TempBooks.txt");
		File fileInputBackup = new File(System.getProperty("java.io.tmpdir") + "BooksBackup.txt");

		String currentLine;
		boolean bookExist = false;
		boolean success = false;
		
		BufferedReader reader = null;
		BufferedWriter writer = null; 

		try {
			 reader = new BufferedReader(new FileReader(fileInput));
			 writer = new BufferedWriter(new FileWriter(fileTemp));

			while ((currentLine = reader.readLine()) != null) {

				// trim newline when comparing with lineToRemove
				String trimmedLine = currentLine.trim();

				String[] bookFields = trimmedLine.split(";");

				if (bookFields[0].equals(Long.toString(idBook))) {
					bookExist = true;
					continue;
				}
				writer.write(currentLine + System.getProperty("line.separator"));
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new DAOException("Error: book was not deleted. Temp file error.");
		} finally {
			try {
				writer.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new DAOException(e);
			}
			
		}
		
		try {
			if (bookExist) {
				fileInput.renameTo(fileInputBackup);
				success = fileTemp.renameTo(fileInput);
				if (success) {
					fileInputBackup.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error: book was not deleted. Renaming files error.");
		}  finally {
				fileTemp.delete();
				fileInputBackup.delete();
		}

		return success;
	}

	@Override
	public List<String> findBookByAuthor(String author) throws DAOException {

		File fileInput = new File("resources/Books.txt");
		List<String> fileBookStrings = null;
		List<String> bookStringsWithAuthor = new ArrayList<String>();

		try {
			fileBookStrings = Files.readAllLines(fileInput.toPath());
			for (String bookString : fileBookStrings) {
				if (bookString.contains(author)) {
					bookStringsWithAuthor.add(bookString);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new DAOException("Error: Failed to read file: " + fileInput.getPath(), e);
		}
		return bookStringsWithAuthor;
	}
}
