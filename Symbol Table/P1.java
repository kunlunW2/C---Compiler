/**
 * P1.java
 * Name: Kunlun Wang 
 * Email: kwang358@wisc.edu 
 * Student ID: 907-809-8895 
 * 
 * P1.java serves to test the functionalities of Sym and SymTable class
 * 
 */


public class P1 {

    /**
     * This is the main method of P1. It serves to execute each testing
     * that tests the functionalities of Sym and SymTable classes
     *
     * @param args not used
     */
    public static void main (String [] args) {

        System.out.println("----------Testing Starts----------"); 
        System.out.println(); 
        System.out.println("----------Testing Sym----------"); 
        // testSym() serves to test the constructor of Sym class
        testSym(); 
        // testGetType() serves to test the getType() method of Sym class 
        testGetType(); 
        // testToString() serves to test the toString() method of the the Sym class 
        testToString(); 

        System.out.println(); 
        System.out.println("----------Testing SymTable: Constructor----------"); 
        // testSymTable() serves to test the SymTable() constructor method of the SymTable class 
        testSymTable(); 
        System.out.println();
        // testAddDeclEmpty() serves to test the addDecl() method of the SymTable class
        // when there is no scope
        System.out.println("----------Testing SymTable: AddDecl()----------"); 
        testAddDeclEmpty(); 
        // testAddDeclNullName() serves to test the addDecl() method of SymTable clas 
        // when adding null name to the map 
        testAddDeclNullName(); 
        // testAddDeclNullSym() serves to test the addDecl() method of SymTable clas 
        // when adding null sym to the map 
        testAddDeclNullSym(); 
        // testAddDeclNullNameSym() serves to test the addDecl() method of SymTable clas 
        // when adding null name and sym to the map  
        testAddDeclNullNameSym(); 
        // testDuplicateName() serves to test the addDecl() method of SymTable clas 
        // when adding duplicate NameID   
        testDuplicateName(); 
        System.out.println(); 

        System.out.println("----------Testing SymTable: addScope()----------"); 
        // testAddScope() serves to test the functionality of addScope() when adding 
        // additional scope to the list
        testAddScope(); 
        System.out.println(); 

        System.out.println("----------Testing SymTable: lookupLocal()----------");
        // The below three testing methods serve to test when looking up names locally in
        // empty list, looking up existent nameID, and looking up non existent nameID
        testLookupLocalEmpty(); 
        testLookupLocalWithTarget();
        testLookupLocalWithoutTarget();
        System.out.println(); 

        System.out.println("----------Testing SymTable: lookupGlobal()----------");
        // The below four testing methods serve to test when looking up names gloablly in
        // empty list, looking up existent nameID, looking up non existent nameID, and
        // looking up names in multiple scope settings
        testLookupGlobalEmpty(); 
        testLookupGlobalWithTarget(); 
        testLookupGlobalWithoutTarget(); 
        testLookupGlobalMultipleScope(); 
        System.out.println(); 

        System.out.println("----------Testing SymTable: removeScope()----------");
        // The below two testing methods serve to test the functionality of removeScope() 
        // when trying to remove from empty list and non-empty list. 
        testRemoveEmptyScope ();
        testRemoveNotEmptyScope (); 
        System.out.println(); 

        System.out.println("----------Testing SymTable: print()----------");
        // testPrint() tests the functionality of print() method
        testPrint(); 
        System.out.println();
        System.out.println("---------Testing Ends---------"); 
    }
    

    /**
     * Test the constructor of Sym()
     */
    private static void testSym () {
        String testType = "SymType";
        try {
            Sym test_sym = new Sym (testType);
            System.out.println("Sym constructor test: Passed!");
        }
        catch (Exception e) {
            System.out.println("Sym constructor test: Failed! Exception was thrown. " +
            "Error message: " + e);
        }
    }
    
