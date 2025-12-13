package SpreadSheet;
import java.util.ArrayList;

public class Spread{
    private final ArrayList<String> col;

    /**
     * Create a spread object, each row should be a String
     * Example: # Title #| con | con | con |
     * @param title, the content of the SpreadSheet
     */
    public Spread(String title){
        this.col = new ArrayList<String>();
        this.col.add(title);
    }

    /**
     * Spread default initializer ofc
     */
    public Spread(){
        this.col = new ArrayList<String>();
    }

    /**
     * I wish this was a C++ class because otherwise I can use a TEMPLATE
     * I still could do that in java that is another day to deal with lmao
     * @param content, the content being added to the row
     */
    public void append(String content){
        this.col.add(content);
    }

    /**
     * Returns the size of element
     * @return
     */
    public int size(){
        return this.col.size();
    }

    /**
     * C++ BETTER WE HAVE UNSIGNED INT
     * @param index<int>
     * @return String
     */
    public String get(int index){
        try{
            return this.col.get(index);
        }catch( IndexOutOfBoundsException e){
            return null;
        }
    }


    @SuppressWarnings({ "Unchecked", "unchecked" })
    public ArrayList<String> get(){
        return (ArrayList<String>)this.col.clone();
    }



}