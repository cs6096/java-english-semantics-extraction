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
package net.cs6096.semanticmapping.util;
import java.util.*;
public class StringUtil {
	public static ArrayList<String> tokenize(String s1){
		ArrayList<String> fin = new ArrayList();
		StringTokenizer st1 = new StringTokenizer(s1);
		for (;st1.hasMoreTokens();){
			fin.add(st1.nextToken());
		}
		return fin;
	}
	public static String removePunctuation(String s1){
		StringBuilder fin = new StringBuilder();
		for (int i = 0 ; i < s1.length(); i++){
			char cur = s1.charAt(i);
			if (Character.isAlphabetic(cur)){
				fin.append(cur);
			}
		}
		return fin.toString();
	}
	public static String canonize1(String s1){
		return removePunctuation(s1).toLowerCase();
	}
	public static boolean nonEmpty(String s1){
		for (int i = 0 ; i < s1.length(); i++){
			if (!Character.isWhitespace(s1.charAt(i))) return true;
		}
		return false;
	}
	public static String formattedStringArrayString(List<String> l1){
		StringBuilder fin = new StringBuilder();
		fin.append("{\n");
		for (int i =0; i < l1.size(); i++){
			if (i != 0) fin.append(", ");
			fin.append(l1.get(i)+"\n");
		}
		fin.append("}\n");
		return fin.toString();
	}
	
}
