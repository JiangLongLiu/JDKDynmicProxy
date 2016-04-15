
public class Main {
	public static void main(String[] args) {
		ArthmeticCalculator target=new ArthmeticCalculatorImpl();
		ArthmeticCalculator proxy=(ArthmeticCalculator) new ArthmeticCalculatoruProxy(target).getArthmeticCalculatorProxy();
		
		proxy.add(1, 1);
		proxy.sub(1, 1);
		proxy.mul(1, 1);
		proxy.div(1, 1);
		
	}
}
