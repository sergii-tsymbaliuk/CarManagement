package cars.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Aspect
public class AspectLogger {
	
	@Around(value= "execution(* cars..*.*(..))")
	public Object around(ProceedingJoinPoint pjp){
		Object result = null;
		System.out.println("======================= Around =======================");		
		System.out.println("Before execution, JP:" + pjp.toString());
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After execution, JP:" + pjp.toString());
		return result;
	}
	
	@Transactional
	@Around(value="execution(* cars..*.*save*(..)) || execution(* cars..*.*delete*(..)) || execution(* cars..*.*update*(..))")
	public Object addTransactional(ProceedingJoinPoint pjp){
		Object result = null;
		System.out.println("Begin transaction, JP:" + pjp.toString());
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("End transaction, JP:" + pjp.toString());
		return result;
	}
	
}
