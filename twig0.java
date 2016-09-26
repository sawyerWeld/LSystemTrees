import java.util.ArrayList;

public class twig0 extends Pythagoras {

	float theta = (float) Math.toRadians(25);

	public twig0(View3D view3d_) {
		super(view3d_);
		// TODO Auto-generated constructor stub
	}

	void setup() {
		ArrayList<LRule> rules = new ArrayList<LRule>();
		rules.add(new LRule('X', "F-[[X]+X]+F[+FX]-X"));
		rules.add(new LRule('F', "FF"));
		lsys = new LGen("X", rules, 7);
		
		setTheta(25);
		setLen(3);
		setStrokeWidth(2);
	}

	void display() {
		if (!initialized) {
			setup();
			initialized = true;
		} else {
			String str = lsys.getString(gen);
			for (char c : str.toCharArray()) {
				if (c == 'F') {
					moveForwardTwig();
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
	}
}
