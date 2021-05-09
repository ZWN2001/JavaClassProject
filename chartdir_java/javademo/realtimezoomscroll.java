import ChartDirector.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;


public class realtimezoomscroll implements DemoModule
{
	//
	// The main method to allow this demo to run as a standalone program.
	//
	public static void main(String args[]) 
	{
		new realtimezoomscrollDialog().setVisible(true);
		System.exit(0); 
	} 
    
	//
	// Implementation of the DemoModule interface to allow this demo to run inside the 
	// ChartDirectorDemo browser
	//
    
	// Name of demo program
	public String toString() 
	{ 
		return "Realtime Chart with Zoom/Scroll"; 
	}

	// Number of charts produced in this demo
	public int getNoOfCharts() 
	{ 
		// This demo open its own dialog instead of using the right pane of the ChartDirectorDemo 
		// browser for display, so we just display the dialog, and return 0.
		new realtimezoomscrollDialog().setVisible(true);
		return 0; 
	}

	// Main code for creating charts
	public void createChart(ChartViewer viewer, int index)
	{
		// do nothing, as the ChartDirectorDemo browser right pane is not used
	}
}


class realtimezoomscrollDialog extends JDialog
{
	//
	// Data to draw the chart. In this demo, the data buffer will be filled by a data generator,
	// triggered to run by a timer every 250ms. We plot the last 240 samples.
	//
	private final int dataInterval = 250;
	private final int sampleSize = 10000;
	private Date[] timeStamps = new Date[sampleSize];
	private double[] dataSeriesA = new double[sampleSize];
	private double[] dataSeriesB = new double[sampleSize];
	private double[] dataSeriesC = new double[sampleSize];

	// The index of the array position to which new data values are added.
	private int currentIndex = 0;

	// The full range is initialized to 60 seconds of data. It can be extended when more data
	// are available.
	private int initialFullRange = 60;

	// The maximum zoom in is 10 seconds.
	private int zoomInLimit = 10;

	// This is an internal variable used by the real time random number generator so it knows what
	// timestamp should be used for the next data point.
	private Date nextDataTime;
	
	// This flag is used to suppress event handlers before complete initialization
	private boolean hasFinishedInitialization;

	//
	// Controls
	//
	private JButton pointerPB;
	private JButton zoomInPB;
	private JButton zoomOutPB;
	private JComboBox samplePeriod;
	private JTextField valueA;
	private JTextField valueB;
	private JTextField valueC;
	private ChartViewer chartViewer1;
	private JScrollBar hScrollBar1;
	private javax.swing.Timer dataRateTimer;
	private javax.swing.Timer chartUpdateTimer;
	private JFileChooser saveDialog;

