
public class Person {
	public String Name;
	String Email;
	String Pass;
	long NID;
	long PhoneNum;
	public float Rate;
	public byte[]pic;
	public Person() {}
	public Person(String n,String E,String Pa,long N,long P,float R,byte[]p) {
	Name=n;
	Email=E;
	Pass=Pa;
	NID=N;
	PhoneNum=P;
	Rate=R;
	pic=p;
	}
	public void Setname(String N)
	{
		Name=N;
	}
	public void SetEmail(String E)
	{
		Email=E;
	}
	public void SetPass(String Pa)
	{
		Pass=Pa;
	}
	public void SetNID(long N)
	{
		NID=N;
	}
	public void SetPhoneN(long P)
	{
		PhoneNum=P;
	}
	public void SetPic(byte []p)
	{
		pic=p;
	}
	public void SetRate(float R)
	{
		Rate=R;
	}
	public String getname()
	{
		return Name;
	}
	public String getEmail()
	{
		return Email;
	}
	public String getPass()
	{
		return Pass;
	}
	public long getNID()
	{
		return NID;
	}
	public long getPhoneN()
	{
		return PhoneNum;
	}
	public byte[] getPic()
	{
		return pic;
	}
	public float getRate()
	{
		return Rate;
	}
}
