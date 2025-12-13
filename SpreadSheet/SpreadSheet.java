package SpreadSheet;
import java.util.ArrayList;

public class SpreadSheet {
    private ArrayList<Sheet> pages;

    public SpreadSheet(Sheet page){
        this.pages = new ArrayList<Sheet>(pages);
    }

    public SpreadSheet(){
        this.pages= new ArrayList<Sheet>();
    }

    public Sheet page(int index){
        return this.pages.get(index);
    }

    
    
}
