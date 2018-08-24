package app.udacity.libjokes;

import java.util.Random;

public class Joke {
    // Jokes from https://short-funny.com/
    private String[] jokeList = {
            "Can a kangaroo jump higher than a house? \n" +
                    "Of course, a house doesn’t jump at all.",
            "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                    "\n" +
                    "Doctor: \"Nine.\"\n",
            "Anton, do you think I’m a bad mother?\n" +
                    "\n" +
                    "My name is Paul.\n",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.\n",
            "What is the difference between a snowman and a snowwoman?\n" +
                    "-\n" +
                    "Snowballs.\n",
            "Mother: \"How was school today, Patrick?\"\n" +
                    "\n" +
                    "Patrick: \"It was really great mum! Today we made explosives!\"\n" +
                    "\n" +
                    "Mother: \"Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow?\"\n" +
                    "\n" +
                    "Patrick: \"What school?\"\n",
            "\"Mom, where do tampons go?\"\n" +
                    "\n" +
                    "\"Where the babies come from, darling.\"\n" +
                    "\n" +
                    "\"In the stork?\"\n",
            "Man to his priest: “Yesterday I sinned with an 18 year old girl.”\n" +
                    "\n" +
                    "The priest: “Squeeze 18 lemons and drink the juice all at once.”\n" +
                    "\n" +
                    "Man: “And that frees me from my sin?”\n" +
                    "\n" +
                    "Priest: “No, but it frees your face from that dirty grin.” ",
            "Doctor: “I’ve found a great new drug that can help you with your sleeping problem.”\n" +
                    " \n" +
                    "Patient: “Great, how often do I have to take it?”\n" +
                    " \n" +
                    "Doctor: “Every two hours.“"
    };

    private String jokeDetail;

    public String getJokeDetail() {
        return jokeDetail = getRandomJoke();
    }

    private String getRandomJoke() {
        return jokeList[new Random().nextInt(jokeList.length + 1)];
    }
}