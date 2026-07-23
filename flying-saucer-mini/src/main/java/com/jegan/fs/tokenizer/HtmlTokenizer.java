public class HtmlTokenizer
{
    public List<Token> tokenize(String html)
    {
        int start = 0;
        List<Token> tokens = new ArrayList<>();
        int len = html.length();
        while (start < len)
        {
            int end;
            char currentCharacter = html.charAt(start);
            if (currentCharacter == '<')
            {
                end = html.indexOf('>', start);
                String tag = html.substring(start + 1, end);
                if (tag.charAt(0) == '/')
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
                end = html.indexOf('<', start);
                if (end == -1)
                {
                    end = len;
                }
                String text = html.substring(start, end).trim();
                if (!text.isEmpty())
                {
                    tokens.add(new Token(TokenType.TEXT, text));
                }
            }
            start = end + 1;
        }
        return tokens;
    }
}