/**
 * Sym.java
 * Name: Kunlun Wang 
 * Email: kwang358@wisc.edu 
 * Student ID: 907-809-8895 
 * 
 * Sym class serves to represent symbols 
 * 
 */

public class Sym {
	
	// create a String that contains the type of the symbol 
	private String symType;
	
	/**
     * Constructor of the Sym class 
     * It should initialize the Sym to have the given type.
     * 
     * @param type the type of the symbol 
     */
	public Sym(String type) {
        this.symType = type;
    }
	
	/**
     * Return this Sym's type.
     * 
     * @return sym's type
     */
	public String getType() {
        return symType;
    }
	
	/**
     * Return this Sym's type. 
     * (This method will be changed later in a future project 
     * when more information is stored in a Sym.)
     * 
     * @return sym's type in a string format
     */
	public String toString() {
        return symType;
    }
}
