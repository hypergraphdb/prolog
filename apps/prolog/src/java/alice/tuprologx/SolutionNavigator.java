package alice.tuprologx;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import alice.tuprolog.NoMoreSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;

public class SolutionNavigator extends JPanel
{
	private static final long serialVersionUID = 169624993686059249L;
	
	private JLabel current;
	private JButton btnNext;
	private JButton btnPrev;
	private transient int pos = -1;
	private transient ArrayList<SolveInfo> solutions = new ArrayList<SolveInfo>();
	private transient Prolog engine;
	
	private static class NextAction implements ActionListener 
	{
		
		public void actionPerformed(ActionEvent e)
		{
			SolutionNavigator nav = (SolutionNavigator)((Component)e.getSource()).getParent();
			try
			{
				if (nav.pos < nav.solutions.size() - 1)
					nav.current.setText(nav.solutions.get(++nav.pos).toString());
				else
				{
					SolveInfo si = nav.engine.solveNext();
					nav.solutions.add(si);
					nav.current.setText(si.toString());
					nav.pos++;
				}
			}
			catch (NoMoreSolutionException ex)
			{
				nav.current.setText("No more");
			}
		}			
	}

	private static class PrevAction implements ActionListener 
	{
		
		public void actionPerformed(ActionEvent e)
		{
			SolutionNavigator nav = (SolutionNavigator)((Component)e.getSource()).getParent();
			if (nav.pos > 0)
				nav.current.setText(nav.solutions.get(--nav.pos).toString());
			else
				nav.current.setText("No more");
		}			
	}
	
	public SolutionNavigator()
	{		
	}
	
	public SolutionNavigator(SolveInfo solution, Prolog engine)
	{
		this.engine = engine;
		solutions.add(solution);
		pos = 0;
		current = new JLabel(solution.toString());
		btnNext = new JButton("Next Solution");
		btnNext.addActionListener(new NextAction());
		btnPrev = new JButton("Prev Solution");
		btnPrev.addActionListener(new PrevAction());
		this.add(current);
		this.add(btnNext);
		this.add(btnPrev);
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		layout.putConstraint(SpringLayout.WEST, btnNext, 10, SpringLayout.EAST, btnPrev);
		layout.putConstraint(SpringLayout.NORTH, current, 10, SpringLayout.SOUTH, btnPrev);
	}
}