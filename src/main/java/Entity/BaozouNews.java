package Entity;

/**
 * Author:林万新 lwx
 * Date:  2017/11/10
 * Time: 9:37
 * 封装实体类
 */
public class BaozouNews {
    private String author;//作者
    private String time;//时间
    private String content;//内容

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
