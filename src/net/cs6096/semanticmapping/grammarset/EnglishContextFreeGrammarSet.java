package net.cs6096.semanticmapping.grammarset;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

import net.cs6096.semanticmapping.util.IOUtil;
import net.cs6096.semanticmapping.util.JavaCodeUtil;
import net.cs6096.semanticmapping.util.StringUtil;
public class EnglishContextFreeGrammarSet {
	public static ArrayList<RewriteRule> applyingRules = new ArrayList<>();
	
	public static EnglishTypeManager usingManager = new EnglishTypeManager();
	
	public static void main(String[] args) throws Exception {
		generate();
	}
	
	public static void generate() throws Exception {
		
		ArrayList<String> rawRules = null;
		ArrayList<String>[] rawRulesAdjacencyList = null;
		
		String rawRuleFileString = IOUtil.readFile("newRules.txt");
		
		String processedRuleFileString = JavaCodeUtil.deleteComment(rawRuleFileString);
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new StringBufferInputStream(processedRuleFileString) ) );
		
		rawRules = new ArrayList();
		for (;;){
			String nextLine = br1.readLine();
//			System.out.println(nextLine);
			if (nextLine == null) break;
			rawRules.add(nextLine);
		}

		rawRulesAdjacencyList = new ArrayList[rawRules.size()];

		// read in input
		for (int i = 0; i < rawRules.size(); i++) {
			ArrayList<String> currentTokenizedRule = StringUtil.tokenize(rawRules.get(i));
			rawRulesAdjacencyList[i] = currentTokenizedRule;
		}
		
		// generate type system
		for (int i = 0 ; i  < rawRules.size(); i++){
			ArrayList<String> currentTokenizedRule = rawRulesAdjacencyList[i];
			if (currentTokenizedRule.size() >= 1){
				if (!currentTokenizedRule.get(0).contains("$")){
					for (String e: currentTokenizedRule){
						usingManager.addType(e);
					}
				}
			}
		}
		
		// generate the grammar rules and their universe update rules
		for (int i = 0; i < rawRules.size();){
			ArrayList<String> currentTokenizedRule = rawRulesAdjacencyList[i];
			if (currentTokenizedRule.size() <= 1){
				i++;
				continue;
			}
			else if (currentTokenizedRule.get(0).contains("$")){
				i++;
				continue;
			}
			else {
				RewriteRule currentRule = new RewriteRule(currentTokenizedRule);
				applyingRules.add(currentRule);
				i++;
				for (;i < rawRules.size();){
					ArrayList<String> nextRule = rawRulesAdjacencyList[i];
//					System.out.println(nextRule);
					if (nextRule.size() <= 1){
						i++;
						continue;
					}
					if (nextRule.get(0).charAt(0) == '$'){
//						System.out.println("HIT");
						currentRule.applyingConceptDimensionModifier.addCommand(nextRule);
						i++;
					}
					else break;
				}
			}
		}
		
	}
}



