package com.vipul.learnspring.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole{
	
	public void up() {
		System.out.println("up");
	}

	public void down() {
		System.out.println("down");
	}
	
	public void right() {
		System.out.println("right");
	}
	
	public void left() {
		System.out.println("left");
	}
}
