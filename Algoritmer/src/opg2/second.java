package opg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {

	static String[] persons;
	static boolean[][] friends;
	static int noPeople;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line;
		String group = null;

		while((line=reader.readLine()) != null){
			if (line.trim().startsWith("taetvenskab") == true){
				group = line.substring(11).trim();
				reader.close();
				break;
			}
			else if(line.trim().substring(0,1).matches("[a-zA-Z]")){
				noPeople = countwords(line);
				persons = new String[noPeople];
				friends = new boolean[noPeople][noPeople];

				for(int i = 0; i<noPeople; i++){
					for(int j=0; j<i; j++){
						friends[i][j] = false;
					}
				}
			}
			else if(line.trim().substring(0,1).matches("[0-9]")){
				int p1 = Integer.parseInt(line.trim().substring(0, line.indexOf(" ")));
				int p2 = Integer.parseInt(line.trim().substring(line.indexOf(" ")+1));
				addEdge(p1, p2);
			}
		}

		boolean isTight = tightFriends(group);
		
		if(isTight){
			System.out.println("ja");
		}else{
			System.out.println("nej");
		}
	}

	public static boolean tightFriends(String str) {
		boolean bool = true;
		
		String[] members = str.split("\\s+");
		int[] memb = new int[members.length];
		
		for (int i = 0 ; i<memb.length; i++) {
		    memb[i] = Integer.parseInt(members[i]);
		}
		
		outerloop:
		for(int i=1; i<memb.length; i++){
			for(int j=1; j<memb.length; j++){
				if((memb[i] == memb[j]) == false){
			    	bool = isEdge(memb[i], memb[j]);
			    	if(bool == false){
			    		break outerloop;
			    	}
				}
		    }
	    	
	    }
		return bool;
	}

	public static void addEdge(int p1, int p2){
		friends[p1][p2] = true;
		friends[p2][p1] = true;
	}

	public static boolean isEdge(int p1, int p2){
		boolean bool = false;
		bool = friends[p1][p2];


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