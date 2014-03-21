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
package net.cs6096.semanticmapping.linguisticconstuct;

import net.cs6096.semanticmapping.core.TextConstructIndexMap;
import net.cs6096.semanticmapping.grammarset.EnglishTypeEnum;

import java.util.ArrayList;


public class AtomicConstruct extends LinguisticConstruct {
	public int index = -1;
	
	public AtomicConstruct(TextConstructIndexMap newText, String newType, int newIndex){
		isAtom = true;
		belongingText = newText;
		typeId = newType;
		index = newIndex;
	}
	public int hashCode(){
		int fin = belongingText.originalText.hashCode();
		fin ^= typeId.hashCode() * typeId.hashCode();
		fin ^= index * index * index;
		return fin;
	}
	public boolean equals(Object o1){
		if (!(o1 instanceof AtomicConstruct)) return false;
		AtomicConstruct k1 = (AtomicConstruct)o1;
		if (k1.typeId.equals(typeId) && k1.index == index) return true;
		return false;
	}
	@Override
	public int start() {
		return index;
	}
	@Override
	public int size() {
		return 1;
	}
	public String toString(){
		return "<"+ typeId+": "+belongingText.tokens.get(index)+">"+"["+index+"]";
	}
	@Override
	public String toSimpleString() {
		return belongingText.tokens.get(index);
	}
	@Override
	public ArrayList<LinguisticConstruct> getChildren() {
		return new ArrayList();
	}
}