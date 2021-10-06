package ctrl.view;

public class ModelAndView {
    private String page;
    private boolean send;

    public ModelAndView() {
        super();
    }

    public ModelAndView(String page, boolean send) {
        this.page = page;
        this.send = send;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public String getPage() {
        return page;
    }

    public boolean isSend() {
        return send;
    }
}
