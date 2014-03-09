package net.shengcao.semanticmapping.grammarset;
import java.util.ArrayList;
public class EnglishContextFreeGrammarSet {
	public static ArrayList<RewriteRule> applyingRules=new ArrayList<>();
	static {
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.ADJECTIVE_PHRASE, EnglishTypeEnum.ADVERB, EnglishTypeEnum.ADJECTIVE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_PREPOSITION, EnglishTypeEnum.PREPOSITION);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.TO_BE_CLAUSE, EnglishTypeEnum.TO_BE_VERB, EnglishTypeEnum.ADJECTIVE_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.TO_BE_CLAUSE, EnglishTypeEnum.TO_BE_VERB, EnglishTypeEnum.FINAL_NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.TO_BE_PHRASE, EnglishTypeEnum.TO_BE_VERB);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.TO_BE_PHRASE, EnglishTypeEnum.TO_BE_VERB, EnglishTypeEnum.ADVERB);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.PASSIVE_CLAUSE, EnglishTypeEnum.TO_BE_PHRASE, EnglishTypeEnum.PREDICATE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE, EnglishTypeEnum.SUBJECT, EnglishTypeEnum.PASSIVE_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.VERB);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.VERB, EnglishTypeEnum.ADJECTIVE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.VERB, EnglishTypeEnum.FINAL_NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.VERB, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.FINAL_NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.VERB_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.ADVERB);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.ADVERB, EnglishTypeEnum.VERB_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.VERB_PHRASE, EnglishTypeEnum.PREPOSITIONAL_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_PREPOSITION, EnglishTypeEnum.ADJECTIVE, EnglishTypeEnum.PREPOSITION);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.PREPOSITIONAL_PHRASE, EnglishTypeEnum.FINAL_PREPOSITION, EnglishTypeEnum.FINAL_NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.PREPOSITIONAL_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_VERB_PHRASE, EnglishTypeEnum.AUXILIARY, EnglishTypeEnum.FINAL_VERB_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.GERUND, EnglishTypeEnum.PRESENT_PRINCIPLE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.NOUN_PHRASE, EnglishTypeEnum.NOUN);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.NOUN, EnglishTypeEnum.PRONOUN);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.NOUN, EnglishTypeEnum.PROPER_NOUN);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.NOUN_PHRASE, EnglishTypeEnum.NOUN, EnglishTypeEnum.NOUN);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.PROPER_NOUN, EnglishTypeEnum.PROPER_NOUN, EnglishTypeEnum.PROPER_NOUN);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.TARGET, EnglishTypeEnum.PRONOUN, EnglishTypeEnum.FINAL_NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.TARGET, EnglishTypeEnum.FINAL_NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.SUBJECT, EnglishTypeEnum.TARGET);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.PREDICATE, EnglishTypeEnum.FINAL_VERB_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE, EnglishTypeEnum.SUBJECT, EnglishTypeEnum.PREDICATE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE, EnglishTypeEnum.SUBJECT, EnglishTypeEnum.TO_BE_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.NOUN_PHRASE, EnglishTypeEnum.ADJECTIVE, EnglishTypeEnum.NOUN);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.$INHERIT, EnglishTypeEnum.1, EnglishTypeEnum.associatedExistence);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
, new Commnand("$INHERIT", "1", "associatedExistence")
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.ARTICLE, EnglishTypeEnum.NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.DETERMINER, EnglishTypeEnum.NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.POSSESSIVE_PRONOUN, EnglishTypeEnum.NOUN_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.PREPOSITIONAL_PHRASE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.INTERROGATIVE_CLAUSE, EnglishTypeEnum.WH_PRONOUN, EnglishTypeEnum.PREDICATE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.INTERROGATIVE_CLAUSE, EnglishTypeEnum.WH_PRONOUN, EnglishTypeEnum.TO_BE_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.DEPENDENT_CLAUSE, EnglishTypeEnum.WH_PRONOUN, EnglishTypeEnum.PREDICATE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.DEPENDENT_CLAUSE, EnglishTypeEnum.WH_PRONOUN, EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.SUBJECT, EnglishTypeEnum.FINAL_NOUN_PHRASE, EnglishTypeEnum.DEPENDENT_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.TARGET, EnglishTypeEnum.DEPENDENT_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.INFINITIVE, EnglishTypeEnum.TO, EnglishTypeEnum.PREDICATE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.SUBJECT, EnglishTypeEnum.INFINITIVE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.EXISTENTIAL_CLAUSE, EnglishTypeEnum.THERE, EnglishTypeEnum.TO_BE_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}
{
    RewriteRule currentRule = new RewriteRule(EnglishTypeEnum.COMPOUND_CLAUSE, EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE, EnglishTypeEnum.CONJUNCTION, EnglishTypeEnum.SIMPLE_DECLARATIVE_CLAUSE);
	currentRule.applyingConceptDimensionModifier = new ConceptDimensionModifier(
	);
    applyingRules.add(currentRule);
}

	}
}