    /**
     * Test the getType() method of Sym()
     */
    private static void testGetType () {
        String testType = "symType"; 

        try {
            Sym test_sym = new Sym (testType);
            String symTypeReturn = test_sym.getType(); 
            if (symTypeReturn.equals("symType")) {
            System.out.println("Sym getType() test: Passed!"); 
            }
            else {
                System.out.println("Sym getType() test: Failed! Wrong return value. ");
            }
        }
        catch (Exception e) {
            System.out.println("Sym getType() test: Failed! Exception was thrown. " +
            "Error message: "+ e); 
        }
    }

    /**
     * Test the toString() method of Sym()
     */
    private static void testToString () {
        String testType = "symType"; 

        try {
            Sym test_sym = new Sym (testType); 
            String symTypeReturn = test_sym.toString(); 
            if (symTypeReturn.equals("symType")) {
                System.out.println("Sym toString() test: Passed!"); 
            }
            else {
                System.out.println("Sym toString() test: Failed! Wrong return value. ");
            }
        }
        catch (Exception e) {
            System.out.println("Sym toString() test: Failed! Exception was thrown. " + "Error message: "+ e); 
        } // testing for Sym class finished! 
    }

    /**
     * Test the constructor of symTable()
     */
    private static void testSymTable() {
        try {
            SymTable test_symTable = new SymTable (); 
            System.out.println("SymTable SymTable() test: Passed!");
        }
        catch (Exception e) {
            System.out.println("SymTable SymTable() test: Failed! Exception was thrown. " + 
            "Error message: "+ e);
        }
    }

    /**
     * Test the addDecl() method of symTable() when adding to empty list 
     */
    private static void testAddDeclEmpty() {

        String name = "one_1";
        String testType = "int"; 

        try {
            SymTable test_list_empty = new SymTable (); 

            Sym test_sym_type = new Sym (testType);

            // now we need to determine whether SymTable's list is empty. 
            // By calling removeScope, if the list is empty, EmptySymTableException 
            // will be throw. 
            test_list_empty.removeScope(); 
            
            test_list_empty.addDecl(name, test_sym_type);
            
            System.out.println("SymTable testAddDeclEmpty() test: Failed! No exception was thrown when attempting to remove from empty list. ");
            test_list_empty.addDecl (name, test_sym_type); 
        }

        // we should expect this exception to be thrown 
        catch (EmptySymTableException e) {
            System.out.println ("SymTable testAddDeclEmpty() test: Passed! Exception successfully caught. " );
        }
        // we typically don't expect other kinds of exceptions to be caught here
        catch (Exception e) {
            System.out.println ("SymTable testAddDeclEmpty() test: Other Exceptions were caught. " );
        }
    }

    /**
     * Test the addDecl() method of symTable() when adding to null NameID 
     */
    private static void testAddDeclNullName () {

        String testType = "int"; 
        try {
            SymTable test_add_null_name = new SymTable (); 
            Sym test_sym_type = new Sym (testType);
            test_add_null_name.addDecl(null, test_sym_type); 
            System.out.println("SymTable testAddDeclNullName() test: Failed! No exception was thrown when attempting to add null name.");
        }
        catch (IllegalArgumentException e) {
            System.out.println ("SymTable testAddDeclNullName() test: Passed! Exception was successfully caught when attempting to add null name. " );
        }
        catch (Exception e) {
            System.out.println ("SymTable testAddDeclNullName() test: Other Exceptions were caught. " );
        }
    }

    /**
     * Test the addDecl() method of symTable() when adding null Sym
     */
    private static void testAddDeclNullSym () {
        String name = "one_1"; 
        try {
            SymTable test_add_null_sym = new SymTable (); 
            test_add_null_sym.addDecl(name, null); 
            System.out.println("SymTable testAddDeclNullSym() test: Failed! No exception was thrown when attempting to add null sym.");
        }
        catch (IllegalArgumentException e) {
            System.out.println ("SymTable testAddDeclNullSym() test: Passed! Exception was successfully caught when attempting to add null sym. " );
        }
        catch (Exception e) {
            System.out.println ("SymTable testAddDeclNullSym() test: Other Exceptions were caught. " );
        }
    }

