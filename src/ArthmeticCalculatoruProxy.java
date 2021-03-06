import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class ArthmeticCalculatoruProxy {
	
	private Object target;
	
	public  ArthmeticCalculatoruProxy(Object target){
		this.target=target;
	}
	
	

	public Object getArthmeticCalculatorProxy(){
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader=this.target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法
		Class[] interfaces=this.target.getClass().getInterfaces();
		//当调用代理对象其中的方法时，该执行的代码
		InvocationHandler  h=new InvocationHandler() {
			/**
			 * proxy: 正在返回的那个代理对象,一般情况下，在invoke方法中都不使用该对象
			 * method:正在被调用的方法
			 * args:调用方法时传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String methodName=method.getName();
				//日志
				System.out.println("The method "+methodName+" begins with"+Arrays.asList(args));
				//执行业务
				Object result=method.invoke(target, args);
				//日志
				System.out.println("The method "+methodName+" ends --> "+result);
				return result;
			}
		};
		return Proxy.newProxyInstance(loader, interfaces, h);
	}
}
