package Backend;

public class HTMLParser
{

    public static String ParseHtmlLink(String line){

        if (line.contains("href="))
        {
            //          Step 1                    Step 2
            return line.split("href=\"")[1].split("\">")[0];


        } else return null;
        // How the String splitting works
            /*
            Text change over time:
            ============
            ||Original||
            ============
            <div class="Blach blach BLacj">
                <a class="sibling-link" href="/youtube/answer/2797466?hl=en&amp;ref_topic=2778546"></a>
            </div>

            ==========
            ||Step 1||
            ==========
                /youtube/answer/2797466?hl=en&amp;ref_topic=2778546></a>
            </div>


            ==========
            ||Step 2||
            ==========
                /youtube/answer/2797466?hl=en&amp;ref_topic=2778546
             */
    }

    public static void main(String[] args)
    {

        System.out.println(ParseHtmlPara("blblblblbllblblb<p class= yayaydya>  Hello World! </p>"));
        System.out.println(ParseHtmlLink("<a class=\"sibling-link\" href=\"/youtube/answer/2797466?hl=en&amp;ref_topic=2778546\"></a>"));
    }

    public static String ParseHtmlPara(String line)
    {
        if (line.contains("<p"))
        {

            //Step 1               Step 2              Step 3
            return line.split("<p")[1].split(">")[1].split("</p")[0];

        }

        else return null;
        // How the String splitting works
            /*
            Text change over time:
            ============
            ||Original||
            ============
            <div class= "ImADiv>
                <p class="articleProductElementParagraph">
                    Blah blah blah im some text
                </p>
            </div>

            ==========
            ||Step 1||
            ==========
           class="articleProductElementParagraph">
                    Blah blah blah im some text
                </p>
            </div>


            ==========
            ||Step 2||
            ==========
                    Blah blah blah im some text
                </p>
            </div>


            ==========
            ||Step 3||
            ==========
                    Blah blah blah im some text


           ~~~RETURN THIS STRING~~~
             */
    }

}
