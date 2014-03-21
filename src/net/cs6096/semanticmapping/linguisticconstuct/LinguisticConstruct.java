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

import net.cs6096.semanticmapping.conceptual.ConceptUniverse;
import net.cs6096.semanticmapping.core.TextConstructIndexMap;
import net.cs6096.semanticmapping.deprecated.EnglishOntology.ActionProcess;
import net.cs6096.semanticmapping.deprecated.EnglishOntology.Quality;
import net.cs6096.semanticmapping.grammarset.EnglishTypeEnum;

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.dv.xs.UnionDV;


public abstract class LinguisticConstruct {

	public TextConstructIndexMap belongingText = null;
	public String typeId = null;
	public boolean isAtom = false;
	public abstract int start();
	public abstract int size();
	public abstract String toSimpleString();
	public abstract ArrayList<LinguisticConstruct> getChildren ();
	public ConceptUniverse underlyingDimension = new ConceptUniverse();
	public String focusConcept;
	
//	public Existence focusExistence = null;
//	public ActionProcess focusActionProcess = null;
//	public Quality focusQuality = null;
//	public ActionQuality focusActionQuality = null;
	

}
