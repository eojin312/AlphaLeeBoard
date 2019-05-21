package servlet.model;

public class WriterModel {
    private int wtno;
    private String name;
    private String writing;

    public WriterModel(int wtno, String name, String writing) {
        this.wtno = wtno;
        this.name = name;
        this.writing = writing;
    }

    public int getWtno() {
        return wtno;
    }

    public String getName() {
        return name;
    }

    public String getWriting() {
        return writing;
    }

    @Override
    public String toString() {
        return "WriterModel{" +
                "wtno=" + wtno +
                ", name='" + name + '\'' +
                ", writing='" + writing + '\'' +
                '}';
    }
}
