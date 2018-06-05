package training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Saidaichi {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = sc.nextInt();
		String str = new String(br.readLine());

		Saidaichi(num, str);

	}

	public static void Saidaichi(int num, String str) {

		//最大値変数
		int max = 0;
		int cpr = 0;
		//配列に一文字ずつ格納（String）
		String[] temp = str.split("");
		//int型に直して別のint型配列に再格納
		int[] orary = new int[temp.length];
		//抽出桁数
		int[] ber = new int[num];
		//ans配列
		ArrayList<Integer> ans = new ArrayList<Integer>();

		//配列の中身をint型に変換
		for (int i = 0; i < temp.length; i++) {
			orary[i] = Integer.parseInt(temp[i]);
		}
		//
		System.out.println(Arrays.toString(orary));

		//探索処理
		for (int k = 0; k < orary.length - ber.length; k++) {
			//
			System.out.println(Arrays.toString(orary));
			for (int l = 0, m = k, n = ber.length; l < ber.length; l++, m++, n--) {
				ber[l] = orary[m] * (int) Math.pow(10, n);
			}
			for (int o = 0; o < ber.length; o++) {
				max += ber[o];
			}
			if (k != 0) {
				//次の数字。上と違うのはkの初期値に+1してるだけ
				for (int l = 0, m = k + 1, n = ber.length; l < ber.length; l++, m++, n--) {
					ber[l] = orary[m] * (int)Math.pow(10, n);
				}
				for (int o = 0; o < ber.length; o++) {
					cpr += ber[o];
				}
				if (max < cpr) {
					max = cpr;
					for (int m = k + 1; m < ber.length; m++) {
						orary[m] = 99;
					}
					//nullを詰める
					remove(orary, ber.length);
				}
			}
			ans.add(max);
		}

		for (int z = 0; z < ans.size(); z++) {
			System.out.println(ans.get(z));
		}

	}

	public static int[] remove(int[] input, int num) {
		for (int p = 0; p < input.length; p++) {
			if (input[p] == 99) {
				for (int q = p; q < input.length; q++) {
					input[q] = input[q + 1];
				}
			}
		}
		int[] output = new int[input.length - num];
		return output;
	}
}
