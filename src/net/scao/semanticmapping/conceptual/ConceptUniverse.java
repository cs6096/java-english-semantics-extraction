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
package net.scao.semanticmapping.conceptual;

import net.scao.semanticmapping.util.MultiHashMap;

import org.shengcao.units.*;

import java.util.*;

/**
 * Container class for containing and managing "concepts" (as well as their
 *  interelations).
 *  
 * @author Sheng Cao
 */
public class ConceptUniverse {
	public HashSet<String> concepts = new HashSet<>();
	public HashMap<String, HashMap<String, String>> propertyMap = new HashMap<>();
	// source : relation + target
	// <source, <relation,set<target>>>
	public HashMap<String, HashMap<String, HashSet<String>>> relationMap = new HashMap<>();
	
	private static int generatorIndex = 0;
	
	public String generateNewConcept(String specificPrefix){
		String newConceptName = specificPrefix +"_"+(generatorIndex++);
		concepts.add(newConceptName);
		return newConceptName;
	}
	
	public String generateNewConceptOfCertainProperty(String specificProperty){
		String newConceptName = specificProperty +"_"+(generatorIndex++);
		concepts.add(newConceptName);
		setProperty(newConceptName, "IS_"+specificProperty, "TRUE");
		return newConceptName;
	}
	
	

	public void ensureConceptExist(String s1){
		if (!this.concepts.contains(s1)) concepts.add(s1);
		if (!propertyMap.containsKey(s1)) propertyMap.put(s1, new HashMap());
		if (!relationMap.containsKey(s1)) relationMap.put(s1, new HashMap());
	}

	public void setProperty(String concept, String property, String value){
		ensureConceptExist(concept);
		propertyMap.get(concept).put(property, value);
	}
	public String getProperty(String concept, String property){
		if (!concepts.contains(concept)) return null;
		return propertyMap.get(concept).get(property);
	}
	public void addRelation(String source, String relation, String target){
		ensureConceptExist(source);
		ensureRelationExist(relation);
		ensureConceptExist(target);
		HashMap<String, HashSet<String>> currentAdjacencySet = relationMap.get(source);
		if (!currentAdjacencySet.containsKey(relation))  currentAdjacencySet.put(relation, new HashSet());
		currentAdjacencySet.get(relation).add(target);
	}
	
	public ArrayList<String> getConceptsRelationTargets(String queryConcept, String queryRelation){
		ArrayList<String> fin = new ArrayList<>();
		if (concepts.contains(queryConcept)){
//			System.out.println(queryRelation);
//			System.out.println(relationMap.get(queryConcept));
			HashSet<String> addingTargets = relationMap.get(queryConcept).get(queryRelation);
//			System.out.println(addingTargets);
			
//			if (addingTargets != null)
			
			
			{
				try {
					fin.addAll(addingTargets);
				}
				catch (Exception e){
					System.err.println(queryConcept + " " + queryRelation);
				}
				
			}
		}
		return fin;
	}
	
	public ConceptUniverse deepCopy(){
		ConceptUniverse fin = new ConceptUniverse();
		fin.absorbOtherDimension(this);
		return fin;
	}
	
	public void ensureRelationExist(String relationName){
		if (!this.concepts.contains(relationName)) this.setProperty(relationName, "IS_Relationship", "TRUE");
		
	}
	
	public void absorbOtherDimension(ConceptUniverse absorbing){
		// inherit concepts and their property
		for (String addingConcept: absorbing.concepts){
			ensureConceptExist(addingConcept);
			HashMap<String, String> ourHashMap = propertyMap.get(addingConcept);
			
			HashMap<String, String> theirHashMap = absorbing.propertyMap.get(addingConcept);
			if (theirHashMap != null){
				for (String f: theirHashMap.keySet() ){
					ourHashMap.put(f, theirHashMap.get(f));
				}
			}
		}
		
		for (String absorbingSource: absorbing.relationMap.keySet() ){
			if (!this.relationMap.containsKey(absorbingSource)) this.relationMap.put(absorbingSource, new HashMap());
			HashMap<String, HashSet<String>> currentAdjacencySet = this.relationMap.get(absorbingSource);
			HashMap<String, HashSet<String>> currentAbsorbingAdjacencySet = absorbing.relationMap.get(absorbingSource);
			for (String absorbingRelation : currentAbsorbingAdjacencySet.keySet()){
				currentAdjacencySet.put(absorbingRelation, (HashSet<String>) currentAbsorbingAdjacencySet.get(absorbingRelation).clone());
			}
		}
	}



	public String convertedConceptString(String concept){
		if (!concepts.contains(concept)){
			return null;
		}
		StringBuilder fin = new StringBuilder();
		fin.append("{");
		fin.append(concept);
		fin.append(":");
		if (propertyMap.containsKey(concept)){
			HashMap<String, String> curPropertyMap = propertyMap.get(concept);
			for (String e: curPropertyMap.keySet()){
				fin.append("<"+e+":"+curPropertyMap.get(e)+">");
			}
		}
		if (relationMap.containsKey(concept)){
			HashMap<String, HashSet<String>> curPropertyMap = relationMap.get(concept);
			for (String relation: curPropertyMap.keySet()){
				for (String target : curPropertyMap.get(relation)){
					fin.append("["+relation+":"+target+"]");
				}
			}
		}
		fin.append("}");

		return fin.toString();
	}

	public static void parseConcept(String conceptString){
		char[] l1 = conceptString.toCharArray();
		int ptr = 0;
		for (;ptr < l1.length;){
			if (l1[ptr] == '{'){
				ptr++;
				StringBuilder conceptName = new StringBuilder();
				for (;;){
					if (l1[ptr] == ':'){
						ptr++;
						break;
					}
					conceptName.append(l1[ptr++]);
				}
				System.out.println("Concept Name: "+conceptName);
			}
			else if (l1[ptr] == '<'){
				ptr++;
				StringBuilder propertyName = new StringBuilder();
				for (;;){
					if (l1[ptr] == ':'){
						ptr++;
						break;
					}
					propertyName.append(l1[ptr++]);
				}
				StringBuilder propertyContent = new StringBuilder();
				for (;;){
					if (l1[ptr] == '>'){
						ptr++;
						break;
					}
					propertyContent.append(l1[ptr++]);
				}
				System.out.println("Property Name: "+propertyName+"\n   Property Content: "+propertyContent);
			}
			else if (l1[ptr] == '['){
				ptr++;
				StringBuilder relationConcept = new StringBuilder();
				for (;;){
					if (l1[ptr] == ':'){
						ptr++;
						break;
					}
					relationConcept.append(l1[ptr++]);
				}
				StringBuilder relationTarget = new StringBuilder();
				for (;;){
					if (l1[ptr] == ']'){
						ptr++;
						break;
					}
					relationTarget.append(l1[ptr++]);
				}
				System.out.println("Relation Name: "+relationConcept+"\n   Relation Target: "+relationTarget);
			}
			else {
				ptr++;
			}
		}
	}
}

