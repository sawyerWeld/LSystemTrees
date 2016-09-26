import java.util.ArrayList;

import processing.core.PVector;

public class Pythagoras extends Turtle {

	float len = 2f;
	float theta = (float) Math.toRadians(60);
	float strokeWidth = 1;
	
	public Pythagoras(View3D view3d_) {
		super(view3d_);
	}

	void setup() {
		ArrayList<LRule> rules = new ArrayList();
		rules.add(new LRule('A', "AA"));
		rules.add(new LRule('B', "A[B]B"));
		lsys = new LGen("B", rules, 9);
	}

	void setTheta(int angle)
	{
		theta = (float) Math.toRadians(angle);
	}
	
	void setLen(float len_)
	{
		len = len_;
	}
	
	void setStrokeWidth(float width_)
	{
		strokeWidth = width_;
	}
	
	void turnRight() {
		parent.rotateZ(theta);
	}

	void turnLeft() {
		parent.rotateZ(-theta);
	}

	void moveForwardTwig() {
		parent.strokeWeight(strokeWidth);
		parent.stroke(102, 51, 0);
		//parent.fill(255);
		parent.line(0, 0, 0, -len);
		//parent.translate(0, -len / 2);
		//parent.box(5, len, 5); 
		parent.translate(0, -len);
	}

	void moveForwardEnd() {
		parent.stroke(0, 153, 51);
		parent.line(0, 0, 0, -len);
		parent.translate(0, -len / 2);
		//parent.box(10, len, 10);
		parent.translate(0, -len / 2);
	}

	@Override
	void display() {
		if (!initialized) {
			setup();
			initialized = true;
		} else {
			String str = lsys.getString(gen);
			for (char c : str.toCharArray()) {
				if (c == 'A') {
					moveForwardTwig();
				} else if (c == 'B') {
					moveForwardEnd();
				} else if (c == '[') {

					parent.pushMatrix();
					turnLeft();

				} else if (c == ']') {

					parent.popMatrix();
					turnRight();

				}
			}
		}
	}
}
