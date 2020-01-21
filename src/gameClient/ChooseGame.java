package gameClient;

import javax.swing.*;

public class ChooseGame {
    public static void main(String[] args) {
        Object[] options = {"Manual game", "Auto Drive"};
        int n = JOptionPane.showOptionDialog(null, "which game would you like to play?", "CHOOSE",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);
        if (n == 0) {
            MyGameGUI gameGUI;
            gameGUI = new MyGameGUI();
        } else {
            AutoDrive game1;
            game1 = new AutoDrive();
        }
    }
}
