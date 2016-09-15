import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Дмитрий on 15.09.2016.
 */
public class SimpleTextExtractor {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите путь к документу");

        PdfReader reader = new PdfReader(bufferedReader.readLine());

        List<String> list = new ArrayList<String>();

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 1; i <= reader.getNumberOfPages(); ++i) {
            TextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
            String text = PdfTextExtractor.getTextFromPage(reader, i, strategy);
            StringTokenizer st = new StringTokenizer(text, "\t\n\r,.;:!?/-{}<>%$#&^1234567890_() =+*");
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

        }

        for (int i = 0; i < list.size(); i++) {
            if(map.containsKey(list.get(i)))
            {
                map.put(list.get(i), map.get(list.get(i))+1);
            }
            else {
                map.put(list.get(i), 1);
            }
        }
        ArrayList<String> res = new ArrayList<String>();
        for (String key : SortByValue.sortByValue(map).keySet()) {
            res.add(key);
        }
        for (int i = res.size() - 100; i < res.size() ; i++) {
            System.out.println(res.get(i));
        }


    }

}









