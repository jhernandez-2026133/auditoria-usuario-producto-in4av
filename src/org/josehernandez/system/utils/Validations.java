/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {
    
    public Validations(){}
    
    public Boolean validatetextEmpty(String text){        
        boolean isEmpty = false;
        
        if( text.isEmpty() == true || text.isBlank() == true )
            isEmpty = true;
        return isEmpty;
    }
    
    public Boolean validateTextLenght (String text, int textmax){
        return text.length() <= textmax;
    }
    
    public Boolean equalsText(String textoOriginal, String textCompare){
        
        return textoOriginal.equals(textCompare);
    }
    
    public Boolean validateEmail(String email){
        int dotCount = 0; //contar el punto
        int arrobeCount = 0; //contar arroba
        //VALIDA PUNTO
        for( int index = 0; index < email.length(); index++){
            if(email.charAt(index) == '.')
                dotCount++;
            if( dotCount >1)
                return false;
        }
        //validar @
        for( int index = 0; index < email.length(); index++){
            if(email.charAt(index) == '@')
                arrobeCount++;

        }  
            if( arrobeCount != 1)
                return false;
            
            return true;
    }
}
