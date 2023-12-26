import java.util.Calendar;

public abstract class Mitarbeiter {
	  private int persnr;
	  private String name;
	  private Calendar eintritt;

	  public Mitarbeiter()
	  {
	  }

	  public abstract double monatsBrutto();
	  
	  public abstract int hatDienstjubilaeum();


	public void setPersnr(int persnr) {
		this.persnr = persnr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEintritt(Calendar eintritt) {
		this.eintritt = eintritt;
	}

	public int getPersnr() {
		return persnr;
	}

	public String getName() {
		return name;
	}

	public Calendar getEintritt() {
		return eintritt;
	}
	
	
}
