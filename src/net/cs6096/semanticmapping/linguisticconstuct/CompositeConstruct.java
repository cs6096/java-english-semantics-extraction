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

// the underlying concept dimension's update must also be covered
public class CompositeConstruct extends LinguisticConstruct {
	public ArrayList<LinguisticConstruct> constituentConstructs = new ArrayList<>();
	public CompositeConstruct(TextConstructIndexMap newText, String newType, LinguisticConstruct... composingTokens){
		belongingText = newText;
		typeId = newType;
		for (LinguisticConstruct e: composingTokens){
			constituentConstructs.add(e);
			this.underlyingDimension.absorbOtherDimension(e.underlyingDimension);
//			this.underlyingOntology.absorb(e.underlyingOntology);
		}
		this.focusConcept = this.underlyingDimension.generateNewConceptOfCertainProperty("CompositeConstruct");
		this.underlyingDimension.setProperty(this.focusConcept,"PartOfSpeechLabel", typeId.toString());
		
	}
	@Override
	public int start() {
		return constituentConstructs.get(0).start();
	}
	@Override
	public int size() {
		int fin = 0;
		for (LinguisticConstruct e: constituentConstructs){
			fin += e.size();
		}
		return fin;
	}
	
	public String toSimpleString(){
		StringBuilder fin = new StringBuilder();
		fin.append(constituentConstructs.get(0).toSimpleString());
		for (int i = 1; i < constituentConstructs.size(); i++){
			fin.append(" ");
			fin.append(constituentConstructs.get(i).toSimpleString());
		}
		return fin.toString();
	}
	
	public String toString(){
		StringBuilder fin = new StringBuilder();
		fin.append("{"+ typeId+": ");
		for (LinguisticConstruct e: constituentConstructs){
			fin.append(e.toString());
		}
		fin.append("}");
		return fin.toString();
	}
	public int hashCode(){
		int fin = belongingText.originalText.hashCode();
		fin ^= typeId.hashCode() * typeId.hashCode();
		int index = this.start();
		fin ^= index * index * index;
		for (LinguisticConstruct e: constituentConstructs){
			fin ^= e.hashCode();
		}
		return fin;
	}
	public boolean equals(Object o1){
		if (!(o1 instanceof CompositeConstruct)) return false;
		CompositeConstruct k1 = (CompositeConstruct)o1;
		if (!typeId.equals(k1.typeId) ) return false;
		if (constituentConstructs.size() != k1.constituentConstructs.size()) return false;
		for (int i = 0; i < constituentConstructs.size(); i++){
			if (!constituentConstructs.get(i).equals(k1.constituentConstructs.get(i))) return false;
		}
		return true;
	}
	@Override
	public ArrayList<LinguisticConstruct> getChildren() {
		return constituentConstructs;
	}
}