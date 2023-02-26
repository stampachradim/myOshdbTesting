package com.mycompany.mavenproject1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import org.heigit.ohsome.oshdb.OSHDBTimestamp;
import org.heigit.ohsome.oshdb.util.celliterator.ContributionType;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class TutorialChart extends ApplicationFrame {

  private SortedMap<OSHDBTimestamp, Map<ContributionType, Integer>> dataset;

  public TutorialChart(
      String applicationTitle,
      String chartTitle,
      SortedMap<OSHDBTimestamp, Map<ContributionType, Integer>> result) {
    super(applicationTitle);
    this.dataset = result;
    JFreeChart barChart = ChartFactory.createBarChart(
        chartTitle,
        "Category",
        "Score",
        createDataset(),
        PlotOrientation.VERTICAL,
        true,
        true,
        false);
    ChartPanel chartPanel = new ChartPanel(barChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
    setContentPane(chartPanel);
  }

  private CategoryDataset createDataset() {
    DefaultCategoryDataset a = new DefaultCategoryDataset();
    Iterator<Map.Entry<OSHDBTimestamp, Map<ContributionType, Integer>>> it = this.dataset.entrySet()
        .iterator();
    while (it.hasNext()) {
      Map.Entry<OSHDBTimestamp, Map<ContributionType, Integer>> ff = it.next();
      Arrays.asList(ContributionType.values()).forEach((ContributionType contribType) -> a
          .addValue(ff.getValue().get(contribType), contribType, ff
              .getKey()));
    }
    return a;
  }
}

