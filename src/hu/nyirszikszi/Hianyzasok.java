package hu.nyirszikszi;

class Hianyzasok {
    private String nev;
    private String osztaly;
    private int elsoNap;
    private int utolsoNap;
    private int mulasztottOrak;

    Hianyzasok(String nev, String osztaly, int elsoNap, int utolsoNap, int mulasztottOrak) {
        this.nev = nev;
        this.osztaly = osztaly;
        this.elsoNap = elsoNap;
        this.utolsoNap = utolsoNap;
        this.mulasztottOrak = mulasztottOrak;
    }

    String getNev() {
        return nev;
    }

    String getOsztaly() {
        return osztaly;
    }

    int getElsoNap() {
        return elsoNap;
    }

    int getUtolsoNap() {
        return utolsoNap;
    }

    int getMulasztottOrak() {
        return mulasztottOrak;
    }

    @Override
    public String toString() {
        return "Hianyzasok{" +
                "nev='" + nev + "'" +
                ", osztaly='" + osztaly + "'" +
                ", elsoNap=" + elsoNap +
                ", utolsoNap=" + utolsoNap +
                ", mulasztottOrak=" + mulasztottOrak +
                "}\n";
    }
}