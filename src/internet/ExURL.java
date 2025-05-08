package internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ExURL {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://www.google.com");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.setReadTimeout(15000);
            huc.connect();
            
            System.out.println(huc.getContentLength());
            System.out.println(huc.getContentType());
            System.out.println(huc.getRequestMethod());
            /*URLConnection uc = url.openConnection();
            System.out.println(uc.getContentType());
            InputStream is = uc.getInputStream();
            int caractere;
            
            while((caractere = is.read()) != -1){
                System.out.print((char) caractere);
            }*/
        }catch(MalformedURLException mue){
            mue.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
