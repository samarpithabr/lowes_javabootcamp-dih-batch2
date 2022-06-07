package com.springAnnotation;

import org.springframework.stereotype.Component;

import com.examples.spring.core.annotation.Person;

public class CommonMan extends Person
{

	boolean canWalk;

	public CommonMan() {

	}

	public boolean isCanFly() {
		return canWalk;
	}

	public void setCanFly(boolean canFly) {
		this.canWalk = canFly;
	}


	
}
