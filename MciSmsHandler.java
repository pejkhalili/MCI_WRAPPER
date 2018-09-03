package com.chapdast.ventures.Handlers;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class MciSmsHandler {
    private static String PUSH = "charge/push";
    private static String CHECK = "charge/check";
    private static String MEMBER_SUB = "member/sub";
    private static String MEMBER_CHECK = "member/check";
    private static String MEMBER_UNSUB = "member/unsub";
    private static String MEMBER_STATUS = "member/status";
    private static String MEMBER_NUMBER = "member/getMobileNumber";

    private final String TAG = "sms-v2";
    private final Long amount = 1L;
    private final String SMS_SERVER_ADDRESS_V2 = "http://vas.rpg.ir/api/";
    private final String WebServiceCreds = "dc8c8671-ab4f-11e8-8129-00505696ce21";
    private final String WebServiceSid = "39d34a36-ab50-11e8-8129-00505696ce21";
    private HttpURLConnection con;
    private URL sendReq;
    private StringBuffer content;
    private int RESULT;



    public String ChargePush(String phone) {
        setAction(PUSH);
        Log.d(TAG, "IN SMSV2");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Map<String, String> params = new HashMap<>();
            params.put("sid", WebServiceSid);
            params.put("mobile", phone);
            params.put("amount", amount.toString());

            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(ParameterStringBuilder.getParamsString(params));

            dos.flush();
            dos.close();

            int status = con.getResponseCode();
            Log.d(TAG, "" + status + ", MSG: " + con.getResponseMessage());
            if (status == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String inputLine;
                content = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                return resultStatus(PUSH, true);
            }

            con.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "-1";
    }

    public String memberSub(String phone) {
        setAction(MEMBER_SUB);
        Log.d(TAG, "IN SMSV2");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Map<String, String> params = new HashMap<>();
            params.put("sid", WebServiceSid);
            params.put("mobile", phone);

            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(ParameterStringBuilder.getParamsString(params));

            dos.flush();
            dos.close();

            int status = con.getResponseCode();
            Log.d(TAG, "" + status + ", MSG: " + con.getResponseMessage());
            if (status == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String inputLine;
                content = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                return resultStatus(MEMBER_SUB, true);
            }

            con.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "-1";
    }




    public boolean ChargeCheck(String TRANSACTION_ID, String PIN) {
        setAction(CHECK);
        Log.d(TAG, "IN SMSV2");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Map<String, String> params = new HashMap<>();
            params.put("tid", TRANSACTION_ID);
            params.put("pin", PIN);


            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(ParameterStringBuilder.getParamsString(params));

            dos.flush();
            dos.close();

            int status = con.getResponseCode();
            Log.d(TAG, "" + status + ", MSG: " + con.getResponseMessage());
            if (status == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String inputLine;
                content = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                return resultStatus(CHECK);
            }

            con.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    public boolean memberCheck(String TRANSACTION_ID, String PIN) {
        setAction(MEMBER_CHECK);
        Log.d(TAG, "IN SMSV2");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Map<String, String> params = new HashMap<>();
            params.put("tid", TRANSACTION_ID);
            params.put("pin", PIN);

            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(ParameterStringBuilder.getParamsString(params));

            dos.flush();
            dos.close();

            int status = con.getResponseCode();
            Log.d(TAG, "" + status + ", MSG: " + con.getResponseMessage());
            if (status == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String inputLine;
                content = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                return resultStatus(MEMBER_CHECK);
            }

            con.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }



    public boolean memberUnsub(String phone) {
        setAction(MEMBER_UNSUB);
        Log.d(TAG, "IN SMSV2");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Map<String, String> params = new HashMap<>();
            params.put("sid", WebServiceSid);
            params.put("mobile", phone);

            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(ParameterStringBuilder.getParamsString(params));

            dos.flush();
            dos.close();

            int status = con.getResponseCode();
            Log.d(TAG, "" + status + ", MSG: " + con.getResponseMessage());
            if (status == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String inputLine;
                content = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                return resultStatus(MEMBER_UNSUB);
            }

            con.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    public boolean memberStatus(String phone) {
        setAction(MEMBER_STATUS);
        Log.d(TAG, "IN SMSV2");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Map<String, String> params = new HashMap<>();
            params.put("sid", WebServiceSid);
            params.put("mobile", phone);

            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(ParameterStringBuilder.getParamsString(params));

            dos.flush();
            dos.close();

            int status = con.getResponseCode();
            Log.d(TAG, "" + status + ", MSG: " + con.getResponseMessage());
            if (status == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String inputLine;
                content = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                return resultStatus(MEMBER_STATUS);
            }

            con.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    public String memberGetMobileNumber(String TOKEN) {
        setAction(MEMBER_NUMBER);
        Log.d(TAG, "IN SMSV2");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Map<String, String> params = new HashMap<>();
            params.put("sid", WebServiceSid);
            params.put("mobile", TOKEN);

            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(ParameterStringBuilder.getParamsString(params));

            dos.flush();
            dos.close();

            int status = con.getResponseCode();
            Log.d(TAG, "" + status + ", MSG: " + con.getResponseMessage());
            if (status == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String inputLine;
                content = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                return resultStatus(MEMBER_NUMBER, true);
            }

            con.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "empty";
    }





    private void setAction(String action) {
        try {
            sendReq = new URL(SMS_SERVER_ADDRESS_V2 + action);
            con = (HttpURLConnection) sendReq.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "key=" + WebServiceCreds);

        } catch (MalformedURLException e) {
            Log.d(TAG, e.getMessage());
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean resultStatus(String METHOD) {
        Log.d(TAG, "resp " + METHOD + ", " + content.toString());
        String res = content.toString();
        int i = res.indexOf('.');
        String act = (i < 0 ) ? res : res.substring(0, i);
        String msg = (i < 0 ) ? res : res.substring(i+1,res.length()).replace(""+'.',"");

        switch (METHOD) {
            case "charge/check":
                if (act.toUpperCase().equals("SUCCESS")) {
                    return true;
                } else {
                    if (act.toUpperCase().equals("ERROR")) {
                        Log.e(TAG, METHOD + msg);
                    }
                    return false;
                }
            case "member/check":
                if (act.toUpperCase().equals("SUCCESS")) {
                    return true;
                } else {
                    if (act.toUpperCase().equals("ERROR")) {
                        Log.e(TAG, METHOD + msg);
                    }
                    return false;
                }

            case "member/unsub":
                Log.e(TAG, METHOD + msg);
                return true;
                // Oparetor return FAILED either way
            /*
                if (act.toUpperCase().equals("SUCCESS")) {
                    return true;
                } else {
                    Log.e(TAG, METHOD + msg);
                    return false;
                }
            */
            case "member/status":
                if (act.toUpperCase().equals("ON")) {
                    return true;
                } else {
                    Log.e(TAG, METHOD + act);
                    return false;
                }

        }
        return false;
    }

    private String resultStatus(String METHOD, boolean string) {
        Log.d(TAG, ">>> " + METHOD.toUpperCase() + ", " + content.toString());
        String res = content.toString();
        int i = res.indexOf('.');
        String act =  (i < 0 ) ? res : res.substring(0, i);
        String msg =  (i < 0 ) ? res : res.substring(i,res.length());

        switch (METHOD) {
            case "member/getMobileNumber":
                if (!act.toUpperCase().equals("ERROR")) {
                    return act;
                } else {
                    Log.e(TAG, METHOD + msg);
                    return "-1";
                }
            case "charge/push":
                if (act.toUpperCase().equals("SUCCESS")) {
                    return msg;
                } else {
                    Log.e(TAG, METHOD + msg);
                    return "-1";
                }
            case "member/sub":
                if (act.toUpperCase().equals("SUCCESS")) {
                    return res;
                } else {
                    Log.e(TAG, METHOD + msg);
                    return "-1";
                }
        }
        return "-1";
    }

}

