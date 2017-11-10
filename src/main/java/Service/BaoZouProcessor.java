package Service;

import Entity.BaozouNews;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Author:林万新 lwx
 * Date:  2017/11/10
 * Time: 10:13
 */
public class BaoZouProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);



    public void process(Page page){
        page.addTargetRequests(page.getHtml().css("div.pager-content").links().all());
        BaozouNews news = new BaozouNews();
        news.setAuthor(page.getHtml().xpath("//a[@class='article-author-name']/text()").toString());
        news.setContent(page.getHtml().xpath("//div[@class='article article-text']/@data-text").toString());
        news.setTime(page.getHtml().xpath("//span[@class='article-date']/text()").toString());
        page.putField("news",news);
    }

    public Site getSite(){
        return site;
    }
}
