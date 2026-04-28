package homlockin;

import java.util.ArrayList;
import java.util.List;

public class Utvonal {
    private List<Utszakasz> utvonalatKeres;
    private int currentIndex = 0;

    public Utvonal() {
        this.utvonalatKeres = new ArrayList<>();
    }

    public void addUtszakasz(Utszakasz u) {
        this.utvonalatKeres.add(u);
    }

    public Utszakasz getKivantUtszakasz() {
        if (currentIndex < utvonalatKeres.size()) {
            return utvonalatKeres.get(currentIndex);
        }
        return null;
    }
    
    public void leptet() {
        currentIndex++;
    }

    public boolean isVege() {
        return currentIndex >= utvonalatKeres.size();
    }
    
    public void clear() {
        this.utvonalatKeres.clear();
        this.currentIndex = 0;
    }
}
