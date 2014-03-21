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

package net.cs6096.semanticmapping.core;

import java.util.ArrayList;
import java.util.HashSet;

import net.cs6096.semanticmapping.linguisticconstuct.LinguisticConstruct;
import net.cs6096.semanticmapping.util.NLPStringUtil;

public class TextConstructIndexMap {
	public static int idPointer = 0;
	public String originalText = null;
	public ArrayList<String> tokens = null;
	public long computedCode = Long.MAX_VALUE;
	public HashSet<LinguisticConstruct>[] tokenAdjacencyList = null;
	public int mapId = -1;
	public TextConstructIndexMap(String str1){
		originalText = str1;
		tokens = NLPStringUtil.NLPTokenize(str1);
		tokenAdjacencyList = new HashSet[tokens.size()];
		for (int i =0; i < tokenAdjacencyList.length; i++){
			tokenAdjacencyList[i] = new HashSet();
		}
		mapId = idPointer++;
	}
	public int hashCode(){
		if (computedCode > (long)Integer.MAX_VALUE){
			computedCode = 0l | ((long)originalText.hashCode());
		}
		return (int)computedCode;
	}
	
}