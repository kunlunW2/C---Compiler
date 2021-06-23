/**
 * SymTable.java
 * Name: Kunlun Wang 
 * Email: kwang358@wisc.edu 
 * Student ID: 907-809-8895 
 * 
 * SymTable class serves to store the symbols into symbol table with the data structure 
 * List<HashMap<String,Sym>> 
 * 
 */

import java.util.*;

public class SymTable {

	// declare a List of HashMaps 
	private List<HashMap<String, Sym>> symList;
	
	/**
     * This is the constructor; it should initialize the SymTable's 
     * List field to contain a single, empty HashMap.
     * 
     */
	public SymTable() {
		// initialize the data structure 
		symList = new LinkedList<HashMap<String, Sym>>();
		// add a single empty HashMap to the DS 
		symList.add(0, new HashMap<String, Sym>());
    }
	
	/**
	 * If this SymTable's list is empty, throw an EmptySymTableException. 
	 * If either name or sym (or both) is null, throw a IllegalArgumentException. 
	 * If the first HashMap in the list already contains the given name as a key, 
	 * throw a DuplicateSymException. Otherwise, add the given name and sym to the 
	 * first HashMap in the list.
	 * 
     * @param name the nameID of the symbol table
     * @param sym a symbol of symbol table 
     * 
     * @throws DuplicateSymException  If the first HashMap in the list already 
     * contains the given name as a key
     * @throws EmptySymTableException If this SymTable's list is empty
     */
	public void addDecl(String name, Sym sym) throws DuplicateSymException, EmptySymTableException {
		// If this SymTable's list is empty, throw an EmptySymTableException.
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		}
		// If either name or sym (or both) is null, throw a IllegalArgumentException.
		if (name == null || sym == null) {
			throw new IllegalArgumentException();
		}
		// If the first HashMap in the list already contains the given name as a key, 
		// throw a DuplicateSymException
		if (symList.get(0).containsKey(name)) {
			throw new DuplicateSymException();
		}
		// Otherwise, add the given name and sym to the first HashMap in the list.
		symList.get(0).put(name, sym);
	}
	
	/**
     * Add a new, empty HashMap to the front of the list.
     */
	public void addScope() {
		symList.add(0, new HashMap<String, Sym>());
    }
	
	/**
     * If this SymTable's list is empty, throw an EmptySymTableException. 
     * Otherwise, if the first HashMap in the list contains name as a key, 
     * return the associated Sym; otherwise, return null.
     * 
     * @param nameID of the symbol
     * @return the associated Sym in the first HashMap
     * @throws EmptySymTableException If this SymTable's list is empty
     */
	public Sym lookupLocal(String name) throws EmptySymTableException {
		// If this SymTable's list is empty, throw an EmptySymTableException. 
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		} 
		// Otherwise, if the first HashMap in the list contains name as a key, 
		// return the associated Sym;
		else if (symList.get(0).containsKey(name)) {
			return symList.get(0).get(name);
		} 
		// otherwise, return null.
		else {
			return null;
		}
	}
	
	/**
	 * If this SymTable's list is empty, throw an EmptySymTableException. 
	 * If any HashMap in the list contains name as a key, return the first 
	 * associated Sym (i.e., the one from the HashMap that is closest to the 
	 * front of the list); otherwise, return null.
	 * 
     * @param name the nameID for a symbol
     * @return the first associated symbol If any HashMap in the list contains name as a key
     * @throws EmptySymTableException If this SymTable's list is empty
     */
	public Sym lookupGlobal(String name) throws EmptySymTableException {
		// If this SymTable's list is empty, throw an EmptySymTableException. 
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		}
		// If any HashMap in the list contains name as a key, return the first 
		// associated Sym (i.e., the one from the HashMap that is closest to the front of the list)
		for (HashMap<String, Sym> listIterator : symList) {
			if (listIterator.containsKey(name)) {
				return listIterator.get(name);
			}
		}
		// otherwise, return null.
		return null;
	}
	
	/**
     * If this SymTable's list is empty, throw an EmptySymTableException; 
     * otherwise, remove the HashMap from the front of the list. To clarify, 
     * throw an exception only if before attempting to remove, the list is empty 
     * (i.e. there are no HashMaps to remove).
     *
     * @throws EmptySymTableException If this SymTable's list is empty
     */
	public void removeScope() throws EmptySymTableException {
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		} else {
			symList.remove(0);
		}
	}
	
	/**
     * This method is for debugging. First, print “\nSym Table\n”. Then, for each 
     * HashMap M in the list, print M.toString() followed by a newline. Finally, print 
     * one more newline. All output should go to System.out.
     */
	public void print() {
		System.out.print("\nSym Table\n");
		for (HashMap<String, Sym> listIterator: symList) {
			System.out.println(listIterator.toString());
			// System.out.println();
		}
		System.out.println();
		
	}
	
}
