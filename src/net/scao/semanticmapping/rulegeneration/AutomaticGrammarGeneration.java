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
package net.scao.semanticmapping.rulegeneration;

import net.scao.semanticmapping.util.IOUtil;
import net.scao.semanticmapping.util.JavaCodeUtil;
import net.scao.semanticmapping.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class AutomaticGrammarGeneration {
	private static ArrayList<String> rawRules = null;
	private static ArrayList<String>[] rawRulesAdjacencyList = null;
	
	public static void readInput() throws Exception {
		String rawString = IOUtil.readFile("newRules.txt");
		rawString = JavaCodeUtil.deleteComment(rawString);
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new StringBufferInputStream(rawString)));
		
		rawRules = new ArrayList();
		for (;;){
			String nextLine = br1.readLine();
			
			if (nextLine == null) break;
			rawRules.add(nextLine);
		}
		

		rawRulesAdjacencyList = new ArrayList[rawRules.size()];

		for (int i = 0; i < rawRules.size(); i++) {
			ArrayList<String> currentTokenizedRule = StringUtil.tokenize(rawRules.get(i));
			rawRulesAdjacencyList[i] = currentTokenizedRule;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		readInput();

//		generateEnumFile();

//		generateGrammarSetFile();
		
//		generateExperimentalGrammarSetFile();

		System.out.println("DONE");
	}
	
	public static void generateExperimentalGrammarSetFile() throws Exception {
		StringBuilder ruleFileText = new StringBuilder();
		String ruleHeader = "package net.shengcao.semanticmapping.grammarset;\n" + "import java.util.ArrayList;\n"
			+ "public class EnglishContextFreeGrammarSet {\n" + "\tpublic static ArrayList<RewriteRule> applyingRules=new ArrayList<>();\n" + "\tstatic {\n";
		ruleFileText.append(ruleHeader);
		int foundRuleCount = 0;
		for (int idx = 0;idx < rawRulesAdjacencyList.length; idx++){
			ArrayList<String> e = rawRulesAdjacencyList[idx];
			if (e.size() <= 1)
				continue;
			ruleFileText.append("{\n");
			ruleFileText.append("    RewriteRule currentRule = " + "new RewriteRule(");
			for (int i = 0; i < e.size(); i++) {
				if (i != 0)
					ruleFileText.append(", ");
				ruleFileText.append("EnglishTypeEnum." + e.get(i));
			}
			ruleFileText.append(");\n");
			ruleFileText.append("	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(\n");
			int addedCommand = 0;
			for (;;){
				if (idx >= rawRulesAdjacencyList.length) break;
				ArrayList<String> nextRule = rawRulesAdjacencyList[idx];
				if (nextRule.size() <= 1) idx++;
				if (!nextRule.get(0).contains("$")) break;
				if (addedCommand > 0) ruleFileText.append(", ");
				
				StringBuilder newCommandString = new StringBuilder();
				newCommandString.append(", new Command(");
				for (int j = 0; j < nextRule.size(); j++){
					if (j != 0){
						newCommandString.append(", ");
					}
					newCommandString.append("\""+nextRule.get(j)+"\"");
				}
				
				newCommandString.append(")");
				ruleFileText.append(newCommandString);
				ruleFileText.append("\n");
				addedCommand++;
				idx++;
			}
			ruleFileText.append("	);\n");
			ruleFileText.append("    applyingRules.add(currentRule);\n");
			

			ruleFileText.append("}\n");
			foundRuleCount++;
		}
		System.out.println("found " + foundRuleCount + " grammar rules");

		String ruleTail = "\n"
			+ "\t}\n"
			+ "}\n"
			+ "\n"
			+ "\n";
		ruleFileText.append(ruleTail);

		// IOUtil.writeFile("./generated/EnglishContextFreeGrammarSet.java",
		// ruleFileText.toString());
		IOUtil.writeFile("./experiment/EnglishContextFreeGrammarSet.java", ruleFileText.toString());

		
	}

	public static void generateEnumFile() throws Exception {

		HashSet<String> typeSet = new HashSet<>();
		
		for (ArrayList<String> e: rawRulesAdjacencyList){
			if (e.size() > 0){
				if (!e.get(0).contains("$")){
					typeSet.addAll(e);
				}
			}
		}

		StringBuilder enumFileText = new StringBuilder();
		enumFileText.append("// generated enum\n");
		enumFileText.append("package net.shengcao.semanticmapping.grammarset;\n");
		enumFileText.append("public enum EnglishTypeEnum {");
		{
			int used = 0;
			for (String e : typeSet) {

				if (used != 0) {
					enumFileText.append(", ");
				}
				enumFileText.append(e);
				used++;
				// System.out.println(e);
			}
			System.out.println("found " + used + " types of part of speech");
		}

		enumFileText.append("}");
		IOUtil.writeFile("./src/net/shengcao/semanticmapping/grammarset/EnglishTypeEnum.java", enumFileText.toString());

	}

	public static void generateGrammarSetFile() throws Exception {

		StringBuilder ruleFileText = new StringBuilder();
		String ruleHeader = "package net.shengcao.semanticmapping.grammarset;\n" + "import java.util.ArrayList;\n"
			+ "public class EnglishContextFreeGrammarSet {\n" + "\tpublic static ArrayList<RewriteRule> applyingRules=new ArrayList<>();\n" + "\tstatic {\n";
		ruleFileText.append(ruleHeader);
		int foundRuleCount = 0;
		for (ArrayList<String> e : rawRulesAdjacencyList) {
			if (e.size() <= 1)
				continue;
			if (e.get(0).contains("$")) continue;
			ruleFileText.append("{\n");
			ruleFileText.append("    RewriteRule currentRule = " + "new RewriteRule(");
			for (int i = 0; i < e.size(); i++) {
				if (i != 0)
					ruleFileText.append(", ");
				ruleFileText.append("EnglishTypeEnum." + e.get(i));
			}
			ruleFileText.append(");\n");
			ruleFileText.append("    applyingRules.add(currentRule);\n");

			ruleFileText.append("}\n");
			foundRuleCount++;
		}
		System.out.println("found " + foundRuleCount + " grammar rules");

		String ruleTail = "\n"
			+ "\t}\n"
			+ "}\n"
			+ "\n"
			+ "\n";
		ruleFileText.append(ruleTail);

		// IOUtil.writeFile("./generated/EnglishContextFreeGrammarSet.java",
		// ruleFileText.toString());
		IOUtil.writeFile("./src/net/shengcao/semanticmapping/grammarset/EnglishContextFreeGrammarSet.java", ruleFileText.toString());

	}
}
