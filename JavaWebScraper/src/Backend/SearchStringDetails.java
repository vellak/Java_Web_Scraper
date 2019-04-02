package Backend;

public class SearchStringDetails {

    private String URL;
    private String Title;
    private String HTMLCode;
    private int Depth;

    public SearchStringDetails(String URL, String title, String HTMLCode, int depth) {
        this.URL = URL;
        Title = title;
        this.HTMLCode = HTMLCode;
        Depth = depth;
    }

    public int getDepth() {
        return Depth;
    }

    public void setDepth(int depth) {
        Depth = depth;
    }

    public String getHTMLCode() {
        return HTMLCode;
    }

    public void setHTMLCode(String HTMLCode) {
        this.HTMLCode = HTMLCode;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
