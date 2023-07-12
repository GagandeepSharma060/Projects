import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Selection extends JPanel implements ActionListener {

	public static final long serialVersionUID = 1l;
    public boolean isRunning;
	private final int WIDTH = 1000, HEIGHT = WIDTH * 9 / 16;

	private final int SIZE = 50;
	private final float BAR_WIDTH = (float) WIDTH / SIZE;
	private float[] bar_height = new float[SIZE];
	private SwingWorker<Void, Void> shuffler, sorter;
	private int curr, trav, mini;
	public JButton start = new JButton("Start");
	JButton reset = new JButton("Reset");

	public Selection() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		initBarHeight();

		// this.setDefault

		 start.setBounds(100,20,50,20);
		start.setBackground(Color.BLACK);
		reset.setForeground(Color.WHITE);
		reset.setBackground(Color.BLACK);
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		reset.addActionListener(this);
		add(start);

		add(reset);

//							
	}

	private void initSorter() {

		sorter = new SwingWorker<>() {

			public Void doInBackground() throws InterruptedException {
				
				sort();
				return null;
			}

		};

	}

	public Void sort() throws InterruptedException {

		// int curr,trav;
		for (curr = 0; curr < SIZE && isRunning==true; curr++) {

			if(isRunning==false) { trav=SIZE-1; curr=SIZE-1; ;initShuffler();initBarHeight();repaint();break;}
			trav = curr + 1;

			mini = curr;
			while (trav < SIZE && isRunning==true) {
				if (bar_height[trav] < bar_height[mini]) {
					mini = trav;
					Thread.sleep(50);
					// repaint();

				}
				repaint();
				trav++;
				Thread.sleep(30);
				if(isRunning==false) {trav=SIZE-1; curr=SIZE-1; ;initShuffler();initBarHeight();repaint();break;}

			}

			swap(mini, curr);
			

		}
		curr = 0;
		trav = 0;

		return null;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.cyan);
		Rectangle2D.Float bar;
		for (int i = 0; i < SIZE; i++) {
			bar = new Rectangle2D.Float(i * BAR_WIDTH + 1, HEIGHT - bar_height[i], BAR_WIDTH - 2, bar_height[i]);
			g2d.fill(bar);

		}

		g2d.setColor(Color.white);
		bar = new Rectangle2D.Float(curr * BAR_WIDTH, HEIGHT - bar_height[curr], BAR_WIDTH - 2, bar_height[curr]);
		g2d.fill(bar);

						g2d.setColor(Color.WHITE);
						if(trav<SIZE) {
							bar= new Rectangle2D.Float(trav*BAR_WIDTH,HEIGHT - bar_height[trav], BAR_WIDTH, bar_height[trav]);
							g2d.fill(bar);
						}
	}

	private void initShuffler() {
		// TODO Auto-generated method stub
		shuffler = new SwingWorker<>() {

			public Void doInBackground() throws InterruptedException {
				int middle = SIZE / 2;

				for (int i = 0, j = middle; i < middle; i++, j++) {
					int random_index = new Random().nextInt(SIZE);
					swap(i, random_index);

					int random_index2 = new Random().nextInt(SIZE);
					swap(j, random_index);

					Thread.sleep(10);
					repaint();
				}

				return null;
			}

			public void done() {
				super.done();
				sorter.execute();
			}

		};
		shuffler.execute();
	}

	private void initBarHeight() {
		// TODO Auto-generated method stub
		float interval = (float) HEIGHT / SIZE;

		for (int i = 0; i < SIZE; i++) {
			bar_height[i] = i * interval;
		}

	}

	private void swap(int i, int j) {

		float temp = bar_height[i];
		bar_height[i] = bar_height[j];
		bar_height[j] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {

			JFrame frame = new JFrame("Selection Sort Visualization");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.setContentPane(new Selection());
			frame.validate();

			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			isRunning=true;
			initBarHeight();
			initShuffler();
			initSorter();

		} else {
           
			curr = SIZE - 1;
			trav = SIZE - 1;
		
			initBarHeight();
			

		}

	}

}
