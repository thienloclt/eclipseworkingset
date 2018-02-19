package monprojet.musique;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Spectateur2 {
	
	public Spectateur2() {
		
	}
	
	@Pointcut("execution(* *.jouer1(..))")
	public void performance() {
	}
	
	@Before("performance()")
	public void before1() {
		System.out.println("----------------before1----------------");
	}
	
	@Before("performance()")
	public void before2() {
		System.out.println("------------before2-----------------");
	}
	
	@AfterReturning("performance()")
	public void afterReturning() {
		System.out.println("-------------afterReturning-------------------");
	}
	
	@AfterThrowing("performance()")
	public void afterThrowing() {
		System.out.println("----------------afterThrowing--------------");
	}
}
