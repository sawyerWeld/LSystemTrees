import processing.core.PApplet;

public class Turtle {
	PApplet parent;
	int gen;
	LGen lsys;
	Boolean initialized = false;
	public Turtle(View3D view3d_) {
		parent = view3d_;
	}
	
	void display() {
		parent.pushMatrix();
		parent.translate(100, 100,100);
		parent.strokeWeight(20f);
	    parent.box(300);
	    parent.popMatrix();
	  }

	public void setGen(int gen_) {
		gen = gen_;
	}
}
