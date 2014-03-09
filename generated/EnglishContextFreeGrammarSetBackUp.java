package net.shengcao.semanticmapping.core;
import java.util.ArrayList;
public class EnglishContextFreeGrammarSet {
	public static ArrayList<RewriteRule> applyingRules=new ArrayList<>();
	static {
		RewriteRule declarativeClauseGen1=new RewriteRule(2,EnglishTypeEnum.SUBJECT,EnglishTypeEnum.PREDICATE,EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE);
		applyingRules.add(declarativeClauseGen1);
		RewriteRule declarativeClauseGen2=new RewriteRule(2,EnglishTypeEnum.SUBJECT,EnglishTypeEnum.TO_BE_CLAUSE,EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE);
		applyingRules.add(declarativeClauseGen2);
		RewriteRule toBeRule=new RewriteRule(2,EnglishTypeEnum.TO_BE_VERB,EnglishTypeEnum.ADJECTIVE_PHRASE,EnglishTypeEnum.TO_BE_CLAUSE);
		applyingRules.add(toBeRule);
		RewriteRule pronounSubjectConversion=new RewriteRule(1,EnglishTypeEnum.PRONOUN,EnglishTypeEnum.SUBJECT);
		applyingRules.add(pronounSubjectConversion);
		RewriteRule finalNounPhrase=new RewriteRule(1,EnglishTypeEnum.FINAL_NOUN_PHRASE,EnglishTypeEnum.SUBJECT);
		RewriteRule finalVerbPhrasePredicateConversion=new RewriteRule(1,EnglishTypeEnum.FINAL_VERB_PHRASE,EnglishTypeEnum.PREDICATE);
		applyingRules.add(finalVerbPhrasePredicateConversion);
		RewriteRule verbVerbPhraseConversion=new RewriteRule(1,EnglishTypeEnum.VERB,EnglishTypeEnum.VERB_PHRASE);
		applyingRules.add(verbVerbPhraseConversion);
		RewriteRule verbNounPhraseRule=new RewriteRule(2,EnglishTypeEnum.VERB,EnglishTypeEnum.FINAL_NOUN_PHRASE,EnglishTypeEnum.VERB_PHRASE);
		applyingRules.add(verbNounPhraseRule);
		RewriteRule primaryVerbPhraseGenerationRule3=new RewriteRule(3,EnglishTypeEnum.VERB,EnglishTypeEnum.FINAL_NOUN_PHRASE,EnglishTypeEnum.FINAL_NOUN_PHRASE,EnglishTypeEnum.VERB_PHRASE);
		applyingRules.add(primaryVerbPhraseGenerationRule3);
		RewriteRule verbPhraseFinalVerbPhraseConvertion=new RewriteRule(1,EnglishTypeEnum.VERB_PHRASE,EnglishTypeEnum.FINAL_VERB_PHRASE);
		applyingRules.add(verbPhraseFinalVerbPhraseConvertion);
		RewriteRule adverbModifiedFinalVerbPhrase=new RewriteRule(2,EnglishTypeEnum.VERB_PHRASE,EnglishTypeEnum.ADVERB,EnglishTypeEnum.FINAL_VERB_PHRASE);
		applyingRules.add(adverbModifiedFinalVerbPhrase);
		RewriteRule verbPhraseAugmentingPrepositionalPhrase1=new RewriteRule(2,EnglishTypeEnum.VERB_PHRASE,EnglishTypeEnum.PREPOSITIONAL_PHRASE,EnglishTypeEnum.VERB_PHRASE);
		applyingRules.add(verbPhraseAugmentingPrepositionalPhrase1);
		RewriteRule verbPhraseAugmentingPrepositionalPhrase2=new RewriteRule(2,EnglishTypeEnum.FINAL_VERB_PHRASE,EnglishTypeEnum.PREPOSITIONAL_PHRASE,EnglishTypeEnum.FINAL_VERB_PHRASE);
		applyingRules.add(verbPhraseAugmentingPrepositionalPhrase2);
		RewriteRule adjectiveAdjectivePhraseConversion=new RewriteRule(1,EnglishTypeEnum.ADJECTIVE,EnglishTypeEnum.ADJECTIVE_PHRASE);
		applyingRules.add(adjectiveAdjectivePhraseConversion);
		RewriteRule adverbAdjectiveFusion=new RewriteRule(2,EnglishTypeEnum.ADVERB,EnglishTypeEnum.ADJECTIVE,EnglishTypeEnum.ADJECTIVE_PHRASE);
		applyingRules.add(adverbAdjectiveFusion);
		RewriteRule prepositionFinalNounPhraseFusion=new RewriteRule(2,EnglishTypeEnum.PREPOSITION,EnglishTypeEnum.FINAL_NOUN_PHRASE,EnglishTypeEnum.PREPOSITIONAL_PHRASE);
		applyingRules.add(prepositionFinalNounPhraseFusion);
		RewriteRule pronounNounConversion=new RewriteRule(1,EnglishTypeEnum.PRONOUN,EnglishTypeEnum.NOUN);
		applyingRules.add(pronounNounConversion);
		RewriteRule properNounNounConversion=new RewriteRule(1,EnglishTypeEnum.PROPER_NOUN,EnglishTypeEnum.NOUN);
		applyingRules.add(properNounNounConversion);
		RewriteRule properNounFusion=new RewriteRule(2,EnglishTypeEnum.PROPER_NOUN,EnglishTypeEnum.PROPER_NOUN,EnglishTypeEnum.PROPER_NOUN);
		applyingRules.add(properNounFusion);
		RewriteRule nounNounPhraseFusion=new RewriteRule(1,EnglishTypeEnum.NOUN,EnglishTypeEnum.NOUN_PHRASE);
		applyingRules.add(nounNounPhraseFusion);
		RewriteRule adjectiveNounFusion=new RewriteRule(2,EnglishTypeEnum.ADJECTIVE_PHRASE,EnglishTypeEnum.NOUN,EnglishTypeEnum.NOUN_PHRASE);
		applyingRules.add(adjectiveNounFusion);
		RewriteRule nounPhraseFinalNounPhraseConversion=new RewriteRule(1,EnglishTypeEnum.NOUN_PHRASE,EnglishTypeEnum.FINAL_NOUN_PHRASE);
		applyingRules.add(nounPhraseFinalNounPhraseConversion);
		RewriteRule articleNounPhraseRule=new RewriteRule(2,EnglishTypeEnum.ARTICLE,EnglishTypeEnum.NOUN_PHRASE,EnglishTypeEnum.FINAL_NOUN_PHRASE);
		applyingRules.add(articleNounPhraseRule);
		RewriteRule determinerNounPhraseRule=new RewriteRule(2,EnglishTypeEnum.DETERMINER,EnglishTypeEnum.NOUN_PHRASE,EnglishTypeEnum.FINAL_NOUN_PHRASE);
		applyingRules.add(determinerNounPhraseRule);
		RewriteRule finalNounPhrasePrepositionalPhraseRule=new RewriteRule(2,EnglishTypeEnum.FINAL_NOUN_PHRASE,EnglishTypeEnum.PREPOSITIONAL_PHRASE,EnglishTypeEnum.FINAL_NOUN_PHRASE);
		applyingRules.add(finalNounPhrasePrepositionalPhraseRule);
		RewriteRule interrogativeClauseGeneration1=new RewriteRule(2,EnglishTypeEnum.WH_PRONOUN,EnglishTypeEnum.PREDICATE,EnglishTypeEnum.INTERROGATIVE_CLAUSE);
		applyingRules.add(interrogativeClauseGeneration1);
		RewriteRule interrogativeClauseGeneration2=new RewriteRule(2,EnglishTypeEnum.WH_PRONOUN,EnglishTypeEnum.TO_BE_CLAUSE,EnglishTypeEnum.INTERROGATIVE_CLAUSE);
		applyingRules.add(interrogativeClauseGeneration2);
		RewriteRule whPronounSimpleDeclarativeClauseFusion=new RewriteRule(2,EnglishTypeEnum.WH_PRONOUN,EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE,EnglishTypeEnum.DEPENDENT_CLAUSE);
		applyingRules.add(whPronounSimpleDeclarativeClauseFusion);
	}
}




