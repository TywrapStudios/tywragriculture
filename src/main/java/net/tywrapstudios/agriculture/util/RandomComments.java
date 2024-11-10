package net.tywrapstudios.agriculture.util;

import java.util.List;
import java.util.Random;

public class RandomComments {

    private static final List<String> INIT_PHRASES = List.of(
            "Caught the baby bunny munching on my lettuce again... too cute to be mad!",
            "Little scarecrow standing so proudly, scaring off all the birdies like a champ.",
            "Farmer’s market? More like cuteness overload with all the tiny veggies lined up!",
            "Somehow, the cows are the happiest in the rain; they’ve got that mud-glow!",
            "Got a tiny, wiggly piglet today—cutest addition to the farm family.",
            "The sunflowers keep trying to outgrow me; little show-offs!",
            "Caught the sheep making a secret napping circle under the apple tree!",
            "Watching ducklings paddle around is peak farm happiness.",
            "Do cows know how cute they look chewing on a daisy? Because they should.",
            "Every time I look at the baby pumpkins, my heart just grows a little bigger.",
            "Chickens waddle-waddling after me like I'm their queen… farm royalty!",
            "Fawming Fwunny UwU",
            "Baby goats have the fluffiest little tails, and it's not even fair!",
            "The tomatoes are looking so plump, they almost make me wanna give 'em a name.",
            "Ran out of carrots because the bunnies got to them first—again!",
            "Just saw a lamb play-tag with a butterfly... hearts melting over here.",
            "If plants could giggle, the peas would be in stitches!",
            "These zucchinis look like they're flexing; okay, I see you.",
            "Horse tried to nibble my hat, and now it's officially a farm hat!",
            "When the rooster crows, the little ducklings try to join in. It’s... a sound.",
            "Harvested my first giant pumpkin, and I'm not saying it's my best friend, but..."
    );

    public static String generateInitComment() {
        Random random = new Random();
        return INIT_PHRASES.get(random.nextInt(INIT_PHRASES.size()));
    }
}
