package Model;

public class Reader {
    private String rCode;
    private String name;
    private int bYear;

    public Reader() {
    }

    public Reader(String rCode, String name, int bYear) {
        this.rCode = rCode;
        this.name = name;
        this.bYear = bYear;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }
    
    @Override
    public String toString(){
        return String.format("%-5s| %-6s| %-9s", rCode, name, bYear);
    }
}
