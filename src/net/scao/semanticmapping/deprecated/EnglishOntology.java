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
package net.scao.semanticmapping.deprecated;

import net.scao.semanticmapping.grammarset.RewriteRule;
import net.scao.semanticmapping.linguisticconstuct.LinguisticConstruct;
import net.scao.semanticmapping.util.MultiHashMap;

import java.util.HashMap;
import java.util.HashSet;

public class EnglishOntology {
	public static HashMap<RewriteRule, EnglishOntology> ruleOntologyMap = new HashMap();
	public static HashMap<RewriteRule, OntologyExtender> ruleExtenderMap = new HashMap();

	public static void registerOntologyExtender(RewriteRule r1, OntologyExtender o1){
		ruleExtenderMap.put(r1, o1);
	}


	// all coneptual objects should be registered on instantiation
	public HashSet<Existence> existenceSet = new HashSet<>();
	public MultiHashMap<Existence, Quality> existenceQualities = new MultiHashMap<>();
	public MultiHashMap<Existence, ActionProcess> committedActions = new MultiHashMap<>();

	public HashMap<LinguisticConstruct, Existence> focusExistences = new HashMap<>();
	public HashMap<LinguisticConstruct, ActionProcess> focusActions = new HashMap<>();
	public HashMap<LinguisticConstruct, Quality> focusQualities = new HashMap<>();



	public HashSet<ActionProcess> actionProcessSet = new HashSet<>();
	public MultiHashMap<ActionProcess, Existence> actionSources = new MultiHashMap<>();
	public MultiHashMap<ActionProcess, Existence> actionTarget = new MultiHashMap<>();
	public MultiHashMap<ActionProcess, Existence> actionInvolved = new MultiHashMap<>();
	public MultiHashMap<ActionProcess, Quality> actionQualities = new MultiHashMap<>();
	
	public HashSet<Existence> interrogativeTarget = new HashSet<>();
	
	public HashSet<Quality> qualitySet = new HashSet<>();
	public MultiHashMap<Quality, Quality> qualityQualities = new MultiHashMap<>();

	
	public void absorb(EnglishOntology absorbing){

		focusExistences.putAll(absorbing.focusExistences);
		focusActions.putAll(absorbing.focusActions);
		focusQualities.putAll(absorbing.focusQualities);

		existenceSet.addAll(absorbing.existenceSet);
		actionProcessSet.addAll(absorbing.actionProcessSet);
		qualitySet.addAll(absorbing.qualitySet);
		interrogativeTarget.addAll(absorbing.interrogativeTarget);	
		
		existenceQualities.absorb(absorbing.existenceQualities);
		committedActions.absorb(absorbing.committedActions);
		
		actionSources.absorb(absorbing.actionSources);
		actionTarget.absorb(absorbing.actionTarget);
		actionInvolved.absorb(absorbing.actionInvolved);
		actionQualities.absorb(absorbing.actionQualities);
		
		qualityQualities.absorb(absorbing.qualityQualities);
		

	}

	public static class Existence {

//		public static int UNKNOWN = -123;
		
		public LinguisticConstruct originatingToken;
		public String typeName;
//		public HashSet<Quality> possessingQualities = new HashSet<>();
		
		public Existence (LinguisticConstruct origin){
			originatingToken = origin;
		}
		
		public Existence (LinguisticConstruct origin, String newTypeName){
			originatingToken = origin;
			typeName = newTypeName;
		}
		
		public int hashCode (){
			return originatingToken.hashCode();
		}
		public boolean equals(Object o1){
			if (!(o1 instanceof Existence)) return false;
			Existence testing = (Existence) o1;
			if (!this.originatingToken.equals(testing.originatingToken)){
				return false;
			}
			if (! this.typeName.equals(testing.typeName)){
				return false;
			}
			return true;
		}
		public void print(){
			System.out.println("EXISTENCE");
			System.out.println("Originating Token: "+originatingToken);
			System.out.println("Type: "+typeName);
		}
		public String toString(){
			return originatingToken.toSimpleString();
		}
	}

	
	public static class Quality {
		public String objectQualityName;
		public LinguisticConstruct originatingToken;
		
		public Quality(LinguisticConstruct origin) {
			originatingToken = origin;
			objectQualityName = originatingToken.toSimpleString();
		}
		
		public int hashCode(){
			return objectQualityName.hashCode();
		}
		public boolean equals(Object o1){
			if (!(o1 instanceof Quality)){
				return false;
			}
			Quality testing = (Quality)o1;
			if (!testing.objectQualityName.equals(this.objectQualityName)){
				return false;
			}
			return true;
		}
		public void print(){
			System.out.println("QUALITY");
			System.out.println("originating token: "+objectQualityName);
			System.out.println(objectQualityName);
		}
	}
	
//	public static class ActionQuality {
//		public String actionQualityName;
//		public int hashCode(){
//			return actionQualityName.hashCode();
//		}
//		public boolean equals(Object o1){
//			if (!(o1 instanceof ActionQuality)){
//				return false;
//			}
//			ActionQuality testing = (ActionQuality)o1;
//			if (!testing.actionQualityName.equals(this.actionQualityName)){
//				return false;
//			}
//			return true;
//		}
//		
//		public void print(){
//			System.out.println("ACTION QUALITY");
//			System.out.println(actionQualityName);
//		}
//	}
	
	public static class ActionProcess {
		public LinguisticConstruct originatingToken;
		public ActionProcess(LinguisticConstruct newOrigin){
			originatingToken = newOrigin;
		}
		public int hashCode(){
			return originatingToken.hashCode();
		}
		public boolean equals(Object o1){
			if (!(o1 instanceof ActionProcess)) return false;
			ActionProcess cur = (ActionProcess) o1;
			return originatingToken.equals(cur.originatingToken);
		}
		public String toString(){
			return "AV: "+originatingToken.toString();
		}
	}
}
