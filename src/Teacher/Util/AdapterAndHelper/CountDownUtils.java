package Teacher.Util.AdapterAndHelper;

import java.util.concurrent.TimeUnit;
/**
 * @ClassName:
 * @Description: 倒计时，以秒为单位
 * @parms:
 * @author 赵炜宁
 * @date 2021.4.26
 *
 */
import java.util.Timer;
import java.util.TimerTask;

public class CountDownUtils {
    private int curSec;
    public CountDownUtils(int limitSec) throws InterruptedException {
        this.curSec = limitSec;
        System.out.println("最后倒计时间： "+limitSec+" s");
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
                if(curSec>0){
                    System.out.println("倒计时： "+ curSec-- +" s");
                }
            }
        },0,1000);
        TimeUnit.SECONDS.sleep(limitSec);
        timer.cancel();
    }

}

