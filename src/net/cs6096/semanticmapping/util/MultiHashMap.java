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
package net.cs6096.semanticmapping.util;

import java.util.HashMap;
import java.util.HashSet;

public class MultiHashMap <E,V> {
	public HashMap<E, HashSet<V>> contMap = new HashMap<>();
	public void add(E e1, V v1){
		if (!contMap.containsKey(e1)){
			contMap.put(e1, new HashSet());
		}
		contMap.get(e1).add(v1);
	}
	public boolean contains(E e1, V v1){
		if (!contMap.containsKey(e1))return false;
		return contMap.get(e1).contains(v1);
	}
	
	public void absorb(MultiHashMap<E, V> absorbed){
		for (E e: absorbed.contMap.keySet()){
			for (V v: absorbed.contMap.get(e)){
				this.add(e, v);
			}
		}
	}
	public V firstMappedElement(E from){
		if (!contMap.containsKey(from)){
			return null;
		}
		return contMap.get(from).iterator().next();
	}

}
