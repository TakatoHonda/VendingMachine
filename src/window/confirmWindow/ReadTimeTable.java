package window.confirmWindow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.StringTokenizer;

public class ReadTimeTable {
	private int[] Kago_down;
	private int[] Kago_up;
	private int[] Houhi;
	//private int[][] lines = {Kago_down, Kago_up, Houhi};
	public ReadTimeTable() {
		try {
			File timeTable = new File("./res/TimeTable.csv");
			BufferedReader br = new BufferedReader(new FileReader(timeTable));
			String line = "";
			int lineNum=0;
			while((line = br.readLine()) != null) {
				lineNum++;
				StringTokenizer st = new StringTokenizer(line, ",");
				if (lineNum == 1) {
					Kago_down = new int[st.countTokens()];
				} else if (lineNum == 2) {
					Kago_up = new int[st.countTokens()];
				} else {
					Houhi = new int[st.countTokens()];
				}

				for (int i = 0; st.hasMoreTokens(); i++) {
					if (lineNum == 1) {
						Kago_down[i] = Integer.parseInt(st.nextToken());
					} else if (lineNum == 2) {
						Kago_up[i] = Integer.parseInt(st.nextToken());
					} else if (lineNum == 3) {
						Houhi[i] = Integer.parseInt(st.nextToken());
					}
				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			// File not found
			e.printStackTrace();
			System.out.println("Error! File not found!");
		} catch (IOException e) {
			// BufferedReader error
			e.printStackTrace();
			System.out.println("Error in BufferReader!");
		} catch (Exception e) {
			System.out.println("Error in ReadTimeTable()");
		}
	}

	public String getLeaveTime(String route) {
		int[] table = null;

		if (route.equals("Kago_down")) {
			table = Kago_down;
		} else if (route.equals("Kago_up")) {
			table = Kago_up;
		} else if (route.equals("Houhi")) {
			table = Houhi;
		}
		String leaveTime = Integer.toString(table[0]).substring(0, 1) + ":" + Integer.toString(table[0]).substring(1, 3);
		Calendar now = Calendar.getInstance();
		int h = now.get(Calendar.HOUR_OF_DAY);
		int m = now.get(Calendar.MINUTE);
		if (h == 0) {
			h = 24;
		}
		int time = h * 100 + m;
		for (int i = 0; i < table.length; i++) {
			if (Integer.valueOf(table[i]) >= time) {
				if (table[i] < 1000) {
					leaveTime = Integer.toString(table[i]).substring(0, 1) + ":" + Integer.toString(table[i]).substring(1, 3);
				} else {
					leaveTime = Integer.toString(table[i]).substring(0, 2) + ":" + Integer.toString(table[i]).substring(2, 4);
				}
				return leaveTime;
			}
		}
		return leaveTime;

	}
}
