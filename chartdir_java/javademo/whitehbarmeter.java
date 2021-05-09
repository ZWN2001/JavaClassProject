import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ChartDirector.*;

public class whitehbarmeter implements DemoModule
{
    //Name of demo program
    public String toString() { return "White Horizontal Bar Meters"; }

    //Number of charts produced in this demo
    public int getNoOfCharts() { return 6; }

    //Main code for creating charts
    public void createChart(ChartViewer viewer, int chartIndex)
    {
        // The value to display on the meter
        double value = 75.35;

        // Create a LinearMeter object of size 260 x 80 pixels with very light grey (0xeeeeee)
        // backgruond and a light grey (0xccccccc) 3-pixel thick rounded frame
        LinearMeter m = new LinearMeter(260, 80, 0xeeeeee, 0xaaaaaa);
        m.setRoundedFrame(Chart.Transparent);
        m.setThickFrame(3);

        // Set the scale region top-left corner at (18, 24), with size of 222 x 20 pixels. The scale
        // labels are located on the top (implies horizontal meter)
        m.setMeter(18, 24, 222, 20, Chart.Top);

        // Set meter scale from 0 - 100, with a tick every 10 units
        m.setScale(0, 100, 10);

        // Demostrate different types of color scales
        double[] smoothColorScale = {0, 0x0000ff, 25, 0x0088ff, 50, 0x00ff00, 75, 0xdddd00, 100,
            0xff0000};
        double[] stepColorScale = {0, 0x00dd00, 50, 0xffff00, 80, 0xff0000, 100};
        double[] highLowColorScale = {0, 0x0000ff, 40, Chart.Transparent, 60, Chart.Transparent,
            100, 0xff0000};
        double[] highColorScale = {70, Chart.Transparent, 100, 0xff0000};

        if (chartIndex == 0) {
            // Add a blue (0x0088ff) bar from 0 to value with glass effect and 4 pixel rounded
            // corners
            m.addBar(0, value, 0x0088ff, Chart.glassEffect(Chart.NormalGlare, Chart.Top), 4);
            // Add a 5-pixel thick smooth color scale at y = 48 (below the meter scale)
            m.addColorScale(smoothColorScale, 48, 5);
        } else if (chartIndex == 1) {
             // Add a green (0x00cc00) bar from 0 to value with bar lighting effect
            m.addBar(0, value, 0x00cc00, Chart.barLighting());
            // Add a 5-pixel thick step color scale at y = 48 (below the meter scale)
            m.addColorScale(stepColorScale, 48, 5);
        } else if (chartIndex == 2) {
            // Add a purple (0x8833dd) bar from 0 to value with glass effect and 4 pixel rounded
            // corners
            m.addBar(0, value, 0x8833dd, Chart.glassEffect(Chart.NormalGlare, Chart.Top), 4);
            // Add a 5-pixel thick high/low color scale at y = 48 (below the meter scale)
            m.addColorScale(highLowColorScale, 48, 5);
        } else if (chartIndex == 3) {
              // Add an orange (0xff8800) bar from 0 to value with cylinder lighting effect
            m.addBar(0, value, 0xff8800, Chart.cylinderEffect());
            // Add a high only color scale at y = 48 (below the meter scale) with thickness varying
            // from 0 to 8
            m.addColorScale(highColorScale, 48, 0, 48, 8);
        } else if (chartIndex == 4) {
            // Add a red (0xee3333) bar from 0 to value with glass effect and 4 pixel rounded
            // corners
            m.addBar(0, value, 0xee3333, Chart.glassEffect(Chart.NormalGlare, Chart.Top), 4);
            // Add a 5-pixel thick smooth color scale at y = 48 (below the meter scale)
            m.addColorScale(smoothColorScale, 48, 5);
        } else {
            // Add a grey (0xaaaaaa) bar from 0 to value
            m.addBar(0, value, 0xaaaaaa);
            // Add a 5-pixel thick step color scale at y = 48 (below the meter scale)
            m.addColorScale(stepColorScale, 48, 5);
        }

        // Add a label right aligned to (243, 65) using 8pt Arial Bold font
        m.addText(243, 65, "Temperature C", "Arial Bold", 8, Chart.TextColor, Chart.Right);

        // Add a text box left aligned to (18, 65). Display the value using white (0xffffff) 8pt
        // Arial Bold font on a black (0x000000) background with depressed rounded border.
        TextBox t = m.addText(18, 65, m.formatValue(value, "2"), "Arial", 8, 0xffffff, Chart.Left);
        t.setBackground(0x000000, 0x000000, -1);
        t.setRoundedCorners(3);

        // Output the chart
        viewer.setChart(m);
    }

    //Allow this module to run as standalone program for easy testing
    public static void main(String[] args)
    {
        //Instantiate an instance of this demo module
        DemoModule demo = new whitehbarmeter();

        //Create and set up the main window
        JFrame frame = new JFrame(demo.toString());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);} });
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(800, 450);

        // Create the charts and put them in the content pane
        for (int i = 0; i < demo.getNoOfCharts(); ++i)
        {
            ChartViewer viewer = new ChartViewer();
            demo.createChart(viewer, i);
            frame.getContentPane().add(viewer);
        }

        // Display the window
        frame.setVisible(true);
    }
}

