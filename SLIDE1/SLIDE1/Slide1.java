
package SLIDE1;


public class Slide1 {
    private String Hangxe;
    private int Namsx;
    public String getHangxe() {
      return Hangxe;
    }
    public void setHangxe(String Hangxe) {
      this.Hangxe = Hangxe;
    }
    public int getNamsx() {
      return Namsx;
    }
    public void setNamsx(int Namsx) {
      this.Namsx = Namsx;
    }
    public Slide1() {}
    public Slide1(String Hangxe, int Namsx) {
      this.Hangxe = Hangxe;
      this.Namsx = Namsx;
    }
    public void xuat() {
      System.out.println("Hang xe: " + Hangxe);
      System.out.println("Nam san xuat: " + Namsx);
    }
  }
