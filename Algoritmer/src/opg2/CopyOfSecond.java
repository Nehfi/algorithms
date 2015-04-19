package opg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CopyOfSecond {

	static Map<Integer, HashSet<Integer>> friends = new HashMap<Integer, HashSet<Integer>>();
	static String[] members;
	static int[] memb;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while((line=reader.readLine()) != null){
			if (line.trim().startsWith("taetvenskab") == true){

				members = line.substring(11).trim().split("\\s+");
				memb = new int[members.length];

				for (int i = 0 ; i<memb.length; i++) {
					memb[i] = Integer.parseInt(members[i]);
				}
				reader.close();
				break;
			}
			else if(line.trim().substring(0,1).matches("[0-9]")){
				int p1 = Integer.parseInt(line.substring(0, line.indexOf(" ")));
				int p2 = Integer.parseInt(line.substring(line.indexOf(" ")+1));

				if(friends.get(p1) == null){
					friends.put(p1, new HashSet<Integer>());
					friends.get(p1).add(p2);
				}else{
					friends.get(p1).add(p2);
				}
			}
		}

		boolean isTight = tightFriends(memb);
		if(isTight){
			System.out.println("ja");
		}else{
			System.out.println("nej");
		}
	}

	public static boolean tightFriends(int[] iA) {
		boolean bool = true;
		
		outerloop:
		for(int i=0 ; i<iA.length ; i++){
			for(int j=i+1 ; j<iA.length ; j++){
				bool = isEdge(iA[i], iA[j]);
				if(bool == false){
					break outerloop;
				}
			}
		}
		
		return bool;
	}

	public static boolean isEdge(int p1, int p2){
		boolean bool = false;
		if(friends.get(p1).contains(p2)){
			bool = true;
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