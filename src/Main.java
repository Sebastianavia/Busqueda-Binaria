
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public final static String SPLIT =" ";
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = read.readLine();
		int books = Integer.parseInt(line);
		int[] prices = new int[books];
		int cost;
		String[] numArrays = null;
		int countain = 0;
		while(line != null) {
			if(countain == 0) {
				line = read.readLine();
			}
			numArrays = line.split(SPLIT);
			for(int i =0; i<books;i++) {
				prices[i] = Integer.parseInt(numArrays[i]);
				System.out.println(prices[i]);

			}
			Arrays.sort(prices);
		
			line= read.readLine();
			cost = Integer.parseInt(line);	
			System.out.println("LLEGA");
			
		int[]position = differenceFind(prices,cost);
		System.out.println("Peter should buy the books, with the following costs: "+position[0] +" and "+position[1]+"\n");
		System.out.println("final");
		line= read.readLine();
		}
		read.close();
		write.close();
	}
	public static int binarySerch(int[] value, int netcash){
		int i= 0;
		int j = value.length-1;
		int amateur = -1;
		int m =0;
		while(amateur<0 && i<=j) {
			m = (i+j)/2;
			if(value[m] == netcash) {
				amateur = m;
			}else if(value[m]>netcash) {
				j=m-1;
			}else {
				i=m+1;
			}
		}
		return amateur;
		
	}
	public static int[] differenceFind(int []worth, int netcash ) {
		int dif = 0;
		int temp = Integer.MAX_VALUE;
		int[]positions = new int[2];
		for(int i=0;i<worth.length;i++) {
			if(binarySerch(worth,(netcash-worth[i]))>=0) {
				if(worth[i]-worth[binarySerch(worth,(netcash-worth[i]))]<Integer.MAX_VALUE) {
					dif = Math.abs(worth[i]-worth[binarySerch(worth,(netcash-worth[i]))]);
					if((temp)>(dif)) {
						temp = dif;
						positions[0] = worth[i];
						positions[1]= worth[binarySerch(worth,(netcash-worth[i]))];
					}
				}
			}
		}
		return positions;
		
	}
}