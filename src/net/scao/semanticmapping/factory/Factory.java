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
package net.scao.semanticmapping.factory;

import net.scao.semanticmapping.conceptual.ConceptUniverse;
import net.scao.semanticmapping.core.*;
import net.scao.semanticmapping.grammarset.EnglishContextFreeGrammarSet;
import net.scao.semanticmapping.grammarset.EnglishType;
import net.scao.semanticmapping.grammarset.EnglishTypeEnum;
import net.scao.semanticmapping.grammarset.RewriteRule;
import net.scao.semanticmapping.linguisticconstuct.AtomicConstruct;
import net.scao.semanticmapping.linguisticconstuct.LinguisticConstruct;
import net.scao.semanticmapping.support.PrimitiveGenerator;

import java.util.HashSet;
import java.util.Set;

public class Factory {
	public static PrimitiveGenerator basicPartOfSpeechGenerator;
	public static PrimitiveGenerator conceptualPartOfSpeechGenerator;

	public static ConceptUniverse baseDimension;

	private static boolean initialized = false;

	public static void initialize() throws Exception {
		if (initialized)
			return;
		initialized = true;

		baseDimension = new ConceptUniverse();
		String[] baseRelationship = { "AssociatedAction", "AssociatedExistence", "AssociatedQuality", "ActionSource", "ActionTarget" };

		for (String e : baseRelationship) {
			baseDimension.setProperty(e, "IS_Relationship", "TRUE");
		}

		basicPartOfSpeechGenerator = new PrimitiveGenerator() {
			@Override
			public void generate(TextConstructIndexMap map1) {
				try {
					for (int i = 0; i < map1.tokens.size(); i++) {
						String cur = map1.tokens.get(i);
						Set<EnglishTypeEnum> temp = PartOfSpeechMarker.wordsPOS(cur);
						System.out.println(String.format("%-15s", cur) + " : " + String.format("%15s  ", i) + temp);
						for (EnglishTypeEnum f : temp) {
							this.registerAtomicConstruct(map1, f, i);
						}
					}
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}

			private boolean registerAtomicConstruct(TextConstructIndexMap fillingIndexMap, EnglishTypeEnum typeId, int index) {
				if (EnglishType.atoms.contains(typeId)) {
					AtomicConstruct newAtom = new AtomicConstruct(fillingIndexMap, typeId.toString(), index);
					fillingIndexMap.tokenAdjacencyList[index].add(newAtom);
					return true;
				}
				return false;
			}
		};

		conceptualPartOfSpeechGenerator = new PrimitiveGenerator() {
			@Override
			public void generate(TextConstructIndexMap map1) {
				try {
					for (int i = 0; i < map1.tokens.size(); i++) {
						String cur = map1.tokens.get(i);
						Set<EnglishTypeEnum> temp = PartOfSpeechMarker.wordsPOS(cur);
						System.out.println(String.format("%-15s", cur) + " : " + String.format("%15s  ", i) + temp);
						for (EnglishTypeEnum f : temp) {
							this.registerAtomicConstruct(map1, f, i);
						}
					}
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}

			private final String ORIGIN_PROPERTY = "originWord";

			private boolean registerAtomicConstruct(TextConstructIndexMap fillingIndexMap, EnglishTypeEnum typeId, int index) {

				if (EnglishType.atoms.contains(typeId)) {
					AtomicConstruct newAtom = new AtomicConstruct(fillingIndexMap, typeId.toString(), index);
					fillingIndexMap.tokenAdjacencyList[index].add(newAtom);
					newAtom.underlyingDimension = new ConceptUniverse();
					newAtom.focusConcept = newAtom.underlyingDimension.generateNewConceptOfCertainProperty("AtomicConstruct");
					newAtom.underlyingDimension.setProperty(newAtom.focusConcept, "PartOfSpeechLabel", typeId.toString());
					String newAssociated = null;
					if (false) {
						if (typeId.equals(EnglishTypeEnum.NOUN) || typeId.equals(EnglishTypeEnum.PRONOUN) || typeId.equals(EnglishTypeEnum.PROPER_NOUN)
							|| typeId.equals(EnglishTypeEnum.WH_PRONOUN)) {
							newAssociated = newAtom.underlyingDimension.generateNewConceptOfCertainProperty("Existence");
						} else if (typeId.equals(EnglishTypeEnum.VERB)) {
							newAssociated = newAtom.underlyingDimension.generateNewConceptOfCertainProperty("Action");
						} else if (typeId.equals(EnglishTypeEnum.ADJECTIVE) || typeId.equals(EnglishTypeEnum.ADVERB) || typeId.equals(EnglishTypeEnum.ARTICLE)
							|| typeId.equals(EnglishTypeEnum.POSSESSIVE_PRONOUN)) {
							newAssociated = newAtom.underlyingDimension.generateNewConceptOfCertainProperty("Quality");
						} else if (typeId.equals(EnglishTypeEnum.PREPOSITION)) {
							newAssociated = newAtom.underlyingDimension.generateNewConceptOfCertainProperty("Prepositional");
						} else {
							newAssociated = newAtom.underlyingDimension.generateNewConceptOfCertainProperty("Uncatergorized");
						}

					}
					newAssociated = newAtom.underlyingDimension.generateNewConcept("CP_" + fillingIndexMap.tokens.get(index));
					if (newAssociated != null) {
						newAtom.underlyingDimension.addRelation(newAtom.focusConcept, "AssociatedAbstractConcept", newAssociated);
						newAtom.underlyingDimension.setProperty(newAssociated, ORIGIN_PROPERTY, fillingIndexMap.tokens.get(index));
					}

					return true;
				}
				return false;
			}
		};
	}

	public static TextConstructIndexMap analysisSentence(String processingSentence) throws Exception {
		// String normalizedSentence =
		// QuestionNormalizer.normalize(processingSentence);
		String normalizedSentence = processingSentence;
		TextConstructIndexMap t1 = new TextConstructIndexMap(normalizedSentence);
		// System.out.println(normalizedSentence);
		for (int i = 0; i < t1.tokens.size(); i++) {
			String cur = t1.tokens.get(i);
			Set<EnglishTypeEnum> temp = PartOfSpeechMarker.wordsPOS(cur);
			System.out.println(String.format("%-15s", cur) + " : " + String.format("%15s  ", i) + temp);
			for (EnglishTypeEnum f : temp) {
				registerAtomicConstruct(t1, f.toString(), i);
			}
		}

		for (int j = 0; j < 20; j++) {
			for (int i = 0; i < t1.tokenAdjacencyList.length; i++) {
				for (RewriteRule f : EnglishContextFreeGrammarSet.applyingRules) {
					f.probe(t1, i);
				}
			}
		}

		HashSet<LinguisticConstruct> generated = new HashSet();
		for (int i = 0; i < t1.tokenAdjacencyList.length; i++) {
			for (LinguisticConstruct e : t1.tokenAdjacencyList[i]) {
				if (!generated.contains(e)) {

				}

			}
		}

		return t1;
	}

	public static boolean registerAtomicConstruct(TextConstructIndexMap fillingIndexMap, String typeId, int index) {
		if (EnglishType.atoms.contains(typeId)) {
			AtomicConstruct newAtom = new AtomicConstruct(fillingIndexMap, typeId, index);
			// if (typeId == EnglishTypeEnum.NOUN){
			// Existence newFocusExistence = new Existence(newAtom,
			// newAtom.toSimpleString());
			// newAtom.underlyingOntology.existenceSet.add(newFocusExistence);
			// newAtom.underlyingOntology.focusExistences.put(newAtom,
			// newFocusExistence);
			// }
			// else if (typeId == EnglishTypeEnum.PROPER_NOUN){
			// Existence newFocusExistence = new Existence(newAtom,
			// newAtom.toSimpleString());
			// newAtom.underlyingOntology.existenceSet.add(newFocusExistence);
			// newAtom.underlyingOntology.focusExistences.put(newAtom,
			// newFocusExistence);
			// }
			// else if (typeId == EnglishTypeEnum.PRONOUN){
			// Existence newFocusExistence = new Existence(newAtom);
			// newAtom.underlyingOntology.existenceSet.add(newFocusExistence);
			// newAtom.underlyingOntology.focusExistences.put(newAtom,
			// newFocusExistence);
			// }
			// else if (typeId == EnglishTypeEnum.ADJECTIVE){
			// Quality newFocusExistenceQuality = new Quality(newAtom);
			// newAtom.focusQuality = newFocusExistenceQuality;
			// newAtom.underlyingOntology.qualitySet.add(newFocusExistenceQuality);
			// newAtom.underlyingOntology.focusQualities.put(newAtom,
			// newFocusExistenceQuality);
			// }
			// else if (typeId == EnglishTypeEnum.ADVERB){
			// Quality newFocusExistenceQuality = new Quality(newAtom);
			// newAtom.focusQuality = newFocusExistenceQuality;
			// newAtom.underlyingOntology.qualitySet.add(newFocusExistenceQuality);
			// newAtom.underlyingOntology.focusQualities.put(newAtom,
			// newFocusExistenceQuality);
			// }
			// else if (typeId == EnglishTypeEnum.VERB){
			// ActionProcess newFocusActionProcess = new ActionProcess(newAtom);
			// newAtom.focusActionProcess = newFocusActionProcess;
			// newAtom.underlyingOntology.actionProcessSet.add(newFocusActionProcess);
			// newAtom.underlyingOntology.focusActions.put(newAtom,
			// newFocusActionProcess);
			// }
			// else if (typeId == EnglishTypeEnum.WH_PRONOUN){
			// Existence newFocusExistence = new Existence(newAtom,
			// newAtom.toSimpleString());
			// newAtom.underlyingOntology.existenceSet.add(newFocusExistence);
			// newAtom.underlyingOntology.interrogativeTarget.add(newFocusExistence);
			// newAtom.underlyingOntology.focusExistences.put(newAtom,
			// newFocusExistence);
			// }
			fillingIndexMap.tokenAdjacencyList[index].add(newAtom);
			return true;
		}
		return false;
	}
}