//package net.shengcao.semanticmapping.core;
//
//import net.shengcao.semanticmapping.deprecated.EnglishOntology.Existence;
//
//import java.util.ArrayList;
//
//public class EnglishContextFreeGrammarSet {
//
//	public static ArrayList<RewriteRule> applyingRules = new ArrayList<>();
//
//	static {
//		// TODO add support for various sentence types
//		// IE: declarative, interrogative, imperative, exclamative
//		// TODO add support for gerunds
//
//		RewriteRule declarativeClauseGen1 = new RewriteRule(2, EnglishTypeEnum.SUBJECT, EnglishTypeEnum.PREDICATE, EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE);
//		EnglishOntology.registerOntologyExtender(declarativeClauseGen1, new OntologyExtender() {
//			@Override
//			public void extendCompositeLogicInstance(
//					CompositeConstruct newlyGeneratedConstruct) {
//				LinguisticConstruct subjectToken = newlyGeneratedConstruct.constituentConstructs.get(0);
//				Existence subjectExistence = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(subjectToken);
//				LinguisticConstruct predicateToken = newlyGeneratedConstruct.constituentConstructs.get(1);
//				EnglishOntology.ActionProcess predicateAction = predicateToken.focusActionProcess;
//				newlyGeneratedConstruct.underlyingOntology.committedActions.add(subjectExistence, predicateAction);
//				newlyGeneratedConstruct.underlyingOntology.actionSources.add(predicateAction, subjectExistence);
//			}
//		});
//		applyingRules.add(declarativeClauseGen1);
//
//		RewriteRule declarativeClauseGen2 = new RewriteRule(2, EnglishTypeEnum.SUBJECT, EnglishTypeEnum.TO_BE_CLAUSE, EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE);
//
//		EnglishOntology.registerOntologyExtender(declarativeClauseGen2, new OntologyExtender() {
//			@Override
//			public void extendCompositeLogicInstance(
//					CompositeConstruct newlyGeneratedConstruct) {
//				LinguisticConstruct subjectToken = newlyGeneratedConstruct.constituentConstructs.get(0);
//				Existence subjectExistence = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(subjectToken);
//				LinguisticConstruct predicateToken = newlyGeneratedConstruct.constituentConstructs.get(1);
//
//				newlyGeneratedConstruct.underlyingOntology.committedActions.add(subjectExistence, predicateToken.focusActionProcess);
//				newlyGeneratedConstruct.underlyingOntology.actionSources.add(predicateToken.focusActionProcess, subjectExistence);
//			}
//		});
//		applyingRules.add(declarativeClauseGen2);
//
//
//		RewriteRule toBeRule = new RewriteRule(2, EnglishTypeEnum.TO_BE_VERB, EnglishTypeEnum.ADJECTIVE_PHRASE, EnglishTypeEnum.TO_BE_CLAUSE);
//		applyingRules.add(toBeRule);
//
//		RewriteRule pronounSubjectConversion = new RewriteRule(1, EnglishTypeEnum.PRONOUN, EnglishTypeEnum.SUBJECT);
//		applyingRules.add(pronounSubjectConversion);
//		EnglishOntology.registerOntologyExtender(pronounSubjectConversion, new OntologyExtender() {
//			@Override
//			public void extendCompositeLogicInstance(
//					CompositeConstruct newlyGeneratedConstruct) {
//				LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//				Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//				newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//			}
//		});
//
//		RewriteRule finalNounPhrase = new RewriteRule(1, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.SUBJECT);
//		EnglishOntology.registerOntologyExtender(finalNounPhrase,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				});
//
//		RewriteRule finalVerbPhrasePredicateConversion = new RewriteRule(1, EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.PREDICATE);
//		EnglishOntology.registerOntologyExtender(finalVerbPhrasePredicateConversion,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//					}
//				}
//
//				);
//		applyingRules.add(finalVerbPhrasePredicateConversion);
//
//		RewriteRule verbVerbPhraseConversion = new RewriteRule(1, EnglishTypeEnum.VERB, EnglishTypeEnum.VERB_PHRASE);
//
//		EnglishOntology.registerOntologyExtender(verbVerbPhraseConversion,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//					}
//				}
//		);
//
//		applyingRules.add(verbVerbPhraseConversion);
//
//
//		RewriteRule verbNounPhraseRule = new RewriteRule(2, EnglishTypeEnum.VERB, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.VERB_PHRASE);
//		EnglishOntology.registerOntologyExtender(verbNounPhraseRule,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//						newlyGeneratedConstruct.underlyingOntology.actionTarget.add(
//								newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess,
//								newlyGeneratedConstruct.underlyingOntology.focusExistences.get(newlyGeneratedConstruct.constituentConstructs.get(1))
//						);
//					}
//				}
//				);
//		applyingRules.add(verbNounPhraseRule);
//
//
//		RewriteRule primaryVerbPhraseGenerationRule3 = new RewriteRule(3, EnglishTypeEnum.VERB, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.VERB_PHRASE);
//
//		EnglishOntology.registerOntologyExtender(
//				primaryVerbPhraseGenerationRule3,
//
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//						newlyGeneratedConstruct.underlyingOntology.actionTarget.add(
//								newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess,
//								newlyGeneratedConstruct.underlyingOntology.focusExistences.get(newlyGeneratedConstruct.constituentConstructs.get(1))
//						);
//						newlyGeneratedConstruct.underlyingOntology.actionInvolved.add(
//								newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess,
//								newlyGeneratedConstruct.underlyingOntology.focusExistences.get(newlyGeneratedConstruct.constituentConstructs.get(2))
//						);
//					}
//				}
//
//
//		);
//		applyingRules.add(primaryVerbPhraseGenerationRule3);
//
//
//		RewriteRule verbPhraseFinalVerbPhraseConvertion = new RewriteRule(1, EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.FINAL_VERB_PHRASE);
//		EnglishOntology.registerOntologyExtender(
//				verbPhraseFinalVerbPhraseConvertion,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//					}
//				}
//
//
//		);
//		applyingRules.add(verbPhraseFinalVerbPhraseConvertion);
//
//
//		RewriteRule adverbModifiedFinalVerbPhrase = new RewriteRule(2, EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.ADVERB, EnglishTypeEnum.FINAL_VERB_PHRASE);
//
//
//		EnglishOntology.registerOntologyExtender(
//				adverbModifiedFinalVerbPhrase,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct verbPhraseToken = newlyGeneratedConstruct.constituentConstructs.get(0);
//						LinguisticConstruct adverbToken = newlyGeneratedConstruct.constituentConstructs.get(1);
//						newlyGeneratedConstruct.underlyingOntology.actionQualities.add(verbPhraseToken.focusActionProcess, adverbToken.focusQuality);
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//					}
//				}
//		);
//		applyingRules.add(adverbModifiedFinalVerbPhrase);
//
//
//		RewriteRule verbPhraseAugmentingPrepositionalPhrase1 = new RewriteRule(2, EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.PREPOSITIONAL_PHRASE, EnglishTypeEnum.VERB_PHRASE);
//
//
//		EnglishOntology.registerOntologyExtender(
//				verbPhraseAugmentingPrepositionalPhrase1,
//
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//
//						// TODO after implementing the prepositional qualities need to add corresponding code here
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//					}
//				}
//
//
//		);
//		applyingRules.add(verbPhraseAugmentingPrepositionalPhrase1);
//
//
//		RewriteRule verbPhraseAugmentingPrepositionalPhrase2 = new RewriteRule(2, EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.PREPOSITIONAL_PHRASE, EnglishTypeEnum.FINAL_VERB_PHRASE);
//		EnglishOntology.registerOntologyExtender(verbPhraseAugmentingPrepositionalPhrase2,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						newlyGeneratedConstruct.focusActionProcess = newlyGeneratedConstruct.constituentConstructs.get(0).focusActionProcess;
//					}
//				}
//				);
//
//		applyingRules.add(verbPhraseAugmentingPrepositionalPhrase2);
//
//		RewriteRule adjectiveAdjectivePhraseConversion = new RewriteRule(1, EnglishTypeEnum.ADJECTIVE, EnglishTypeEnum.ADJECTIVE_PHRASE);
//
//		EnglishOntology.registerOntologyExtender(adjectiveAdjectivePhraseConversion,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct adjPart = newlyGeneratedConstruct.constituentConstructs.get(0);
//						newlyGeneratedConstruct.focusQuality = adjPart.focusQuality;
//					}
//				}
//
//				);
//
//		applyingRules.add(adjectiveAdjectivePhraseConversion);
//
//
//		RewriteRule adverbAdjectiveFusion = new RewriteRule(2, EnglishTypeEnum.ADVERB, EnglishTypeEnum.ADJECTIVE, EnglishTypeEnum.ADJECTIVE_PHRASE);
//		EnglishOntology.registerOntologyExtender(
//				adverbAdjectiveFusion,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct advPart = newlyGeneratedConstruct.constituentConstructs.get(0);
//						LinguisticConstruct adjPart = newlyGeneratedConstruct.constituentConstructs.get(1);
////						adjPart.focusQuality.possessingQualities.add(advPart.focusQuality);
//						newlyGeneratedConstruct.underlyingOntology.qualityQualities.add(adjPart.focusQuality, advPart.focusQuality);
//						newlyGeneratedConstruct.focusQuality = adjPart.focusQuality;
//					}
//				}
//		);
//		applyingRules.add(adverbAdjectiveFusion);
//
//		RewriteRule prepositionFinalNounPhraseFusion = new RewriteRule(2, EnglishTypeEnum.PREPOSITION, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.PREPOSITIONAL_PHRASE);
//		applyingRules.add(prepositionFinalNounPhraseFusion);
//
//
//		RewriteRule pronounNounConversion = new RewriteRule(1, EnglishTypeEnum.PRONOUN, EnglishTypeEnum.NOUN);
//		EnglishOntology.registerOntologyExtender(pronounNounConversion,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				}
//				);
//		applyingRules.add(pronounNounConversion);
//
//		RewriteRule properNounNounConversion = new RewriteRule(1, EnglishTypeEnum.PROPER_NOUN, EnglishTypeEnum.NOUN);
//		EnglishOntology.registerOntologyExtender(
//				properNounNounConversion,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				}
//
//		);
//		applyingRules.add(properNounNounConversion);
//
//		RewriteRule properNounFusion = new RewriteRule(2, EnglishTypeEnum.PROPER_NOUN, EnglishTypeEnum.PROPER_NOUN, EnglishTypeEnum.PROPER_NOUN);
//
//		EnglishOntology.registerOntologyExtender(
//				properNounFusion,
//
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						Existence newCombinedProperNounExistence = new Existence(newlyGeneratedConstruct);
//						newlyGeneratedConstruct.underlyingOntology.existenceSet.add(newCombinedProperNounExistence);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, newCombinedProperNounExistence);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.remove(newlyGeneratedConstruct.constituentConstructs.get(0));
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.remove(newlyGeneratedConstruct.constituentConstructs.get(1));
//					}
//				}
//
//		);
//
//		applyingRules.add(properNounFusion);
//
//
//		RewriteRule nounNounPhraseFusion = new RewriteRule(1, EnglishTypeEnum.NOUN, EnglishTypeEnum.NOUN_PHRASE);
//		EnglishOntology.registerOntologyExtender(
//				nounNounPhraseFusion,
//		new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				}
//
//		);
//		applyingRules.add(nounNounPhraseFusion);
//
//
//		RewriteRule adjectiveNounFusion = new RewriteRule(2, EnglishTypeEnum.ADJECTIVE_PHRASE, EnglishTypeEnum.NOUN, EnglishTypeEnum.NOUN_PHRASE);
//
//
//		EnglishOntology.registerOntologyExtender(
//				adjectiveNounFusion,
//
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct adjectivePart = newlyGeneratedConstruct.constituentConstructs.get(0);
//						LinguisticConstruct nounPart = newlyGeneratedConstruct.constituentConstructs.get(1);
//						Existence nounFocusExistence = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(nounPart);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, nounFocusExistence);
//						newlyGeneratedConstruct.underlyingOntology.existenceQualities.add(nounFocusExistence, adjectivePart.focusQuality);
//					}
//				}
//
//		);
//		applyingRules.add(adjectiveNounFusion);
//
//
//		RewriteRule nounPhraseFinalNounPhraseConversion = new RewriteRule(1, EnglishTypeEnum.NOUN_PHRASE, EnglishTypeEnum.FINAL_NOUN_PHRASE);
//		EnglishOntology.registerOntologyExtender(
//				nounPhraseFinalNounPhraseConversion,
//
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				}
//		);
//		applyingRules.add(nounPhraseFinalNounPhraseConversion);
//
//		RewriteRule articleNounPhraseRule = new RewriteRule(2, EnglishTypeEnum.ARTICLE, EnglishTypeEnum.NOUN_PHRASE, EnglishTypeEnum.FINAL_NOUN_PHRASE);
//
//		EnglishOntology.registerOntologyExtender(
//
//				articleNounPhraseRule,
//
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(1);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				}
//		);
//
//		applyingRules.add(articleNounPhraseRule);
//
//
//		RewriteRule determinerNounPhraseRule = new RewriteRule(2, EnglishTypeEnum.DETERMINER, EnglishTypeEnum.NOUN_PHRASE, EnglishTypeEnum.FINAL_NOUN_PHRASE);
//		EnglishOntology.registerOntologyExtender(determinerNounPhraseRule,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(1);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				}
//
//				);
//		applyingRules.add(determinerNounPhraseRule);
//
//		RewriteRule finalNounPhrasePrepositionalPhraseRule = new RewriteRule(2, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.PREPOSITIONAL_PHRASE, EnglishTypeEnum.FINAL_NOUN_PHRASE);
//
//
//		EnglishOntology.registerOntologyExtender(
//				finalNounPhrasePrepositionalPhraseRule,
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//						Existence e1 = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						newlyGeneratedConstruct.underlyingOntology.focusExistences.put(newlyGeneratedConstruct, e1);
//					}
//				}
//		);
//		applyingRules.add(finalNounPhrasePrepositionalPhraseRule);
//
//
//		RewriteRule interrogativeClauseGeneration1 = new RewriteRule(2, EnglishTypeEnum.WH_PRONOUN, EnglishTypeEnum.PREDICATE, EnglishTypeEnum.INTERROGATIVE_CLAUSE);
//		EnglishOntology.registerOntologyExtender(
//				interrogativeClauseGeneration1,
//
//				new OntologyExtender() {
//					@Override
//					public void extendCompositeLogicInstance(
//							CompositeConstruct newlyGeneratedConstruct) {
//						LinguisticConstruct lc1 = newlyGeneratedConstruct.constituentConstructs.get(0);
//						Existence whPronounToken = newlyGeneratedConstruct.underlyingOntology.focusExistences.get(lc1);
//						EnglishOntology.ActionProcess predicateToken = newlyGeneratedConstruct.constituentConstructs.get(1).focusActionProcess;
//						newlyGeneratedConstruct.underlyingOntology.committedActions.add(whPronounToken, predicateToken);
//						newlyGeneratedConstruct.underlyingOntology.actionSources.add(predicateToken, whPronounToken);
//					}
//				}
//
//
//		);
//		applyingRules.add(interrogativeClauseGeneration1);
//
//
//		RewriteRule interrogativeClauseGeneration2 = new RewriteRule(2, EnglishTypeEnum.WH_PRONOUN, EnglishTypeEnum.TO_BE_CLAUSE, EnglishTypeEnum.INTERROGATIVE_CLAUSE);
//		applyingRules.add(interrogativeClauseGeneration2);
//
//		RewriteRule whPronounSimpleDeclarativeClauseFusion = new RewriteRule(2, EnglishTypeEnum.WH_PRONOUN, EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE, EnglishTypeEnum.DEPENDENT_CLAUSE);
//		applyingRules.add(whPronounSimpleDeclarativeClauseFusion);
//
//
//	}
//
//}
//
