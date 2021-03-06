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
package net.cs6096.semanticmapping.rulegeneration;

import net.cs6096.semanticmapping.util.StringUtil;

import java.util.*;
import java.io.*;
import java.math.*;

public class RefactorUtil {
	public static ArrayList<ArrayList<String>> rules() throws Exception {
		ArrayList<ArrayList<String>> fin = new ArrayList<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("./rules.txt")));
		for (;;){
			String line = in.readLine();
			if (line == null ) break;
			fin.add(StringUtil.tokenize(line));
		}

		return fin;
	}
}
