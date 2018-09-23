package anaghesh.suraksha;

public class Datas {

    private String dt;
    private String phno;
    private boolean isSelected;


    public String getDt() {
        return dt;
    }

    public String getPhno()
    {
        return phno;
    }


    public boolean getSelected()
    {
        return isSelected;
    }

    public void setSelected(boolean Selected)
    {
        isSelected = Selected;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public void setPhno(String phno)
        {this.phno = phno; }
}
