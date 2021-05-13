package Teacher.ALineCounter;


public class RunCounter {
    public static void main(String args[])
    {
        CountLine cl = new CountLine();
        cl.Dir("E:\\myIdeaProject\\javaClassProject\\src");	// 工程代码路径
        cl.countLine();												// 计算.java代码总行数
        System.out.println("一共"+cl.getLines()+"行代码，完工啦！！！");							// 把行数输出到屏幕
    }
}