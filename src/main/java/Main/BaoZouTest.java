package Main;

import Service.BaoZouPipeLine;
import Service.BaoZouProcessor;
import us.codecraft.webmagic.Spider;

/**
 * Author:林万新 lwx
 * Date:  2017/11/10
 * Time: 10:25
 */
public class BaoZouTest {
    public static void main(String[] args) {
        //程序入口
        Spider.create(new BaoZouProcessor())
                //从url开始抓；
        .addUrl("http://baozoumanhua.com/text").addPipeline(new BaoZouPipeLine())
                //启动5个线程
                .thread(5).run();
    }
}
