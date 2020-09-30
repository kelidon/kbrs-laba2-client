package edu.ciphernotebook.shchors.client.view;

import edu.ciphernotebook.shchors.client.models.FileItem;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class View {

    private final JFrame jFrame;

    public View() {
        jFrame = new JFrame();
        jFrame.setVisible(false);
        jFrame.setAlwaysOnTop(true);
    }

    public String userRequest(){
        return Objects.requireNonNull(JOptionPane
                .showInputDialog(jFrame, "input urself"));
    }

    public String fileRequest(){
        return Objects.requireNonNull(JOptionPane
                .showInputDialog(jFrame, "u wonna file?"));
    }

    public void fileResponse(FileItem fileItem) {
        JTextArea textArea = new JTextArea(fileItem.getData());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(jFrame, new JScrollPane(textArea), fileItem.getName(),
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void somethingErrorHappens(){
        JOptionPane.showMessageDialog(jFrame, "Something error happens");
    }
}
