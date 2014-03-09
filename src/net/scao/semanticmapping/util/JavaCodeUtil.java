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
package net.scao.semanticmapping.util;
import java.util.*;
import java.io.*;
public class JavaCodeUtil {
	
	public static String[] javaKeywords = 
		{"abstract", "continue", "for", "new", "switch"
		, "assert", "default", "if", "package", "synchronized"
		, "boolean", "do", "goto", "private", "this"
		, "break", "double", "implements", "protected"
		, "throw", "byte", "else", "import", "public"
		, "throws", "case", "enum", "instanceof", "return"
		, "transient", "catch", "extends", "int", "short"
		, "try", "char", "final", "interface", "static"
		, "void", "class", "finally", "long", "strictfp"
		, "volatile", "const", "float", "native", "super"
		, "while"
		};
	
	public static char[] specialChars = {',','+','-','*','/', '(',')','{','}'}; 
	public static String crumple(String f1){
		StringBuilder fin = new StringBuilder();
		boolean inQuote = false;
		for (int i = 0  ; i < f1.length(); i++){
			if (!inQuote) if (Character.isWhitespace(f1.charAt(i))) continue;
			boolean enter = false;
			boolean exit = false;
			if (f1.charAt(i) == '"'){
				if (i == 0){
					inQuote = true;
				}
				else {
					if (!inQuote){
						enter = true;
						inQuote = true;
					}
					else {
						if (f1.charAt(i - 1) != '\\'){
							exit = true;
							inQuote = false;
						}
					}
				}
			}
			fin.append(f1.charAt(i));
		}
		return fin.toString();
	}
	public static ArrayList<String> tokenizeQuotes(String f1){
		ArrayList<String> fin = new ArrayList();
		StringBuilder temp = new StringBuilder();
		boolean inQuote = false;
		for (int i = 0  ; i < f1.length(); i++){
			if (!inQuote) if (Character.isWhitespace(f1.charAt(i))) continue;
			boolean enter = false;
			boolean exit = false;
			if (f1.charAt(i) == '"'){
				if (i == 0){
					inQuote = true;
				}
				else {
					if (!inQuote){
						enter = true;
						inQuote = true;
					}
					else {
						if (f1.charAt(i - 1) != '\\'){
							exit = true;
							inQuote = false;
						}
					}
				}
			}
			if (enter){
				fin.add(temp.toString());
				temp = new StringBuilder();
			}
			temp.append(f1.charAt(i));
			if (exit){
				fin.add(temp.toString());
				temp = new StringBuilder();
			}
		}
		if (temp.length()!=0) fin.add(temp.toString());
		return fin;
	}
	public static ArrayList<String> tokenizedCode(String code){
		ArrayList<String> fin = new ArrayList<>();
		StringBuilder spaced = new StringBuilder();
		A:
		for (char e: code.toCharArray()){
			for (char f: specialChars){
				if (f == e){
					spaced.append(" ");
					spaced.append(e);
					spaced.append(" ");
					continue A;
				}
			}
			spaced.append(e);
		}
		return StringUtil.tokenize(code);
	}
	public static String deleteComment(String code) throws IOException {
		String cur = clearBlockComment(code);
		BufferedReader in = new BufferedReader(new StringReader(cur));
		StringBuilder fin = new StringBuilder();
		for (;;){
			String line = in.readLine();
			if (line == null) break;
			String clean = clearLineComment(line);
			if (StringUtil.nonEmpty(clean)){
				fin.append(clean);
				fin.append('\n');
			}
		}
		return fin.toString();
	}
	
	public static String clearBlockComment(String f1){
		StringBuilder fin = new StringBuilder();
		boolean include = true;
		for (int i = 0  ; i < f1.length(); i++){
			if (i < f1.length()-1){
				if (f1.charAt(i) == '/' && f1.charAt(i+1) == '*'){
					include = false;
				}
				else if (f1.charAt(i) == '*' && f1.charAt(i+1) == '/'){
					i++;
					include = true;
					continue;
				}
			}
			if (include) fin.append(f1.charAt(i));
		}
		return fin.toString();
	}
	
	public static String clearLineComment(String f1){
		boolean inQuote = false;
		int end = 0;
		for (int i = 0  ; i < f1.length(); i++){
			char c1 = f1.charAt(i);
			if (c1 == '"'){
				if (i == 0 || f1.charAt(i-1) != '\\'){
					inQuote = !inQuote;
				}
			}
			end = i + 1;
			if (inQuote) continue;
			if (i < f1.length()-1){
				if (c1 == '/' && f1.charAt(i+1) == '/'){
					end = i;
					break;
				}
			}
		}
		return f1.substring(0,end);
	}
	
	
}

