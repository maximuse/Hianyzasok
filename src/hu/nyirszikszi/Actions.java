package hu.nyirszikszi;

import java.io.RandomAccessFile;
import java.util.*;

class Actions {
    private static int day;
    private static String name;

    private static int getDay() {
        return day;
    }

    private static void setDay(int day) {
        Actions.day = day;
    }

    private static String getName() {
        return name;
    }

    private static void setName(String name) {
        Actions.name = name;
    }

    static ArrayList<Hianyzasok> fileToList(String fileName) {
        ArrayList<Hianyzasok> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            row = raf.readLine();
            String[] slice;

            while (row != null) {
                slice = row.split(";");

                list.add(new Hianyzasok(slice[0], slice[1], Integer.parseInt(slice[2]), Integer.parseInt(slice[3]), Integer.parseInt(slice[4])));

                row = raf.readLine();
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    static String task2(ArrayList<Hianyzasok> list) {
        int sum = 0;

        for (Hianyzasok hianyzasok : list) {
            sum += hianyzasok.getMulasztottOrak();
        }

        return "\n\tÖsszes mulasztott órák száma: " + sum + " óra.";
    }

    static void task3() {
        Scanner s = new Scanner(System.in);

        try {
            System.out.print("\tKérem adjon meg egy napot: ");
            int day = Integer.parseInt(s.nextLine());

            if (day >0 && day < 30) {
                setDay(day);
            }
            else {
                throw new Exception("\tA napnak 1 és 30 közé kell esnie!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("\tTanuló neve: ");
            setName(s.nextLine());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        s.close();
    }

    static String task4(ArrayList<Hianyzasok> list) {
        boolean error = false;
        String result;

        for (Hianyzasok hianyzasok : list) {
            if (hianyzasok.getNev().equals(getName())) {
                error = true;
                break;
            }
        }

        if (error) {
            result = "A tanuló hiányzott szeptemberben.";
        }
        else {
            result = "A tanuló nem hiányzott szeptemberben.";
        }

        return "\n\t" + result;
    }

    static StringBuilder task5(ArrayList<Hianyzasok> list) {
        StringBuilder result = new StringBuilder();

        list.sort(Comparator.comparing(Hianyzasok::getOsztaly));

        if (getDay() != 0) {
            result.append("Hiányzók 2017. 09. " + getDay() + ".-n:");

            for (Hianyzasok hianyzasok : list) {
                for (int i = hianyzasok.getElsoNap(); i <= hianyzasok.getUtolsoNap(); i++) {
                    if (i == getDay()) {
                        result.append("\n\t" + hianyzasok.getNev() + " (" + hianyzasok.getOsztaly() + ")");
                        break;
                    }
                }
            }
        }
        else {
            result.append("\n\tÉrvénytelen napot adatott adott meg a 3. feladatban!");
        }

        return result;
    }

    static String task6(ArrayList<Hianyzasok> list, String fileName) {
        TreeSet<String> classes = new TreeSet<>();
        int counter = 0;

        list.sort(Comparator.comparing(Hianyzasok::getOsztaly));

        for (Hianyzasok hianyzasok : list) {
            classes.add(hianyzasok.getOsztaly());
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

            for (String cls : classes) {
                for (Hianyzasok hianyzasok : list) {
                    if (hianyzasok.getOsztaly().equals(cls)) {
                        counter += hianyzasok.getMulasztottOrak();
                    }
                }

                raf.writeBytes(cls + " - " + counter + "\r\n");
                counter = 0;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return fileName;
    }
}