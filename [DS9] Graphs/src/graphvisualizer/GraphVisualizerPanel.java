package graphvisualizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class GraphVisualizerPanel<T> extends JPanel {

	private static final long serialVersionUID = 7400139117499271983L;
	
	private int width;
	private int height;
	
	private static final AffineTransform transform;
	private static Polygon arrowHead;
			
	static{
		
		transform = new AffineTransform();

		arrowHead = new Polygon();  
		arrowHead.addPoint( 0,5);
		arrowHead.addPoint( -5, -5);
		arrowHead.addPoint( 5,-5);
		
	}
	
	private Map<Node<T>, Ellipse2D.Double> positionOfNodes;
	
	private List<Node<T>> visitableNodes;
	
	private Node<T> startNode;
	
	private Node<T> selectedNode;
	
	private Graph<T> graph;
	
	private Map<Node<T>, List<Node<T>>> shortestPathsToNodes;
	
	private Map<Node<T>, Integer> distances;
	
	public GraphVisualizerPanel(Graph<T> graph, int w, int h){
	
		super();
		
		this.width = w;
		this.height = h;
			
		this.graph = graph;
		
		generatePositionOfNodes();
				
		this.addMouseListener(new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent e){
								
				for(Entry<Node<T>, Ellipse2D.Double> entry : positionOfNodes.entrySet()){
					
					if(entry.getValue().contains(e.getPoint())){
						
						selectedNode = entry.getKey();
												
					}
					
				}
								
			}
			
			@Override
			public void mouseReleased(MouseEvent e){
				
				selectedNode = null;
				
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter(){
			
			@Override
			public void mouseDragged(MouseEvent e){
								
				if(selectedNode != null){
										
					positionOfNodes.put(selectedNode, new Ellipse2D.Double(e.getX() - 25, e.getY() - 25, 50, 50));
										
					repaint();
										
				}
				
				
			}
			
		});
		
	}
	
	public GraphVisualizerPanel(Graph<T> graph){
		
		this(graph, 900, 900);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
						
		for(Node<T> node : graph.getNodes()){
		
			for(Edge<T> e : graph.getAdjacentEdges(node)){
				
				Node<T> neighbor = e.getTo();
				
				int fromX = (int) positionOfNodes.get(node).getX() + 25;
				int fromY = (int) positionOfNodes.get(node).getY() + 25;
				
				int toX = (int) positionOfNodes.get(neighbor).getX() + 25;
				int toY = (int) positionOfNodes.get(neighbor).getY() + 25;
				
				// Shorten the line
				int dx = toX - fromX;
				int dy = toY - fromY;
				
				double length = Math.sqrt(dx * dx + dy * dy);
				double percentShorten = 1 - (length - 25) / length + 0.02;
				
				int resizedToX = toX - (int) (dx * percentShorten);
				int resizedToY = toY - (int) (dy * percentShorten);
				
				Color c = null;
				
				if(visitableNodes != null && visitableNodes.contains(node) && visitableNodes.contains(neighbor)){
					
					c = new Color(45, (int) (((float) (visitableNodes.size() - visitableNodes.indexOf(node)) / visitableNodes.size()) * 230), 45);
					
				}
				
				else{
					
					c = Color.BLACK;
					
				}
								
				drawEdge((Graphics2D) g, fromX, fromY, resizedToX, resizedToY, e.getWeight(), c);
							
			}
		
		}
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		for(Entry<Node<T>, Ellipse2D.Double> entry : positionOfNodes.entrySet()){
			
			if(visitableNodes != null && visitableNodes.contains(entry.getKey())){
												
				g.setColor(new Color(45, (int) (((float) (visitableNodes.size() - visitableNodes.indexOf(entry.getKey())) / visitableNodes.size()) * 230), 45));
				
			}
			
			else{
				
				g.setColor(Color.BLACK);
				
			}
			
			if(startNode != null && startNode.equals(entry.getKey())){
				
				g.setColor(new Color(0, 230, 0));
				
			}
			
			if((visitableNodes != null && startNode != null) && !visitableNodes.contains(entry.getKey()) && !startNode.equals(entry.getKey())){
				
				g.setColor(Color.BLACK);
				
			}
			
			g.fillOval((int) entry.getValue().getX(), (int) entry.getValue().getY(), 50, 50);
			g.setColor(Color.WHITE);
			g.drawString(entry.getKey().getData().toString(), (int) entry.getValue().getX() + 25 - (g.getFontMetrics().stringWidth(entry.getKey().getData().toString()) / 2), (int) entry.getValue().getY() + (distances != null && shortestPathsToNodes != null ? 10 : 20) + (g.getFontMetrics().getHeight() / 2));
						
		}
		
		if(visitableNodes != null){
			
			g.drawString(visitableNodes.toString(), 5, 20);
			
		}
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		
		if(distances != null && shortestPathsToNodes != null){
			
			for(Entry<Node<T>, Integer> entry : distances.entrySet()){
				
				g.drawString("Distance: " + entry.getValue(), (int) positionOfNodes.get(entry.getKey()).getX() + 25 - (g.getFontMetrics().stringWidth("Distance: " + entry.getValue()) / 2), (int) positionOfNodes.get(entry.getKey()).getY() + 23 + (g.getFontMetrics().getHeight() / 2));
				g.drawString("Path: " + shortestPathsToNodes.get(entry.getKey()), (int) positionOfNodes.get(entry.getKey()).getX() + 25 - (g.getFontMetrics().stringWidth("Path: " + shortestPathsToNodes.get(entry.getKey())) / 2), (int) positionOfNodes.get(entry.getKey()).getY() + 30 + (g.getFontMetrics().getHeight() / 2));
				
			}
			
		}
								
	}

	private void drawEdge(Graphics2D g2d, int fromX, int fromY, int toX, int toY, int weight, Color c) { 
		
		g2d.setColor(c);
	    g2d.drawLine(fromX, fromY, toX, toY);
	    Line2D.Double line = new Line2D.Double(fromX, fromY, toX, toY);
		
		transform.setToIdentity();
	    double angle = Math.atan2(line.y2 - line.y1, line.x2 - line.x1);
	    transform.translate(line.x2, line.y2);
	    transform.rotate((angle - Math.PI / 2d));
	    
	    Graphics2D g = (Graphics2D) g2d.create();
	    g.setTransform(transform);   
	    g.fill(arrowHead);
	    g.dispose();
	    
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    g2d.setColor(Color.BLACK);
	    g2d.drawString(weight + "", ((fromX + toX) / 2) - (g2d.getFontMetrics().stringWidth(weight + "") / 2), ((fromY + toY) / 2) - (g2d.getFontMetrics().getHeight() / 2));
	    
	}
	
	private void generatePositionOfNodes(){
		
		positionOfNodes = new HashMap<>();
		
		double deltaAngle = (2 * Math.PI) / graph.getNumberOfNodes();
		
		double angle = 0;
						
		for(Node<T> node : graph.getNodes()){
			
			double cartesianX = ((width / 2) - 55) * Math.cos(angle);
			double cartesianY = ((height / 2) - 55) * Math.sin(angle);
			
			int graphicsX = (int) (cartesianX + (width / 2) - 25);
			int graphicsY = (int) (cartesianY + (height / 2) - 25);
			
			positionOfNodes.put(node, new Ellipse2D.Double(graphicsX, graphicsY, 50, 50));
						
			angle += deltaAngle;
			
		}
		
	}
	
	public void updateSize(int w, int h){
		
		width = w;
		height = h;
				
		generatePositionOfNodes();
				
	}

	public void setVisitableNodes(List<Node<T>> nodes) {

		visitableNodes = nodes;
		
	}

	public void setStart(Node<T> start) {

		startNode = start;
		
	}
	
	public void setPathsAndDistances(Map<Node<T>, List<Node<T>>> paths, Map<Node<T>, Integer> distances){
		
		this.distances = distances;
		this.shortestPathsToNodes = paths;
		
	}
	

}
