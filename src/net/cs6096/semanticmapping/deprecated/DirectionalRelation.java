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

package net.cs6096.semanticmapping.deprecated;

import java.util.HashMap;
import java.util.HashSet;

public class DirectionalRelation {
	HashMap<String, HashSet<String>> cont = new HashMap();
	public void addNewRelation(String left, String right){
		if (!cont.containsKey(left)) cont.put(left, new HashSet());
		cont.get(left).add(right);
	}
	
	public boolean containsRelation(String left, String right){
		if (!cont.containsKey(left)) return false;
		return cont.get(left).contains(right);
	}
	
	public HashSet<String> allDirectRighthandside(String left){
		if (!cont.containsKey(left)) return new HashSet<>();
		return cont.get(left);
	}
	
	public DirectionalRelation copy(){
		DirectionalRelation fin = new DirectionalRelation();
		fin.cont = (HashMap<String, HashSet<String>>) this.cont.clone();
		return fin;
	}

}
