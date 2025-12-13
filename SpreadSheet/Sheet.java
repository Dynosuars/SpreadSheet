package SpreadSheet;
import java.util.ArrayList;

public class Sheet {
    // Title of the SpreadSheet
    private String title;
    // Content of the Spread Sheet
    private final ArrayList<Spread> Contents;

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

    public Sheet(String title, String[][] conts) throws Exception{
        this.title = title;
        this.Contents = new ArrayList<>();

        for(String curr: conts[0]){
            this.Contents.add(new Spread(curr));
        }

        for(int row=1; row < conts.length; row++){
            for(int col=0; col < conts[row].length; col++){
                this.Contents.get(col).append(conts[row][col]);
            }
        }
    }



    public Sheet(String title, String[] titles){
        this.title = title;
        this.Contents = new ArrayList<Spread>();
        
        for(String curr: titles){
            this.Contents.add(new Spread(curr));
        }
    }

    /**
     * Creates a new <Sheet> using <matrix<String>>;
     * @param title <String>
     * @param titles <String[]>
     * @param conts <String[][]>
     * @throws Exception
     */
    public Sheet(String title, String[] titles, String[][] conts) throws Exception{
        this.Contents = new ArrayList<Spread>();
        this.title = title;
        if(titles.length != conts.length) throw new Exception("Different dimensions");
        for(String curr: titles){
            this.Contents.add(new Spread(curr));
        }
        for(String[] curr : conts){
            this.addRow(curr);
        }
    }


    /**
     * Creates a new <Sheet> using <matrix<String>> but with a Iterable<String> title;
     * @param title <String>
     * @param titles <Iterable<String>>
     * @param conts <String[][]>
     * @throws Exception
     */
    public Sheet(String title, Iterable<String> titles, String[][] conts) throws Exception{
        int count = 0;
        this.title = title;
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
     * Gets the numbers of row
     * @return
     */
    public int size(){
        return this.Contents.size();
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


    /**
     * Gets the row of <int> index
     * @param index<int>
     * @return rows<String[]>
     */
    public String[] row(int index){
        Spread curr = this.Contents.get(index);
        String[] rows = new String[curr.size()];
        
        for(int i=0; i < curr.size(); i++){
            rows[i] = curr.get(i);
        }
        return rows;
    }
    /**
     * Gets the Column as a <Spread>
     * @param index<int>
     * @return <Spread>
     */
    public Spread colSpread(int index){
        return this.Contents.get(index);
    }


    /**
     * Gets the Column as a <String[]>
     * @param index
     * @return <String[]>
     */
    public String[] col(int index){
        return this.Contents.get(index).get().toArray(new String[0]);
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

    public void addRow(Iterable<String> args) throws Exception{
        int size = 0, count = 0;
        // Safety matters
        for(String arg: args){
            size++;
        }
        if(size != this.Contents.size()) throw new Exception("Dimension doesn't match");
        else if(size == 0) throw new IndexOutOfBoundsException("The Iterable is not initialized");

        for(String arg: args){
            this.Contents.get(count).append(arg);
            count++;
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

    /**
     * Converts <Sheet>this into a string
     * @return <String>this
     */
    @Override
    public String toString(){
        String result = this.title + "\n";
        for (String word : this.Titles()) {
            for(int i=0;i< word.length() + 2;i++){
                result += "-";
            }
        }
        result += "\n";
        for(int row = 0; row < this.max(); row++){
            for(int col = 0; col < this.Contents.size(); col++){
                result += this.Contents.get(col).get(row);

                if(col < (this.Contents.size() - 1)){
                    result += ", ";
                }
            }
            if(row < (this.max() ))
                result += "\n";
        }
        //result += "\n";
        for (String word : this.Titles()) {
            for(int i=0;i< word.length() + 2;i++){
                result += "-";
            }
        }
        result += "\n";

        return result;
    }

    public static String toString(Sheet curr){

        String result = curr.Title();
        Spread ts;
        for (String word : curr.Titles()) {
            for(int i=0;i< word.length() + 2;i++){
                result += "=";
            }
        }

    


        

        return result;
    }


}
