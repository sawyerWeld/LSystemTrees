import processing.core.*;

import java.util.ArrayList;

import peasy.*;

public class View3D extends PApplet {

	public void settings() {
		size(1000, 500, P3D);
	}

	float x, y, z;
	PeasyCam cam;
	
	//Sierpinski sierpinski = new Sierpinski(this);
	Pythagoras pythagoras = new Pythagoras(this);
	twig1 twig = new twig1(this);
	ArrayList<Turtle> actors = new ArrayList<Turtle>();
	int gen = 0;

	public void setup() {
		background(102, 204, 255);
		//lights();
		cam = new PeasyCam(this, 1000);
		//actors.add(sierpinski);
		//actors.add(pythagoras);
		actors.add(twig);
	}

	public void draw() {
		strokeWeight(1);
		background(204, 230, 255);
		stroke(255);
		fill(71, 107, 107);
		translate(0,100,0);
		box(200);
		translate(0,-100,0);
		for (Turtle t : actors) {
			t.display();
		}
	}

	public void keyTyped() {
		if ((int) key == 122 && gen > 0) // Z
		{
			gen--;
			for (Turtle t : actors) {
				t.setGen(gen);
			}
		} else if ((int) key == 120 && gen < 7) // Z
		{
			gen++;
			for (Turtle t : actors) {
				t.setGen(gen);
			}
		}
		//println("typed " + (int) key + " " + keyCode);
	}

	public void mouseClicked() {
		for (Turtle t : actors) {
			t.setGen(gen);
		}
	}

	public static void main(String[] args) {

		PApplet.main("View3D");

	}
}
