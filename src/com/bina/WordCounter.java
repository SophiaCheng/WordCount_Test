package com.bina;
import java.util.*;

import java.io.*;

 
public class WordCounter {
	
	Scanner textFile;
	private int counter;
	public WordCounter(String text) {
		 try{
			 textFile = new Scanner(new FileReader(text));
		 } catch (FileNotFoundException e){
			 System.err.println(e);
			 return;
		 }  
	}
	public int count(){
		 
		while(textFile.hasNext()){
			String input = textFile.next();
			boolean notCount = false;
			 
			
			boolean hasConn = input.split("-").length > 1;
			boolean hasChar = false;
			 
			String[] words = input.split("-");
			for(String word : words){
				if(word.length() == 0){
					continue;
				}
				if(isPairPre(word)){
					word = word.substring(1);
					if(word.length() == 0){
						notCount = true;
					}
				}
				
				 
				// to check only punctuation
				if(word.split("\\W+").length == 0){
				//	System.out.println("check punctuation");
					notCount = true;
					continue;
				}
				
				//check possesion 
				if(word.split("\\W+").length > 1 && word.split("\'").length < 2 ){
					//System.out.println("possesion" + word);
					notCount = true;
					continue;
				}
				
				 
				//has number without valid punctuation
				if(isNumeric(word) && !hasConn){
				// System.out.println("single number without hasConn");
					notCount = true;
					continue;
				} else if(word.split("\\d+").length > 1){
				//	System.out.println("number catenate with string" + word);
					notCount = true;
					continue;
				}
				
				if(!isNumeric(word)){
					hasChar = true;
				}
				 
			}
			if(!hasChar){
				continue;
			}
			if(!notCount){
			//	System.out.print(input + " ");
				counter ++;
			}
		 
		}
		 
		System.out.println(counter);
		return (counter);
		 
	}
	
	public boolean isNumeric(String str){
		 return str.split("\\d+").length == 0 || str.split(".").length == 2;
	}
	
	public boolean isPairPre(String input){
		char c = input.charAt(0);
		if (c == '\'' || c == '\"'|| c == '(' || c == '[' || c == '{'){	 
			return true;
		}
		return false;
	}
	
	 
	
}
