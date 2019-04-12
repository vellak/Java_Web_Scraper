package Backend;


public class SearchStringDetails
{

    private String URL;
    private String HTMLCode;
    private int Depth;

    SearchStringDetails(String URL, String HTMLCode, int depth)
    {
        this.URL = URL;

        this.HTMLCode = HTMLCode;
        Depth = depth;
    }


    public int getDepth()
    {
        return Depth;
    }


    public void setDepth(int depth)
    {
        Depth = depth;
    }

    public String getHTMLCode()
    {
        return HTMLCode;
    }

    public void setHTMLCode(String HTMLCode)
    {
        this.HTMLCode = HTMLCode;
    }

    public String getURL()
    {
        return URL;
    }


    public void setURL(String URL)
    {
        this.URL = URL;
    }


    @Override
    public String toString()
    {
        String url = getURL();
        String line =getHTMLCode().replaceAll(",", ".");
        int depth = getDepth();

        return "URL='" + url +
                ", Line Found='" + line +
                ", Depth=" + depth +
                '}';
    }

    public String toStringFormatted()
    {
        return "URL='" + URL + "\n" +
                ", HTMLCode='" + HTMLCode + "\n" +
                ", Depth=" + Depth +
                '}';
    }

    public String toHTML()
    {
        return
                "<p>" + URL + "</P>" + "<br>" +
                "<p>" + HTMLCode + "</p>" + "<br>" +
                "<P> Depth=" + Depth + "</p>";
    }
}
