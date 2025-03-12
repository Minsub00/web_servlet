package mallpage;

import java.util.ArrayList;

public abstract class ab_footer {
	copyright cr = new copyright();
	ArrayList<String> cpdata = null;
	public void fts() {
		cpdata = cr.copyright_info();
	}
}