    /**
     * Test the addDecl() method of symTable() when adding null Name and Sym 
     */
    private static void testAddDeclNullNameSym () {
        try {
            SymTable test_add_null = new SymTable (); 
            test_add_null.addDecl(null, null); 
            System.out.println("SymTable testAddDeclNull() test: Failed! No exception was thrown when attempting to add null name and sym.");
        }
        catch (IllegalArgumentException e) {
            System.out.println ("SymTable testAddDeclNull() test: Passed! Exception was successfully caught when attempting to add  null name and sym. " );
        }
        catch (Exception e) {
            System.out.println ("SymTable testAddDeclNull() test: Other Exceptions were caught. " );
        }
    }

    /**
     * Test the addDecl() method of symTable() when adding duplicate NameID
     */
    private static void testDuplicateName() {
    
        String name_1 = "one_1";
        String name_2 = "two_2"; 
        String name_3 = "three_3"; 
        String testType_1 = "int"; 
        String testType_2 = "long"; 

        try {
            SymTable test_duplicate_name = new SymTable (); 
            Sym test_sym_type_1 = new Sym (testType_1);
            Sym test_sym_type_2 = new Sym (testType_2);

            test_duplicate_name.addDecl(name_1, test_sym_type_1);
            test_duplicate_name.addDecl(name_2, test_sym_type_2);
            test_duplicate_name.addDecl(name_3, test_sym_type_1);
            test_duplicate_name.addDecl(name_3, test_sym_type_2);
            System.out.println("SymTable testDuplicateName() test: Failed! No exception was thrown when attempting to add duplicate name.");
        }
        catch (DuplicateSymException e) {
            System.out.println ("SymTable testDuplicateName() test: Passed! Exception was successfully caught when attempting to add duplicate name. " );
        }
        catch (Exception e) {
            System.out.println ("SymTable testDuplicateName() test: Other Exceptions were caught. " );
        }
    }

    /**
     * Test the addScope() method of symTable() 
     */
    private static void testAddScope() {
        try{
            SymTable test_add_scope = new SymTable (); 
            test_add_scope.addScope(); 
            test_add_scope.addScope(); 
            test_add_scope.addScope(); 
            System.out.println("SymTable testAddScope() test: Passed! No exceptions were thrown. ");
        }
        catch (Exception e) {
            System.out.println ("SymTable testAddScope() test: Failed! Exceptions were caught. " );
        }
    }


    /**
     * Test the lookupLocal() method of symTable() when SymTable is empty 
     */
    private static void testLookupLocalEmpty() {
        String name_1 = "one_1"; 
        try {
            SymTable test_lookup_local = new SymTable (); 
            // we need to delete the single hashmap created by the constructor and test
            test_lookup_local.removeScope(); 
            // At this point, lookupLocal() method should throw a EmptySymtableException
            test_lookup_local.lookupLocal(name_1); 
            System.out.println("SymTable testLookupLocalEmpty() test: Failed! Failed to throw an exception when trying to look up in an empty list.");
        }
        // this exception should be caught
        catch (EmptySymTableException e) {
            System.out.println ("SymTable testLookupLocalEmpty() test: Passed! EmptySymtableException caught when attempting to look up empty list. ");
        }
        catch (Exception e) {
            System.out.println ("SymTable testLookupLocalEmpty() test: Failed! Exceptions were caught. " );
        }
    }

