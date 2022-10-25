public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op -[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] s) {
        GuitarString[] strings = new GuitarString[37];

        for (int i = 0; i < strings.length; i++) {
            double frequency = Math.pow(1.05956, i - 24) * 440;
            GuitarString g = new GuitarString(frequency);
            strings[i] = g;
        }

        while (true) {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index == -1) {
                    continue;
                }
                strings[index].pluck();
            }
            //strings[index].pluck();


            //
            double sample = 0;

            for (int i = 0; i < strings.length; i++) {
                sample += strings[i].sample();

            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < strings.length; i++) {
                strings[i].tic();
            }
            //
        }


    }
}
