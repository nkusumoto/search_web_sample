import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CustomSearch {

    public static void main(String[] arg) throws IOException {

        String key = "";
        String cx = "";
        String qry = "石原さとみ";

        URL url = new URL("https://www.googleapis.com/customsearch/v1?key=" + key + "&cx=" +cx+ "&q=" + qry + "&hl=ja&start=1");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept-Language", "jp");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream()), StandardCharsets.UTF_8));

        StringBuilder response = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            response.append(line+"\n");
        }

        bufferedReader.close();
        conn.disconnect();

        String[] lines;
        lines = response.toString().split("\n");

    }
}
