//Vrinda Mittal
//2016279
import java.io.*;

class mess {
	private float[] mattrs;

	public mess(float[] messd) {
		mattrs = new float[4];
		for (int i = 0; i < 4; i++) {
			mattrs[i] = messd[i];
		}
	}

	public float getfa() {
		return mattrs[0];
	}

	public float getfn() {
		return mattrs[1];
	}

	public float gethm() {
		return mattrs[2];
	}

	public float getfdd() {
		return mattrs[3];
	}

	public boolean mcmp(mess m2) {
		if (this.getfa() != m2.getfa()) {
			if (this.getfa() > m2.getfa()) {
				return true;
			} else {
				return false;
			}
		} else if (this.getfn() != m2.getfn()) {
			if (this.getfn() > m2.getfn()) {
				return true;
			} else {
				return false;
			}
		} else if (this.gethm() != m2.gethm()) {
			if (this.gethm() > m2.gethm()) {
				return true;
			} else {
				return false;
			}
		} else if (this.getfdd() != m2.getfdd()) {
			if (this.getfdd() < m2.getfdd()) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
}

class hostel {
	private float[] hattrs;

	public hostel(float[] hosteld) {
		hattrs = new float[4];
		for (int i = 0; i < 4; i++) {
			hattrs[i] = hosteld[i];
		}
	}

	public float getrc() {
		return hattrs[0];
	}

	public float getsf() {
		return hattrs[1];
	}

	public float getc() {
		return hattrs[2];
	}

	public float getrf() {
		return hattrs[3];
	}

	public boolean hcmp(hostel h2) {
		if (this.getrc() != h2.getrc()) {
			if (this.getrc() > h2.getrc()) {
				return true;
			} else {
				return false;
			}
		} else if (this.getsf() != h2.getsf()) {
			if (this.getsf() > h2.getsf()) {
				return true;
			} else {
				return false;
			}
		} else if (this.getc() != h2.getc()) {
			if (this.getc() > h2.getc()) {
				return true;
			} else {
				return false;
			}
		} else if (this.getrf() != h2.getrf()) {
			if (this.getrf() > h2.getrf()) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
}

class lib {
	private float[] lattrs;

	public lib(float[] libd) {
		lattrs = new float[3];
		for (int i = 0; i < 3; i++) {
			lattrs[i] = libd[i];
		}
	}

	public float getba() {
		return lattrs[0];
	}

	public float getdf() {
		return lattrs[1];
	}

	public float getse() {
		return lattrs[2];
	}

	public boolean lcmp(lib l2) {
		float sum1 = (getba() + getdf() + getse()) / 3;
		float sum2 = (l2.getba() + l2.getdf() + l2.getse()) / 3;
		if (sum1 > sum2) {
			return true;
		} else {
			return false;
		}

	}

}

class acad {
	private float[] aattrs;

	public acad(float[] acadd) {
		aattrs = new float[3];
		for (int i = 0; i < 3; i++) {
			aattrs[i] = acadd[i];
		}
	}

	public float getki() {
		return aattrs[0];
	}

	public float getdc() {
		return aattrs[1];
	}

	public float getcse() {
		return aattrs[2];
	}

	public boolean acmp(acad a2) {
		float sum1 = getki() + getdc() + 2 * getcse();
		float sum2 = a2.getki() + a2.getdc() + 2 * a2.getcse();
		if (sum1 > sum2) {
			return true;
		} else {
			return false;
		}

	}

}

class appclg {

	final private float[] weights = { (float) 0.25, (float) 0.20, (float) 0.25, (float) 0.30 }; // mess,hostel,lib,acad
	private int[] otherranks; // rank on basis of :mess,hostel,lib,acad
	private String naMe; // name of the college
	private int fees;
	private int naac;
	private mess mymess;
	private hostel myhostel;
	private lib mylib;
	private acad myacad;
	private float wrank;

	public appclg(String naMe, float[] ok1, float[] ok2, float[] ok3, float[] ok4, int fees, String naac) {
		otherranks = new int[4];
		this.naMe = naMe;
		mymess = new mess(ok1);
		myhostel = new hostel(ok2);
		mylib = new lib(ok3);
		myacad = new acad(ok4);
		this.fees = fees;
		if (naac.equals("A")) {
			this.naac = 1;
		} else if (naac.equals("B")) {
			this.naac = 2;
		} else if (naac.equals("C")) {
			this.naac = 3;
		} else {
			this.naac = 4;
		}
	}

	public mess getmess() {
		return mymess;
	}

	public hostel gethostel() {
		return myhostel;
	}

	public lib getlib() {
		return mylib;
	}

	public acad getacad() {
		return myacad;
	}

	public int getfees() {
		return fees;
	}

	public int getnaac() {
		return naac;
	}

	public String getname() {
		return naMe;
	}

	public void setranks(int i, int rank) {
		otherranks[i] = rank;
	}

	public void calweights() {

		for (int i = 0; i < 4; i++) {
			wrank += weights[i] * otherranks[i];
		}
	}

	public float getwrank() {
		return wrank;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(rd.readLine());

		appclg[] list = new appclg[m]; // list of colleges

		for (int i = 0; i < m; i++) {

			String name = rd.readLine(); // name of clg
			String[] mess1 = rd.readLine().split(" ");
			String[] hostel1 = rd.readLine().split(" ");
			String[] lib1 = rd.readLine().split(" ");
			String[] acad1 = rd.readLine().split(" ");

			float[] messdata = { Float.parseFloat(mess1[1]), Float.parseFloat(mess1[2]), Float.parseFloat(mess1[3]),
					Float.parseFloat(mess1[4]) };
			float[] hosteldata = { Float.parseFloat(hostel1[1]), Float.parseFloat(hostel1[2]),
					Float.parseFloat(hostel1[3]), Float.parseFloat(hostel1[4]) };
			float[] libdata = { Float.parseFloat(lib1[1]), Float.parseFloat(lib1[2]), Float.parseFloat(lib1[3]) };
			float[] acaddata = { Float.parseFloat(acad1[1]), Float.parseFloat(acad1[2]), Float.parseFloat(acad1[3]) };
			String[] fees = rd.readLine().split(" ");
			String[] naac = rd.readLine().split(" ");

			list[i] = new appclg(name, messdata, hosteldata, libdata, acaddata, Integer.parseInt(fees[1]), naac[2]);

		}

		list = sort1(list, m);
		list = sort2(list, m);
		list = sort3(list, m);
		list = sort4(list, m);
		for (int i = 0; i < m; i++) {
			list[i].calweights();
		}

		list = finalsort(list, m);

		for (int k = 0; k < m; k++) {
			System.out.println(list[k].getname());
		}
	}

	public static appclg[] sort1(appclg[] mlist, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (mlist[j].getmess().mcmp(mlist[i].getmess())) {
					int temp = j;
					mlist[j].setranks(0, i);
					mlist[i].setranks(0, temp);
				}
			}
		}
		return mlist;

	}

	public static appclg[] sort2(appclg[] hlist, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (hlist[j].gethostel().hcmp(hlist[i].gethostel())) {
					int temp = j;
					hlist[j].setranks(1, i);
					hlist[i].setranks(1, temp);
				}
			}
		}
		return hlist;
	}

	public static appclg[] sort3(appclg[] llist, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (llist[j].getlib().lcmp(llist[i].getlib())) {
					int temp = j;
					llist[j].setranks(2, i);
					llist[i].setranks(2, temp);
				}
			}
		}
		return llist;
	}

	public static appclg[] sort4(appclg[] alist, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (alist[j].getacad().acmp(alist[i].getacad())) {
					int temp = j;
					alist[j].setranks(3, i);
					alist[i].setranks(3, temp);
				}
			}
		}

		return alist;
	}

	public static appclg[] finalsort(appclg[] fl, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				if (fl[j].getwrank() < fl[i].getwrank()) {
					appclg temp = fl[j];
					fl[j] = fl[i];
					fl[i] = temp;
				} else if (fl[j].getwrank() == fl[i].getwrank()) {
					if (fl[j].getfees() < fl[i].getfees()) {
						appclg temp = fl[j];
						fl[j] = fl[i];
						fl[i] = temp;
					} else if (fl[j].getfees() == fl[i].getfees()) {
						if (fl[j].getnaac() < fl[i].getnaac()) {
							appclg temp = fl[j];
							fl[j] = fl[i];
							fl[i] = temp;
						}
					}
				}
			}
		}
		return fl;
	}
}