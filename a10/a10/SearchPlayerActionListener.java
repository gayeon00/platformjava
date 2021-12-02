package com.fm.view;

import com.fm.controller.SearchPlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchPlayerActionListener implements ActionListener {
    private JTextField[] searchTermTextFields;
    private SearchPlayerController controller;

    public SearchPlayerActionListener(JTextField[] searchTermTextFields, SearchPlayerController controller) {
        super();
        this.searchTermTextFields = searchTermTextFields;
        this.controller = controller;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        List<SearchCondition> searchConditions = new ArrayList<>();
        for (JTextField i:searchTermTextFields) {
            if(!Objects.equals(i.getText(),"")) searchConditions.add(new SearchCondition(i.getName(),i.getText()));
        }
        controller.searchPlayer(searchConditions);
    }
}
