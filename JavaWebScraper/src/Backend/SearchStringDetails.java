package Backend;

/**
 * The type Search string details.
 */
public class SearchStringDetails
{

    private String URL;
    private String HTMLCode;
    private int Depth;


    /**
     * Instantiates a new Search string details.
     *
     * @param URL      the url\
     * @param HTMLCode the html code
     * @param depth    the depth
     */
    SearchStringDetails(String URL, String HTMLCode, int depth)
    {
        this.URL = URL;

        this.HTMLCode = HTMLCode;
        Depth = depth;
    }

    /**
     * Gets depth.
     *
     * @return the depth
     */
    public int getDepth()
    {
        return Depth;
    }

    /**
     * Sets depth.
     *
     * @param depth the depth
     */
    public void setDepth(int depth)
    {
        Depth = depth;
    }

    /**
     * Gets html code.
     *
     * @return the html code
     */
    public String getHTMLCode()
    {
        return HTMLCode;
    }

    /**
     * Sets html code.
     *
     * @param HTMLCode the html code
     */
    public void setHTMLCode(String HTMLCode)
    {
        this.HTMLCode = HTMLCode;
    }


    /**
     * Gets url.
     *
     * @return the url
     */
    public String getURL()
    {
        return URL;
    }

    /**
     * Sets url.
     *
     * @param URL the url
     */
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

    /**
     * To html string.
     *
     * @return the string
     */
    public String toHTML()
    {
        return
                "<p>" + URL + "</P>" + "<br>" +
                "<p>" + HTMLCode + "</p>" + "<br>" +
                "<P> Depth=" + Depth + "</p>";
    }
}
