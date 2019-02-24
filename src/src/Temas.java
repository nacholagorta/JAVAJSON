package src;

public class Temas {

    private String str_mid;
    private String str_mname;
    private String str_minstrumental;
    private String str_midinstrumental;

    public Temas(String str_mid, String str_mname, String str_minstrumental, String str_midinstrumental) {
        this.str_mid = str_mid;
        this.str_mname = str_mname;
        this.str_minstrumental = str_minstrumental;
        this.str_midinstrumental = str_midinstrumental;
    }

    public String getStr_mid() {
        return str_mid;
    }

    public void setStr_mid(String str_mid) {
        this.str_mid = str_mid;
    }

    public String getStr_mname() {
        return str_mname;
    }

    public void setStr_mname(String str_mname) {
        this.str_mname = str_mname;
    }

    public String getStr_minstrumental() {
        return str_minstrumental;
    }

    public void setStr_minstrumental(String str_minstrumental) {
        this.str_minstrumental = str_minstrumental;
    }

    public String getStr_midinstrumental() {
        return str_midinstrumental;
    }

    public void setStr_midinstrumental(String str_midinstrumental) {
        this.str_midinstrumental = str_midinstrumental;
    }
}
