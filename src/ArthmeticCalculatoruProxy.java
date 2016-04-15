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
		//�����������һ����������������
		ClassLoader loader=this.target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class[] interfaces=this.target.getClass().getInterfaces();
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler  h=new InvocationHandler() {
			/**
			 * proxy: ���ڷ��ص��Ǹ��������,һ������£���invoke�����ж���ʹ�øö���
			 * method:���ڱ����õķ���
			 * args:���÷���ʱ����Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String methodName=method.getName();
				//��־
				System.out.println("The method "+methodName+" begins with"+Arrays.asList(args));
				//ִ��ҵ��
				Object result=method.invoke(target, args);
				//��־
				System.out.println("The method "+methodName+" ends --> "+result);
				return result;
			}
		};
		return Proxy.newProxyInstance(loader, interfaces, h);
	}
}
