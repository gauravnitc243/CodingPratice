package com.oracle;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinuxBoxOptimization {
    private static Map<String, String> env;
    private static final int NO_OF_VIEWS_RECO = 5;
    private static final int FMWTOOLS_TOTAL_SIZE_RECO = 75;
    private static final int SYSTEM_UPTIME_RECO = 30;
    private static final int HARD_DISK_USAGE_RECO = 80;
    private static final String GENERAL_RECO_TEXT = "Things look good here";
    private static int jdevCount;
    private static int wlsCount;
    private static int jdevMemory;
    private static int wlsMemory;
    private static int jdevRAM;
    private static int wlsRAM;
    private static String JDEV;
    private static String WLS;

    public static void main(String[] arrstring) {
        Object object;
        int n =0;
        String[] arrstring2;
        LinuxBoxOptimization.clearScreen();
        env = System.getenv();
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
        System.out.println("\t\t\t\t                             Memory Usage Info                             ");
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
        System.out.println("");
        int n2 = LinuxBoxOptimization.getNoOfViews();
        System.out.println("\t\t\t\t\t 1. No of views : " + n2);
        if (n2 > 5) {
            System.out.println("\t\t\t\t\t\t\t RECOMMENDATION : View clean up required since there are more than 5 views");
        } else {
            System.out.println("\t\t\t\t\t\t\t RECOMMENDATION : Things look good here");
        }
        System.out.println("\t\t\t\t\t 2. Summary of FMWTOOLS ");
        Map<String, Integer> map = LinuxBoxOptimization.getFMWTOOLSInfo();
        Integer n3 = map.get("FMWTOOLSTotalSize") / 1048576;
        System.out.println("\t\t\t\t\t\t\t Total Size of FMWTOOLS : " + n3 + " GB");
        if (n3 > 75) {
            System.out.println("\t\t\t\t\t\t\t RECOMMENDATION : FMWTOOLS folder clean up required since it occupies more than 75GB of space");
        } else {
            System.out.println("\t\t\t\t\t\t\t RECOMMENDATION : Things look good here");
        }
        int n4 = LinuxBoxOptimization.getSystemUptime();
        if (n4 > 0) {
            System.out.println("\t\t\t\t\t 3. You have not restarted your machine for past " + n4 + " days.");
        } else {
            System.out.println("\t\t\t\t\t 3. You have restarted your machine today.");
        }
        if (n4 > 30) {
            System.out.println("\t\t\t\t\t\t\t RECOMMENDATION: It is a good practice to restart your machine once a month");
        } else {
            System.out.println("\t\t\t\t\t\t\t RECOMMENDATION : Things look good here");
        }
        Map<String, Integer> map2 = LinuxBoxOptimization.getStorageInfo();
        int n5 = map2.get("UsedSpace%");
        System.out.println("\t\t\t\t\t 4. Hard Disk Summary ");
        System.out.println("\t\t\t\t\t\t   Total Space : " + map2.get("TotalSpace") + " GB.");
        System.out.println("\t\t\t\t\t\t  Usable Space : " + map2.get("UsableSpace") + " GB.");
        System.out.println("\t\t\t\t\t\t    Used Space : " + map2.get("UsedSpace") + " GB. (" + map2.get("UsedSpace%") + "%)");
        System.out.println("\t\t\t\t\t\t    Free Space : " + map2.get("FreeSpace") + " GB. (" + map2.get("FreeSpace%") + "%)");
        if (n5 > 80) {
            System.out.println("\t\t\t\t\t\t\t   RECOMMENDATION: Hard disk clean up required since you have used more than 80% of space");
        } else {
            System.out.println("\t\t\t\t\t\t\t RECOMMENDATION : Things look good here");
        }
        Map<String, Integer> map3 = LinuxBoxOptimization.getRAMInfoWithoutCaching();
        System.out.println("\t\t\t\t\t 5. RAM Usage Summary ");
        System.out.println("\t\t\t\t\t\t  Total Memory : " + map3.get("TotalRAM") + " MB.");
        System.out.println("\t\t\t\t\t\t   Used Memory : " + map3.get("UsedRAM") + " MB. (" + map3.get("UsedRAM%") + "%)");
        System.out.println("\t\t\t\t\t\t   Free Memory : " + map3.get("FreeRAM") + " MB. (" + map3.get("FreeRAM%") + "%)");
        System.out.println("\t\t\t\t\t\t Check this link to understand more about memory usage : http://blog.us.oracle.com/fintech/?97244103");
        List<Map<String, String>> list = LinuxBoxOptimization.getTopCommandsList();
        System.out.println("\t\t\t\t\t 6. JDeveloper Summary ");
        if (jdevCount > 0) {
            System.out.println("\t\t\t\t\t\t             No of JDeveloper Instances : " + jdevCount);
            System.out.println("\t\t\t\t\t\t          Memory used by all Jdeveloper : " + jdevMemory + " MB.");
            System.out.println("\t\t\t\t\t\t      RAM Memory used by all Jdeveloper : " + jdevRAM + " MB.");
        } else {
            System.out.println("\t\t\t\t\t\t No JDeveloper instance is running.");
        }
        System.out.println("\t\t\t\t\t 7. Weblogic Server Summary ");
        if (wlsCount > 0) {
            System.out.println("\t\t\t\t\t\t        No of Weblogic Server Instances : " + wlsCount);
            System.out.println("\t\t\t\t\t\t     Memory used by all Weblogic Server : " + wlsMemory + " MB.");
            System.out.println("\t\t\t\t\t\t RAM Memory used by all Weblogic Server : " + wlsRAM + " MB.");
        } else {
            System.out.println("\t\t\t\t\t\t No Weblogic Server instance is running.");
        }
        boolean bl = LinuxBoxOptimization.isDBRunning();
        int n6 = 0;
        if (bl) {
            System.out.println("\t\t\t\t\t 8. DataBase is running on machine ");
            n6 = 1;
        }
        if ((n = n6 + jdevCount + wlsCount) > 4) {
            if (bl) {
                System.out.println("\t\t\t\t\t RECOMMENDATION : Since database is running on this machine, total running instances of JDeveloper and Weblogic Server should be limited to 3.");
            } else {
                System.out.println("\t\t\t\t\t RECOMMENDATION : Total running instances of JDeveloper and Weblogic Server should be limited to 4.");
            }
        }
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
        System.out.println("\t\t\t\t                          Top 5 Memory Consumers                           ");
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
     /*   for (int i = 0; i < 5; ++i) {
            object = list.get(i);
            int n7 = i + 1;
            arrstring2 = object.get("ProcessName");
            System.out.println("\t\t\t\t\t " + n7 + ". " + (String)arrstring2);
            if (JDEV.equals(arrstring2) || WLS.equals(arrstring2)) {
                System.out.println("\t\t\t\t\t\t Path :  " + (String)object.get("Path"));
            }
            System.out.println("\t\t\t\t\t\t Total Memory Used :  " + (String)object.get("Memory"));
            System.out.println("\t\t\t\t\t\t Total RAM Memory Used :" + (String)object.get("RAM"));
            System.out.println("\t\t\t\t\t\t % RAM Memory Used : " + (String)object.get("RAM%"));
        }*/
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
        System.out.println("\t\t\t\t                          Kill Killer Processes                            ");
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
        Console console = System.console();
        object = console.readLine("\t\t\t\t\t Do you want to kill any of the above processes [y/n - Defaualts n]: ", new Object[0]);
        if ("y".equalsIgnoreCase((String)object)) {
            String string = console.readLine("\t\t\t\t\t Enter the S.Nos in 'Top 5 Memory consumers' that you want to kill [Eg: 1,2,3] : ", new Object[0]);
            string = string.trim();
            string = string.replaceAll("\\s+", "");
            arrstring2 = string.split(",");
            System.out.println("");
            StringBuffer stringBuffer = new StringBuffer("");
            for (int j = 0; j < arrstring2.length; ++j) {
                int n8 = Integer.parseInt(arrstring2[j]);
                Map<String, String> map4 = list.get(n8 - 1);
                String string2 = map4.get("ProcessName");
                String string3 = map4.get("ProcessId");
                stringBuffer.append(string3);
                stringBuffer.append(" ");
                String string4 = map4.get("Path");
                if (JDEV.equals(string2) || WLS.equals(string2)) {
                    System.out.println("\t\t\t\t\t " + string2 + " at path : " + string4);
                    continue;
                }
                System.out.println("\t\t\t\t\t " + string2);
            }
            String string5 = console.readLine("\t\t\t\t\t Confirm that you want to kill the above processes [y/n - Defaualts y]: ", new Object[0]);
            if (!"n".equalsIgnoreCase(string5)) {
                LinuxBoxOptimization.killProcesses(stringBuffer.toString());
                System.out.println("\t\t\t\t\t\t\t Processes Killed");
            }
        }
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
        System.out.println("\t\t\t\t                          Optimization Script Terminated                   ");
        System.out.println("\t\t\t\t ------------------------------------------------------------------------- ");
    }

    public Map<String, String> getEnvironment() {
        return env;
    }

    private static String getUserName() {
        return env.get("USER");
    }

    private static String getHostName() {
        return env.get("HOSTNAME");
    }

    private static boolean isIDCMachine() {
        String string = LinuxBoxOptimization.getHostName();
        if (string.contains("indl")) {
            return true;
        }
        return false;
    }

    private static int getNoOfFMWTOOLS() {
        File file = new File("/scratch/software/mw_local/");
        return LinuxBoxOptimization.getNoOfSubDirectories(file);
    }

    private static int getNoOfSubDirectories(File file) {
        File[] arrfile = file.listFiles();
        int n = 0;
        for (int i = 0; i < arrfile.length; ++i) {
            if (!arrfile[i].isDirectory()) continue;
            ++n;
        }
        return n;
    }

    public static int getNoOfViews() {
        int n = 0;
        try {
       
            Process process = Runtime.getRuntime().exec("ade lsviews");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (bufferedReader.readLine() != null) {
                ++n;
            }
            bufferedReader.close();
        }
        catch (IOException var1_2) {
            var1_2.printStackTrace();
        }
        return n;
    }

    private static int getSystemUptime() {
        String string = null;
        int n = 0;
        try {
            String string2 = null;
            Process process = Runtime.getRuntime().exec("uptime");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            string2 = bufferedReader.readLine().trim();
            string2 = string2.replaceAll("\\s+", " ");
            String[] arrstring = string2.split(" ");
            string = arrstring[2];
            n = string2.contains("days") ? Integer.parseInt(string) : 0;
            bufferedReader.close();
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
        }
        return n;
    }

    private static Map<String, Integer> getRAMInfo() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        try {
            String string = null;
            String string2 = null;
            Process process = Runtime.getRuntime().exec("vmstat -s -S M");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            string = bufferedReader.readLine().trim();
            string2 = bufferedReader.readLine().trim();
            String[] arrstring = string.split(" ");
            String[] arrstring2 = string2.split(" ");
            Integer n = Integer.parseInt(arrstring[0]);
            Integer n2 = Integer.parseInt(arrstring2[0]);
            Integer n3 = n - n2;
            Integer n4 = n2 * 100 / n;
            Integer n5 = 100 - n4;
            hashMap.put("TotalRAM", n);
            hashMap.put("UsedRAM", n2);
            hashMap.put("FreeRAM", n3);
            hashMap.put("UsedRAM%", n4);
            hashMap.put("FreeRAM%", n5);
            bufferedReader.close();
        }
        catch (IOException var1_2) {
            var1_2.printStackTrace();
        }
        return hashMap;
    }

    private static Map<String, Integer> getRAMInfoWithoutCaching() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        try {
            String string = null;
            String string2 = null;
            Process process = Runtime.getRuntime().exec("free -m");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedReader.readLine();
            string = bufferedReader.readLine().trim();
            string2 = bufferedReader.readLine().trim();
            string2 = string2.replaceAll("\\s+", " ");
            String[] arrstring = string2.split(" ");
            Integer n = Integer.parseInt(arrstring[2]);
            Integer n2 = Integer.parseInt(arrstring[3]);
            Integer n3 = n + n2;
            Integer n4 = n * 100 / n3;
            Integer n5 = 100 - n4;
            hashMap.put("TotalRAM", n3);
            hashMap.put("UsedRAM", n);
            hashMap.put("FreeRAM", n2);
            hashMap.put("UsedRAM%", n4);
            hashMap.put("FreeRAM%", n5);
            bufferedReader.close();
        }
        catch (IOException var1_2) {
            var1_2.printStackTrace();
        }
        return hashMap;
    }

    private static Map<String, Integer> getStorageInfo() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        String string = null;
        try {
            String[] arrstring;
            Process process = null;
            BufferedReader bufferedReader = null;
            if (LinuxBoxOptimization.isIDCMachine()) {
                arrstring = new String[]{"/bin/sh", "-c", "df -h | grep /scratch"};
                process = Runtime.getRuntime().exec(arrstring);
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                string = bufferedReader.readLine();
            } else {
                process = Runtime.getRuntime().exec("df -h");
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                string = bufferedReader.readLine();
                string = bufferedReader.readLine();
            }
            string.trim();
            string = string.replaceAll("\\s+", " ");
            arrstring = string.split(" ");
            Integer n = (int)Math.round(Double.parseDouble(arrstring[1].substring(0, arrstring[1].length() - 1)));
            Integer n2 = (int)Math.round(Double.parseDouble(arrstring[2].substring(0, arrstring[2].length() - 1)));
            Integer n3 = (int)Math.round(Double.parseDouble(arrstring[3].substring(0, arrstring[3].length() - 1)));
            Integer n4 = n2 + n3;
            Integer n5 = n2 * 100 / n4;
            Integer n6 = 100 - n5;
            hashMap.put("TotalSpace", n);
            hashMap.put("UsableSpace", n4);
            hashMap.put("UsedSpace", n2);
            hashMap.put("FreeSpace", n3);
            hashMap.put("UsedSpace%", n5);
            hashMap.put("FreeSpace%", n6);
            bufferedReader.close();
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
        }
        return hashMap;
    }

    private static boolean isFirefoxRunning() {
        int n = 0;
        n = LinuxBoxOptimization.noOfOccurrencesOfCommand("firefox");
        if (n > 0) {
            return true;
        }
        return false;
    }

    private static int noOfOccurrencesOfCommand(String string) {
        int n = 0;
        try {
            Object var2_2 = null;
            Process process = Runtime.getRuntime().exec("ps -C " + string);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (bufferedReader.readLine() != null) {
                ++n;
            }
            --n;
            bufferedReader.close();
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
        }
        return n;
    }

    private static int noOfOccurrencesOfCommandFromBin(String string) {
        int n = 0;
        try {
            Object var2_2 = null;
            String[] arrstring = new String[]{"/bin/sh", "-c", "ps -ef | grep " + string + " | grep -v grep"};
            Process process = Runtime.getRuntime().exec(arrstring);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (bufferedReader.readLine() != null) {
                ++n;
            }
            bufferedReader.close();
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
        }
        return n;
    }

    private static List<Map<String, String>> getTopCommandsList() {
        ArrayList<Map<String, String>> arrayList = new ArrayList<Map<String, String>>();
        try {
            ArrayList<String> arrayList2 = new ArrayList<String>();
            String string = LinuxBoxOptimization.getUserName();
            String string2 = null;
            String[] arrstring = new String[]{"/bin/sh", "-c", "top -cSb -u " + string + " n 1 | tail -n+8 | sort -rn -k10"};
            Process process = Runtime.getRuntime().exec(arrstring);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((string2 = bufferedReader.readLine()) != null) {
                arrayList2.add(string2);
            }
            for (int i = 0; i < 5; ++i) {
                Object object;
                Object object2;
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                String string3 = ((String)arrayList2.get(i)).trim();
                string3 = string3.replaceAll("\\s+", " ");
                String[] arrstring2 = string3.split(" ");
                String string4 = arrstring2[0];
                String string5 = LinuxBoxOptimization.getParentProcessId(string4);
                String string6 = LinuxBoxOptimization.getProcessName1(string4);
                String string7 = LinuxBoxOptimization.getProcessName1(string5);
                String string8 = arrstring2[4];
                char c = string8.charAt(string8.length() - 1);
                int n = 0;
              /*  if (c == 'm') {
                    object2 = Double.parseDouble(string8.substring(0, string8.length() - 1));
                    n = (int)Math.round(object2.doubleValue());
                } else if (c == 'g') {
                    object2 = Double.parseDouble(string8.substring(0, string8.length() - 1));
                    n = (int)Math.round(object2.doubleValue() * 1024.0);
                }
                object2 = arrstring2[5];
                char c2 = object2.charAt(object2.length() - 1);
                int n2 = 0;
                if (c2 == 'm') {
                    n2 = Integer.parseInt(object2.substring(0, object2.length() - 1));
                } else if (c2 == 'g') {
                    object = Double.parseDouble(object2.substring(0, object2.length() - 1));
                    n2 = (int)Math.round(object.doubleValue() * 1024.0);
                }*/
             /*   if ("jdev".equalsIgnoreCase(string7)) {
                    object = LinuxBoxOptimization.getParentProcessId(string5);
                    String string9 = LinuxBoxOptimization.getProcessName((String)object);
                    hashMap.put("Path", string9);
                    string6 = JDEV;
                    ++jdevCount;
                    jdevMemory += n;
                    jdevRAM += n2;
                } else if (string7.contains("startWebLogic")) {
                    object = LinuxBoxOptimization.getProcessName(string5);
                    hashMap.put("Path", object);
                    string6 = WLS;
                    ++wlsCount;
                    wlsMemory += n;
                    wlsRAM += n2;
                }
                hashMap.put("ProcessId", string4);
                hashMap.put("ProcessName", string6);
                hashMap.put("Memory", arrstring2[4]);
                hashMap.put("RAM", arrstring2[5]);
                hashMap.put("RAM%", arrstring2[9]);
                arrayList.add(hashMap);*/
            }
            bufferedReader.close();
        }
        catch (IOException var1_2) {
            System.out.println(var1_2.getMessage());
            var1_2.printStackTrace();
        }
        return arrayList;
    }

    private static String getParentProcessId(String string) {
        String string2 = null;
        try {
            Process process = Runtime.getRuntime().exec("ps -p " + string + " -o ppid=");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            string2 = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
        }
        return string2.trim();
    }

 /*   private static String getProcessName(String string) {
        String string2 = null;
        try {
            Process process = Runtime.getRuntime().exec("ps -p " + string + " -o cmd=");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            string2 = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
        }
        return string2;
    }*/

    private static String getProcessName1(String string) {
        String string2 = null;
        String string3 = null;
        try {
            String[] arrstring = new String[]{"/bin/sh", "-c", "cat /proc/" + string + "/status | grep Name"};
            Process process = Runtime.getRuntime().exec(arrstring);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            string2 = bufferedReader.readLine();
            string2 = string2.replaceAll("\\s+", " ");
            String[] arrstring2 = string2.split(" ");
            string3 = arrstring2[1];
            bufferedReader.close();
        }
        catch (IOException var3_4) {
            var3_4.printStackTrace();
        }
        return string3;
    }

    private static void clearScreen() {
        String string = "\u001b[";
        System.out.print(string + "2J");
    }

    private static void killProcesses(String string) {
        try {
            Process process = Runtime.getRuntime().exec("kill -9 " + string);
        }
        catch (IOException var1_2) {
            var1_2.printStackTrace();
        }
    }

    private static Map<String, Integer> getFMWTOOLSInfo() {
        String[] arrstring;
        Object object;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        String string = null;
        Object var2_2 = null;
        Integer n = 0;
        Integer n2 = 0;
        Integer n3 = 0;
        try {
            arrstring = new String[]{"/bin/sh", "-c", "cd /scratch/software/mw_local/ ; du -s `ls | grep FMWTOOLS` ;"};
            object = Runtime.getRuntime().exec(arrstring);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((Process) object).getInputStream()));
            while ((string = bufferedReader.readLine()) != null) {
                string = string.replaceAll("\\s+", " ");
                string.trim();
                String[] arrstring2 = string.split(" ");
                Object object2 = n3;
                Integer n4 = n3 = Integer.valueOf(n3 + 1);
                n = Integer.parseInt(arrstring2[0]);
                object2 = null;
                if (n > 1048576) {
                    n4 = n / 1048576;
                    object2 = "" + n4 + " GB.";
                } else {
                    n4 = n / 1024;
                    object2 = "" + n4 + " MB.";
                }
                System.out.println("\t\t\t\t\t\t " + n3 + ". " + arrstring2[1] + " " + (String)object2);
                n2 = n2 + n;
            }
            bufferedReader.close();
        }
        catch (IOException var6_7) {
            var6_7.printStackTrace();
        }
        arrstring = null;
        object = n2 / 1048576;
        hashMap.put("FMWTOOLSCount", n3);
        hashMap.put("FMWTOOLSTotalSize", n2);
        return hashMap;
    }

    private static boolean isDBRunning() {
        try {
            String[] arrstring = new String[]{"/bin/sh", "-c", "ps -ef | grep pmon | grep -v grep"};
            Process process = Runtime.getRuntime().exec(arrstring);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (bufferedReader.readLine() != null) {
                return true;
            }
            return false;
        }
        catch (IOException var0_1) {
            var0_1.printStackTrace();
            return false;
        }
    }

    static {
        jdevCount = 0;
        wlsCount = 0;
        jdevMemory = 0;
        wlsMemory = 0;
        jdevRAM = 0;
        wlsRAM = 0;
        JDEV = "JDeveloper";
        WLS = "Weblogic Server";
    }
}