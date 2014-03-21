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
/**
 * A modifer is used to update the universe after its associated RewriteRule
 *  is called.
 * The indexing for elements in the rules is as follows:
 * -1 for the right hand side element
 * 0 .. k for the left hand side elements (essentially saying that they are
 *  0 indexed)
 */
package net.cs6096.semanticmapping.grammarset;

import java.util.*;

import net.cs6096.semanticmapping.linguisticconstuct.CompositeConstruct;

public class ConceptUniverseModifier {
	public ConceptUniverseModifier() {

	}

	public void addCommand(List<String> commandTokenList) {
		this.commandsList.add(new Command(commandTokenList.toArray(new String[commandTokenList.size()])));
	}

	public ConceptUniverseModifier(Command... commandList) {
		for (Command e : commandList) {
			if (e != null)
				this.commandsList.add(e);
		}
	}

	public void expandDimension(CompositeConstruct newConstruct) {
		processCommands(newConstruct);
	}

	static class Command {
		String commandName = null;
		String[] arguments = null;

		public Command(String... strings) {
			commandName = strings[0];
			arguments = Arrays.copyOfRange(strings, 1, strings.length);
		}

	}

	public ArrayList<Command> commandsList = new ArrayList<>();

	public void processCommands(CompositeConstruct newConstruct) {
		// System.out.println("CMDSIZE"+ commandsList.size());
		for (Command e : commandsList) {
			if (false)
				;
			else if (e.commandName.equals("$INHERIT")) {

				inherit(newConstruct, e.arguments);
			} else if (e.commandName.equals("$RELATE")) {
				relate(newConstruct, e.arguments);
			} else if (e.commandName.equals("$ASSOCIATE")) {
				associate(newConstruct, e.arguments);
			} else if (e.commandName.equals("$SET_PROPERTY")) {
				setProperty(newConstruct, e.arguments);
			}

		}
	}

	public void inherit(CompositeConstruct newConstruct, String... argumentArray) {
		// System.out.println(Arrays.toString(argumentArray));
		int inheritChildConstructIndex = Integer.parseInt(argumentArray[0]);

		String inheritingPropertyName = argumentArray[1];

		inherit(newConstruct, inheritChildConstructIndex, inheritingPropertyName);
	}

	
	/**
	 * Take specified relation mappings from one of the constituents and
	 *  gave the parent construct a copy.
	 * @param newConstruct
	 * @param inheritChildConstructIndex
	 * @param inheritingRelationName
	 */
	private void inherit(CompositeConstruct newConstruct, int inheritChildConstructIndex, String inheritingRelationName) {
		// String targetProperty = newConstruct.underlyingDimension.getProperty(
		// newConstruct.constituentConstructs.get(inheritChildConstructIndex).focusConcept,
		// inheritingRelationName);
		ArrayList<String> targets = newConstruct.underlyingDimension.getConceptsRelationTargets(
			newConstruct.constituentConstructs.get(inheritChildConstructIndex).focusConcept, inheritingRelationName);

		for (String e : targets) {
			newConstruct.underlyingDimension.addRelation(newConstruct.focusConcept, inheritingRelationName, e);
		}
	}

	
	/**
	 * Generate a relation mapping between some elements of the current rule
	 *  and add them to the concept universe.
	 * @param newConstruct
	 * @param argumentArray
	 */
	public void relate(CompositeConstruct newConstruct, String... argumentArray) {
		int sourceIndex = Integer.parseInt(argumentArray[0]);
		String relationName = argumentArray[1];
		int targetIndex = Integer.parseInt(argumentArray[2]);
		relate(newConstruct, sourceIndex, targetIndex, relationName);
	}

	private String retrieveConstructConcept(CompositeConstruct consideringConstruct, int index) {
		if (index < 0) {
			return consideringConstruct.focusConcept;
		} else {
			return consideringConstruct.constituentConstructs.get(index).focusConcept;
		}
	}

	private void relate(CompositeConstruct newConstruct, int sourceIndex, int targetIndex, String relationName) {
		String sourceConstructConcept = retrieveConstructConcept(newConstruct, sourceIndex);
		String targetConstructConcept = retrieveConstructConcept(newConstruct, targetIndex);
		ArrayList<String> sourceConcepts = newConstruct.underlyingDimension.getConceptsRelationTargets(sourceConstructConcept, "AssociatedAbstractConcept");
		ArrayList<String> targetConcepts = newConstruct.underlyingDimension.getConceptsRelationTargets(targetConstructConcept, "AssociatedAbstractConcept");
		for (String currentSource : sourceConcepts) {
			for (String currentTarget : targetConcepts) {
				newConstruct.underlyingDimension.addRelation(currentSource, relationName, currentTarget);
			}
		}
	}

	private void associate(CompositeConstruct newConstruct, String... argumentArray) {
		String newConceptOfProperty = argumentArray[0];
		associate(newConstruct, newConceptOfProperty);
	}

	/**
	 * Associate the new generating contruct with a newly generated specified concept.
	 * @param newConstruct
	 * @param newConceptOfProperty
	 */
	private void associate(CompositeConstruct newConstruct, String newConceptOfProperty) {
		String newAssociatedConcept = newConstruct.underlyingDimension.generateNewConceptOfCertainProperty(newConceptOfProperty);
		newConstruct.underlyingDimension.addRelation(newConstruct.focusConcept, "AssociatedAbstractConcept", newAssociatedConcept);
	}

	private void setProperty(CompositeConstruct newConstruct, String... argumentArray) {
		setProperty(newConstruct, Integer.parseInt(argumentArray[0]), argumentArray[1], argumentArray[2]);
	}

	/**
	 * Set the value for a specified property for a element in the rule
	 *  of specified index.
	 * @param newConstruct
	 * @param constructIndex
	 * @param propertyName
	 * @param newValue
	 */
	private void setProperty(CompositeConstruct newConstruct, int constructIndex, String propertyName, String newValue) {
		String sourceConstructConcept = retrieveConstructConcept(newConstruct, constructIndex);
		ArrayList<String> constructConcepts = newConstruct.underlyingDimension.getConceptsRelationTargets(sourceConstructConcept, "AssociatedAbstractConcept");
		for (String associatedConcept : constructConcepts) {
			newConstruct.underlyingDimension.setProperty(associatedConcept, propertyName, newValue);
		}
	}

}
