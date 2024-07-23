import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------!");
        System.out.println("Willkommen im Schaltjahr-Überprüfungsprogramm!");
        System.out.println("------------------------------!");

        // Überprüfung eines einzelnen Jahres
        int jahr = getValidYear(scanner, "Bitte geben Sie eine Jahreszahl ein: ");
        if (istSchaltjahr(jahr)) {
            System.out.println("Das Jahr " + jahr + " ist ein Schaltjahr.");
        } else {
            System.out.println("Das Jahr " + jahr + " ist kein Schaltjahr.");
        }

        // Liste der Schaltjahre in einem Zeitraum
        int startJahr = getValidYear(scanner, "Bitte geben Sie den Startwert (Jahr) für den Zeitraum ein: ");
        int endJahr;
        while (true) {
            endJahr = getValidYear(scanner, "Bitte geben Sie den Endwert (Jahr) für den Zeitraum ein: ");
            if (endJahr >= startJahr) {
                break;
            } else {
                System.out.println("Fehler: Der Endwert muss größer oder gleich dem Startwert sein.");
            }
        }

        System.out.println("Liste der Schaltjahre von " + startJahr + " bis " + endJahr + ":");
        for (int i = startJahr; i <= endJahr; i++) {
            if (istSchaltjahr(i)) {
                System.out.println(i);
            }
        }

        scanner.close();
    }

    // Methode zur Überprüfung, ob ein Jahr ein Schaltjahr ist
    public static boolean istSchaltjahr(int jahr) {
        // Ein Jahr ist ein Schaltjahr, wenn es durch 4 teilbar ist
        if (jahr % 4 == 0) {
            if (jahr % 100 == 0) {
                if (jahr % 400 == 0) {
                    return true; // Jahr ist durch 4, 100 und 400 teilbar -> Schaltjahr
                } else {
                    return false; // Jahr ist durch 4 und 100, aber nicht durch 400 teilbar -> kein Schaltjahr
                }
            } else {
                return true; // Jahr ist durch 4, aber nicht durch 100 teilbar -> Schaltjahr
            }
        } else {
            return false; // Jahr ist nicht durch 4 teilbar -> kein Schaltjahr
        }
    }


    // Methode zur Validierung der Jahreseingabe
    public static int getValidYear(Scanner scanner, String prompt) {
        int jahr;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                jahr = scanner.nextInt();
                scanner.nextLine(); // Puffer leeren
                if (jahr >= 0) { // Optional: Überprüfen, ob das Jahr positiv ist
                    break;
                } else {
                    System.out.println("Fehler: Bitte geben Sie eine positive Jahreszahl ein.");
                }
            } else {
                System.out.println("Fehler: Bitte geben Sie eine gültige ganze Zahl ein.");
                scanner.nextLine(); // Ungültige Eingabe aus dem Puffer entfernen
            }
        }
        return jahr;
    }
}
