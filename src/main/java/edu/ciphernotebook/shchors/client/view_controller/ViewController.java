package edu.ciphernotebook.shchors.client.view_controller;

import edu.ciphernotebook.shchors.client.models.FileItem;
import edu.ciphernotebook.shchors.client.view.View;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class ViewController {

    private final JFrame jFrame;
    private final View view;
    private String userName;

    public ViewController(View view) {
        this.view = view;
        userName = "";

        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setTitle("Cipher Notebook");
        jFrame.setSize(600, 400);

        var panel = new JPanel();
        var login = new JButton("login");
        var getFile = new JButton("get file");

        login.addActionListener(e -> {
            userName = view.userRequest();
            service.login(userName);
        });
        getFile.addActionListener(e -> {
            if("".equals(userName)){
                view.somethingErrorHappens();
            } else {
                var fileName = view.fileRequest();
                FileItem fileItem = service.getFileItem(userName, fileName);
                view.fileResponse(fileItem);
            }
        });

        panel.add(login);
        panel.add(getFile);
        jFrame.add(panel);
    }
}
