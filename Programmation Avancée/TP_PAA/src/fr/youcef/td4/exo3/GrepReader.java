package fr.youcef.td4.exo3;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;

public class GrepReader extends BufferedReader {
    public GrepReader(Reader in, int sz) {
        super(in, sz);
    }

    public GrepReader(Reader in) {
        super(in);
    }

    public String readLine(String pattern) {
        String line = null;
        try {
            line = super.readLine();
            while (line != null && !line.contains(pattern)) {
                line = super.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }
}