    /**
     * Test the lookupLocal() method of symTable() when target is present locally 
     */
    private static void testLookupLocalWithTarget() {
        String name_1 = "one_1";
        String name_2 = "two_2"; 
        String name_3 = "three_3"; 
        String name_4 = "four_4"; 
        String testType_1 = "int"; 
        String testType_2 = "long"; 
        String testType_3 = "char";
        String testType_4 = "float"; 
    

        try {
            SymTable test_lookup_local_with_target = new SymTable (); 
            Sym test_sym_type_1 = new Sym (testType_1);
            Sym test_sym_type_2 = new Sym (testType_2);
            Sym test_sym_type_3 = new Sym (testType_3);
            Sym test_sym_type_4 = new Sym (testType_4);

            test_lookup_local_with_target.addDecl(name_1, test_sym_type_1);
            test_lookup_local_with_target.addDecl(name_2, test_sym_type_2);
            test_lookup_local_with_target.addDecl(name_3, test_sym_type_3);
            test_lookup_local_with_target.addDecl(name_4, test_sym_type_4);

            Sym test_return_value = test_lookup_local_with_target.lookupLocal(name_1);
            String test_return_value_type = test_return_value.getType(); 

            if (test_return_value != null && test_return_value_type.equals(testType_1)) {
                System.out.println("SymTable testLookupLocalWithTarget() test: Passed! ");
            }
            else {
                System.out.println("SymTable testLookupLocalWithTarget() test: Failed! ");
            }
        }
        catch (Exception e) {
            System.out.println ("SymTable testLookupLocalWithTarget() test: Failed! Exceptions were caught. " );
        }
    }

    /**
     * Test the lookupLocal() method of symTable() when target is not present locally
     */
    private static void testLookupLocalWithoutTarget () {
        String name_1 = "one_1";
        String name_2 = "two_2"; 
        String name_3 = "three_3"; 
        String name_4 = "four_4"; 
        String testType_1 = "int"; 
        String testType_2 = "long"; 
        String testType_3 = "char";
        String testType_4 = "float"; 

        try {
            SymTable test_lookup_global_without_target = new SymTable (); 
            Sym test_sym_type_1 = new Sym (testType_1);
            Sym test_sym_type_2 = new Sym (testType_2);
            Sym test_sym_type_3 = new Sym (testType_3);
            Sym test_sym_type_4 = new Sym (testType_4);

            test_lookup_global_without_target.addDecl(name_1, test_sym_type_1);
            test_lookup_global_without_target.addDecl(name_2, test_sym_type_2);
            test_lookup_global_without_target.addDecl(name_3, test_sym_type_3);

            Sym test_return_value = test_lookup_global_without_target.lookupLocal(name_4);
            // String test_return_value_type = test_return_value.getType(); 

            if (test_return_value == null) {
                System.out.println("SymTable testLookupLocalWithoutTarget() test: Passed! Return null when looking gloablly non existent NameID NameID.");
            }
            else {
                System.out.println("SymTable testLookupLocalWithoutTarget() test: Failed! Not returning null when looking for non existent nameID.");
            }
        }
        catch (Exception e) {
            System.out.println("SymTable testLookupLocalWithoutTarget() test: Failed! Exceptions were thrown.");
        }
    }

    /**
     * Test the lookupGlobal() method of symTable() when SymTable is empty 
     */
    private static void testLookupGlobalEmpty() {
        String name_1 = "one_1"; 
        try {
            SymTable test_lookup_local = new SymTable (); 
            // we need to delete the single hashmap created by the constructor and test
            test_lookup_local.removeScope(); 
            // At this point, lookupLocal() method should throw a EmptySymtableException
            test_lookup_local.lookupGlobal(name_1); 
            System.out.println("SymTable testLookupGlobalEmpty() test: Failed! Failed to throw an exception when trying to look up in an empty list.");
        }
        catch (EmptySymTableException e) {
            System.out.println ("SymTable testLookupGlobalEmpty() test: Passed! EmptySymtableException caught when attempting to look up empty list. ");
        }
        catch (Exception e) {
            System.out.println ("SymTable testLookupGlobalEmpty() test: Failed! Exceptions were caught. " );
        }
    }

