import java.util.ArrayList;

import processing.core.PApplet;

public class twig1 extends Pythagoras {

	float theta = (float) Math.toRadians(25);

	ArrayList<Float> myRots = new ArrayList<>();

	public twig1(View3D view3d_) {
		super(view3d_);
		// TODO Auto-generated constructor stub
		ArrayList<LRule> rules = new ArrayList<LRule>();
		rules.add(new LRule('X', "F-[[X]+X]+F[+FX]-X"));
		rules.add(new LRule('F', "FF"));
		lsys = new LGen("X", rules, 7);
		System.out.println(lsys.getString(7).length());
		setTheta(30);
		setLen(5);
		setStrokeWidth(1);

		for (int i = 0; i < 100000; i++) {
			myRots.add((float) (Math.random()));
		}
	}

	void setup() {

	}

	int c = 0;

	void moveForwardTwig() {
		float myRot = myRots.get(c);
		parent.rotateY(myRot);
		c++;
		super.moveForwardTwig();
	}

	void leaf() {
		parent.stroke(0, 102, 0);
		parent.rotateX(-theta);
		parent.line(0, 0, 0, -len);
		parent.rotateX(2 * theta);
		
		parent.line(0, 0, 0, -len);
	}

	void display() {
		c = 0;

		if (!initialized) {
			setup();
			initialized = true;
		} else {
			String str = lsys.getString(gen);
			for (char c : str.toCharArray()) {

				if (c == 'F') {
					parent.stroke(210, 166, 121);
					moveForwardTwig();
				} else if (c == 'X') {
					leaf();
				} else if (c == '-') {
					turnLeft();
				} else if (c == '+') {
					turnRight();
				} else if (c == '[') {
					parent.pushMatrix();
				} else if (c == ']') {
					parent.popMatrix();
				}
			}
		}
		parent.stroke(100, 255, 0);
		parent.sphere(1);
		// System.out.print(c);
	}
}
