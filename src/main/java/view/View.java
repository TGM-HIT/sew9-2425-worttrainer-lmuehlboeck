package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

/**
 * View class for the WordTrainer application.
 * @author Leo Mühlböck
 * @version 2024-09-21
 */
public class View extends JFrame {
    private final Controller controller;

    private final JTextField tfWord;
    private final JLabel lImage, lNumRight, lNumAsked, lLastResult;

    /**
     * Creates a new View object.
     * @param controller the controller to use
     */
    public View(Controller controller) {
        if(controller == null) throw new IllegalArgumentException();
        this.controller = controller;

        this.setLayout(new BorderLayout(20, 20));
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel lInstruction = new JLabel("Welches Wort wird unten dargestellt?", SwingConstants.CENTER);
        tfWord = new JTextField();
        tfWord.addActionListener(l -> controller.check(tfWord.getText()));
        JPanel top = new JPanel(new BorderLayout(5, 5));
        top.add(lInstruction, BorderLayout.PAGE_START);
        top.add(tfWord, BorderLayout.PAGE_END);
        this.add(top, BorderLayout.PAGE_START);

        lImage = new JLabel();
        lImage.setHorizontalAlignment(JLabel.CENTER);
        lImage.setVerticalAlignment(JLabel.CENTER);
        this.add(lImage, SwingConstants.CENTER);

        JLabel lRight = new JLabel(new String("Anzahl richtige Wörter:".getBytes(), StandardCharsets.UTF_8), SwingConstants.RIGHT);
        JLabel lAsked = new JLabel(new String("Anzahl abefragte Wörter:".getBytes(), StandardCharsets.UTF_8), SwingConstants.RIGHT);
        JLabel lResult = new JLabel(new String("Letztes Ergebnis:".getBytes(), StandardCharsets.UTF_8), SwingConstants.RIGHT);

        lNumAsked = new JLabel("0");
        lNumRight = new JLabel("0");
        lLastResult = new JLabel("0");

        JPanel bottom = new JPanel(new GridLayout(2, 2, 5, 5));
        bottom.add(lRight);
        bottom.add(lNumRight);
        bottom.add(lAsked);
        bottom.add(lNumAsked);
        bottom.add(lResult);
        bottom.add(lLastResult);

        this.add(bottom, BorderLayout.PAGE_END);

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                controller.save();
                e.getWindow().dispose();
            }
        });
        this.pack();
        this.setBounds(300, 100, 1000, 600);
        this.setVisible(true);
    }

    /**
     * Sets the number of asked and right entries.
     * @param asked the number of asked entries
     * @param right the number of right entries
     */
    public void setNum(int asked, int right) {
        lNumAsked.setText(Integer.toString(asked));
        lNumRight.setText(Integer.toString(right));
    }

    /**
     * Sets the image.
     * @param url the url of the image
     */
    public void setImg(String url) {
        try {
            URI u = new URI(url);
            Image img = ImageIO.read(u.toURL());
            lImage.setIcon(new ImageIcon(img));
        } catch (IOException | URISyntaxException | NullPointerException ignored) { }
    }

    /**
     * Sets the input.
     * @param input the input to set
     */
    public void setInput(String input) {
        tfWord.setText(input);
    }

    /**
     * Sets the last result.
     * @param result the result to set
     */
    public void setLastResult(boolean result) {
        lLastResult.setText(result ? "Richtig" : "Falsch");
    }
}
