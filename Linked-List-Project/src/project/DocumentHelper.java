package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentHelper {
	private String text;
	private File file;

	public DocumentHelper(String text) {
		this.text = text;
		this.file = new File(text);
	}

	public List<String> getTokens(String pattern) {
		ArrayList<String> tokens = new ArrayList<>();
		Pattern tokenSplitter = Pattern.compile(pattern);
		Matcher m = tokenSplitter.matcher(readFile());

		while (m.find()) {
			tokens.add(m.group());
		}
		return tokens;
	}

	public int countSyllables(String word) {
		int num = 0;
		String pattern = "[aeiouyAEIOUY]+";
		Pattern tokenSplitter = Pattern.compile(pattern);
		Matcher m = tokenSplitter.matcher(word);
		String lastToken = "";
		while (m.find()) {
			num++;
			lastToken = m.group();
		}
		if (num > 1 && word.charAt(word.length() - 1) == 'e' && lastToken.equals("e")) {
			num--;
		}
		return num;
	}

	private String readFile() {
		String toReturn = "";
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				toReturn += scanner.nextLine() + " ";
			}
			scanner.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return toReturn;
	}

}
