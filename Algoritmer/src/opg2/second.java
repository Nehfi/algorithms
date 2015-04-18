package opg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class main {

	static String[] persons;
	static boolean[][] friends;

	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader = new BufferedReader(new FileReader("input2"));

		String line;
		String group = null;

		int E = 0;
		ArrayList<Integer> gr = new ArrayList<Integer>();
		String[] q;

		while((line=reader.readLine()) != null){
			if (line.trim().startsWith("taetvenskab") == true){
				group = line.substring(11).trim();
				reader.close();
				break;
			}
			else if(line.trim().substring(0,1).matches("[a-zA-Z]")){
				int V = countwords(line);
				System.out.println("V: " + V);
				persons = new String[V];
				friends = new boolean[V][V];

				for(int i = 0; i<V; i++){
					for(int j=0; j<i; j++){
						friends[i][j] = false;
//						System.out.println("Freinds i,j: " + friends[i][j]);
					}
				}
			}
			else if(line.trim().substring(0,1).matches("[0-9]")){
				int p1 = Integer.parseInt(line.trim().substring(0, 1));
				int p2 = Integer.parseInt(line.trim().substring(2));
				addEdge(p1, p2);
				E++;
			}
		}

		boolean isTight = tightFriends(group);
		System.out.println("Be tight? " + isTight);
	}

	public static boolean tightFriends(String str) {
		boolean bool = false;

		String[] digitwords = str.split("\\s+");
		int[] result = new int[digitwords.length];
		for (int i = 0; i < result.length; i++) {
		    result[i] = Integer.parseInt(digitwords[i]);
		    System.out.println("Res :" + result[i]);
		}

		
		
		return bool;
	}

	public static void addEdge(int p1, int p2){
		friends[p1][p2] = true;
		friends[p2][p1] = true;
		System.out.println("Venskab " + p1 + " og " + p2 + " er: " + friends[p2][p1]);
	}

	public static boolean isEdge(int p1, int p2){
		boolean bool = false;
		bool = friends[p1][p2];

		System.out.println("IsEdge?: " + bool);

		return bool;
	}

	public static int countwords(String str){
		boolean word = false;
		int wordCount = 0;
		int  endOfLine = str.length () -1;

		for (int i =0; i<str.length(); i++){
			if (Character.isLetter(str.charAt(i)) && i != endOfLine){
				word=true;
			}
			else if (!Character.isLetter(str.charAt(i)) && word){
				wordCount++;
				word=false;

			} else if (Character.isLetter(str.charAt(i)) && i==endOfLine){
				wordCount++;
			}
		}
		return wordCount;
	}
}