	//
	// Constructor
	//
	realtimezoomscrollDialog() 
	{
		// Use DISPOSE_ON_CLOSE to avoid mmeory leak, and set dialog to modal and non-resizable
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		
		// Set title to name of this demo program
		setTitle("Realtime Chart with Zoom/Scroll");

		// Initialize the internal variable used by our random real time data generator.
		nextDataTime = new Date((new Date().getTime()) / 1000 * 1000);

	   // Font to use for user interface elements
		Font uiFont = new Font("Dialog", Font.PLAIN, 11);

		// Top label bar
		JLabel topLabel = new JLabel("Advanced Software Engineering");
		topLabel.setForeground(new Color(255, 255, 51));
		topLabel.setBackground(new Color(0, 0, 128));
		topLabel.setBorder(new javax.swing.border.EmptyBorder(2, 0, 2, 5));
		topLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		topLabel.setOpaque(true);
		getContentPane().add(topLabel, BorderLayout.NORTH);

		// Left panel
		JPanel leftPanel = new JPanel(null);
		leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		// Pointer push button
		pointerPB = new JButton("Pointer", loadImageIcon("pointer.gif"));
		pointerPB.setHorizontalAlignment(SwingConstants.LEFT);
		pointerPB.setMargin(new Insets(5, 5, 5, 5));
		pointerPB.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)	{
				pointerPB_Clicked();
			}});
		leftPanel.add(pointerPB).setBounds(1, 0, 118, 24);
        
		// Zoom In push button
		zoomInPB = new JButton("Zoom In", loadImageIcon("zoomin.gif"));
		zoomInPB.setHorizontalAlignment(SwingConstants.LEFT);
		zoomInPB.setMargin(new Insets(5, 5, 5, 5));
		zoomInPB.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)	{
				zoomInPB_Clicked();
			}});		
		leftPanel.add(zoomInPB).setBounds(1, 24, 118, 24);

		// Zoom out push button
		zoomOutPB = new JButton("Zoom Out", loadImageIcon("zoomout.gif"));
		zoomOutPB.setHorizontalAlignment(SwingConstants.LEFT);
		zoomOutPB.setMargin(new Insets(5, 5, 5, 5));
		zoomOutPB.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)	{
				zoomOutPB_Clicked();
			}});		
		leftPanel.add(zoomOutPB).setBounds(1, 48, 118, 24);

		// Save push button
		JButton savePB = new JButton("Save", loadImageIcon("save.gif"));
		savePB.setHorizontalAlignment(SwingConstants.LEFT);
		savePB.setMargin(new Insets(5, 5, 5, 5));
		savePB.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				savePB_Clicked();
			}});        
		leftPanel.add(savePB).setBounds(1, 96, 118, 24);
	
		// Update Period label
		leftPanel.add(new JLabel("Update Period (ms)")).setBounds(4, 160, 110, 20);

		// Update Period drop down list box
		samplePeriod = new JComboBox(new Object[] { "250", "500", "750", "1000", "1250", "1500",
			"1750", "2000" });
		samplePeriod.setSelectedItem("1000");
		samplePeriod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				samplePeriod_ValueChanged(evt);
			}});
		leftPanel.add(samplePeriod).setBounds(4, 180, 112, 20);

		// Simulated Machine label
		leftPanel.add(new JLabel("Simulated Machine")).setBounds(4, 250, 112, 20);

		// Alpha Label
		JLabel alphaLabel = new JLabel("Alpha");
		alphaLabel.setFont(uiFont);
		leftPanel.add(alphaLabel).setBounds(4, 270, 55, 20);

		// Alpha value
		valueA = new JTextField();
		valueA.setEditable(false);
		leftPanel.add(valueA).setBounds(60, 270, 56, 20);

		// Beta label
		JLabel betaLabel = new JLabel("Beta");
		betaLabel.setFont(uiFont);
		leftPanel.add(betaLabel).setBounds(4, 290, 55, 20);

		// Beta value
		valueB = new JTextField();
		valueB.setEditable(false);
		leftPanel.add(valueB).setBounds(60, 290, 56, 20);

		// Gamma label
		JLabel gammaLabel = new JLabel("Gamma");
		gammaLabel.setFont(uiFont);
		leftPanel.add(gammaLabel).setBounds(4, 310, 55, 20);

		// Gamma value
		valueC = new JTextField();
		valueC.setEditable(false);
		leftPanel.add(valueC).setBounds(60, 310, 56, 20);

		// Total expected panel size
		leftPanel.setPreferredSize(new Dimension(120, 360));

		// Chart Viewer
		chartViewer1 = new ChartViewer();
		chartViewer1.setBackground(new Color(255, 255, 255));
		chartViewer1.setOpaque(true);
		chartViewer1.setPreferredSize(new Dimension(640, 350));
		chartViewer1.setHorizontalAlignment(SwingConstants.CENTER);
		chartViewer1.addViewPortListener(new ViewPortAdapter() {
			public void viewPortChanged(ViewPortChangedEvent e) {
				chartViewer1_viewPortChanged(e);
			}
		});	
		chartViewer1.addTrackCursorListener(new TrackCursorAdapter() {
			public void mouseMovedPlotArea(MouseEvent e) {
				chartViewer1_MouseMovedPlotArea(e);
			}
		});

		// Horizontal Scroll bar
		hScrollBar1 = new JScrollBar(JScrollBar.HORIZONTAL, 0, 100000000, 0, 1000000000);
		hScrollBar1.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				hScrollBar1_ValueChanged();		 
			}
		});

		// Put the ChartViewer and the scroll bars in the right panel
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.add(chartViewer1, java.awt.BorderLayout.CENTER);
		rightPanel.add(hScrollBar1, java.awt.BorderLayout.SOUTH);
		
		// Put the leftPanel and rightPanel on the content pane
		getContentPane().add(leftPanel, java.awt.BorderLayout.WEST);
		getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);
		
		// Set all UI fonts (except labels) to uiFont
		for (int i = 0; i < leftPanel.getComponentCount(); ++i)
		{
			Component c = leftPanel.getComponent(i);
			if (!(c instanceof JLabel))
				c.setFont(uiFont);
		}

		// The data generation timer for our random number generator
		dataRateTimer = new javax.swing.Timer(dataInterval, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dataRateTimer_Tick();
			}
		});

		// The chart update timer
		chartUpdateTimer = new javax.swing.Timer(
			Integer.parseInt((String)samplePeriod.getSelectedItem()), new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chartUpdateTimer_Tick();
			}
		});
		
		// Layout the window
		pack();
		
		// Initialize the ChartViewer
		initChartViewer(chartViewer1);
		
		// It is safe to handle events now.
		hasFinishedInitialization = true;

		// Start collecting and plotting data
		dataRateTimer.start();
		chartUpdateTimer.start();
	}
	
	//
	// A utility to load an image icon from the Java class path
	//
	private ImageIcon loadImageIcon(String path)
	{
		try { return new ImageIcon(getClass().getClassLoader().getResource(path)); }
		catch (Exception e) { return null; }
	}

	//
	// Initialize the WinChartViewer
	//
	private void initChartViewer(ChartViewer viewer)
	{
		// Enable mouse wheel zooming by setting the zoom ratio to 1.1 per wheel event
		viewer.setMouseWheelZoomRatio(1.1);
	
		// Initially set the mouse usage to "Pointer" mode (Drag to Scroll mode)
		pointerPB.doClick();
	}

	//
	// The data update routine. In this demo, it is invoked every 250ms to get new data.
	//
	private void dataRateTimer_Tick()
	{
		Date now = new Date();
		do
		{
			//
			// In this demo, we use some formulas to generate new values. In real applications,
			// it may be replaced by some data acquisition code.
			//
			double p = nextDataTime.getTime() / 1000.0 * 4;
			double dataA = 20 + Math.cos(p * 2.2) * 10 + 1 / (Math.cos(p) * Math.cos(p) + 0.01);
			double dataB = 150 + 100 * Math.sin(p / 27.7) * Math.sin(p / 10.1);
			double dataC = 150 + 100 * Math.cos(p / 6.7) * Math.cos(p / 11.9);

			// In this demo, if the data arrays are full, the oldest 5% of data are discarded.
			if (currentIndex >= timeStamps.length)
			{
				currentIndex = sampleSize * 95 / 100 - 1;
				System.arraycopy(timeStamps, sampleSize - currentIndex, timeStamps, 0, currentIndex);
				System.arraycopy(dataSeriesA, sampleSize - currentIndex, dataSeriesA, 0, currentIndex);
				System.arraycopy(dataSeriesB, sampleSize - currentIndex, dataSeriesB, 0, currentIndex);
				System.arraycopy(dataSeriesC, sampleSize - currentIndex, dataSeriesC, 0, currentIndex);
			}

			// Store the new values in the current index position, and increment the index.
			timeStamps[currentIndex] = nextDataTime;
			dataSeriesA[currentIndex] = dataA;
			dataSeriesB[currentIndex] = dataB;
			dataSeriesC[currentIndex] = dataC;
			++currentIndex; 

			// Update nextDataTime
			nextDataTime = new Date(nextDataTime.getTime() + dataInterval);;
		}
		while (nextDataTime.before(now));

		// We provide some visual feedback to the numbers generated, so you can see the
		// data being updated.
		valueA.setText("" + Math.round(dataSeriesA[currentIndex - 1] * 100) / 100.0);
		valueB.setText("" + Math.round(dataSeriesB[currentIndex - 1] * 100) / 100.0);
		valueC.setText("" + Math.round(dataSeriesC[currentIndex - 1] * 100) / 100.0);
	}

	//
	// The chartUpdateTimer Tick event - this updates the chart periodicially by raising
	// viewPortChanged events.
	//
	private void chartUpdateTimer_Tick()
	{
		ChartViewer viewer = chartViewer1;

		if (currentIndex >= 0)
		{
			//
			// As we added more data, we may need to update the full range. 
			//

			Date startDate = timeStamps[0];
			Date endDate = timeStamps[currentIndex - 1];

			// Use the initialFullRange if this is sufficient.
			double duration = endDate.getTime() - startDate.getTime();
			if (duration < initialFullRange * 1000)
				endDate = new Date(startDate.getTime() + initialFullRange * 1000);

			// Update the full range to reflect the actual duration of the data. In this case, 
			// if the view port is viewing the latest data, we will scroll the view port as new
			// data are added. If the view port is viewing historical data, we would keep the 
			// axis scale unchanged to keep the chart stable.
			int updateType = Chart.ScrollWithMax;
			if (viewer.getViewPortLeft() + viewer.getViewPortWidth() < 0.999)
				updateType = Chart.KeepVisibleRange;
			boolean axisScaleHasChanged = viewer.updateFullRangeH("x", startDate, endDate, updateType);          
            
			// Set the zoom in limit as a ratio to the full range
			viewer.setZoomInWidthLimit(zoomInLimit / (viewer.getValueAtViewPort("x", 1) - 
				viewer.getValueAtViewPort("x", 0)));
                
			// Trigger the viewPortChanged event to update the display if the axis scale has 
			// changed or if new data are added to the existing axis scale.
			if (axisScaleHasChanged || (duration < initialFullRange * 1000))
				viewer.updateViewPort(true, false);
		}
	}

	//
	// The viewPortChanged event handler. In this example, it just updates the chart. If you
	// have other controls to update, you may also put the update code here.
	//
	private void chartViewer1_viewPortChanged(ViewPortChangedEvent e)
	{
		// In addition to updating the chart, we may also need to update other controls that
		// changes based on the view port.
		updateControls(chartViewer1);

		// Update the chart if necessary
		if (e.needUpdateChart())
			drawChart(chartViewer1);
	}

	//
	// Update other controls when the view port changed
	//
	private void updateControls(ChartViewer viewer)
	{
		// Update the scroll bar to reflect the view port position and width of the view port.
		hScrollBar1.setEnabled(chartViewer1.getViewPortWidth() < 1);
		hScrollBar1.setVisibleAmount((int)Math.ceil(chartViewer1.getViewPortWidth() * 
			(hScrollBar1.getMaximum() - hScrollBar1.getMinimum())));
		hScrollBar1.setBlockIncrement(hScrollBar1.getVisibleAmount());
		hScrollBar1.setUnitIncrement((int)Math.ceil(hScrollBar1.getVisibleAmount() * 0.1));
		hScrollBar1.setValue((int)Math.round(chartViewer1.getViewPortLeft() * 
			(hScrollBar1.getMaximum() - hScrollBar1.getMinimum())) + hScrollBar1.getMinimum());
	}

	//
	// Draw the chart and display it in the given viewer.
	//
	private void drawChart(ChartViewer viewer)
	{
		// Get the start date and end date that are visible on the chart.
		Date viewPortStartDate = Chart.NTime(viewer.getValueAtViewPort("x", viewer.getViewPortLeft()));
		Date viewPortEndDate = Chart.NTime(viewer.getValueAtViewPort("x", viewer.getViewPortLeft() +
			viewer.getViewPortWidth()));

		// Extract the part of the data arrays that are visible.
		Date[] viewPortTimeStamps = null;
		double[] viewPortDataSeriesA = null;
		double[] viewPortDataSeriesB = null;
		double[] viewPortDataSeriesC = null;

		if (currentIndex > 0)
		{
			// Get the array indexes that corresponds to the visible start and end dates
			int startIndex = (int)Math.floor(Chart.bSearch2(timeStamps, 0, currentIndex, viewPortStartDate));
			int endIndex = (int)Math.ceil(Chart.bSearch2(timeStamps, 0, currentIndex, viewPortEndDate));
			int noOfPoints = endIndex - startIndex + 1;
                
			// Extract the visible data
			viewPortTimeStamps = (Date[])Chart.arraySlice(timeStamps, startIndex, noOfPoints);
			viewPortDataSeriesA = (double[])Chart.arraySlice(dataSeriesA, startIndex, noOfPoints);
			viewPortDataSeriesB = (double[])Chart.arraySlice(dataSeriesB, startIndex, noOfPoints);
			viewPortDataSeriesC = (double[])Chart.arraySlice(dataSeriesC, startIndex, noOfPoints);
		}

		//
		// At this stage, we have extracted the visible data. We can use those data to plot the chart.
		//

		//================================================================================
		// Configure overall chart appearance.
		//================================================================================

		// Create an XYChart object of size 640 x 350 pixels
		XYChart c = new XYChart(640, 350);

		// Set the plotarea at (55, 50) with width 80 pixels less than chart width, and height 85 pixels
		// less than chart height. Use a vertical gradient from light blue (f0f6ff) to sky blue (a0c0ff)
		// as background. Set border to transparent and grid lines to white (ffffff).
		c.setPlotArea(55, 50, c.getWidth() - 85, c.getHeight() - 80, c.linearGradientColor(0, 50, 0,
			c.getHeight() - 35, 0xf0f6ff, 0xa0c0ff), -1, Chart.Transparent, 0xffffff, 0xffffff);

		// As the data can lie outside the plotarea in a zoomed chart, we need enable clipping.
		c.setClipping();

		// Add a title to the chart using 18 pts Times New Roman Bold Italic font
		c.addTitle("  Realtime Chart with Zoom/Scroll and Track Line", "Arial", 18);

		// Add a legend box at (55, 25) using horizontal layout. Use 8pts Arial Bold as font. Set the
		// background and border color to Transparent and use line style legend key.
		LegendBox b = c.addLegend(55, 25, false, "Arial Bold", 10);
		b.setBackground(Chart.Transparent);
		b.setLineStyleKey();

		// Set the x and y axis stems to transparent and the label font to 10pt Arial
		c.xAxis().setColors(Chart.Transparent);
		c.yAxis().setColors(Chart.Transparent);
		c.xAxis().setLabelStyle("Arial", 10);
		c.yAxis().setLabelStyle("Arial", 10);

		// Add axis title using 10pts Arial Bold Italic font
		c.yAxis().setTitle("Ionic Temperature (C)", "Arial Bold", 10);

		//================================================================================
		// Add data to chart
		//================================================================================

		//
		// In this example, we represent the data by lines. You may modify the code below to use other
		// representations (areas, scatter plot, etc).
		//

		// Add a line layer for the lines, using a line width of 2 pixels
		LineLayer layer = c.addLineLayer2();
		layer.setLineWidth(2);
		layer.setFastLineMode();

		// Now we add the 3 data series to a line layer, using the color red (ff0000), green (00cc00)
		// and blue (0000ff)
		layer.setXData(viewPortTimeStamps);
		layer.addDataSet(viewPortDataSeriesA, 0xff0000, "Alpha");
		layer.addDataSet(viewPortDataSeriesB, 0x00cc00, "Beta");
		layer.addDataSet(viewPortDataSeriesC, 0x0000ff, "Gamma");

		//================================================================================
		// Configure axis scale and labelling
		//================================================================================

		if (currentIndex > 0)
			c.xAxis().setDateScale(viewPortStartDate, viewPortEndDate);

		// For the automatic axis labels, set the minimum spacing to 75/30 pixels for the x/y axis.
		c.xAxis().setTickDensity(75);
		c.yAxis().setTickDensity(30);

		//
		// In a zoomable chart, the time range can be from a few years to a few seconds. We can need
		// to define the date/time format the various cases. 
		//

		// If all ticks are year aligned, we use "yyyy" as the label format.
		c.xAxis().setFormatCondition("align", 360 * 86400);
		c.xAxis().setLabelFormat("{value|yyyy}");

		// If all ticks are month aligned, we use "mmm yyyy" in bold font as the first label of a year,
		// and "mmm" for other labels.
		c.xAxis().setFormatCondition("align", 30 * 86400);
		c.xAxis().setMultiFormat(Chart.StartOfYearFilter(), "<*font=bold*>{value|mmm yyyy}",
			Chart.AllPassFilter(), "{value|mmm}");

		// If all ticks are day algined, we use "mmm dd<*br*>yyyy" in bold font as the first label of a
		// year, and "mmm dd" in bold font as the first label of a month, and "dd" for other labels.
		c.xAxis().setFormatCondition("align", 86400);
		c.xAxis().setMultiFormat(Chart.StartOfYearFilter(),
			"<*block,halign=left*><*font=bold*>{value|mmm dd<*br*>yyyy}", Chart.StartOfMonthFilter(),
			"<*font=bold*>{value|mmm dd}");
		c.xAxis().setMultiFormat2(Chart.AllPassFilter(), "{value|dd}");

		// If all ticks are hour algined, we use "hh:nn<*br*>mmm dd" in bold font as the first label of 
		// the Day, and "hh:nn" for other labels.
		c.xAxis().setFormatCondition("align", 3600);
		c.xAxis().setMultiFormat(Chart.StartOfDayFilter(), "<*font=bold*>{value|hh:nn<*br*>mmm dd}",
			Chart.AllPassFilter(), "{value|hh:nn}");

		// If all ticks are minute algined, then we use "hh:nn" as the label format.
		c.xAxis().setFormatCondition("align", 60);
		c.xAxis().setLabelFormat("{value|hh:nn}");

		// If all other cases, we use "hh:nn:ss" as the label format.
		c.xAxis().setFormatCondition("else");
		c.xAxis().setLabelFormat("{value|hh:nn:ss}");

		// We make sure the tick increment must be at least 1 second.
		c.xAxis().setMinTickInc(1);

		//================================================================================
		// Output the chart
		//================================================================================

		// We need to update the track line too. If the mouse is moving on the chart (eg. if 
		// the user drags the mouse on the chart to scroll it), the track line will be updated
		// in the MouseMovePlotArea event. Otherwise, we need to update the track line here.
		if (!chartViewer1.isInMouseMoveEvent())
		{
			trackLineLabel(c, (null == viewer.getChart()) ? c.getPlotArea().getRightX() : 
				viewer.getPlotAreaMouseX());
		}
                        
		// Set the chart image to the ChartViewer
		chartViewer1.setChart(c);
	}

	//
	// Click event for the pointerPB.
	//
	private void pointerPB_Clicked()
	{
		pointerPB.setBackground(new Color(0x80, 0xff, 0x80));
		zoomInPB.setBackground(null);
		zoomOutPB.setBackground(null);
		chartViewer1.setMouseUsage(Chart.MouseUsageScrollOnDrag);
	}

	//
	// Click event for the zoomInPB.
	//
	private void zoomInPB_Clicked()
	{
		pointerPB.setBackground(null);
		zoomInPB.setBackground(new Color(0x80, 0xff, 0x80));
		zoomOutPB.setBackground(null);
		chartViewer1.setMouseUsage(Chart.MouseUsageZoomIn);
	}

	//
	// Click event for the zoomOutPB.
	//
	private void zoomOutPB_Clicked()
	{
		pointerPB.setBackground(null);
		zoomInPB.setBackground(null);
		zoomOutPB.setBackground(new Color(0x80, 0xff, 0x80));
		chartViewer1.setMouseUsage(Chart.MouseUsageZoomOut);
	}
	
	//
	// A utility class to be used with JFileChooser to filter files with certain extensions.
	// This is to maintain compatibility with older versions of Java that does not built-in
	// extension filtering class.
	//
	private static class SimpleExtensionFilter extends FileFilter 
	{
		public String ext;
		public SimpleExtensionFilter(String extension) { this.ext = "." + extension; }
		public String getDescription() { return ext.substring(1);	}
		public boolean accept(java.io.File file) 
		{ return file.isDirectory() || file.getName().endsWith(ext); }
	}

	//
	// Save button event handler
	//
	private void savePB_Clicked()
	{
		String[] extensions = { "png", "jpg", "gif", "bmp", "svg", "pdf" };

		// The File Save dialog
		if (null == saveDialog)
		{
			saveDialog = new JFileChooser();
			for (int i = 0; i < extensions.length; ++i)
				saveDialog.addChoosableFileFilter(new SimpleExtensionFilter(extensions[i]));		
			saveDialog.setAcceptAllFileFilterUsed(false);
			saveDialog.setFileFilter(saveDialog.getChoosableFileFilters()[0]);
			saveDialog.setSelectedFile(new java.io.File("chartdirector_demo"));
		}
		
		int status = saveDialog.showSaveDialog(null);
		if ((status == JFileChooser.APPROVE_OPTION) && (null != chartViewer1.getChart()))
		{
			// Add extension if the pathName does not already have one
			String pathName = saveDialog.getSelectedFile().getAbsolutePath();
			boolean hasExtension = false;
			for (int i = 0; i < extensions.length; ++i)
				if (hasExtension = pathName.endsWith("." + extensions[i]))
					break;
			if ((!hasExtension) && (saveDialog.getFileFilter() instanceof SimpleExtensionFilter))
				pathName += ((SimpleExtensionFilter)saveDialog.getFileFilter()).ext;
			
			// Issue an overwrite confirmation dialog if the file already exists
			if (new java.io.File(pathName).exists())
			{
				if (JOptionPane.YES_OPTION != JOptionPane.showOptionDialog(this, 
					"File \"" + pathName + "\" already exists, confirm overwrite?", 
					"Existing File - Confirm Overwrite", 
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, 
					null, new String[] { "Yes", "No" }, "No"))
					return;	
			}

			chartViewer1.getChart().makeChart(pathName);					
		}
	}
    
	//
	// Updates the chartUpdateTimer interval if the user selects another interval.
	//
	private void samplePeriod_ValueChanged(ActionEvent evt)
	{
		int period = Integer.parseInt(samplePeriod.getSelectedItem().toString());
		chartUpdateTimer.setDelay(period);
		chartUpdateTimer.setInitialDelay(period);
	}
	
	//
	// Horizontal ScrollBar ValueChanged event handler
	//
	private void hScrollBar1_ValueChanged()
	{
		if (hasFinishedInitialization && !chartViewer1.isInViewPortChangedEvent())
		{
			// Get the view port left as according to the scroll bar
			double newViewPortLeft = ((double)(hScrollBar1.getValue() - hScrollBar1.getMinimum())) 
				/ (hScrollBar1.getMaximum() - hScrollBar1.getMinimum());

			// Check if view port has really changed - sometimes the scroll bar may issue redundant
			// value changed events when value has not actually changed.
			if (Math.abs(chartViewer1.getViewPortLeft() - newViewPortLeft) > 
				0.00001 * chartViewer1.getViewPortWidth())
			{
				// Set the view port based on the scroll bar
				chartViewer1.setViewPortLeft(newViewPortLeft);
	
				// Update the chart display without updating the image maps. We delay updating
				// the image map because the chart may still be unstable (still scrolling).
				chartViewer1.updateViewPort(true, false);
			}
		}
	}
    
	//
	// Draw track cursor when mouse is moving over plotarea
	//
	private void chartViewer1_MouseMovedPlotArea(MouseEvent e)
	{
		ChartViewer viewer = (ChartViewer)e.getSource();
		trackLineLabel((XYChart)viewer.getChart(), viewer.getPlotAreaMouseX());
		viewer.updateDisplay();
	}

	//
	// Draw track line with data labels
	//
	private void trackLineLabel(XYChart c, int mouseX)
	{
		// Clear the current dynamic layer and get the DrawArea object to draw on it.
		DrawArea d = c.initDynamicLayer();

		// The plot area object
		PlotArea plotArea = c.getPlotArea();

		// Get the data x-value that is nearest to the mouse, and find its pixel coordinate.
		double xValue = c.getNearestXValue(mouseX);
		int xCoor = c.getXCoor(xValue);
		if (xCoor < plotArea.getLeftX())
			return;

		// Draw a vertical track line at the x-position
		d.vline(plotArea.getTopY(), plotArea.getBottomY(), xCoor, 0x888888);

		// Draw a label on the x-axis to show the track line position.
		String xlabel = "<*font,bgColor=000000*> " + c.xAxis().getFormattedLabel(xValue, "hh:nn:ss.ff") +
			" <*/font*>";
		TTFText t = d.text(xlabel, "Arial Bold", 10);

		// Restrict the x-pixel position of the label to make sure it stays inside the chart image.
		int xLabelPos = Math.max(0, Math.min(xCoor - t.getWidth() / 2, c.getWidth() - t.getWidth()));
		t.draw(xLabelPos, plotArea.getBottomY() + 6, 0xffffff);

		// Iterate through all layers to draw the data labels
		for (int i = 0; i < c.getLayerCount(); ++i)
		{
			Layer layer = c.getLayerByZ(i);

			// The data array index of the x-value
			int xIndex = layer.getXIndexOf(xValue);

			// Iterate through all the data sets in the layer
			for (int j = 0; j < layer.getDataSetCount(); ++j)
			{
				ChartDirector.DataSet dataSet = layer.getDataSetByZ(j);

				// Get the color and position of the data label
				int color = dataSet.getDataColor();
				int yCoor = c.getYCoor(dataSet.getPosition(xIndex), dataSet.getUseYAxis());
				String name = dataSet.getDataName();

				// Draw a track dot with a label next to it for visible data points in the plot area
				if ((yCoor >= plotArea.getTopY()) && (yCoor <= plotArea.getBottomY()) && (color !=
					Chart.Transparent) && (null != name) && (0 < name.length()))
				{
					d.circle(xCoor, yCoor, 4, 4, color, color);

					String label = "<*font,bgColor=" + Integer.toHexString(color) + "*> " + c.formatValue(
						dataSet.getValue(xIndex), "{value|P4}") + " <*/font*>";
					t = d.text(label, "Arial Bold", 10);

					// Draw the label on the right side of the dot if the mouse is on the left side the
					// chart, and vice versa. This ensures the label will not go outside the chart image.
					if (xCoor <= (plotArea.getLeftX() + plotArea.getRightX()) / 2)
						t.draw(xCoor + 5, yCoor, 0xffffff, Chart.Left);
					else
						t.draw(xCoor - 5, yCoor, 0xffffff, Chart.Right);
				}
			}
		}
	}
}