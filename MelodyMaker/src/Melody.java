import java.util.LinkedList;
import java.util.Queue;

public class Melody {
    private Queue<Note> notes = new LinkedList<>();

    public Melody(Queue<Note> song) {
        notes = song;
    }

    public double getTotalDuration() {
        double notesSum = 0;
        boolean repeated = false;
        boolean done = false;

        for (int i = 0; i < notes.size(); i++) {
            Note n = notes.poll();
            if (repeated) {
                if (n.isRepeat()) {
                    notesSum += n.getDuration();
                    repeated = false;
                    done = true;
                } else {
                    notesSum += n.getDuration();
                }
            }
            if (n.isRepeat()) {
                if (!done) {
                    repeated = true;
                    notesSum += n.getDuration();
                }
            }
            notesSum += n.getDuration();
            notes.offer(n);
        }
        return notesSum;
    }

    public void changeTempo(double tempo) {
        for (int i = 0; i < notes.size(); i++) {
            Note n = notes.poll();
            n.setDuration(n.getDuration() / tempo);
            notes.offer(n);
        }
    }

    public void reverse() {
        Note[] array = new Note[notes.size()];
        for (int i = 0; i < notes.size(); i++) {
            array[i] = notes.poll();
        }
        for (int i = notes.size() - 1; i >= 0; i--) {
            notes.offer(array[i]);
        }
    }

    public void append(Melody other) {
        for (int i = 0; i < other.notes.size(); i++) {
            this.notes.offer(other.notes.poll());
        }
    }

    public void play() {
        for (int i = 0; i < notes.size(); i++) {
            Note n = notes.poll();
            n.play();
            notes.offer(n);
        }
    }

    public Queue<Note> getNotes() {
        return notes;
    }



}
