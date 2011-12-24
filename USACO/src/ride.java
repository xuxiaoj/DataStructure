/*
ID: xuxiaoj1
LANG: JAVA
TASK: ride
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")), true);
		
		String comet = br.readLine();
		String group = br.readLine();
/*
		StringReader srcomet = new StringReader(comet);
		StringReader srgroup = new StringReader(group);
		
		int c;
		int pcomet = 1;
		int pgroup = 1;
		
		while ((c = srcomet.read()) != -1) {
			c = c - 64;
			pcomet = pcomet * c;
		}
		
		while ((c = srgroup.read()) != -1) {
			c = c - 64;
			pgroup = pgroup * c;
		}
		*/
		char[] c1 = comet.toCharArray();
		char[] c2 = group.toCharArray();
		int pcomet = 1;
		int pgroup = 1;
		for (char c : c1) {
			pcomet = (pcomet * (c - 'A' + 1)) % 47;
		}
		for (char c : c2) {
			pgroup = (pgroup * (c - 'A' + 1)) % 47;
		}
		if (pcomet == pgroup) {
			out.println("GO");
		} else {
			out.println("STAY");
		}
	}
}
