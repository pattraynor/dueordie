import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;
public class Chart extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Chart(String type, String ChartType, Patient tempPatient) {

		String Yaxis = "";
		if(type.equals(Globals.HEIGHT))
			Yaxis = "inches";
		else if(type.equals(Globals.WEIGHT))
			Yaxis = "lbs";
		else if(type.equals(Globals.BLOODSUGAR))
			Yaxis = "mg/dL";
	
		JFreeChart chart = null;
		CategoryDataset chartData;
		if (ChartType.equals(Globals.BARCHART)) {
			chartData = createChartData(type, tempPatient);
			chart = createBarChart(chartData, type, Yaxis);
		}
		if (ChartType.equals(Globals.BARCHART3D)) {
			chartData = create3DChartData(type, tempPatient);
			chart = create3DBarChart(chartData, type);
		}
		if (ChartType.equals(Globals.LINECHART)) {
			chartData = createChartData(type, tempPatient);
			chart = createLineChart(chartData, type, Yaxis);
		}

		ChartPanel chartPanel = new ChartPanel(chart, false);
		chartPanel.setPreferredSize(new Dimension(600, 320));
		setContentPane(chartPanel);

	}

	private JFreeChart create3DBarChart(CategoryDataset chartData, String type) {

		final JFreeChart chart = ChartFactory.createBarChart3D(type,
				"Date", "", chartData, PlotOrientation.HORIZONTAL,
				true, true, false);

		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setForegroundAlpha(1.0f);

		
		final CategoryAxis axis = plot.getDomainAxis();
		final CategoryLabelPositions p = axis.getCategoryLabelPositions();

		final CategoryLabelPosition left = new CategoryLabelPosition(
				RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT,
				TextAnchor.CENTER_LEFT, 0.0, CategoryLabelWidthType.RANGE,
				0.30f);
		axis.setCategoryLabelPositions(CategoryLabelPositions
				.replaceLeftPosition(p, left));

		return chart;

	}

	private JFreeChart createLineChart(CategoryDataset chartData, String type, String Yaxis) {

		
		final JFreeChart chart = ChartFactory
				.createLineChart(type, "Date", Yaxis, chartData,
						PlotOrientation.VERTICAL, true, true, false);

		chart.setBackgroundPaint(Color.white);

		final CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		categoryPlot.setBackgroundPaint(Color.lightGray);
		categoryPlot.setRangeGridlinePaint(Color.white);

		final NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);

		final LineAndShapeRenderer renderer = (LineAndShapeRenderer) categoryPlot
				.getRenderer();

		renderer.setSeriesStroke(0, new BasicStroke(2.0f,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 10.0f, 6.0f }, 0.0f));
		
		CategoryAxis domainAxis = categoryPlot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(Math.PI / 6.0));

		return chart;
	}

	private static JFreeChart createBarChart(CategoryDataset chartData,
			String type, String Yaxis) {
		
		//creates chart
		JFreeChart chart = ChartFactory.createBarChart(type, "Date",
				Yaxis, chartData, PlotOrientation.VERTICAL, true, true, false);

		// sets the background color for the chart
		chart.setBackgroundPaint(Color.white);

		// Customization
		CategoryPlot categoryPlot = chart.getCategoryPlot();
		categoryPlot.setBackgroundPaint(Color.lightGray);
		categoryPlot.setDomainGridlinePaint(Color.white);
		categoryPlot.setDomainGridlinesVisible(true);
		categoryPlot.setRangeGridlinePaint(Color.white);

		//sets the range axis to only display integers
		final NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		//disables bar outlines
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		barRenderer.setDrawBarOutline(false);

		//sets the color of the series
		GradientPaint newColor = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f,
				0.0f, new Color(20, 0, 0));
		barRenderer.setSeriesPaint(0, newColor);

		CategoryAxis domainAxis = categoryPlot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(Math.PI / 6.0));

		return chart;

	}

	private static CategoryDataset create3DChartData(String type,
			Patient currentPatient) {
		double[] data1 = null, data2 = null;
		String series1 = null, series2 = null;
		
		DefaultCategoryDataset chartData = new DefaultCategoryDataset();

		if (type.equals(Globals.BLOODPRESSURE)) {
			data1 = currentPatient.getMedicalRecord()
					.getBloodPressureTopChart();
			data2 = currentPatient.getMedicalRecord()
					.getBloodPressureBotChart();
			series1 = "Systolic";
			series2 = "Diastolic";
		}
		if (type.equals(Globals.HEIGHTWEIGHT)) {
			data1 = currentPatient.getMedicalRecord().getHeightChart();
			data2 = currentPatient.getMedicalRecord().getWeightChart();
			series1 = "Height";
			series2 = "Weight";
		}

		String[] dates = currentPatient.getMedicalRecord().getDates();
		int datesCount = dates.length -1;
		if (datesCount > 15) {
			datesCount = 15;
		}
		int index = 0;
		while (datesCount > index) {
			if (data1[index] > 0 && data2[index] > 0) 
			{
				chartData.addValue(data1[datesCount], series1, dates[datesCount]);
				chartData.addValue(data2[datesCount], series2, dates[datesCount]);
			}
			datesCount--;
		}

		return chartData;
	}

	private CategoryDataset createChartData(String type, Patient currentPatient) {
		DefaultCategoryDataset chartData = new DefaultCategoryDataset();
		
		double[] data = null, data2 = null;
		String series = null, series2 = null;
		
		if (type.equals(Globals.WEIGHT)) {
			data = currentPatient.getMedicalRecord().getWeightChart();
			series = "Weight";

		}
		if (type.equals(Globals.HEIGHT)) {
			data = currentPatient.getMedicalRecord().getHeightChart();
			series = "Height";
		}
		if (type.equals(Globals.BLOODSUGAR)) {
			data = currentPatient.getMedicalRecord().getSugarChart();
			series = "Blood Sugar";
		}
		if (type.equals(Globals.BLOODPRESSURE)) {
			data = currentPatient.getMedicalRecord()
					.getBloodPressureTopChart();
			data2 = currentPatient.getMedicalRecord()
					.getBloodPressureBotChart();
			series = "Systolic";
			series2 = "Diastolic";
		}
		if (type.equals(Globals.HEIGHTWEIGHT)) {
			data = currentPatient.getMedicalRecord().getHeightChart();
			data2 = currentPatient.getMedicalRecord().getWeightChart();
			series = "Height";
			series2 = "Weight";
		}

		String[] dates = currentPatient.getMedicalRecord().getDates();
		int datesCount = dates.length -1;
		if (datesCount > 15) {
			datesCount = 15;
		}
		int index = 0;
		while (datesCount > index) {
			
			if(type.equals(Globals.HEIGHTWEIGHT) || type.equals(Globals.BLOODPRESSURE))
			{
				if (data2[datesCount] > 0) 
				{
					
					chartData.addValue(data2[datesCount], series2, dates[datesCount]);

				}
			}
			
			if (data[datesCount] > 0) 
			{
				
				chartData.addValue(data[datesCount], series, dates[datesCount]);

			}
			
			datesCount--;
		}

		return chartData;

	}
	

}
