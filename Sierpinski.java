import java.util.ArrayList;

import processing.core.PVector;

public class Sierpinski extends Turtle {

	float len = 10f;
	float theta = (float) Math.toRadians(60);
	
	

	public Sierpinski(View3D view3d_) {
		super(view3d_);
	}

	void setup() {
		ArrayList<LRule> rules = new ArrayList();
		rules.add(new LRule('A', "+B-A-B+"));
		rules.add(new LRule('B', "-A+B+A-"));
		lsys = new LGen("A", rules, 9);
	}

	void turnRight() {
		parent.rotateZ(theta);
	}
	

	void turnLeft() {
		parent.rotateZ(-theta);
	}

	void moveForward() {
		// System.out.println(loc.x);
		parent.stroke(0, 200, 200);
		parent.strokeWeight(3);
		parent.line(0, 0, 0, -len);
		parent.translate(0, -len/2);
		parent.box(2, len, 2);
		parent.translate(0, -len/2);
	}

	@Override
	void display() {
		if (!initialized) {
			setup();
			initialized = true;
		} else {
			String str = lsys.getString(gen);
			for (char c : str.toCharArray()) {
				if (c == 'A' || c == 'B') {
					moveForward();
				} else if (c == '-') {
					turnLeft();
				} else if (c == '+') {
					turnRight();
				}
			}
		}
	}
}
