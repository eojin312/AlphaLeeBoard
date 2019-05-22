package servlet.model;

public class Inquire {
    private long articleNo;
    private String title;
    private String createDate;

    public Inquire(long articleNo, String title, String createDate) {
        this.articleNo = articleNo;
        this.title = title;
        this.createDate = createDate;
    }

    public long getArticleNo() {
        return articleNo;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Inquire{" +
                "articleNo=" + articleNo +
                ", title='" + title + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
