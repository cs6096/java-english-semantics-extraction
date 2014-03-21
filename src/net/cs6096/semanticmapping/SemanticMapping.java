package net.cs6096.semanticmapping;

import java.util.*;

import net.cs6096.semanticmapping.core.TextConstructIndexMap;
import net.cs6096.semanticmapping.debug.Debug;
import net.cs6096.semanticmapping.factory.Factory;
import net.cs6096.semanticmapping.grammarset.EnglishContextFreeGrammarSet;
import net.cs6096.semanticmapping.grammarset.RewriteRule;
import net.cs6096.semanticmapping.linguisticconstuct.LinguisticConstruct;
import net.cs6096.semanticmapping.sentencebreak.SentenceBreak;
import net.cs6096.semanticmapping.util.NLPStringUtil;

public class SemanticMapping {
	public static void main(String[] args){
		Initialization.initialize();
		Scanner scan = new Scanner(System.in);
		for (;scan.hasNext();){
			String line = scan.nextLine();
			ArrayList<String> brokenSentences = SentenceBreak.sentenceBreak(line);
			for (String e: brokenSentences){
				System.out.println(e);
				runOnSentence(e);
			}
		}
	}
	public static void runOnSentence(String sentence){
		String normalized = NLPStringUtil.NLPPurposeProcessing(sentence);
		System.out.println(normalized);

		TextConstructIndexMap newMap = new TextConstructIndexMap(normalized);

		Factory.conceptualPartOfSpeechGenerator.generate(newMap);

		System.out.println(newMap.tokens);
		
		for (int j = 0; j < 20; j++){
			for (int i =0; i < newMap.tokenAdjacencyList.length; i++){
				for (RewriteRule f: EnglishContextFreeGrammarSet.applyingRules){
					f.probe(newMap, i);
				}
			}
		}
		
		int bestLength = 0;
		
		int remainingAmibuguiousElement = 0;
		for (HashSet<LinguisticConstruct> f: newMap.tokenAdjacencyList){
//			System.out.println(f);

			for (LinguisticConstruct g: f){
				bestLength = Math.max(bestLength, g.size());
			}
		}
		
		ArrayList<LinguisticConstruct> fin = new ArrayList<>();
		for (HashSet<LinguisticConstruct> f: newMap.tokenAdjacencyList){
			for (LinguisticConstruct g: f){
				if (g.size() == bestLength){
					fin.add(g);
					System.out.println(g);
					System.out.println(g.toSimpleString());
					Debug.print(g.underlyingDimension);
					remainingAmibuguiousElement++;
				}
			}
		}
		System.out.println(remainingAmibuguiousElement);
	}
}