    /**
     * Test the lookupLocal() method of symTable() when target is present globally
     */
    private static void testLookupGlobalWithTarget() {
        String name_1 = "one_1";
        String name_2 = "two_2"; 
        String name_3 = "three_3"; 
        String name_4 = "four_4"; 
        String testType_1 = "int"; 
        String testType_2 = "long"; 
        String testType_3 = "char";
        String testType_4 = "float"; 

        try {
            SymTable test_lookup_global_with_target = new SymTable (); 
            Sym test_sym_type_1 = new Sym (testType_1);
            Sym test_sym_type_2 = new Sym (testType_2);
            Sym test_sym_type_3 = new Sym (testType_3);
            Sym test_sym_type_4 = new Sym (testType_4);

            test_lookup_global_with_target.addDecl(name_1, test_sym_type_1);
            test_lookup_global_with_target.addDecl(name_2, test_sym_type_2);
            test_lookup_global_with_target.addDecl(name_3, test_sym_type_3);
            test_lookup_global_with_target.addDecl(name_4, test_sym_type_4);

            Sym test_return_value = test_lookup_global_with_target.lookupGlobal(name_1);
            String test_return_value_type = test_return_value.getType(); 

            if (test_return_value != null && test_return_value_type.equals(testType_1)) {
                System.out.println("SymTable testLookupGlobalWithTarget() test: Passed! ");
            }
            else {
                System.out.println("SymTable testLookupGlobalWithTarget() test: Failed! ");
            }
        }
        catch (Exception e) {
            System.out.println ("SymTable testLookupGlobalWithTarget() test: Failed! Exceptions were caught. " );
        }
    }

    /**
     * Test the lookupLocal() method of symTable() when target is not present globally
     */
    private static void testLookupGlobalWithoutTarget() {
        String name_1 = "one_1";
        String name_2 = "two_2"; 
        String name_3 = "three_3"; 
        String name_4 = "four_4"; 
        String name_5 = "five_5";
        String testType_1 = "int"; 
        String testType_2 = "long"; 
        String testType_3 = "char";
        String testType_4 = "float"; 

        try {
            SymTable test_lookup_global_without_target = new SymTable (); 
            Sym test_sym_type_1 = new Sym (testType_1);
            Sym test_sym_type_2 = new Sym (testType_2);
            Sym test_sym_type_3 = new Sym (testType_3);
            Sym test_sym_type_4 = new Sym (testType_4);

            test_lookup_global_without_target.addDecl(name_1, test_sym_type_1);
            test_lookup_global_without_target.addDecl(name_2, test_sym_type_2);

            // now we add another scope, see how the second scope also has a name_2
            test_lookup_global_without_target.addScope(); 
            test_lookup_global_without_target.addDecl(name_3, test_sym_type_3);
            test_lookup_global_without_target.addDecl(name_4, test_sym_type_4);

            Sym test_return_value = test_lookup_global_without_target.lookupGlobal(name_5);
            // String test_return_value_type = test_return_value.getType(); 

            if (test_return_value == null) {
                System.out.println("SymTable testLookupGlobalWithoutTarget() test: Passed! Return null when looking gloablly non existent NameID NameID.");
            }
            else {
                System.out.println("SymTable testLookupGlobalWithoutTarget() test: Failed! Not returning null when looking for non existent nameID.");
            }
        }
        catch (Exception e) {
            System.out.println("SymTable testLookupGlobalWithoutTarget() test: Failed! Exceptions were thrown.");
        }
    }

