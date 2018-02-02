import java.util.Vector;

public class DiceSum {

	static int calls=0;

	public static void diceSumCheckHelper(int sumSoFar, Vector<Integer> chosen, int desiredSum, int dice){
		calls++;
		if(dice == 0){
			//if(sumSoFar == desiredSum){
				System.out.println(chosen);
			//}
		}else{
			for(int i=1;i<=6;i++){
				if(sumSoFar + i + 1*(dice-1) <= desiredSum && sumSoFar + i + 6*(dice-1) >= desiredSum){
					chosen.addElement(i);
					diceSumCheckHelper(sumSoFar+i, chosen, desiredSum, dice-1);
					chosen.removeElement(i);
				}
			}
		}
	}

	public static void diceSumCheck(int dice, int desiredSum){
		Vector<Integer> chosen = new Vector<>();
		diceSumCheckHelper(0, chosen, desiredSum, dice);
	}

	public static void main(String[] args) {
		diceSumCheck(3,10);
		System.out.println(calls);
	}

}
