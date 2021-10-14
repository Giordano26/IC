package Lexer;
import Token.Token;

public class Lexer{
    private String input;
    private int position;
    private int readPosition;
    private char ch;

    public Token NextToken(){
       Token tk;

       skipWhitespace();

       switch (ch) {
            case '+':
                tk = Token.PLUS;
                break;
            case '-':
                tk = Token.MINUS;
                break;
            case '/':
                tk = Token.SLASH;
                break;
            case '*':
                tk = Token.ASTERISK;
                break;
            case '(':
                tk = Token.LPAREN;
                break;
            case ')':
                tk = Token.RPAREN;
            case 0:
                tk = Token.EOF; //End of file
                break;
            
            default:
                tk = Token.INT;
                tk.literal = readNumber();

       }   


       readChar();
       return tk;


    }

    private void readChar(){
        if(readPosition >= input.length()){
            ch = 0; // Verificamos se a proxima posição é um EOF, se for indicamos isso com um 0
        } else {
            ch = input.charAt(readPosition); // Se não, lemos o caractere que a posição representa
        }

        position = readPosition; // Sempre guardamos a ultima posição no position
        readPosition += 1;
    }


    private char peekChar(){
        if(readPosition > input.length()){
            return 0;
        } else{
            return input.charAt(readPosition);
        }
    }


    private String skipWhitespace(){
        return input.replaceAll(" ","");
    }


    private Boolean isDigit(char ch){
        if(ch == Character.MIN_VALUE){
            return false;
        }
        try{
            double d = (double) (ch - '0');
        } catch(NumberFormatException nfe){
            return false;
        }

        return true;

    }
    private String readNumber(){
        int first_position = position;

        while(isDigit(ch)){
            readChar();
        }

        return input.substring(first_position,position); // "800"
    }

}