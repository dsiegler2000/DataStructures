package graphvisualizer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import graph.Graph;
import graph.Node;

public class GraphVisualizer<T> extends JFrame {

	private static final long serialVersionUID = 4196353452912601760L;
	
	private static final int WIDTH = 900;
	private static final int HEIGHT = 900;
	
	private GraphVisualizerPanel<T> p;
	
	public GraphVisualizer(Graph<T> g){
		
		super("Graph Visualizer");
				
		this.setSize(WIDTH, HEIGHT);
		
		p = new GraphVisualizerPanel<T>(g);
		p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.add(p, BorderLayout.CENTER);
		this.pack();
		
		this.addComponentListener(new ComponentAdapter(){

			@Override
			public void componentResized(ComponentEvent e) {

				p.updateSize(getWidth(), getHeight());
				repaint();
				
			}
			
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setVisitableNodes(List<Node<T>> nodes){
		
		p.setVisitableNodes(nodes);
		
	}
	
	public void setStart(Node<T> start){
		
		p.setStart(start);
		
	}
	
	public void setPathsAndDistances(Map<Node<T>, List<Node<T>>> paths, Map<Node<T>, Integer> distances){
		
		p.setPathsAndDistances(paths, distances);
		
	}
	
}