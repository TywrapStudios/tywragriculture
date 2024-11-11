package net.tywrapstudios.agriculture.util;

import java.util.List;
import java.util.Random;

public class RandomComments {

    private static final List<String> INIT_PHRASES = List.of(
            "Do cows know how cute they look chewing on a daisy? Because they should.",
            "Every time I look at the baby pumpkins, my heart just grows a little bigger.",
            "Fawming Fwunny UwU",
            "These zucchinis look like they're flexing; okay, I see you.",
            "When the rooster crows, the little ducklings try to join in. It’s... certainly a sound.",
            "Harvested my first giant pumpkin, and I'm not saying it's my best friend, but hear me out...",
            "Ah yes I love Config formatting version AAAA it reminds me of my mental health.",
            "Dot put te fok in te micorwafe waltuh",
            "Roses are red, violets are blue, unexpected \"{\" at line 32.",
            "So like what the f*ck is a Tywrgaricultuerre?",
            "garlic bread?",
            "\"glorps glop bieb bobls\" ~ The Aliens saying this mod is fire",
            "ORAJ POLE NA TRAKTORE HEY HOOP SJABADABA",
            "Z-O-O-M, talk a lot on Twitter bish I'm not yo friend",
            "I love it when the little piglets play together. So cute I could combust!"
    );

    public static String generateInitComment() {
        return INIT_PHRASES.get(new Random().nextInt(INIT_PHRASES.size()));
    }
}
