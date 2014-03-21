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

package net.cs6096.semanticmapping.debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import net.cs6096.semanticmapping.core.*;
import net.cs6096.semanticmapping.factory.Factory;
import net.cs6096.semanticmapping.grammarset.EnglishContextFreeGrammarSet;
import net.cs6096.semanticmapping.grammarset.RewriteRule;
import net.cs6096.semanticmapping.linguisticconstuct.LinguisticConstruct;
import net.cs6096.semanticmapping.util.IOUtil;
import net.cs6096.semanticmapping.util.NLPStringUtil;

public class TestingShell {
	public static void main(String[] args) throws Exception {
		EnglishContextFreeGrammarSet.generate();
		testFromConsole();
//		testOnTestSentence();
	}
	public static ArrayList<String> getTestSentences() throws Exception {
		return IOUtil.readLineList("testSentence.txt");
	}
	public static void px(Object ...objects){
		System.out.println(Arrays.deepToString(objects));
	}
	public static void testFromConsole() throws Exception {
		Factory.initialize();
//		GeneralUtil.px(text1);
		Scanner scan = new Scanner(System.in);
		for (;;){
			String e = scan.nextLine();
			if (e.equals("exit")) break;
			String normalized = NLPStringUtil.NLPPurposeProcessing(e);
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
//				System.out.println(f);

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
				System.out.println();
			}
			System.out.println(remainingAmibuguiousElement);
			
		}
		
	}

	/*
	 * The sentences used are in ./testSentence.txt. Modify the file to
	 * define the sentence you wish to test on.
	 */
	public static void testingPipeline() throws Exception {
		System.out.println("To change the testing sentences, modify \"testSentence.txt\" under the project directory.");
		String text1 = net.cs6096.semanticmapping.util.IOUtil.readFile("testSentence.txt");
		Factory.initialize();
//		GeneralUtil.px(text1);
		ArrayList<String> sents = net.cs6096.semanticmapping.util.IOUtil.readLineList("testSentence.txt");
		for (String e: sents){
			String normalized = NLPStringUtil.NLPPurposeProcessing(e);
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
//				System.out.println(f);

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
	
//	public static void testOnTestSentence() throws Exception {
//		ArrayList<String> l1 = net.cs6096.semanticmapping.util.IOUtil.readLineList("testSentence.txt");
//		for (String e: l1){
////			String normalized = QuestionNormalizer.normalize(e);
//			String normalized = NLPStringUtil.NLPPurposeProcessing(e);
//			System.out.println(normalized);
//
//			TextConstructIndexMap t1 = Factory.analysisSentence(normalized);
//			int totalConstructCount = 0;
//			for (int i =0; i < t1.tokens.size(); i++){
//				System.out.println(i +": "+t1.tokens.get(i));
////				System.out.println(t1.tokenAdjacencyList[i]);
//				for (LinguisticConstruct f: t1.tokenAdjacencyList[i]){
//					totalConstructCount++;
////					if (!EnglishType.printingTypeId.contains(f.typeId)) continue;
//					TestingShell.px(f);
//					TestingShell.px(f.toSimpleString());
////					Print.print(f.underlyingOntology);
//					System.out.println();
////					if (f.type == EnglishType.SIMPLE_CLAUSE){
////						interpretSentence(f);
////						
////					}
//				}
//			}
//			System.out.println(totalConstructCount);
////			break;
//		}
//	}

}
