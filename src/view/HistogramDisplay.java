/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Histogram;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author sauld
 */

public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    public void execute() {
        this.setVisible(true);
    }

    private JPanel createPanel() {
         ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
         chartPanel.setPreferredSize(new Dimension(500,400));
         return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", "Dominios email", "N� de emails", dataset, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataset.addValue(histogram.get(key),"",key);
        }
        return dataset;
    }
}
