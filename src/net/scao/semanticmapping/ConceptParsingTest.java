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
package net.scao.semanticmapping;

import net.scao.semanticmapping.conceptual.ConceptUniverse;
import net.scao.semanticmapping.util.IOUtil;

import java.util.*;

public class ConceptParsingTest {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = IOUtil.readLineList("sampleConcept.txt");
		for (String e: lines){
			String cur = e.trim();
			if (cur.length() <= 0) continue;
			ConceptUniverse.parseConcept(cur);
			System.out.println();
		}
	}
}
