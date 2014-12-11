package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class StepButtonListener implements ActionListener {
    private JList instructionList;

    public StepButtonListener(JList instructionList) {
        this.instructionList = instructionList;
    }

    public void actionPerformed(ActionEvent e) {

        //Bör nog flyttas, markerade raden bör bero på PC:n
        /*int selectedIndex = instructionList.getSelectedIndex();
        if (selectedIndex + 1 <= instructionList.getModel().getSize()) {
            instructionList.setSelectedIndex(selectedIndex + 1);
        }*/

        //Kör nästa instruktion här
    }
}
