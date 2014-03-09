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

public class RemoveSlash {
	public static void main(String[] args) throws Exception {
//		System.out.println(System.getProperty("user.dir"));
		String k1 = IOUtil.readFile("./removeSlash.txt");
		StringBuilder fin = new StringBuilder();
		for (char e : k1.toCharArray()){
			fin.append(Character.toLowerCase(e));
		}
		System.out.println(fin);
	}
}
