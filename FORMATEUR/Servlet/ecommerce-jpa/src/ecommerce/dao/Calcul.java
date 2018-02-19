package ecommerce.dao;

public class Calcul {
	public static int add(int... nbs) {
		return operation("add", nbs);
	}
	
	public static int mul(int... nbs) {
		return operation("mul", nbs);
	}
	
	private static int operation(String op, int... nbs) {
		int result = 0;
		if(op.equals("add")) {
			for (int nb : nbs) {
				result += nb;
			}
		} else if(op.equals("mul")) {
			result++;
			for (int nb : nbs) {
				result *= nb;
			}
		}
		
		return result;
	}

}
