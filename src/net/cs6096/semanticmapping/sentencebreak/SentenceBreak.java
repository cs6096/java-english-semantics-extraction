package net.cs6096.semanticmapping.sentencebreak;

import java.util.ArrayList;

public class SentenceBreak {
	public static ArrayList<String> sentenceBreak(String input){
		ArrayList<String> fin = new ArrayList<>();
		ArrayList<Integer> breakingIndex = new ArrayList<>();
		for (int i = 0 ; i <input.length(); i++){
			if (input.charAt(i) == '.'
				|| input.charAt(i) == '?'
				|| input.charAt(i) == '!'
				){
				breakingIndex.add(i);
			}
		}
		int last = 0;
		for (int i = 0;i < breakingIndex.size() ;i++){
			int cur = breakingIndex.get(i);
			fin.add(input.substring(last, cur + 1) );
			last = cur + 1;
		}
		if (last != input.length()){
			fin.add(input.substring(last, input.length()));
		}
		return fin;
	}

}
