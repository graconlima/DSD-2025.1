package tcp.arcoeflecha;

public class Flecha {
    private int x;
    private int y;
    private String nome;
    
    public Flecha(String tentativa){
        String[] s = tentativa.split(":");
        if(s.length == 3){
            nome = s[0];
            x = Integer.parseInt(s[1]);
            y = Integer.parseInt(s[2]);
        }else{
            System.out.println("Fora de formato");
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
