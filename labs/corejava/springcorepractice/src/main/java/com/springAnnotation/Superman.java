package com.springAnnotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class Superman extends Person{
	boolean canfly;
	public Superman() {
		
	}
	public Superman(boolean canfly) {
		super();
		this.canfly = canfly;
	}
	public boolean isCanfly() {
		return canfly;
	}
	public void setCanfly(boolean canfly) {
		this.canfly = canfly;
	}

}
