package com.fm.view;

import com.fm.controller.SearchPlayerController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class SearchPlayerView  extends JFrame {
    JLabel nameLabel, clubLabel, posLabel, nationLabel;
    JTextField name, club, position, nationality ;
    JButton createBtn, deleteBtn, Search;
    JScrollPane pane;
    JPanel panel;
    JTable table;

    public SearchPlayerView(SearchPlayerController controller, DefaultTableModel model){
        //윗부분
        panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        nameLabel = new JLabel("name");
        clubLabel = new JLabel("club");
        posLabel = new JLabel("position");
        nationLabel = new JLabel("nationality");

        name = new JTextField();
        name.setName("name");
        club = new JTextField();
        club.setName("club");
        position = new JTextField();
        position.setName("position");
        nationality = new JTextField();
        nationality.setName("nationality");

        createBtn = new JButton("Create");
        deleteBtn = new JButton("Delete");
        Search = new JButton("Search");
        Search.setName("Search");

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatePlayerDialog createPlayerDialog = new CreatePlayerDialog(SearchPlayerView.this,controller);
                createPlayerDialog.setVisible(true);
            }
        });
        deleteBtn.addActionListener(new DeletePlayerActionListener(table,controller));
        Search.addActionListener(new SearchPlayerActionListener(new JTextField[]{name,club,position,nationality},controller));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        panel.add(nameLabel,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(clubLabel,gbc);

        gbc.gridx = 0;
        gbc.gridy=2;
        panel.add(posLabel,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(nationLabel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        panel.add(name,gbc);

        gbc.gridy = 1;
        panel.add(club,gbc);

        gbc.gridy = 2;
        panel.add(position,gbc);

        gbc.gridy = 3;
        panel.add(nationality,gbc);
        JPanel anotPan = new JPanel();
        anotPan.setLayout(new GridLayout(1,3,5,5));
        anotPan.add(createBtn);
        anotPan.add(deleteBtn);
        anotPan.add(Search);

        gbc.gridy = 4;
        panel.add(anotPan,gbc);


        //표
        table = new JTable();
        table.setName("foundPlayer");
        table.setModel(model);
        table.setRowHeight(24);
//        table.setPreferredScrollableViewportSize(new Dimension(800,1000));

        pane = new JScrollPane(table);
        add(pane, BorderLayout.SOUTH);

    }

    public class CreatePlayerDialog extends JDialog {
        String[] fields;
        JTextField nameField, heightField, nationalityField, clubField, overallField, positionField;
        JPanel pane;

        public CreatePlayerDialog(JFrame frame,SearchPlayerController controller) {
            super(frame);
            pane = new JPanel();
            pane.setLayout(new GridLayout(6,2,10,10));

            nameField = new JTextField(); heightField= new JTextField(); nationalityField = new JTextField();
            clubField = new JTextField(); overallField = new JTextField(); positionField = new JTextField();

            pane.add(new JLabel("Name"));        pane.add(nameField);
            pane.add(new JLabel("Height"));      pane.add(heightField);
            pane.add(new JLabel("Nationality")); pane.add(nationalityField);
            pane.add(new JLabel("Club"));        pane.add(clubField);
            pane.add(new JLabel("Overall"));     pane.add(overallField);
            pane.add(new JLabel("Positions"));   pane.add(positionField);

            int option = JOptionPane.showConfirmDialog(frame, pane, "Create a Player",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.YES_OPTION){
                fields = new String[]{nameField.getText(), heightField.getText(), nationalityField.getText(), clubField.getText(), overallField.getText(), positionField.getText()};
                controller.createPlayer(fields);
            }
        }
    }

    public class DeletePlayerActionListener implements ActionListener {
        private JTable foundPlayer;
        private SearchPlayerController controller;

        public DeletePlayerActionListener(JTable foundPlayer, SearchPlayerController controller) {
            super();
            this.foundPlayer = foundPlayer;
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel)foundPlayer.getModel();
            Object selectedRow = model.getDataVector().get(foundPlayer.getSelectedRow());
            int playerID = ((Integer) ((Vector) selectedRow).get(0)).intValue();
            SearchPlayerController.deletePlayer(playerID);
        }
    }

}




