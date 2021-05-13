package Teacher.View.CheckAllMarks.CheckEachPaperMark;
import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
/**
 *
 * @Title:JFreeChart实现柱状图
 * @Description:Comment for created type
 * @author zwn
 * @date 2021年5月11日上午10:43:44
 * @version 1.0
 */
public class BarChart {
    ChartPanel chartPanel;
    public BarChart(DefaultCategoryDataset dataset) {
        // 获得数据集
        JFreeChart chart = ChartFactory.createBarChart3D(
                "成绩统计", // 图表标题
                "分值", // 目录轴的显示标签
                "人数", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                false, // 是否显示图例
                true, // 是否生成工具（提示）
                false // 是否生成URL链接
        );
        // 设置标题字体
        Font font = new Font("宋体", Font.BOLD, 18);
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        chart.setTextAntiAlias(false);
        // 设置背景色
        chart.setBackgroundPaint(new Color(255, 255, 255));
        // 设置图例字体
//        LegendTitle legend = chart.getLegend(0);
//        legend.setItemFont(new Font("宋体", Font.BOLD, 14));
        // 获得柱状图的Plot对象
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer3D customBarRenderer = (BarRenderer3D) plot.getRenderer();
        // 取得横轴
        CategoryAxis categoryAxis = plot.getDomainAxis();
        // 设置横轴显示标签的字体
        categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 16));
        // 设置横轴标记的字体
        categoryAxis.setTickLabelFont(new Font("宋休", Font.BOLD, 16));
        // 取得纵轴
        NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
        // 设置纵轴显示标签的字体
        numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 16));
        numberAxis.setTickLabelFont(new Font("Fixedsys", Font.PLAIN, 13));
        customBarRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());// 显示每个柱的数值
        customBarRenderer.setBaseItemLabelsVisible(true);
        // 注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
        customBarRenderer.setBasePositiveItemLabelPosition(
                new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
         chartPanel=new ChartPanel(chart,true);
    }
    public ChartPanel getChartPanel(){
        return chartPanel;
    }
}
