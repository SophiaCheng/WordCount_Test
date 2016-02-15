package com.bina;

import static org.junit.Assert.*;

import java.io.*;
 

import org.junit.Test;

public class WordCounterTest {
	String fileName;
	
	@Test
	public void fileNotExist() {
		fileName = "/Users/Documents/mycode1/text.txt";
		File f = new File(fileName);
		 
		 assertFalse(f.exists());
	}
 
	 
	@Test
	public void stringOnlyCase() {
		File file = new File("stringOnlyTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("This is a basic test for only test characters without numbers or punctuation");
	        System.out.println("This is a basic case for testing characters without numbers or punctuation");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),13);
	}
	
	@Test
	public void punctOnlyCase() {
		File file = new File("punctOnlyTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        System.out.println("This is a case for punctuation only and zero counted.");
	        writer.write("\' ^&@# $ ^ \"\" | @");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),0);
	}
	
	@Test
	public void numberOnlyCase() {
		File file = new File("numberOnlyTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("1.2 3/4  3 132 -5 32%");
	        System.out.println("This is a case for number only of  1.2 3/4  3 132 -5 32%");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),0);
	}
	
	@Test
	public void validStringPunctCase() {
		File file = new File("validStringPunctTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("This is a test for \"valid\" punctuation: I'm a new grad from USC and I like apple-pie."
	        		+ " In this case apple-pie is counted as one.");
	        System.out.println("This is a case for testing valid string catenate punctuation ");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),25);
	}
	
	@Test
	public void invalidStringPunctCase() {
		File file = new File("invalidStringPunctTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("$wrong you&me F=ma"); 
                        
	        System.out.println("This is case for testing invalid string catenating puncutaion");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),0);
	}
	
	@Test
	public void validNumStringCase() {
		File file = new File("validnumStringTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("2-phase pie-3 one-2-three ");			  
	        System.out.println("This is a case for testing valid number catenating string");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),3);
	}
	
	
	@Test
	public void invalidNumStringCase() {
		File file = new File("invalidNumStringTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("one2three 3rd");
        			 
	        			  
	        System.out.println("This is a case for testing invalid number catenating string");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),0);
	}
	
	@Test
	public void  NumPunctCase() {
		File file = new File("NumPunctTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("123, 23! &4.3 -4! 3$2 &3&");
        			 
	        			  
	        System.out.println("This is a case for testing number catenating punctuation");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),0);
	}
	
	@Test
	public void combinationCase() {
		File file = new File("combinationTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("In your examples, \"E=MC^2\" and \"F=ma\" are formula representations, "
	        		+ "not words in a sentence. you&me is also not a word. \"you & me\"."
	        		+ " would count as 2 words.");
        			 
	        			  
	        System.out.println("This is a case for testing combination of string, number and punctuation");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),23);
	}
	
	@Test
	public void  nonASCIICase() {
		File file = new File("NumPunctTest.txt");
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write("英语 англійська영어");
        			 
	        			  
	        System.out.println("This is a test for non-ASCII characters");
	    } catch (IOException e) {
	        e.printStackTrace();  
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    WordCounter w1 = new WordCounter(file.getAbsolutePath());
		 assertEquals(w1.count(),0);
	}
}
