package com.princess.tictactoe;

import javax.swing.*;
import java.awt.*;

/**
 * Класс конкретной ячейки, наследует панель
 */
public class CellPanel extends JPanel {
    /**
     * Текущее состояние ячейки
     */
    private CellState state = CellState.EMPTY;
    /**
     * Порядковый номер ячейки
     */
    private final int number;

    public CellPanel(int number) {
        this.number = number;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    /**
     * Переопределяем функцию отрисовки панели, чтобы ячейка отрисовывала
     * нужную фигуру согласно текущему состоянию ячейки
     */
    @Override
    protected void paintComponent(Graphics g) {
        this.setBorder(BorderFactory.createLineBorder(Color.gray));
        super.paintComponent(g);
        switch (getState()) {
            case X -> drawX(g);
            case O -> drawO(g);
            case EMPTY -> clear(g);
        }
    }

    /**
     * Использует экземпляр графики, чтобы нарисовать крестик в пределах ячейки
     */
    private void drawX(Graphics g) {
        g.setColor(Color.red); // Задаём красный цвет
        ((Graphics2D) g).setStroke(new BasicStroke(4)); // Устанавливаем толщину кисти

        int widthPadding = this.getWidth() / 3; // Вычисляем сколько нужно отступить от левого края
        int heightPadding = this.getHeight() / 3; // Вычисляем сколько нужно отступить сверху

        // Рисуем две пересекающиеся линии
        g.drawLine(
                widthPadding,
                heightPadding,
                this.getWidth() - widthPadding,
                this.getHeight() - heightPadding
        );
        g.drawLine(
                this.getWidth() - widthPadding,
                heightPadding,
                widthPadding, this.getHeight() - heightPadding
        );
    }

    private void drawO(Graphics g) {
        // TODO по аналогии с методом drawX эта функция должна нарисовать кружок, используя g#drawOval
    }

    private void clear(Graphics g) {
        // TODO очистить содержимое ячейки
    }
}
