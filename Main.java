import SpreadSheet.Sheet;
import java.util.ArrayList;

public class Main {
    public static void main() throws Exception{
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Date");
        titles.add("Height");
        titles.add("Name");
        titles.add("Mewer");
        titles.add("Aura");
        String[][] conts = {
            {"1/1/1", "6'7", "Alex", "Daniel", "6767"},
            {"1/1/1", "6'7", "Alex", "Sigma", "6767"},
            {"1/1/1", "6'7", "Alex", "DaQuavis", "6767"}
        };
        
        Sheet a = new Sheet("Sigmas", titles, conts);
    
        System.out.println(a);
    }

}
