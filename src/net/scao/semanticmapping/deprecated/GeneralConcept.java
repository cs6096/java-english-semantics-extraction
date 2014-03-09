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

import net.scao.semanticmapping.util.MultiHashMap;

import java.util.*;

public class GeneralConcept {
	public int conceptGenerationId = 0;
	public String shallowLabel;
	// first one is the relation, second one is the target
	public MultiHashMap<GeneralConcept, GeneralConcept> generalConnection = new MultiHashMap<>();
	public HashMap<String, String> attributes = new HashMap();

	public GeneralConcept(String newLabel){
		shallowLabel = newLabel;
	}

	public void addAttribute(){

	}

	public void addProperty(GeneralConcept gc1, GeneralConcept gc2){
		generalConnection.add(gc1, gc2);
	}

	public boolean containsProperty(GeneralConcept gc1, GeneralConcept gc2){
		return generalConnection.contains(gc1, gc2);
	}
	private Integer code;
	public int hashCode(){
		if (code == null){
			code = (int)(Math.random() * Integer.MAX_VALUE);
			code *= Math.random() > 0.5 ? -1 : 1;
		}
		return code;
	}
}
