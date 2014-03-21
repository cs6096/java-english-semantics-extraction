/*
 * Copyright (C) 2014  Sheng Cao <sca6096@gmail.com>. All rights reserved.
 * 
 * The file is part of English-Semantics-Extraction.
 * 
 * English-Semantics-Extraction is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Please contact sca6096@gmail.com if you need additional information
 * or have any questions.
 */

package net.cs6096.semanticmapping.core;

import net.cs6096.semanticmapping.grammarset.EnglishTypeEnum;
import net.cs6096.semanticmapping.util.IOUtil;




import java.util.HashSet;

public class PartOfSpeechMarker {
	
	static HashSet<String> nounList = new HashSet<>();
	static HashSet<String> verbList = new HashSet<>();
	static HashSet<String> auxiliaryList = new HashSet<>();
	static HashSet<String> adjectiveList = new HashSet<>();
	static HashSet<String> adverbList = new HashSet<>();
	static HashSet<String> prepositionList = new HashSet<>();
	static HashSet<String> toBeVerbList = new HashSet<>();
	static HashSet<String> concretePronounList = new HashSet<>();
	static HashSet<String> determinerPronounList = new HashSet<>();
	static HashSet<String> whPronounList = new HashSet<>();
	static HashSet<String> conjunctionList = new HashSet<>();
	static {
		try {
			nounList.addAll(IOUtil.readTokenList("./partOfSpeechList/noun.txt"));
			verbList.addAll(IOUtil.readTokenList("./partOfSpeechList/verb.txt"));
			auxiliaryList.addAll(IOUtil.readTokenList("./partOfSpeechList/auxiliary.txt"));
			adjectiveList.addAll(IOUtil.readTokenList("./partOfSpeechList/adjective.txt"));
			adverbList.addAll(IOUtil.readTokenList("./partOfSpeechList/adverb.txt"));
			prepositionList.addAll(IOUtil.readTokenList("./partOfSpeechList/preposition.txt"));
			toBeVerbList.addAll(IOUtil.readTokenList("./partOfSpeechList/toBeVerb.txt"));
			// as of http://learnenglish.britishcouncil.org/zh-hans/english-grammar/determiners-and-quantifiers
			determinerPronounList.addAll(IOUtil.readTokenList("./partOfSpeechList/determinerPronoun.txt"));
			concretePronounList.addAll(IOUtil.readTokenList("./partOfSpeechList/concretePronoun.txt"));
			whPronounList.addAll(IOUtil.readTokenList("./partOfSpeechList/whPronoun.txt"));
			conjunctionList.addAll(IOUtil.readTokenList("./partOfSpeechList/conjunction.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean isNoun(String queryWord){
		if (nounList.contains(queryWord)) return true;
		if (queryWord.charAt(queryWord.length() - 1) == 's'){
//			px(queryWord.substring(0, queryWord.length() - 1));
			if (nounList.contains(queryWord.substring(0, queryWord.length() - 1) ) ) return true;
		}
		if (queryWord.endsWith("es")){
			if (nounList.contains(queryWord.substring(0, queryWord.length() - 2) ) ) return true;
		}
		if (queryWord.endsWith("ies")){
			if (nounList.contains(queryWord.substring(0, queryWord.length() - 3)+"y" ) ) return true;
		}
		return false;
	}
	public static boolean isVerb(String queryWord){
		if (verbList.contains(queryWord)) return true;
		if (queryWord.endsWith("ing")){
			String possibleOriginal = queryWord.substring(0, queryWord.length() - 3);
			if (isVerb(possibleOriginal)) return true;
		}
		if (queryWord.endsWith("ed")){
			String possibleOriginal = queryWord.substring(0, queryWord.length() - 2);
			if (isVerb(possibleOriginal)) return true;
		}
		return false;
	}
	public static boolean isAuxiliary(String queryWord){
		if (auxiliaryList.contains(queryWord)){
			return true;
		}
		return false;
	}
	
	public static boolean isVerbPresentTence(String queryWord){
		if (!isVerb(queryWord)){
			return false;
		}
		if (queryWord.endsWith("ing")){
			return true;
		}
		return true;
	}
	
	public static boolean isVerbPastTence(String queryWord){
		if (!isVerb(queryWord)){
			return false;
		}
		if (queryWord.endsWith("ed")){
			return true;
		}
		return true;
	}
	
	public static boolean isAdjective(String queryWord){
		if (adjectiveList.contains(queryWord)) return true;
		return false;
	}
	
	public static boolean isAdverb(String queryWord){
		if (adverbList.contains(queryWord)) return true;
		if (queryWord.endsWith("ly")){
			String possibleOriginal = queryWord.substring(0, queryWord.length()-2);
			if (adjectiveList.contains(possibleOriginal)){
				return true;
			}
		}
		if (queryWord.endsWith("ily")){
			String possibleOriginal = queryWord.substring(0, queryWord.length()-3) + "y";
			if (adjectiveList.contains(possibleOriginal)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPreposition(String queryWord){
		if (prepositionList.contains(queryWord)) return true;
		return false;
	}
	
	public static boolean isPronounDeterminer(String queryWord){
		if (determinerPronounList.contains(queryWord)){
			return true;
		}
		if (queryWord.endsWith("'s")) return true;
		return false;
	}
	
	public static boolean isPronoun(String queryWord){
		if (concretePronounList.contains(normalizedWord1(queryWord) ) ){
			return true;
		}
		return false;
	}
	
	public static boolean isToBeVerb(String queryWord){
		if (toBeVerbList.contains(queryWord)){
			return true;
		}
		return false;
	}
	
	public static boolean isWhPronoun(String queryWord){
		if (whPronounList.contains(normalizedWord1(queryWord))){
			return true;
		}
		return false;
	}

	public static boolean isConjunction(String queryWord){
		if (conjunctionList.contains(normalizedWord1(queryWord))){
			return true;
		}
		return false;
	}
	
	public static boolean canBeProperNoun(String queryWord){
		for (char e: queryWord.toCharArray()){
			if (Character.isUpperCase(e)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPureNumbers(String queryWord){
		boolean hit = false;
		for (char e: queryWord.toCharArray()){
			if (e != '+' && e != '-' && e != '.' && e!= ','){
				if (e > '9' || e < '0') return false;
				hit = true;
			}
		}
		return hit;
	}
	
	public static HashSet<String> wordsPOS(String queryWord) throws Exception {
		HashSet<String> fin = new HashSet<>();
		if (normalizedWord1(queryWord).equals("a")
				|| normalizedWord1(queryWord).equals("an")
				|| normalizedWord1(queryWord).equals("the")
				){
			fin.add("ARTICLE");
			return fin;
		}
		if (isNoun(queryWord)){
			fin.add("NOUN");
		}
		if (isVerb(queryWord)){
			fin.add("VERB");
		}
		if (isAdjective(queryWord)){
			fin.add("ADJECTIVE");
		}
		else if(isPronounDeterminer(queryWord)){
			fin.add("POSSESSIVE_PRONOUN");
		}
		if (isAdverb(queryWord)){
			fin.add("ADVERB");
		}
		if (isPreposition(queryWord)){
			fin.add("PREPOSITION");
		}
		
		if (isToBeVerb(queryWord)){
			fin.add("TO_BE_VERB");
		}
		if (isAuxiliary(queryWord)){
			fin.add("AUXILIARY");
		}
		if (isPronoun(queryWord)){
			fin.add("PRONOUN");
		}
		if (isWhPronoun(queryWord)){
			fin.add("WH_PRONOUN");
		}
		if (isConjunction(queryWord)){
			fin.add("CONJUNCTION");
		}

		if (normalizedWord1(queryWord).equals("there")){
			fin.add("THERE");
		}

		if (fin.size() == 0){
			if (canBeProperNoun(queryWord)){
				fin.add("PROPER_NOUN");
			}
		}
		if (queryWord.length() > 0 && Character.isUpperCase(queryWord.charAt(0))){
			fin.add("PROPER_NOUN");
		}
		
		
		if (isPureNumbers(queryWord)){
			fin.add("NOUN");
			fin.add("ADJECTIVE");
		}
		
		if (normalizedWord1(queryWord).equals("to")){
			fin.add("TO");
		}
		if (queryWord.trim().equals(".")){
			fin.add("FULL_STOP");
		}
		if (queryWord.trim().equals(",")){
			fin.add("COMMA");
		}
		if (queryWord.trim().equals("?")){
			fin.add("QUESTION_MARK");
		}

		return fin;
	}
	
	public static String normalizedWord1(String given){
		StringBuilder fin = new StringBuilder();
		for (char e: given.toLowerCase().toCharArray()){
			if (Character.isAlphabetic(e)){
				fin.append(e);
			}
		}
		return fin.toString();
	}
	
}



