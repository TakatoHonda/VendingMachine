import java.io.*;

class VendingMachine {
	private static final String D_P0 = "/sys/class/gpio/CON9_1/";
	private static final String D_P1 = "/sys/class/gpio/CON9_2/";
	private static final String D_P2 = "/sys/class/gpio/CON9_11/";
	private static final String D_STB = "/sys/class/gpio/CON9_12/";
	private static final String D_ACK = "/sys/class/gpio/CON9_13/";
	private static final String D_RET = "/sys/class/gpio/CON9_14/";
	private static final String D_TWICE = "/sys/class/gpio/CON9_15/";
	private static final String D_RST = "/sys/class/gpio/CON9_16/";
	private static final String D_R0 = "/sys/class/gpio/CON9_17/";
	private static final String D_R1 = "/sys/class/gpio/CON9_18/";
	private static final String D_E0 = "/sys/class/gpio/CON9_21/";
	private static final String D_E1 = "/sys/class/gpio/CON9_22/";
	private static final String D_E2 = "/sys/class/gpio/CON9_23/";
	private static final String D_SEL0 = "/sys/class/gpio/CON9_24/";
	private static final String D_SEL1 = "/sys/class/gpio/CON9_25/";
	private static RandomAccessFile P0, P1, P2, STB, ACK, RET, TWICE, RST, R0, R1, E0, E1, E2, SEL0, SEL1;

	VendingMachine() {
		ioInit();
	}

	public void ioC50() {
		try {
			P0.writeBytes("0");
			P0.seek(0);
			P0.writeBytes("1");
			P0.seek(0);
			P1.writeBytes("0");
			P1.seek(0);
			P2.writeBytes("0");
			P2.seek(0);
			System.out.println("send C50");
		} catch (Exception e) {
			System.out.println("error in ioC50()");
		}
	}

	public void ioC100() {
		try {
			P0.writeBytes("0");
			P0.seek(0);
			P1.writeBytes("0");
			P1.seek(0);
			P1.writeBytes("1");
			P1.seek(0);
			P2.writeBytes("0");
			P2.seek(0);
			System.out.println("send C100");
		} catch (Exception e) {
			System.out.println("error in ioC100()");
		}
	}

	public void ioC500() {
		try {
			P0.writeBytes("0");
			P0.seek(0);
			P1.writeBytes("0");
			P1.seek(0);
			P2.writeBytes("0");
			P2.seek(0);
			P2.writeBytes("1");
			P0.seek(0);
			System.out.println("send C500");
		} catch (Exception e) {
			System.out.println("error in ioC500()");
		}
	}

	public void ioREQ150() {
		try {
			P0.writeBytes("1");
			P0.seek(0);
			P0.writeBytes("0");
			P0.seek(0);
			P1.writeBytes("1");
			P1.seek(0);
			P1.writeBytes("0");
			P1.seek(0);
			P2.writeBytes("0");
			P2.seek(0);
			System.out.println("Send request 150ticket");
		} catch (Exception e) {
			System.out.println("error in ioREQ150()");
		}
	}

	public void ioREQ200() {
		try {
			P0.writeBytes("1");
			P0.seek(0);
			P0.writeBytes("0");
			P0.seek(0);
			P1.writeBytes("0");
			P1.seek(0);
			P2.writeBytes("1");
			P2.seek(0);
			P2.writeBytes("0");
			P2.seek(0);
			System.out.println("Send request 200ticket");
		} catch (Exception e) {
			System.out.println("error in ioREQ200()");
		}
	}

	public void ioREQ450() {
		try {
			P0.writeBytes("0");
			P0.seek(0);
			P1.writeBytes("1");
			P1.seek(0);
			P1.writeBytes("0");
			P1.seek(0);
			P2.writeBytes("1");
			P2.seek(0);
			P2.writeBytes("0");
			P2.seek(0);
			System.out.println("Send request 450ticket");
		} catch (Exception e) {
			System.out.println("error in ioREQ450()");
		}
	}

	public void ioTWICE() {
		try {
			TWICE.writeBytes("1");
			TWICE.seek(0);
			TWICE.writeBytes("0");
			TWICE.seek(0);
			System.out.println("Send signal for roundtrip");
		} catch (Exception e) {
			System.out.println("error in ioTWICE()");
		}
	}

