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

import java.util.ArrayList;


public class NLPStringUtil {
	public static ArrayList<String> NLPTokenize(String s1){
		String canonlized = canonlizePunctuationalAbbreviation(s1);
		StringBuilder temp1 = new StringBuilder();
		for (char e: canonlized.toCharArray()){
			if (e == '.'
					|| e == ','
					|| e == '?'
					|| e == '"'
					){
				temp1.append(" "+e+" ");
			}
			else {
				temp1.append(e);
			}
		}
		return StringUtil.tokenize(temp1.toString());
	}


	static String[] validHead = {"he","she","it","they","we","there","you", "I"};
	static String[][] substitionPattern = {
			                                      {"'s"," is"}
			                                      , {"'re"," are"}
			                                      , {"'d"," would"}
	};
	public static String canonlizePunctuationalAbbreviation(String s1){
		String fin = s1;

		for (String head : validHead){
			char[] temp = head.toCharArray();
			temp[0] = Character.toUpperCase(temp[0]);
			String head2 = String.valueOf(temp);
			for (String[] pair : substitionPattern){
				String seeking  = head + pair[0];
				String replacing = head  + pair[1];
				fin = fin.replace(seeking, replacing);
				String seeking2 = head2 + pair[0];
				fin = fin.replace(seeking2, replacing);
			}
		}

		return fin;
	}

	public static String NLPPurposeProcessing(String s1){
		StringBuilder temp1 = new StringBuilder();
		for (char e: s1.toCharArray()){
			if (e == '.'
					|| e == ','
					|| e == '?'
					|| e == '"'
					){
				temp1.append(" "+e+" ");
			}
			else {
				temp1.append(e);
			}
		}
		return temp1.toString();
	}

}
