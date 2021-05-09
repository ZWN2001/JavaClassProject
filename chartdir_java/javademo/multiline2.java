import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import ChartDirector.*;

public class multiline2 implements DemoModule
{
    //Name of demo program
    public String toString() { return "Multi-Line Chart (2)"; }

    //Number of charts produced in this demo
    public int getNoOfCharts() { return 1; }

    //Main code for creating charts
    public void createChart(ChartViewer viewer, int chartIndex)
    {
        // In this example, we simply use random data for the 3 data series.
        RanSeries r = new RanSeries(129);
        double[] data0 = r.getSeries(100, 100, -15, 15);
        double[] data1 = r.getSeries(100, 160, -15, 15);
        double[] data2 = r.getSeries(100, 220, -15, 15);
        Date[] timeStamps = r.getDateSeries(100, new GregorianCalendar(2014, 0, 1).getTime(), 86400)
            ;

        // Create a XYChart object of size 600 x 400 pixels
        XYChart c = new XYChart(600, 400);

        // Add a title box using grey (0x555555) 20pt Arial font
        c.addTitle("    Multi-Line Chart Demonstration", "Arial", 20, 0x555555);

        // Set the plotarea at (70, 70) and of size 500 x 300 pixels, with transparent background
        // and border and light grey (0xcccccc) horizontal grid lines
        c.setPlotArea(70, 70, 500, 300, Chart.Transparent, -1, Chart.Transparent, 0xcccccc);

        // Add a legend box with horizontal layout above the plot area at (70, 35). Use 12pt Arial
        // font, transparent background and border, and line style legend icon.
        LegendBox b = c.addLegend(70, 35, false, "Arial", 12);
        b.setBackground(Chart.Transparent, Chart.Transparent);
        b.setLineStyleKey();

        // Set axis label font to 12pt Arial
        c.xAxis().setLabelStyle("Arial", 12);
        c.yAxis().setLabelStyle("Arial", 12);

        // Set the x and y axis stems to transparent, and the x-axis tick color to grey (0xaaaaaa)
        c.xAxis().setColors(Chart.Transparent, Chart.TextColor, Chart.TextColor, 0xaaaaaa);
        c.yAxis().setColors(Chart.Transparent);

        // Set the major/minor tick lengths for the x-axis to 10 and 0.
        c.xAxis().setTickLength(10, 0);

        // For the automatic axis labels, set the minimum spacing to 80/40 pixels for the x/y axis.
        c.xAxis().setTickDensity(80);
        c.yAxis().setTickDensity(40);

        // Add a title to the y axis using dark grey (0x555555) 14pt Arial font
        c.yAxis().setTitle("Y-Axis Title Placeholder", "Arial", 14, 0x555555);

        // Add a line layer to the chart with 3-pixel line width
        LineLayer layer = c.addLineLayer2();
        layer.setLineWidth(3);

        // Add 3 data series to the line layer
        layer.addDataSet(data0, 0x5588cc, "Alpha");
        layer.addDataSet(data1, 0xee9944, "Beta");
        layer.addDataSet(data2, 0x99bb55, "Gamma");

        // The x-coordinates for the line layer
        layer.setXData(timeStamps);

        // Output the chart
        viewer.setChart(c);

        //include tool tip for the chart
        viewer.setImageMap(c.getHTMLImageMap("clickable", "",
            "title='[{x|mm/dd/yyyy}] {dataSetName}: {value}'"));
    }

    //Allow this module to run as standalone program for easy testing
    public static void main(String[] args)
    {
        //Instantiate an instance of this demo module
        DemoModule demo = new multiline2();

        //Create and set up the main window
        JFrame frame = new JFrame(demo.toString());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);} });
        frame.getContentPane().setBackground(Color.white);

        // Create the chart and put them in the content pane
        ChartViewer viewer = new ChartViewer();
        demo.createChart(viewer, 0);
        frame.getContentPane().add(viewer);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }
}