	public void ioRET() {
		try {
			RET.writeBytes("1");
			RET.seek(0);
			RET.writeBytes("0");
			RET.seek(0);
			System.out.println("Send ioRET");
		} catch (Exception e) {
			System.out.println("error in ioRET()");
		}
	}

	public void ioRST() {
		try {
			RST.writeBytes("1");
			RST.seek(0);
			RST.writeBytes("0");
			RST.seek(0);
			System.out.println("Send ioRST");
		} catch (Exception e) {
			System.out.println("error in ioRST()");
		}
	}

	public void ioACK() {
		try {
			ACK.writeBytes("1");
			ACK.seek(0);
			ACK.writeBytes("0");
			ACK.seek(0);
			System.out.println("Send ACK");
		} catch (Exception e) {
			System.out.println("error in ioACK()");
		}
	}

	public void ioSTB() {
		try {
			STB.writeBytes("1");
			STB.seek(0);
			STB.writeBytes("0");
			STB.seek(0);
			System.out.println("Send STB");
		} catch (Exception e) {
			System.out.println("error in ioSTB()");
		}
	}

	public boolean ioR50() {
		boolean r50 = false;
		try {
			if (String.valueOf((char) R0.read()).equals("1") && String.valueOf((char) R1.read()).equals("0")) {
				r50 = true;
				System.out.println("Get R50");
			}
		} catch (Exception e) {
			System.out.println("error in ioR50()");
		}
		return r50;
	}

	public boolean ioR100() {
		boolean r100 = false;
		try {
			if (String.valueOf((char) R0.read()).equals("0") && String.valueOf((char) R1.read()).equals("1")) {
				r100 = true;
				System.out.println("Get R100");
			}
		} catch (Exception e) {
			System.out.println("error in ioR50()");
		}
		return r100;
	}

	public boolean ioR500() {
		boolean r500 = false;
		try {
			if (String.valueOf((char) R0.read()).equals("1") && String.valueOf((char) R1.read()).equals("1")) {
				r500 = true;
				System.out.println("Get R500");
			}
		} catch (Exception e) {
			System.out.println("error in ioR50()");
		}
		return r500;
	}

	public boolean ioNotSel() {
		boolean NotSel = false;
		try {
			if (String.valueOf((char) E0.read()).equals("1") && String.valueOf((char) E1.read()).equals("0")
					&& String.valueOf((char) E2.read()).equals("0")) {
				NotSel = true;
				System.out.println("Get NotSel");
			}
		} catch (Exception e) {
			System.out.println("error in ioNotSel()");
		}
		return NotSel;
	}

	public boolean ioNO50() {
		boolean NO50 = false;
		try {
			if (String.valueOf((char) E0.read()).equals("0") && String.valueOf((char) E1.read()).equals("1")
					&& String.valueOf((char) E2.read()).equals("0")) {
				NO50 = true;
				System.out.println("No coin 50");
			}
		} catch (Exception e) {
			System.out.println("error in ioNO50()");
		}
		return NO50;
	}

	public boolean ioNO100() {
		boolean NO100 = false;
		try {
			if (String.valueOf((char) E0.read()).equals("1") && String.valueOf((char) E1.read()).equals("1")
					&& String.valueOf((char) E2.read()).equals("0")) {
				NO100 = true;
				System.out.println("No coin 100");
			}
		} catch (Exception e) {
			System.out.println("error in ioNO100()");
		}
		return NO100;
	}

	public boolean ioSOVR() {
		boolean SOVR = false;
		try {
			if (String.valueOf((char) E0.read()).equals("0") && String.valueOf((char) E1.read()).equals("0")
					&& String.valueOf((char) E2.read()).equals("1")) {
				SOVR = true;
				System.out.println("NumberÅ@of coins exceeded!");
			}
		} catch (Exception e) {
			System.out.println("error in ioSOVR()");
		}
		return SOVR;
	}

	public boolean ioIOVR() {
		boolean IOVR = false;
		try {
			if (String.valueOf((char) E0.read()).equals("1") && String.valueOf((char) E1.read()).equals("0")
					&& String.valueOf((char) E2.read()).equals("1")) {
				IOVR = true;
				System.out.println("Over 1000");
			}
		} catch (Exception e) {
			System.out.println("error in ioIOVR()");
		}
		return IOVR;
	}

