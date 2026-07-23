public class HtmlTokenizer
{
    public static List<Token> tokenize(String html)
    {
        int start = 0;
        List<Token> tokens = new ArrayList<>();
        int len = html.length();
        while (start < len)
        {
            char currentCharacter = html.charAt(start);
            if (currentCharacter == '<')
            {
                int end = html.indexOf('>', start);
                String tag = html.substring(start + 1, end);
                if (tag.indexOf(0) == '\\')
                {
                    tokens.add(new Token(TokenType.CLOSE_TAG, tag.substring(1)));
                }
                else
                {
                    tokens.add(new Token(TokenType.OPEN_TAG, tag));
                }
            }
            else
            {
                int end = html.indexOf('<', start);
                String text = html.substring(start, end).trim();
                tokens.add(new Token(TokenType.TEXT, text));
            }
            start = end + 1;
        }
        return tokens;
    }
}