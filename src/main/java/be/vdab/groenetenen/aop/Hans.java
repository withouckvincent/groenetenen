package be.vdab.groenetenen.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
class Hans {
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Around("execution(* be.vdab.groenetenen.services.*.*(..))")
	@Around("be.vdab.groenetenen.aop.PointcutExpressions.services()")
	Object schrijfPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Hans");
		try {
			return joinPoint.proceed();
		} finally {
		}
	}

}
