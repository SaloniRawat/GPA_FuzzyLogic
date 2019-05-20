
import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.membership.functions.*;


/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class Fuzzy {
	
    public static void main(String[] args) throws Exception {
        
    	Fuzzy f = new Fuzzy();
    			f.readFile();
    	
    }
    
    public void readFile() {
    	// Load from 'FCL' file
        String fileName = "src/gpa.fcl";
        FIS fis = FIS.load(fileName,true);
        FunctionBlock fb = fis.getFunctionBlock("Score");
        //fis.
        
        
        //System.out.println(fb.getVariables());
        
        
        
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show 
        JFuzzyChart.get().chart(fb);

       // Set inputs
        fis.setVariable("SAT", 1368.00);
        

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable tip = fb.getVariable("GPA");
        System.out.println(tip);
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
        
        //fb.getVariable("tip").chart(true);
        
        // Print ruleSet
        System.out.println(fis);
    }
}
