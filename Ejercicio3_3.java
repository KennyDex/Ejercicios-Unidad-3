public class Ejercicio3_3{
    
    protected char[] encod = new char[28];
    protected char[] decod = new char[28];

    public Ejercicio3_3(int rotacion){
        for(int i = 0; i < 28; i++){
            encod[i] = (char) ('A' + (i + rotacion) % 28);
            decod[i] = (char) ('A' + (i - rotacion + 28)% 28);
        }
    }

    private String tranformar(String original, char[] code){
        char[] msg = original.toCharArray();
        for(int i = 0; i < msg.length;){
            if(Character.isUpperCase(msg[i])){
                int j = msg[i] - 'A';
                msg[i] = code[j];
            }
        }
        return new String(msg);
    }

    public String encriptar(String mensaje){
        return tranformar(mensaje, encod);
    }

    public String desencriptar(String secret){
        return tranformar(secret, decod);
    }

    public static void main(String[] args) {
        Ejercicio3_3 cyph = new Ejercicio3_3(3);
        System.out.println("Encryption code = " + new String(cyph.encod));
        System.out.println("Decryption code = " + new String(cyph.decod));
        String mensaje = "THE EAGLE IS A PLAY; MEET A JOE'S.";
        String coded = cyph.encriptar(mensaje);
        System.out.println("Secret: " + coded);
        String answer = cyph.desencriptar(coded);
        System.out.println("Message: " + answer);
    }
}