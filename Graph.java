import java.awt.*;
import java.awt.geom.*;
import java.io.FileNotFoundException;
import java.util.List;


import javax.swing.*;

public class Graph extends JPanel {

	static ScoreList test = new ScoreList();
		
	List<Student> data = test.returnStudentList();
	
	final int PAD = 10;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//Graphics2D g3 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getWidth();
		int h = getHeight();
		// Draw ordinate.
		g2.draw(new Line2D.Double(PAD, PAD, PAD, h - PAD));
		//g2.drawString
		// Draw abcissa.
		g2.draw(new Line2D.Double(PAD, h - PAD, w - PAD, h - PAD));
		//double xInc = (double) (w - 2 * PAD) / (data.length - 1);
		//double scale = (double) (h - 2 * PAD) / getMax();
		
		double xInc = (double) (w- 2*PAD)/(data.size()-1);
		double scale = (double)(h - 2*PAD)/getMax();
		// Mark data points.
		g2.setPaint(Color.green);
		for (int i = 0; i < data.size(); i++) {
			
			Student student1 = data.get(i);
			double y = h- PAD - student1.getGPA() *xInc;
			double x =   PAD + scale*student1.getSAT();
			
			
			/*double x1 = PAD + data.get(i+1).getGPA() *xInc;
			double y1 = h -PAD - scale*data.get(i+1).getSAT();*/
			g2.fill(new Ellipse2D.Double(x ,y, 4, 4));
			
		}
		
		g2.setPaint(Color.red);
		//System.out.println("X Centroid: " + calculateXCentroid());
		//System.out.println("Y Centroid: " + calculateYCentroid());
		double xCentroid = PAD + calculateXCentroid()*xInc;
		double yCentroid = h -PAD - scale*calculateYCentroid();
		double max = getMax();
		//System.out.println("max: " + max);
		g2.fill(new Ellipse2D.Double( xCentroid, yCentroid, 3, 3));
		
		
		g2.setPaint(Color.BLUE);
		g2.fill(new Ellipse2D.Double(xCentroid-PAD, h-PAD , 3, 3));
		g2.fill(new Ellipse2D.Double(PAD, yCentroid , 3, 3));
		
		g2.setPaint(Color.RED);
		g2.fill(new Ellipse2D.Double(PAD,max, 3, 3));
	}

	public float getMax() {
		float max = 0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getSAT() > max)
				max = data.get(i).getSAT();
		}
		return max;
	}
	
	public float getMin() {
		float min = data.get(1).getSAT();
		//System.out.println("Min" + min);
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getSAT() < min && data.get(i).getSAT()!=0)
				min = data.get(i).getSAT();
		}
		return min;
	}
	
	public double calculateXCentroid() {
	    double x = 0.;
	    int pointCount = data.size();
	    for (int i = 0;i < pointCount - 1;i++){
	        final Student point = data.get(i);
	        x += point.getSAT();
	    }

	    x = x/pointCount;

	    return x;
	}
	
	public double calculateYCentroid() {
	   
	    double y = 0.;
	    int pointCount = data.size();
	    for (int i = 0;i < pointCount - 1;i++){
	        final Student point = data.get(i);
	        y += point.getGPA();
	    }

	   y = y/pointCount;

	    return y;
	}
	
	public double sCalculate() {
		
		double s = getMax() - calculateXCentroid();
		
		return s;
	}
	
	public double tCalculate() {
		
		double t = calculateXCentroid() - getMin();
		return t;
	}
	
	public double qCalculate() {
		
		if((calculateXCentroid() - getMin()) > (getMax() - calculateXCentroid())){
			double q = ((3*calculateXCentroid()) - getMax())/2;
			return q;
		}else {
			double q = ((3*calculateXCentroid()) - getMin())/2;
			return q;
		}
		
				
	}
	
	public double rCalculate() {
		
		if((calculateXCentroid() - getMin()) > (getMax() - calculateXCentroid())){
			double r = qCalculate() + (calculateYCentroid() - qCalculate())*(sCalculate() + qCalculate() -calculateXCentroid());
			return r;
		}else {
			double r = qCalculate() + (calculateXCentroid() - qCalculate())*(tCalculate() - qCalculate() +calculateXCentroid())/sCalculate();
					return r;
		}
			
	}
	
	public double hCalculate() {
		
		if((calculateXCentroid() - getMin()) > (getMax() - calculateXCentroid())){
			double h = calculateYCentroid()*(sCalculate() + qCalculate() - calculateXCentroid())/tCalculate();
			return h;
		}else {
			double h = calculateYCentroid() * (tCalculate() + calculateXCentroid() - qCalculate())/sCalculate();
			return h;
		}
	}
	
	public void checkCase() {
		
		if((calculateXCentroid() - getMin()) > (getMax() - calculateXCentroid())){
			System.out.println("Case 1");
			
		}else {
			System.out.println("Case 2");
		}
	}
	
	public void printData() {
		
		double k = calculateYCentroid();
		double h = hCalculate();
		double m = getMin();
		double n = calculateXCentroid();
		double r = rCalculate();
		double q = qCalculate();
		double p = getMax();
		double t = tCalculate();
		double s = sCalculate();
		
		checkCase();
		System.out.println("The values are: ");
		System.out.println("K: " + (k));
		System.out.println("H: " + (h));
		System.out.println("M: " + (m));
		System.out.println("N: " + (n));
		System.out.println("R: " + (r));
		System.out.println("Q: " + (q));
		System.out.println("P: " + (p));
		System.out.println("T: " + (t));
		System.out.println("S: " + (s));
		
		
	}
	
	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.add(new Graph());
//		f.setSize(400, 400);
//		f.setLocation(200, 200);
//		f.setVisible(true);
		
		Graph g = new Graph();
		g.printData();
		
	}
	
}
