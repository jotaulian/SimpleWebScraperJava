import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        String url = "https://www.ole.com.ar/";
        String html = WebScraper.cargarWeb(url);
        // System.out.println(html);

        List<String> noticias = WebScraper.obtenerTitulares(html);

        noticias.forEach(noticia -> System.out.println(noticia));
    }

}
