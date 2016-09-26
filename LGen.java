import java.util.ArrayList;

public class LGen {
	String axiom = "";
	ArrayList<LRule> rules = new ArrayList();
	ArrayList<String> gens = new ArrayList();

	public LGen(String axiom_, ArrayList<LRule> rules_) {
		axiom = axiom_;
		rules = rules_;
	}

	public LGen(String axiom_, ArrayList<LRule> rules_, int preprocess) {
		axiom = axiom_;
		rules = rules_;
		gens.add(axiom);
		iterate(preprocess);
	}

	void iterate(int iterations) {
		String current = axiom;
		String next = "";
		for (int i = 0; i < iterations; i++) {
			for (int j = 0; j < current.length(); j++) {
				boolean Added = false;
				char c = current.charAt(j);
				for (LRule rule : rules)
				{
					if (rule.In() == c)
					{
						next += rule.Out();
						Added = true;
					}
				}
				if (!Added)
				{
					next += c;
				}
			}
			gens.add(next);
			current = next;
			next = "";
		}
	}

	String getString(int i) {
		return gens.get(i);
	}
	
	public static void main(String[] args)
	{
		ArrayList<LRule> algaeRules = new ArrayList();
		algaeRules.add(new LRule('A',"+B-A-B+"));
		algaeRules.add(new LRule('B',"-A+B+A-"));
		LGen algae = new LGen("A",algaeRules,5);
		System.out.println(algae.getString(0));
		System.out.println(algae.getString(1));
		System.out.println(algae.getString(2));
		System.out.println(algae.getString(3));
		System.out.println(algae.getString(4));
	}
}
