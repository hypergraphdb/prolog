/*
 * tuProlog - Copyright (C) 2001-2004  aliCE team at deis.unibo.it
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package alice.tuprologx.ide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * An input field for the Java2 platform using Swing components.
 * 
 * @author	<a href="mailto:giulio.piancastelli@studio.unibo.it">Giulio Piancastelli</a>
 * @version	1.0 - 29-nov-02
 */

public class JavaInputField extends JPanel implements InputField {

    /** The input field used in the graphic interface. */
    private JTextField inputField;
    /** A store for the history of the requested goals. */
    private History history;
    /** The console referenced by this component. */
    private ThinletConsole console; // hopefully this will not needed soon...

    public JavaInputField() {
        inputField = new JTextField();
        inputField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {
                inputFieldKeyReleased(event);
            }
        });
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                solve();
            }
        });

        history = new History();

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("?- "), constraints);
        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(inputField, constraints);
    }

    /**
     * Listen to the keys pressed in the input field to provide an intuitive
     * mechanism for navigating through the history of the requested goals
     * using the up and down arrow keys.
     *
     * @param event The <code>java.awt.event.KeyEvent</code> occurred in the
     * input field.
     */
    private void inputFieldKeyReleased(KeyEvent event) {
        int code = event.getKeyCode();
        if (code == 38) // up arrow
        	inputField.setText(history.previous());
        else
        	if (code == 40) // down arrow
            	inputField.setText(history.next());
    }

    /**
     * Since the solve() method must be placed in this class, I need
     * a reference to the Console where output, solveInfo, tuProlog
     * engine and the ProcessInput thread are placed.
     *
     * This behaviour will change as soon as there will be no need of
     * separate input components for .NET and Java2, i.e. as soon as
     * the AltGr bug in Thinlet, preventing the use of italian keycombo
     * AltGr + '?' and AltGr + '+' to write '[' and ']', will be solved.
     */
    public void setConsole(ThinletConsole console) {
        this.console = console;
    }

    /**
     * Solve the goal currently displayed in the input field.
     */
    public void solve() {
        addGoalToHistory();
        console.solve();
    }

    public void addGoalToHistory() {
        history.add(getGoal());
    }

    public String getGoal() {
		return inputField.getText();
    }

    public void enableSolveCommands(boolean flag) {
        inputField.setEnabled(flag);
    }

} // end JavaInputField class