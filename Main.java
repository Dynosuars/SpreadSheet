import SpreadSheet.Sheet;
import SpreadSheet.SpreadSheet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
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

        ArrayList<String> await =  new ArrayList<String>();
        await.add("6/7/25");
        await.add("5'6'");
        await.add("Solo");
        await.add("Jibababa");
        await.add("-67000");
        String[][][] conts2 = {
            {{"1/1/1", "6'7", "Alex", "Daniel", "6767"},
            {"1/1/1", "6'7", "Alex", "Sigma", "6767"},
            {"1/1/1", "6'7", "Alex", "DaQuavis", "6767"}},
            {{"1/1/1", "6'7", "Alex", "Daniel", "6767"},
            {"1/1/1", "6'7", "Alex", "Sigma", "6767"},
            {"1/1/1", "6'7", "Alex", "DaQuavis", "6767"}}
        };

        
        Sheet a = new Sheet("Alex Liu's Hunting list", titles, conts);
        a.addRow(await);
        SpreadSheet b = new SpreadSheet(conts2);
    
        System.out.println(a);
        System.out.println(b.getData(0, 1, 0));
        System.out.println();
        System.out.println();

        for(String[][] page: b.get()){
            for(String[] sheets: page){
                for(String data: sheets){
                    System.out.println(data);
                }
            }
        }
        String[][] page1 =  {
                                {"Name", "DOB", "ID"},
                                {"Peter Parker", "08/10/2001", "552808061"},
                                {"Bruce Banner", "12/18/1969", "239487392"},
                                {"America Chavez", "07/04/2006", "616360975"}
                            };
        
        String[][] page2 =  {
                                {"Hero", "ThreatLevel", "Notes"},
                                {"Spider-man", "8-B", "Be careful if he ever stops talking."},
                                {"The Hulk", "4-B", "Much more docile as of late; still maintain caution when engaging. Avoid engagement all-together if possible."},
                                {"Ms. America", "2-C", "Insufficient Data."}
                            };
        
        //Test Your Class Here:
        String[][][] pages = {page1, page2};
        SpreadSheets heroes = new SpreadSheets(pages);
        
        
        for(int i=0; i<heroes.length(); i++){
            System.out.println(heroes.page(i));
        }
    }

}
