package Service;

import Dao.BaozouDao;
import Entity.BaozouNews;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Author:林万新 lwx
 * Date:  2017/11/10
 * Time: 10:20
 */
public class BaoZouPipeLine implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        BaozouNews news = (BaozouNews) resultItems.get("news");
        int i= BaozouDao.insert(news);//插入数据库
        System.out.println("如果i不为0，则插入成功，i的值为：" +i );
    }
}