    /**
     * Test the lookupLocal() method of symTable() when there are multiple scopes. 
     * Return the first associated sym when there exists multiple scopes
     */
    private static void testLookupGlobalMultipleScope() {
        String name_1 = "one_1";
        String name_2 = "two_2"; 
        String name_3 = "three_3"; 
        String name_4 = "four_4"; 
        String testType_1 = "int"; 
        String testType_2 = "long"; 
        String testType_3 = "char";
        String testType_4 = "float"; 

        try {
            SymTable test_lookup_global_multiple_scope = new SymTable (); 
            Sym test_sym_type_1 = new Sym (testType_1);
            Sym test_sym_type_2 = new Sym (testType_2);
            Sym test_sym_type_3 = new Sym (testType_3);
            Sym test_sym_type_4 = new Sym (testType_4);

            test_lookup_global_multiple_scope.addDecl(name_1, test_sym_type_1);
            test_lookup_global_multiple_scope.addDecl(name_2, test_sym_type_2);

            // now we add another scope, see how the second scope also has a name_2
            test_lookup_global_multiple_scope.addScope(); 
            test_lookup_global_multiple_scope.addDecl(name_2, test_sym_type_3);
            test_lookup_global_multiple_scope.addDecl(name_3, test_sym_type_3);

            // the return sym should be of test_sym_type_3 (since the new scope is added 
            // to the front of the list.
            Sym test_return_value = test_lookup_global_multiple_scope.lookupGlobal(name_2);
            String test_return_value_type = test_return_value.getType(); 

            if ((test_return_value != null) && (test_return_value_type.equals(testType_3))) {
                System.out.println("SymTable testLookupGlobalMultipleScope() test: Passed! First Sym found! ");
            }
            else {
                System.out.println("SymTable testLookupGlobalMultipleScope() test: Failed! Wrong return value OR Sym! ");
            }
        }
        catch (Exception e) {
            System.out.println ("SymTable testLookupGlobalMultipleScope() test: Failed! Exceptions were caught. " );
        }
    }

    
    /**
     * Test the removeScope() method of symTable() when is it empty
     */
    private static void testRemoveEmptyScope () {
        try {
            // now there is a single map 
            SymTable test_remove_scope = new SymTable (); 
            test_remove_scope.removeScope(); // this shouldn't throw exception 
            test_remove_scope.removeScope(); // this should throw exception 
            System.out.println("SymTable testRemoveScope() test: Failed! No EmptySymTableException was thrown when attempting to remove from empty symbol table. ");
        }
        catch (EmptySymTableException e) {
            System.out.println("SymTable testRemoveScope() test: Passed! EmptySymTableException caught when attempting to remove from empty symbol table. ");
        }

        catch (Exception e) {
            System.out.println("SymTable testRemoveScope() test: Failed! Other exceptions were thrown when removing from empty symbol table. ");
        }
    }

    /**
     * Test the removeScope() method of symTable() when is it not empty
     */
    private static void testRemoveNotEmptyScope () {
        try {
            SymTable test_remove_not_empty_scope = new SymTable (); 
            test_remove_not_empty_scope.addScope();
            test_remove_not_empty_scope.addScope();
            test_remove_not_empty_scope.addScope();
            test_remove_not_empty_scope.addScope();
            test_remove_not_empty_scope.removeScope();
            test_remove_not_empty_scope.removeScope();
            test_remove_not_empty_scope.removeScope();
            test_remove_not_empty_scope.removeScope(); 
            // No exceptions should be thrown because there is still an empty scope at this point 
            System.out.println("SymTable testRemoveNotEmptyScope () test: Passed! No exceptions thrown. ");
        }
        catch (Exception e) {
            System.out.println("SymTable testRemoveNotEmptyScope () test: Failed! Exceptions were thrown. ");
        }
    }

    /**
     * Test the print() method of symTable()
     */
    private static void testPrint() {
        try {
            SymTable test_print = new SymTable (); 
            test_print.print(); 
            System.out.println("SymTable testPrint() test: Passed! No exceptions thrown. ");
        }
        catch (Exception e){
            System.out.println("SymTable testPrint() test: Failed! Exceptions were thrown. ");
        }
    }
    }