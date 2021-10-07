package model.vo;

public class BoardVO {
    private int seq;
    private String title, writer, content, regdate;
    private int cnt;

    public BoardVO() {
    }

    public BoardVO(int seq, String title, String writer, String content, String regdate, int cnt) {
        this.seq = seq;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regdate = regdate;
        this.cnt = cnt;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
