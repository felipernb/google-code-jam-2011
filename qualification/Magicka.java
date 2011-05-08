import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Magicka {

	public static String sortedString(String s) {
		if (s.charAt(0) < s.charAt(1)) return s;
		return s.substring(1) + s.substring(0,1);
	}
		
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int t = Integer.parseInt(in.nextLine()); //test cases
		String l;
		int c, d, n;
		StringTokenizer st;
		Map<String,Character> combinations;
		Map<Character,Character> oppositions;
		for(int i = 0; i < t; i++) {
			combinations = new HashMap<String,Character>();
			oppositions = new HashMap<Character, Character>();
			l = in.nextLine();
			st = new StringTokenizer(l);
			c = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < c; j++) {
				String combination = st.nextToken();
				combinations.put(sortedString(combination.substring(0,2)), combination.charAt(2));
			}
			
			d = Integer.parseInt(st.nextToken());
			for (int j = 0; j < d; j++) {
				String opposition = st.nextToken();
				oppositions.put(opposition.charAt(0), opposition.charAt(1));
				oppositions.put(opposition.charAt(1), opposition.charAt(0));
			}
			
			n = Integer.parseInt(st.nextToken());
			char[] magics = st.nextToken().toCharArray();
			StringBuffer m = new StringBuffer();
			for (int j = 0; j < magics.length; j++) {
				if(m.length() > 0) {
					char[] pair = {magics[j-1], magics[j]};
					String sorted = sortedString(new String(pair));
					if(combinations.containsKey(sorted)) {
						m.deleteCharAt(m.length()-1);
						magics[j--] = combinations.get(sorted);
						continue;
					}
				}
				if (oppositions.containsKey(magics[j]) && m.indexOf(oppositions.get(magics[j]).toString()) != -1) {
						m = new StringBuffer();
						continue;
				}
				m.append(magics[j]);
			}
			System.out.println("Case #"+(i+1)+ ": "+printAsArray(m.toString()));
		}
	}
	
	private static String printAsArray(String s) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if (s.length() > 0) sb.append(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			sb.append(", ");
			sb.append(s.charAt(i));
		}
		sb.append("]");
		return sb.toString();
	}
}

