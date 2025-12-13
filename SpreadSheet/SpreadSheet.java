package SpreadSheet;
import java.util.ArrayList;
import java.util.Arrays;
public class SpreadSheet {
    private final ArrayList<Sheet> pages;

    public SpreadSheet(Sheet page){
        this.pages = new ArrayList<Sheet>();
        this.pages.add(page);
    }

    public SpreadSheet(){
        this.pages= new ArrayList<Sheet>();
    }

    public SpreadSheet(Sheet... pages){
        this.pages = new ArrayList<Sheet>();
        this.pages.addAll(Arrays.asList(pages));
    }

    public SpreadSheet(Iterable<Sheet> pages){
        this.pages = new ArrayList<Sheet>();
    }

    public SpreadSheet(String[][][] pages) throws Exception{
        this.pages = new ArrayList<>();
        int count = 1;

        for(String[][] curr : pages){
            this.pages.add(new Sheet(String.format("Page %d", count), curr));
        }
    }

    public Sheet page(int index){
        return this.pages.get(index);
    }

    public int length(){
        return this.pages.size();
    }

    public String getData(int page, int row, int col){
        return this.pages.get(page).getRow(row)[col];
    }

    public void changeData(int page, int row, int col, String value){
        this.pages.get(page).getRow(row)[col] = value;
    }

    public int maxCol(){
        int curr = 0;
        for(Sheet a: this.pages){
            if(curr < a.max()){
                curr = a.max();
            }
        }
        return curr;
    }

    public int maxRow(){
        int curr = 0;
        for(Sheet a: this.pages){
            if(curr < a.size()){
                curr = a.size();
            }
        }
        return curr;
    }

    public String[][][] get(){
        String[][][] result = new String[this.pages.size()][][];

        for(int p = 0; p < this.pages.size(); p++){
            Sheet s = this.pages.get(p);
            String[] titles = s.Titles();
            int rows = s.max();
            int cols = titles.length;

            String[][] sheetArr = new String[rows][cols];

            sheetArr[0] = titles;

            for(int r = 0; r < rows - 1; r++){
                String[] rowData = s.getRow(r);
                sheetArr[r + 1] = rowData;
            }

            result[p] = sheetArr;
        }

        return result;
    }

    
    
}