	public boolean ioSEL150() {
		boolean SEL150 = false;
		try {
			if (String.valueOf((char) SEL0.read()).equals("1") && String.valueOf((char) SEL1.read()).equals("0")) {
				SEL150 = true;
				System.out.println("Sell ticket150");
			}
		} catch (Exception e) {
			System.out.println("error in ioSEL150()");
		}
		return SEL150;
	}

	public boolean ioSEL200() {
		boolean SEL200 = false;
		try {
			if (String.valueOf((char) SEL0.read()).equals("0") && String.valueOf((char) SEL1.read()).equals("1")) {
				SEL200 = true;
				System.out.println("Sell ticket200");
			}
		} catch (Exception e) {
			System.out.println("error in ioSEL200()");
		}
		return SEL200;
	}

	public boolean ioSEL450() {
		boolean SEL450 = false;
		try {
			if (String.valueOf((char) SEL0.read()).equals("1") && String.valueOf((char) SEL1.read()).equals("1")) {
				SEL450 = true;
				System.out.println("Sell ticket450");
			}
		} catch (Exception e) {
			System.out.println("error in ioSEL450()");
		}
		return SEL450;
	}

	public void ioInit() {
		ioDirectionInit();
		ioOpenInit();

		try {
			P0.writeBytes("0");
			P0.seek(0);
			P1.writeBytes("0");
			P1.seek(0);
			P2.writeBytes("0");
			P2.seek(0);
			RET.writeBytes("0");
			RET.seek(0);
			STB.writeBytes("0");
			STB.seek(0);
			TWICE.writeBytes("0");
			TWICE.seek(0);
			ACK.writeBytes("0");
			ACK.seek(0);
			RST.writeBytes("1");
			RST.seek(0);
			RST.writeBytes("0");
			RST.seek(0);
			System.out.println("ioInit() OK.");
		} catch (Exception e) {
			System.out.println("error in ionInit()");
		}
	}

	public void ioDirectionInit() {
		String[] io = { D_SEL0, D_SEL1, D_R0, D_R1, D_E0, D_E1, D_E2, D_TWICE, D_STB, D_P0, D_P1, D_P2, D_RET, D_ACK };
		String[] set = { "in", "in", "in", "in", "in", "in", "in", "out", "out", "out", "out", "out", "out", "out", "out" };

		for (int i = 0; i < io.length; i++) {
			try {
				FileWriter f = new FileWriter(new File(io[i] + "direction"));
				f.write(set[i]);
				f.close();
				System.out.println("ioDirectionInit OK.");
			} catch (Exception e) {
				System.out.println("error in ioDirectionInit()" + io[i]);
			}
		}
	}

	public void ioOpenInit() {
		try {
			SEL0 = new RandomAccessFile(D_SEL0 + "value", "r");
			SEL1 = new RandomAccessFile(D_SEL1 + "value", "r");
			R0 = new RandomAccessFile(D_R0 + "value", "r");
			R1 = new RandomAccessFile(D_R1 + "value", "r");
			E0 = new RandomAccessFile(D_E0 + "value", "r");
			E1 = new RandomAccessFile(D_E1 + "value", "r");
			E2 = new RandomAccessFile(D_E2 + "value", "r");

			P0 = new RandomAccessFile(D_P0 + "value", "rw");
			P1 = new RandomAccessFile(D_P1 + "value", "rw");
			P2 = new RandomAccessFile(D_P2 + "value", "rw");
			RET = new RandomAccessFile(D_RET + "value", "rw");
			ACK = new RandomAccessFile(D_ACK + "value", "rw");
			RST = new RandomAccessFile(D_RST + "value", "rw");
			TWICE = new RandomAccessFile(D_TWICE + "value", "rw");
			STB = new RandomAccessFile(D_STB + "value", "rw");
			  System.out.println("ioOpenInit() OK.");
		} catch (Exception e) {
			System.out.println("error in ioOpenInit()");
		}
	}

	public void ioClose() {
		try {
			P0.close();
			P1.close();
			P2.close();
			STB.close();
			RET.close();
			ACK.close();
			TWICE.close();
			R0.close();
			R1.close();
			E0.close();
			E1.close();
			E2.close();
			SEL0.close();
			SEL1.close();
			RST.close();
			System.out.println("ioClose() OK.");
		} catch (Exception e) {
			System.out.println("error in ioClose()");
		}
	}
}
