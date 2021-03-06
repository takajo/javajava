import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MojiIrekae {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = new String(br.readLine());

		System.out.println( MojiIrekae(s) );
	}

	private static String MojiIrekae(String str) {
		String ans = "";
		char[] temp = str.toCharArray();
		//先頭と後尾の文字を変数に格納
		char c = temp[0];
		char h = temp[temp.length-1];

		//文字列が偶数の時
		if(temp.length % 2 == 0) {
			//中央の添字を決める。 iは中央の左側、kは中央の右側
			int i = temp.length / 2 - 1;
			int j = i + 1;
			//前半の文字をずらす
			for(int m = 0; m <= i; m++) {
				temp[m] = temp[m+1];
			}
			//後半の文字をずらす
			for(int n = temp.length-2; n >= j; n--) {
				temp[n+1] = temp[n];
			}
			//両端の文字を中央に格納
			temp[i] = c;
			temp[j] = h;

		//文字列が奇数の時
		} else {
			int i = temp.length / 2 -1;
			int j = i + 2;
			int k = i + 1;
			for(int m = 0; m <= i; m++) {
				temp[m] = temp[m+1];
			}
			for(int n = temp.length-2; n >= j; n--) {
				temp[n+1] = temp[n];
			}
			temp[i] = c;
			temp[j] = h;
		}
		ans = String.valueOf(temp);
		return ans;
	}
}
