package com.maurice.boxed;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Boxed";
		cfg.width = 480;
		cfg.height = 800;
		
		new LwjglApplication(new MyBoxedGame(), cfg);
	}
}
