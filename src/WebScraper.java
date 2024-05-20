import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {

    public static List<String> obtenerTitulares(String html) {
        List<String> titulares = new ArrayList<>();
        String[] splitH2Inicial = html.split("<h2 class=\"sc-fa18824-3 hoYziy\">");
        for (int i = 1; i < splitH2Inicial.length; i++) {
            String titular = splitH2Inicial[i].split("</h2>")[0];
            titulares.add(titular);
        }
        return titulares;
    }

    public static String cargarWeb(String urlStr) {
        String html = "";
        try {
            URL url =  new URL(urlStr);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(reader);
            String linea;

            do {
                linea = br.readLine();
                if (linea != null){
                    html += linea;
                }
            } while(linea != null);

            br.close();
        }catch (Exception exception){
            System.out.println(exception);
        }

        return html;
    }
}
