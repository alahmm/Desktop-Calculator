package swingwiththread;

import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Long running task");
        final JTextArea textArea = new JTextArea();
        final JProgressBar progressBar = new JProgressBar(0, 100);

        frame.add(label, BorderLayout.PAGE_START);
        frame.add(textArea);
        frame.add(progressBar, BorderLayout.PAGE_END);

        ProgressBarTask task = new ProgressBarTask(textArea, progressBar);
        task.execute();
        task.get();
        System.exit(0);
    }
}
class ProgressBarTask extends SwingWorker<Integer, Integer> {
    private int counter;
    private final JTextArea textArea;
    private final JProgressBar progressBar;

    ProgressBarTask(JTextArea textArea, JProgressBar progressBar) {
        this.textArea = textArea;
        this.progressBar = progressBar;
    }

    @Override
    public Integer doInBackground() throws Exception {
        while (counter < 100 && !isCancelled()) {
            Thread.sleep(100L);
            publish(counter++);

            setProgress(counter);
        }

        return counter;
    }

    @Override
    protected void process(List<Integer> chunks) {
        int value = chunks.get(0);

        textArea.setText("loading " + value + "%");
        progressBar.setValue(value);
    }
}