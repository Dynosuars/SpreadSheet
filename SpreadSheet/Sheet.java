package SpreadSheet;
import java.util.ArrayList;
import java.lang.Iterable;

public class Sheet {
    // Title of the SpreadSheet
    private String title;
    // Content of the Spread Sheet
    private ArrayList<Spread> Contents;

    /**
     * Creates a sheet object
     * @param title
     * @param titles, a array of object
     */
    public Sheet(String title, Iterable<String> titles){
        this.title = title;
        this.Contents = new ArrayList<Spread>();
        
        for(String curr: titles){
            this.Contents.add(new Spread(curr));
        }
    }



    public Sheet(String title, String[] titles){
        this.title = title;
        this.Contents = new ArrayList<Spread>();
        
        for(String curr: titles){
            this.Contents.add(new Spread(curr));
        }
    }

    public Sheet(String title, String[] titles, String[][] conts) throws Exception{
        this.Contents = new ArrayList<Spread>();
        if(titles.length != conts.length) throw new Exception("Different dimensions");
        for(String curr: titles){
            this.Contents.add(new Spread(curr));
        }
        for(String[] curr : conts){
            this.addRow(curr);
        }
    }

    public Sheet(String title, Iterable<String> titles, String[][] conts) throws Exception{
        int count = 0;
        this.Contents = new ArrayList<Spread>();
        for(String curr: titles){
            count++;
            this.Contents.add(new Spread(curr));
        }
        if(count != conts[0].length) throw new Exception("Deminsion doesn't match");
        for(String[] curr : conts){
            this.addRow(curr);
        }
    }

    /*
    public Sheet(String title, Iterable<String> titles, Iterable<Iterable<String>> conts) throws Exception{
        if(titles.size() != conts.length) throw new Exception("Different dimensions");
        for(String curr: titles){
            this.Contents.add(new Spread(curr));
        }
        for(Iterable<String> curr : conts){
            this.addRow(curr);
        }
    }
     */



    /**
     * Pretty clear, just changes the title
     * @param newTitle
     */
    public void changeTitle(String newTitle){
        this.title = newTitle;
    }

    /**
     * Gets the title
     * @return the title of this Sheet
     */
    public String Title(){
        return this.title;
    }

    /**
     * Gets the max size of the columns
     * @return the max size
     */
    public int max(){

        int highest = 0;

        for(Spread A: this.Contents){
            if(highest < A.size()){
                highest = A.size();
            }
        }

        return highest;
    }

    /**
     * Gets the titles 
     * @return the titles of this Sheet
     */
    public String[] Titles(){
        String titles[] = new String[this.Contents.size()];
        for(int i=0;i<this.Contents.size();i++)
            titles[i] = this.Contents.get(i).get(0);
        
        return titles;
    }



    public String[] row(int index){
        Spread curr = this.Contents.get(index);
        String[] rows = new String[curr.size()];
        
        for(int i=0; i < curr.size(); i++){
            rows[i] = curr.get(i);
        }
        return rows;
    }


    public void addRow(String... args){
        if(args.length != this.Contents.size()){
            // Should throw errors
            return;
        }
        for(int col=0;col < this.Contents.size(); col++){
            this.Contents.get(col).append(args[col]);
        }
    }



    public String[] getRow(int index){
        // Errors throw
        String row[] = new String[this.Contents.size()];

        for(int i=0; i<this.Contents.size(); i++){
            row[i] = this.Contents.get(i).get(index + 1);
        }

        return row;
        
    }

    @Override
    public String toString(){
        String result = this.title + "\n";
        
        for(int row = 0; row < this.max(); row++){
            for(int col = 0; col < this.Contents.size(); col++){
                result += this.Contents.get(col).get(row);

                if(col < (this.Contents.size() - 1)){
                    result += ", ";
                }
            }
            if(row < (this.max() - 1))
                result += "\n";
        }

        return result;
    }


}
