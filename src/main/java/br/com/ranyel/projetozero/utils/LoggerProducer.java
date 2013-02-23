package br.com.ranyel.projetozero.utils;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author ranyel
 * 
 */
public class LoggerProducer {

	@Produces
	public Logger produceLogger(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
