public class Token {
    private final TokenType tokenType;
    private final String value;

    public Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public TokenType getTokenType() {
        return this.tokenType;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return tokenType.type + "(" + getValue() + ")";
    }
}
