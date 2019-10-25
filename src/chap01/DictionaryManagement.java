package chap01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class DictionaryManagement {
	
	private Dictionary dictionaries = new Dictionary();
	
	// gọi lại từ điển
	public Dictionary getDictionary()
	{
		return dictionaries;
	}
	
	// nhập lựa chọn
	public void dictionarySelection()
	{
		
		Scanner sc = new Scanner(System.in);
		
		int numOfSelection;
		numOfSelection = sc.nextInt();


		switch (numOfSelection) {
		case 1:
			//this.dictionaryLookup();
			//sthis.dictionarySearcher();
			break;
		case 2:
			//this.insertWord();
			break;
		case 3:
			//this.deleteWord();;
			break;
		case 4:
			//this.fixWord();	
			break;
		case 5:
			//this.showAllWords();
			break;
		case 6:
			this.dictionaryExportToFile();
			break;
		default:
			//System.out.println("KHONG HOP LE !!!");
			break;
		}
		
	}
	
	// Tra từ
	public ArrayList<String> dictionarySearcher(String word_Need_Search)
	{
		ArrayList<String> list_Eword = new ArrayList<String>();
		//int num = 0;
		//boolean check = false;
		
		for(  Word word : this.getDictionary().getWord() )
		{
			if ( word.getWordSpelling().length() < word_Need_Search.length() )
			{
				continue;
			}
			
			if ( word.getWordSpelling().substring(0, word_Need_Search.length()).equals(word_Need_Search) )
			{
				//num++;
				//check = true;
				list_Eword.add(word.getWordSpelling());
			}
		}
		
		return list_Eword;
		
	}
	
	//thêm từ
	public boolean insertWord(String word_Need_Add, String explainWord_Need_Add)
	{
		Word wordInsert = new Word();
		
		wordInsert.setWordSpelling(word_Need_Add);

		wordInsert.setWordExplain(explainWord_Need_Add);
		
		
		boolean checkInsert = true;
		// true là thêm thành công, false là thêm thất bại
		for ( Word word : this.getDictionary().getWord() )
		{
			if ( word.getWordSpelling().equals(wordInsert.getWordSpelling()))
			{
				checkInsert = false;
				
				break;
			}
		}
		if ( checkInsert ) dictionaries.getWord().add(wordInsert);
		
		return checkInsert;
	}
	
	// xóa từ
	public boolean deleteWord(String word_Need_Delete)
	{
		boolean checkDelete = false;
		// true là xóa thành công, false là không xóa đc vì không thấy từ
		for ( Word word : this.getDictionary().getWord() )
		{
			if ( word.getWordSpelling().equals(word_Need_Delete))
			{
				this.getDictionary().getWord().remove(word);
				checkDelete = true;
				break;
			}
		}
		
		return checkDelete;
	}
	
	// sửa từ
	public boolean fixWord01(String word_Before, String word_After)
	{
			boolean check1 = false;

			
			for( Word word : this.getDictionary().getWord() )
			{
				if ( word.getWordSpelling().equals(word_Before) )
				{
				
					word.setWordSpelling(word_After);
					check1 = true;
					
					break;
				}
			}
			return check1; 
	}
	
	// sửa nghĩa của từ
		
	public boolean fixWord02(String word_Before, String word_After)
	{
		boolean check2 = false;
		
		
		for( Word word : this.getDictionary().getWord() )
		{
			if ( word.getWordSpelling().equals(word_Before) )
			{
				
				word.setWordExplain(word_After);
				check2 = true;

				break;
			}
		}
		return check2;
	}
	
	// in ra từ điển
/*	public void showAllWords()
	{	
		System.out.println("____________DICTIONARY____________");
		System.out.println("No \t\t| English \t\t| VietNamese \t\t\t");
		int num = 1;
		for (Word word : this.getDictionary().getWord()) 
		{
			//System.out.println(num + "\t\t| " + word.getWordSpelling() + "\t\t\t| " + word.getWordExplain() + "\t\t\t");
			num++;
		}
		System.out.println("-------------* * * ---------------");
	}
*/	
	// tra từ ( nguyên 1 từ ) 
	public String dictionaryLookup(String keyWord)
	{
		
		boolean isFinded = false;
		
		for(Word word : this.getDictionary().getWord())
		{
			int numW=1;
			if ( word.getWordSpelling().equals(keyWord) )
			{
				isFinded = true;
				return word.getWordExplain();
			}
		}
		
		return "Không tìm thấy từ";
	}

	
	// nhập dữ liệu từ file vào từ điển
	public void insertFromFile()
	{
		File file = new File("dictionariesWord.txt");
		try (Scanner inFile = new Scanner(file)) {
			String word_spelling, word_explain;
			while(inFile.hasNextLine() )
			{
				String oneLine = inFile.nextLine();
				word_spelling = oneLine.substring(0, oneLine.indexOf("\t"));
				word_explain = oneLine.substring(oneLine.indexOf("\t") + 1);
				
				Word word = new Word();
				word.setWordSpelling(word_spelling);
				word.setWordExplain(word_explain);
				
				
				
				this.getDictionary().getWord().add(word);
			}
		} catch (FileNotFoundException e) {
			//System.out.println("File Not Found");
			// TODO: handle exception
		}
	}
	
	public void dictionaryExportToFile()
	{
		File file = new File("dictionariesWord.txt");
		try {
			PrintWriter pw = new PrintWriter(file);
			for(Word word : this.getDictionary().getWord())
			{
				pw.println(word.getWordSpelling() + "\t" + word.getWordExplain());
				
			}
			//System.out.println("Lưu thành công.!!!");
			pw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("Ghi file không thành công !!!");
		}
		
	}

}
