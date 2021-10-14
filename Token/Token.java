package Token;

public enum Token{


    //Operadores
    PLUS("+"),
    MINUS("-"),
    ASTERISK("*"),
    SLASH("/"),
    
    //Delimitadores
    LPAREN("("),
    RPAREN(")"),
    
    EOF(""),
    INT("INT");
    
    
    private String token;
    
    Token(String token){
        this.token = token;
    }
    
    public String getToken(){
        return token;
    }
    
    public String literal;
}
