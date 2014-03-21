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
import java.util.*;
import java.io.*;
public class IOUtil {
	public static String readFile(String fileName) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
		StringBuilder fin = new StringBuilder();
		for (;;){
			int cur = in.read();
			if (cur<0) break;
			fin.append((char)cur);
		}
		return fin.toString();
	}
	
	public static ArrayList<String> readTokenList(String fileName) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
		StringTokenizer st = null; 
		ArrayList<String> fin =new ArrayList();
		A:
		for (;;){
			for (;st == null || !st.hasMoreTokens();){
				String k1 = in.readLine();
				if (k1 == null) break A;
				st = new StringTokenizer(k1);
			}
			fin.add(st.nextToken());
		}
		return fin;
	}
	
	public static ArrayList<String> readLineList(String fileName) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
		ArrayList<String> fin =new ArrayList();
		for (;;){
			String k1 = in.readLine();
			if (k1 == null) break;
			fin.add(k1);
		}
		return fin;
	}
	
	public static void writeFile(String fileName, String cont) throws Exception {
//		System.out.println(System.getProperty("user.dir"));
		PrintWriter f1 = new PrintWriter(fileName,"UTF-8");
		f1.write(cont);
		f1.flush();
		f1.close();
	}
	
	public static void writeListFile(String fileName, ArrayList<String> list) throws Exception {
		PrintWriter f1 = new PrintWriter(fileName);
		for (String e: list){
			f1.println(e);
		}
		f1.flush();
	}
}
