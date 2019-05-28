package servlet.model;
//create table alphaleeboard.article (
//        article_no bigint unsigned not null auto_increment primary key,
//        writer varchar(20) not null,
//        contents mediumtext,
//        create_date datetime,
//        update_date datetime,
//        read_count bigint unsigned default '0' ,
//        recommend_count bigint unsigned default '0'
//        );
public class Article {
    private long articleNo;
    private String title;
    private String writer;
    private String contents;
    private String createDate;
    private String updateDate;
    private long readCount;
    private long recommendCount;

    public Article() {
    }

    public Article(long articleNo, String title, String writer, String contents, String createDate, String updateDate, long readCount, long recommendCount) {
        this.articleNo = articleNo;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.readCount = readCount;
        this.recommendCount = recommendCount;
    }

    public Article(long articleNo, String writer, String title, String contents, String createDate) {
        this.title = title;
        this.articleNo = articleNo;
        this.writer = writer;
        this.contents = contents;
        this.createDate = createDate;
    }

    public Article(long articleNo, String title, String writer, String createDate, String updateDate, long readCount, long recommendCount) {
        this.articleNo = articleNo;
        this.title = title;
        this.writer = writer;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.readCount = readCount;
        this.recommendCount = recommendCount;
    }

    public String getTitle() {
        return title;
    }

    public long getArticleNo() {
        return articleNo;
    }

    public String getWriter() {
        return writer;
    }

    public String getContents() {
        return contents.replaceAll("\r\n", "<br>");
    }

    public String getContentsWithReturn() {
        return this.contents;
    }




    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public long getReadCount() {
        return readCount;
    }

    public long getRecommendCount() {
        return recommendCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleNo=" + articleNo +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", contents='" + contents + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", readCount=" + readCount +
                ", recommendCount=" + recommendCount +
                '}';
    }
}
