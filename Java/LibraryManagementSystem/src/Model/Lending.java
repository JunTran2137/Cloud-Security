package Model;

public class Lending {
    private String bCode;
    private String rCode;
    private int state;

    public Lending() {
    }

    public Lending(String bCode, String rCode, int state) {
        this.bCode = bCode;
        this.rCode = rCode;
        this.state = state;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
   
    @Override
    public String toString(){
        return String.format("%-6s| %-6s| %-9d", bCode, rCode, state);
    }
}
