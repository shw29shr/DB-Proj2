package operators;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import models.Tuple;

/**
 * Base Abstract class for all Operators
 * 
 * @author
 * Saarthak Chandra - sc2776
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * 
 */
public abstract class Operator {
	public abstract Tuple getNextTuple();	
	public abstract List<String> getSchema();
	public abstract void reset();
	public List<String> schema = null;
	
	/**
	 * Print Every table row
	 * @param ps The PrintStream object
	 * @throws IOException 
	 */
	public void dump(PrintStream ps) throws IOException {
		Tuple tuple = null;
		int counter = 0;
		while ((tuple = getNextTuple()) != null) {
			if(counter != 0)
				ps.write("\n".getBytes());
			counter++;
			tuple.dump(ps);
			
		}
	}
	
}
