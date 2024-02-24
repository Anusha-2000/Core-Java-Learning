package SentimentAnalysis;

import java.util.ArrayList;
import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
			String[] negOpinionWords) {
		int[] featureOpinions = new int[featureSet.length]; // output
 
        // your code ~ you will be invoking getOpinionOnFeature		
		for(int i = 0; i < featureSet.length; i++) {
			int opinion = 0;
			for(int j = 0; j < featureSet[i].length; j++) {
				String feature = featureSet[i][j];
				opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
				if(opinion != 0) {
					featureOpinions[i] = opinion;
					break;
				}
			}
		}
		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and 
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		
		// your code
		int opinion = 0;

		opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
		if(opinion == 0) {
			opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
		}
		return opinion;
	}	

	// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		int opinion = 0;
		String pattern = feature + " was ";

		// your code
		//int rLen = review.length();
		review = review.toLowerCase();
		pattern = pattern.toLowerCase();

		//int rLen = review.length();
		//int pLen = pattern.length();

		String[] words = review.split(" ");
		ArrayList<String> opinions = new ArrayList<>();

		//System.out.println("Review = " + review);
		//display(words);

		int index = 0;
		//System.out.println("Pattern = " + pattern);
		while(index < words.length - 2) {
			String str = words[index] + " " + words[index+1] + " ";
			
			//System.out.println("index = " + index + "; str = " + str);
			
			if(str.contains(pattern)) {
				//System.out.println("Hurray, Pattern Matched.");
				opinions.add(words[index+2]);
				//System.out.println("Adding the opinion = " + opinion + " to the opList\n");
				index = index + 3;
				continue;
			}
			index++;
		}
		//System.out.println(opinions);

		for(String posOp : posOpinionWords) {
			for(String op : opinions) {
				if(op.contains(posOp)) {
					return 1;
				}
			}
		}

		for(String negOp : negOpinionWords) {
			for(String op : opinions) {
				if(op.contains(negOp)) {
					return -1;
				}
			}
		}

		return opinion; 	
	}
	
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {
		// Extract sentences as feature might appear multiple times. 
		// split() takes a regular expression and "." is a special character 
		// for regular expression. So, escape it to make it work!!
		review = review.toLowerCase();
		String[] sentences = review.split("\\.");
		int opinion = 0;
		
		//int rLen = review.length();
		// your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)		
        
		//int fLen = feature.length();
		feature = feature.toLowerCase();
		
	    ArrayList<String> opList = new ArrayList<>();
	    
	    for(String sentence : sentences) {
	        //System.out.println(sentence);
	        if(sentence.contains(feature) == false) {
	            //System.out.println("Byeeeeeeeeeee");
	            continue;
	        }
	        String[] words = sentence.split(" ");
	        //display(words);
	        //System.out.println("Hiiiiiiiiiiiiiiiiii");
	        for(int i = 0; i < words.length - 1; i++) {
	            String nextWord = words[i+1];
	            if(nextWord.contains(feature)) {
	                opList.add(words[i]);
	            }
	        }
	    }
	    
	    //System.out.println(opList);
	    
	    for(String op : opList) {
	        for(String posOp : posOpinionWords) {
	            if(op.contains(posOp)) return 1;
	        }
	    }
	    
	    for(String op : opList) {
	        for(String negOp : negOpinionWords) {
	            if(op.contains(negOp)) return -1;
	        }
	    }
	    
		return opinion;
	}

	public static void display(String[] arr) {
	    for(String str: arr) {
	        System.out.print(str + " ");
	    }
	    System.out.println();
	}
	
	public static void display(int[] arr) {
	    for(int i : arr) {
	        System.out.print(i + " ");
	    }
	    System.out.println();
	}
	
	public static void display(String[][] set) {
	    for(String[] arr: set) {
	        display(arr);
	    }
	    System.out.println();
	}
	public static void main(String[] args) {
		String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
		
		//String review = "Sorry OG, but you just lost some loyal customers. The service was unprofessional. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
		
		// int opFirst = getOpinionOnFeature(review, "service", posOpinionWords, negOpinionWords);
		// System.out.println(opFirst);
	}
}

