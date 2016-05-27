package org.ahocorasick.Genome;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Token;
import org.ahocorasick.trie.Trie;

import java.util.Collection;

/**
 * Created by EdwardChor on 5/26/16.
 */
public class ACmain {
    public static void main(String argv[]){
        String speech = "The Answer to the Great Question... Of Life, " +
                "the Universe and Everything... Is... Forty-two,' said " +
                "Deep Thought, with infinite majesty and calm.";
        Trie trie = Trie.builder().removeOverlaps().onlyWholeWords().caseInsensitive()
                .addKeyword("great question")
                .addKeyword("forty-two")
                .addKeyword("deep thought")
                .build();
        Collection<Token> tokens = trie.tokenize(speech);
        StringBuffer html = new StringBuffer();
        html.append("<html><body><p>");
        for (Token token : tokens) {
            if (token.isMatch()) {
                html.append("<i>");
            }
            html.append(token.getFragment());
            if (token.isMatch()) {
                html.append("</i>");
            }
        }
        html.append("</p></body></html>");
        System.out.println(html);
    }
}
