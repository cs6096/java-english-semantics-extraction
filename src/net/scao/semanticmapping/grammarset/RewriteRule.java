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

import net.scao.semanticmapping.core.TextConstructIndexMap;
import net.scao.semanticmapping.linguisticconstuct.CompositeConstruct;
import net.scao.semanticmapping.linguisticconstuct.LinguisticConstruct;

import java.util.ArrayList;
import java.util.List;

public class RewriteRule {
	
	ArrayList<String> needTypes = new ArrayList<>();
	String generatingType = null;
	ConceptUniverseModifier applyingConceptDimensionModifier = new ConceptUniverseModifier();
	
	public RewriteRule(String ... l1){
		generatingType = l1[0];
		for (int i = 1; i < l1.length; i++){
			needTypes.add(l1[i]);
		}
	}
	
	public RewriteRule(List<String> l1){
		for (String e: l1){
			if (e == null) continue;
			if (generatingType == null) generatingType = e;
			else needTypes.add(e);
		}
	}

	public void probe(TextConstructIndexMap treated, int startIndex){
		ArrayList<LinguisticConstruct> toAdd = new ArrayList<>();
		probeDFS(treated, startIndex, 0, new ArrayList(), toAdd);
		for (LinguisticConstruct e: toAdd){
			treated.tokenAdjacencyList[startIndex].add(e);
		}
	}
	private void probeDFS(TextConstructIndexMap treated, int startIndex, int tokenMatched, ArrayList<LinguisticConstruct> stack, ArrayList<LinguisticConstruct> toAdd){
		if (tokenMatched == needTypes.size()){
			CompositeConstruct gen = new CompositeConstruct(treated, generatingType, stack.toArray(new LinguisticConstruct[stack.size()]));
			toAdd.add(gen);
			this.applyingConceptDimensionModifier.expandDimension(gen);
			return;
		}
		if (startIndex >= treated.tokenAdjacencyList.length) return;
		for (LinguisticConstruct e: treated.tokenAdjacencyList[startIndex]){
			if (e.typeId.equals(needTypes.get(tokenMatched))){
				stack.add(e);
				int newPtr = e.size() + startIndex;
				probeDFS(treated, newPtr, tokenMatched + 1, stack, toAdd);
				stack.remove(stack.size() - 1);
			}
		}
	}

	public int hashCode(){
		return needTypes.hashCode() ^ generatingType.hashCode();
	}

	public boolean equals(Object o1){
		if (! (o1 instanceof RewriteRule)) return false;
		RewriteRule test = (RewriteRule) o1;
		if (needTypes.equals(test.needTypes) && generatingType.equals(test.generatingType)) return true;
		return false;
	}

}