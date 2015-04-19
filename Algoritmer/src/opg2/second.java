package opg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

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
				noPeople = lineNames(line);
				friends = new boolean[noPeople][noPeople];

			}
			else if(line.trim().substring(0,1).matches("[0-9]")){
				int p1 = Integer.parseInt(line.substring(0, line.indexOf(" ")));
				int p2 = Integer.parseInt(line.substring(line.indexOf(" ")+1));
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
		for(int i=0; i<memb.length; i++){
			for(int j=i+1; j<memb.length; j++){
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
		if(p1<p2){
			friends[p1][p2] = true;
		}else{
			friends[p2][p1] = true;
		}
	}

	public static boolean isEdge(int p1, int p2){
		boolean bool;
		if(p1<p2){
			bool = friends[p1][p2];
		}else{
			bool = friends[p2][p1];
		}
		
		return bool;
	}

	public static int lineNames(String str){
		int count;
		String[] people = str.split("\\s+");
		
		count = people.length;
		
		return count;
	}
}