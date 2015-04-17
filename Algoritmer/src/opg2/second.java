package opg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class main {

	/**
	 * For den obligatoriske opgave i algoritmer
	 * Af Amal, Kim og Konstantin
	 */
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader = new BufferedReader(new FileReader("input2"));
		
		String line;
		String group;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> friendships = new ArrayList<Integer>();
		int n = 0;
		
		while((line=reader.readLine()) != null){
			if (line.trim().compareTo("taetvenskab") == 0) {
				group = line;
				System.out.println(line);
				reader.close();
				break;
			}else if(line.trim().compareTo("[a-zA-Z]") == 0){
				Collections.addAll(names, line.split("\\s+"));
			}else{
				
			}
			
			n++;
		}

		System.out.println(line);
		
	}

	public boolean tightFriends() {
		boolean bool = false;
		
		return bool;
	}
	
	public void addEdge(int p1, int p2){
		
	}

	public boolean isEdge(int p1, int p2){
		boolean bool = false;
		
		return bool;
	}
}
