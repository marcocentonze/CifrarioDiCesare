
public class CifrarioDiCesare {
    private static final String DIZIONARIO = "abcdefghijklmnopqrstuvwxyz0123456789"; //dizionario lettere + numeri

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso <messaggio> <shift> <modalità(0/1)>");
            return;
        }
        //l'utente passa <messaggio_da_criptare_o_decriptare> <numero_di_shift> <modalità (1/0> 1 -> Crittografia , 2 -> Decrittografia)

        String messaggio = args[0].toLowerCase(); //convertiamo tutti i caratteri in lower case per semplicità
        int shift = Integer.parseInt(args[1]);//Il numero di posizioni per cui ogni lettera del messaggio verrà spostata nel dizionario durante la cifratura/decifratura.
        int modalità = Integer.parseInt(args[2]);
        String risultato = "";

        switch (modalità) {
            case 1:
                risultato = trasforma(messaggio, shift);
                break;
            case 0:
                risultato = trasforma(messaggio, -shift);
                break;
            default:
                System.out.println("Modalità non valida. Usa 1 per Crittografia e 0 per Decrittografia");
                return;
        }

        System.out.println("Risultato: " + risultato);
    }

    private static String cripta(String testo, int shift) {
        return trasforma(testo,shift);
    }

    private static String decripta(String testo, int shift) {
        return trasforma(testo,-shift);
    }

    public static String trasforma(String testo, int shift) {
        StringBuilder risultato = new StringBuilder();

        for (char carattere : testo.toCharArray()) {
            if(DIZIONARIO.indexOf(carattere) != -1) { 
                int posizioneOriginale = DIZIONARIO.indexOf(carattere);//vede per ogni carattere se è nel dizionario
                int nuovaPosizione = (DIZIONARIO.length() + posizioneOriginale + shift ) % DIZIONARIO.length(); //usiamo il modulo per renderlo sempre positivo e valido nella nostra lista di caratteri
                risultato.append(DIZIONARIO.charAt(nuovaPosizione));
            } else {
                risultato.append(carattere);
            }
        }
        return risultato.toString();
    }
    
}