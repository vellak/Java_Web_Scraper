package Backend;

class HTMLParser
{
    String[] ParseHtmlLink(String line)
    {
        if (line != null)
        {
            //System.out.println("Line is not Null");

            if (line.contains("href="))
            {
                try
                {
                    //          Step 1                            Step 2
                    String step1 = line.split("href=\"", 2)[1];
                    //System.out.println("Step1 " +step1);

                    String[] step2 = step1.split("\"", 2);
                    //System.out.println("Step2 " +step2);

                    return step2;
                } catch (ArrayIndexOutOfBoundsException e)
                {
                    System.err.println("The Link you tried to Parse Failed Miserably   ||" + line);
                }
            }
        }
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
        return null;
    }

    String[] ParseHtmlPara(String line)
    {
        if (line != null)
        {
            System.out.println("Line is not Null");

            if (line.contains("<p"))
            {
                try
                {
                    //          Step 1               Step 2              Step 3
                    String step1 = line.split("<p", 2)[1];
                    String step2 = step1.split(">", 2)[1];
                    String[] step3 = step2.split("</p", 2);

                    System.out.println(step3[0]);
                    return step3;
                } catch (ArrayIndexOutOfBoundsException e)
                {
                    System.err.println("The HTML Code you tried to Parse Failed Miserably   ||" + line);
                }
            }
        }
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

        return null;
    }

    public String CleanHTML(String lineDirty)
    {
        try
        {
            lineDirty = lineDirty.replaceAll("<path", "");
            lineDirty = lineDirty.replaceAll("<strong>", "");
            lineDirty = lineDirty.replaceAll("</strong", "");
            lineDirty = lineDirty.replaceAll("</svg>", "");
            lineDirty = lineDirty.replaceAll("</button>", "");
            lineDirty = lineDirty.replaceAll("", "");
            lineDirty = lineDirty.replaceAll("<button", "");
            lineDirty = lineDirty.replaceAll("<a", "");
            lineDirty = lineDirty.replaceAll("</a>", "");
            lineDirty = lineDirty.replaceAll("<div>", "");
            lineDirty = lineDirty.replaceAll("<div", "");
            return lineDirty;
        } catch (NullPointerException e)
        {
            return null;
        }
    }
}
