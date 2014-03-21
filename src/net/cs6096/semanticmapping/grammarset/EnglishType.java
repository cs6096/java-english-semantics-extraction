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
package net.cs6096.semanticmapping.grammarset;

import java.util.HashMap;
import java.util.HashSet;

public class EnglishType {

	public static HashSet<String> atoms = new HashSet<>();
	static {
		atoms.add("NOUN");
		atoms.add("PROPER_NOUN");
		atoms.add("VERB");
		atoms.add("ARTICLE");
		atoms.add("PREPOSITION");
		atoms.add("PROPER_NOUN");
		atoms.add("ADVERB");
		atoms.add("ADJECTIVE");
		atoms.add("CONJUNCTION");
		atoms.add("DETERMINER");
		atoms.add("WH_PRONOUN");
		atoms.add("TO_BE_VERB");
		atoms.add("TO");
		atoms.add("AUXILIARY");
		atoms.add("COMMA");
		atoms.add("FULL_STOP");
		atoms.add("QUESTION_MARK");
		atoms.add("POSSESSIVE_PRONOUN");
		atoms.add("CONJUNCTION");
	}

	public static HashSet<String> printingTypeId = new HashSet();
	static {
		printingTypeId.add("SIMPLE_DECLARATIVE_CLAUSE");
		printingTypeId.add("INTERROGATIVE_CLAUSE");
	}

}

