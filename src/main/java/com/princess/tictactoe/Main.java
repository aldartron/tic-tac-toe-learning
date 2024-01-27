package com.princess.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Integer, JPanel> CELLS = new HashMap<>();

    public static void main(String[] args) {
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));

        // Формируем девять игровых ячеек, складываем их в мапу по порядковому номеру
        for (int i = 0; i < 9; i++) {
            JPanel cell = getCell(i);
            CELLS.put(i, cell);
            gamePanel.add(cell);
        }

        // Создаём и настраиваем главное окно
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(new Dimension(480, 480));
        frame.add(gamePanel);
    }

    private static JPanel getCell(int number) {
        CellPanel cell = new CellPanel(number);
        cell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // Рисуем крестик по клику
                cell.setState(CellState.X);
                cell.paintComponent(cell.getGraphics());
            }
        });
        return cell;
    }
}