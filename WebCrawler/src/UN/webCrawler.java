package UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

//clase auxiliar
public class webCrawler {

    private static HashSet<String> urls = new HashSet<String>();
    public static int ct;

    public webCrawler(String ul, int count) {
        ct = count;
        try {
            URL my_url = new URL(ul);

            rastrear(my_url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void rastrear(URL url) {
        try {
            boolean esValida;
            try {
                URLConnection connection = url.openConnection();
                connection.connect();
                if ((connection.getContentType() != null) && !connection.getContentType().toLowerCase().startsWith("text/")) {
                    esValida = false;
                } else {
                    esValida = true;
                }
            } catch (IOException e) {
                esValida = false;
            }

            if (esValida) {
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                HTMLEditorKit.Parser parse = new HTMLParse().getParser();
                //escribir enlaces de una página
                parse.parse(br, new Parser(url), true);
                urls = Parser.getList();
                HashSet<String> newOne = new HashSet<String>();
                if (ct + urls.size() > 26) {
                    for (String url1 : urls) {
                        if (ct <= 26 && newOne.size() < 5) {
                            newOne.add(url1);
                            ct++;
                        }
                    }
                    urls = newOne;
                } else {
                    if (urls.size() > 5) {
                        for (String url1 : urls) {
                            if (newOne.size() < 5) {
                                newOne.add(url1);
                            }
                        }
                    }
                    urls = newOne;
                }
            } else {
                System.out.println("No es una página válida");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public HashSet<String> getList() {
        return urls;
    }
}

class HTMLParse extends HTMLEditorKit {

    public HTMLEditorKit.Parser getParser() {
        return super.getParser();
    }
}
//clase auxiliar

class Parser
        extends HTMLEditorKit.ParserCallback {

    protected URL url;
    private static HashSet<String> urls1 = new HashSet<String>();

    public Parser(URL base) {
        urls1.clear();
        this.url = base;
    }

    public void EtiquetaSimple(HTML.Tag t,
            MutableAttributeSet a, int pos) {
        //obtener la propiedad href de la etiqueta <a> que identifica que hay un enlace en la página
        String href = (String) a.getAttribute(HTML.Attribute.HREF);
        if ((href == null) && (t == HTML.Tag.FRAME)) {
            href = (String) a.getAttribute(HTML.Attribute.SRC);
        }

        if (href == null) {
            return;
        }

        int i = href.indexOf('#');
        if (i != -1) {
            href = href.substring(0, i);
        }
        mostrarLink(url, href);
    }

    public void handleStartTag(HTML.Tag t,
            MutableAttributeSet a, int pos) {
        EtiquetaSimple(t, a, pos);

    }

    public void mostrarLink(URL dominio, String url) {
        if (!url.equals("") && !url.equals(" ") && !url.equals("/")) {
            if (url.length() >= 8) {
                if (url.substring(0, 8).equals("https://") || url.substring(0, 7).equals("http://")) {
//                    System.out.println(url);
                    urls1.add(url);
                } else {
//                    System.out.println(dominio + url);
                    urls1.add(dominio + url);
                }
            }
        }

    }

    public static HashSet<String> getList() {
        return urls1;
    }
}
