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
		//�擪�ƌ���̕�����ϐ��Ɋi�[
		char c = temp[0];
		char h = temp[temp.length-1];

		//�����񂪋����̎�
		if(temp.length % 2 == 0) {
			//�����̓Y�������߂�B i�͒����̍����Ak�͒����̉E��
			int i = temp.length / 2 - 1;
			int j = i + 1;
			//�O���̕��������炷
			for(int m = 0; m <= i; m++) {
				temp[m] = temp[m+1];
			}
			//�㔼�̕��������炷
			for(int n = temp.length-2; n >= j; n--) {
				temp[n+1] = temp[n];
			}
			//���[�̕����𒆉��Ɋi�[
			temp[i] = c;
			temp[j] = h;

		//�����񂪊�̎�
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
