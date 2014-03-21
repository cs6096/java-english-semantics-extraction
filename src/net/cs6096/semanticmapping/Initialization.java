package net.cs6096.semanticmapping;

import net.cs6096.semanticmapping.factory.Factory;
import net.cs6096.semanticmapping.grammarset.EnglishContextFreeGrammarSet;

public class Initialization {
	public static boolean isInitialized = false;
	public static void initialize(){
		if (isInitialized) return;
		isInitialized = true;
		try {
			EnglishContextFreeGrammarSet.generate();
			Factory.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
