public class DistinctCharContainer {
    int[] char_positions;
    int no_uniques = 0;

    DistinctCharContainer() {
        char_positions = new int[26];
    }

    public void add(char x) {
        int pos = (int) x - (int) 'a';
        if (char_positions[pos] == 0) {
            no_uniques++;
        }
        char_positions[pos]++;
    }

    public void remove(char x) {
        int pos = (int) x - (int) 'a';
        if ((char_positions[pos] - 1) == 0) {
            no_uniques--;
        }
        char_positions[pos]--;
    }

    public int uniques() {
        return no_uniques;
    }
}
