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
package net.scao.semanticmapping.grammarset;

import java.util.HashMap;
import java.util.HashSet;

public class EnglishType {

	public static HashSet<EnglishTypeEnum> atoms = new HashSet<>();
	static {
		atoms.add(EnglishTypeEnum.NOUN);
		atoms.add(EnglishTypeEnum.PROPER_NOUN);
		atoms.add(EnglishTypeEnum.VERB);
		atoms.add(EnglishTypeEnum.ARTICLE);
		atoms.add(EnglishTypeEnum.PREPOSITION);
		atoms.add(EnglishTypeEnum.PROPER_NOUN);
		atoms.add(EnglishTypeEnum.ADVERB);
		atoms.add(EnglishTypeEnum.ADJECTIVE);
		atoms.add(EnglishTypeEnum.CONJUNCTION);
		atoms.add(EnglishTypeEnum.DETERMINER);
		atoms.add(EnglishTypeEnum.WH_PRONOUN);
		atoms.add(EnglishTypeEnum.TO_BE_VERB);
		atoms.add(EnglishTypeEnum.TO);
		atoms.add(EnglishTypeEnum.AUXILIARY);
		atoms.add(EnglishTypeEnum.COMMA);
		atoms.add(EnglishTypeEnum.FULL_STOP);
		atoms.add(EnglishTypeEnum.QUESTION_MARK);
		atoms.add(EnglishTypeEnum.POSSESSIVE_PRONOUN);
		atoms.add(EnglishTypeEnum.CONJUNCTION);
	}

	public static HashSet<EnglishTypeEnum> printingTypeId = new HashSet();
	static {
		printingTypeId.add(EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE);
		printingTypeId.add(EnglishTypeEnum.INTERROGATIVE_CLAUSE);
	}

}

