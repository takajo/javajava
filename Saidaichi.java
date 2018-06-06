package training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Saidaichi {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = sc.nextInt();
		String str = new String(br.readLine());

		Saidaichi(num, str);

	}

	public static void Saidaichi(int a, String b) {

		int max = 0;
		int cpr = 0;
		int dig = a;
		ArrayList<Integer> ans = new ArrayList<Integer>();

		//string配列をIntegerListに
		String[] temp = b.split("");
		List<Integer> ary = new ArrayList<Integer>();
		for (String j : temp) {
			ary.add(Integer.parseInt(j));
		}

		//処理
		for (int i = 0; i < ary.size(); i++) {
			//先頭が0ならremove
			while (ary.get(0) == 0) {
				ary.remove(0);
			}
			//添字保存用変数を用意
			int x = 0;
			//max格納
			for (int k = 0, l = dig - 1; k < dig; k++, l--) {
				max = max + ary.get(k) * (int) Math.pow(10, l);
			}

			for (int j = 0; j < ary.size() - dig + 1; j++) {
				//比較するN桁をcprに格納する
				//cpr初期化
				cpr = 0;
				//cpr格納
				if (ary.size() >= dig) {
					for (int m = j, n = dig - 1; m < j + dig; m++, n--) {
						cpr = cpr + ary.get(m) * (int) Math.pow(10, n);
					}
				} else {
					//ary配列がN桁数未満
					for (int m = ary.size() -1, n = 0; n <  dig; m--, n++) {
						max = max + ary.get(m) * (int) Math.pow(10, n);
					}
				}
				//cprがmaxより大きければ交換
				if (max < cpr) {
					max = cpr;
					//交換した場所の添字を保存
					x = j;
				}

				//確認
				System.out.println("\n" + "max " + max);
				System.out.println("cpr " + cpr);
				for (Integer st : ary) {
					System.out.print(st + "ary");
				}
				System.out.println("\n");
				for (Integer tr : ans) {
					System.out.print(tr + "ans");
				}

			}
			//ans配列にmax格納
			ans.add(max);

			//交換したとこをremove
			if (x != 0) {
				for (int o = 0; o < dig; o++) {
					ary.remove(x);
					ary.size();
				}
			}

			//確認
			for (Integer st : ary) {
				System.out.print(st + " ");
			}
			System.out.println();

			//maxとcprを初期化
			max = 0;
			cpr = 0;
		}

		//結果出力
		for (Integer z : ans) {
			System.out.print(z + "z");
		}
		
	}
}

//ary.size() != 0

//比べた数字が(cpr)maxより大きかった場合の処理
//xに見つかったときの先頭の番号を格納、桁数分removeする

//次の数字をcprに格納し順次比較、maxより大きければmaxに格納、
//そうでなかったらスルーするメソッド
//maxに格納した場合、その値が入っていた配列を削除し、配列を短縮するメソッド
